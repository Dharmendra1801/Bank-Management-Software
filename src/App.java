import java.awt.Color;
import java.awt.Font;

import javax.swing.*;

public class App {
    static Frame frame;
    public static void main(String[] args) throws Exception {
        frame = new Frame();
        frame.setTitle("Mishra Bank");

        JLabel label = new JLabel("Welcome to Mishra Bank");
        label.setBounds(135, 20, 800, 40);
        label.setFont(new Font("Ariel", Font.BOLD, 35));
        label.setForeground(Color.blue);
        
        JButton signin_button = new JButton("Sign In");
        signin_button.setBounds(320, 100,100,40);
        signin_button.setFocusable(false);
        signin_button.setForeground(Color.BLUE);
        signin_button.setFont(new Font(null,Font.PLAIN,16));
        
        JButton signup_button = new JButton("Sign Up");
        signup_button.setBounds(620, 20,80,35);
        signup_button.setFocusable(false);
        signup_button.setForeground(Color.BLUE);
        
        JPanel panel = new JPanel();
        panel.setOpaque(true);
        panel.setBounds(0, 240, 720, 240);
        panel.setBackground(Color.ORANGE);
        panel.setLayout(null);
        panel.add(label);
        panel.add(signin_button);
        
        frame.add(panel);
        frame.add(signup_button);
        frame.setVisible(true);
        // User_LogIn.LogIn();

        signin_button.addActionListener(e -> {
            try {
                // System.out.println("Works");
                frame.getContentPane().removeAll();
                frame.revalidate();
                frame.repaint();
                User_LogIn.LogIn();
            } catch (Exception e1) {
                System.out.println(e1.getMessage()); 
            }
        });
        signup_button.addActionListener(e -> {
            try {
                // System.out.println("Works");
                frame.getContentPane().removeAll();
                frame.revalidate();
                frame.repaint();
                User_LogIn.Registration();
            } catch (Exception e1) {
                System.out.println(e1.getMessage()); 
            }
        });
    }
}
