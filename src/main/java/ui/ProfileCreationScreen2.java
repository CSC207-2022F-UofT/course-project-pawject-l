package ui;

import javax.swing.*;
import java.awt.*;
import javax.swing.filechooser.FileFilter;
import java.io.File;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;


public class ProfileCreationScreen2 extends JFrame implements ActionListener {
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

    JLabel page = new JLabel("Page 2/4");
    JButton saveAndContinueButton = new JButton("Save & Continue");


    JLabel[] labels = {proximityLabel, imageSelectedLabel, vaccineLabel, vaccineProofLabel, descriptionLabel, longitudeLabel,latitudeLabel};
    JTextField[] textFields = {longitude, latitude, preferredProximity};

    JTextArea[] textAreas = {description};

    JComboBox[] comboBoxes = {vaccineStatus};



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

        public final static String PNG = "png";
        public final static String JPEG = "jpeg";
        public final static String JPG = "jpg";
        public final static String GIF = "gif";
        public final static String TIFF = "tiff";
        public final static String TIF = "tif";

        @Override
        public boolean accept(File f) {
            if (f.isDirectory()) {
                return true;
            }

            String extension = getExtension(f);
            if (extension != null) {
                return extension.equals(JPG) || extension.equals(PNG) || extension.equals(JPEG) || extension.equals(TIFF) ||
                        extension.equals(TIF) || extension.equals(GIF);
            }
            return false;

        }

        @Override
        public String getDescription() {
            return "Images only";
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

    public ProfileCreationScreen2(){
        setLayoutManager();
        setPositionAndSize();
        addComponentsToContainer();
        addActionEvent();
        setFonts();
    }




    @Override
    public void actionPerformed(ActionEvent evt) {
        if(evt.getSource() == saveAndContinueButton){
            ProfileCreationScreen3 PCS3 = new ProfileCreationScreen3();
            this.setVisible(false);
            PCS3.setVisible(true);
            PCS3.setSize(370, 600);
        }
        else if (evt.getSource() == uploadVaccineImageButton) {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.addChoosableFileFilter(new ProfileCreationScreen2.ImageFilter());
            fileChooser.setAcceptAllFileFilterUsed(false);

            int option = fileChooser.showOpenDialog(this);
            if(option == JFileChooser.APPROVE_OPTION){
                File file = fileChooser.getSelectedFile();
                imageSelectedLabel.setText("File Selected: " + file.getName());
            }else{
                imageSelectedLabel.setText("Image upload canceled");
            }

        }
    }


    public static void main(String[] args) {
        ProfileCreationScreen2 frame = new ProfileCreationScreen2();
        frame.setTitle("Profile Creation Screen");
        frame.setVisible(true);
        frame.setBounds(10, 10, 370, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

}