package bankapp;

import java.util.LinkedList;
import java.util.List;

public class BankAppDriver {
    public static void main(String[] args) {
//        Checking c = new Checking("charlie", "GQ8977", 1500);
//        Savings s = new Savings("sameer", "AB1234", 9900);
//
//        s.compound();
        List<Account> accounts = new LinkedList<>();

        String file = "data.txt";

        List<String[]> newAccounts = CSV.readFromFile(file);
        for(String[] account: newAccounts){
            String name = account[0];
            String ID = account[1];
            String type = account[2];
            double deposit = Double.parseDouble(account[3]);

            if(type.equals("Savings")){
                accounts.add(new Savings(name, ID, deposit));
            } else if(type.equals("Checking")){
                accounts.add(new Checking(name, ID, deposit));
            } else{
                System.out.println("Error reading account type");
                System.exit(1);
            }
        }

        for (Account acc : accounts){
            acc.printDetails();
        }
    }

}
