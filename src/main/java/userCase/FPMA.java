package userCase;
import entities.Pet;
import entities.Attributes;
import repo.FPMARequestModel;
import java.util.List;

public class FPMA implements FPMARequestModel {
    public Pet[] PotentialCandidates(Pet userPet)
    {
        Attributes userPetAttributes = userPet.getAttributes();
        Pet[] PossibleCandidates = getPossibleCandidates(userPet);
        for(Pet pet : PossibleCandidates)
        {
            Attributes candidatePetAttributes = pet.getAttributes();

        }
    }
    public Pet[] getPossibleCandidates(Pet userPet)
    {
        Attributes userPetAttributes = userPet.getAttributes();
        int[] location = userPetAttributes.getLocation();
        int preferredDistance = userPetAttributes.getPreferredDistance();


    }

}
