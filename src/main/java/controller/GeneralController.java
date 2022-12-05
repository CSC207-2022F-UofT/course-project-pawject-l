package controller;
import repo.FPMAInputBoundary;
import useCase.FPMARequestModel;
import entities.Pet;
import useCase.FPMAResponseModel;

import java.io.IOException;

public class GeneralController {
    FPMAInputBoundary FPMA;

    public GeneralController(FPMAInputBoundary fpma) {this.FPMA = fpma;

    }

    public FPMAResponseModel getPotentialCandidates(String petId) throws IOException {
        FPMARequestModel requestModel = new FPMARequestModel(petId);
        return this.FPMA.PotentialCandidates(requestModel);
    }
}
