import java.util.Scanner;
import java.util.ArrayList;
import java.text.DecimalFormat;
import java.io.File;
import java.io.IOException;
/**
*
* @Author: John Carroll
* @Version: 10-13-2013
* Assignment Due Date: 10-14-2013
*
* The CollegeInfo class has fields, a constructor, and methods as 
* outlined below.
* 
*
*/
public class CollegeInfo { 

   //_________Fields:__________.
   //Instance Variables
   private String collegeName; 
   private ArrayList<DeptInfo> dept = new ArrayList<DeptInfo>();
      
   /**
   *________Constructor:________.
   *@param collegeNameIn becomes college
   *@param deptIn becomes dept
   */
   public CollegeInfo(String collegeNameIn, ArrayList<DeptInfo> deptIn) { 
      collegeName = collegeNameIn; 
      dept = deptIn; 
   } 
   
   //_________Methods:__________.
   
   //Name of College_____________________________
   /**
   *getName.
   *@return college
   */
   public String getName() { 
      return collegeName; 
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
      
      output += "\nCollege of " + collegeName + "\n\n";
      
      int i = dept.size() - 1;
      int j = 0;
      while (j <= i) {
         output += dept.get(j).toString() + "\n";
         j++;
      }
      
                   
      return output; 
   } 
   
   //=====================================================================
   //Project 6 addition
   //=====================================================================
   /**
    *readFile.
    *@param fileName reads the file
    * @throws IOException  If an input or output 
    *                      exception occurred 
    *@return ci
    */
   public CollegeInfo readFile(String fileName) throws IOException {
   
      Scanner userInput = new Scanner(System.in);
      
         
      boolean getCollege = true;
      while (getCollege) {
      
         if (fileName.trim().length() != 0) {
         
            //Scan in file
            Scanner inFile = new Scanner(new File(fileName));
         
            //Read College name
            collegeName = inFile.nextLine();
            
            //Read DeptInfo Objects    
            while (inFile.hasNext()) {
               dept.add(new DeptInfo(inFile.nextLine(), 
                     inFile.nextLine(), inFile.nextLine(),
                     Integer.parseInt(inFile.nextLine()),
                     Integer.parseInt(inFile.nextLine()),
                     Integer.parseInt(inFile.nextLine()),
                     Integer.parseInt(inFile.nextLine()),
                     Double.parseDouble(inFile.nextLine())));
            }
            inFile.close();
            break;
         }
      }
   
      
      CollegeInfo ci = new CollegeInfo(collegeName, dept);
   
      return ci;
      
      
   }
   
   /**
    *Summary.
    *@return output
    */ 
   public String summary() 
   {
      String output = "";
      // output += "----- Summary for " + getName() + " -----";
      output += "\nTotal Faculty: " + totalFaculty();
      output += "\nTotal Undergraduate Students: " + totalUgrads();
      output += "\nTotal Graduate Students: " + totalGrads();
      output += "\nDept with Most Undergraduate Students: ";
      output += deptWithMaxUgrads();
      output += "\nDept with Most Graduate Students: " + deptWithMaxGrads();
      output += "\nDept Research Funding: \n" + researchFundingReport();
   
   
      return output;
   }
    /**
    *Add DeptInfo.
    *@param nameIn becomes name
    *@param abbrevIn becomes abbrev
    *@param locationIn becomes location
    *@param numFacultyIn becomes numFaculty
    *@param numGtaIn becomes numGta
    *@param numUnderGradIn becomes numUnderGrad
    *@param numGradIn becomes numGrad
    *@param researchFundIn becomes researchFund
    */
   public void addDeptInfo(String nameIn, String abbrevIn,
      String locationIn, int numFacultyIn, 
      int numGtaIn, int numUnderGradIn, 
      int numGradIn, double researchFundIn) {
               
      DeptInfo newDept = new DeptInfo(nameIn, abbrevIn, locationIn, 
         numFacultyIn, numGtaIn, numUnderGradIn, numGradIn, researchFundIn);
         
      dept.add(newDept);      
   }
   
    /**
    *deleteDeptInfo.
    *@param abbrevIn becomes abbrev.
    *@return result
    */ 
   public boolean deleteDeptInfo(String abbrevIn) {
   
      boolean result = false;
      int index = -1;
      for (DeptInfo obj : dept) {
         if (obj.getAbbrev().equalsIgnoreCase(abbrevIn)) 
         {
            index = dept.indexOf(obj);
            break;
         }
      }
      
      if (index >= 0) {
         dept.remove(index);
         result = true;
      }
      return result;
   }
   
   /**
    *findDeptInfo.
    *@param abbrevIn becomes abbrev.
    *@return result
    */ 
   public String findDeptInfo(String abbrevIn) {
      int index = -1;
      String result = "";
      for (DeptInfo obj : dept) {
         if (obj.getAbbrev().equalsIgnoreCase(abbrevIn)) 
         {
            
            result = obj.toString();
            break;
         }
         else {
            result = "\t\"" + abbrevIn + "\" not found\n";
         }
      }
      
   
      return result;
   
     
   }
  
}