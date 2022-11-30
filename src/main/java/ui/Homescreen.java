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

    Container container = getContentPane();

    JButton likeButton = new JButton("Like");
    JButton dislikeButton = new JButton("Dislike");
    JButton homeButton = new JButton("Home");
    JButton chatButton = new JButton("Chat");
    JButton profileButton = new JButton("Profile");
    int curr = 0;

    public Homescreen(GeneralController ctrl1, String petId, MatchManagerController ctrl2) throws IOException {

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
        curr++;

        currPet.setBounds(100, 20, 350, 350);
        likeButton.setBounds(210, 470, 150, 50);
        dislikeButton.setBounds(5, 470, 150, 50);
        profileButton.setBounds(0, 540, 130, 30);
        homeButton.setBounds(122, 540, 130, 30);
        chatButton.setBounds(244, 540, 130, 30);

        container.add(currPet);
        container.add(likeButton);
        container.add(dislikeButton);
        container.add(homeButton);
        container.add(chatButton);

        profileButton.addActionListener(this);
        chatButton.addActionListener(this);
        likeButton.addActionListener(this);
        dislikeButton.addActionListener(this);
        JButton buttons = new JButton();
        buttons.add(likeButton);
        buttons.add(dislikeButton);
        buttons.addActionListener(new ActionListener() {
                                      @Override
                                      public void actionPerformed(ActionEvent e) {
                                          if (curr < listOfPotentialMatches.getListOfPotentialMatches().length) {
                                              PreviewProfileScreen currPet = new PreviewProfileScreen(
                                                      listOfPotentialMatches.getPetNameAt(curr),
                                                      new ImageIcon(listOfPotentialMatches.getPetImageAt(curr)),
                                                      listOfPotentialMatches.getPetBioAt(curr),
                                                      listOfPotentialMatches.getPetAgeAt(curr).toString(),
                                                      listOfPotentialMatches.getPetBreedAt(curr),
                                                      listOfPotentialMatches.getPetSpeciesAt(curr),
                                                      new ImageIcon(listOfPotentialMatches.getPetVaccineAt(curr)));
                                              curr++;
                                          }
                                      }
                                  }
        );
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //if(e.getSource() == profileButton){
        //PreferencesEditScreen profileEditScreen = new PreferencesEditScreen();
        //this.setVisible(false);
        //profileEditScreen.setVisible(true);
        //profileEditScreen.setSize(370, 600);

        if (e.getSource() == likeButton) {
        }
    }
}


