import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("If you are a new user please type '0' for registering.\nElse type any number.");
        int ans = sc.nextInt();
        sc.nextLine();
        DAO dao = new DAO();
        if (ans==0) {
            String u_name;
            String pass1;
            String pass2;
            do {
                System.out.println("Enter your username to be used for registering:");
                u_name = sc.nextLine();
            }
            while (dao.checkInUsage(u_name,true));
            boolean c = false;
            do {    
                if (c) {
                    System.out.println("Passwords doesn't match.");
                }
                System.out.println("Enter a password (min. 5 characters)");
                pass1 = sc.nextLine();
                System.out.println("Enter again");
                pass2 = sc.nextLine();
                c = true;
            }
            while (!pass1.equals(pass2));
            dao.addUserCred(u_name,pass1);
            System.out.println("Now please log in");
        }
        String u_name;
        String u_pass;
        int n = 0;
        System.out.println("Please enter your username and password to log in.");
        do {
            if (n==5) {
                System.out.println("Multiple wrong passwords");
                System.exit(0);
            }
            System.out.println("Username: ");
            u_name = sc.nextLine();
            System.out.println("Password: ");
            u_pass = sc.nextLine();
            n++;
        }
        while(!dao.loginCheckUser(u_name,u_pass));
        System.out.println("Log in successful");
        System.out.println();
        sc.close();
    }
}
