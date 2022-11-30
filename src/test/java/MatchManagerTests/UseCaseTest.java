package MatchManagerTests;

import entities.Pet;
import entities.User;
import repo.PetDataAccess;
import useCase.MatchManager;
import useCase.MatchManagerRequestModel;
import repo.PetDataAccessInterface;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UseCaseTest {
    PetDataAccessInterface ds = new PetDataAccess();
    MatchManager mm = new MatchManager(ds);

    @Test
    public void matched() throws IOException {
        // p1 liked p2 $$ p2 liked p1 -> matched
        MatchManagerRequestModel rm = new MatchManagerRequestModel("PET ID:1", "PET ID:2", true);
        assertTrue(mm.manageMatch(rm));
    }

    @Test
    public void mismatched1() throws IOException {
        // p1 disliked p2 && p2 liked p1 -> not matched
        MatchManagerRequestModel rm = new MatchManagerRequestModel("PET ID:5", "PET ID:4", false);
        assertFalse(mm.manageMatch(rm));

    }

    @Test
    public void mismatched2() throws IOException {
        // p1 liked p2 && p2 haven't seen p1 yet -> not matched
        MatchManagerRequestModel rm = new MatchManagerRequestModel("PET ID:3", "PET ID:4", true);
        assertFalse(mm.manageMatch(rm));
    }

    @Test
    public void mismatched3() throws IOException {
        // p1 disliked p2 && p2 haven't seen p1 yet -> not matched
        MatchManagerRequestModel rm = new MatchManagerRequestModel("PET ID:4", "PET ID:3", false);
        assertFalse(mm.manageMatch(rm));
    }
}
