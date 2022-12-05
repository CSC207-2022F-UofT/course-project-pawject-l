package ui;

import controller.*;

import entities.Pet;
import entities.User;
import repo.*;
import useCase.Account.AccountInputBoundary;
import useCase.Account.AccountModel;
import useCase.Chat.ChatManager;
import useCase.Chat.ChatManagerInputBoundary;
import useCase.FPMA.FPMA;
import useCase.FPMA.FPMAInputBoundary;

import useCase.FPMA.FPMAResponseModel;
import useCase.Match.MatchManager;
import useCase.Match.MatchManagerInputBoundary;
import useCase.Profile.ProfileInputBoundary;
import useCase.Profile.ProfileManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.time.DayOfWeek;

public class Homescreen extends JFrame implements ActionListener {

    GeneralController generalCtrl;
    MatchManagerController matchCtrl;
    ChatController chatCtrl;
    AccountController accCtrl;
    ProfileController profileCtrl;

    JButton likeButton = new JButton("Like");
    JButton dislikeButton = new JButton("Dislike");
    JButton homeButton = new JButton("Home");
    JButton chatButton = new JButton("Chat");
    JButton profileButton = new JButton("Profile");
    JButton logoutButton = new JButton("Logout");
    int curr = 0;
    String petId;

    public Homescreen(String id, GeneralController ctrl1, MatchManagerController ctrl2,
                      ChatController ctrl3, AccountController ctrl4, ProfileController ctrl5) throws IOException {

        Container container = getContentPane();
        container.setLayout(null);

        this.generalCtrl = ctrl1;
        this.matchCtrl = ctrl2;
        this.chatCtrl = ctrl3;
        this.accCtrl = ctrl4;
        this.profileCtrl = ctrl5;
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
                if (listOfPotentialMatches.getPetAt(curr) == null) {
                    JLabel msg = new JLabel("You have no matches yet.");
                    container.remove(currPet);
                    msg.setBounds(170, 10, 500, 450);
                    container.add(msg);
                    container.validate();
                    container.repaint();
                } else {
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
                if (listOfPotentialMatches.getPetAt(curr) == null) {
                    JLabel msg = new JLabel("You have no matches yet.");
                    container.remove(currPet);
                    msg.setBounds(170, 10, 500, 450);
                    container.add(msg);
                    container.validate();
                    container.repaint();
                } else {
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
            }
        });
        this.setVisible(true);
        this.setBounds(500, 700, 500, 700);
        this.setTitle("Home screen");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == profileButton) {
            PetDataAccessInterface petDS = new PetDataAccess();
            Pet userPet = null;
            try {
                userPet = petDS.getPetById(petId);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            String prefSpecies = "";
            for (String species: userPet.getPreferredAttributes().getSpecies()) {
                prefSpecies = prefSpecies + species + ", ";
            }
            String prefBreed = "";
            for (String breed: userPet.getPreferredAttributes().getBreed()) {
                prefBreed = prefBreed + breed + ", ";
            }
            String prefAge = "";
            for (int age: userPet.getPreferredAttributes().getAge()) {
                prefAge = prefAge + String.valueOf(age) + ", ";
            }
            String prefVacc = "";
            if (userPet.getPreferredAttributes().isVaccinated()) {
                prefVacc = "Vaccinated";
            } else {
                prefVacc = "N/A";
            }
            String availability = "";
            for (DayOfWeek day: userPet.getAvailableDay()) {
                availability = availability + day.toString().toLowerCase() + ", ";
            }
            FullProfileScreen profile = new FullProfileScreen(userPet.getName(),
                    new ImageIcon(userPet.getImages().get(0)), userPet.getDescription(),
                    userPet.getAttributes().getAge().get(0).toString(),
                    userPet.getAttributes().getBreed().get(0), userPet.getAttributes().getSpecies().get(0),
                    new ImageIcon(userPet.getProofOfVaccination()), userPet.getAttributes().getGender(),prefSpecies,
                    prefBreed, prefAge, String.valueOf(userPet.getPreferredProximity()) + "km",prefVacc,
                    availability,
                    String.valueOf(userPet.getLongitude()) + ", " + String.valueOf(userPet.getLatitude()));
            profile.setTitle("Full profile");
        } else if (e.getSource() == chatButton){
            ChatsScreen CU = new ChatsScreen();
            CU.loadChatUI(chatCtrl, petId);
        } else if (e.getSource() == logoutButton) {
            LogIn_Screen LS = new LogIn_Screen(accCtrl, generalCtrl, matchCtrl, chatCtrl, profileCtrl);
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
        UserDataAccessInterface userDS = new UserDataAccess("src/main/user.csv");
        User user = new User("004", "nomiko", "20020626", "PET ID:1", "0");
        userDS.save(user);

        FPMAInputBoundary fpma = new FPMA(petDS);
        GeneralController genCtrl = new GeneralController(fpma);

        ChatManagerInputBoundary chat = new ChatManager(chatDS);
        ChatController chatCtrl = new ChatController(chat);

        MatchManagerInputBoundary match = new MatchManager(petDS);
        MatchManagerController matchCtrl = new MatchManagerController(match, chat);

        AccountInputBoundary acc = new AccountModel(userDS);
        AccountController accCtrl = new AccountController(acc);

        ProfileInputBoundary prof = new ProfileManager(petDS);
        ProfileController profCtrl = new ProfileController(prof);

        Homescreen h = new Homescreen("PET ID:3", genCtrl, matchCtrl, chatCtrl, accCtrl, profCtrl);
    }
}


