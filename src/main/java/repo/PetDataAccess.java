package repo;

import entities.Attributes;
import entities.Pet;
import entities.User;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Objects;

public class PetDataAccess implements PetDataAccessInterface{
    @Override
    public Pet getPetById(String id) throws IOException {
        try {
            File file = new File("java/data/petData");
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            String[] tempArr;
            while((line = br.readLine()) != null) {
                tempArr = line.split(",");
                if(Objects.equals(tempArr[0], id)){
                    String[] att = tempArr[3].split("$");
                    return new Pet(tempArr[1], tempArr[0], tempArr[2], new Attributes(Arrays.asList(att[0].split("&")), Arrays.asList(att[1].split("&")), Arrays.asList(stringToIntConversion(att[2].split("&"))), att[3], Boolean.parseBoolean(att[4])))
                }
            }
            br.close();
        } catch(IOException ioe) {
            ioe.printStackTrace();
        }
    }

    @Override
    public HashMap<String, Pet> getPetsByUser(User user) {
        return null;
    }

    @Override
    public Pet getPetByUserAndName(User user, String name) {
        return null;
    }

    @Override
    public Pet getPetByUserAndType(User user, String typeOfPet) {
        return null;
    }

    @Override
    public Pet getRandomPet() {
        return null;
    }

    @Override
    public boolean savePet(Pet pet) {
        return false;

    }

    public int[] stringToIntConversion(String[] strarr)
    {
        int i = 0;
        int[] intarr = new int[strarr.length];
        for(String num: strarr)
        {
            intarr[i] = Integer.parseInt(num);
        }
    }
}
