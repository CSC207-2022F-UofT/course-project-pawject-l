package userCase;
import entities.Pet;
import entities.Attributes;
import org.w3c.dom.Attr;
import repo.FPMARequestModel;

import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class FPMA implements FPMARequestModel {
    public Pet[] PotentialCandidates(Pet userPet)
    {
        Dictionary potentialCandidateGrading = new Hashtable();
        Attributes userPetAttributes = userPet.getAttributes();
        Pet[] PossibleCandidates = getPossibleCandidates(userPet);
        for(Pet pet : PossibleCandidates)
        {
            Attributes candidatePetAttributes = pet.getAttributes();
            potentialCandidateGrading.put(pet, getGrade(userPetAttributes, candidatePetAttributes));
        }
    }
    public Pet[] getPossibleCandidates(Pet userPet)
    {
        Attributes userPetAttributes = userPet.getAttributes();
        int[] location = userPetAttributes.getLocation();
        int preferredDistance = userPetAttributes.getPreferredDistance();


    }
    public float getGrade(Attributes userPetAttributes, Attributes candidatePetAttributes)
    {

    }
}
