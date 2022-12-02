package FPMATests;

import entities.Pet;
import org.junit.Test;
import repo.FPMARequestModel;
import repo.PetDataAccess;
import repo.PetDataAccessInterface;
import useCase.FPMA;

import java.io.IOException;

public class UseCaseTest {
    PetDataAccessInterface ds = new PetDataAccess();
    FPMA fpma = new FPMA(ds);

    @Test
    public void getPossibleCandidates() throws IOException {
        Pet userPet = ds.getRandomPet();
    }
}
