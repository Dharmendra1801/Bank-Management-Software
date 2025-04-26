import java.util.*;

public class Account {
    Scanner sc = new Scanner(System.in);
    DAO dao = new DAO();
    public void createAccount(String user_name) throws Exception {
        System.out.println("Enter type of account");
        String type = sc.nextLine();
        System.out.println("Enter initial balance of the account");
        double bal = sc.nextDouble();
        sc.close();
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
}
