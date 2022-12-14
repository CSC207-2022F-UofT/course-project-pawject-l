package ui;

import controller.*;
import entities.User;
import repo.*;
import useCase.Account.AccountInputBoundary;
import useCase.Account.AccountModel;
import repo.UserDataAccessInterface;
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

public class LogIn_Screen extends JFrame implements ActionListener {
    Font f1 = new Font("Arial", Font.PLAIN,  12);
    Font f3 = new Font("Arial", Font.PLAIN,  20);
    Container container = getContentPane();
    JLabel titleLabel = new JLabel("Log In");
    JLabel usernameLabel = new JLabel("Enter Username");
    JLabel passwordLabel = new JLabel("Enter Password");
    JTextField usernameField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JButton loginButton = new JButton("Log In");
    JButton signupButton = new JButton("Don't have an account? Sign up.");

    AccountController accCtrl;
    GeneralController genCtrl;
    MatchManagerController matchCtrl;
    ChatController chatCtrl;
    ProfileController profileCtrl;

    public LogIn_Screen(AccountController ctrl1, GeneralController ctrl2, MatchManagerController ctrl3,
                        ChatController ctrl4, ProfileController ctrl5) {
        this.accCtrl = ctrl1;
        this.genCtrl = ctrl2;
        this.matchCtrl = ctrl3;
        this.chatCtrl = ctrl4;
        this.profileCtrl = ctrl5;
        container.setLayout(null);

        JLabel imageL = new JLabel();
        imageL.setIcon(new ImageIcon(new ImageIcon("src/main/java/data/logo.jpg.png").getImage().getScaledInstance(270, 180, Image.SCALE_DEFAULT)));
        imageL.setBounds(50, 10, 270, 180);
        container.add(imageL);

        titleLabel.setBounds(150, 210, 100, 30);
        usernameLabel.setBounds(60, 250, 100, 30);
        passwordLabel.setBounds(60, 320, 100, 30);
        usernameField.setBounds(160, 250, 150, 30);
        passwordField.setBounds(160, 320, 150, 30);
        loginButton.setBounds(120, 420, 100, 30);
        signupButton.setBounds(80, 500, 200, 30);

        container.add(titleLabel);
        container.add(usernameLabel);
        container.add(passwordLabel);
        container.add(usernameField);
        container.add(passwordField);
        container.add(signupButton);
        container.add(loginButton);

        titleLabel.setFont(f3);
        passwordLabel.setFont(f1);
        usernameLabel.setFont(f1);
        usernameField.setFont(f1);
        passwordField.setFont(f1);

        loginButton.addActionListener(this);
        signupButton.addActionListener(this);

        this.setVisible(true);
        this.setBounds(0,0,370, 600);
        this.setTitle("Log in Screen");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
//        Coding Part of Log In button
        if (e.getSource() == loginButton) {
            String userText = usernameField.getText();
            String pwdText = passwordField.getText();

            try {
                if (!accCtrl.userExists(userText, pwdText)) {
                    JOptionPane.showMessageDialog(this, "This username doesn't exist. Please create an account.");
                } else if (!accCtrl.correctPassword(userText, pwdText)) {
                    JOptionPane.showMessageDialog(this, "Username or password is incorrect. Please try again.");
                } else {
                    JOptionPane.showMessageDialog(this, "Logged in.");

                    UserDataAccessInterface userDS = new UserDataAccess();
                    PetDataAccessInterface petDS = new PetDataAccess();

                    //initiate home screen
                    User user = userDS.getUserByUsername(userText);
                    String petId = petDS.getPetIdByUser(user);
                    this.setVisible(false);
                    Homescreen hs = new Homescreen(petId, genCtrl, matchCtrl, chatCtrl, accCtrl, profileCtrl);
                    this.validate();
                    this.repaint();
                }
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
        if (e.getSource() == signupButton) {
            SignUpScreen signupScreen = new SignUpScreen(accCtrl, profileCtrl, genCtrl, matchCtrl, chatCtrl);
            this.setVisible(false);
            signupScreen.setVisible(true);
            signupScreen.setSize(370, 600);
        }
    }

    public static void main(String[] args) throws IOException {
        PetDataAccessInterface petDS = new PetDataAccess();
        ChatDataAccessInterface chatDS = new ChatDataAccess();
        UserDataAccessInterface userDS = new UserDataAccess();

        FPMAInputBoundary fpma = new FPMA(petDS);
        GeneralController genCtrl = new GeneralController(fpma);

        ChatManagerInputBoundary chat = new ChatManager(chatDS);
        ChatController chatCtrl = new ChatController(chat);

        MatchManagerInputBoundary match = new MatchManager(petDS);
        MatchManagerController matchCtrl = new MatchManagerController(match, chat);

        AccountInputBoundary acc = new AccountModel(userDS);
        AccountController accCtrl = new AccountController(acc);

        ProfileInputBoundary prof = new ProfileManager(petDS);
        ProfileController profileCtrl = new ProfileController(prof);

        LogIn_Screen login = new LogIn_Screen(accCtrl, genCtrl, matchCtrl, chatCtrl, profileCtrl);
    }
}
