package me.jonakls.simplecontacts.ui;

import javax.swing.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegisterForm extends JDialog {
    private JPanel registerPane;
    private JPanel imagePanel;
    private JLabel imageIcon;
    private JLabel titleLabel;
    private JPanel contentPane;
    private JLabel loginTitle;
    private JTextField inputUser;
    private JPasswordField inputPassword;
    private JButton registerButton;
    private JButton loginButton;
    private JTextField inputName;
    private JTextField inputSecondName;
    private JTextField inputPhone;
    private JTextField inputMail;

    public RegisterForm(JFrame parent) {
        super(parent);
        setContentPane(registerPane);
        setTitle("SimpleContact | Registrarse");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(1000, 600);
        setLocationRelativeTo(null);
        setVisible(true);
        toLoginForm();
        onRegisterUser();
    }

    private void toLoginForm() {
        loginButton.addActionListener(e -> {
            dispose();
            new LoginForm(null);
        });
    }

    private void onRegisterUser() {
        final Pattern pattern = Pattern.compile("^[a-zA-Z0-9]*$");

        loginButton.addActionListener(e -> {
            Matcher matcher = pattern.matcher(inputUser.getText());

            if (matcher.find()) {
                inputUser.setText("");
                JOptionPane.showMessageDialog(null, "El usuario no puede contener caracteres especiales");
            }
        });
    }
}
