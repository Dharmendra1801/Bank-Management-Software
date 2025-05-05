import java.awt.*;
import javax.swing.*;

public class Transactions {

    static DAO dao = new DAO();

    public static void credit(String user_name) throws Exception {
    
        Frame frame = App.frame;

        RoundedPanel panel = new RoundedPanel();
        panel.setBounds(100,120,520,480);

        JLabel caL = new JLabel("Credit Money");
        caL.setFont(new Font("Ariel", Font.BOLD, 37));
        caL.setBounds(225, 20, 300, 80);
        caL.setForeground(Color.blue);

        JLabel accNO = new JLabel("Account No.:");
        accNO.setFont(new Font(null, Font.PLAIN, 25));
        accNO.setBounds(100, 30, 300, 80);

        JTextField accNOF = new JTextField();
        accNOF.setBounds(100,130,300,40);

        JLabel amt = new JLabel("Amount:");
        amt.setFont(new Font(null, Font.PLAIN, 25));
        amt.setBounds(100, 200, 300, 80);

        JTextField amtF = new JTextField();
        amtF.setBounds(100,300,300,40);

        JButton create = new JButton("Proceed");
        create.setBounds(210, 400, 100, 40);
        create.addActionListener(e -> {
            try {
                String accNo = accNOF.getText();
                if (dao.accExist(accNo)) {
                    double bal = Double.parseDouble(dao.checkBal(accNo).get(1));
                    double money = bal + Double.parseDouble(amtF.getText());
                    int c = dao.updateBalance(accNo, money);
                    if (c>0) JOptionPane.showMessageDialog(panel,"<html>$" + amtF.getText() + " Amount Credited<br>Current Balance: $" +money+"</html>",accNo, JOptionPane.PLAIN_MESSAGE);
                    else System.exit(0);
                    frame.getContentPane().removeAll();
                    frame.revalidate();
                    frame.repaint();
                    new Account(user_name);
                }
                else {
                    accNOF.setText("");
                    JOptionPane.showMessageDialog(panel,"Account no: "+ accNo +" doesn't exist", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }catch (Exception e1) {
                System.out.println(e1.getMessage());
            }
        });

        panel.add(accNO);
        panel.add(accNOF);
        panel.add(amt);
        panel.add(amtF);
        panel.add(create);
        frame.add(caL);
        frame.add(panel);
    }
    public static void debit(String user_name) throws Exception {

        Frame frame = App.frame;

        RoundedPanel panel = new RoundedPanel();
        panel.setBounds(100,120,520,480);

        JLabel caL = new JLabel("Debit Money");
        caL.setFont(new Font("Ariel", Font.BOLD, 37));
        caL.setBounds(225, 20, 300, 80);
        caL.setForeground(Color.blue);

        JLabel accNO = new JLabel("Account No.:");
        accNO.setFont(new Font(null, Font.PLAIN, 25));
        accNO.setBounds(100, 30, 300, 80);

        JTextField accNOF = new JTextField();
        accNOF.setBounds(100,130,300,40);

        JLabel amt = new JLabel("Amount:");
        amt.setFont(new Font(null, Font.PLAIN, 25));
        amt.setBounds(100, 200, 300, 80);

        JTextField amtF = new JTextField();
        amtF.setBounds(100,300,300,40);

        JButton create = new JButton("Proceed");
        create.setBounds(210, 400, 100, 40);
        create.addActionListener(e -> {
            try {
                String accNo = accNOF.getText();
                if (dao.accExist(accNo)) {
                    String pass = JOptionPane.showInputDialog(panel,"Enter password", "Confirm", JOptionPane.QUESTION_MESSAGE);
                    if (dao.loginCheckUser(user_name, pass)==0) {
                        double bal = Double.parseDouble(dao.checkBal(accNo).get(1));
                        double money = bal - Double.parseDouble(amtF.getText());
                        int c = dao.updateBalance(accNo, money);
                        if (c>0) JOptionPane.showMessageDialog(panel,"<html>$" + amtF.getText() + " Amount Debited<br>Current Balance: $" +money+"</html>",accNo, JOptionPane.PLAIN_MESSAGE);
                        else System.exit(0);
                    }
                    else {
                        JOptionPane.showMessageDialog(panel,"Wrong Password", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    frame.getContentPane().removeAll();
                    frame.revalidate();
                    frame.repaint();
                    new Account(user_name);
                }
                else {
                    accNOF.setText("");
                    JOptionPane.showMessageDialog(panel,"Account no: "+ accNo +" doesn't exist", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }catch (Exception e1) {
                System.out.println(e1.getMessage());
            }
        });

        panel.add(accNO);
        panel.add(accNOF);
        panel.add(amt);
        panel.add(amtF);
        panel.add(create);
        frame.add(caL);
        frame.add(panel);
    }
    public static void transfer(String user_name) throws Exception {

        Frame frame = App.frame;

        RoundedPanel panel = new RoundedPanel();
        panel.setBounds(100,120,520,550);

        JLabel caL = new JLabel("Money Transfer");
        caL.setFont(new Font("Ariel", Font.BOLD, 37));
        caL.setBounds(215, 20, 400, 80);
        caL.setForeground(Color.blue);

        JLabel yaccNO = new JLabel("Your Account No.:");
        yaccNO.setFont(new Font(null, Font.PLAIN, 25));
        yaccNO.setBounds(100, 20, 300, 80);

        JTextField yaccNOF = new JTextField();
        yaccNOF.setBounds(100,110,300,40);

        JLabel raccNO = new JLabel("Recipient's Account No.:");
        raccNO.setFont(new Font(null, Font.PLAIN, 25));
        raccNO.setBounds(100, 160, 300, 80);

        JTextField raccNOF = new JTextField();
        raccNOF.setBounds(100,250,300,40);

        JLabel amt = new JLabel("Amount:");
        amt.setFont(new Font(null, Font.PLAIN, 25));
        amt.setBounds(100, 300, 300, 80);

        JTextField amtF = new JTextField();
        amtF.setBounds(100,390,300,40);

        JButton create = new JButton("Proceed");
        create.setBounds(210, 470, 100, 40);
        create.addActionListener(e -> {
            try {
                String my = yaccNOF.getText();
                String rec = raccNOF.getText();
                if (dao.accExist(my) && dao.accExist(rec)) {
                    String pass = JOptionPane.showInputDialog(panel,"Enter password", "Confirm", JOptionPane.QUESTION_MESSAGE);
                    if (dao.loginCheckUser(user_name, pass)==0) {
                        double mybal = Double.parseDouble(dao.checkBal(my).get(1));
                        double mymoney = mybal - Double.parseDouble(amtF.getText());
                        double recbal = Double.parseDouble(dao.checkBal(rec).get(1));
                        double recmoney = recbal + Double.parseDouble(amtF.getText());
                        dao.transfer(mymoney, recmoney, my, rec);
                        JOptionPane.showMessageDialog(panel,"<html>$" + amtF.getText() + " Amount Transfered<br>Current Balance: $" +mymoney+"</html>",my, JOptionPane.PLAIN_MESSAGE);
                    }
                    else {
                        JOptionPane.showMessageDialog(panel,"Wrong Password", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    frame.getContentPane().removeAll();
                    frame.revalidate();
                    frame.repaint();
                    new Account(user_name);
                }
                else {
                    yaccNOF.setText("");
                    raccNOF.setText("");
                    JOptionPane.showMessageDialog(panel,"One of the account doesn't exist", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }catch (Exception e1) {
                System.out.println(e1.getMessage());
            }
        });

        panel.add(yaccNO);
        panel.add(yaccNOF);
        panel.add(raccNO);
        panel.add(raccNOF);
        panel.add(create);
        panel.add(amt);
        panel.add(amtF);
        frame.add(caL);
        frame.add(panel);
    }
}
