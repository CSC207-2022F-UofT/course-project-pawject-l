package ui;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Objects;

import controller.*;
import useCase.Profile.ProfileInputBoundary;

import repo.PetDataAccessInterface;
import repo.PetDataAccess;
import useCase.Profile.ProfileManager;


public class ProfileCreationScreen1 extends JFrame implements ActionListener {
    ProfileController profileController;
    ChatController chatController;
    MatchManagerController matchController;
    AccountController accountController;
    GeneralController generalController;

    Font f1 = new Font("Arial", Font.PLAIN, 20);
    Font f2 = new Font("Arial", Font.PLAIN, 12);
    Font f3 = new Font("Arial", Font.PLAIN, 15);
    Container container = getContentPane();
    JLabel titleLabel = new JLabel("Profile Creation");
    JLabel nameLabel = new JLabel("Pet name");
    JTextField name = new JTextField(20);

    JLabel speciesLabel = new JLabel("Species");
    String[] speciesChoices = {"Select", "Dog", "Cat", "Turtle", "Hamster"};
    JComboBox<String> species = new JComboBox<>(speciesChoices);

    JLabel genderLabel = new JLabel("Gender");
    String[] genderChoices = {"Select", "Female", "Male"};
    JComboBox<String> gender = new JComboBox<>(genderChoices);

    JLabel breedLabel = new JLabel("Breed");
    JTextField breed = new JTextField(20);

    JLabel ageLabel = new JLabel("Age");
    JTextField age = new JTextField(20);

    JLabel page = new JLabel("Page 1/4");

    JButton saveAndContinueButton = new JButton("Save & Continue");

    JLabel petImageLabel = new JLabel("Upload a photo of your pet!");
    JButton uploadPetImageButton = new JButton("Upload");
    JLabel imageSelectedLabel = new JLabel();

    BufferedImage petPhoto;


    JLabel[] labels = {nameLabel, petImageLabel, speciesLabel, breedLabel, genderLabel, ageLabel, petImageLabel, imageSelectedLabel};

    JTextField[] textFields = {name, breed, age};
    JComboBox[] comboBoxes = {gender, species};


    public void setPositionAndSize() {
        int currX = 60;
        int currY = 70;

        titleLabel.setBounds(120, 20, 160, 30);
        Object[] allFeatures = {nameLabel, name, speciesLabel, species, breedLabel, breed, genderLabel, gender, ageLabel,
                age, petImageLabel, imageSelectedLabel};

        for (Object i : allFeatures) {
            boolean isLabel = Objects.equals(i.getClass(), JLabel.class);
            boolean isTextField = Objects.equals(i.getClass(), JTextField.class);
            boolean isComboBox = Objects.equals(i.getClass(), JComboBox.class);
            if (isLabel) {
                ((JComponent) i).setBounds(currX, currY, 300, 30);
                currY += 30;
            } else if (isTextField || isComboBox) {
                ((JComponent) i).setBounds(currX, currY, 100, 30);
                currY += 40;
            }
        }

        uploadPetImageButton.setBounds(245, currY - 60, 80, 40);
        page.setBounds(60, 520, 100, 30);
        saveAndContinueButton.setBounds(200, 520, 150, 40);

    }

    public void addComponentsToContainer() {
        container.add(titleLabel);
        container.add(uploadPetImageButton);

        for (JTextField f : textFields) {
            container.add(f);
        }

        for (JLabel l : labels) {
            container.add(l);
        }


        for (JComboBox c : comboBoxes) {
            container.add(c);
        }

        container.add(page);
        container.add(saveAndContinueButton);
    }

    public void setFonts() {
        titleLabel.setFont(f1);
        uploadPetImageButton.setFont(f3);
        for (JTextField f : textFields) {
            f.setFont(f2);
        }

        for (JLabel l : labels) {
            l.setFont(f2);
        }

        for (JComboBox c : comboBoxes) {
            c.setFont(f2);
        }
        page.setFont(f2);
        saveAndContinueButton.setFont(f3);
    }

