import java.util.Arrays; 

public class HospitalSearch {

   public static void main(String[] args) {
   
   // create an array of 'people'
      Person[] people = new Person[5];
      people[0] = new Doctor("Bob", "Smith", "Floor 1", "none");
      people[1] = new MaternityPatient("Ann", "Aber", 1975, 14);
      people[2] = new Staff("Pat", "Lane", "", "Nurse", "none");
      people[3] = new Doctor("Lindsey", "Jones", "Floor 2", "none");
      people[4] = new ICUPatient("Lynn", "Harris", 253, 1992);
      
   	// Sanders via linear search
      Person found = null;
      for (Person p : people) {
         if(p.getLastName().equals("Sanders")) {
            found = p;
         }
      }
   	
      if (found == null) {
         System.out.println("Person not found.\r\n");
      }
      else {
         System.out.println(found + "\r\n");
      }
   	
   	// find last name "Jones" via binary search
      Arrays.sort(people);
      int min = 0, max = people.length - 1, mid = 0;
      Person foundBin = null;
   	
      while (foundBin == null && min <= max) {
         mid = (min + max) / 2; // find center
         int compare = people[mid].getLastName().compareTo("Jones");
         if (compare == 0) {
            foundBin = people[mid];
         }
         else {
            if (compare < 0) {
               max = mid - 1;
            }
            else {
               min = mid + 1;
            }
         }
      }
      
      if (foundBin == null) {
         System.out.println("Person not found.");
      }
      else {
         System.out.println(foundBin);
      }
   }
}