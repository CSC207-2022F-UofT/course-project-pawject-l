package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FullProfileScreen extends JFrame implements ActionListener {

    JLabel petName;
    JLabel petImage;
    JLabel petBio;
    JLabel petAge;
    JLabel petBreed;
    JLabel petSpecies;
    JLabel petGender;
    JLabel preferredSpecies;
    JLabel preferredBreed;
    JLabel preferredAge;
    JLabel preferredProximity;
    JLabel preferredVaccineStatus;
    JLabel petAvailability;
    JLabel petLocation;
    JLabel petVaccinationRecords;

    public FullProfileScreen(String name, ImageIcon image, String bio, String age, String breed,
                                String species, ImageIcon vaccine, String gender, String species_,
                             String breed_, String age_, String prox_, String vacc_, String availability,
                             String location) {

        this.setLayout(null);

        this.petName = new JLabel("Name: " + name);
        this.petBreed = new JLabel("Breed: " + breed);
        this.petAge = new JLabel("Age: " + age);
        this.petSpecies = new JLabel("Species: " + species);
        this.petBio = new JLabel("About me: " + bio);
        this.petGender = new JLabel("Gender: " + gender);
        this.preferredSpecies = new JLabel("Preferred Species: " + species_);
        this.preferredBreed = new JLabel("Preferred Breed: " + breed_);
        this.preferredAge = new JLabel("Preferred Age: " + age_);
        this.preferredProximity = new JLabel("Preferred Proximity: " + prox_);
        this.preferredVaccineStatus = new JLabel("Preferred Vaccine Status: " + vacc_);
        this.petAvailability = new JLabel("My availability: " + availability);
        this.petLocation = new JLabel("My location: " + location);


        ImageIcon scaledPetImage = new ImageIcon(image.getImage().getScaledInstance(150, 150, 150));
        ImageIcon scaledVaccinationRecords = new ImageIcon(vaccine.getImage().getScaledInstance(400,
                400, 100));

        this.petImage = new JLabel(scaledPetImage);
        this.petVaccinationRecords = new JLabel(scaledVaccinationRecords);

        JButton toGetVaccinationRecords = new JButton("Click here to see my vaccination records!");
        toGetVaccinationRecords.addActionListener(this);

        this.petName.setBounds(200, 10, 300, 40);
        this.petImage.setBounds(30, 10, 150, 150);
        this.petBio.setBounds(200, 35, 300, 40);
        this.petAge.setBounds(200, 60, 300, 40);
        this.petBreed.setBounds(200, 85, 300, 40);
        this.petSpecies.setBounds(200, 110, 300, 40);
        this.petGender.setBounds(200, 135, 300, 40);
        this.preferredSpecies.setBounds(30,150, 300, 40);
        this.preferredBreed.setBounds(30, 180, 300, 40);
        this.preferredAge.setBounds(30, 210, 300, 40);
        this.preferredProximity.setBounds(30, 240, 300, 40);
        this.preferredVaccineStatus.setBounds(30, 270, 300, 40);
        this.petAvailability.setBounds(30, 300, 300, 40);
        this.petLocation.setBounds(30, 330, 300, 40);
        toGetVaccinationRecords.setBounds(100,370, 300, 30);

        this.petName.setFont(new Font("Arial", Font.PLAIN, 13));
        this.petBio.setFont(new Font("Arial", Font.PLAIN, 13));
        this.petSpecies.setFont(new Font("Arial", Font.PLAIN, 13));
        this.petBreed.setFont(new Font("Arial", Font.PLAIN, 13));
        this.petAge.setFont(new Font("Arial", Font.PLAIN, 13));
        this.petGender.setFont(new Font("Arial", Font.PLAIN, 13));
        this.preferredSpecies.setFont(new Font("Arial", Font.PLAIN, 13));
        this.preferredBreed.setFont(new Font("Arial", Font.PLAIN, 13));
        this.preferredAge.setFont(new Font("Arial", Font.PLAIN, 13));
        this.preferredProximity.setFont(new Font("Arial", Font.PLAIN, 13));
        this.preferredVaccineStatus.setFont(new Font("Arial", Font.PLAIN, 13));
        this.petAvailability.setFont(new Font("Arial", Font.PLAIN, 13));
        this.petLocation.setFont(new Font("Arial", Font.PLAIN, 13));

        this.add(this.petName);
        this.add(this.petImage);
        this.add(this.petBio);
        this.add(this.petAge);
        this.add(this.petBreed);
        this.add(this.petSpecies);
        this.add(toGetVaccinationRecords);
        this.add(petGender);
        this.add(preferredAge);
        this.add(preferredBreed);
        this.add(preferredSpecies);
        this.add(petAvailability);
        this.add(petLocation);
        this.add(preferredProximity);
        this.add(preferredVaccineStatus);

        this.setBounds(500, 450, 500, 450);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(null, null, "My vaccination records",
                JOptionPane.INFORMATION_MESSAGE, this.petVaccinationRecords.getIcon());
    }

    public static void main(String[] args) {
        FullProfileScreen p1 = new FullProfileScreen("Ben", new ImageIcon("images/dog.jpeg"),
                "A cute lil puppy looking for a friend!", "1", "unknown", "Dog",
                new ImageIcon("images/vaccine.png"), "female", "any", "any", "10-12",
                "5 km", "vaccinated", "Monday, Friday", "5.0.6, 12.4.5");
    }
}
