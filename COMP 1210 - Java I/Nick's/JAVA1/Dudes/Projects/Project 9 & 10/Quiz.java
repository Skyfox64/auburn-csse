import java.util.ArrayList;
import java.util.Collections;

public class Quiz extends QuizQuestion
{
	
	public int MULTIPLE_CHOICE = 0;
	public int SHORT_ANSWER = 1;
	public int ALL_QUESTIONS = 2;
	public int QUESTION_LENGTH = 3;
	public int INDEX = 4;
	public int CATEGORY = 5;
	ArrayList<QuizQuestion> questions = new ArrayList<QuizQuestion>();
	private String name = "";
	
	public Quiz()
	{
		name = "Today's Quiz";
	}
	
	public Quiz(String nameIn)
	{
		name = nameIn;
	}
	
	public boolean setName(String nameIn)
	{
		boolean isSet = false;
		nameIn.trim();
		if (nameIn.isEmpty() == false && nameIn != "")
		{
			isSet = true;
			name = nameIn;
		}
		return isSet;
	}

	public String getName()
	{
		return name;	
	}
	
	public boolean addQuestion(QuizQuestion obj)
	{	
		boolean isSet = false;
		/*if (questions.contains(obj) == false || obj.getQuestionIndex() == "")
		{
			questions.add(obj);
			isSet = true;
		}*/
		
		for (int i = 0; i < questions.size(); i++)
		{
			if (questions.get(i).equals(obj) == false)
			{
				isSet = true;
				questions.add(obj);
				break;
			}
			else
			{
				isSet = false;
			}
		}
		return isSet;
	}
	
	public int removeQuestion(String index)
	{
		int num = 0;
		for (int i = 0; i < questions.size(); i++)
		{
			if (questions.get(i).getQuestionIndex().contains(index))
			{
				questions.remove(i);
				num++;
			}
		
		}
		return num;
	}
	
	public ArrayList<QuizQuestion> questionList()
	{
		return questions;
	}
	
	public ArrayList<QuizQuestion> questionList(int questionType)
	{
		ArrayList<QuizQuestion> temp = new ArrayList<QuizQuestion>();
		if (questionType == MULTIPLE_CHOICE)
		{
			for (QuizQuestion question : questions)
			{
				if (question instanceof MultipleChoice)
				{
					temp.add(question);
				}
			}
		}
		else if (questionType == SHORT_ANSWER)
		{
			for (QuizQuestion question : questions)
			{
				if (question instanceof ShortAnswer)
				{
					temp.add(question);
				}
			}
		}
		else if (questionType == ALL_QUESTIONS)
		{
			for (QuizQuestion question : questions)
			{
				if (question instanceof QuizQuestion)
				{
					temp.add(question);
				}
			}
		}
		return temp;
	}
	
	public ArrayList<QuizQuestion> questionList(int questionType, int sortType)
	{
		
		/*ArrayList<QuizQuestion> temp = new ArrayList<QuizQuestion>();
		if (questionType == MULTIPLE_CHOICE)
		{
			for (QuizQuestion question : questions)
			{
				if (question instanceof MultipleChoice)
				{
					temp.add(question);
				}
			}
		}
		else if (questionType == SHORT_ANSWER)
		{
			for (QuizQuestion question : questions)
			{
				if (question instanceof ShortAnswer)
				{
					temp.add(question);
				}
			}
		}
		else if (questionType == ALL_QUESTIONS)
		{
			for (QuizQuestion question : questions)
			{
				if (question instanceof QuizQuestion)
				{
					temp.add(question);
				}
			}
		}*/
		return null;
	}
	
	
	
	public String displayKey()
	{
		return null;
	}



}