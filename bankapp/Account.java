package bankapp;

import java.util.Random;

public abstract class Account implements BaseRate{

    private String name;
    private String ID;
    private static int accNumberPrefix = 10000;
    protected String accountNumber;
    private double balance;
    protected double rate;


    public Account(String name, String ID, double deposit){
        this.name = name;
        this.ID = ID;
        balance = deposit;

        //Set account number
        accNumberPrefix++;
        this.accountNumber = setAccountNumber();
        rate = getBaseRate();

    }

    public void compound(){
        double accrued = balance * (rate/100);
        balance +=accrued;
        System.out.println("Accrued Interest: " + accrued);
        printBalance();
    }

    public abstract void setRate();

    public void deposit(double amount){
        balance += amount;
        System.out.println("Deposited " + amount);
    }

    public void withdraw(double amount){
        balance -= amount;
        System.out.println("Withdrawn " + amount);
    }

    public void transfer(String receiver, double amount){
        balance -=amount;
        System.out.println("Tranferring $" + amount + "to " + receiver);
    }

    public void printBalance(){
        System.out.println("Current Balance: " + balance);
    }

    private String setAccountNumber(){
        String partID = ID.substring(ID.length()-2, ID.length());
        int uniqueID = accNumberPrefix;
        Random rd = new Random();
        int randomNumber = 100 + rd.nextInt(900);
        return uniqueID + partID + randomNumber;
    }

    public void printDetails (){
        System.out.println(
                "NAME: " + name+
                        "\nACCOUNT NUMBER: " + accountNumber +
                        "\nBALANCE: $" + balance +
                        "\nRATE: " + rate + "%"

        );
    }
}
