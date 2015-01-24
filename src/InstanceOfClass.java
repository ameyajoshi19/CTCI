public class InstanceOfClass
{
	static
	{
		System.out.println("static block");
	}
	
	public static void main(String args[])
	{
		A a = new B();
		System.out.println(a instanceof A);
		System.out.println(a instanceof B);
	}
}

class A
{
	String b;
	public A()
	{
		b = "string A";
		System.out.println("A");
	}
}

class B extends A
{
	String b;
	public B()
	{
		b = "string B";
		System.out.println(b);
		System.out.println("B");
	}
}