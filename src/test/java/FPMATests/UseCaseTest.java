package FPMATests;

import entities.Pet;
import org.junit.Test;
import useCase.FPMARequestModel;
import repo.PetDataAccess;
import repo.PetDataAccessInterface;
import useCase.FPMA;
import useCase.FPMAResponseModel;

import java.io.IOException;

public class UseCaseTest {
    PetDataAccessInterface ds = new PetDataAccess();
    FPMA fpma = new FPMA(ds);

    @Test
    public void getPossibleCandidates() throws IOException {
        Pet userPet = ds.getRandomPet();
        FPMARequestModel FRM = new FPMARequestModel(userPet.getPetID());
        System.out.println(userPet.getPetID());
        FPMAResponseModel PC = fpma.PotentialCandidates(FRM);
        assert true;
    }
}
