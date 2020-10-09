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

		tree.display();

		tree.deleteNode(2);
	
		tree.display();
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


	// return the node we need to find. 
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


	// return the previous node of the node we need to find. 
	public Node findPreviousNode(int value) {
		Node nodeToFind = new Node(value);
		if(this.root == null) {
			return null; 
		}
		Node iterator = this.root;
		Node previous = iterator;
		while(true) {
			if(nodeToFind.getValue() == iterator.getValue()) {
				return previous;
			}
			if(nodeToFind.getValue() > iterator.getValue()) {
				if(iterator.getRight() == null) {
					return null;
				} else {
					previous = iterator;
					iterator = iterator.getRight();
				}
			} else {
				if(iterator.getLeft() == null) {
					return null;
				} else {
					previous = iterator;
					iterator = iterator.getLeft();
				}
			}
		}
	}


	//_________Nodes can be deleted and replaced by:-->
	// 1. Predecessor of that node
	// 2. Successor of that node
	// so i want to know in both the cases will the method to delete a node
	// ...with only one child is the same
	// tho to delete a node having two childs the method in both the cases is
	// ...definetely not the same

	public boolean deleteNode(int nodeValue) {
		Node currentNode = find(nodeValue);
		if(currentNode == null) {
			System.out.println("Node to be deleted is not found.");
			return false;
		}
		Node previousNode = findPreviousNode(nodeValue);

		boolean isLeftChild = false;

		// yeh dekhne ke liye ki delete karne wala node,
		// ..previous node ke right mei hai ya left mei.
		if(previousNode.getValue() > currentNode.getValue()) {
			isLeftChild = true;
		} 
		System.out.println("1");
		// agar leaf node delete karna hai (i.e. no child present of 
		// ..node to be deleted)
		if(currentNode.getLeft() == null && currentNode.getRight() == null) {
		System.out.println("2");
			if(isLeftChild) {
				previousNode.setLeft(null);
			} else {
				previousNode.setRight(null);
			}
			return true;
			
		// niche wale do if loop gets executed if ek hi side child hai ===>
		} else if(currentNode.getLeft() == null || currentNode.getRight() == null) {
		System.out.println("3");
			if(currentNode.getLeft() == null) {
				currentNode = currentNode.getRight();
			} else if(currentNode.getRight() == null) {
				currentNode = currentNode.getLeft();
			}


			if(isLeftChild) {
				previousNode.setLeft(currentNode);
			} else {
				previousNode.setRight(currentNode);
			}
			return true;
		// niche wala else loop gets executed if dono side child hai
		} else {
			// we need to delete the node with the minimum node in the 
			// ..right subtree

			Node iterator = currentNode;	// jisse replace karna hai woh node.
			Node prevIterator = iterator;	// jisse replace karna hai uska prev.

			
			return true;
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
		if(iterator.getLeft() != null) {
			helperMethod(iterator.getLeft());
		}
		System.out.print(iterator.getValue()+", ");
		if(iterator.getRight() != null) {
			helperMethod(iterator.getRight());
		}
	}

}




	// public boolean deleteNode(int nodeValue) {
	// 	Node currentNode = find(nodeValue);
	// 	if(currentNode == null) {
	// 		System.out.println("Node to be deleted is not found.");
	// 		return false;
	// 	}
	// 	Node previousNode = findPreviousNode(nodeValue);

	// 	boolean isLeftChild = false;

	// 	// yeh dekhne ke liye ki delete karne wala node,
	// 	// ..previous node ke right mei hai ya left mei.
	// 	if(previousNode.getValue() > currentNode.getValue()) {
	// 		isLeftChild = true;
	// 	} 
	// 	System.out.println("1");
	// 	// agar leaf node delete karna hai (i.e. no child present of 
	// 	// ..node to be deleted)
	// 	if(currentNode.getLeft() == null && currentNode.getRight() == null) {
	// 	System.out.println("2");
	// 		if(isLeftChild) {
	// 			previousNode.setLeft(null);
	// 		} else {
	// 			previousNode.setRight(null);
	// 		}
	// 		return true;
			
	// 	// niche wale do if loop gets executed if ek hi side child hai ===>
	// 	} else if(currentNode.getLeft() == null || currentNode.getRight() == null) {
	// 	System.out.println("3");
	// 		if(currentNode.getLeft() == null) {
	// 			currentNode = currentNode.getRight();
	// 		} else if(currentNode.getRight() == null) {
	// 			currentNode = currentNode.getLeft();
	// 		}


	// 		if(isLeftChild) {
	// 			previousNode.setLeft(currentNode);
	// 		} else {
	// 			previousNode.setRight(currentNode);
	// 		}
	// 		return true;
	// 	// niche wala else loop gets executed if dono side child hai
	// 	} else {
	// 		// we need to delete the node with the minimum node in the 
	// 		// ..right subtree

	// 		Node iterator = currentNode;	// jisse replace karna hai woh node.
	// 		Node prevIterator = iterator;	// jisse replace karna hai uska prev.

			
	// 		return true;
	// 	}
	// }
