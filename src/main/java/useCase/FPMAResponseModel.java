package useCase;
import entities.Pet;

import java.awt.*;
import java.lang.reflect.Array;

public class FPMAResponseModel {
    Pet[] listOfPotentialMatches;

    public FPMAResponseModel(Pet[] pets) {
        this.listOfPotentialMatches = pets;
    }


    public String getPetNameAt(int index) {
        return ((Pet) Array.get(this.listOfPotentialMatches, index)).getName();
    }

    public String getPetIdAt(int index) {
        return ((Pet) Array.get(this.listOfPotentialMatches, index)).getPetID();
    }

    public Image getPetImageAt(int index) {
        return ((Pet) Array.get(this.listOfPotentialMatches, index)).getImages().get(0);
    }

    public String getPetBioAt(int index) {
        return ((Pet) Array.get(this.listOfPotentialMatches, index)).getDescription();
    }

    public Integer getPetAgeAt(int index) {
        return ((Pet) Array.get(this.listOfPotentialMatches, index)).getAttributes().getAge().get(0);
    }

    public String getPetBreedAt(int index) {
        return ((Pet) Array.get(this.listOfPotentialMatches, index)).getAttributes().getBreed().get(0);
    }

    public String getPetSpeciesAt(int index) {
        return ((Pet) Array.get(this.listOfPotentialMatches, index)).getAttributes().getSpecies().get(0);
    }

    public Image getPetVaccineAt(int index) {
        return ((Pet) Array.get(this.listOfPotentialMatches, index)).getProofOfVaccination();
    }









}
