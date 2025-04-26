import java.util.Scanner;

public class User_LogIn {
    Scanner sc = new Scanner(System.in);
    DAO dao = new DAO();
    public void Registration() throws Exception {
        String u_name;
        String pass1;
        String pass2;
        do {
            System.out.println("\nEnter your username to be used for registering:");
            u_name = sc.nextLine();
        }
        while (dao.checkInUsage(u_name,true));
        boolean c = false;
        do {    
            if (c) {
                System.out.println("Passwords doesn't match.");
            }
            System.out.println("\nEnter a password (min. 5 characters)");
            pass1 = sc.nextLine();
            System.out.println("Enter again");
            pass2 = sc.nextLine();
            c = true;
        }
        while (!pass1.equals(pass2));
        dao.addUserCred(u_name,pass1);
        System.out.println("\nNow please log in");
    }
    public String LogIn() throws Exception {
        String u_name;
        String u_pass;
        int n = 0;
        System.out.println("\nPlease enter your username and password to log in.\n");
        do {
            if (n==5) {
                System.out.println("\nMultiple wrong passwords");
                System.exit(0);
            }
            System.out.println("Username: ");
            u_name = sc.nextLine();
            System.out.println("Password: ");
            u_pass = sc.nextLine();
            n++;
            
        }
        while(!dao.loginCheckUser(u_name,u_pass));
        System.out.println("\nLog in successful");
        return u_name;
    }
}