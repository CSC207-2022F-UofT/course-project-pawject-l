package repo;

import entities.Attributes;
import entities.Pet;
import entities.User;
import javax.imageio.ImageIO;
import java.awt.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.DayOfWeek;
import java.util.*;
import java.util.List;

public class PetDataAccess implements PetDataAccessInterface{
    /**
     * Creates Pet object corresponding to given ID
     * @param id the ID of the Pet being queried
     * @return Returns the corresponding Pet object
     */
    @Override
    public Pet getPetById(String id) throws IOException {
        Pet pet = null;
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
                    String[] pref = tempArr[4].split("$");
                    pet = new Pet(tempArr[1], tempArr[0], tempArr[2], new Attributes(Arrays.asList(att[0].split("&")), Arrays.asList(att[1].split("&")), stringToIntConversion(att[2].split("&")), att[3], Boolean.parseBoolean(att[4])), new Attributes(Arrays.asList(pref[0].split("&")), Arrays.asList(pref[1].split("&")), stringToIntConversion(pref[2].split("&")), pref[3], Boolean.parseBoolean(att[4])), convertToPhotos(tempArr[5].split("$")), convertToPhoto(tempArr[6]), Float.parseFloat(tempArr[7]), Float.parseFloat(tempArr[8]), Float.parseFloat(tempArr[9]), convertToDaysOfWeek(tempArr[5].split("$")));
                }
            }
            fr.close();
            br.close();
        }
        catch(IOException ioe)
        {
            ioe.printStackTrace();
        }
        return pet;
    }
    /**
     * Creates HashMap with petId as Key and Pet object as value corresponding to given User object
     * @param user the User object used to find specific Pet objects
     * @return Returns a HashMap containing petId and Pet object
     */
    @Override
    public HashMap<String, Pet> getPetsByUser(User user) throws IOException
    {
        String petIds = getPetIdsByUser(user);
        HashMap<String, Pet> petHashMap = new HashMap<>();
        String[] petIdArr = petIds.split("$");
        for(String petId: petIdArr)
        {
            petHashMap.put(petId, getPetById(petId));
        }
        return petHashMap;
    }
    /**
     * Creates Pet object corresponding to User object and petName variable
     * @param user  the User object used to find specific Pet object
     * @param name  petName corresponding to queried Pet object
     * @return Returns the corresponding Pet object
     */
    @Override
    public Pet getPetByUserAndName(User user, String name) throws IOException {
        String[] petIds = getPetIdsByUser(user).split("$");
        Pet pet = null;
        for(String petId: petIds)
        {
            Pet possiblePet = getPetById(petId);
            if(possiblePet.getName().equals(name))
            {
                pet = possiblePet;
            }
        }
        return pet;
    }
    /**
     * Creates String object containing a user's petIds
     * @param user  the User object used to find specific petIds
     * @return Returns String object containing petIds
     */
    private String getPetIdsByUser(User user)
    {
        String petIds = null;
        try
        {
            int count = 0;
            File file = new File("java/data/userData");
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            String[] tempArr;
            while ((line = br.readLine()) != null) {
                tempArr = line.split(",");
                if(tempArr[0].equals(user.getUserID()))
                {
                   petIds = tempArr[3];
                }
            }
            fr.close();
            br.close();
        }
        catch(IOException ioe)
        {
            ioe.printStackTrace();
        }
        return petIds;
    }
    /**
     * Creates HashMap with petId as Key and Pet object as value corresponding to given User object and specified species
     * @param user the User object used to find specific Pet objects
     * @param typeOfPet the specified species of Pet
     * @return Returns a HashMap containing petId and Pet object
     */
    @Override
    public HashMap<String, Pet> getPetsByUserAndType(User user, String typeOfPet) throws IOException {
        String petIds = getPetIdsByUser(user);
        HashMap<String, Pet> petHashMap = new HashMap<>();
        String[] petIdArr = petIds.split("$");
        for(String petId: petIdArr)
        {
            Pet possiblePet = getPetById(petId);
            String type = possiblePet.getAttributes().getSpecies().get(0);
            if(Objects.equals(type, typeOfPet))
            {
                petHashMap.put(petId, getPetById(petId));
            }
        }
        return petHashMap;
    }
    /**
     * Creates Pet object based on random index
     * @return Returns random Pet object
     */
    @Override
    public Pet getRandomPet() throws IOException {
        int size = getSizeOfDataFile();
        int randIndex = (int)(Math.random()*(size+1));
        String petId = "PET ID:" + randIndex;
        return getPetById(petId);
    }
    /**
     * Finds current number of lines in petData storage file
     * @return Returns int containing number of lines
     */
    private int getSizeOfDataFile() {
        int count = 0;
        try
        {
            File file = new File("java/data/petData");
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            while ((line = br.readLine()) != null) {
                count += 1;
            }
            fr.close();
            br.close();
        }
        catch(IOException ioe)
        {
            ioe.printStackTrace();
        }
        return count;
    }
    /**
     * Saves data corresponding to given Pet object
     * @param pet Pet object which data is being stored
     * @return Returns if data was successfully stored
     */
    @Override
    public boolean savePet(Pet pet) throws IOException
    {
        boolean saved = false;
        try {
            FileWriter fw = new FileWriter("java/data/petData", true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.newLine();
            bw.write(petConvertedToString(pet));
            saved = true;
        }
        catch(IOException ioe)
        {
            ioe.printStackTrace();
        }
        return saved;
    }
    /**
     * Converts Pet object to String for data storage
     * @param pet Pet object which data is being converted
     * @return Returns String with corresponding Pet object data
     */
    private String petConvertedToString(Pet pet)
    {
        int count = 0;
        StringBuilder construction = new StringBuilder();
        construction.append(pet.getPetID()).append(",");
        construction.append(pet.getName()).append(",");
        construction.append(pet.getDescription()).append(",");
        construction.append(pet.getAttributes().getSpecies().get(0)).append("$");
        construction.append(pet.getAttributes().getBreed().get(0)).append("$");
        construction.append(pet.getAttributes().getAge().get(0)).append("$");
        construction.append(pet.getAttributes().getGender()).append("$");
        construction.append(pet.getAttributes().isVaccinated()).append(",");
        for(String specie: pet.getPreferredAttributes().getSpecies())
        {
            if(count == 0)
            {
                construction.append(specie);
                count += 1;
            }
            else
            {
                construction.append("&").append(specie);
            }
        }
        construction.append("$");
        count = 0;
        for(String breed: pet.getPreferredAttributes().getBreed())
        {
            if(count == 0)
            {
                construction.append(breed);
                count += 1;
            }
            else
            {
                construction.append("&").append(breed);
            }
        }
        construction.append("$");
        count = 0;
        for(int age: pet.getPreferredAttributes().getAge())
        {
            if(count == 0)
            {
                construction.append(age);
                count += 1;
            }
            else
            {
                construction.append("&").append(age);
            }
        }
        construction.append("$");
        count = 0;
        construction.append(pet.getPreferredAttributes().getGender()).append("$");
        construction.append(pet.getPreferredAttributes().isVaccinated()).append(",");
        for(Image image: pet.getImages())
        {
            if(count == 0)
            {
                construction.append(image.getSource());
                count += 1;
            }
            else
            {
                construction.append("$").append(image.getSource());
            }

        }
        construction.append(",");
        count = 0;
        construction.append(pet.getProofOfVaccination().getSource()).append(",");
        construction.append(pet.getLatitude()).append(",");
        construction.append(pet.getLongitude()).append(",");
        construction.append(pet.getPreferredProximity()).append(",");
        for(DayOfWeek day:pet.getAvailableDay())
        {
            if(count == 0)
            {
                construction.append(day.name());
                count += 1;
            }
            else
            {
                construction.append("$").append(day.name());
            }
        }
        return construction.toString();
    }
    /**
     * Converts String Array into List<Integer>
     * @param strarr String array being converted
     * @return Returns List<Integer> with values corresponding to given String array
     */
    public List<Integer> stringToIntConversion(String[] strarr)
    {
        int i = 0;
        List<Integer> intarr = new ArrayList<>();
        for(String num: strarr)
        {
            intarr.add(Integer.parseInt(num));
        }
        return intarr;
    }
    /**
     * Converts String Array into List<Image>
     * @param strarr String array being converted
     * @return Returns List<Image> with sources corresponding to given String array
     */
    public List<Image> convertToPhotos(String[] strarr) throws IOException {
        List<Image> images = new ArrayList<>();
        for(String str: strarr)
        {
            Image image = ImageIO.read(new File(str));
            images.add(image);
        }
        return images;
    }
    /**
     * Converts String object to Image object
     * @param str String array being converted
     * @return Returns Image with source corresponding to given String
     */
    public Image convertToPhoto(String str) throws IOException
    {
        return ImageIO.read(new File(str));
    }
    /**
     * Converts String Array into List<DayOfWeek>
     * @param days String array being converted
     * @return Returns List<DayOfWeek> with values corresponding to given String array
     */
    public List<DayOfWeek> convertToDaysOfWeek(String[] days)
    {
        List<DayOfWeek> DayOfWeekList = new ArrayList<DayOfWeek>();
        for(String day: days)
        {
            if(day.equals("MONDAY"))
            {
                DayOfWeekList.add(DayOfWeek.MONDAY);
            }
            if(day.equals("TUESDAY"))
            {
                DayOfWeekList.add(DayOfWeek.TUESDAY);
            }
            if(day.equals("WEDNESDAY"))
            {
                DayOfWeekList.add(DayOfWeek.WEDNESDAY);
            }
            if(day.equals("THURSDAY"))
            {
                DayOfWeekList.add(DayOfWeek.THURSDAY);
            }
            if(day.equals("FRIDAY"))
            {
                DayOfWeekList.add(DayOfWeek.FRIDAY);
            }
            if(day.equals("SATURDAY"))
            {
                DayOfWeekList.add(DayOfWeek.SATURDAY);
            }
            if(day.equals("SUNDAY"))
            {
                DayOfWeekList.add(DayOfWeek.SUNDAY);
            }
        }
        return DayOfWeekList;
    }
}
