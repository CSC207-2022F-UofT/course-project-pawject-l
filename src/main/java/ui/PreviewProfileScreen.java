package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PreviewProfileScreen extends JPanel implements ActionListener {

    JLabel petName;
    JLabel petImage;
    JLabel petBio;
    JLabel petAge;
    JLabel petBreed;
    JLabel petSpecies;
    JLabel petVaccinationRecords;

    public PreviewProfileScreen(String name, ImageIcon image, String bio, String age, String breed,
    String species, ImageIcon vaccine) {

        this.setLayout(null);

        this.petName = new JLabel("Hi, I'm " + name + "!");
        this.petBreed = new JLabel("Breed: " + breed);
        this.petAge = new JLabel("Age: " + age);
        this.petSpecies = new JLabel("Species: " + species);
        this.petBio = new JLabel("About me: " + bio);

        ImageIcon scaledPetImage = new ImageIcon(image.getImage().getScaledInstance(200, 200, 100));
        ImageIcon scaledVaccinationRecords = new ImageIcon(vaccine.getImage().getScaledInstance(400,
                400, 100));

        this.petImage = new JLabel(scaledPetImage);
        this.petVaccinationRecords = new JLabel(scaledVaccinationRecords);

        JButton toGetVaccinationRecords = new JButton("Click here to see my vaccination records!");
        toGetVaccinationRecords.addActionListener(this);

        this.petName.setBounds(150, 10, 100, 30);
        this.petImage.setBounds(150, 40, 200, 200);
        this.petBio.setBounds(20, 250, 480, 30);
        this.petAge.setBounds(20, 280, 480, 30);
        this.petBreed.setBounds(20, 310, 480, 30);
        this.petSpecies.setBounds(20, 340, 480, 30);
        toGetVaccinationRecords.setBounds(100,370, 300, 30);

        this.petName.setFont(new Font("Arial", Font.BOLD, 12));
        this.petBio.setFont(new Font("Arial", Font.PLAIN, 12));
        this.petSpecies.setFont(new Font("Arial", Font.PLAIN, 12));
        this.petBreed.setFont(new Font("Arial", Font.PLAIN, 12));
        this.petAge.setFont(new Font("Arial", Font.PLAIN, 12));

        this.add(this.petName);
        this.add(this.petImage);
        this.add(this.petBio);
        this.add(this.petAge);
        this.add(this.petBreed);
        this.add(this.petSpecies);
        this.add(toGetVaccinationRecords);

        this.setBounds(500, 450, 500, 450);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(null, null, "My vaccination records",
                JOptionPane.INFORMATION_MESSAGE, this.petVaccinationRecords.getIcon());
    }

    public static void main(String[] args) {
        PreviewProfileScreen p1 = new PreviewProfileScreen("Ben", new ImageIcon("images/cute-dog-headshot.jpeg"),
                "A cute lil puppy looking for a friend!", "1", "unknown", "Dog", new ImageIcon("images/vaccine.png"));
    }
}
