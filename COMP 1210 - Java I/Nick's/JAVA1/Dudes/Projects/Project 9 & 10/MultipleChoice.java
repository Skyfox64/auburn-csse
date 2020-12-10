import java.util.ArrayList;
/**
*This child class creates a multiple choice question, complete
*wih answers and an answer key.
*
*@author Tyler Rabren
*@version 11/7/11
**/
public class MultipleChoice extends QuizQuestion
{
	private ArrayList<Character> multi = new ArrayList<Character>();
	protected char choice;
	private int correctIndex;
	private char correctAnswer;
	
	/**
	*This is an empty constructor.
	**/
	public MultipleChoice()
	{
	}
	/**
	*This is a constructor that takes an index as a parameter.
	*
	*@param index is the String of the question's index.
	**/
	public MultipleChoice(String index)
	{
		super.setQuestionIndex(index);
	}
	
	/**
	*This method adds a multiple choiec answer for the question text.
	*
	*@param possibleAnswer is the String parameter that is the answer.
	*@return isSet is the boolean returned, returning true if set correctly.
	**/
	public boolean addAnswer(String possibleAnswer)
	{
		boolean isSet;
		if (answer.size() < 52)
		{
			super.addAnswer(possibleAnswer);
			if (multi.size() == 0)
			{
				choice = 'A';
				multi.add(choice);
			}
			else
			{
				
				int i = (int) choice;
				if (i == 90)
				{
					i += 7;
					char choiceIn = (char) i;
					choice = choiceIn;
					multi.add(choiceIn);
				}
				else
				{
					i++;
					char choiceIn = (char) i; 
					choice = choiceIn;
					multi.add(choiceIn);
					
				}
				
			}
			isSet = true;
		}
		else
		{
			isSet = false;
		}
		return isSet;
	}
	/**
	*This method displays the multiple choice question.
	*
	*@return output is the String returned.
	**/
	public String displayQuestion()
	{	
		
		String answers = "";
		
		for (int i = 0; i < answer.size(); i++)
		{
				answers += multi.get(i) + ". " + answer.get(i) + "\r\n";
		}
		
		if (getQuestionIndex() != null)
		{
			output = "Question " + getQuestionIndex() + ":" + "\r\n"
			+ super.displayQuestion() + "\r\n" + answers;
		}
		else
		{
			output = super.displayQuestion() + "\r\n" + answers;
		}

		return output;
	}
	/**
	*This method displays the question and only the correct answer.
	*
	*@return output is the String returned with the question and the right 
	*answer.
	**/
	public String displayKey()
	{
		String answers = "";
		
		for (int i = 0; i < answer.size(); i++)
		{
				
				answers = multi.get(correctIndex) + ". " 
				+ answer.get(correctIndex) + "\r\n";
		}
		
		if (getQuestionIndex() != null)
		{
			output = "Question " + getQuestionIndex() + ":" + "\r\n"
			+ super.displayQuestion() + "\r\n" + answers;
		}
		
		return output;
	}
	/**
	*This method defines which option is the correct one.
	*
	*@param correctIn is the char representing the corect multiple choice.
	*@return isSet is the boolean, returning true if set correctly.
	**/
	public boolean setCorrectOption(char correctIn)
	{
		boolean isSet = false;
		
				for (correctIndex = 0; correctIndex < multi.size(); correctIndex++)
				{
					multi.get(correctIndex);
					if (multi.get(correctIndex) == correctIn)
					{
						isSet = true;
						correctAnswer = multi.get(correctIndex);
						break;
					}
					else
					{
						isSet = false;
					}
				}
	
		return isSet;
	}
	/**
	*This method returns the corect option.
	*
	*@return correctAnswer is the char representing the correct option.
	**/
	public char getCorrectOption()
	{
		return correctAnswer;
	}
}