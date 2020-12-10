import java.util.Scanner;
import java.io.File;
import java.util.NoSuchElementException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.text.DecimalFormat;


/**
* This class provides methods for reading in the data file and
* generating reports.
*
* @author John Carroll
* @version 12-5-2013
*/
public class Provider
{
  /**
   * Fields.
   *===========================================================**/
   
   /** name is the name of the provider. */
   private String name = "not yet assigned";
      /** phones is an array of type CellPhone. */
   private CellPhone[] phones = new CellPhone[0];
   /** excludedRecords is a String array. */
   private String[] excludedRecords = new String[0];

  /** 
   * Consructor: CellPhone.
   *============================================================**/
   public Provider() {
   }

   /**
   * Methods.
   *============================================================**/   
      
   
   
   /** Method used to read the CellPhone file.
    * @param fileIn is the file being read in.
    * @throws IOException  If an input or output 
    *                      exception occurred      
    */
   public void readCellPhoneFile(String fileIn) throws IOException
   {
      Scanner fileScan = new Scanner(new File(fileIn));
      name = fileScan.nextLine();
   
      while (fileScan.hasNext()) {
         String cellPhoneIn = fileScan.nextLine();
         Scanner cellPhoneScan = new Scanner(cellPhoneIn);
         cellPhoneScan.useDelimiter(",");
      
         String number;
         int texts, minutes, data, iMessages, hotSpotMinutes;
      
         char type = cellPhoneScan.next().charAt(0);
      
         try {
            switch (type) {
            
               case 'F':
                  number = cellPhoneScan.next();
                  texts = Integer.parseInt(cellPhoneScan.next());
                  minutes = Integer.parseInt(cellPhoneScan.next());
               
               
                  FlipPhone flip = new FlipPhone(number, texts, minutes);
                  addPhone(flip);
               
                  break;
            
               case 'S':
                  number = cellPhoneScan.next();
                  texts = Integer.parseInt(cellPhoneScan.next());
                  minutes = Integer.parseInt(cellPhoneScan.next());
                  data = Integer.parseInt(cellPhoneScan.next());
               
               
                  SmartPhone smart;
                  smart = new SmartPhone(number, texts, minutes, data);
                  addPhone(smart);
                  break;
            
               case 'I':
                  number = cellPhoneScan.next();
                  texts = Integer.parseInt(cellPhoneScan.next());
                  minutes = Integer.parseInt(cellPhoneScan.next());
                  data = Integer.parseInt(cellPhoneScan.next());
                  iMessages = Integer.parseInt(cellPhoneScan.next());
               
                  IPhone i;
                  i = new IPhone(number, texts, minutes, data, iMessages);
                  addPhone(i);
                  break;
            
               case 'A':
                  number = cellPhoneScan.next();
                  texts = Integer.parseInt(cellPhoneScan.next());
                  minutes = Integer.parseInt(cellPhoneScan.next());
                  data = Integer.parseInt(cellPhoneScan.next());
                  hotSpotMinutes = Integer.parseInt(cellPhoneScan.next());
               
                  Android a = new Android(number, texts, minutes, data, 
                     hotSpotMinutes);
                  addPhone(a);
                  break;
               
               default:
               
                  String output = "Invalid Category: ";
                  output += cellPhoneIn;
               
                  addExcludedRecord(output);
                 
                  break;      
            }
         }
         catch (NumberFormatException e)
         {
            String error = e + " (NFE) in: " + cellPhoneIn;
            addExcludedRecord(error);
         }
         catch (NegativeValueException e)
         {
            String error = e + " (NVE) in: " + cellPhoneIn;
            addExcludedRecord(error);
         }
         catch (NoSuchElementException e)
         {
            String error = e + " (NSEE) in: " + cellPhoneIn;
            addExcludedRecord(error);
         }
      }
   }
  
  /** Method used to get the name.
      * @return name specifies name used. */
   public String getName()
   {
      return name;
   }
  
