 // Calculate conversion of dollars to Bitcoins
 // CMS 121
 
 // Use the double type for decimal values
 // Stands for "double precision floating point" which refers to how data is represented in memory
 
 public class ExchangeCalculator {
 
     public static void main(String[] args) {
         double bitcoins = 1000.00;
    
         // final declares a constant value
         // By convention, constants are written in ALL_CAPS
         final double EXCHANGE_RATE = 10866.70;
     
         double dollars = bitcoins * EXCHANGE_RATE;
     
         System.out.println("$" + dollars + " is " + bitcoins + " BTC.");
     }
   
 }
