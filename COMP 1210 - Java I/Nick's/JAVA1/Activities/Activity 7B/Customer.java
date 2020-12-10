   /**
   * This class will store and compare customer info.
   *
   * @author Nick DiChiara
   * @version 10-22-2012
   */



   public class Customer implements Comparable<Customer> {
   /**
   * Variables: name, location, balance.
   * Consructor: Customer
   * Methods: main, setLocation, changeBalance, 
   * getLoation, changeLocation, getBalance.
   * compareTo method for comparing Customer objects
   * toString method (for String output)
   */
   
   
      private String name;
      private String location;
      private double balance;
   
   
   
   
      /**
       * Default Constructor.
   	 * @param nameIn defines the name input.
       */
      public Customer(String nameIn) {
         name = nameIn;
         location = "";
         balance = 0;
      }
      
   /**
   * @param args specifies the command arguments.
   */
      public static void main(String[] args) {
         Customer cstmr1 = new Customer("John");
         cstmr1.changeBalance(10);
         cstmr1.setLocation("Boston, MA");
         System.out.println(cstmr1);
      
         Customer cstmr2 = new Customer("JoAnn");
         cstmr2.changeBalance(73);
         cstmr2.setLocation("Auburn, AL");
         System.out.println(cstmr2 + "\r\n");
      
      //use the compareTo method in the if statement below
      
         if (cstmr1.compareTo(cstmr2) == 1) {
            System.out.println("Higher balance: " + cstmr1);
         }
         else if (cstmr1.compareTo(cstmr2) == -1) {
            System.out.println("Higher balance: " + cstmr2);
         }
         else {
            System.out.println("Balances are equal.");
         }
      
      }
   
   
   
   
      /**
       * Method to set location.
       * @param locationIn defines input location
       */
      public void setLocation(String locationIn) {
         location = locationIn;
      }
   
      
      /**
       * Method to set location.
       * @param city defines the city.
       * @param state defines the state.
       */
      public void setLocation(String city, String state) {
         location = city + ", " + state;
      }
      
   
      /**
       * Method to change balance.
       * @param amount defines the amount.
       */
      public void changeBalance(double amount) {
         balance += amount;
      }
   
      /**
       * Method to get the location.
   	 * @return location gives the location.
       */
      public String getLocation() {
         return location;
      }
   	
   
      /**
       * Method to get the location.
   	 * @return balance gives the balance
       */
      public double getBalance() {
         return balance;
      }
   
      /**
       * Method to compare customer Objects.
       * @param obj is the customer object being compared.
   	 * @return gives the compare results.
       */
      public int compareTo(Customer obj) {
      
         if (this.balance > obj.getBalance()) {
            return 1;
         }
         else if (this.balance < obj.getBalance()) {
            return -1;
         }
         else {
            return 0;
         }
      	
      }
   
   
         /**
      * Method to output stacker's information.
      * @return output specifies stacker's information.
      */
      public String toString() {
         String output = "";
         
         output += name + "\n";
         output += location + "\n";
         output += balance;
      
         return output;
      }
   
   }