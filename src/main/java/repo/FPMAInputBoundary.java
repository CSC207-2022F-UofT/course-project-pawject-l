package repo;
import useCase.FPMARequestModel;
import useCase.FPMAResponseModel;

import java.io.IOException;

public interface FPMAInputBoundary{
    /**
     * Creates list of potential matching candidates
     *
     * @param requestModel the pet entity resposible for calling the FPMA request
     * @return a list of pets to be judged by the user
     */
    FPMAResponseModel PotentialCandidates(FPMARequestModel requestModel) throws IOException;
}