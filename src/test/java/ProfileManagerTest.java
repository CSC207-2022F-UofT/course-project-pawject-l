import useCase.MatchManager;

import repo.PetDataAccessInterface;
import repo.PetDataAccess;

import org.junit.jupiter.api.Test;
import useCase.ProfileManager;

public class ProfileManagerTest {
    PetDataAccessInterface ds = new PetDataAccess();
    ProfileManager pm = new ProfileManager(ds);

    @Test
    public void ProfileManagerTest() {


    }





}
