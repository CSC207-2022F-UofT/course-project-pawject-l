package controller;
import useCase.Profile.ProfileInputBoundary;
import useCase.Profile.ProfileRequestModel;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.time.DayOfWeek;
import java.util.List;


public class ProfileController {

    ProfileInputBoundary profileInput;

    public ProfileController(ProfileInputBoundary profileInput) {
        this.profileInput = profileInput;
    }

    public void performProfileCreation(ProfileRequestModel requestModel) throws IOException {
        this.profileInput.createNewProfile(requestModel);
    }

    public void editName (ProfileRequestModel requestModel, String newValue) throws IOException {
        this.profileInput.editName(requestModel, newValue);
    }

    public void editSpecies(ProfileRequestModel requestModel, List<String> newValues) throws IOException {
        this.profileInput.editSpecies(requestModel, newValues);
    }

    public void editBreed (ProfileRequestModel requestModel, List<String> newValues) throws IOException {
        this.profileInput.editBreed(requestModel, newValues);
    }

    public void editAge(ProfileRequestModel requestModel,List<Integer> newValues) throws IOException {
        this.profileInput.editAge(requestModel, newValues);
    }

    public void editGender(ProfileRequestModel requestModel,String newValue) throws IOException {
        this.profileInput.editGender(requestModel, newValue);
    }

    public void editDescription(ProfileRequestModel requestModel,String newValue) throws IOException {
        this.profileInput.editDescription(requestModel, newValue);
    }

    public void addImage(ProfileRequestModel requestModel, BufferedImage newImage) throws IOException {
        this.profileInput.addImage(requestModel, newImage);
    }

    public void removeImage(ProfileRequestModel requestModel, BufferedImage imageToRemove) throws IOException {
        this.profileInput.removeImage(requestModel, imageToRemove);
    }

    public void updateProofOfVaccination (ProfileRequestModel requestModel, BufferedImage proofOfVaccination) throws IOException {
        this.profileInput.updateProofOfVaccination(requestModel, proofOfVaccination);
    }

    public void editLongitude (ProfileRequestModel requestModel, float newValue) throws IOException {
        this.profileInput.editLongitude(requestModel, newValue);
    }

    public void editLatitude (ProfileRequestModel requestModel, float newValue) throws IOException {
        this.profileInput.editLatitude(requestModel, newValue);
    }

    public void editAvailableDay (ProfileRequestModel requestModel, List<DayOfWeek> availableDay) throws IOException {
        this.profileInput.editAvailableDay(requestModel, availableDay);
    }

    public void editPreferredSpecies(ProfileRequestModel requestModel, List<String> newValues) throws IOException {
        this.profileInput.editPreferredSpecies(requestModel, newValues);
    }

    public void editPreferredBreeds (ProfileRequestModel requestModel, List<String> newValues) throws IOException {
        this.profileInput.editPreferredBreed(requestModel, newValues);
    }

    public void editPreferredAge(ProfileRequestModel requestModel,List<Integer> newValues) throws IOException {
        this.profileInput.editPreferredAge(requestModel, newValues);
    }

    public void editPreferredGender(ProfileRequestModel requestModel,String newValue) throws IOException {
        this.profileInput.editPreferredGender(requestModel, newValue);
    }

    public void editPreferredProximity(ProfileRequestModel requestModel, float newValue) throws IOException {
        this.profileInput.editPreferredProximity(requestModel, newValue);
    }
}
