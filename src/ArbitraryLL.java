import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

/* This class is used to create an instance of a single node.
 * This node will have its data, a pointer to the next node,
 * and an arbitrary pointer which may point to any node in the list */
class Node
{
	int data;
	Node next;
	Node arbitrary;
	
	public Node()
	{
		next = null;
		arbitrary = null;
	}
	
	public Node(int data)
	{
		this.data = data;
		next = null;
		arbitrary = null;
	}
}

/* This class is used to instantiate a list having an arbitrary pointer
 * along with the usual pointer for the next node. */
public class ArbitraryLL
{
	Node head;
	
	/* The parameterized constructor initiates the list and creates the head of the list. */ 
	public ArbitraryLL(Node n)
	{
		head = n;
	}
	
	/* This method adds an element to the end of the list. */
	public static void addElement(ArbitraryLL list, int v)
	{
		Node last = new Node(v);
		
		Node current = list.head;
		
		while(current.next != null)
		{
			current = current.next;
		}
		current.next = last;
		last.next = null;
	}
	
	
	/* This method will set the arbitrary pointers in the list. */
	public static void setArbitraryPointers(ArbitraryLL list, int len)
	{
		Node head = list.head;
		Node first, second, third;
		
		first = head.next;
		second = first.next;
		third = second.next;
		
		head.arbitrary = second;
		first.arbitrary = third;
		second.arbitrary = first;
		third.arbitrary = head;
	}
	
	/* This method clones the given ArbitraryLL and creates its copy. */
	public static ArbitraryLL cloneArbitraryLL(ArbitraryLL list)
	{
		/* Create copy of each node and store it the same linked list.
		 * The first_node will point to the copy_of_first_node and
		 * the copy_of_first_node will point to the second_node and so on. */
		
		Node current = list.head;
		while(current != null)
		{
			Node newNode = new Node(current.data);
			if(current.next != null)
				newNode.next = current.next;
			current.next = newNode;
			current = current.next.next;
		}
		
		/* Now, we set the arbitrary pointers of the newly created nodes similar
		 * to the arbitrary pointers of the original nodes. That is, if the 
		 * original_arbit_of_first points to third_node, then clone_arbit_of_first
		 * will point to clone_third_node. For this, we iterate through the
		 * combined list and "original->next->arbit = original->arbit->next".*/
		
		current = list.head;
		while(current != null)
		{
			if(current.arbitrary.next != null)
				current.next.arbitrary = current.arbitrary.next;
			current = current.next.next;
		}
		
		/* Now that the two lists have their arbit pointers set, we need to separate
		 * these lists. For this, we iterate over the lists and change the next pointers
		 * of nodes restoring the original list and creating the cloned list. */
		
		ArbitraryLL old = new ArbitraryLL(list.head);
		ArbitraryLL clone = new ArbitraryLL(list.head.next); 
		Node oldList = old.head;
		Node newList = old.head.next;
		
		while(newList.next != null)
		{
			oldList.next = oldList.next.next;
			newList.next = newList.next.next;
			oldList = oldList.next;
			newList = newList.next;
		}
		
		return clone;
	}
	
	public static void iterateList(ArbitraryLL list)
	{
		Node current = list.head;
		while(current != null)
		{
			System.out.println("Current node -> " + current.data);
			if(current.next != null)
				System.out.println("Next -> " + current.next.data);
			System.out.println("Arbitrary -> " + current.arbitrary.data);
			System.out.println();
			current = current.next;
		}
	}
	
	public static void main(String[] args)
	{
		Node n = new Node(1);
		ArbitraryLL LL = new ArbitraryLL(n);
		
		addElement(LL, 2);
		addElement(LL, 3);
		addElement(LL, 4);
		
		setArbitraryPointers(LL, 4);
		System.out.println("---Original List---\n");
		iterateList(LL);
		
		ArbitraryLL clone = cloneArbitraryLL(LL);
		
		System.out.println("---Cloned List---\n");
		iterateList(clone);

	}

}
