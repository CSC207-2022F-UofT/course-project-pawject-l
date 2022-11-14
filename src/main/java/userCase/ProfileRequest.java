package userCase;
import entities.Pet;
import entities.Attributes;
import repo.PetDataRequestModel;

import java.awt.*;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
public class ProfileRequest{
    private  HashMap<String, Pet> existingPetIdDict = new HashMap<>();
    private PetDataRequestModel petDataRequestModel;

    public ProfileRequest(PetDataRequestModel petDataRequestModel){
        this.petDataRequestModel = petDataRequestModel;
    }

    /**
     * Generates unique PetID when the profile is first created.
     * @param existingPetIdDict
     * @return unique PetID
     */
    public String generatePetID(HashMap<String, Pet> existingPetIdDict){
        return "Pet ID:" + (existingPetIdDict.size() + 1);
    }

    /**
     * Check if profile exists in the database.
     * @param petId
     * @return true if profile exist, false if not
     */
    public Boolean profileExists(String petId){
        return existingPetIdDict.containsKey(petId);
    }

    /**
     * Create a new pet and save all the information into the Pet database.
     * @param existingPetIdDict
     * @param name
     * @param description
     * @param attributes
     * @param preferredAttributes
     * @param images
     */
    public void createNewProfile(HashMap<String, Pet> existingPetIdDict, String name, String description,
                                 Attributes attributes, Attributes preferredAttributes, List<Image> images){
        String petId = generatePetID(existingPetIdDict);
        Pet newPet = new Pet(name, petId, description, attributes, preferredAttributes, images);
        petDataRequestModel.savePet(newPet);
        existingPetIdDict.put(petId, newPet);
    }

    public void editName(String petID,String newValue){
        Pet pet = petDataRequestModel.getPetById(petID);
        pet.setName(newValue);
    }

    public void editSpecies(String petID,List<String> newValues){
        Pet pet = petDataRequestModel.getPetById(petID);
        pet.getAttributes().setSpecies(newValues);
    }

    public void editBreed(String petID,List<String> newValues){
        Pet pet = petDataRequestModel.getPetById(petID);
        pet.getAttributes().setBreed(newValues);
    }

    public void editAge(String petID,List<Integer> newValues){
        Pet pet = petDataRequestModel.getPetById(petID);
        pet.getAttributes().setAge(newValues);
    }

    public void editGender(String petID,String newValue){
        Pet pet = petDataRequestModel.getPetById(petID);
        pet.getAttributes().setGender(newValue);
    }

    public void editDescription(String petID,String newValue){
        Pet pet = petDataRequestModel.getPetById(petID);
        pet.setDescription(newValue);
    }

    public void addImage(String petID, Image newImage){
        Pet pet = petDataRequestModel.getPetById(petID);
        pet.getImages().add(newImage);
    }

    public void removeImage(String petID, Image imageToRemove){
        Pet pet = petDataRequestModel.getPetById(petID);
        pet.getImages().remove(imageToRemove);
    }

    public void updateProofOfVaccination (String petID, Image proofOfVaccination){
        Pet pet = petDataRequestModel.getPetById(petID);
        pet.getAttributes().setProofOfVaccination(proofOfVaccination);
        pet.getAttributes().setVaccineStatus(true);
    }

    public void editLongitude (String petID, int newValue){
        Pet pet = petDataRequestModel.getPetById(petID);
        pet.getAttributes().setLongitude(newValue);
    }

    public void editLatitude (String petID, int newValue){
        Pet pet = petDataRequestModel.getPetById(petID);
        pet.getAttributes().setLatitude(newValue);
    }

    public void editAvailableDay (String petID, List<DayOfWeek> availableDay){
        Pet pet = petDataRequestModel.getPetById(petID);
        pet.getAttributes().setAvailableDay(availableDay);
    }

    public void editPreferredSpecies(String petID,List<String> newValues){
        Pet pet = petDataRequestModel.getPetById(petID);
        pet.getPreferredAttributes().setSpecies(newValues);
    }

    public void editPreferredBreed(String petID,List<String> newValues){
        Pet pet = petDataRequestModel.getPetById(petID);
        pet.getPreferredAttributes().setBreed(newValues);
    }

    public void editPreferredAge(String petID,List<Integer> newValues){
        Pet pet = petDataRequestModel.getPetById(petID);
        pet.getPreferredAttributes().setAge(newValues);
    }

    public void editPreferredGender(String petID,String newValue){
        Pet pet = petDataRequestModel.getPetById(petID);
        pet.getPreferredAttributes().setGender(newValue);
    }

    public void editPreferredProximity(String petID, int newValue){
        Pet pet = petDataRequestModel.getPetById(petID);
        pet.getAttributes().setPreferredProximity(newValue);
    }

    /**
     *
     * @param petID
     * @return all profile information of a pet.
     */
    public List<Object> getProfileAllInfo(String petID) {
        Pet userPet = petDataRequestModel.getPetById(petID);
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
        petInfo.add(userPet.getAttributes().getProofOfVaccination());
        petInfo.add(userPet.getAttributes().isVaccinated());
        petInfo.add(userPet.getAttributes().getLongitude());
        petInfo.add(userPet.getAttributes().getLatitude());
        petInfo.add(userPet.getAttributes().getAvailableDay());
        petInfo.add(userPet.getPreferredAttributes().getSpecies());
        petInfo.add(userPet.getPreferredAttributes().getBreed());
        petInfo.add(userPet.getPreferredAttributes().getGender());
        petInfo.add(userPet.getPreferredAttributes().getPreferredProximity());

        return petInfo;
    }

    public HashMap<Object, List<Object>> getPetFullProfileData(String petID) {
        Pet userPet = petDataRequestModel.getPetById(petID);

        HashMap<Object, List<Object>> petProfile = new HashMap<>();
        petProfile.put(userPet, getProfileAllInfo(petID));

        return petProfile;
    }

    public HashMap<Object, List<Object>> getPetProfilePreviewData(String petID) {
        Pet userPet = petDataRequestModel.getPetById(petID);

        HashMap<Object, List<Object>> petProfile = new HashMap<>();
        petProfile.put(userPet, getProfileAllInfo(petID).subList(0, 6));

        return petProfile;
    }
}