   /** Method used to set the name.
    * @param nameIn specifies name used. */
   public void setName(String nameIn)
   {
      name = nameIn;
   }
  
   /** Method used to get the phones.
    * @return phones specifies phones used. */
   public CellPhone[] getPhones()
   {
      return phones;
   }
   
   /** Method used to get the excluded records.
    * @return excludedRecords specifies excludedRecords sought after. */
   public String[] getExcludedRecords()
   {
      return excludedRecords;
   }
   
   /** Method used to add a phone.
    * @param phoneIn specifies the phone being added. */
   public void addPhone(CellPhone phoneIn)
   {
      int length = phones.length;
      CellPhone[] newPhones = new CellPhone[length + 1];
      for (int i = 0; i < length; i++)
      {
         newPhones[i] = phones[i];
      }
      newPhones[length] = phoneIn;
      phones = newPhones;
   }
   
   /** Method used to delete a phone.
    * @param numberIn specifies the phone being deleted. 
    * @return result specifies if it was deleted. */
   public boolean deletePhone(String numberIn) {
      boolean deleted = false;
      CellPhone[] catcher = new CellPhone[phones.length];
      for (int i = 0; i < phones.length; i++) {
         if (phones[i].getNumber().equals(numberIn)) {
            deleted = true;
         }
         else {
            catcher[i] = phones[i];
         }
      }
      phones = catcher;
      // trim the null vlues from catcher if anything was deleted
      if (deleted) {
         CellPhone[] catcherFixed = new CellPhone[catcher.length - 1];
         int counter = 0;
         for (int i = 0; i < catcher.length; i++) {
            if (catcher[i] != null) {
               catcherFixed[counter] = catcher[i];
               counter++;
            }
         }
         phones = catcherFixed;
      }
      return deleted;
   }

   /** Method used to add a excluded record.
    * @param recordIn specifies the excluded record being added. */
   public void addExcludedRecord(String recordIn)
   {
      int length = excludedRecords.length;
      String[] newExcludedRecords = new String[length + 1];
      for (int i = 0; i < length; i++)
      {
         newExcludedRecords[i] = excludedRecords[i];
      }
      newExcludedRecords[length] = recordIn;
      excludedRecords = newExcludedRecords;
   }
   
   /** Method used to output the information. 
    * @return output specifies the stringed information. */
   public String toString()
   {
      String output = "";
      for (int i = 0; i < phones.length; i++)
      {
         output += "\n" + phones[i] + "\n";
      }
      return output;
   }
   
   /** Method used to calculate the total bill.
    * @return total specifies the calculated total bill amount. */
   public double calculateTotalBill()
   {
      double total = 0.0;
      for (int i = 0; i < phones.length; i++)
      {
         total += phones[i].calculateBill();
      }
      return total;
   }
   
   /** Method used to calculate the total number of texts.
    * @return texts specifies the calculated total number of texts. */
   public int calculateTotalTexts()
   {
      int texts = 0;
      for (int i = 0; i < phones.length; i++)
      {
         texts += phones[i].getTexts();
      }
      return texts;
   }
   
   /** Method used to calculate the total number of minutes.
    * @return minutes specifies the calculated total number of minutes. */
   public int calculateTotalMinutes()
   {
      int minutes = 0;
      for (int i = 0; i < phones.length; i++)
      {
         minutes += phones[i].getMinutes();
      }
      return minutes;
   }
   
   /** Method used to calculate the total amount of data used.
    * @return data specifies the calculated total amount of data used. */
   public int calculateTotalData()
   {
      int data = 0;
      for (int i = 0; i < phones.length; i++)
      {
         if (phones[i] instanceof SmartPhone) {
            data += ((SmartPhone) phones[i]).getData();
         }
      }
      return data;
   }
   
