public class FindSecondLargest
{
	public static int findSecondLargest(int[] list)
	{
		int largest = Integer.MIN_VALUE;
		int second_largest = Integer.MIN_VALUE;
		
		for(int i = 0; i < list.length; i++)
		{
			if(list[i] > largest)
			{
				second_largest = largest;
				largest = list[i];
			}
			else if(list[i] > second_largest)
				second_largest = list[i];
		}
		
		return second_largest;
	}
	
	public static void main(String[] args)
	{
		int[] list = {1,5,7,2,4,9};
		int second = findSecondLargest(list);
		System.out.println("Second largest: " + second);
	}
}
