package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.time.DayOfWeek;
import controller.ProfileController;

public class ProfileCreationScreen4 extends JFrame implements ActionListener {
    ProfileController profileController;
    Font f1 = new Font("Arial", Font.PLAIN, 20);
    Font f2 = new Font("Arial", Font.PLAIN, 12);
    Font f3 = new Font("Arial", Font.PLAIN, 15);
    Container container = getContentPane();
    JLabel titleLabel = new JLabel("Profile Creation");
    JLabel availableDaysLabel = new JLabel("Available Days");
    JCheckBox mon = new JCheckBox("Monday");
    JCheckBox tue = new JCheckBox("Tuesday");
    JCheckBox wed = new JCheckBox("Wednesday");
    JCheckBox thur = new JCheckBox("Thursday");
    JCheckBox fri = new JCheckBox("Friday");
    JCheckBox sat = new JCheckBox("Saturday");
    JCheckBox sun = new JCheckBox("Sunday");

    JCheckBox[] availableDaysChoices = {mon, tue, wed, thur, fri, sat, sun};

    JLabel preferredVaccineLabel = new JLabel("<html> Do you want to match ONLY with <br> pets that are vaccinated?</html>");
    String[] preferredVaccineChoices = {"Select", "Yes", "No"};
    JComboBox<String> preferredVaccineStatus = new JComboBox<>(preferredVaccineChoices);

    JLabel page = new JLabel("Page 4/4");
    JButton submitProfileButton = new JButton("Submit Profile");

    // info from previous pages
    boolean vaccineSta;
    String bio;
    float lo;
    float la;
    float proximity;
    String name;
    List<String> species;
    List<String> breed;
    String gender;
    List<Integer> age;
    BufferedImage petPhoto;
    BufferedImage vaccineImage;
    List<String> preferredSpec;
    List<String> preferredBre;
    String preferredGen;
    List<Integer> preferredAgeRange;




    public void setLayoutManager() {
        container.setLayout(null);

    }

    public void setPositionAndSize() {
        int currX = 60;
        int currY = 70;

        titleLabel.setBounds(120, 20, 160, 30);
        availableDaysLabel.setBounds (60, 70, 100, 30);
        currY += 30;

        for(JCheckBox d: availableDaysChoices){
            d.setBounds(currX, currY, 300, 30);
            currY += 30;
        }
        currY += 10;
        preferredVaccineLabel.setBounds(currX, currY, 300, 50);
        currY += 50;
        preferredVaccineStatus.setBounds(currX, currY, 100, 40);

        page.setBounds(60, 520, 100, 30);
        submitProfileButton.setBounds(200, 520, 150, 40);

    }

    public void addComponentsToContainer() {
        container.add(titleLabel);
        container.add(availableDaysLabel);
        for(JCheckBox d: availableDaysChoices){
            container.add(d);
        }
        container.add(preferredVaccineLabel);
        container.add(preferredVaccineStatus);
        container.add(page);
        container.add(submitProfileButton);
    }

    public void setFonts(){
        titleLabel.setFont(f1);
        for(JCheckBox d: availableDaysChoices){
            d.setFont(f2);
        }
        preferredVaccineStatus.setFont(f2);
        preferredVaccineLabel.setFont(f2);
        page.setFont(f2);
        submitProfileButton.setFont(f3);
    }

    public void addActionEvent() {
        submitProfileButton.addActionListener(this);

    }

    public ProfileCreationScreen4(ProfileController profileController, boolean vaccineSta, String bio, float lo, float la, float proximity, String name,
                                  java.util.List<String> species, java.util.List<String> breed, String gender, List<Integer> age,
                                  BufferedImage petPhoto, BufferedImage vaccineImage, List<String> preferredSpec,
                                  List<String> preferredBre, String preferredGen, List<Integer> preferredAgeRange){
        this.profileController = profileController;
        this.vaccineSta = vaccineSta;
        this.bio = bio;
        this.lo = lo;
        this.la = la;
        this.proximity = proximity;
        this.name = name;
        this.species = species;
        this.breed = breed;
        this.gender = gender;
        this.age = age;
        this.petPhoto = petPhoto;
        this.vaccineImage = vaccineImage;
        this.preferredSpec = preferredSpec;
        this.preferredBre = preferredBre;
        this.preferredGen = preferredGen;
        this.preferredAgeRange = preferredAgeRange;

        setLayoutManager();
        setPositionAndSize();
        addComponentsToContainer();
        addActionEvent();
        setFonts();
    }

    public boolean checkFilled(){
        if (!Objects.equals(preferredVaccineStatus.getSelectedItem().toString(), "Select")) {
            for (JCheckBox c : availableDaysChoices) {
                if (c.isSelected()) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        if(evt.getSource() == submitProfileButton){
            if (!checkFilled()){
                JOptionPane.showMessageDialog(this, "Incomplete, please select at least one choice from all sections.");
            }
            else {
                List<DayOfWeek> availableDays = new ArrayList<>();
                for(JCheckBox d:availableDaysChoices){
                    if (d.isSelected()){
                        if(d.isSelected()){
                            if (Objects.equals(d.getName(), "Monday")){
                                availableDays.add(DayOfWeek.MONDAY);
                            } else if (Objects.equals(d.getText(), "Tuesday")) {
                                availableDays.add(DayOfWeek.TUESDAY);
                            } else if (Objects.equals(d.getText(), "Wednesday")) {
                                availableDays.add(DayOfWeek.WEDNESDAY);
                            } else if (Objects.equals(d.getText(), "Thursday")) {
                                availableDays.add(DayOfWeek.THURSDAY);
                            } else if(Objects.equals(d.getText(), "Friday")){
                                availableDays.add(DayOfWeek.FRIDAY);
                            }else if (Objects.equals(d.getText(), "Saturday")){
                                availableDays.add(DayOfWeek.SATURDAY);
                            } else if (Objects.equals(d.getText(), "Sunday")){
                            availableDays.add(DayOfWeek.SUNDAY);}
                        }
                    }
                }

                boolean preferredVaccineSta = !Objects.equals(preferredVaccineStatus.getSelectedItem().toString(), "No");
                List<BufferedImage> petP = new ArrayList<>();
                petP.add(petPhoto);

                /**
                 Once all the user inputs are all converted into the data form needed to create a Pet object,
                 the UI will call the profile controller which calls the method to create new Pet and save it to the
                 database.
                 */

                try {
                    profileController.performProfileCreation(name, bio, species, breed, age, gender, vaccineSta, preferredSpec,
                            preferredBre, preferredAgeRange, preferredGen, petP, vaccineImage, lo, la, proximity,
                            availableDays,preferredVaccineSta);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

                JOptionPane.showMessageDialog(this, "Profiled created!");
            }
        }
    }

    /**
    public static void main(String[] args) {
        ProfileCreationScreen4 frame = new ProfileCreationScreen4();
        frame.setTitle("Profile Creation Screen");
        frame.setVisible(true);
        frame.setBounds(10, 10, 370, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }*/
}