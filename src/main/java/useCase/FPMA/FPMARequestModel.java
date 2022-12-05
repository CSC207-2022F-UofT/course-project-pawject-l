package useCase.FPMA;

public class FPMARequestModel {
    String petId;

    public FPMARequestModel(String petId) {
        this.petId = petId;
    }

    public String getPetId() {
        return petId;
    }
}
