  /**
  *This program keeps track of times that athletes spend running three
  *race events.
  *
  *@author Tyler Rabren
  *@version 10/14/11
  **/
  
   public class RunnerTimes
   {
      private String name;
      private char raceType;
      private double ratedAverage;
      private double nonRatedAverage;
      private double practiceAverage;
      private double[] ratedRace;
      private double[] nonRatedRace;
      private double[] practiceRace;

      
      
   	
   	/**
   	*This constructor states the parameters and sets them equal to 
   	*outside variables.
   	*@param userName is the String representing an individual runner. 
   	*@param raceA is a double array representing one of the three races 
   	*@param raceB is a double array representing one of the three races 
   	*@param raceC is a double array representing one of the three races
   	**/
      public RunnerTimes(String userName, double[] raceA, double[] raceB, 
      double[] raceC)
      {
         name = userName;
         ratedRace = raceA;
         nonRatedRace = raceB;
         practiceRace = raceC;
      }
       /**
   	 *This method sets the times for each race.
   	 *
   	 *@return boolean isSet is true when the times are correctly set.
   	 *@param race specifies which race.
   	 *@param times is the double array representing the times for the race.
   	 **/
      public boolean setTimes(char race, double[] times)
      {
         boolean isSet = false;

         if (race == 'A' || race == 'a')
         {
            ratedRace = times;
				isSet = true;
         }
         else if (race == 'B' || race == 'b')
         {
            nonRatedRace = times;
				isSet = true;
         }
         else if (race == 'C' || race == 'c')
         {
            practiceRace = times;
				isSet = true;
         }
			else  
         {
            isSet = false;
         }
         return isSet;
      }
   	 /**
   	 *This method gets the times for the race specified.
   	 *
   	 *@return is a double containing the times for the race.
   	 *@param race specifies which race.
   	 **/
      public double[] getTimes(char race)
      {
			double[] times = new double[0];
			
         if (race == 'a' || race == 'A')
			{
				times = ratedRace;
				return times;
			}
			else if (race == 'b' || race == 'B')
			{	
				times = nonRatedRace;
				return times;
			}
			else if (race == 'c' || race == 'C')
			{
				times = practiceRace;
				return times;
			}
			else
			{
				return times;
			}
      }
   	 /**
   	 *This method takes the average times of each race.
   	 *
   	 *@return average is the double containing the average of times.
   	 *@param race specifies which race.
   	 **/
      public double averageTimes(char race)
      {
         double average = 0;
         double sum = 0;
      	double sum1 = 0;
			double sum2 = 0;    
			
         if (race == 'a' || race == 'A')
         {
		      for (int index = 0; index < ratedRace.length; index++)
            {
               sum += ratedRace[index];
               average = sum / ratedRace.length;
            }
				ratedAverage = average;
				if (ratedRace.length == 0)
				{
					average = 0;
				}
			}
				
         else if (race == 'b' || race == 'B')
         {

	         for (int index = 0; index < nonRatedRace.length; index++)
            {
               sum += nonRatedRace[index];
               average = sum / nonRatedRace.length;
            }
				nonRatedAverage = average;
				if (nonRatedRace.length == 0)
				{
					average = 0;
				}
         }
         else if (race == 'c' || race == 'C')
         {
            for (int index = 0; index < practiceRace.length; index++)
            {
               sum += practiceRace[index];
               average = sum / practiceRace.length;
            }
				practiceAverage = average;
				if (practiceRace.length == 0)
				{
				average = 0;
				}
         }
         else if (race == '0')
         {
            	for (int index = 0; index < ratedRace.length; index++)
            	{
               	sum += ratedRace[index];
					}
				
            	for (int index = 0; index < nonRatedRace.length; index++)
            	{
               	sum1 += nonRatedRace[index];
					}

            	for (int index = 0; index < practiceRace.length; index++)
            	{
            	   sum2 += practiceRace[index];
					}
				
					average = (sum + sum1 + sum2) / (ratedRace.length 
					+ nonRatedRace.length + practiceRace.length);
				
					if (ratedRace.length == 0 && nonRatedRace.length == 0 
					&& practiceRace.length == 0)
					{
						average = 0;
					}
				
         }
         else
         {
            average = -1.0;
         }
         return average;
      }
   	 /**
   	 *This method adds all the times of each race.
   	 *
   	 *@return double is the sum of all times.
   	 *@param race specifies which race. 
   	 **/
      public double totalRaceTimes(char race)
      {
         double sum = 0;
      
         if (race == 'a' || race == 'A')
         {
            for (int index = 0; index < ratedRace.length; index++)
            {
               sum += ratedRace[index];
            }
				if (ratedRace.length == 0)
				{
					sum = 0;
				}
         }
         else if (race == 'b' || race == 'B')
         {
            for (int index = 0; index < nonRatedRace.length; index++)
            {
               sum += nonRatedRace[index];
            }
				if (nonRatedRace.length == 0)
				{
					sum = 0;
				}
         }
         else if (race == 'c' || race == 'C')
         {
            for (int index = 0; index < practiceRace.length; index++)
            {
               sum += practiceRace[index];
            }
				if (practiceRace.length == 0)
				{
					sum = 0;
				}
         }
         else
         {
            sum = -1;
         }
         return sum;
      }
   	  /**
   	  *This method adds all the times of all the races.
   	  *
   	  *@param race specifies which race and newTimes is the 
   	  *variable length parameter list. 
   	  *@param newTimes is the variable length parameter list.
   	  **/	
      public void addTimes(char race, double ... newTimes)
      {
         
         if (race == 'a' || race == 'A')
         {
				int position = 0;
				
				double[] times2 = new double[ratedRace.length + newTimes.length];
		
            for (int index = 0; index < ratedRace.length; index++)
            {
               times2[index] = ratedRace[index];
					position++;
            }
				
				for (int index = 0; index < newTimes.length; index++)
				{
					times2[position] = newTimes[index];
					position++;
				}
				ratedRace = times2;
         }
         else if (race == 'b' || race == 'B')
         {
				int position = 0;
				double[] times2 = new double[nonRatedRace.length + newTimes.length];
				
            for (int index = 0; index < nonRatedRace.length; index++)
            {
               times2[index] = nonRatedRace[index];
					position++;
            }
				for (int index = 0; index < newTimes.length; index++)
				{
					times2[position] = newTimes[index];
					position++;
				}
				nonRatedRace = times2;
         }
         else if (race == 'c' || race == 'C')
         {
				int position = 0;
				double[] times2 = new double[practiceRace.length + newTimes.length];
				
            for (int index = 0; index < practiceRace.length; index++)
            {
               times2[index] = practiceRace[index];
					position++;
            }
				for (int index = 0; index < newTimes.length; index++)
				{
					times2[position] = newTimes[index];
					position++;
				}
				practiceRace = times2;
         }
      }
   	  /**
   	  *This method determines the best race.
		  @return race specifies which race to use.
   	  **/
      public char bestRace()
      {
         char race = 0;
			double sum1 = 0;
			double sum2 = 0;
			double sum3 = 0;
			double averageA = 0;
			double averageB = 0;
			double averageC = 0;
      	
			
			for (int index = 0; index < ratedRace.length; index++)
            {
               sum1 += ratedRace[index];
               averageA = sum1 / ratedRace.length;
            }
				ratedAverage = averageA;
			for (int index = 0; index < nonRatedRace.length; index++)
            {
               sum2 += nonRatedRace[index];
               averageB = sum2 / nonRatedRace.length;
            }
				nonRatedAverage = averageB;
			for (int index = 0; index < practiceRace.length; index++)
         {
              sum3 += practiceRace[index];
              averageC = sum3 / practiceRace.length;
         }
			practiceAverage = averageC;


         if (ratedAverage < nonRatedAverage
         && ratedAverage < practiceAverage)
         {
            race = 'A';
         }
         if (nonRatedAverage < ratedAverage 
         && nonRatedAverage < practiceAverage)
         {
            race = 'B';
         }
         if (practiceAverage < nonRatedAverage 
         && practiceAverage < ratedAverage)
         {
            race = 'C';
         }
      	
         return race;
      }
   	  /**
   	  *This method determines which race was the worst.
   	  *
   	  *@return race returns the worst race.
   	  **/
      public char worstRace()
      {	
         char race = 0;
      	double sum1 = 0;
			double sum2 = 0;
			double sum3 = 0;
			double averageA = 0;
			double averageB = 0;
			double averageC = 0;
      	
			
			for (int index = 0; index < ratedRace.length; index++)
            {
               sum1 += ratedRace[index];
               averageA = sum1 / ratedRace.length;
            }
				ratedAverage = averageA;
			for (int index = 0; index < nonRatedRace.length; index++)
            {
               sum2 += nonRatedRace[index];
               averageB = sum2 / nonRatedRace.length;
            }
				nonRatedAverage = averageB;
			for (int index = 0; index < practiceRace.length; index++)
         {
              sum3 += practiceRace[index];
              averageC = sum3 / practiceRace.length;
         }
			practiceAverage = averageC;
			
         if (ratedAverage > nonRatedAverage 
         && ratedAverage > practiceAverage)
         {
            race = 'A';
         }
         if (nonRatedAverage > ratedAverage 
         && nonRatedAverage > practiceAverage)
         {
            race = 'B';
         }
         if (practiceAverage > nonRatedAverage 
         && practiceAverage > ratedAverage)
         {
            race = 'C';
         }
      	
         return race;
      }
   	  /**
   	  *This method takes a RunnerTimes object as a parameter
   	  *and returns an int value.
   	  *
   	  *@return int is the int value representing whether it all worked.
   	  *@param runner is the RunnerTimes object returned.
   	  **/
      public int compareRunners(RunnerTimes runner)
      {
      	double sumRaceTimes;
      	double sumRunner;
      	int comparisonResult = 0;
      	
      	sumRaceTimes = totalRaceTimes('A') + totalRaceTimes('B')
      	+ totalRaceTimes('C');
      	
      	sumRunner = runner.totalRaceTimes('A') + runner.totalRaceTimes('B')
      	+ runner.totalRaceTimes('C');
      	
      	if (sumRaceTimes < sumRunner)
      	{
      		comparisonResult = -1;
      	}
      	else if (sumRaceTimes > sumRunner)
      	{
      		comparisonResult = 1;
      	}
      	else if (sumRaceTimes == sumRunner)
      	{
      		comparisonResult = 0;
      	}
      	
         return comparisonResult;
      }
   	  /**
   	  *This toString method gives the necessary output.
   	  *
   	  *@return output is the String returned.
   	  **/
      public String toString()
      {
         String output = "Runner's name: " + name
            + "Rated race times: " + ratedRace + "Non-rated race times: " 
            + nonRatedRace + "Practice race times: " + practiceRace;
         return output;
      }
   }