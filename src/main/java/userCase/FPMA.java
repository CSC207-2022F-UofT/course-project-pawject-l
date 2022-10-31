package userCase;
import entities.Pet;
import entities.Attributes;
import repo.FPMARequestModel;
import repo.PetDataRequestModel;
import java.util.Dictionary;
import java.util.Hashtable;

public class FPMA implements FPMARequestModel {
    public Pet[] PotentialCandidates(Pet userPet)
    {
        Dictionary potentialCandidateGrading = new Hashtable();
        Attributes userPetPreferredAttributes = userPet.getPreferred_attributes();
        Pet[] PossibleCandidates = getPossibleCandidates(userPet);
        for(Pet pet : PossibleCandidates)
        {
            Attributes candidatePetAttributes = pet.getAttributes();
            potentialCandidateGrading.put(pet, getGrade(userPetPreferredAttributes, candidatePetAttributes));
        }
    }
    public Pet[] getPossibleCandidates(Pet userPet)
    {
        Pet[] possibleCandidates = new Pet[20];
        Attributes userPetAttributes = userPet.getAttributes();
        float[] location = getLocation(userPetAttributes.getLatitude(), userPetAttributes.getLongitude());
        float preferredDistance = userPetAttributes.getPreferredProximity();
        int count = 0;
        while(count < 19)
        {
            Pet candidate = repo.PetDataRequestModel.getRandomPet();
            if(candidate.getDistance()) < preferredDistance
            {

            }
            count += 1;
        }

    }
    public float getGrade(Attributes userPetPreferredAttributes, Attributes candidatePetAttributes)
    {
        float prereq = 0;
        float satisficataion = 0;
        if(!userPetPreferredAttributes.getBreed().isEmpty())
        {
            prereq += 1;
            if(userPetPreferredAttributes.getBreed().contains(candidatePetAttributes.getBreed().get(0)))
            {
                satisficataion += 1;
            }
        }
        if(!userPetPreferredAttributes.getAge().isEmpty())
        {
            prereq += 1;
            if(userPetPreferredAttributes.getAge().contains(candidatePetAttributes.getAge().get(0)))
            {
                satisficataion += 1;
            }
        }
        if(userPetPreferredAttributes.getGender.isEmpty() == false)
        {
            prereq += 1;
            if(userPetPreferredAttributes.getGender == candidatePetAttributes.getGender)
            {
                satisficataion += 1;
            }
        }
        if(userPetPreferredAttributes.getVaccineStatus.isEmpty() == false)
        {
            prereq += 1;
            if(userPetPreferredAttributes.getVaccineStatus == candidatePetAttributes.getVaccineStatus)
            {
                satisficataion += 1;
            }
        }
        if(prereq == 0)
        {
            return 1;
        }
        else
        {
            return (prereq / satisficataion);
        }
    }
    public float[] getLocation(float latitude, float longitude)
    {
        float[] location = new float[2];
        location[0] = latitude;
        location[1] = longitude;
        return location;

    }
}
