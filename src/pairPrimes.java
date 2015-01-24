import java.util.HashSet;

public class pairPrimes
{
	public static boolean isPrime(int num)
	{
		int count = 0;
		for(int i = 1; i <= num; i++)
		{
			if(num % i == 0)
				count++;
		}
		if(count == 2)
			return true;
		else
			return false;
	}
	
	public static int reverseNumber(int num)
	{
		int reverse = 0;
		while(num != 0)
		{
			reverse = reverse * 10;
			reverse = reverse + num % 10;
			num = num/10;
		}
		return reverse;
	}
	
	public static void findPairPrimes(int from, int to)
	{
		HashSet<Integer> seen = new HashSet<Integer>();
		int rev;
		int count = 0;
		
		for(int i = from; i <= to; i++)
		{
			rev = reverseNumber(i);
			if(isPrime(i) && isPrime(rev))
			{
				if(!seen.contains(i) && i < rev)
				{
					count++;
					System.out.println(count + ": " + i + " " + rev);
					seen.add(i);
				}
			}
		}
	}
	public static void main(String[] args)
	{
		findPairPrimes(1, 1000);
	}

}
