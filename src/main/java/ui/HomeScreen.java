package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

//    AccountController controller;


        public HomeScreen () {
//        this.controller = controller;
//        JPanel panel1 = new JPanel();
//        panel1.add(imageL);
//        this.add(panel1);
//        this.pack();
//        this.setVisible(true);
            container.setLayout(null);

            JLabel imageL = new JLabel();
            imageL.setIcon(new ImageIcon(new ImageIcon("images/dog2.jpeg").getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT)));
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
                        imageL.setIcon(new ImageIcon(new ImageIcon("images/dog.jpeg").getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT)));
                }
            });
            dislikeButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    imageL.setIcon(new ImageIcon(new ImageIcon("images/dog2.jpeg").getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT)));
                }
            });
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == profileButton){
                PreferencesEditScreen profileEditScreen = new PreferencesEditScreen();
                this.setVisible(false);
                profileEditScreen.setVisible(true);
                profileEditScreen.setSize(370, 600);
            }
        }

//        public static void main(String[] args) {
////        AccountInputBoundary input = new AccountModel()
////        AccountController controller = new AccountController()
//            HomeScreen frame = new HomeScreen();
//
//            frame.setTitle("Home Screen");
//            frame.setVisible(true);
//            frame.setBounds(0, 0, 370, 600);
//            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//            frame.setResizable(false);
//            System.out.println(new java.io.File("images/dog.jpeg").exists());
//        }
    }

