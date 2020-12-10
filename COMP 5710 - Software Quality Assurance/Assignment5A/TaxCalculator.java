//Imports
import java.*;



/**
TaxCalculator

@author John Carroll
@version 04-21-2016
*/

public class TaxCalculator {

   //Tier CONSTANTS
   //Tier tax rates
   private static final double TIER1_TAXRATE = 0;
   private static final double TIER2_TAXRATE = 0.10;
   private static final double TIER3_TAXRATE = 0.20;
   private static final double TIER4_TAXRATE = 0.30;
   private static final double TIER5_TAXRATE = 0.40;

   //Tier income maximums, single filing, and joint filing
   private static final int SINGLE_TIER1_MAXINCOME = 6000;
   private static final int SINGLE_TIER2_MAXINCOME = 55000;
   private static final int SINGLE_TIER3_MAXINCOME = 105000;
   private static final int SINGLE_TIER4_MAXINCOME = 160000;

   private static final int JOINT_TIER1_MAXINCOME = 10000;
   private static final int JOINT_TIER2_MAXINCOME = 70000;
   private static final int JOINT_TIER3_MAXINCOME = 120000;
   private static final int JOINT_TIER4_MAXINCOME = 250000;   

   //Tier Tax Max's based off income, single and joint filing
   private static final double  SINGLE_TIER1_MAXTAX = (SINGLE_TIER1_MAXINCOME - 0) * TIER1_TAXRATE;
   private static final double  SINGLE_TIER2_MAXTAX = SINGLE_TIER1_MAXTAX + (SINGLE_TIER2_MAXINCOME - SINGLE_TIER1_MAXINCOME) * TIER2_TAXRATE;
   private static final double  SINGLE_TIER3_MAXTAX = SINGLE_TIER2_MAXTAX + (SINGLE_TIER3_MAXINCOME - SINGLE_TIER2_MAXINCOME) * TIER3_TAXRATE;
   private static final double  SINGLE_TIER4_MAXTAX = SINGLE_TIER3_MAXTAX + (SINGLE_TIER4_MAXINCOME - SINGLE_TIER3_MAXINCOME) * TIER4_TAXRATE;
   
   private static final double  JOINT_TIER1_MAXTAX = (JOINT_TIER1_MAXINCOME - 0) * TIER1_TAXRATE;
   private static final double  JOINT_TIER2_MAXTAX = JOINT_TIER1_MAXTAX + (JOINT_TIER2_MAXINCOME - JOINT_TIER1_MAXINCOME) * TIER2_TAXRATE;
   private static final double  JOINT_TIER3_MAXTAX = JOINT_TIER2_MAXTAX + (JOINT_TIER3_MAXINCOME - JOINT_TIER2_MAXINCOME) * TIER3_TAXRATE;
   private static final double  JOINT_TIER4_MAXTAX = JOINT_TIER3_MAXTAX + (JOINT_TIER4_MAXINCOME - JOINT_TIER3_MAXINCOME) * TIER4_TAXRATE;

   /**
   calculateTax
   @param status - where status is 1 for single and 2 for joint, 
   @param income - income is the reported income, and 
   @return tax - the return value is the calculated tax.
   */
   public int calculateTax(int status, int income) throws IllegalArgumentException {
   
      double tax = 0.0;
   
      if (status == 1){
         if (income < 0){
            throw new IllegalArgumentException("Income should be a positive integer.");
         }
         else if (income < SINGLE_TIER1_MAXINCOME) {
            tax = (income - SINGLE_TIER1_MAXINCOME) * TIER1_TAXRATE;
         }
         else if (SINGLE_TIER1_MAXINCOME < income && income <= SINGLE_TIER2_MAXINCOME){
            tax =  SINGLE_TIER1_MAXTAX + (income - SINGLE_TIER1_MAXINCOME) * TIER2_TAXRATE;
         }
         else if (SINGLE_TIER2_MAXINCOME < income && income <= SINGLE_TIER3_MAXINCOME){         
            tax =  SINGLE_TIER2_MAXTAX + (income - SINGLE_TIER2_MAXINCOME) * TIER3_TAXRATE;
         }
         else if (SINGLE_TIER3_MAXINCOME < income && income <= SINGLE_TIER4_MAXINCOME){        
            tax =  SINGLE_TIER3_MAXTAX + (income - SINGLE_TIER3_MAXINCOME) * TIER4_TAXRATE;
         }
         else if (SINGLE_TIER4_MAXINCOME < income) {
            tax =  SINGLE_TIER4_MAXTAX + (income - SINGLE_TIER4_MAXINCOME) * TIER5_TAXRATE;
         }
      }
      else if (status == 2) {
         if (income < 0){
            throw new IllegalArgumentException("Income should be a positive integer.");
         }
         else if (income < JOINT_TIER1_MAXINCOME) {
            tax = (income - JOINT_TIER1_MAXINCOME) * TIER1_TAXRATE;
         }
         else if (JOINT_TIER1_MAXINCOME < income && income <= JOINT_TIER2_MAXINCOME){
            tax =  JOINT_TIER1_MAXTAX + (income - JOINT_TIER1_MAXINCOME) * TIER2_TAXRATE;
         }
         else if (JOINT_TIER2_MAXINCOME < income && income <= JOINT_TIER3_MAXINCOME){         
            tax =  JOINT_TIER2_MAXTAX + (income - JOINT_TIER2_MAXINCOME) * TIER3_TAXRATE;
         }
         else if (JOINT_TIER3_MAXINCOME < income && income <= JOINT_TIER4_MAXINCOME){        
            tax =  JOINT_TIER3_MAXTAX + (income - JOINT_TIER3_MAXINCOME) * TIER4_TAXRATE;
         }
         else if (JOINT_TIER4_MAXINCOME < income) {
            tax =  JOINT_TIER4_MAXTAX + (income - JOINT_TIER4_MAXINCOME) * TIER5_TAXRATE;
         }
      }
      else {
         throw new IllegalArgumentException("Status should be 1 or 2.");
      }

      tax = (int)Math.round(tax);
      return (int)tax;
   }
   
}