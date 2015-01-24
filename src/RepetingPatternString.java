/* Given an input string S write a function which returns true if it satisfies S = nT. 
 * Basically you have to find if a given string can be represented from a substring by
 * iterating it “n” times. n >= 2
 * 
 * For example – Function should return true if:
 * 1) S = “abab”
 * 2) S = “abcdabcd”
 * 3) S = “abcabcabc”
 * 4) S = “zzxzzxzzx”
 * 
 * Function should return false if:
 * 1) S = “abac”
 * 2) S = “abcdabbd”
 * 3) S = “abcabcefg”
 * 4) S = “zzxzzyzzx”
 */

public class RepetingPatternString
{
	boolean isRepetingPatternString(String str)
	{
		int len = str.length();
		int n;
		
		for(int i = 2; i < len/2; i++)
		{
			
		}
				
		return false;
	}
	
	
	int checkString(RepetingPatternString rps, String str, boolean expected)
	{
		boolean output = rps.isRepetingPatternString(str);
		System.out.println(str + ": " + output);
		if(expected ^ output == false)
			return 1;
		else
			return 0;
	}
	
	
	void runTestSuite(RepetingPatternString rps)
	{
		String s1 = "abaaba";
		String s2 = "abcabcabc";
		int errors = 0;
		int total = 2;
		
		System.out.println("Checking if strings are repetition of some patterns:");
		errors += rps.checkString(rps, s1, true);
		errors += rps.checkString(rps, s2, false);
		
		System.out.println("Passed: " + (total - errors) + " out of " + total);
		
	}
	
	/* The main method calls the runTestSuite() method which then checks if our code works */
	public static void main(String args[])
	{
		RepetingPatternString rps = new RepetingPatternString();
		
		rps.runTestSuite(rps);
	}
	
}
