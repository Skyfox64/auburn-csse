   /**
    * Provides the basis for keeping track of people in a hospital
	 * (patients and workers). Includes a name and location. Sub classes
	 * must define how IDs will be generated for the person.
    * @author Lauren Goff
    */
   public abstract class Person implements Comparable<Person> {
      protected String firstName, lastName, location;
    
      public Person(String firstNameIn, String lastNameIn, String locationIn) {
         firstName = firstNameIn;
         lastName = lastNameIn;
         location = locationIn;
      }
      
      public abstract String getId();
         	
      public String getFirstName() {
         return firstName;
      }
      
      public String getLastName() {
         return lastName;
      }
      
      public String getLocation() {
         return location;
      }
      
   	// compares based on last name
      public int compareTo(Person personIn) {
         return this.getLastName().compareTo(personIn.getLastName());
      }
      
      public String toString() {
         return "Name: " + lastName + ", " + firstName 
            + " (" + getId() + ")";
         /* Note that the getId method can be invoked even though
      	   it is abstract. */ 
      	
      }
   }