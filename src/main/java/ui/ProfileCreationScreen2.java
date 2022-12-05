package ui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.IOException;
import java.util.List;
import java.awt.*;
import javax.swing.filechooser.FileFilter;
import java.awt.image.BufferedImage;
import java.io.File;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;
import controller.ProfileController;


public class ProfileCreationScreen2 extends JFrame implements ActionListener {
    ProfileController profileController;
    Font f1 = new Font("Arial", Font.PLAIN,  20);
    Font f2 = new Font("Arial", Font.PLAIN,  12);
    Font f3 = new Font("Arial", Font.PLAIN,  15);
    Container container = getContentPane();
    JLabel titleLabel = new JLabel("Profile Creation");

    JLabel descriptionLabel = new JLabel("<html>Please introduce your pet to others <br> by writing a short bio~</html>");
    JTextArea description = new JTextArea(30, 70);

    JLabel longitudeLabel = new JLabel("Longitude");
    JTextField longitude = new JTextField(20);
    JLabel latitudeLabel = new JLabel("Latitude");
    JTextField latitude = new JTextField(20);

    JLabel proximityLabel = new JLabel("Preferred Proximity (in KM)");
    JTextField preferredProximity = new JTextField(20);


    JLabel vaccineLabel = new JLabel("Is your pet vaccinated?");
    String[] vaccineChoices = {"Select", "Vaccinated", "Unvaccinated"};
    JComboBox<String> vaccineStatus = new JComboBox<>(vaccineChoices);
    JLabel vaccineProofLabel = new JLabel("<html> If you selected 'Vaccinated' above, <br> please upload a proof of vaccination. </html>");
    JButton uploadVaccineImageButton = new JButton("Upload");
    JLabel imageSelectedLabel = new JLabel();

    BufferedImage vaccineImage;

    JLabel page = new JLabel("Page 2/4");
    JButton saveAndContinueButton = new JButton("Save & Continue");


    JLabel[] labels = {proximityLabel, imageSelectedLabel, vaccineLabel, vaccineProofLabel, descriptionLabel, longitudeLabel,latitudeLabel};
    JTextField[] textFields = {longitude, latitude, preferredProximity};

    JTextArea[] textAreas = {description};

    JComboBox[] comboBoxes = {vaccineStatus};

    //user data from previous page
    String name;
    List<String> species;
    List<String> breed;
    String gender;
    List<Integer> age;
    BufferedImage petPhoto;



    public void setLayoutManager() {
        container.setLayout(null);

    }

    public void setPositionAndSize() {
        int currX = 60;
        int currY = 70;

        titleLabel.setBounds(120, 20, 160, 30);
        Object[] allFeatures = {descriptionLabel, description, longitudeLabel, longitude, proximityLabel, preferredProximity};

        vaccineLabel.setBounds(currX, currY, 300, 30);
        currY += 30;
        vaccineStatus.setBounds(currX, currY, 100, 30);
        currY += 40;
        vaccineProofLabel.setBounds(currX, currY, 300, 30);
        uploadVaccineImageButton.setBounds(270, currY, 80, 40);
        currY += 30;
        imageSelectedLabel.setBounds(currX, currY, 300, 30);
        currY+= 50;


        for (Object i: allFeatures){
            boolean isLabel = Objects.equals(i.getClass(), JLabel.class);
            boolean isTextField = Objects.equals(i.getClass(), JTextField.class);
            boolean isComboBox = Objects.equals(i.getClass(), JComboBox.class);
            boolean isTextArea = Objects.equals(i.getClass(), JTextArea.class);
            if (isLabel) {
                ((JComponent) i).setBounds(currX, currY, 300, 30);
                currY += 30;
            } else if (isTextField || isComboBox){
                ((JComponent) i).setBounds(currX, currY, 100, 30);
                currY += 40;
            } else if (isTextArea){
                ((JComponent) i).setBounds(currX, currY, 250, 60);
                currY += 60;
            }
        }

        latitudeLabel.setBounds(200, currY-140, 300, 30);
        latitude.setBounds(200, currY-110, 100, 30);

        page.setBounds(60, 520, 100, 30);
        saveAndContinueButton.setBounds(200, 520, 150, 40);

    }

