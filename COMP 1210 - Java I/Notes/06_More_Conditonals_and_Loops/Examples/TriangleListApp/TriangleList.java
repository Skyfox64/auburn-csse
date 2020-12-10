import java.util.ArrayList;

public class TriangleList {
   String listName;
   ArrayList<Triangle> tList;
   
   public TriangleList(String listNameIn, ArrayList<Triangle> tListIn) {
      listName = listNameIn;
      tList = tListIn;
   }
   
   public String getListName() {
      return listName;
   }
   
   public int numTriangles() {
      return  tList.size();
   }

   public double smallestPerimeter() {
      double smallest = 0;
   
      if (tList.size() != 0) {
         smallest = tList.get(0).perimeter();
      }
      else {
         return 0;
      }
      
      int index = 0;
      while (index < tList.size()) {
         if (!(smallest < tList.get(index).perimeter())) {
            smallest = tList.get(index).perimeter();
         }
         index++;  
      }   
      
      return smallest;
   }

   public String largestPerimeterWithSides() {
      double largest = 0;
      int indexOfLargest = 0;
      int index = 0;
      while (index < tList.size()) {
         if (tList.get(indexOfLargest).perimeter() < tList.get(index).perimeter()) {
            indexOfLargest = index;
         }
         index++;  
      }   
      
      return tList.get(indexOfLargest).perimeter()
         + " for sides "
         + tList.get(indexOfLargest).getS1() + ", " 
         + tList.get(indexOfLargest).getS2() + ", " 
         + tList.get(indexOfLargest).getS3();
   }
   
   public String toString() {
      String result = "\n" + listName + "\n";
      int index = 0;
      while (index < tList.size()) {
         result += "\n" + tList.get(index) + "\n"; 
         index++;  
      }   
      return result;
   }
}
