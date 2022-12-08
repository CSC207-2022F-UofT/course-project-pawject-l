package ui;

import controller.*;
import repo.*;
import useCase.Account.AccountInputBoundary;
import useCase.Account.AccountModel;
import useCase.Chat.ChatManager;
import useCase.Chat.ChatManagerInputBoundary;
import useCase.FPMA.FPMA;
import useCase.FPMA.FPMAInputBoundary;
import useCase.Match.MatchManager;
import useCase.Match.MatchManagerInputBoundary;
import useCase.Profile.ProfileInputBoundary;
import useCase.Profile.ProfileManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.UUID;

public class SignUpScreen extends JFrame implements ActionListener {
    Font f1 = new Font("Arial", Font.PLAIN,  12);
    Font f2 = new Font("Arial", Font.PLAIN,  9);
    Font f3 = new Font("Arial", Font.PLAIN,  20);
    Container container = getContentPane();
    JLabel titleLabel = new JLabel("Sign Up");
    JLabel usernameLabel = new JLabel("Enter Username");
    JLabel passwordLabel = new JLabel("Enter Password");
    JLabel passwordMessageLabel = new JLabel("<html>Password must have at least 6 characters, one lowercase and one uppercase character, one number, no spaces</html>");
    JTextField usernameField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JButton signupButton = new JButton("Sign up");
    JButton loginButton = new JButton("Have an account? Log in.");



    AccountController accCtrl;
    ProfileController profileCtrl;
    GeneralController genCtrl;
    MatchManagerController matchCtrl;
    ChatController chatCtrl;
    String PetId;

    public SignUpScreen (AccountController ctrl1, ProfileController ctrl2, GeneralController ctrl3,
                         MatchManagerController ctrl4, ChatController ctrl5) {
        this.accCtrl = ctrl1;
        this.profileCtrl = ctrl2;
        this.genCtrl = ctrl3;
        this.matchCtrl = ctrl4;
        this.chatCtrl = ctrl5;
        this.PetId = String.valueOf(UUID.randomUUID());

        container.setLayout(null);
        JLabel imageL = new JLabel();
        imageL.setIcon(new ImageIcon(new ImageIcon("src/main/java/data/logo.jpg.png").getImage().getScaledInstance(270, 180, Image.SCALE_DEFAULT)));
        imageL.setBounds(50, 10, 270, 180);
        container.add(imageL);

        titleLabel.setBounds(150, 210, 100, 30);
        usernameLabel.setBounds(60, 250, 100, 30);
        passwordLabel.setBounds(60, 320, 100, 30);
        passwordMessageLabel.setBounds(50, 350, 300, 30);
        usernameField.setBounds(160, 250, 150, 30);
        passwordField.setBounds(160, 320, 150, 30);
        signupButton.setBounds(120, 420, 100, 30);
        loginButton.setBounds(80, 500, 200, 30);

        container.add(titleLabel);
        container.add(usernameLabel);
        container.add(passwordLabel);
        container.add(usernameField);
        container.add(passwordField);
        container.add(signupButton);
        container.add(loginButton);
        container.add(passwordMessageLabel);

        titleLabel.setFont(f3);
        passwordLabel.setFont(f1);
        usernameLabel.setFont(f1);
        usernameField.setFont(f1);
        passwordField.setFont(f1);
        passwordMessageLabel.setFont(f2);

        signupButton.addActionListener(this);
        loginButton.addActionListener(this);

        this.setTitle("Sign Up Screen");
        this.setVisible(true);
        this.setBounds(0, 0, 370, 600);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
//        Coding Part of Sign Up button
        if (e.getSource() == signupButton) {
            String userText = usernameField.getText();
            String pwdText = passwordField.getText();
            try {
                if (accCtrl.userExists(userText, pwdText)) {
                    JOptionPane.showMessageDialog(this, "Username already associated to an account. Please log in.");
                } else if (!accCtrl.checkPasswordValid(userText, pwdText)) {
                    JOptionPane.showMessageDialog(this, "Password requirements unmet.");
                } else {
                    JOptionPane.showMessageDialog(this, userText + " created.");
                    accCtrl.create(userText, pwdText, PetId);
                    //profile creation initialized
                    ProfileCreationScreen1 profileCreation = new ProfileCreationScreen1(PetId, profileCtrl, chatCtrl,
                            matchCtrl, accCtrl, genCtrl);
                    this.setVisible(false);
                    this.validate();
                    this.repaint();
                }
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }

        }
        if (e.getSource() == loginButton) {
            LogIn_Screen loginScreen = new LogIn_Screen(accCtrl, genCtrl, matchCtrl, chatCtrl, profileCtrl);
            this.setVisible(false);
            loginScreen.setVisible(true);
            loginScreen.setSize(370, 600);
        }
    }

    public static void main(String[] args) {

        UserDataAccessInterface userDs = new UserDataAccess();
        PetDataAccessInterface petDS = new PetDataAccess();
        ChatDataAccessInterface chatDS = new ChatDataAccess();

        AccountInputBoundary interactor = new AccountModel(userDs);
        AccountController control = new AccountController(interactor);

        FPMAInputBoundary fpma = new FPMA(petDS);
        GeneralController genCtrl = new GeneralController(fpma);

        ChatManagerInputBoundary chat = new ChatManager(chatDS);
        ChatController chatCtrl = new ChatController(chat);

        MatchManagerInputBoundary match = new MatchManager(petDS);
        MatchManagerController matchCtrl = new MatchManagerController(match, chat);

        ProfileInputBoundary prof = new ProfileManager(petDS);
        ProfileController profileCtrl = new ProfileController(prof);

        SignUpScreen s = new SignUpScreen(control, profileCtrl, genCtrl, matchCtrl, chatCtrl);
    }
}