package practice.dynamicProg;

public class DivideArrayEqualSum
{

	/* This method returns true if there is a subset of arr[] with
	 * sum equal to the given sum. */
	public static boolean isSubsetSum(int[] arr, int len, int sum)
	{
		// Base cases
		if(sum == 0)
			return true;
		if(len == 0 && sum != 0)
			return false;
		
		// If last element is greater than sum, then ignore it.
		if(arr[len - 1] > sum)
			return isSubsetSum(arr, len - 1, sum);
		
		/* Else, check if the sum can be obtained by any of the following
		 * (a) including the last element
		 * (b) excluding the last element. */
		return isSubsetSum(arr, len - 1, sum) || isSubsetSum(arr, len - 1, sum - arr[len - 1]);
	}
	
	/* This method returns true if arr[] can be partitioned in two subsets
	 * of equal sum, otherwise returns false. */
	public static boolean isPartition(int arr[], int len)
	{
		// Calculate the sum of the integers in the array.
		int sum = 0;
		for(int i = 0; i < arr.length; i++)
			sum += arr[i];
		
		// If the sum is odd, there cannot be a partition with equal sum.
		if(sum % 2 == 1)
			return false;
		
		// Find if there is a subset sum equal to the half of total sum
		return isSubsetSum(arr, len, sum / 2);
	}
	
	/* This method does the exact same thing but using dynamic programming. */
	public static boolean isPartitionUsingDP(int[] arr, int len)
	{
		int sum = 0;
		int i, j;
		
		// Calculate the sum of all elements.
		for(i = 0; i < len; i++)
			sum += arr[i];
		
		if(sum % 2 == 1)
			return false;
		
		boolean[][] part = new boolean[sum/2 + 1][len + 1];
		
		// Initialize the top row as true.
		for(j = 0; j <= len; j++)
			part[0][j] = true;
		
		// Initialize the leftmost column, except part[0][0] as false.
		for(i = 1; i <= sum/2; i++)
			part[i][0] = false;
		
		// Fill in the partition table in the bottom up manner.
		for(i = 1; i <= sum/2; i++)
		{
			for(j = 1; j <= len; j++)
			{
				part[i][j] = part[i][j-1];
				if(i >= arr[j - 1])
					part[i][j] = part[i][j] || part[i - arr[j-1]][j-1];
			}
		}
		
		// Print the table.
		for(i = 0; i <= sum/2; i++)
		{
			for(j = 0; j<= len; j++)
				System.out.print(part[i][j] + "\t");
			System.out.println();
		}
		
		return part[sum/2][len];
	}
	
	public static void main(String[] args)
	{
		int arr[] = {3, 1, 2, 6};
		System.out.println("Finding using recursion -> Can be divided into subsets with equal sum? " + isPartition(arr, arr.length));
		System.out.println("Finding using dynamic prog -> Can be divided into subsets with equal sum? " + isPartitionUsingDP(arr, arr.length));

	}

}