    public void addActionEvent() {
        saveAndContinueButton.addActionListener(this);
        uploadPetImageButton.addActionListener(this);

    }

    public ProfileCreationScreen1(ProfileController profileController, ChatController chatController,
                                  MatchManagerController matchController, AccountController accountController,
                                  GeneralController generalController) {
        this.profileController = profileController;
        this.accountController = accountController;
        this.matchController = matchController;
        this.generalController = generalController;
        this.chatController = chatController;
        container.setLayout(null);
        setPositionAndSize();
        addComponentsToContainer();
        addActionEvent();
        setFonts();
    }

    class ImageFilter extends FileFilter {

        public final static String JPG = "jpg";

        @Override
        public boolean accept(File f) {
            if (f.isDirectory()) {
                return true;
            }

            String extension = getExtension(f);
            if (extension != null) {
                return extension.equals(JPG);
            }
            return false;

        }

        @Override
        public String getDescription() {
            return "JPG files only";
        }

        String getExtension(File f) {
            String extension = null;
            String s = f.getName();
            int i = s.lastIndexOf('.');

            if (i > 0 && i < s.length() - 1) {
                extension = s.substring(i + 1).toLowerCase();
            }
            return extension;
        }

    }

    public boolean checkFilled(){
        for (JTextField i:textFields){
            if (Objects.equals(i.getText(), "")){
                return false;
            }
        }
        for (JComboBox c: comboBoxes){
            if (Objects.equals(c.getSelectedItem().toString(), "Select")){
                return false;
            }
        }
        if (Objects.equals(imageSelectedLabel.getText(), "Image upload canceled") || Objects.equals(imageSelectedLabel.getText(), "")){
            return false;
        }
        return true;
    }

    public boolean checkInputCorrect(){
        try{
            Integer num = Integer.valueOf(this.age.getText());
            return true;
        } catch(NumberFormatException ex) {
            return false;
        }
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        if (evt.getSource() == uploadPetImageButton) {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.addChoosableFileFilter(new ImageFilter());
            fileChooser.setAcceptAllFileFilterUsed(false);

            int option = fileChooser.showOpenDialog(this);
            if (option == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                imageSelectedLabel.setText("File Selected: " + file.getName());
                try {
                    petPhoto = ImageIO.read(file);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            } else {
                imageSelectedLabel.setText("Image upload canceled");
            }
        }

        if (evt.getSource() == saveAndContinueButton) {
            if (!checkFilled()) {
                JOptionPane.showMessageDialog(this, "Incomplete, please fill out all sections");
            }
            else if(!checkInputCorrect()){
                JOptionPane.showMessageDialog(this,"Age must be a number");
            }
            else {

                String name = this.name.getText();
                List<String> speciesInput = new ArrayList<>();
                speciesInput.add(this.species.getSelectedItem().toString());
                List<String> breedInput = new ArrayList<>();
                breedInput.add(this.breed.getText());
                String gender = this.gender.getSelectedItem().toString();
                List<Integer> ageInput = new ArrayList<>();
                ageInput.add(Integer.valueOf(this.age.getText()));

                ProfileCreationScreen2 PCS2 = new ProfileCreationScreen2(profileController, chatController, matchController,
                        accountController, generalController, name, speciesInput,
                        breedInput, gender, ageInput, petPhoto);
                this.setVisible(false);
                PCS2.setVisible(true);
                PCS2.setSize(370, 600);
            }
        }

    }


    //public static void main(String[] args) {
        //PetDataAccessInterface pet;
        //pet = new PetDataAccess();
        //ProfileInputBoundary PIB = new ProfileManager(pet);
        //ProfileController profileController = new ProfileController(PIB);
        //ProfileCreationScreen1 frame = new ProfileCreationScreen1(profileController);
        //frame.setTitle("Profile Creation Screen");
        //frame.setVisible(true);
        //frame.setBounds(10, 10, 370, 600);
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    //}
}