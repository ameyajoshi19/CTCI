class findAverage
{
	public static float divingScore(int[] scoreList)
	{
		if(scoreList.length == 0 || scoreList.length == 1 || scoreList.length == 2)
			return (float) -1;
		else
		{
			int sum = 0;
			float average = (float) 0;
			int min = scoreList[0];
			int max = scoreList[0];
			for(int i = 0; i < scoreList.length; i++)
			{
				if(scoreList[i] < min)
					min = scoreList[i];
				else if(scoreList[i] > max)
					max = scoreList[i];
				sum = sum + scoreList[i];
			}
			sum = sum - (min + max);
			average = (float) sum / scoreList.length;
			return average;
		}
	}

	public static void main(String args[])
	{
		findAverage fa = new findAverage();
		int scores[] = {1,2,3,4,5};
		float avg = divingScore(scores);
		if(avg == -1.0)
			System.out.println("Error in score list!");
		else
			System.out.println("Average score: " + avg);
	}
}