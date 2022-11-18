package repo;
import entities.Chat;
import entities.Pet;
import useCase.FPMA;

import java.util.ArrayList;

public interface FPMARequestModel{
    /**
     * Creates list of potential matching candidates
     * @param userPet the pet entity resposible for calling the FPMA request
     * @return a list of pets to be judged by the user
     */
    Pet[] PotentialCandidates(Pet userPet);
}