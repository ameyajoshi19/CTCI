import java.util.HashMap;
import java.util.Map;

public class PermutString {

	/**
	 * @param args
	 */
	
	public static void permute(String head, String tail)
	{
        if (tail.isEmpty())
        {
            System.out.println(head);
        }
        else
        {
            Map<Character, Boolean> seen = new HashMap<Character, Boolean>();
            for (int i = 0; i < tail.length(); i++)
            {
                if (!seen.containsKey(tail.charAt(i)))
                {
                    seen.put(tail.charAt(i), true);
                    permute(head + tail.charAt(i), tail.substring(0, i) + tail.substring(i + 1, tail.length()));
                }
            }
        }
    }

    public static void main(String[] args)
    {
        permute("", "abc");
    }
    
}
