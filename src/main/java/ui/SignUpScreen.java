package ui;

import controller.AccountController;
import repo.UserDataAccess;
import repo.UserDataAccessInterface;
import useCase.Account.AccountInputBoundary;
import useCase.Account.AccountModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

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



    AccountController controller;

    public SignUpScreen (AccountController controller) {
        this.controller = controller;
        container.setLayout(null);
        JLabel imageL = new JLabel();
        imageL.setIcon(new ImageIcon(new ImageIcon("images/logo.png").getImage().getScaledInstance(270, 180, Image.SCALE_DEFAULT)));
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
    }

    @Override
    public void actionPerformed(ActionEvent e) {
//        Coding Part of Sign Up button
        if (e.getSource() == signupButton) {
            String userText = usernameField.getText();
            String pwdText = passwordField.getText();
            try {
                if (controller.userExists(userText, pwdText)) {
                    JOptionPane.showMessageDialog(this, "Username already associated to an account. Please log in.");
                } else if (!controller.checkPasswordValid(userText, pwdText)) {
                    JOptionPane.showMessageDialog(this, "Password requirements unmet.");
                } else {
                    JOptionPane.showMessageDialog(this, userText + " created.");
                    controller.create(userText, pwdText);
//                    HomeScreen hs = new HomeScreen(controller);
//                    hs.setVisible(true);
//                    this.setVisible(false);
//                    hs.setSize(370, 600);
                }
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }

        }
        if (e.getSource() == loginButton) {
            LogIn_Screen loginScreen = new LogIn_Screen(controller);
            this.setVisible(false);
            loginScreen.setVisible(true);
            loginScreen.setSize(370, 600);
        }
    }

    public static void main(String[] args) {

        UserDataAccessInterface user;
        try {
            user = new UserDataAccess("./user.csv");
        } catch (IOException e) {
            throw new RuntimeException("Could not create file.");
        }

        AccountInputBoundary interactor = new AccountModel(user);

        AccountController control = new AccountController(interactor);

        SignUpScreen frame = new SignUpScreen(control);
        frame.setTitle("Sign Up Screen");
        frame.setVisible(true);
        frame.setBounds(0, 0, 370, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
    }
}