public class Tester implements Comparable<Tester> {

   int a;
   int b;
   
   public Tester(int int1, int int2) {
      a = int1;
      b = int2;
   }
   
   public int compareTo(Tester array) {
      return this.a - array.a;
   }
   
   public String toString() {
      String toString = "(" + a + ", " + b + ")";
      return toString;
   }
  
}