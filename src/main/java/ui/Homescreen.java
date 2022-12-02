package ui;

import controller.GeneralController;
import controller.MatchManagerController;

import useCase.FPMAResponseModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Homescreen extends JFrame implements ActionListener {

    GeneralController generalCtrl;
    MatchManagerController matchCtrl;

    JButton likeButton = new JButton("Like");
    JButton dislikeButton = new JButton("Dislike");
    JButton homeButton = new JButton("Home");
    JButton chatButton = new JButton("Chat");
    JButton profileButton = new JButton("Profile");
    JButton logoutButton = new JButton("Logout");
    int curr = 0;

    public Homescreen(GeneralController ctrl1, String petId, MatchManagerController ctrl2) throws IOException {

        Container container = getContentPane();
        container.setLayout(null);

        this.generalCtrl = ctrl1;
        this.matchCtrl = ctrl2;


        FPMAResponseModel listOfPotentialMatches = generalCtrl.getPotentialCandidates(petId);
        PreviewProfileScreen currPet = new PreviewProfileScreen(listOfPotentialMatches.getPetNameAt(curr),
                new ImageIcon(listOfPotentialMatches.getPetImageAt(curr)),
                listOfPotentialMatches.getPetBioAt(curr),
                listOfPotentialMatches.getPetAgeAt(curr).toString(),
                listOfPotentialMatches.getPetBreedAt(curr),
                listOfPotentialMatches.getPetSpeciesAt(curr),
                new ImageIcon(listOfPotentialMatches.getPetVaccineAt(curr)));

        currPet.setBounds(0, 10, 500, 450);
        likeButton.setBounds(100, 470, 150, 50);
        dislikeButton.setBounds(250, 470, 150, 50);
        profileButton.setBounds(0, 540, 130, 30);
        homeButton.setBounds(122, 540, 130, 30);
        chatButton.setBounds(244, 540, 130, 30);
        logoutButton.setBounds(366, 540, 130, 30);

        container.add(currPet);
        container.add(likeButton);
        container.add(dislikeButton);
        container.add(homeButton);
        container.add(chatButton);
        container.add(profileButton);
        container.add(logoutButton);

        profileButton.addActionListener(this);
        chatButton.addActionListener(this);
        homeButton.addActionListener(this);
        logoutButton.addActionListener(this);
        likeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    matchCtrl.manageMatch(petId, listOfPotentialMatches.getPetIdAt(curr), true);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                curr++;
                PreviewProfileScreen newCurrPet = new PreviewProfileScreen(
                        listOfPotentialMatches.getPetNameAt(curr),
                        new ImageIcon(listOfPotentialMatches.getPetImageAt(curr)),
                        listOfPotentialMatches.getPetBioAt(curr),
                        listOfPotentialMatches.getPetAgeAt(curr).toString(),
                        listOfPotentialMatches.getPetBreedAt(curr),
                        listOfPotentialMatches.getPetSpeciesAt(curr),
                        new ImageIcon(listOfPotentialMatches.getPetVaccineAt(curr)));
                container.removeAll();
                newCurrPet.setBounds(0, 10, 500, 450);
                likeButton.setBounds(100, 470, 150, 50);
                dislikeButton.setBounds(250, 470, 150, 50);
                profileButton.setBounds(0, 540, 130, 30);
                homeButton.setBounds(122, 540, 130, 30);
                chatButton.setBounds(244, 540, 130, 30);
                logoutButton.setBounds(366, 540, 130, 30);

                container.add(newCurrPet);
                container.add(likeButton);
                container.add(dislikeButton);
                container.add(profileButton);
                container.add(homeButton);
                container.add(chatButton);
                container.add(logoutButton);
                container.validate();
                container.repaint();
            }
        });
        dislikeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    matchCtrl.manageMatch(petId, listOfPotentialMatches.getPetIdAt(curr), false);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                curr++;
                PreviewProfileScreen newCurrPet = new PreviewProfileScreen(
                        listOfPotentialMatches.getPetNameAt(curr),
                        new ImageIcon(listOfPotentialMatches.getPetImageAt(curr)),
                        listOfPotentialMatches.getPetBioAt(curr),
                        listOfPotentialMatches.getPetAgeAt(curr).toString(),
                        listOfPotentialMatches.getPetBreedAt(curr),
                        listOfPotentialMatches.getPetSpeciesAt(curr),
                        new ImageIcon(listOfPotentialMatches.getPetVaccineAt(curr)));
                container.removeAll();
                newCurrPet.setBounds(0, 10, 500, 450);
                likeButton.setBounds(100, 470, 150, 50);
                dislikeButton.setBounds(250, 470, 150, 50);
                profileButton.setBounds(0, 540, 130, 30);
                homeButton.setBounds(122, 540, 130, 30);
                chatButton.setBounds(244, 540, 130, 30);
                logoutButton.setBounds(366, 540, 130, 30);

                container.add(newCurrPet);
                container.add(likeButton);
                container.add(dislikeButton);
                container.add(profileButton);
                container.add(homeButton);
                container.add(chatButton);
                container.add(logoutButton);
                container.validate();
                container.repaint();
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //if(e.getSource() == profileButton){
        //PreferencesEditScreen profileEditScreen = new PreferencesEditScreen();
        //this.setVisible(false);
        //profileEditScreen.setVisible(true);
        //profileEditScreen.setSize(370, 600);
        //if(e.getSource() == chatButton){
    }
}


