package ui;

import controller.AccountController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.io.IOException;

public class HomeScreen extends JFrame implements ActionListener{

    Font f1 = new Font("Arial", Font.PLAIN,  12);
    Font f2 = new Font("Arial", Font.PLAIN,  10);
    Font f3 = new Font("Rockwell", Font.PLAIN,  20);
    Container container = getContentPane();
    JLabel nameLabel = new JLabel("Name");
    JLabel speciesLabel = new JLabel("Species: " + "");
    JLabel breedLabel = new JLabel("Breed: " + "");
    JLabel ageLabel = new JLabel("Age: " + "");
    JLabel genderLabel = new JLabel("Gender: " + "");
    JLabel vaccinationLabel = new JLabel("Vaccination Status: " + "");

    JButton likeButton = new JButton("Like");
    JButton dislikeButton = new JButton("Dislike");

    JButton homeButton = new JButton("Home");
    JButton chatButton = new JButton("Chat");
    JButton profileButton = new JButton("Profile");

    AccountController controller;
    ArrayList<String> arr = new ArrayList<String>(4);
    int i = 0;
    int b = 0;


    public HomeScreen (AccountController controller) {
        this.controller = controller;
        container.setLayout(null);
        arr.add("images/dog.jpeg");
        arr.add("images/dog2.jpeg");
        arr.add("images/dog3.jpeg");
        arr.add("images/dog4.jpeg");
        arr.add("images/dog5.png");

        JLabel imageL = new JLabel();
        imageL.setIcon(new ImageIcon(new ImageIcon(arr.get(0)).getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT)));
        imageL.setBounds(35, 10, 300, 300);
        container.add(imageL);

        nameLabel.setBounds(10, 325, 100, 30);
        speciesLabel.setBounds(10, 350, 100, 30);
        breedLabel.setBounds(10, 370, 100, 30);
        ageLabel.setBounds(10, 390, 300, 30);
        genderLabel.setBounds(10, 410, 300, 30);
        vaccinationLabel.setBounds(10, 430, 300, 30);
        likeButton.setBounds(210, 470, 150, 50);
        dislikeButton.setBounds(5, 470, 150, 50);
        profileButton.setBounds(0, 540, 130, 30);
        homeButton.setBounds(122, 540, 130, 30);
        chatButton.setBounds(244, 540, 130, 30);

        container.add(nameLabel);
        container.add(speciesLabel);
        container.add(breedLabel);
        container.add(ageLabel);
        container.add(genderLabel);
        container.add(vaccinationLabel);
        container.add(likeButton);
        container.add(dislikeButton);
        container.add(homeButton);
        container.add(profileButton);
        container.add(chatButton);

        nameLabel.setFont(f3);
        speciesLabel.setFont(f1);
        breedLabel.setFont(f1);
        ageLabel.setFont(f1);
        genderLabel.setFont(f1);
        vaccinationLabel.setFont(f1);

        profileButton.addActionListener(this);
        chatButton.addActionListener(this);

        likeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                i = i + 1;
                b = b + 1;
                imageL.setIcon(new ImageIcon(new ImageIcon(arr.get(i)).getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT)));
                if (b % 4 == 0) {
                    i = -1;
                }
            }
        });
        dislikeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                i--;
                imageL.setIcon(new ImageIcon(new ImageIcon(arr.get(i)).getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT)));
                if (i == -1) {
                    i = 5;
                }
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == profileButton){
            PreferencesEditScreen profileEditScreen = new PreferencesEditScreen(controller);
            this.setVisible(false);
            profileEditScreen.setVisible(true);
            profileEditScreen.setSize(370, 600);
        }
    }
}

