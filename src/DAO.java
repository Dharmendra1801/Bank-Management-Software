import java.sql.*;

public class DAO {
    String url = "jdbc:mysql://localhost:3306/BankDB";
    String un = "root";
    String p = "10010@Uday";
    Connection con;

    public DAO() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, un, p);
            if (con == null) {
                System.out.println("Connection established.");
            }
        } catch (Exception e) {
            System.out.println("Connection error: " + e.getMessage());
        }
    }

    public void addUserCred(String name, String pass) throws Exception {
        String q = "insert into username_pass values(?,?)";
        PreparedStatement ps = con.prepareStatement(q);
        ps.setString(1, name);
        ps.setString(2, pass);
        ps.executeUpdate();
    }
    public boolean checkInUsage(String name, boolean c) throws Exception {
        String q = "SELECT 1 FROM username_pass WHERE user_name = ?";
        PreparedStatement ps = con.prepareStatement(q);
        ps.setString(1, name);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            if (c) System.out.println("User name already exist.\nPlease select a new one.");
            return true;
        }
        return false;
    }
    public boolean loginCheckUser(String name, String pass) throws Exception {
        if (!checkInUsage(name,false)) {
            System.out.println("Wrong Username");
            return false;
        }
        String q = "SELECT password FROM username_pass WHERE user_name = ?";
        PreparedStatement ps = con.prepareStatement(q);
        ps.setString(1, name);
        ResultSet rs = ps.executeQuery();
        rs.next();
        if (rs.getString(1).equals(pass)) return true;
        System.out.println("Wrong Password");
        return false;
    }
}