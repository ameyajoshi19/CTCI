package practice.dynamicProg;

import java.util.ArrayList;

public class LongestZigzag
{
	/* A list of integers is called zigzag when the difference between
	 * the consecutive numbers alternates between +ve and -ve. That is,
	 * 1, 3, 2 is a zigzag list because (3-1) is 2 (+ve) and (2-3) is
	 * -1 (-ve). This method finds the longest sequence of zigzags in
	 * a given list of integers using DYNAMIC PROGRAMMING! */
	
	public static int longestZigZag(int[] list)
	{	
		if(list.length == 1)
			return 1;
		
		ArrayList<Integer> v = new ArrayList<Integer>();
		for(int i = 1; i < list.length; i++)
		{
			v.add(list[i] - list[i - 1]);
		}
		
		int j = 0;
		while(j < list.length && v.get(j) == 0)
			j++;
		if(j == v.size())
			return 1;
		
		int dir = v.get(j);
		int longest = 2;
		
		for(int i = j+1; i < v.size(); i++)
		{
			if(v.get(i) * dir < 0)
			{
				dir *= -1;
				longest++;
			}
		}
		return longest;
	}
	
	public static void main(String[] args)
	{
		int arr[] = {1, 3, 2, 7, 9, 2, 5, 6};
		
		System.out.println("Longest zigzag: " + longestZigZag(arr));
		
	}

}
