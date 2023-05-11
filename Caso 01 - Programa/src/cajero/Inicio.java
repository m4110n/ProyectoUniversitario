package cajero;

import javax.swing.*;
import java.awt.event.*;
import java.io.*;

public class Inicio extends JFrame implements ActionListener {
    private JTextField userField;
    private JPasswordField passField;
    private JButton loginButton;
    private JLabel statusLabel;
    
    public Inicio() {
        setTitle("Login");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        JPanel panel = new JPanel();
        add(panel);
        
        JLabel userLabel = new JLabel("Username: ");
        panel.add(userLabel);
        
        userField = new JTextField(15);
        panel.add(userField);
        
        JLabel passLabel = new JLabel("Password: ");
        panel.add(passLabel);
        
        passField = new JPasswordField(15);
        panel.add(passField);
        
        loginButton = new JButton("Login");
        loginButton.addActionListener(this);
        panel.add(loginButton);
        
        statusLabel = new JLabel(" ");
        panel.add(statusLabel);
    }
    
    public void actionPerformed(ActionEvent e) {
        String user = userField.getText();
        String pass = new String(passField.getPassword());
        boolean loggedIn = false;
        
        try {
            BufferedReader reader = new BufferedReader(new FileReader("users.txt"));
            String line = reader.readLine();
            while (line != null) {
                String[] parts = line.split(";");
                if (parts[0].equals(user) && parts[1].equals(pass)) {
                    loggedIn = true;
                    break;
                }
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
        if (loggedIn) {
            statusLabel.setText("Login successful");
            CajeroAutomatico cajeroAutomatico = new CajeroAutomatico();
            cajeroAutomatico.ejecutarCajero();      
        } else {
            statusLabel.setText("Incorrect username or password");
        }
    }
    
    public static void main(String[] args) {
        Inicio frame = new Inicio();
        frame.setVisible(true);
    }
}