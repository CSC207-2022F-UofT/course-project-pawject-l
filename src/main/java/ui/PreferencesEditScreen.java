package ui;

import controller.AccountController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class PreferencesEditScreen extends JFrame implements ActionListener {

    Font f1 = new Font("Arial", Font.PLAIN,  12);
    Font f2 = new Font("Arial", Font.PLAIN,  10);
    Font f3 = new Font("Rockwell", Font.PLAIN,  20);
    Container container = getContentPane();
    JLabel titleLabel = new JLabel("Edit Preferred Attributes");
    JLabel speciesLabel = new JLabel("Species");
    JLabel breedLabel = new JLabel("Breed");
    JLabel ageLabel = new JLabel("Age");
    JLabel genderLabel = new JLabel("Gender");
    JLabel vaccinationLabel = new JLabel("Vaccination Status");
    JTextField breedField = new JTextField();
    JButton saveButton = new JButton("Save");
    String[] speciesChoices = {"Select", "Dog", "Cat", "Rabbit", "Hamster",
            "Bird", "Panda" };
    final JComboBox<String> species = new JComboBox<String>(speciesChoices);
    String[] ageChoices = {"Select", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30"};
    final JComboBox<String> age = new JComboBox<String>(ageChoices);
    String[] genderChoices = {"Select", "Male", "Female" };
    final JComboBox<String> gender = new JComboBox<String>(genderChoices);
    String[] vaccinationChoices = {"Select", "Vaccinated", "Unvaccinated" };
    final JComboBox<String> vaccination = new JComboBox<String>(vaccinationChoices);
    JButton homeButton = new JButton("Home");
    JButton chatButton = new JButton("Chat");
    JButton profileButton = new JButton("Profile");
    JButton logoutButton = new JButton("Log Out");

    AccountController controller;


    public PreferencesEditScreen (AccountController controller) {
        this.controller = controller;
        container.setLayout(null);

        titleLabel.setBounds(65, 50, 300, 30);
        speciesLabel.setBounds(70, 140, 100, 30);
        breedLabel.setBounds(70, 180, 100, 30);
        ageLabel.setBounds(70, 220, 300, 30);
        genderLabel.setBounds(70, 260, 300, 30);
        vaccinationLabel.setBounds(70, 300, 300, 30);
        species.setBounds(190, 140, 100, 30);
        breedField.setBounds(190, 180, 100, 30);
        age.setBounds(190, 220, 100, 30);
        gender.setBounds(190, 260, 100, 30);
        vaccination.setBounds(190, 300, 100, 30);
        saveButton.setBounds(120, 380, 100, 30);
        logoutButton.setBounds(120, 450, 100, 30);
        profileButton.setBounds(0, 540, 130, 30);
        homeButton.setBounds(122, 540, 130, 30);
        chatButton.setBounds(244, 540, 130, 30);

        container.add(titleLabel);
        container.add(speciesLabel);
        container.add(breedLabel);
        container.add(ageLabel);
        container.add(genderLabel);
        container.add(vaccinationLabel);
        container.add(breedField);
        container.add(age);;
        container.add(saveButton);
        container.add(species);
        container.add(gender);
        container.add(vaccination);
        container.add(homeButton);
        container.add(profileButton);
        container.add(chatButton);
        container.add(logoutButton);

        titleLabel.setFont(f3);
        speciesLabel.setFont(f1);
        breedLabel.setFont(f1);
        ageLabel.setFont(f1);
        genderLabel.setFont(f1);
        vaccinationLabel.setFont(f1);
        breedField.setFont(f1);
        age.setFont(f2);
        species.setFont(f2);
        gender.setFont(f2);
        vaccination.setFont(f2);

        saveButton.addActionListener(this);
        homeButton.addActionListener(this);
        chatButton.addActionListener(this);
        logoutButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == saveButton) {
        }
        if (e.getSource() == homeButton) {
            HomeScreen hs = new HomeScreen(controller);
            hs.setVisible(true);
            this.setVisible(false);
            hs.setSize(370, 600);
        }
        if (e.getSource() == logoutButton) {
            LogIn_Screen lis = new LogIn_Screen(controller);
            lis.setVisible(true);
            this.setVisible(false);
            lis.setSize(370, 600);
        }
    }

//    public static void main(String[] args) {
////        AccountInputBoundary input = new AccountModel()
////        AccountController controller = new AccountController()
//        PreferencesEditScreen frame = new PreferencesEditScreen();
//
//        frame.setTitle("Preferences Edit Screen");
//        frame.setVisible(true);
//        frame.setBounds(0, 0, 370, 600);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setResizable(false);
//        System.out.println(new java.io.File("src/main/java/ui/dog.jpeg").exists());
//    }
}