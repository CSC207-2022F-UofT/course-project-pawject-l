package repo;
import entities.Pet;
import useCase.FPMA;
import useCase.FPMARequestModel;

import java.io.IOException;
import java.util.ArrayList;

public interface FPMAInputBoundary{
    /**
     * Creates list of potential matching candidates
     * @param userPet the pet entity resposible for calling the FPMA request
     * @return a list of pets to be judged by the user
     */
    Pet[] PotentialCandidates(FPMARequestModel requestModel) throws IOException;
}