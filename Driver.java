/*
 Name: Abed Alrheem Fialah
 ID: 1220216
 Section Lab: 7L 
 */
import java.util.*; 

public class Driver{
    public static void main (String []args){
        
        //Defined two arraylist of type CustomerPayment, first one is temporary to check authrized payments
        //Second one is the sorted/completed arraylist
        ArrayList<CustomerPayment> temp = new ArrayList<CustomerPayment>();
        ArrayList<CustomerPayment> arrOfCustomersPayments = new ArrayList<CustomerPayment>();
        
        //Data about customers added to the arraylist temp, the refrence is CustomerPayment but each one has its own object (check,creditcard,cash)
        CustomerPayment RanaPayment = new Check("Rana",7777,400,1111,350,Check.PERSONAL);                  
        CustomerPayment AhmadPayment = new Cash("Ahmad",4444,150,5.0);	 							 
        CustomerPayment SuhaPayment = new Check("Suha",5555,100,1111,200,Check.CASHIER);			   
        CustomerPayment RaniaPayment = new Check("Rania",7777,600.0,1111,750,Check.CERTIFIED);			   
        CustomerPayment RandaPayment = new CreditCard("Randa",9999,170,20, new Date(124,05,03));		   
        CustomerPayment HaniPayment = new CreditCard("Hani",6666,150,10, new Date(120,06,07));

        temp.add(RanaPayment);
        temp.add(AhmadPayment);
        temp.add(SuhaPayment);
        temp.add(RaniaPayment);
        temp.add(RandaPayment);
        temp.add(HaniPayment);


        //Loop to check all elements of arraylist temp
        //Casting is used as well 
        for (int i=0;i<temp.size();i++){
            if (temp.get(i) instanceof Check && ((Check) temp.get(i)).isAuthorized()){
                arrOfCustomersPayments.add(temp.get(i));
            }else if (temp.get(i) instanceof CreditCard && ((CreditCard) temp.get(i)).isAuthorized()){
                arrOfCustomersPayments.add(temp.get(i));
            }else if(temp.get(i) instanceof Cash){
                arrOfCustomersPayments.add(temp.get(i));
            }
        }

        //Method called to sort the elements of the array Descending as the project says
        //Switched between 1 and -1 in compareTo method in CustomerPayment to get Descending Sort 
        Collections.sort(arrOfCustomersPayments);

        //Method to print the output arraylist
        printSortedPayments(arrOfCustomersPayments);

    }

    public static void printSortedPayments(ArrayList<CustomerPayment> cc){
        for(int i =0; i<cc.size();i++){
            cc.get(i).printPaymentInfo();
        }
    }
}