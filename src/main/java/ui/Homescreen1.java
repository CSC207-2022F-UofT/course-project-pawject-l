package ui;

import entities.Pet;
import repo.PetDataAccess;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

public class Homescreen1 extends JFrame implements ActionListener {
    JButton likeButton = new JButton("Like");
    JButton dislikeButton = new JButton("Dislike");
    JButton homeButton = new JButton("Home");
    JButton chatButton = new JButton("Chat");
    JButton profileButton = new JButton("Profile");
    JButton logoutButton = new JButton("Logout");
    int curr = 0;
    public Homescreen1(ArrayList<Pet> pets) {
        Container container = getContentPane();
        container.setLayout(null);

        PreviewProfileScreen currPet = new PreviewProfileScreen(pets.get(curr).getName(),
                new ImageIcon(pets.get(curr).getImages().get(0)),
                pets.get(curr).getDescription(),
                pets.get(curr).getAttributes().getAge().get(0).toString(),
                pets.get(curr).getAttributes().getBreed().get(0),
                pets.get(curr).getAttributes().getSpecies().get(0),
                new ImageIcon(pets.get(curr).getProofOfVaccination()));

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
        container.add(profileButton);
        container.add(homeButton);
        container.add(chatButton);
        container.add(logoutButton);

        profileButton.addActionListener(this);
        chatButton.addActionListener(this);
        logoutButton.addActionListener(this);
        homeButton.addActionListener(this);
        likeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                container.removeAll();
                curr++;
                PreviewProfileScreen newCurrPet = new PreviewProfileScreen(pets.get(curr).getName(),
                        new ImageIcon(pets.get(curr).getImages().get(0)),
                        pets.get(curr).getDescription(),
                        pets.get(curr).getAttributes().getAge().get(0).toString(),
                        pets.get(curr).getAttributes().getBreed().get(0),
                        pets.get(curr).getAttributes().getSpecies().get(0),
                        new ImageIcon(pets.get(curr).getProofOfVaccination()));
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
                container.removeAll();
                curr++;
                PreviewProfileScreen newCurrPet = new PreviewProfileScreen(pets.get(curr).getName(),
                        new ImageIcon(pets.get(curr).getImages().get(0)),
                        pets.get(curr).getDescription(),
                        pets.get(curr).getAttributes().getAge().get(0).toString(),
                        pets.get(curr).getAttributes().getBreed().get(0),
                        pets.get(curr).getAttributes().getSpecies().get(0),
                        new ImageIcon(pets.get(curr).getProofOfVaccination()));
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
                container.validate();
                container.repaint();

            }
        });
        this.setBounds(500, 650, 500, 650);
        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

    public static void main(String[] args) throws IOException {
        PetDataAccess ds = new PetDataAccess();
        Pet p1 = ds.getPetById("PET ID:1");
        Pet p2 = ds.getPetById("PET ID:2");
        ArrayList<Pet> pets = new ArrayList<>();
        pets.add(p1);
        pets.add(p2);
        Homescreen1 h1 = new Homescreen1(pets);
    }
}
