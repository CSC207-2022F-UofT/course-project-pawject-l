package controller;
import userCase.ProfileInputBoundary;
import userCase.ProfileRequestModel;

import java.awt.*;
import java.time.DayOfWeek;
import java.util.List;


public class ProfileController {

    ProfileInputBoundary profileInput;

    public ProfileController(ProfileInputBoundary profileInput) {
        this.profileInput = profileInput;
    }

    public void performProfileCreation(ProfileRequestModel requestModel) {
        this.profileInput.createNewProfile(requestModel);
    }

    public void editName (ProfileRequestModel requestModel, String newValue) {
        this.profileInput.editName(requestModel, newValue);
    }

    public void editSpecies(ProfileRequestModel requestModel, List<String> newValues) {
        this.profileInput.editSpecies(requestModel, newValues);
    }

    public void editBreed (ProfileRequestModel requestModel, List<String> newValues) {
        this.profileInput.editBreed(requestModel, newValues);
    }

    public void editAge(ProfileRequestModel requestModel,List<Integer> newValues){
        this.profileInput.editAge(requestModel, newValues);
    }

    public void editGender(ProfileRequestModel requestModel,String newValue){
        this.profileInput.editGender(requestModel, newValue);
    }

    public void editDescription(ProfileRequestModel requestModel,String newValue){
        this.profileInput.editDescription(requestModel, newValue);
    }

    public void addImage(ProfileRequestModel requestModel, Image newImage){
        this.profileInput.addImage(requestModel, newImage);
    }

    public void removeImage(ProfileRequestModel requestModel, Image imageToRemove){
        this.profileInput.removeImage(requestModel, imageToRemove);
    }

    public void updateProofOfVaccination (ProfileRequestModel requestModel, Image proofOfVaccination){
        this.profileInput.updateProofOfVaccination(requestModel, proofOfVaccination);
    }

    public void editLongitude (ProfileRequestModel requestModel, float newValue){
        this.profileInput.editLongitude(requestModel, newValue);
    }

    public void editLatitude (ProfileRequestModel requestModel, float newValue){
        this.profileInput.editLatitude(requestModel, newValue);
    }

    public void editAvailableDay (ProfileRequestModel requestModel, List<DayOfWeek> availableDay){
        this.profileInput.editAvailableDay(requestModel, availableDay);
    }

    public void editPreferredSpecies(ProfileRequestModel requestModel, List<String> newValues) {
        this.profileInput.editPreferredSpecies(requestModel, newValues);
    }

    public void editPreferredBreeds (ProfileRequestModel requestModel, List<String> newValues) {
        this.profileInput.editPreferredBreed(requestModel, newValues);
    }

    public void editPreferredAge(ProfileRequestModel requestModel,List<Integer> newValues){
        this.profileInput.editPreferredAge(requestModel, newValues);
    }

    public void editPreferredGender(ProfileRequestModel requestModel,String newValue){
        this.profileInput.editPreferredGender(requestModel, newValue);
    }

    public void editPreferredProximity(ProfileRequestModel requestModel, float newValue){
        this.profileInput.editPreferredProximity(requestModel, newValue);
    }
}
