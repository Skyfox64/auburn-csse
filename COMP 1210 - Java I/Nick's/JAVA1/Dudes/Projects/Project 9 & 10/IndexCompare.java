public class IndexCompare extends QuizQuestion implements Comparable<QuizQuestion>
{
	public int compareTo(QuizQuestion obj)
	{
		int result = 0;
		
		for (int i = 0; i < answer.size(); i++)
		{
			char a = this.getQuestionIndex().charAt(i);
			char b = obj.getQuestionIndex().charAt(i);
			
			if (a > b)
			{
			
			}
		
		}
		return this.compareTo(obj);
	}
	
	public int compare(QuizQuestion obj, QuizQuestion obj2)
	{
		return obj.getQuestionIndex().compareToIgnoreCase(obj2.getQuestionIndex());
	}
	

	public String displayKey()
	{
		return null;
	}






}