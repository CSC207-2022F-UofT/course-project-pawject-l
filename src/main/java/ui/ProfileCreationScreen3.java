package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class ProfileCreationScreen3 extends JFrame implements ActionListener {
    Font f1 = new Font("Arial", Font.PLAIN, 20);
    Font f2 = new Font("Arial", Font.PLAIN, 12);
    Font f3 = new Font("Arial", Font.PLAIN, 15);
    Container container = getContentPane();
    JLabel titleLabel = new JLabel("Profile Creation");

    JLabel preferredSpeciesLabel = new JLabel("Preferred Species");
    JCheckBox dog = new JCheckBox("Dog");
    JCheckBox cat = new JCheckBox("Cat");
    JCheckBox bird = new JCheckBox("Bird");
    JCheckBox hamster = new JCheckBox("Hamster");
    JCheckBox rabbit = new JCheckBox("Rabbit");

    JCheckBox[] preferredSpeciesChoices = {dog, cat, bird, hamster, rabbit};
    JLabel preferredGenderLabel = new JLabel("Preferred Gender of your pet's potential matches");
    String[] preferredGenderChoices = {"Select","Female", "Male", "No preference"};
    JComboBox<String> preferredGender = new JComboBox<>(preferredGenderChoices);

    JLabel preferredBreedLabel = new JLabel("Preferred Breeds (Enter breeds seperated by commas)");
    JTextArea preferredBreed = new JTextArea(20, 50);

    JLabel preferredAgeLabel = new JLabel("Preferred Age Range");
    JLabel minAgeLabel = new JLabel("Minimum Age");
    JLabel maxAgeLabel = new JLabel("Maximum Age");
    JTextField minAge = new JTextField(10);
    JTextField maxAge = new JTextField(10);

    JLabel page = new JLabel("Page 3/4");
    JButton saveAndContinueButton = new JButton("Save & Continue");

    JLabel[] labels = { preferredGenderLabel, preferredSpeciesLabel,
            preferredBreedLabel, preferredAgeLabel, minAgeLabel, maxAgeLabel};
    JTextField[] textFields = {minAge, maxAge};

    JTextArea[] textAreas = {preferredBreed};

    JComboBox[] comboBoxes = {preferredGender};


    public void setLayoutManager() {
        container.setLayout(null);

    }

    public void setPositionAndSize() {
        int currX = 60;
        int currY = 70;

        titleLabel.setBounds(120, 20, 160, 30);
        Object[] allFeatures = {preferredBreedLabel, preferredBreed, preferredGenderLabel, preferredGender,
                preferredAgeLabel, minAgeLabel,minAge};


        preferredSpeciesLabel.setBounds(currX, currY, 100, 30);
        currY += 30;
        for(JCheckBox s: preferredSpeciesChoices){
            s.setBounds(currX, currY, 100, 30);
            currY += 30;
        }

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
                ((JComponent) i).setBounds(currX, currY, 250, 50);
                currY += 60;
            }
        }

        maxAgeLabel.setBounds(200, currY-70, 300, 30);
        maxAge.setBounds(200, currY-40, 100, 30);

        page.setBounds(60, 520, 100, 30);
        saveAndContinueButton.setBounds(200, 520, 150, 40);

    }

    public void addComponentsToContainer() {
        container.add(titleLabel);

        for(JCheckBox s: preferredSpeciesChoices){
            container.add(s);
        }

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
        for(JTextField f :textFields){
            f.setFont(f2);
        }
        for(JCheckBox s: preferredSpeciesChoices){
            s.setFont(f2);
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

    public void addActionEvent() {
        saveAndContinueButton.addActionListener(this);

    }

    public ProfileCreationScreen3(){
        setLayoutManager();
        setPositionAndSize();
        addComponentsToContainer();
        addActionEvent();
        setFonts();
    }


    @Override
    public void actionPerformed(ActionEvent evt) {
        if(evt.getSource() == saveAndContinueButton){
            ProfileCreationScreen4 PCS4 = new ProfileCreationScreen4();
            this.setVisible(false);
            PCS4.setVisible(true);
            PCS4.setSize(370, 600);
        }
    }

    public static void main(String[] args) {
        ProfileCreationScreen3 frame = new ProfileCreationScreen3();
        frame.setTitle("Profile Creation Screen");
        frame.setVisible(true);
        frame.setBounds(10, 10, 370, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}