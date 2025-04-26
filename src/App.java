import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        System.out.println("\nIf you are a new user please type '0' for registering.\nElse type any number.");
        int ans = sc.nextInt();
        sc.nextLine();

        User_LogIn user = new User_LogIn();
        if (ans==0) {
            user.Registration();
        }
        String username = user.LogIn();

        Account acc = new Account();
        while (true) {
            System.out.println("\nSelect from the Menu: ");
            System.out.println("1) Create new Account");
            System.out.println("2) Check if account exists with the Account No.");
            System.out.println("3) Get list of all the accounts");
            System.out.println("4) Delete Account");
            System.out.println("5) Check Account Balance");
            System.out.println("6) Make transaction");
            System.out.println("7) Log Out");
            System.out.println();
            int out = sc.nextInt();
            sc.nextLine();
            System.out.println();
            switch (out) {
                case 1:
                    acc.createAccount(username);
                    break;
                case 2:
                    acc.accExist();
                    break;
                case 3:
                    acc.accList(username);
                    break;
                case 4:
                    acc.delAcc();
                    break;
                case 5:
                    acc.checkBal();
                    break;
                case 6:
                    acc.makeT();
                    break;
                default:
                    System.out.println("Enter valid number");
                    break;
            }
            System.out.println("\nIf you want to quit press 'Y', if not then anything else");
            String c = sc.nextLine();
            if (c.toUpperCase().equals("Y")) {
                System.out.println("\nThank You for using.");
                System.exit(0);
            }
        }
    }
}
