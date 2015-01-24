public class PrintParan
{
	public static void printPar(int l, int r, char[] str, int count)
	{
		if(l < 0 || r < 0)
			return;
		if(l == 0 && r == 0)
			System.out.println(str);
		else
		{
			if(l > 0)
			{
				str[count] = '(';
				printPar(l - 1, r, str, count + 1);
			}
			if(r > l)
			{
				str[count] = ')';
				printPar(l, r - 1, str, count + 1);
			}
		}
	}
	
	public static void main(String args[])
	{
		int count = 3;
		char str[] = new char[count * 2];
		printPar(count, count, str, 0);
	}
}
