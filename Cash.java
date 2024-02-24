/*
 Name: Abed Alrheem Fialah
 ID: 1220216
 Section Lab: 7L 
 */

class Cash extends CustomerPayment{
    // Cash is subclass of superclass CustomerPayment

    private double discountRate;
    // private Access modifier that accessible just in this class

    public Cash(){
        // Default Constructor, java calls the keyword super(); automatically there is no need to write it
    }

    public Cash(String customerName, int customerId, double amount,double discountRate) {
        // all-arg Constructer, can write it by calling super(customerName,customerId,amount) and this.discountRate = discountRate; 
        this.customerName = customerName;
        this.customerId = customerId;
        this.amount = amount;
        this.discountRate = discountRate;
    }

    //****Setters & Getters****

    public double getDiscountRate() {

        return this.discountRate;
    }

    public void setDiscountRate(double discountRate) {
        this.discountRate = discountRate;
    }

    
    public double calculatePayment(){
        // method used to calculate the payment which measured as the project says, this method is Abstract inherited from CustomerPayment
        double discount = (getAmount() * getDiscountRate())/100;
        // we can also use the attributes themselves not their getters (amout*discountRate)
        return getAmount() - discount;
    }


    //toString method
    @Override
    public String toString() {
        return "Cash [" +
            " discountRate='" + getDiscountRate() + "'," +
            super.toString();
    }

}