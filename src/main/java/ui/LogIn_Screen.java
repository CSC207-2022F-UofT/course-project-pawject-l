package ui;

import controller.AccountController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

//    SignUpScreen signupScreen = new SignUpScreen();


    public void setLayoutManager() {
        container.setLayout(null);
    }

    public void setLocationAndSize() {
        titleLabel.setBounds(150, 70, 100, 30);
        usernameLabel.setBounds(60, 150, 100, 30);
        passwordLabel.setBounds(60, 220, 100, 30);
        usernameField.setBounds(160, 150, 150, 30);
        passwordField.setBounds(160, 220, 150, 30);
        loginButton.setBounds(120, 320, 100, 30);
        signupButton.setBounds(80, 400, 200, 30);
    }

    public void addComponentsToContainer() {
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
        signupButton.setFont(f1);
        loginButton.setFont(f1);
    }

    public void addActionEvent() {
        loginButton.addActionListener(this);
        signupButton.addActionListener(this);
    }

    public LogIn_Screen() {
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
//        Coding Part of Log In button
        if (e.getSource() == loginButton) {
            String userText = usernameField.getText();
            String pwdText = passwordField.getText();

            if (AccountController.userExists(userText, pwdText) == false) {
                JOptionPane.showMessageDialog(this, "This username doesn't exist. Please create an account.");
            } else if (AccountController.correctPassword(userText, pwdText) == false) {
                JOptionPane.showMessageDialog(this, "Username or password is incorrect. Please try again.");
            } else {
                JOptionPane.showMessageDialog(this, "Logged in.");
            }
//        } else if (e.getSource() == signupButton) {
//            this.dispose();
//            signupScreen.setVisible(true);
//            signupScreen.setSize(370, 600);
//        }
    }
    }

    public static void main(String[] args) {
        LogIn_Screen frame = new LogIn_Screen();
        frame.setTitle("Log in Screen");
        frame.setVisible(true);
        frame.setBounds(10, 10, 370, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
    }
}
