/*
 Name: Abed Alrheem Fialah
 ID: 1220216
 Section Lab: 7L 
 */
import java.util.Date;

class CreditCard extends CustomerPayment implements Payable{
    // CreditCard is a subclass of superclass CustomerPayment, also implements interface class Payable
    
    private double chargingFee;
    private Date expiryDate;
    //private access modifier make the attributes accessible only in this class


    public CreditCard() {
        // Default Constructor, java calls the keyword super(); automatically there is no need to write it
    }

    public CreditCard(String customerName, int customerId, double amount,double chargingFee, Date expiryDate) {
        // all-arg Constructer,we can write superclass attributes by calling super(customerName,customerId,amount
        this.customerName = customerName;
        this.customerId = customerId;
        this.amount = amount;
        this.chargingFee = chargingFee;
        this.expiryDate = expiryDate;
    }

    //Setters & Getters

    public double getChargingFee() {
        return this.chargingFee;
    }

    public void setChargingFee(double chargingFee) {
        this.chargingFee = chargingFee;
    }

    public Date getExpiryDate() {
        return this.expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    //method to calculate payment, inherited from CustomerPayment
    public double calculatePayment(){
        return getAmount() + getChargingFee();
    }

    @Override
    public String toString() {
        return "CreditCard [" +
            " chargingFee='" + getChargingFee() + "'" +
            ", expiryDate='" + getExpiryDate() + "'" +
            super.toString();
    }

    //This method determine if the payment is Authorized or not by checking some conditions
    //It is inherited from Payable interface class
    public boolean isAuthorized(){
        if(this.getExpiryDate().compareTo(new Date())<0){
            return false;
        }else if (this.getExpiryDate().compareTo(new Date())>0){
            return true;
        }else{
            return true;
        }
    }
        
}