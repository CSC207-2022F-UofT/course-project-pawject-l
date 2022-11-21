package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginScreen extends JFrame implements ActionListener {

    // The username chosen by the user
    JTextField username = new JTextField(20);

    // The password
    JPasswordField password = new JPasswordField(15);

    public LoginScreen() {

        JLabel title = new JLabel("Login Screen");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        LabelTextPanel usernameInfo = new LabelTextPanel(new JLabel("Username"), username);
        LabelTextPanel passwordInfo = new LabelTextPanel(new JLabel("Password"), password);

        JButton login = new JButton("Log in");


        JPanel buttons = new JPanel();
        buttons.add(login);

        login.addActionListener(this);

        JPanel main = new JPanel();
        main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));

        main.add(title);
        main.add(usernameInfo);
        main.add(passwordInfo);
        main.add(login);
        this.setContentPane(main);

        this.pack();

    }

    public void actionPerformed(ActionEvent evt) {}

}
