import java.util.*;

public class Account {
    Scanner sc = new Scanner(System.in);
    DAO dao = new DAO();
    public void menu(String username) throws Exception {
        while (true) {
            System.out.println("\nSelect from the Menu: ");
            System.out.println("1) Create new Account");
            System.out.println("2) Check if account exists with the Account No.");
            System.out.println("3) Get list of all the accounts");
            System.out.println("4) Delete Account");
            System.out.println("5) Check Account Balance");
            System.out.println("6) Make transaction");
            System.out.println("7) Log Out\n");
            
            int out = sc.nextInt();
            sc.nextLine();
            System.out.println();
            switch (out) {
                case 1:
                    createAccount(username);
                    break;
                case 2:
                    accExist();
                    break;
                case 3:
                    accList(username);
                    break;
                case 4:
                    delAcc();
                    break;
                case 5:
                    checkBal();
                    break;
                case 6:
                    makeT(username);
                    break;
                case 7:
                    User_LogIn.LogIn();
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
    public void createAccount(String user_name) throws Exception {
        System.out.println("Enter type of account");
        String type = sc.nextLine();
        System.out.println("Enter initial balance of the account");
        double bal = sc.nextDouble();
        dao.createAccount(user_name,type,bal);
    }
    public void accExist() throws Exception {
        System.out.println("Enter account number to be checked");
        int accNo = sc.nextInt();
        sc.nextLine();
        if (dao.accExist(accNo)) System.out.println("Account No: " + accNo + " Exists");
        else System.out.println("Account No: " + accNo + " Doesn't exists");
    }
    public void accList(String user_name) throws Exception{
        List<List<Integer>> ls = dao.getAccounts(user_name);
        System.out.println("Account Numbers associated with the user name: " + user_name + " are:\n");
        for (List x: ls) {
            System.out.println("Account Number: " + x.get(0) + "\tAccount Type: " + x.get(1));
        }
    }
    public void delAcc() throws Exception {
        System.out.println("Enter the account number to be deleted: ");
        int accNo = sc.nextInt();
        sc.nextLine();
        System.out.println("Are you sure you want to delete it? (Press 'Y')");
        String c = sc.nextLine();
        if (!c.toUpperCase().equals("Y")) return;
        dao.delAcc(accNo);
        System.out.println("Account deleted");
    }
    public void checkBal() throws Exception {
        System.out.println("Enter the account number: ");
        int accNo = sc.nextInt();
        sc.nextLine();
        List<String> ls = dao.checkBal(accNo);
        System.out.println("\nAccount type: " + ls.get(0));
        System.out.println("Account balance: " + ls.get(1));
    }
    public void makeT(String username) throws Exception {
        boolean ch = true;
        while (ch) {
            System.out.println("\nSelect one of the following transactions:");
            System.out.println("1) Credit into Account");
            System.out.println("2) Debit from Account");
            System.out.println("3) Transfer to another Account");
            System.out.println("4) Back\n");
            int c = sc.nextInt();
            sc.nextLine();
            System.out.println();

            Transactions t = new Transactions();
            switch (c) {
                case 1:
                    System.out.println("Enter the Account Number: ");
                    int accNo = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter the amount to be credited: ");
                    double amt = sc.nextDouble();
                    sc.nextLine();
                    t.credit(amt, accNo);
                    break;
                case 2:
                    System.out.println("Enter the Account Number: ");
                    int acNo = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter the amount to be debited: ");
                    double am = sc.nextDouble();
                    sc.nextLine();
                    t.debit(am, acNo);
                    break;
                case 3:
                    System.out.println("Enter the Sender's Account Number: ");
                    int fAccNo = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter the Receiver's Account Number: ");
                    int tAccNo = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter the amount to be credited: ");
                    double amount = sc.nextDouble();
                    sc.nextLine();
                    t.transfer(amount, fAccNo, tAccNo);
                    break;
                case 4:
                    menu(username);
                    break;
                default:
                    System.out.println("Enter Correct Input!!!\n");
                    ch = false;
                    break;
            }
            ch = !ch;
        }
    }
}
