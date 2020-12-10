   class InvalidTriangleException extends RuntimeException {
   
      public InvalidTriangleException() {
         super("Invalid triangle sides.");
      }
      
      public InvalidTriangleException(String message) {
         super(message); 	
      }
   
   }
