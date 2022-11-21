package userCase;

import java.awt.*;
import java.time.DayOfWeek;
import java.util.List;

public interface ProfileInputBoundary {

    public void createNewProfile(ProfileRequestModel requestModel);

    public void editName(ProfileRequestModel requestModel, String newValue);

    public void editSpecies(ProfileRequestModel requestModel,List<String> newValues);

    public void editBreed(ProfileRequestModel requestModel,List<String> newValues);

    public void editAge(ProfileRequestModel requestModel,List<Integer> newValues);

    public void editGender(ProfileRequestModel requestModel,String newValue);

    public void editDescription(ProfileRequestModel requestModel,String newValue);

    public void addImage(ProfileRequestModel requestModel, Image newImage);

    public void removeImage(ProfileRequestModel requestModel, Image imageToRemove);

    public void updateProofOfVaccination (ProfileRequestModel requestModel, Image proofOfVaccination);

    public void editLongitude (ProfileRequestModel requestModel, float newValue);

    public void editLatitude (ProfileRequestModel requestModel, float newValue);

    public void editAvailableDay (ProfileRequestModel requestModel, List<DayOfWeek> availableDay);

    public void editPreferredSpecies(ProfileRequestModel requestModel,List<String> newValues);

    public void editPreferredBreed(ProfileRequestModel requestModel,List<String> newValues);

    public void editPreferredAge(ProfileRequestModel requestModel,List<Integer> newValues);

    public void editPreferredGender(ProfileRequestModel requestModel,String newValue);

    public void editPreferredProximity(ProfileRequestModel requestModel, float newValue);





}

