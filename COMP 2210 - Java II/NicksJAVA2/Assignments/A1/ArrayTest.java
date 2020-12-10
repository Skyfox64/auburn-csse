import java.util.Arrays;

public class ArrayTest{

   public static void main(String[] args) {
   
      int[] a = {12,2,8,4,2,10};
      int k = 1;
   
      int kmin = 0;
      if (a.length == 0) {
         System.out.print(" -1");
      }
      else {
         int[] temp = (int[])a.clone();
         Arrays.sort(temp);
         int [] ranked = new int[temp.length];
         int uniqueCount = 0;
         for (int i=0;i<temp.length;i++) {
            boolean unique = true;
            for (int j=0;j<uniqueCount && unique;j++) {
               if (temp[i] == ranked[j]) {
                  unique = false;
               }
            }
            if (unique) {
               ranked[uniqueCount++] = temp[i];
            }
         }
         int[] temp2 = Arrays.copyOf(ranked, uniqueCount);
         
         System.out.print(temp2[-1 + k]);
      }
   
   }
   
}
