package useCase;
import entities.Pet;
import entities.Attributes;
import repo.ProfileRequestModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
public class ProfileRequest implements ProfileRequestModel{

    public void setProfile (){

    }

    public List<Object> getPetAllInfo (Pet userPet){
        List<Object> petInfo = new ArrayList<>();
         /* All pet profile information in order: name, breed, age, gender, description, image, vaccineStatus,
          longitude, latitude, availableDay, preferredBreed, preferredAge, preferredGender, preferredProximity]*/

        petInfo.add(userPet.getName());
        petInfo.add(userPet.getAttributes().get(0));
        petInfo.add(userPet.getAttributes().get(1));
        petInfo.add(userPet.getAttributes().get(3));
        petInfo.add(userPet.getDescription());
        petInfo.add(userPet.getImage());
        petInfo.add(userPet.getAttributes().get(4));
        petInfo.add(userPet.getAttributes().get(5));
        petInfo.add(userPet.getAttributes().get(6));
        petInfo.add(userPet.getAttributes().get(7));
        petInfo.add(userPet.getPreferred_attributes().get(0));
        petInfo.add(userPet.getPreferred_attributes().get(1));
        petInfo.add(userPet.getPreferred_attributes().get(2));

        return petInfo;
    }

    public HashMap<Object, List<Object>> getPetFullProfile(Pet userPet){

        HashMap<Object, List<Object>> petProfile = new HashMap<>();
        petProfile.put(userPet, getPetAllInfo(userPet));

        return petProfile;
    }

    public HashMap<Object, List<Object>> getPetProfilePreview(Pet userPet){

        HashMap<Object, List<Object>> petProfile = new HashMap<>();
        petProfile.put(userPet, getPetAllInfo(userPet).subList(0,5));

        return petProfile;
    }


}
