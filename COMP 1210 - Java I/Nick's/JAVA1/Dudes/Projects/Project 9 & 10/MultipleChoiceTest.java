   import org.junit.Assert;
   import org.junit.Test;

  /** Very basic tests for the MultipleChoiceTest. You will need to complete
   *  the test for the equals method at the bottom and add any more test 
	*  methods that you need for full statement coverage (there will need to 
	*  be a test for getCorrectOption for valid and invalid inputs). 
	*  The '50 character rule' for the question display can be tested in the 
	*  interactions pane.
	*
	*  The Web-CAT tests will be much more extensive than the tests below;
	*  make sure that you test your program thoroughly before submitting.
   **/
   public class MultipleChoiceTest {
   
     /** Tests the overloaded constructor. **/
      @Test public void constructor1Test() {
         String index = "4A";
         MultipleChoice mc = new MultipleChoice(index);
         Assert.assertEquals(index, mc.getQuestionIndex());
      }
   
     /** Tests the setQuestionText and getQuestionText method. **/
      @Test public void setQuestionTest() {
         MultipleChoice mc = new MultipleChoice();
         String question = "What is the answer?";
         mc.setQuestionText(question);
         Assert.assertEquals(question, mc.getQuestionText());
      }
      
   	/** Tests the setIndexText return with valid and 
   	 *  invalid inputs. Should return true with a valid input
   	 *  and false with an invalid input.
   	 **/
      @Test public void setQuestionIndexReturnTest() {
         MultipleChoice mc = new MultipleChoice();
         String validInput = "1234567890"; // 10 characters or less
         String invalidInput = "1234567890z"; // more than 10 characters
         Assert.assertTrue(mc.setQuestionIndex(validInput));
         Assert.assertFalse(mc.setQuestionIndex(invalidInput));
      }
      
   	/** Tests the setIndexText functionality with valid and 
   	 *  invalid inputs. 
   	 **/
      @Test public void setQuestionIndexTest() {
         MultipleChoice mc = new MultipleChoice();
         String validInput = "1234567890"; // 10 characters or less
         String invalidInput = "1234567890z"; // more than 10 characters
         mc.setQuestionIndex(validInput);
         Assert.assertEquals(validInput, mc.getQuestionIndex());
         mc.setQuestionIndex(invalidInput); // should not change index
         Assert.assertEquals(validInput, mc.getQuestionIndex());
      }
      
   	/** Makes sure that you can't add more than 53 answers to a multiple
   	 *  choice question.
   	 **/
      @Test public void addAnswerAndDisplayTest() {
         MultipleChoice mc = new MultipleChoice();
         // add 53 answers
         for (int i = 0; i < 53; i++) {
            mc.addAnswer("Answer " + i);
         }
      	// try to add another one - it should not be added!
         mc.addAnswer("Should not be added");
			mc.setQuestionText("What is the meaning of life?");
         String display = mc.displayQuestion();
         // make sure a valid answer was added
         Assert.assertTrue(display.contains("Answer 5"));
      	// make sure the invalid answer was not added
         Assert.assertFalse(display.contains("Should not be added"));
      }
      
   	/** A basic test for the question display.
   	 **/
      @Test public void displayTest() {
         MultipleChoice mc2 = new MultipleChoice("4a");
         mc2.setQuestionText("What does the Java compiler do? You "
            + "should also be making sure that lines with 50+ "
            + "characters are being written correctly; you can, "
            + "however, test that in interactions.");
         mc2.addAnswer("Run Java Programs");
         mc2.addAnswer("Compile Source Code");
         mc2.addAnswer("All of the above");
         mc2.setCorrectOption('B');
         String display = mc2.displayQuestion();
         Assert.assertTrue(display.contains("What does the"));
         Assert.assertTrue(display.contains("C. All of the above"));
			MultipleChoice mc3 = new MultipleChoice();
         mc3.setQuestionText("What does the Java compiler do? You "
            + "should also be making sure that lines with 50+ "
            + "characters are being written correctly; you can, "
            + "however, test that in interactions.");
         mc3.addAnswer("Run Java Programs");
         mc3.addAnswer("Compile Source Code");
         mc3.addAnswer("All of the above");
         mc3.setCorrectOption('B');
			char display2 = mc3.getCorrectOption();
			int i = (int) display2;
			Assert.assertTrue(i == 66);
			//Assert.assertTrue(display2.contains('B'));
         String display1 = mc3.displayQuestion();
         Assert.assertTrue(display1.contains("What does the"));
         Assert.assertTrue(display1.contains("C. All of the above"));
      }
      
   	/** A basic test for the question key.
   	 **/
      @Test public void keyTest() {
         MultipleChoice mc2 = new MultipleChoice("4a");
         mc2.setQuestionText("What does the Java compiler do? You "
            + "should also be making sure that lines with 50+ "
            + "characters are being written correctly; you can, "
            + "however, test that in interactions.");
         mc2.addAnswer("Run Java Programs");
         mc2.addAnswer("Compile Source Code");
         mc2.addAnswer("All of the above");
         mc2.setCorrectOption('B');
         String key = mc2.displayKey();
         Assert.assertTrue(key.contains("What does the"));
         Assert.assertTrue(key.contains("B. Compile Source Code"));
         Assert.assertFalse(key.contains("All of the above"));
      }
      
   	/** Checks the return of the equals method.
   	 **/
      @Test public void equalsTest() {
         MultipleChoice mc3 = new MultipleChoice("1");
			mc3.setQuestionText("This is a question?");
			
			MultipleChoice mc4 = new MultipleChoice("1");
			mc4.setQuestionText("This is a question?");
			Assert.assertTrue(mc3.equals(mc4));
			
			MultipleChoice mc5 = new MultipleChoice("2");
			mc5.setQuestionText("This is a question?");
			Assert.assertFalse(mc3.equals(mc5));
			
			MultipleChoice mc6 = new MultipleChoice("78");
			mc6.setQuestionText("This is the wrong question?");
			Assert.assertFalse(mc3.equals(mc6));
			
      }
      
   	// add more test methods below
   }