   /** Method used to calculate the total number of hotspot minutes used.
    * @return hotSpot specifies the total number of hotspot minutes used. */
   public int calculateTotalHotspotMin()
   {
      int hotSpot = 0;
      for (int i = 0; i < phones.length; i++)
      {
         if (phones[i] instanceof Android) {
            hotSpot += ((Android) phones[i]).getHotspotMin();
         }
      }
      return hotSpot;
   }
   
   /** Method used to calculate the total number of iMessages used.
    * @return iMessages specifies the total number of iMessages used. */
   public int calculateTotalIMessages()
   {
      int iMessages = 0;
      for (int i = 0; i < phones.length; i++)
      {
         if (phones[i] instanceof IPhone) {
            iMessages += ((IPhone) phones[i]).getIMessages();
         }
      }
      return iMessages;
   }
   
   /** Method used to output the summary. 
    * @return output specifies the displayed information. */
   public String summary()
   {
      DecimalFormat currency = new DecimalFormat("$#,##0.00");
      String output = "------------------------------"; 
      output += "\nSummary for " + getName();
      output += "\n------------------------------";
      output += "\nNumber of cell phones: " + CellPhone.getCellPhoneCount();
      output += "\nTexts: " + calculateTotalTexts();
      output += "\nTalk Minutes: " + calculateTotalMinutes();
      output += "\nData: " + calculateTotalData();
      output += "\nHotspot Minutes: " + calculateTotalHotspotMin();
      output += "\niMessages: " + calculateTotalIMessages();
      output += "\nBill Total: " + currency.format(calculateTotalBill()) + "\n";
      return output;
   }
   
   /** Method used to output the rates. 
    * @return output specifies the displayed information. */
   public String rates()
   {
      DecimalFormat currency = new DecimalFormat("$#,##0.00");
   
   
      String output = "------------------------------";
      output += "\nRates for " + getName();
      output += "\n------------------------------";
      output += "\nFlipPhone Talk Rate: " 
         + currency.format(FlipPhone.TALK_RATE);
      output += "   Text Rate: " + currency.format(FlipPhone.TEXT_RATE);
      output += "\nSmartPhone Talk Rate: "
          + currency.format(SmartPhone.TALK_RATE);
      output += "   Text Rate: " 
         + currency.format(SmartPhone.TEXT_RATE);
      output += "   Max Talk Time: " + SmartPhone.MAX_TALK_TIME;
      output += "\n   iPhone iMessage Rate: " 
         + currency.format(IPhone.IMESSAGE_RATE);
      output += "\n   Android Hotspot Rate: " 
         + currency.format(Android.HOTSPOT_RATE) + "\n";
      return output;
   }
   
   /** Method used to output the information, listed by number. 
    * @return output specifies the displayed information. */
   public String listByNumber()
   {
      String listByNumber = "------------------------------"
         + "\nCell Phones by Number"
         + "\n------------------------------\n";
      
      Arrays.sort(phones, 
            new Comparator<CellPhone>()
            {
               public int compare(CellPhone one, CellPhone two)
               {
                  return one.getNumber().compareTo(two.getNumber());
               }
            });
      
      for (int i = 0; i < phones.length; i++)
      {
         listByNumber += "\n" + phones[i] + "\n";
      }
      return listByNumber + "\n";
   }

   /** Method used to output the information, listed by bill. 
    * @return output specifies the displayed information. */
   public String listByBill()
   {
      String output = "";
      Arrays.sort(phones, new CellPhoneBillComparator());
      output += "------------------------------";
      output += "\nCell Phones by Billing Amount";
      output += "\n------------------------------\n\n";
      for (CellPhone c : phones) 
      {
         output += c.toString() + "\n\n";
      }
      return output;
   }
   
   /** Method used to output the excluded records list. 
    * @return output specifies the displayed information. */
   public String excludedRecordsList()
   {
      String output = "";
      output += "------------------------------";
      output += "\nExcluded Records";
      output += "\n------------------------------\n\n";
      for (int i = 0; i < excludedRecords.length; i++) 
      {
         output += excludedRecords[i] + "\n";
      }
      return output;
   }
}