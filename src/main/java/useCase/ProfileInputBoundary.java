package useCase;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.time.DayOfWeek;
import java.util.List;

public interface ProfileInputBoundary {

    public void createNewProfile(ProfileRequestModel requestModel) throws IOException;

    public void editName(ProfileRequestModel requestModel, String newValue) throws IOException;

    public void editSpecies(ProfileRequestModel requestModel,List<String> newValues) throws IOException;

    public void editBreed(ProfileRequestModel requestModel,List<String> newValues) throws IOException;

    public void editAge(ProfileRequestModel requestModel,List<Integer> newValues) throws IOException;

    public void editGender(ProfileRequestModel requestModel,String newValue) throws IOException;

    public void editDescription(ProfileRequestModel requestModel,String newValue) throws IOException;

    public void addImage(ProfileRequestModel requestModel, BufferedImage newImage) throws IOException;

    public void removeImage(ProfileRequestModel requestModel, BufferedImage imageToRemove) throws IOException;

    public void updateProofOfVaccination (ProfileRequestModel requestModel, BufferedImage proofOfVaccination) throws IOException;

    public void editLongitude (ProfileRequestModel requestModel, float newValue) throws IOException;

    public void editLatitude (ProfileRequestModel requestModel, float newValue) throws IOException;

    public void editAvailableDay (ProfileRequestModel requestModel, List<DayOfWeek> availableDay) throws IOException;

    public void editPreferredSpecies(ProfileRequestModel requestModel,List<String> newValues) throws IOException;

    public void editPreferredBreed(ProfileRequestModel requestModel,List<String> newValues) throws IOException;

    public void editPreferredAge(ProfileRequestModel requestModel,List<Integer> newValues) throws IOException;

    public void editPreferredGender(ProfileRequestModel requestModel,String newValue) throws IOException;

    public void editPreferredProximity(ProfileRequestModel requestModel, float newValue) throws IOException;





}

