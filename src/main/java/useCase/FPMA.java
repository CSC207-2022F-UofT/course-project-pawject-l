package useCase;

import entities.Pet;
import entities.Attributes;
import repo.FPMARequestModel;
import repo.PetDataAccessInterface;

import java.io.IOException;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.Map;
import java.lang.Math;

public class FPMA implements FPMARequestModel {
    private PetDataAccessInterface PDAI;
    /**
     * Initialize PetDataAcessInterface
     *
     * @param pdai PetDatAcessInterface
     */
    public FPMA(PetDataAccessInterface pdai) {
        PDAI = pdai;
    }

    /**
     * Get Potential Matching Candidates
     *
     * @param userPet Pet user has logged in at time of method call
     * @return Pet array of potential match candidates sorted by preference saturation.
     */
    public Pet[] PotentialCandidates(Pet userPet) throws IOException {
        HashMap<Float, Pet> potentialCandidateGrading = new HashMap<Float, Pet>(); // Initializes new HashMap with Floats as keys and Pets as values
        Attributes userPetPreferredAttributes = userPet.getPreferredAttributes(); // Initializes Attributes object containing attributes of userPet
        Pet[] PossibleCandidates = getPossibleCandidates(userPet); // Initializes Pet array and calls getPossibleCandidates method
        for (Pet pet : PossibleCandidates) { // Loops through Pet array with goal to grade each candidate
            Attributes candidatePetAttributes = pet.getAttributes(); // Initializes Attributes object containing attributes of
            potentialCandidateGrading.put(getGrade(userPetPreferredAttributes, candidatePetAttributes), pet); //Assigns grade to candidate pet based on how its attributes satisfy userPet
        }
        return sortedHashmap(potentialCandidateGrading); //Returns list of pets ordered by grade
    }

    /**
     * Get Potential Grading Candidates
     *
     * @param userPet Pet user has logged in at time of method call
     * @return Pet array of potential candidates for grading
     */
    public Pet[] getPossibleCandidates(Pet userPet) throws IOException {
        Pet[] possibleCandidates = new Pet[20]; //Initializes list as well as limits the maximum number of candidates
        Attributes userPetAttributes = userPet.getAttributes(); //Initializes attributes object containing the attributes of the user
        Attributes userPetPreferredAttributes = userPet.getPreferredAttributes(); //Initializes attributes object containing the preferences of the user
        float[] location = getLocation(userPet.getLatitude(), userPet.getLongitude()); //Initializes float list containing the coordinates of the user
        float preferredDistance = userPet.getPreferredProximity(); //Initializes float object containing the preferred proximity of the user
        int count = 0; //Initializes arbitrary count integer
        while (count < 19) {
            Pet candidate = PDAI.getRandomPet(); //Initializes Pet object containing a possible candidate
            Attributes candidatePetAttributes = candidate.getAttributes();//Initializes Attributes object containing the attributes of candidate
            if (!userPet.getDislikes().contains(candidate)) { //Checks if user has already disliked candidate
                if (!userPet.getLikes().contains(candidate)) { //Checks if user has already liked candidate
                    if (!candidate.getDislikes().contains(userPet)) { //Checks if candidate already disliked user
                        if (getDistance(getLocation(candidate.getLatitude(), candidate.getLongitude()), location) < preferredDistance) { //Checks if candidates location satisfies users preferred proximity
                            if (userPetPreferredAttributes.isVaccinated()) { //Checks if user prefers vaccinated pets
                                if (userPetPreferredAttributes.isVaccinated() == candidatePetAttributes.isVaccinated()) { //Checks if candidate is vaccinated
                                    if (!userPetPreferredAttributes.getSpecies().isEmpty()) { //Checks if user has preferred species
                                        if (userPetPreferredAttributes.getSpecies().contains(candidatePetAttributes.getBreed().get(0))) { //Checks if candidate's species satisfies preference
                                            possibleCandidates[count] = candidate; //Candidate is added to list to be graded
                                            count += 1; //Count variable increased
                                        }
                                    } else {
                                        possibleCandidates[count] = candidate; //Candidate is added to list to be graded
                                        count += 1; //Count variable increased
                                    }
                                }
                            } else {
                                if (!userPetPreferredAttributes.getSpecies().isEmpty()) {//Checks if user has preferred species
                                    if (userPetPreferredAttributes.getSpecies().contains(candidatePetAttributes.getBreed().get(0))) {//Checks if candidate's species satisfies preference
                                        possibleCandidates[count] = candidate; //Candidate is added to list to be graded
                                        count += 1; //Count variable increased
                                    }
                                } else {
                                    possibleCandidates[count] = candidate; //Candidate is added to list to be graded
                                    count += 1; //Count variable increased
                                }
                            }
                        }
                    }
                }
            }
        }
        return possibleCandidates; //Returns list of candidates for grading

    }

