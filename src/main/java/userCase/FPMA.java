package userCase;

import entities.Pet;
import entities.Attributes;
import repo.FPMARequestModel;

import java.util.HashMap;
import java.util.TreeMap;
import java.util.Map;
import java.lang.Math;

public class FPMA implements FPMARequestModel {
    public static Pet[] PotentialCandidates(Pet userPet) {
        HashMap<Float, Pet> potentialCandidateGrading = new HashMap<Float, Pet>();
        Attributes userPetPreferredAttributes = userPet.getPreferred_attributes();
        Pet[] PossibleCandidates = getPossibleCandidates(userPet);
        for (Pet pet : PossibleCandidates) {
            Attributes candidatePetAttributes = pet.getAttributes();
            potentialCandidateGrading.put(getGrade(userPetPreferredAttributes, candidatePetAttributes), pet);
        }
        return sortedHashmap(potentialCandidateGrading);
    }

    public static Pet[] getPossibleCandidates(Pet userPet) {
        Pet[] possibleCandidates = new Pet[20];
        Attributes userPetAttributes = userPet.getAttributes();
        Attributes userPetPreferredAttributes = userPet.getPreferred_attributes();
        float[] location = getLocation(userPetAttributes.getLatitude(), userPetAttributes.getLongitude());
        float preferredDistance = userPetAttributes.getPreferred_proximity();
        int count = 0;
        while (count < 19) {
            Pet candidate = repo.PetDataRequestModel.getRandomPet();
            Attributes candidatePetAttributes = candidate.getAttributes();
            if (getDistance(getLocation(candidatePetAttributes.getLatitude(), candidatePetAttributes.getLongitude()), location) < preferredDistance) {
                if (userPetPreferredAttributes.isVaccinated()) {
                    if (userPetPreferredAttributes.isVaccinated() == candidatePetAttributes.isVaccinated()) {
                        if (!userPetPreferredAttributes.getSpecies().isEmpty()) {
                            if (userPetPreferredAttributes.getSpecies().contains(candidatePetAttributes.getBreed().get(0))) {
                                possibleCandidates[count] = candidate;
                                count += 1;
                            }
                        } else {
                            possibleCandidates[count] = candidate;
                            count += 1;
                        }
                    }
                } else {
                    if (!userPetPreferredAttributes.getSpecies().isEmpty()) {
                        if (userPetPreferredAttributes.getSpecies().contains(candidatePetAttributes.getBreed().get(0))) {
                            possibleCandidates[count] = candidate;
                            count += 1;
                        }
                    } else {
                        possibleCandidates[count] = candidate;
                        count += 1;
                    }
                }
            }
        }
        return possibleCandidates;

    }

    public static float getGrade(Attributes userPetPreferredAttributes, Attributes candidatePetAttributes) {
        float prereq = 0;
        float satisficataion = 0;
        if (!userPetPreferredAttributes.getBreed().isEmpty()) {
            prereq += 1;
            if (userPetPreferredAttributes.getBreed().contains(candidatePetAttributes.getBreed().get(0))) {
                satisficataion += 1;
            }
        }
        if (!userPetPreferredAttributes.getAge().isEmpty()) {
            prereq += 1;
            if (userPetPreferredAttributes.getAge().contains(candidatePetAttributes.getAge().get(0))) {
                satisficataion += 1;
            }
        }
        if (!userPetPreferredAttributes.getGender().equals("N/A")) {
            prereq += 1;
            if (userPetPreferredAttributes.getGender().equals(candidatePetAttributes.getGender())) {
                satisficataion += 1;
            }
        }
        if (prereq == 0) {
            return 1;
        } else {
            return (prereq / satisficataion);
        }
    }

    public static float[] getLocation(float latitude, float longitude) {
        float[] location = new float[2];
        location[0] = latitude;
        location[1] = longitude;
        return location;

    }

    public static float getDistance(float[] userLocation, float[] candidateLocation) {
        return ((float) Math.acos(Math.sin(userLocation[0]) * Math.sin(candidateLocation[0]) + Math.cos(userLocation[0])
                * Math.cos(candidateLocation[0]) * Math.cos(userLocation[1] - candidateLocation[1])) * 6371);
    }
    public static Pet[] sortedHashmap(HashMap<Float, Pet> PotentialCandidates) {
        Pet[] sortedPets = new Pet[20];

        TreeMap<Float, Pet> sortedMap = new TreeMap<>(PotentialCandidates);

        int count = 0;
        for (Map.Entry<Float, Pet> entry : sortedMap.entrySet()){
            sortedPets[count] = entry.getValue();
            count += 1;
        }
        return sortedPets;
    }
}
