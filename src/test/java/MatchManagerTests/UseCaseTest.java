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
        // p1_owner liked p2 $$ p2_owner liked p1 -> matched
        MatchManagerRequestModel rm = new MatchManagerRequestModel("2", "1", true);
        assertTrue(mm.manageMatch(rm));
    }

    @Test
    public void mismatched1() throws IOException {
        // p1_owner disliked p2 -> not matched (if p1_owner or p2_owner dislikes then match doesn't occur)
    }

    @Test
    public void mismatched2() throws IOException {
        // p1_owner liked p2 && p2_owner haven't seen p1 yet -> not matched
    }
}
