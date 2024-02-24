/*
 Name: Abed Alrheem Fialah
 ID: 1220216
 Section Lab: 7L 
 */
public abstract class CustomerPayment implements Comparable<CustomerPayment>{
    // abstarct class that implements Comparable interface

    protected String customerName;
    protected int customerId;
    protected double amount;
    //Protected access modifier which makes the attributes accessible in same class, package, subclasses 

    public CustomerPayment() {
        //Default Constructor
    }


    public CustomerPayment(String customerName, int customerId, double amount) {
        // All-arg Constructer
        this.customerName = customerName;
        this.customerId = customerId;
        this.amount = amount;
    }


    // Setters & Getters
    public String getCustomerName() {
        return this.customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getCustomerId() {
        return this.customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public double getAmount() {
        return this.amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return " " +
            " customerName='" + getCustomerName() + "'" +
            ", customerId='" + getCustomerId() + "'" +
            ", amount='" + getAmount() + "'" +
            "]\n";
    }

    //Protected abstract method to calculate payment
    protected abstract double calculatePayment();

    //voit method to print payment
    void printPaymentInfo(){
        System.out.println("\n" + toString() + " Payment = " + calculatePayment()+"\n\n");
    }
    
    // compareTo method wich comes from java.lang.Comparable interface
    public int compareTo(CustomerPayment c){
        if (this.calculatePayment() > c.calculatePayment()){
            return -1;
        }else if(this.calculatePayment() < c.calculatePayment()){
            return 1;
        }else{
            return 0;
        }
    }


}