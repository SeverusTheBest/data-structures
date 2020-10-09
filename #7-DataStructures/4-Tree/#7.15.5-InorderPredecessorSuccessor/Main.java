import java.util.*;
public class Main {
	public static void main(String[] args) {
		BinarySearchTree tree = new BinarySearchTree();	
		//--------testcase-1------------
		// tree.insert(10);
		// tree.insert(6);
		// tree.insert(15);
		// tree.insert(3);
		// tree.insert(8);
		// tree.insert(20);

		//--------testcase-2------------
		tree.insert(10);
		tree.insert(6);
		tree.insert(15);
		tree.insert(3);
		tree.insert(8);
		tree.insert(20);
		tree.insert(2);
		tree.insert(4);
		tree.insert(18);
		tree.insert(24);
		System.out.println(tree.findInorderPredecessor(24));


		System.out.println(tree.findInorderSuccessor(20));
	}
}


// Input:Tree1
// 		  	      10
// 			6			15
// 		3		8			20	
// <------------------------------------>
// Input:Tree2
// 		  	      10
// 			6			15
// 		3		8			20	
// 	 2    4			     18	   24

class Node {
	private Node left, right;
	private int value;

	public Node(int value) {
		this.value = value;
		this.left = null;
		this.right = null;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public void setLeft(Node leftValue) {
		this.left = leftValue;
	}

	public void setRight(Node rightValue) {
		this.right = rightValue;
	}

	public int getValue() {
		return this.value;
	}

	public Node getLeft() {
		return this.left;
	}

	public Node getRight() {
		return this.right;
	}

}


class BinarySearchTree {
	private Node root;

	public BinarySearchTree() {
		this.root = null;
	}

	public void setRoot(int rootValue) {
		this.root = new Node(rootValue);
	}

	public Node getRoot() {
		return this.root;
	}


	public boolean insert(int value) {
		Node newNode = new Node(value);
		Node iterator = this.root;
		if(this.root==null) {
			this.root = newNode;
			return true;
		} else {
			while(true) {
				if(newNode.getValue() == iterator.getValue()) {
					return false;
				} 
				if(newNode.getValue() > iterator.getValue()) {
					if(iterator.getRight() == null) {
						iterator.setRight(newNode);
						return true;
					} else {
						iterator = iterator.getRight();
					}
				} else {
					if(iterator.getLeft() == null) {
						iterator.setLeft(newNode);
						return true;
					} else {
						iterator = iterator.getLeft();
					}
				}
			}
		}
	}

	public Node find(int value) {
		Node nodeToFind = new Node(value);
		if(this.root == null) {
			return null; 
		}
		Node iterator = this.root;
		while(true) {
			if(nodeToFind.getValue() == iterator.getValue()) {
				return iterator;
			}
			if(nodeToFind.getValue() > iterator.getValue()) {
				if(iterator.getRight() == null) {
					return null;
				} else {
					iterator = iterator.getRight();
				}
			} else {
				if(iterator.getLeft() == null) {
					return null;
				} else {
					iterator = iterator.getLeft();
				}
			}
		}
	}


	//INORDER PREDECESSOR- means yeh value se exact chota wala value.
	//INORDER SUCCESSOR- means yeh value se exact bada wala value.


	// =-=-=-=-=-=-=-=-=___Important Part___-=-=-=-=-=-=-=-=-=-
	// takes the node jiska predecessor find karna hai using bfs
	// return -1 nd msg if not found
	// find that node in the tree then =>
	// find largest elem. in the left subtree
	// if no left subtree, start from the node again
	// and return the node(elem) from where we took the last right.
	public int findInorderPredecessor(int nodeValue) {
		Node currentNode = find(nodeValue);
		if(currentNode == null) {
			System.out.println("No such node present");
			return -1;
		} else if(currentNode.getLeft() != null) {
			currentNode = currentNode.getLeft();
			while(currentNode.getRight() != null) {
				currentNode = currentNode.getRight();
			}
			return currentNode.getValue();
		} else {
			if(currentNode == this.root) {
				System.out.println("This is the root node and the *ONLY* node"+
					" and hence no inorder predecessor.");
				return -1;
			}
			Node iterator = this.root;
			currentNode = new Node(-1);
			while(iterator.getValue() != nodeValue) {
				if(iterator.getValue() > nodeValue) {
					iterator = iterator.getLeft();
				} else if(iterator.getValue() < nodeValue) {
					currentNode = iterator;
					iterator = iterator.getRight();
				}
			}
			if(currentNode.getValue() == -1) {
				System.out.println("That means the node to find is the "+
					"left most node hence no inorder predecessor.");
				System.out.println("TLDR: it is the smallest element in the tree."+
					", hence no inorder predecessor.");
				return -1;
			} else {
				return currentNode.getValue();
			}
		}

	}  

	//NOTE: basically ulta of what we do in finding predecessor
	// =-=-=-=-=-=-=-=-=___Important Part___-=-=-=-=-=-=-=-=-=-
	// takes the node jiska predecessor find karna hai using bfs
	// return -1 nd msg if not found
	// find that node in the tree then =>
	// find smallest elem. in the right subtree
	// if no right subtree, start from the node again
	// and return the node(elem) from where we took the last left.
	public int findInorderSuccessor(int nodeValue) {
		Node currentNode = find(nodeValue);
		if(currentNode == null) {
			System.out.println("No such node present");
			return -1;
		} else if(currentNode.getRight() != null) {
			currentNode = currentNode.getRight();
			while(currentNode.getLeft() != null) {
				currentNode = currentNode.getLeft();
			}
			return currentNode.getValue();
		} else {
			if(currentNode == this.root) {
				System.out.println("This is the root node and the *ONLY* node"+
					" and hence no inorder predecessor.");
				return -1;
			}
			Node iterator = this.root;
			currentNode = new Node(-1);
			while(iterator.getValue() != nodeValue) {
				if(iterator.getValue() > nodeValue) {
					currentNode = iterator;
					iterator = iterator.getLeft();
				} else if(iterator.getValue() < nodeValue) {
					iterator = iterator.getRight();
				}
			}
			if(currentNode.getValue() == -1) {
				System.out.println("That means the node to find is the "+
					"right most node hence no inorder successor.");
				System.out.println("TLDR: it is the largest element in the tree."+
					", hence no inorder successor.");
				return -1;
			} else {
				return currentNode.getValue();
			}
		}

	}  




	public void display() {
		if(this.root == null) {
			System.out.println("No tree");
			return;
		}
		Node iterator = this.root;
		System.out.print("Tree-> ");
		helperMethod(iterator);
		System.out.println();
	}

	public void helperMethod(Node iterator) {
		System.out.print(iterator.getValue()+", ");
		if(iterator.getLeft() != null) {
			helperMethod(iterator.getLeft());
		}
		if(iterator.getRight() != null) {
			helperMethod(iterator.getRight());
		}
	}

}