    /**
     * Get Potential Grading Candidates
     *
     * @param userPetPreferredAttributes, Corresponding preferences to Pet user has logged in at time of method call
     * @param candidatePetAttributes      Corresponding attributes of given candidate pet
     * @return Pet array of potential candidates for grading
     */
    public float getGrade(Attributes userPetPreferredAttributes, Attributes candidatePetAttributes) {
        float prereq = 0; //Initializes float object that will count number of preferences needed to be satisfied
        float satisficataion = 0; //Initalizes float object that will count number of preferences candidate pet satisfies
        if (!userPetPreferredAttributes.getBreed().isEmpty()) { //Checks if userPet has preferred breed(s)
            prereq += 1; //Increases float object
            if (userPetPreferredAttributes.getBreed().contains(candidatePetAttributes.getBreed().get(0))) { //Checks if candidate satisfies breed preferences
                satisficataion += 1; //Increases float object
            }
        }
        if (!userPetPreferredAttributes.getAge().isEmpty()) { //Checks if userPet has preferred ages
            prereq += 1; //Increases float object
            if (userPetPreferredAttributes.getAge().contains(candidatePetAttributes.getAge().get(0))) { //Checks if candidate satisfies age preferences
                satisficataion += 1;//Increases float object
            }
        }
        if (!userPetPreferredAttributes.getGender().equals("N/A")) { //Checks if userPet has preferred gender
            prereq += 1; //Increases float object
            if (userPetPreferredAttributes.getGender().equals(candidatePetAttributes.getGender())) { //Checks if candidate satisfies gender preference
                satisficataion += 1;//Increases float object
            }
        }
        if (prereq == 0) { //If no preferences found automatically apply perfect grade
            return 1; //Returns perfect grade 1/1
        } else {
            return (prereq / satisficataion); //Returns the grade based on preference saturation
        }
    }

    /**
     * Get Float list containing Pet coordinates
     *
     * @param latitude, pets latitude
     * @param longitude pet longitude
     * @return Float list containing pet's coordinates
     */
    public float[] getLocation(float latitude, float longitude) {
        float[] location = new float[2]; //Initializes float list
        location[0] = latitude; //Sets latitude
        location[1] = longitude; //Sets longitude
        return location; //Returns float list

    }

    /**
     * Get Distance between two coordinates
     *
     * @param userLocation,     userPet's latitude/longitude
     * @param candidateLocation candidate pet's latitude/longitude
     * @return Calculated distance between two coordinates
     */
    public float getDistance(float[] userLocation, float[] candidateLocation) {
        return ((float) Math.acos(Math.sin(userLocation[0]) * Math.sin(candidateLocation[0]) + Math.cos(userLocation[0])
                * Math.cos(candidateLocation[0]) * Math.cos(userLocation[1] - candidateLocation[1])) * 6371); //Returns calculated distance between two points using adapted version of the Haversine formula
    }

    /**
     * Sorts hashmap into ordered list
     *
     * @param PotentialCandidates, Hashmap containing potential candidates and their calculated grades
     * @return Sorted list based on grade
     */
    public Pet[] sortedHashmap(HashMap<Float, Pet> PotentialCandidates) {
        Pet[] sortedPets = new Pet[20]; //Initializes list of pets

        TreeMap<Float, Pet> sortedMap = new TreeMap<>(PotentialCandidates); //Uses TreeMap object to sort pets based on their grades

        int count = 0; //Initalizes count object
        for (Map.Entry<Float, Pet> entry : sortedMap.entrySet()) { //Loop starts
            sortedPets[count] = entry.getValue(); //Inserts taken value from TreeMap into its corresponding index in sortedPets
            count += 1; //Increases count object
        }
        return sortedPets; //Returns list of pets
    }
}