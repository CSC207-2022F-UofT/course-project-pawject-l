package ui;

import controller.ChatController;
import controller.GeneralController;
import controller.MatchManagerController;
import controller.AccountController;

import entities.Pet;
import repo.*;
import useCase.*;
import useCase.Account.AccountInputBoundary;
import useCase.Account.AccountModel;
import repo.FPMAInputBoundary;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Homescreen extends JFrame implements ActionListener {

    GeneralController generalCtrl;
    MatchManagerController matchCtrl;
    ChatController chatCtrl;
    AccountController accCtrl;

    JButton likeButton = new JButton("Like");
    JButton dislikeButton = new JButton("Dislike");
    JButton homeButton = new JButton("Home");
    JButton chatButton = new JButton("Chat");
    JButton profileButton = new JButton("Profile");
    JButton logoutButton = new JButton("Logout");
    int curr = 0;
    String petId;

    public Homescreen(String id, GeneralController ctrl1, MatchManagerController ctrl2,
                      ChatController ctrl3, AccountController ctrl4) throws IOException {

        Container container = getContentPane();
        container.setLayout(null);

        this.generalCtrl = ctrl1;
        this.matchCtrl = ctrl2;
        this.chatCtrl = ctrl3;
        this.accCtrl = ctrl4;
        this.petId = id;


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
        if(e.getSource() == profileButton) {
        } else if (e.getSource() == chatButton){
            ChatsScreen CU = new ChatsScreen();
            CU.loadChatUI(chatCtrl, petId);
        } else if (e.getSource() == logoutButton) {
            LogIn_Screen LS = new LogIn_Screen(accCtrl, generalCtrl, matchCtrl, chatCtrl);
            LS.setTitle("Log in Screen");
            LS.setVisible(true);
            LS.setBounds(0, 0, 370, 600);
            LS.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            LS.setResizable(false);
            this.setVisible(false);
        }

    }

    public static void main(String[] args) throws IOException {
        PetDataAccessInterface petDS = new PetDataAccess();
        ChatDataAccessInterface chatDS = new ChatDataAccess();
        UserDataAccessInterface userDS = new UserDataAccess("./user1.csv");
        // userDS.saveUser("001", "user1", "ilovemydog");

        FPMAInputBoundary fpma = new FPMA(petDS);
        GeneralController genCtrl = new GeneralController(fpma);

        ChatManagerInputBoundary chat = new ChatManager(chatDS);
        ChatController chatCtrl = new ChatController(chat);

        MatchManagerInputBoundary match = new MatchManager(petDS);
        MatchManagerController matchCtrl = new MatchManagerController(match, chat);

        AccountInputBoundary acc = new AccountModel(userDS);
        AccountController accCtrl = new AccountController(acc);

        Homescreen h = new Homescreen("PET ID:1", genCtrl, matchCtrl, chatCtrl, accCtrl);
        h.setVisible(true);
    }
}


