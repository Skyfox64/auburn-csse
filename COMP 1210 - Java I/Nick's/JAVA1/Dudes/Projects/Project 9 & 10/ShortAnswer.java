/**
*This child class creates a short answer question, complete
*with an answer key.
*
*@author Tyler Rabren
*@version 11/7/11
**/
public class ShortAnswer extends QuizQuestion
{
	/**
	*This is an empty constructor.
	**/
	public ShortAnswer()
	{
	}
	/**
	*This constructor contains the index as the parameter.
	*
	*@param s is the String representing the index.
	**/
	public ShortAnswer(String s)
	{
		super.setQuestionIndex(s);
	}
	
	/**
	*This method displays the question.
	*
	*@return output is the String returned, repesenting the full question.
	**/
	public String displayQuestion()
	{
		if (getQuestionIndex() != null)
		{
			output = "Question " + getQuestionIndex() + ":" + "\r\n"
			+ super.displayQuestion();
		}
		else
		{
			output = super.displayQuestion();
		}
		
		return output;
	}
	
	/**
	*This method displays the question with the right answer.
	*
	*@return output returns the String as well as the correct answer.
	**/
	public String displayKey()
	{
		String answers = "";
		
		for (int i = 0; i < answer.size(); i++)
		{
				answers += answer.get(i) + "\r\n";
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
	









}