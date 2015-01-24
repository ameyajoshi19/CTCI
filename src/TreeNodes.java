public class TreeNodes
{
	int data;
	TreeNodes left, right, parent;
	
	public TreeNodes(int value)
	{
		data = value;
	}
	
	public static TreeNodes insertNode(TreeNodes t, int value)
	{
		if(t == null)
		{
			TreeNodes x = new TreeNodes(value);
			t = x;
			t.parent = null;
			System.out.println("Inserted " + value + "\n");
		}
		else
		{
			if(t.data > value)
			{
				System.out.println("Going left...");
				t.left = insertNode(t.left, value);
				t.left.parent = t;
			}
			else
			{
				System.out.println("Going right...");
				t.right = insertNode(t.right, value);
				t.right.parent = t;
			}
		}
		return t;
	}
	
	public static void preOrder(TreeNodes t)
	{
		if(t == null)
			return;
		else
		{
			System.out.print(t.data + " ");
			preOrder(t.left);
			preOrder(t.right);
		}
	}
	
	public static void postOrder(TreeNodes t)
	{
		if(t == null)
			return;
		else
		{
			postOrder(t.left);
			postOrder(t.right);
			System.out.print(t.data + " ");
		}
	}
	
	public static void inOrder(TreeNodes t)
	{
		if(t == null)
			return;
		else
		{
			inOrder(t.left);
			System.out.print(t.data + " ");
			inOrder(t.right);
		}
	}
	
	public static int heightTree(TreeNodes t)
	{
		if(t == null)
			return 0;
		else
		{
			int x = heightTree(t.left);
			int y = heightTree(t.right);
			if(x > y)
				return (x + 1);
			else
				return (y + 1);
		}
	}
	
	public static int nodeCount(TreeNodes t)
	{
		if(t == null)
			return 0;
		else if(t.left == null && t.right == null)
			return 1;
		else
		{
			int x = nodeCount(t.left);
			int y = nodeCount(t.right);
			return (x + y + 1);
		}
	}
	
	public static int leafCount(TreeNodes t)
	{
		if(t == null)
			return 0;
		else if(t.left == null && t.right == null)
			return 1;
		else
		{
			int x = leafCount(t.left);
			int y = leafCount(t.right);
			return (x + y);
		}
	}
	
	public static int maxInTree(TreeNodes t)
	{
		if(t == null)
			return (Integer) null;
		else
		{
			while(t.right != null)
				t = t.right;
			return t.data;
		}
	}
	
	public static boolean isCompleteBinaryTree(TreeNodes t)
	{
		if(t == null)
			return false;
		else if(t.left == null && t.right == null)
			return true;
		else
		{
			boolean x = isCompleteBinaryTree(t.left);
			boolean y = isCompleteBinaryTree(t.right);
			return (x && y);
		}
	}
	
	public static int maxDepth(TreeNodes t)
	{
		if(t == null)
			return 0;
		else
			return 1 + Math.max(maxDepth(t.left), maxDepth(t.right));
	}
	
	public static int minDepth(TreeNodes t)
	{
		if(t == null)
			return 0;
		else
			return 1 + Math.min(minDepth(t.left), minDepth(t.right));
	}
	
	public static boolean isBalanced(TreeNodes t)
	{
		if(t == null)
			return false;
		else
		{
			int max = maxDepth(t);
			int min = minDepth(t);
			
			if (min == max)
				return true;
			else
				return false;
		}
	}
	
	public static TreeNodes findSuccessor(TreeNodes t, int v)
	{
		if(t == null)
			return null;
		
		while(t.data != v)
		{
			if(t.data > v)
				t = t.left;
			else
				t = t.right;
		}
				
		/* Now find the successor. */
		
		if(t.right != null)
		{
			t = t.right;
			while(t.left != null)
				t = t.left;
			return t;
		}
		else
		{
			while(t.parent.left != t)
				t = t.parent;
			return t.parent;
		}

	}
	
	public static TreeNodes findPredecessor(TreeNodes t, int v)
	{
		if(t == null)
			return null;
		
		TreeNodes temp;
		/* Find the node with value v in the tree. */
		if(t.data == v)
			temp = t;
		else
		{
			while(t.data != v)
			{
				if(t.data > v)
					t = t.left;
				else
					t = t.right;
			}
		}
		
		/* Now find the predecessor. */
		if(t.left != null)
		{
			t = t.left;
			while(t.right != null)
				t = t.right;
			return t;
		}
		else
		{
			while(t.parent.right != t)
				t = t.parent;
			return t.parent;
		}
	}
	
	public static TreeNodes leastCommonAncestor(TreeNodes t, int v1, int v2)
	{
		if(t == null)
			return null;
		else if(t.data == v1 || t.data == v2)
			return t;
		else
		{
			while((t.data > v1) && (t.data > v2) || (t.data < v1) && (t.data < v2))
			{
				if(t.data < v1)
					t = t.right;
				else
					t = t.left;
			}
			return t;
		}
	}
	
	public static TreeNodes leastCommonAncestorUsingRecursion(TreeNodes t, int v1, int v2)
	{
		if(t == null)
			return null;
		else if(t.data == v1 || t.data == v2)
			return t;
		else
		{
			TreeNodes t1 = leastCommonAncestorUsingRecursion(t.left, v1, v2);
			TreeNodes t2 = leastCommonAncestorUsingRecursion(t.right, v1, v2);
			
			if(t1 != null && t2 != null)
				return t;
			else
			{
				if(t1 != null)
					return t1;
				else
					return t2;
			}
		}
	}
	
	
	public static void main(String[] args)
	{
		TreeNodes myTree = new TreeNodes(5);
		
		System.out.println("Root node: " + myTree.data + "\n");
		System.out.println("Inserting new nodes: \n");
		
		insertNode(myTree, 2);
		insertNode(myTree, 8);
		insertNode(myTree, 3);
		insertNode(myTree, 1);
		insertNode(myTree, 7);
		insertNode(myTree, 9);
		insertNode(myTree, 4);
		
		
		System.out.println("\n\nPre Order:");
		preOrder(myTree);
		
		System.out.println("\n\nIn Order:");
		inOrder(myTree);
		
		System.out.println("\n\nPost Order:");
		postOrder(myTree);
		
		System.out.println("\n\nHeight of the tree: " + heightTree(myTree));
		System.out.println("Remember, height is the number of levels in a tree!");
		
		System.out.println("\nNumber of leaves in the tree: " + leafCount(myTree));
		
		System.out.println("\nNumber of nodes in the tree: " + nodeCount(myTree));
		
		System.out.println("\nLargest node in the tree: " + maxInTree(myTree));
		
		System.out.println("\nIs the tree complete binary tree?: " + isCompleteBinaryTree(myTree));
		System.out.println("Remember, complete binary tree is that tree in which all nodes, except leaf nodes, have 2 children!");
		
		System.out.println("\nMaximum Depth of the tree: " + maxDepth(myTree));
		System.out.println("Minimum Depth of the tree: " + minDepth(myTree));
		System.out.println("\nUsing minimum and maximum depth to check if tree is balanced...");
		System.out.println("Is tree balanced?: " + isBalanced(myTree));
		System.out.println("Remember, balanced binary tree is the one whose left and right subtrees have same height!");
		
		System.out.println("\nSuccessor to 5 is: " + findSuccessor(myTree, 5).data);
		
		System.out.println("\nPredecessor to 5 is: " + findPredecessor(myTree, 5).data);
		
		System.out.println("\nLeast Common Ancestor of 1 & 7 is: " + leastCommonAncestor(myTree, 1, 7).data);
		
		System.out.println("\nLeast Common Ancestor of 1 & 7 using Recusion is: " + leastCommonAncestorUsingRecursion(myTree, 1, 7).data);

	}

}
