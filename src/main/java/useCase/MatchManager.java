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
                p2.removeLikes(p1.getPetID());
                PetDsGateway.savePet(p1);
                PetDsGateway.savePet(p2);
                return true;
            }
            else {
                // at this point p2 hasn't interacted with p1 yet
                p1.addLikes(p2.getPetID());
                PetDsGateway.savePet(p1);
            }
        } else {
            p1.addDislikes(p2.getPetID());
            PetDsGateway.savePet(p1);
            if (p2.getLikes().contains(p1.getPetID())) {
                p2.getLikes().remove(p1.getPetID());
                p2.addDislikes(p1.getPetID());
                PetDsGateway.savePet(p2);
            }
            // at this point p2 hasn't interacted with p1 yet, but they'll never show up at each other's list of potential
            // candidates as one of them has disliked the other
        }
        return false;
    }
}