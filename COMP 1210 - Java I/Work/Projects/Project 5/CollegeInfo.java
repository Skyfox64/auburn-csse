import java.util.ArrayList;
import java.text.DecimalFormat;
/**
*
* @Author: John Carroll
* @Version: 10-5-2013
* Assignment Due Date: 10-7-2013
*
* The CollegeInfo class has fields, a constructor, and methods as 
* outlined below.
* 
*
*/
public class CollegeInfo { 

   //_________Fields:__________.
   //Instance Variables
   private String college; 
   private ArrayList<DeptInfo> dept = new ArrayList<DeptInfo>();
      
   /**
   *________Constructor:________.
   *@param collegeName becomes college
   *@param deptIn becomes dept
   */
   public CollegeInfo(String collegeName, ArrayList<DeptInfo> deptIn) { 
      college = collegeName; 
      dept = deptIn; 
   } 
   
   //_________Methods:__________.
   
   //Name of College_____________________________
   /**
   *getName.
   *@return college
   */
   public String getName() { 
      return college; 
   } 
    
    /**
    *totalFaculty.
    *@return total
    */       
   public int totalFaculty() {
      int total = 0; 
      if (dept.size() == 0) {
         total += 0;
         return total;
      }
      else { 
         for (DeptInfo obj: dept) { 
            total += obj.getNumFaculty(); 
         } 
         return total; 
      } 
   }
   
   /**
    *totalUgrads.
    *@return total
    */  
   public int totalUgrads() {
      int total = 0;
      if (dept.size() == 0) {
         total += 0;
         return total;
      }
      else {
         for (DeptInfo obj: dept) {
            total += obj.getNumUgrads();
         }
         return total;
      }
   }
    
    /**
    *totalGrads.
    *@return total
    */    
   public int totalGrads() {
      int total = 0;
      if (dept.size() == 0) {
         total += 0;
         return total;
      }
      else {
         for (DeptInfo obj: dept) {
            total += obj.getNumGrads();
         }
         return total;
      }
   }
      
    /**
    *deptWithMaxUgrads.
    *@return output
    */    
   public String deptWithMaxUgrads() { 
      String output = "";
      
      if (dept.size() == 0) {
         output += "(0)";
         return output;
      }   
      else {
         int max = 0;
         for (int i = 1; i < dept.size(); i++) {
            if (dept.get(i).getNumUgrads() > dept.get(max).getNumUgrads()) {
               max = i;
            }
         }
         
         output += dept.get(max).getName() + " (";
         output += dept.get(max).getNumUgrads() + ")";
         
         return output; 
      }
   } 
   
    /**
    *deptWithMaxGrads.
    *@return output
    */    
   public String deptWithMaxGrads() { 
      String output = "";
      
      if (dept.size() == 0) {
         output += "(0)";
         return output;
      }   
      else {
         int max = 0;
         for (int i = 1; i < dept.size(); i++) {
            if (dept.get(i).getNumGrads() > dept.get(max).getNumGrads()) {
               max = i;
            }
         }
         
         output += dept.get(max).getName() + " (";
         output += dept.get(max).getNumGrads() + ")";
         
         return output; 
      }
   } 
    
    /**
    *totalResearchFunding.
    *@return 0 or total
    */    
   public double totalResearchFunding() {
      double total = 0.0;
      if (dept.size() == 0) {
         total += 0.0;
         return total;
      }   
      else {
         for (DeptInfo obj: dept) {
            total += obj.getResFunding();
         }
         return total;
      }
   } 
   
   /**
    *researchFundingReport.
    *@return output
    */     
   public String researchFundingReport() { 
      DecimalFormat currency = new DecimalFormat("$#,##0");
      String output = "";
      if (dept.size() == 0) {
         output += "   No departments found";
         return output; 
      }
      else {
         for (DeptInfo obj: dept) {
         
            output += "   " + currency.format(obj.getResFunding());
            output += " " + obj.getName() + "\n";
         }
         output += "   Total: " + currency.format(totalResearchFunding());
         return output;
      }
   } 
    
    /**
    *toString.
    *@return output
    */    
   public String toString() { 
      String output = "";
      
      output += "\nCollege of " + college + "\n\n";
      
      int i = dept.size() - 1;
      int j = 0;
      while (j <= i) {
         output += dept.get(j).toString() + "\n";
         j++;
      }
      
      output += "----- Summary for " + getName() + " -----";
      output += "\nTotal Faculty: " + totalFaculty();
      output += "\nTotal Undergraduate Students: " + totalUgrads();
      output += "\nTotal Graduate Students: " + totalGrads();
      output += "\nDept with Most Undergraduate Students: ";
      output += deptWithMaxUgrads();
      output += "\nDept with Most Graduate Students: " + deptWithMaxGrads();
      output += "\nDept Research Funding: \n" + researchFundingReport();
           
      return output; 
   } 
}