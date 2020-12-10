import java.text.DecimalFormat;
/**
*
* @Author: John Carroll
* @Version: 9-21-2013
* Assignment Due Date: 9-23-2013
*
* The DeptInfo class has fields, a constructor, and methods as 
* instructed.
* 
*
*/

public class DeptInfo
//DeptInfo.java
{
   //______Fields:______
   //Instance Variables(8):
   private String name;
   private String abbrev;
   private String location;
   private int numFaculty;
   private int numGta;
   private int numUnderGrad;
   private int numGrad;
   private double researchFund;
   //Constants used to calculate the
   //Viability Index:
   /**Constant for Min.*/
   public static final int MIN_FACULTY = 10;
   /**Constant for Min.*/
   public static final int MIN_UGRAD = 200;
   /**Constant for Min.*/
   public static final int MIN_GRAD = 50;
   

   /**
   *________Constructor:________.
   *@param nameIn becomes name
   *@param abbrevIn becomes abbrev
   *@param locationIn becomes location
   *@param numFacultyIn becomes numFaculty
   *@param numGtaIn becomes numGta
   *@param numUnderGradIn becomes numUnderGrad
   *@param numGradIn becomes numGrad
   *@param researchFundIn becomes researchFund
   */
   public DeptInfo(String nameIn, String abbrevIn,
      String locationIn, int numFacultyIn, 
      int numGtaIn, int numUnderGradIn, 
      int numGradIn, double researchFundIn)
   {
      name = nameIn.trim();
      abbrev = abbrevIn.trim();
      location = locationIn.trim();
      numFaculty = numFacultyIn;
      numGta = numGtaIn;
      numUnderGrad = numUnderGradIn;
      numGrad = numGradIn;
      researchFund = researchFundIn;
      
   }   
   
   
   //________Methods:________
   //Name of city_______________________________
   /**
   *getName.
   *@return name
   */
   public String getName()
   {
      return name;
   }
   
   /**
   *setName.
   *@param nameIn sets name
   *@return true or false
   */
   public boolean setName(String nameIn)
   {   
      if (nameIn == null || nameIn.isEmpty()) 
      {
         return false;
      }
      else 
      {
         name = nameIn.trim();
         return true;
      }
   }
   
   //Abbreviation________________________________
   /**
   *getAbbrev.
   *@return abbrev
   */
   public String getAbbrev()
   {
      return abbrev;
   }
   
   /**
   *setAbbrev.
   *@param abbrevIn gsts abbrev
   *@return true or false
   */
   public boolean setAbbrev(String abbrevIn)
   {   
      if (abbrevIn == null || abbrevIn.isEmpty()) 
      {
         return false;
      }
      else 
      {
         abbrev = abbrevIn.trim();
         return true;
      }
   }
   
   //Location____________________________________
   /**
   *getLocation.
   *@return location
   */
   public String getLocation()
   {
      return location;
   }
  
   /**
   *getLocation.
   *@param locationIn sets location
   *@return true or false
   */
   public boolean setLocation(String locationIn)
   {   
      if (locationIn == null || locationIn.isEmpty()) 
      {
         return false;
      }
      else 
      {
         location = locationIn.trim();
         return true;
      }
   }
   
   //Number of Faculty___________________________
   /**
   *getNumFaculty.
   *@return numFaculty
   */
   public int getNumFaculty()
   {
      return numFaculty;
   }
   
   /**
   *setNumFaculty.
   *@param num is a value
   */
   public void setNumFaculty(int num)
   {
      numFaculty = num;
   }   
   
   //Number of GTA's_____________________________
   /**
   *getNumGradAssts.
   *@return numGta
   */
   public int getNumGradAssts()
   {
      return numGta;
   }
   
   /**
   *setNumNumGradAssts.
   *@param num is a value
   */
   public void setNumGradAssts(int num)
   {
      numGta = num;
   }
   
   //Number of Undergraduates____________________
   /**
   *getNumUgrads.
   *@return numUnderGrad
   */
   public int getNumUgrads()
   {
      return numUnderGrad;
   }
   
   /**
   *setNumUgrads.
   *@param num is a value
   */
   public void setNumUgrads(int num)
   {
      numUnderGrad = num;
   }
   
   //Number of Graduate Students_________________
   /**
   *getNumGrads.
   *@return numGrad
   */
   public int getNumGrads()
   {
      return numGrad;
   }
   
   /**
   *setNumUgrads.
   *@param num is a value
   */
   public void setNumGrads(int num)
   {
      numGrad = num;
   }
    
   //Amount of research funding_________________
   /**
   *getResFunding.
   *@return researchFund;
   */
   public double getResFunding()
   {
      return researchFund;
   }
   
   /**
   *setResFunding.
   *@param num is a double value
   */
   public void setResFunding(double num)
   {
      researchFund = num;
   }
   
   //Calculate the total number of students______
   /**
   *totalStudents.
   *@return numUnderGrad + numGrad
   */
   public int totalStudents()
   {         
      return numUnderGrad + numGrad;
   }
   
   //Calculate the AVG funding per Faculty_______
   /**
   *avgFundingPerFaculty.
   *@return researchFund/numFaculty
   */
   public double avgFundingPerFaculty()
   {
      return researchFund / numFaculty;
   }   
   
   //Calculate the Viability Index_______________
   /**
   *viabilityIndex.
   *@return output
   */
   public double viabilityIndex()
   {
      double output = ((numFaculty / (double) MIN_FACULTY)
         + (numUnderGrad / (double) MIN_UGRAD)
         + (numGrad / (double) MIN_GRAD));
      return output;
   }
   
   //Print the data______________________________
   /**
   *toString.
   *@return output
   */
   public String toString() 
   {
      //Formatting
      DecimalFormat twoDecimals = new DecimalFormat("#,###.##");
      DecimalFormat currency = new DecimalFormat("$#,##0.00");
      DecimalFormat commas = new DecimalFormat("#,###");
      
      //Printing Output
      String output = name + " (" + abbrev + ")\n";
      output += "Location: "  + location + "\n";
      output += "Faculty: " + numFaculty + "   GTA: " + numGta + "\n";
      output += "Students: " + commas.format(numUnderGrad) + "(UG)   ";
      output += commas.format(numGrad) + "(G)   ";
      output += commas.format(totalStudents()) + "(total)\n";
      output += "Research Funding: " + currency.format(researchFund);
      output += "   Avg/Fac: " + currency.format(avgFundingPerFaculty());
      output += "\n" + "Viability Index: ";
      output += twoDecimals.format(viabilityIndex()) + "\n";
      return output;
   }
}