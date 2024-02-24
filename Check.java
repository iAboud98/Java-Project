/*
 Name: Abed Alrheem Fialah
 ID: 1220216
 Section Lab: 7L 
 */

class Check extends CustomerPayment implements Payable{
//class Check is a subclass of superclass CustomerPayment and also implements the interface class Payable

    public static final int CASHIER = 1;
    public static final int CERTIFIED = 2;
    public static final int PERSONAL = 3; 
    // static final attributes (constants) to determine the type of payment

    private int acountNumber;
    private double accountBalance;
    private int type;
    //Priavte Access modifier which is accessible just in this class

    public Check() {
        // Default Constructor, java calls the keyword super(); automatically there is no need to write it
    }

    public Check(String customerName, int customerId, double amount,int acountNumber, double accountBalance, int type) {
         // all-arg Constructer,we can write superclass attributes by calling super(customerName,customerId,amount) 
        this.customerName = customerName;
        this.customerId = customerId;
        this.amount = amount;
        this.acountNumber = acountNumber;
        this.accountBalance = accountBalance;
        this.type = type;
    }

    //******Setters & Getters ********

    public int getAcountNumber() {
        return this.acountNumber;
    }

    public void setAcountNumber(int acountNumber) {
        this.acountNumber = acountNumber;
    }

    public double getAccountBalance() {
        return this.accountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int type) {
        this.type = type;
    }

    // method to deduct from balanceAcount, just used in Check personal,certified types
    public void deductAmountFromBalance(){
        accountBalance = getAccountBalance() - getAmount();
    }

    //method to calculate payment, inherited from CustomerPayment
    public double calculatePayment(){
        return getAmount();
    }


    @Override
    public String toString() {
        return  "Check [" + 
            " acountNumber='" + getAcountNumber() + "'" +
            ", accountBalance='" + getAccountBalance() + "'" +
            ", type='" + getType() + "'" +
            super.toString();
    }

    //This method determine if the payment is Authorized or not by checking some conditions
    //It is inherited from Payable interface class
    public boolean isAuthorized(){
        if (calculatePayment()<=getAccountBalance() || type == CASHIER){
            if(calculatePayment()<=getAccountBalance() && type != CASHIER){
                deductAmountFromBalance();
            }
            return true;
        }else{
            return false;
        }
    }
    

}