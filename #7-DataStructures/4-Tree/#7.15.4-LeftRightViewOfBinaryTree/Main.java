public class Main {
	public static void main(String[] args) {
		BinarySearchTree tree = new BinarySearchTree();
		tree.insert(10);
		tree.insert(5);
		tree.insert(13);
		tree.insert(11);
		tree.insert(2);
		tree.insert(16);
		tree.insert(7);
		tree.insert(3);
		tree.display();
	}
}

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

	public boolean find(int value) {
		Node nodeToFind = new Node(value);
		if(this.root == null) {
			return false; 
		}
		Node iterator = this.root;
		while(true) {
			if(nodeToFind.getValue() == iterator.getValue()) {
				return true;
			}
			if(nodeToFind.getValue() > iterator.getValue()) {
				if(iterator.getRight() == null) {
					return false;
				} else {
					iterator = iterator.getRight();
				}
			} else {
				if(iterator.getLeft() == null) {
					return false;
				} else {
					iterator = iterator.getLeft();
				}
			}
		}
	}


	public ArrayList<Integer> leftViewOfBinaryTree() {
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		ArrayList<Node> queue1 = new ArrayList<>();
		ArrayList<Node> queue2 = new ArrayList<>();

		Node currentNode = this.root;
		int levels = 0;
		queue1.add(currentNode);
		while(!queue1.isEmpty() || !queue2.isEmpty()) {
			levels++;
			if()
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

