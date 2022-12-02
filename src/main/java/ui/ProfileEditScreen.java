package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ProfileEditScreen extends JFrame implements ActionListener {

    Font f1 = new Font("Arial", Font.PLAIN,  12);
    Font f2 = new Font("Arial", Font.PLAIN,  10);
    Font f3 = new Font("Rockwell", Font.PLAIN,  20);
    Container container = getContentPane();
    JLabel nameLabel = new JLabel("My Name");
    JLabel speciesLabel = new JLabel("Species");
    JLabel breedLabel = new JLabel("Breed");
    JLabel ageLabel = new JLabel("Age");
    JLabel genderLabel = new JLabel("Gender");
    JLabel vaccinationLabel = new JLabel("Vaccination Status");
    JLabel proximityLabel = new JLabel("Preferred Proximity");

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
    String[] proximityChoices = {"Select", "1km", "5km", "10km", "25km", "50km", "75km", "100km" };
    final JComboBox<String> proximity = new JComboBox<String>(proximityChoices);

//    AccountController controller;


    public ProfileEditScreen () {
//        this.controller = controller;
//        JPanel panel1 = new JPanel();
//        panel1.add(imageL);
//        this.add(panel1);
//        this.pack();
//        this.setVisible(true);

        JLabel imageL = new JLabel();
        imageL.setIcon(new ImageIcon(new ImageIcon("images/dog.jpeg").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT)));
        imageL.setBounds(50, 30, 100, 100);
        container.add(imageL);

        container.setLayout(null);

        nameLabel.setBounds(180, 50, 100, 30);
        speciesLabel.setBounds(60, 140, 100, 30);
        breedLabel.setBounds(60, 180, 100, 30);
        ageLabel.setBounds(60, 220, 300, 30);
        genderLabel.setBounds(60, 260, 300, 30);
        vaccinationLabel.setBounds(60, 300, 300, 30);
        proximityLabel.setBounds(60, 340, 300, 30);
        species.setBounds(180, 140, 100, 30);
        breedField.setBounds(180, 180, 100, 30);
        age.setBounds(180, 220, 100, 30);
        gender.setBounds(180, 260, 100, 30);
        vaccination.setBounds(180, 300, 100, 30);
        proximity.setBounds(180, 340, 100, 30);
        saveButton.setBounds(120, 400, 100, 30);

        container.add(nameLabel);
        container.add(speciesLabel);
        container.add(breedLabel);
        container.add(ageLabel);
        container.add(genderLabel);
        container.add(vaccinationLabel);
        container.add(proximityLabel);
        container.add(breedField);
        container.add(age);;
        container.add(proximity);
        container.add(saveButton);
        container.add(species);
        container.add(gender);
        container.add(vaccination);

        nameLabel.setFont(f3);
        speciesLabel.setFont(f1);
        breedLabel.setFont(f1);
        ageLabel.setFont(f1);
        genderLabel.setFont(f1);
        vaccinationLabel.setFont(f1);
        proximityLabel.setFont(f1);
        breedField.setFont(f1);
        age.setFont(f2);
        proximity.setFont(f2);
        saveButton.setFont(f1);
        species.setFont(f2);
        gender.setFont(f2);
        vaccination.setFont(f2);

        saveButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
//        Coding Part of Sign Up button
        if (e.getSource() == saveButton) {
//            String userText = usernameField.getText();
//            String pwdText = passwordField.getText();
//
//            if (AccountController.checkPasswordValid(userText, pwdText) == false) {
//                JOptionPane.showMessageDialog(this, "Password requirements unmet.");
//            } else if (AccountController.userExists(userText, pwdText) == true) {
//                JOptionPane.showMessageDialog(this, "Username already associated to an account. Please log in.");
//            } else {
//                AccountController.createUser(userText, pwdText);
//                JOptionPane.showMessageDialog(this, userText + " created.");
//            }
//        }
//        if (e.getSource() == loginButton) {
//            this.dispose();
//            loginScreen.setVisible(true);
//            loginScreen.setSize(370, 600);
        }
    }

    public static void main(String[] args) {
//        AccountInputBoundary input = new AccountModel()
//        AccountController controller = new AccountController()
        ProfileEditScreen frame = new ProfileEditScreen();

        frame.setTitle("Profile Edit Screen");
        frame.setVisible(true);
        frame.setBounds(0, 0, 370, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
    }
}