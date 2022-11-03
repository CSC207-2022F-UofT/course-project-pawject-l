package repo;
import entities.Pet;
import userCase.FPMA;

public interface FPMARequestModel {
    default Pet[] Potential_Candidates(Pet userPet)
    {
        return FPMA.PotentialCandidates(userPet);
    }
}
