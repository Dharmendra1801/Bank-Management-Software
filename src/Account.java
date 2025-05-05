import java.awt.Color;
import java.awt.Font;
import java.util.*;
import javax.swing.*;

public class Account {
    Scanner sc = new Scanner(System.in);
    DAO dao = new DAO();
    Frame frame = App.frame;

    Account(String username) throws Exception {
        menu(username);
    }

    public void menu(String username) throws Exception {

        RoundedPanel panel = new RoundedPanel();
        panel.setLayout(null);
        panel.setBounds(100,120,520,500);

        JMenuItem homepage = new JMenuItem("Home Page");
        homepage.addActionListener( e -> {
            frame.getContentPane().removeAll();
            frame.revalidate();
            frame.repaint();
            try {
                menu(username);
            } catch (Exception e1) {
                System.out.println(e1.getMessage());
            }
        }); 

        JMenuItem mnewAcc = new JMenuItem("Create new Account");
        mnewAcc.addActionListener(e -> {
            frame.getContentPane().removeAll();
            frame.revalidate();
            frame.repaint();
            try {
                createAccount(username);
            } catch (Exception e1) {
                System.out.println(e1.getMessage());
            }
        });

        JMenuItem mallAcc = new JMenuItem("Get list of all the Accounts");
        mallAcc.addActionListener(e -> {
            frame.getContentPane().removeAll();
            frame.revalidate();
            frame.repaint();
            try {
                // accList(username);
            } catch (Exception e1) {
                System.out.println(e1.getMessage());
            }
        });

        JMenuItem mdelAcc = new JMenuItem("Delete Account");
        mdelAcc.addActionListener(e -> {
            frame.getContentPane().removeAll();
            frame.revalidate();
            frame.repaint();
            try {
                delAcc(username);
            } catch (Exception e1) {
                System.out.println(e1.getMessage());
            }
        });

        JMenuItem mbal = new JMenuItem("Check Balance");
        mbal.addActionListener(e -> {
            frame.getContentPane().removeAll();
            frame.revalidate();
            frame.repaint();
            try {
                checkBal(username);
            } catch (Exception e1) {
                System.out.println(e1.getMessage());
            }
        });

        JMenuItem mchPass = new JMenuItem("Change Password");
        mchPass.addActionListener(e -> {
            frame.getContentPane().removeAll();
            frame.revalidate();
            frame.repaint();
            try {
                changePass(username);
            } catch (Exception e1) {
                System.out.println(e1.getMessage());
            }
        });

        JMenu home = new JMenu("Home");
        home.add(homepage);
        home.add(mnewAcc);
        home.add(mallAcc);
        home.add(mdelAcc);
        home.add(mbal);
        home.add(mchPass);

        JMenuItem debit = new JMenuItem("Debit");
        debit.addActionListener(e -> {
            try {
                frame.getContentPane().removeAll();
                frame.revalidate();
                frame.repaint();
                Transactions.debit(username);
            } catch (Exception e1) {
                System.out.println(e1.getMessage());
            }
        });

        JMenuItem credit = new JMenuItem("Credit");
        credit.addActionListener(e -> {
            try {
                frame.getContentPane().removeAll();
                frame.revalidate();
                frame.repaint();
                Transactions.credit(username);
            } catch (Exception e1) {
                System.out.println(e1.getMessage());
            }
        });

        JMenuItem transfer = new JMenuItem("Transfer");
        transfer.addActionListener(e -> {
            try {
                frame.getContentPane().removeAll();
                frame.revalidate();
                frame.repaint();
                Transactions.transfer(username);
            } catch (Exception e1) {
                System.out.println(e1.getMessage());
            }
        });

        JMenu pay = new JMenu("Payments");
        pay.add(debit);
        pay.add(credit);
        pay.add(transfer);
        
        JMenuItem log = new JMenuItem("Log out");
        log.addActionListener(e -> {
            try {
                frame.getContentPane().removeAll();
                frame.revalidate();
                frame.repaint();
                App.app();
            } catch (Exception e1) {
                System.out.println(e1.getMessage());
            }
        });
        
        JMenuItem exit = new JMenuItem("Exit");
        exit.addActionListener(e -> System.exit(0));
        
        JMenu logout = new JMenu("Exit");
        logout.add(log);
        logout.add(exit);

        JMenuBar menu = new JMenuBar();
        menu.add(home);
        menu.add(pay);
        menu.add(logout);

        JLabel menuL = new JLabel("Menu");
        menuL.setFont(new Font("Ariel", Font.BOLD, 45));
        menuL.setBounds(300, 20, 300, 80);
        menuL.setForeground(Color.blue);

        JRadioButton newAcc = new JRadioButton("Create new Account");
        newAcc.addActionListener(e -> {
            frame.getContentPane().removeAll();
            frame.revalidate();
            frame.repaint();
            try {
                createAccount(username);
            } catch (Exception e1) {
                System.out.println(e1.getMessage());
            }
        });
        newAcc.setOpaque(true);
        newAcc.setBounds(65,50,400,60);
        newAcc.setFont(new Font("Ariel",Font.BOLD,25));;

        JRadioButton allAcc = new JRadioButton("Get list of all the Accounts");
        allAcc.addActionListener(e -> {
            frame.getContentPane().removeAll();
            frame.revalidate();
            frame.repaint();
            try {
                // accList(username);
            } catch (Exception e1) {
                System.out.println(e1.getMessage());
            }
        });
        allAcc.setOpaque(true);
        allAcc.setBounds(65,130,400,60);
        allAcc.setFont(new Font("Ariel",Font.BOLD,25));

        JRadioButton delAcc = new JRadioButton("Delete Account");
        delAcc.addActionListener(e -> {
            frame.getContentPane().removeAll();
            frame.revalidate();
            frame.repaint();
            try {
                delAcc(username);
            } catch (Exception e1) {
                System.out.println(e1.getMessage());
            }
        });
        delAcc.setOpaque(true);
        delAcc.setBounds(65,210,400,60);
        delAcc.setFont(new Font("Ariel",Font.BOLD,25));

        JRadioButton bal = new JRadioButton("Check Balance");
        bal.addActionListener(e -> {
            frame.getContentPane().removeAll();
            frame.revalidate();
            frame.repaint();
            try {
                checkBal(username);
            } catch (Exception e1) {
                System.out.println(e1.getMessage());
            }
        });
        bal.setOpaque(false);
        bal.setBounds(65,290,400,60);
        bal.setFont(new Font("Ariel",Font.BOLD,25));

        JRadioButton chPass = new JRadioButton("Change Password");
        chPass.addActionListener(e -> {
            frame.getContentPane().removeAll();
            frame.revalidate();
            frame.repaint();
            try {
                changePass(username);
            } catch (Exception e1) {
                System.out.println(e1.getMessage());
            }
        });
        chPass.setOpaque(true);
        chPass.setBounds(65,370,400,60);
        chPass.setFont(new Font("Ariel",Font.BOLD,25));

        ButtonGroup grp = new ButtonGroup();
        grp.add(newAcc);
        grp.add(allAcc);
        grp.add(delAcc);
        grp.add(bal);
        grp.add(chPass);

        panel.add(newAcc);
        panel.add(allAcc);
        panel.add(delAcc);
        panel.add(bal);
        panel.add(chPass);
        frame.add(menuL);
        frame.add(panel);
        frame.setJMenuBar(menu);
        frame.setTitle("Home");
        frame.setVisible(true);
    } 
    private void createAccount(String user_name) throws Exception {

        RoundedPanel panel = new RoundedPanel();
        panel.setBounds(100,120,520,480);

        JLabel caL = new JLabel("Create Account");
        caL.setFont(new Font("Ariel", Font.BOLD, 37));
        caL.setBounds(225, 20, 300, 80);
        caL.setForeground(Color.blue);

        JLabel type = new JLabel("Type of Account:");
        type.setFont(new Font(null, Font.PLAIN, 25));
        type.setBounds(100, 30, 300, 80);

        JTextField typeF = new JTextField();
        typeF.setBounds(100,130,300,40);

        JLabel bal = new JLabel("Initial Balance:");
        bal.setFont(new Font(null, Font.PLAIN, 25));
        bal.setBounds(100, 200, 300, 80);

        JTextField balF = new JTextField();
        balF.setBounds(100,300,300,40);

        JButton create = new JButton("Create");
        create.setBounds(210, 400, 100, 40);
        create.addActionListener(e -> {
            try {
                String accNo = dao.createAccount(user_name,typeF.getText(),Double.parseDouble(balF.getText()));
                JOptionPane.showMessageDialog(panel,"Your Account Number is: "+accNo, "Account Created", JOptionPane.INFORMATION_MESSAGE);
                frame.getContentPane().removeAll();
                frame.revalidate();
                frame.repaint();
                menu(user_name);
            }catch (Exception e1) {
                System.out.println(e1.getMessage());
            }
        });

        panel.add(type);
        panel.add(typeF);
        panel.add(bal);
        panel.add(balF);
        panel.add(create);
        frame.add(caL);
        frame.add(panel);
    }
    private void accList(String user_name) throws Exception{
        List<List<Integer>> ls = dao.getAccounts(user_name);
        System.out.println("Account Numbers associated with the user name: " + user_name + " are:\n");
        for (List x: ls) {
            System.out.println("Account Number: " + x.get(0) + "\tAccount Type: " + x.get(1));
        }
    }
    private void delAcc(String username) throws Exception {

        RoundedPanel panel = new RoundedPanel();
        panel.setBounds(100,150,520,360);

        JLabel caL = new JLabel("Delete Account");
        caL.setFont(new Font("Ariel", Font.BOLD, 37));
        caL.setBounds(225, 20, 300, 80);
        caL.setForeground(Color.blue);

        JLabel type = new JLabel("Account No.:");
        type.setFont(new Font(null, Font.PLAIN, 25));
        type.setBounds(100, 30, 300, 80);

        JTextField accNoF = new JTextField();
        accNoF.setBounds(100,130,300,40);

        JButton create = new JButton("Delete");
        create.setBounds(210, 230, 100, 40);
        create.addActionListener(e -> {
            try {
                String accNo = accNoF.getText();
                if (dao.accExist(accNo)) {
                    String pass = JOptionPane.showInputDialog(panel,"Enter password", "Confirm", JOptionPane.WARNING_MESSAGE);
                    if (dao.loginCheckUser(username, pass)==0) {
                        dao.delAcc(accNo);
                        JOptionPane.showMessageDialog(panel,"Account no: "+ accNo +" deleted", "Success", JOptionPane.PLAIN_MESSAGE);
                    }
                    else {
                        JOptionPane.showMessageDialog(panel,"Wrong Password", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    frame.getContentPane().removeAll();
                    frame.revalidate();
                    frame.repaint();
                    menu(username);
                }
                else {
                    accNoF.setText("");
                    JOptionPane.showMessageDialog(panel,"Account no: "+ accNo +" doesn't exist", "Error", JOptionPane.ERROR_MESSAGE);
                }
                
            }catch (Exception e1) {
                System.out.println(e1.getMessage());
            }
        });

        panel.add(type);
        panel.add(accNoF);
        panel.add(create);
        frame.add(caL);
        frame.add(panel);
    }
    private void checkBal(String username) throws Exception {

        RoundedPanel panel = new RoundedPanel();
        panel.setBounds(100,150,520,360);

        JLabel caL = new JLabel("Check Balance");
        caL.setFont(new Font("Ariel", Font.BOLD, 37));
        caL.setBounds(225, 20, 300, 80);
        caL.setForeground(Color.blue);

        JLabel accNL = new JLabel("Account No.:");
        accNL.setFont(new Font(null, Font.PLAIN, 25));
        accNL.setBounds(100, 30, 300, 80);

        JTextField accNoF = new JTextField();
        accNoF.setBounds(100,130,300,40);

        JButton create = new JButton("Check");
        create.setBounds(210, 230, 100, 40);
        create.addActionListener(e -> {
            try {
                String accNo = accNoF.getText();
                if (dao.accExist(accNo)) {
                    List<String> ls = dao.checkBal(accNo);
                    JOptionPane.showMessageDialog(panel,"<html>Account Type: " + ls.get(0) + "<br>Account Balance: " + ls.get(1) + "</html>","Balance", JOptionPane.PLAIN_MESSAGE);
                    frame.getContentPane().removeAll();
                    frame.revalidate();
                    frame.repaint();
                    menu(username);
                }
                else {
                    accNoF.setText("");
                    JOptionPane.showMessageDialog(panel,"Account no: "+ accNo +" doesn't exist", "Error", JOptionPane.ERROR_MESSAGE);
                }
                
            }catch (Exception e1) {
                System.out.println(e1.getMessage());
            }
        });

        panel.add(accNL);
        panel.add(accNoF);
        panel.add(create);
        frame.add(caL);
        frame.add(panel);
    }
    private void changePass(String user_name) throws Exception {

        RoundedPanel panel = new RoundedPanel();
        panel.setBounds(100,120,520,480);

        JLabel caL = new JLabel("Change Password");
        caL.setFont(new Font("Ariel", Font.BOLD, 37));
        caL.setBounds(190, 20, 360, 80);
        caL.setForeground(Color.blue);

        JLabel l1 = new JLabel("New Password:");
        l1.setFont(new Font(null, Font.PLAIN, 25));
        l1.setBounds(100, 30, 300, 80);

        JTextField p1 = new JTextField();
        p1.setBounds(100,130,300,40);

        JLabel l2 = new JLabel("Re-enter Password:");
        l2.setFont(new Font(null, Font.PLAIN, 25));
        l2.setBounds(100, 200, 300, 80);

        JTextField p2 = new JTextField();
        p2.setBounds(100,300,300,40);

        JButton update = new JButton("Update");
        update.setBounds(210, 400, 100, 40);
        update.addActionListener(e -> {
            try {
                if (!p1.getText().equals(p2.getText())) {
                    p1.setText("");
                    p2.setText("");
                    JOptionPane.showMessageDialog(panel, "Passwords don't match", "Error", JOptionPane.ERROR_MESSAGE);
                }
                else {
                    dao.changePass(user_name, p1.getText());
                    JOptionPane.showMessageDialog(panel,"Password for " + user_name + " updated", "Success", JOptionPane.INFORMATION_MESSAGE);
                    frame.getContentPane().removeAll();
                    frame.revalidate();
                    frame.repaint();
                    App.app();
                }
            }catch (Exception e1) {
                System.out.println(e1.getMessage());
            }
        });

        panel.add(l1);
        panel.add(l2);
        panel.add(p1);
        panel.add(p2);
        panel.add(update);
        frame.add(caL);
        frame.add(panel);

    }
}
