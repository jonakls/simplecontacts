package me.jonakls.simplecontacts.ui;

import javax.swing.*;

public class LoginForm extends JDialog {
    private JPanel loginPane;
    private JPanel imagePanel;
    private JPanel contentPane;
    private JLabel imageIcon;
    private JLabel titleLabel;
    private JLabel loginTitle;
    private JTextField inputUser;
    private JPasswordField inputPassword;
    private JButton registerButton;
    private JButton loginButton;

    public LoginForm(JFrame parent) {
        super(parent);
        setContentPane(loginPane);
        setTitle("SimpleContact | Ingresar");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(900, 600);
        setLocationRelativeTo(null);
        setVisible(true);
        toRegisterForm();
    }

    private void toRegisterForm() {
        registerButton.addActionListener(e -> {
            dispose();
            RegisterForm registerForm = new RegisterForm(null);
        });
    }
}
