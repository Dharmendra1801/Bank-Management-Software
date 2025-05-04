import java.awt.Font;
import javax.swing.*;

public class User_LogIn {
    
    static DAO dao = new DAO();

    public static void Registration() throws Exception {

        Frame frame = App.frame;

        RoundedPanel panel = new RoundedPanel();
        
        panel.setBounds(180, 100, 360, 500);
        panel.setLayout(null);

        JLabel unL = new JLabel("Enter username(unique):");
        unL.setOpaque(true);
        unL.setBounds(30,15,720,40);
        unL.setFont(new Font("Ariel",Font.PLAIN,18));

        JLabel psL = new JLabel("Password:");
        psL.setOpaque(true);
        psL.setBounds(30,125,720,40);
        psL.setFont(new Font("Ariel",Font.PLAIN,18));

        JLabel rpsL = new JLabel("Re-enter Password:");
        rpsL.setOpaque(true);
        rpsL.setBounds(30,240,720,40);
        rpsL.setFont(new Font("Ariel",Font.PLAIN,18));

        JTextField un = new JTextField();
        un.setBounds(30, 65, 300, 40);
        
        JTextField ps = new JTextField();
        ps.setBounds(30, 175, 300, 40);

        JTextField rps = new JTextField();
        rps.setBounds(30, 290, 300, 40);

        JButton submit = new JButton("Submit");
        submit.setBounds(130, 355, 100, 40);
        submit.addActionListener(e -> {
            String u_name = un.getText();
            String u_pass = ps.getText();
            String ru_pass = rps.getText();
            try {
                if (u_name.length()==0) {
                    JOptionPane.showMessageDialog(panel,"Username is empty", "Warning", JOptionPane.WARNING_MESSAGE);
                }
                else if (dao.checkInUsage(u_name)) {
                    un.setText("");
                    JOptionPane.showMessageDialog(panel, "Username already exists!!!", "Warning" , JOptionPane.WARNING_MESSAGE);
                }
                else {
                    if (u_pass.length()==0 || ru_pass.length()==0) {
                        JOptionPane.showMessageDialog(panel,"Password is empty", "Warning", JOptionPane.WARNING_MESSAGE);
                    }
                    else if (!u_pass.equals(ru_pass)) {
                        JOptionPane.showMessageDialog(panel,"Password doesn't match!!!", "Warning", JOptionPane.WARNING_MESSAGE);
                    }
                    else {
                        dao.addUserCred(u_name,u_pass);
                        JOptionPane.showMessageDialog(panel, "User Registered", "Success", JOptionPane.PLAIN_MESSAGE);
                        frame.getContentPane().removeAll();
                        frame.revalidate();
                        frame.repaint();
                        LogIn();
                    }
                }
            } catch (Exception e1) {
                System.out.println(e1.getMessage());
            }
        });
        
        JLabel orLabel = new JLabel("or");
        orLabel.setOpaque(true);
        orLabel.setBounds(170,395,100,40);
        orLabel.setFont(new Font("Ariel",Font.PLAIN,15));

        JButton reg = new JButton("Sign in");
        reg.setBounds(130, 435, 100, 40);
        reg.addActionListener(e -> {
            try {
                frame.getContentPane().removeAll();
                frame.revalidate();
                frame.repaint();
                LogIn();
            } catch (Exception e1) {
                System.out.println(e1.getMessage());
            }
        });

        panel.add(un);
        panel.add(ps);
        panel.add(unL);
        panel.add(psL);
        panel.add(rpsL);
        panel.add(rps);
        panel.add(submit);
        panel.add(reg);
        panel.add(orLabel);
        frame.add(panel);
        frame.setTitle("Sign Up Page");
        frame.setVisible(true);
        
    }

    public static void LogIn() throws Exception {

        Frame frame = App.frame;

        RoundedPanel panel = new RoundedPanel();
    
        panel.setBounds(180, 100, 380, 420);
        panel.setLayout(null);

        JLabel unL = new JLabel("Username:");
        unL.setOpaque(true);
        unL.setBounds(30,30,720,40);
        unL.setFont(new Font("Ariel",Font.PLAIN,18));

        JLabel psL = new JLabel("Password:");
        psL.setOpaque(true);
        psL.setBounds(30,150,720,40);
        psL.setFont(new Font("Ariel",Font.PLAIN,18));

        JTextField un = new JTextField();
        un.setBounds(30, 80, 300, 40);
        
        JTextField ps = new JTextField();
        ps.setBounds(30, 200, 300, 40);

        JButton submit = new JButton("Submit");
        submit.setBounds(130, 280, 100, 40);
        submit.addActionListener(e -> {
            String u_name = un.getText();
            String u_pass = ps.getText();
            un.setText("");
            ps.setText("");
            try {
                int ans = dao.loginCheckUser(u_name,u_pass);
                if (ans==0) {
                    frame.getContentPane().removeAll();
                    frame.revalidate();
                    frame.repaint();
                    new Account(u_name);
                }
                else if (ans==-1) {
                    JOptionPane.showMessageDialog(frame,"Wrong Password","Error",JOptionPane.ERROR_MESSAGE);
                }
                else if (ans==1) {
                    JOptionPane.showMessageDialog(frame,"Username isn't registered","Error",JOptionPane.ERROR_MESSAGE);
                }
            } catch (Exception e1) {
                System.out.println(e1.getMessage());
            }
        });

        JLabel orLabel = new JLabel("or");
        orLabel.setOpaque(true);
        orLabel.setBounds(170,320,100,40);
        orLabel.setFont(new Font("Ariel",Font.PLAIN,15));
        
        JButton reg = new JButton("Sign up");
        reg.setBounds(130, 360, 100, 40);
        reg.addActionListener(e -> {
            try {
                frame.getContentPane().removeAll();
                frame.revalidate();
                frame.repaint();
                Registration();
            } catch (Exception e1) {
                System.out.println(e1.getMessage());
            }
        });

        panel.add(un);
        panel.add(ps);
        panel.add(unL);
        panel.add(psL);
        panel.add(submit);
        panel.add(reg);
        panel.add(orLabel);
        frame.add(panel);
        frame.setTitle("Sign In Page");
        frame.setVisible(true);
    }
}