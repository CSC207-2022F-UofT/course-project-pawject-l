package useCase;

import entities.Pet;
import repo.PetDataAccessInterface;

import java.io.IOException;

//use case layer

public class MatchManager implements MatchManagerInputBoundary {

    /**
     * A match manager is responsible for managing all the matches and mismatches that occur within the system.
     */

    PetDataAccessInterface PetDsGateway;

    public MatchManager(PetDataAccessInterface PetDsGateway) {
        this.PetDsGateway = PetDsGateway;
    }

    /**
     * Returns true iff the pet with pet id p1_id is matched with the pet with pet id p2_id. The match occurs iff the
     * owners of both pets liked each other's pets.
     *
     * @param requestModel
     * @return true iff the match has occurred
     */

    @Override
    public boolean manageMatch(MatchManagerRequestModel requestModel) throws IOException {

        Pet p1 = PetDsGateway.getPetById(requestModel.getP1_id()); // own pet
        Pet p2 = PetDsGateway.getPetById(requestModel.getP2_id()); // other pet

        if (requestModel.isP1_owner_decision()) {
            if (p2.getLikes().contains(p1.getPetID())) {
                p1.addMatches(p2.getPetID());
                p2.addMatches(p1.getPetID());
                return true;
            }
             // at this point p2 hasn't interacted with p1 yet
        } else {
            p1.addDislikes(p2.getPetID());
        }
        return false;
    }
}
