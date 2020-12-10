  /**
   * Represents a polygon with a specified number of sides
   * lengths. The polygon is classified based on its number of sides.
   *
   * @author Lauren Goff
   */
   public class Polygon {
      
      private double[] sideLengths;
		private double[] sidesGreaterThanParameter;

		
      public Polygon(double[] sidesIn) {
         setSides(sidesIn); 
      }
      
      public void setSides(double[] sidesIn) {  
         sideLengths = sidesIn != null ? sidesIn : sideLengths;
      }
   
      public double[] getSides() {  
         return sideLengths;
      }
		
		public double calculatePerimeter() {
			double perimeter = 0;
			
			for (int index = 0; index < sideLengths.length; index++)
			{
			perimeter += sideLengths[index];
			}
			return perimeter;
		}
		
		public double[] getSidesGreaterThan(double value)
		{
			int sides = 0;
			
			for (int index = 0; index < sideLengths.length; index++)
			{
				if (sideLengths[index] > value)
				{
					sides++;
				}
			}
			double[] theSides = new double[sides];
			
			int count = 0;
			for (int index = 0; index < sideLengths.length; index++)
			{
				if (sideLengths[index] > value)
				{
					theSides[count] = sideLengths[index];
					count++;
				}
			}
			return theSides;
		}
      
      public String toString() {
         switch (sideLengths.length) {
            case 0:
            case 1:
            case 2:
               return "non-polygon";
            case 3:
               return "triangle";
            case 4:
               return "rectangle";
            case 5:
               return "pentagon";
            case 6:
               return "hexagon";
            case 7:
               return "heptagon";
            case 8:
               return "octagon";
            default:
               return "n-gon";
         }   
      }   
   }
