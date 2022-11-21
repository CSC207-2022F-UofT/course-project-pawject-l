package ui;

import controller.AccountController;
import userCase.Account.AccountInputBoundary;
import userCase.Account.AccountModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

    LogInScreen loginScreen = new LogInScreen();

    public void setLayoutManager() {
        container.setLayout(null);
    }

    public void setLocationAndSize() {
        titleLabel.setBounds(150, 70, 100, 30);
        usernameLabel.setBounds(60, 150, 100, 30);
        passwordLabel.setBounds(60, 220, 100, 30);
        passwordMessageLabel.setBounds(50, 250, 300, 30);
        usernameField.setBounds(160, 150, 150, 30);
        passwordField.setBounds(160, 220, 150, 30);
        signupButton.setBounds(120, 320, 100, 30);
        loginButton.setBounds(80, 400, 200, 30);
    }

    public void addComponentsToContainer() {
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
        signupButton.setFont(f1);
        loginButton.setFont(f1);
        passwordMessageLabel.setFont(f2);
    }

    public void addActionEvent() {
        signupButton.addActionListener(this);
        loginButton.addActionListener(this);
    }

//    AccountController controller;

    public SignUpScreen () {
//        this.controller = controller;
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
//        Coding Part of Sign Up button
        if (e.getSource() == signupButton) {
            String userText = usernameField.getText();
            String pwdText = passwordField.getText();

            if (AccountController.checkPasswordValid(userText, pwdText) == false) {
                JOptionPane.showMessageDialog(this, "Password requirements unmet.");
            } else if (AccountController.userExists(userText, pwdText) == true) {
                JOptionPane.showMessageDialog(this, "Username already associated to an account. Please log in.");
            } else {
                AccountController.createUser(userText, pwdText);
                JOptionPane.showMessageDialog(this, userText + " created.");
            }
        }
        if (e.getSource() == loginButton) {
            this.dispose();
            loginScreen.setVisible(true);
            loginScreen.setSize(370, 600);
        }
    }

    public static void main(String[] args) {
//        AccountInputBoundary input = new AccountModel()
//        AccountController controller = new AccountController()
        SignUpScreen frame = new SignUpScreen();
        frame.setTitle("Sign Up Screen");
        frame.setVisible(true);
        frame.setBounds(10, 10, 370, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
    }
}