package bankapp;

public class Savings extends Account{
    private int safetyDepositBoxID;
    private int safetyDepositBoxKey;
    public Savings(String name, String ID, double deposit){
        super(name, ID, deposit);
        accountNumber = "2" + accountNumber;
        setSafetyDepositBox();
        setRate();
        printDetails();
    }

    @Override
    public void setRate() {
        rate = getBaseRate() - 0.25;
    }

    public void printDetails(){
        System.out.println("ACCOUNT TYPE: SAVINGS");
        super.printDetails();
        System.out.println("SAFETY DEPOSIT BOX DETAILS:" +
                "\nSafety Deposit Box ID: " + safetyDepositBoxID+
                "\nSafety Deposit Box Key: " + safetyDepositBoxKey +
                "\n***********************************"
        );


    }

    private void setSafetyDepositBox(){
        safetyDepositBoxID = 100 + (int) (Math.random()*Math.pow(10,3));
        safetyDepositBoxKey = 1000 + (int) (Math.random()*Math.pow(10, 4));


    }

}
