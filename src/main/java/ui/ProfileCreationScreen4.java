package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ProfileCreationScreen4 extends JFrame implements ActionListener {
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

    JLabel page = new JLabel("Page 4/4");
    JButton submitProfileButton = new JButton("Submit Profile");



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
        page.setBounds(60, 520, 100, 30);
        submitProfileButton.setBounds(200, 520, 150, 40);

    }

    public void addComponentsToContainer() {
        container.add(titleLabel);
        container.add(availableDaysLabel);
        for(JCheckBox d: availableDaysChoices){
            container.add(d);
        }
        container.add(page);
        container.add(submitProfileButton);
    }

    public void setFonts(){
        titleLabel.setFont(f1);
        for(JCheckBox d: availableDaysChoices){
            d.setFont(f2);
        }
        page.setFont(f2);
        submitProfileButton.setFont(f3);
    }

    public void addActionEvent() {
        submitProfileButton.addActionListener(this);

    }

    public ProfileCreationScreen4(){
        setLayoutManager();
        setPositionAndSize();
        addComponentsToContainer();
        addActionEvent();
        setFonts();
    }


    @Override
    public void actionPerformed(ActionEvent evt) {
        if(evt.getSource() == submitProfileButton){
            JOptionPane.showMessageDialog(this,"Profiled created!");
        }
    }

    public static void main(String[] args) {
        ProfileCreationScreen4 frame = new ProfileCreationScreen4();
        frame.setTitle("Profile Creation Screen");
        frame.setVisible(true);
        frame.setBounds(10, 10, 370, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}