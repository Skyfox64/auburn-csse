   public class PrintHospital {
   
      public static void main(String[] args) {
         Person[] personArray = new Person[3];
         
         Person p = new Patient("Jane", "Lane", "US", 1970);
         personArray[0] = p;
         
         //p = new Doctor("Joan", "Doe", "Lab", "none");
         personArray[1] = new Doctor("Joan", "Doe", "Lab", "none");
      	
         //p = new MaternityPatient("Bob", "Smith", 1980, 40);
         personArray[2] = new MaternityPatient("Bo", "Smith", 1980, 40);
      	
         for (Person pObj : personArray) {
            System.out.println(pObj.getId());
         }
      }
   }