package bankapp;
public class Checking extends Account {

    private int debitCardNum;
    private int debitCardPin;

    public Checking(String name, String ID, double deposit){
        super(name, ID, deposit);
        accountNumber = "1" + accountNumber;
        setDebitCard();
        setRate();
        printDetails();
    }

    public void setRate(){
        rate = getBaseRate() * .15;
    }

    public void printDetails(){
        System.out.println("ACCOUNT TYPE: CHECKING");
        super.printDetails();
        System.out.println(
                "DEBIT CARD DETAILS: "+
                        "\nDebit card number: " + debitCardNum +
                        "\nDebit card pin: " + debitCardPin +
                "\n***********************************");
    }

    private void setDebitCard(){
        debitCardNum = (int) (Math.random()*Math.pow(10, 12));
        debitCardPin = 1000 + (int) (Math.random()*Math.pow(10, 4));
    }



}
