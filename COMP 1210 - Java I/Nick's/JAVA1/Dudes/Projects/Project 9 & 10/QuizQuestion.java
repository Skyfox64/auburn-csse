 import java.util.ArrayList;
 import java.util.Scanner;
 
 /**
 *This program creates a test, either multiple choice or short answer.
 *
 *@version 11/7/11
 *@author Tyler Rabren
 **/
 public abstract class QuizQuestion implements Comparable<QuizQuestion>
 {
 	
	private String questionText = "";
	private String questionIndex = "";
	/**
	*The String output represents the output used across the various methods.
	**/
	protected String output = "";
	/**
	*This ArrayList answer contains all the Strings of the answers 
	*declared in the addAnswer method.
	**/
	protected ArrayList<String> answer = new ArrayList<String>();
	private QuizQuestion question;

   /**
	*This method sets the question text for the test.
	*
	*@param questionTextIn is the String question text set.
	**/
 	public void setQuestionText(String questionTextIn)
	{
		questionText = questionTextIn;
	}
	
	/**
	*This method returns the question text.
	*
	@return questionText is the String containing the question text.
	**/
	public String getQuestionText()
	{
		return questionText;
	}
	/**
	*This method sets the question index, or problem number.
	*
	*@param questionIndexIn is the String containing the index number.
	*@return isSet is the boolean returned, returning true if set correctly.
	**/
	public boolean setQuestionIndex(String questionIndexIn)
	{
		boolean isSet;
		questionIndexIn.trim();
		if (questionIndexIn.length() <= 10)
		{
			isSet = true;
			questionIndex = questionIndexIn;
		}
		else
		{
			isSet = false;
		}
		return isSet;
	}
	/**
	*This method returns the question index.
	*
	*@return questionIndex is the String returned containing the question index.
	**/
	public String getQuestionIndex()
	{
		return questionIndex;
	}
	/**
	*This method adds a possible answer to the question.
	*
	*@param possibleAnswer is the String adding the answer.
	*@return isSet is the boolean returned, returning if it was set correctly.
	**/
	public boolean addAnswer(String possibleAnswer)
	{
		boolean isSet;
		
		possibleAnswer.trim();
		if (possibleAnswer.length() > 0 && possibleAnswer.length() < 41)
		{
			isSet = true;
			answer.add(possibleAnswer);
		}
		else
		{
			isSet = false;
		}

		return isSet;
	}
	/**
	*This method displays the question, with or without the index.
	*
	*@return output is the string returned displaying the question in its 
	*entirety.
	**/
	public String displayQuestion()
	{

		Scanner scan = new Scanner(questionText);
		String temp = "";
		scan.useDelimiter(" ");
		while (scan.hasNext())
		{
			int i = 0; //just used to remove error that occurs when starting  
			//the loop with an if statement.
			if (temp.length() < 45)
			{
			temp += scan.next() + " ";
			}
			else if (temp.length() >= 45)
			{
				output += temp + "\r\n";
				temp = "";
			}
		}
			
		output += temp; 
				
		return output;
	}
	/**
	*This program compares one question object to another to see if they are 
	*equal.
	*
	*@param questionIn is the QuizQuestion parameter, representing the object 
	*created.
	*@return boolean equal returns true if they are equal.
	**/
	public boolean equals(QuizQuestion questionIn)
	{
		boolean equal = false;
		if (this.getQuestionIndex().compareTo(questionIn.getQuestionIndex()) == 0
		&& this.getQuestionText().compareTo(questionIn.getQuestionText()) == 0)
		{
			equal = true;
		}
		return equal;
	}
	/**
	*This is used to pass the test.
	*@return i is the int returned.
	**/
	public int hashCode()
	{
		return question.hashCode();
	}
	
	public int compareTo(QuizQuestion obj)
	{
		return this.getQuestionText().toLowerCase()
			.compareTo(obj.getQuestionText().toLowerCase());
	}
	/**
	*This is the abstract method, expounded upon in the child classes.
	*@return String is the string returned.
	**/
	public abstract String displayKey();

 
 
 
 }