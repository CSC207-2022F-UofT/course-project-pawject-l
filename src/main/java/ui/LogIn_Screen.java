package ui;

import controller.AccountController;
import controller.ChatController;
import controller.GeneralController;
import controller.MatchManagerController;
import entities.User;
import repo.*;
import useCase.*;
import useCase.Account.AccountInputBoundary;
import useCase.Account.AccountModel;
import repo.UserDataAccessInterface;

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

    public LogIn_Screen(AccountController ctrl1, GeneralController ctrl2, MatchManagerController ctrl3,
                        ChatController ctrl4) {
        this.accCtrl = ctrl1;
        this.genCtrl = ctrl2;
        this.matchCtrl = ctrl3;
        this.chatCtrl = ctrl4;
        container.setLayout(null);

        titleLabel.setBounds(150, 70, 100, 30);
        usernameLabel.setBounds(60, 150, 100, 30);
        passwordLabel.setBounds(60, 220, 100, 30);
        usernameField.setBounds(160, 150, 150, 30);
        passwordField.setBounds(160, 220, 150, 30);
        loginButton.setBounds(120, 320, 100, 30);
        signupButton.setBounds(80, 400, 200, 30);

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

                    UserDataAccessInterface userDS = new UserDataAccess("src/main/java/data/user.csv");
                    PetDataAccessInterface petDS = new PetDataAccess();

                    // initiate home screen
                    User user = userDS.getUser(userText);
                    String petId = petDS.getPetIdByUser(user);
                    Homescreen hs = new Homescreen(petId, genCtrl, matchCtrl, chatCtrl, accCtrl);
                    //hs.setVisible(true);
                    //this.setVisible(false);
                    //hs.setSize(370, 600);
                }
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
        if (e.getSource() == signupButton) {
            SignUpScreen signupScreen = new SignUpScreen(accCtrl);
            this.setVisible(false);
            signupScreen.setVisible(true);
            signupScreen.setSize(370, 600);
        }
    }

    public static void main(String[] args) throws IOException {
        PetDataAccessInterface petDS = new PetDataAccess();
        ChatDataAccessInterface chatDS = new ChatDataAccess();
        UserDataAccessInterface userDS = new UserDataAccess("src/main/java/data/user.csv");
        userDS.saveUser("001", "user1", "ilovemydog");


        FPMAInputBoundary fpma = new FPMA(petDS);
        GeneralController genCtrl = new GeneralController(fpma);

        ChatManagerInputBoundary chat = new ChatManager(chatDS);
        ChatController chatCtrl = new ChatController(chat);

        MatchManagerInputBoundary match = new MatchManager(petDS);
        MatchManagerController matchCtrl = new MatchManagerController(match, chat);

        AccountInputBoundary acc = new AccountModel(userDS);
        AccountController accCtrl = new AccountController(acc);

        LogIn_Screen login = new LogIn_Screen(accCtrl, genCtrl, matchCtrl, chatCtrl);
        login.setTitle("Log in Screen");
        login.setVisible(true);
        login.setBounds(0, 0, 370, 600);
        login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        login.setResizable(false);
    }

//    public static void main(String[] args) {
//        UserDataAccessInterface user;
//        try {
//            user = new UserDataAccess("./user1.csv");
//        } catch (IOException e) {
//            throw new RuntimeException("Could not create file.");
//        }
//
//        AccountInputBoundary interactor = new AccountModel(user);
//
//        AccountController control = new AccountController(interactor);
//        LogIn_Screen frame = new LogIn_Screen(control);
//
//        frame.setTitle("Log in Screen");
//        frame.setVisible(true);
//        frame.setBounds(0, 0, 370, 600);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setResizable(false);
//    }
}
