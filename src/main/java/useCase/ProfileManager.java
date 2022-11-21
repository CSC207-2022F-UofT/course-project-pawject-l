package useCase;
import entities.Pet;
import entities.Attributes;
import repo.PetDataAccessInterface;


import java.awt.*;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ProfileManager implements ProfileInputBoundary{

    PetDataAccessInterface petDsGateway;

    public ProfileManager(PetDataAccessInterface petDsGateway){
        this.petDsGateway = petDsGateway;
    }



    /**
     * Create a new pet and save all the information into the Pet database.
     */
    public void createNewProfile(ProfileRequestModel requestModel){
        Attributes attributes = new Attributes(requestModel.getSpecies(), requestModel.getBreed(), requestModel.getAge(), requestModel.getGender(), true);
        Attributes preferredAttributes = new Attributes(requestModel.getPreferredSpecies(), requestModel.getPreferredBreed(),
                requestModel.getPreferredAge(), requestModel.getPreferredGender(), requestModel.getPreferredVaccineStatus());
        Pet newPet = new Pet(requestModel.getName(), requestModel.getPetId(), requestModel.getDescription(),attributes, preferredAttributes,
                requestModel.getImages(), requestModel.getProofOfVaccination(), requestModel.getLongitude(), requestModel.getLatitude(),
                requestModel.getPreferredProximity(), requestModel.getAvailableDay());
        petDsGateway.savePet(newPet);
    }

    public void editName(ProfileRequestModel requestModel, String newValue){
        Pet pet = petDsGateway.getPetById(requestModel.getPetId());
        pet.setName(newValue);
    }

    public void editSpecies(ProfileRequestModel requestModel, List<String> newValues){
        Pet pet = petDsGateway.getPetById(requestModel.getPetId());
        pet.getAttributes().setSpecies(newValues);
    }

    public void editBreed(ProfileRequestModel requestModel,List<String> newValues){
        Pet pet = petDsGateway.getPetById(requestModel.getPetId());
        pet.getAttributes().setBreed(newValues);
    }

    public void editAge(ProfileRequestModel requestModel,List<Integer> newValues){
        Pet pet = petDsGateway.getPetById(requestModel.getPetId());
        pet.getAttributes().setAge(newValues);
    }

    public void editGender(ProfileRequestModel requestModel,String newValue){
        Pet pet = petDsGateway.getPetById(requestModel.getPetId());
        pet.getAttributes().setGender(newValue);
    }

    public void editDescription(ProfileRequestModel requestModel,String newValue){
        Pet pet = petDsGateway.getPetById(requestModel.getPetId());
        pet.setDescription(newValue);
    }

    public void addImage(ProfileRequestModel requestModel, Image newImage){
        Pet pet = petDsGateway.getPetById(requestModel.getPetId());
        pet.getImages().add(newImage);
    }

    public void removeImage(ProfileRequestModel requestModel, Image imageToRemove){
        Pet pet = petDsGateway.getPetById(requestModel.getPetId());
        pet.getImages().remove(imageToRemove);
    }

    public void updateProofOfVaccination (ProfileRequestModel requestModel, Image proofOfVaccination){
        Pet pet = petDsGateway.getPetById(requestModel.getPetId());
        pet.setProofOfVaccination(proofOfVaccination);
        pet.getAttributes().setVaccineStatus(true);
    }

    public void editLongitude (ProfileRequestModel requestModel, float newValue){
        Pet pet = petDsGateway.getPetById(requestModel.getPetId());
        pet.setLongitude(newValue);
    }

    public void editLatitude (ProfileRequestModel requestModel, float newValue){
        Pet pet = petDsGateway.getPetById(requestModel.getPetId());
        pet.setLatitude(newValue);
    }

    public void editAvailableDay (ProfileRequestModel requestModel, List<DayOfWeek> availableDay){
        Pet pet = petDsGateway.getPetById(requestModel.getPetId());
        pet.setAvailableDay(availableDay);
    }

    public void editPreferredSpecies(ProfileRequestModel requestModel,List<String> newValues){
        Pet pet = petDsGateway.getPetById(requestModel.getPetId());
        pet.getPreferredAttributes().setSpecies(newValues);
    }

    public void editPreferredBreed(ProfileRequestModel requestModel,List<String> newValues){
        Pet pet = petDsGateway.getPetById(requestModel.getPetId());
        pet.getPreferredAttributes().setBreed(newValues);
    }

    public void editPreferredAge(ProfileRequestModel requestModel,List<Integer> newValues){
        Pet pet = petDsGateway.getPetById(requestModel.getPetId());
        pet.getPreferredAttributes().setAge(newValues);
    }

    public void editPreferredGender(ProfileRequestModel requestModel,String newValue){
        Pet pet = petDsGateway.getPetById(requestModel.getPetId());
        pet.getPreferredAttributes().setGender(newValue);
    }

    public void editPreferredProximity(ProfileRequestModel requestModel, float newValue){
        Pet pet = petDsGateway.getPetById(requestModel.getPetId());
        pet.setPreferredProximity(newValue);
    }

    /**
     *
     * @param petID
     * @return all profile information of a pet.
     */
    public List<Object> getProfileAllInfo(String petID) {
        Pet userPet = petDsGateway.getPetById(petID);
        List<Object> petInfo = new ArrayList<>();
         /* All pet profile information in order: name, species, breed, age, gender, description, images, proofOfVaccination, vaccineStatus,
          longitude, latitude, availableDay, preferredSpecies, preferredBreed, preferredAge, preferredGender, preferredProximity]*/

        petInfo.add(userPet.getName());
        petInfo.add(userPet.getAttributes().getSpecies());
        petInfo.add(userPet.getAttributes().getBreed());
        petInfo.add(userPet.getAttributes().getAge());
        petInfo.add(userPet.getAttributes().getGender());
        petInfo.add(userPet.getDescription());
        petInfo.add(userPet.getImages());
        petInfo.add(userPet.getProofOfVaccination());
        petInfo.add(userPet.getAttributes().isVaccinated());
        petInfo.add(userPet.getLongitude());
        petInfo.add(userPet.getLatitude());
        petInfo.add(userPet.getAvailableDay());
        petInfo.add(userPet.getPreferredAttributes().getSpecies());
        petInfo.add(userPet.getPreferredAttributes().getBreed());
        petInfo.add(userPet.getPreferredAttributes().getGender());
        petInfo.add(userPet.getPreferredProximity());

        return petInfo;
    }

    public HashMap<Object, List<Object>> getPetFullProfileData(String petID) {
        Pet userPet = petDsGateway.getPetById(petID);

        HashMap<Object, List<Object>> petProfile = new HashMap<>();
        petProfile.put(userPet, getProfileAllInfo(petID));

        return petProfile;
    }

    public HashMap<Object, List<Object>> getPetProfilePreviewData(String petID) {
        Pet userPet = petDsGateway.getPetById(petID);

        HashMap<Object, List<Object>> petProfile = new HashMap<>();
        petProfile.put(userPet, getProfileAllInfo(petID).subList(0, 6));

        return petProfile;
    }
}