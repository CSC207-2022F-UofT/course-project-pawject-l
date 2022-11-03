package userCase;
import entities.Pet;
import entities.Attributes;
import userCase.ProfileRequestModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
public class ProfileRequest {

    public List<Object> getPetAllInfo(Pet userPet) {
        List<Object> petInfo = new ArrayList<>();
         /* All pet profile information in order: name, breed, age, gender, description, image, vaccineStatus,
          longitude, latitude, availableDay, preferredBreed, preferredAge, preferredGender, preferredProximity]*/

        petInfo.add(userPet.getName());
        petInfo.add(userPet.getAttributes().getBreed());
        petInfo.add(userPet.getAttributes().getAge());
        petInfo.add(userPet.getAttributes().getGender());
        petInfo.add(userPet.getDescription());
        petInfo.add(userPet.getImage());
        petInfo.add(userPet.getAttributes().isVaccinated());
        petInfo.add(userPet.getAttributes().getLongitude());
        petInfo.add(userPet.getAttributes().getLatitude());
        petInfo.add(userPet.getAttributes().getAvailableDay());
        petInfo.add(userPet.getPreferred_attributes().getBreed());
        petInfo.add(userPet.getPreferred_attributes().getGender());
        petInfo.add(userPet.getPreferred_attributes().getPreferred_proximity());

        return petInfo;
    }

    public HashMap<Object, List<Object>> getPetFullProfile(Pet userPet) {

        HashMap<Object, List<Object>> petProfile = new HashMap<>();
        petProfile.put(userPet, getPetAllInfo(userPet));

        return petProfile;
    }

    public HashMap<Object, List<Object>> getPetProfilePreview(Pet userPet) {

        HashMap<Object, List<Object>> petProfile = new HashMap<>();
        petProfile.put(userPet, getPetAllInfo(userPet).subList(0, 5));

        return petProfile;
    }
}