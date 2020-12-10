/**
 * This class is made to throw exceptions to negative numbers.
 * This class extends the Exception class.
 *
 * @author John Carroll
 * @version 12-5-2013
 */
public class NegativeValueException extends Exception 
{
/**
 * Constructor: NegativeValueException.
 * @param message is the exception message.
 */
   public NegativeValueException(String message) {
      super(message);
   }

}