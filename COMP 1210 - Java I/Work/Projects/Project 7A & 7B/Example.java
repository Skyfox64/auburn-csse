public class Example {
   public static void main (String[] args) {
      String[] myGrades = {"a90", "a100", "q90", "q80", "p100", "e87.5", "f90"}; 
      WeightedGrades2 wg = new WeightedGrades2("your name", 7, myGrades);
      boolean flag = wg.deleteLowestGrade('a');
   }
}