    public void addComponentsToContainer() {
        container.add(titleLabel);
        container.add(uploadVaccineImageButton);

        for(JTextField f :textFields){
            container.add(f);
        }

        for(JLabel l :labels){
            container.add(l);
        }

        for(JTextArea a :textAreas){
            container.add(a);
        }

        for(JComboBox c :comboBoxes){
            container.add(c);
        }

        container.add(page);
        container.add(saveAndContinueButton);
    }

    public void setFonts(){
        titleLabel.setFont(f1);
        uploadVaccineImageButton.setFont(f3);
        for(JTextField f :textFields){
            f.setFont(f2);
        }

        for(JLabel l :labels){
            l.setFont(f2);
        }

        for(JTextArea a :textAreas){
            a.setFont(f2);
        }

        for(JComboBox c :comboBoxes){
            c.setFont(f2);
        }
        page.setFont(f2);
        saveAndContinueButton.setFont(f3);
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
            return "jpg file only";
        }
        String getExtension(File f) {
            String extension = null;
            String s = f.getName();
            int i = s.lastIndexOf('.');

            if (i > 0 &&  i < s.length() - 1) {
                extension = s.substring(i+1).toLowerCase();
            }
            return extension;
        }

    }


    public void addActionEvent() {
        saveAndContinueButton.addActionListener(this);
        uploadVaccineImageButton.addActionListener(this);

    }

    public ProfileCreationScreen2(ProfileController profileController, String name, List<String> species, List<String> breed, String gender, List<Integer> age, BufferedImage petPhoto){
        this.profileController = profileController;
        this.name = name;
        this.species = species;
        this.breed = breed;
        this.gender = gender;
        this.age = age;
        this.petPhoto = petPhoto;

        setLayoutManager();
        setPositionAndSize();
        addComponentsToContainer();
        addActionEvent();
        setFonts();
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
        if (Objects.equals(vaccineStatus.getSelectedItem().toString(),"Vaccinated")){
            if (Objects.equals(imageSelectedLabel.getText(), "Image upload canceled") || Objects.equals(imageSelectedLabel.getText(), "")){
                return false;
            }
        }

        return true;
    }

    public boolean checkInputCorrect(){
        try{
            Float lo = Float.valueOf(this.longitude.getText());
            Float la = Float.valueOf(this.latitude.getText());
            Float pp = Float.valueOf(this.preferredProximity.getText());
            return true;
        } catch(NumberFormatException ex) {
            return false;
        }
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        if (evt.getSource() == uploadVaccineImageButton) {
            if (Objects.equals(vaccineStatus.getSelectedItem().toString(),"Vaccinated")){
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.addChoosableFileFilter(new ProfileCreationScreen2.ImageFilter());
                fileChooser.setAcceptAllFileFilterUsed(false);

                int option = fileChooser.showOpenDialog(this);
                if(option == JFileChooser.APPROVE_OPTION){
                    File file = fileChooser.getSelectedFile();
                    imageSelectedLabel.setText("File Selected: " + file.getName());
                    try {
                        vaccineImage = ImageIO.read(file.getAbsoluteFile());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }else{
                    imageSelectedLabel.setText("Image upload canceled");
                }
            }
        }

        if(evt.getSource() == saveAndContinueButton){
            if (!checkFilled()){
                JOptionPane.showMessageDialog(this, "Incomplete, please fill out all sections");
            }else if(!checkInputCorrect()){
                JOptionPane.showMessageDialog(this,"Longitude, Latitude and Proximity must all be numbers");
            }
            else{
                boolean vaccineSta = Objects.equals(this.vaccineStatus.getSelectedItem().toString(), "Vaccinated");
                String bio = this.description.getText();
                Float lo = Float.valueOf(this.longitude.getText());
                Float la = Float.valueOf(this.latitude.getText());
                Float proximity = Float.valueOf(this.preferredProximity.getText());


                ProfileCreationScreen3 PCS3 = new ProfileCreationScreen3(profileController, vaccineSta, bio, lo, la,
                        proximity, name, species, breed, gender, age, petPhoto, vaccineImage);
                this.setVisible(false);
                PCS3.setVisible(true);
                PCS3.setSize(370, 600);
            }

        }
    }


}