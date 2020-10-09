import java.util.*;
public class Main {
	public static void main(String[] args) {
		BinarySearchTree tree = new BinarySearchTree();	
		//--------testcase-1------------
		// tree.insert(10, 0);
		// tree.insert(6, 0);
		// tree.insert(15, 0);
		// tree.insert(3, 0);
		// tree.insert(8, 0);
		// tree.insert(20, 0);

		//--------testcase-2------------
		tree.insert(10, 0);
		tree.insert(6, 0);
		tree.insert(15, 0);
		tree.insert(3, 0);
		tree.insert(8, 0);
		tree.insert(20, 0);
		tree.insert(2, 0);
		tree.insert(4, 0);
		tree.insert(18, 0);
		tree.insert(24, 0);



		//---------------------------
		tree.display();

		tree.topViewOfBinaryTree();
		tree.bottomViewOfBinaryTree();
	}
}

/*
Input:Tree
		  	      10
			6			15
		3		8			20	
	2		4			18		24

Output: Tree-> 10, 6, 3, 8, 15, 20,
		BFS: [10, 6, 15, 3, 8, 20]
		DFS_PreOrder: [10, 6, 3, 8, 15, 20]
		DFS_PostOrder: [3, 8, 6, 20, 15, 10]
		DFS_InOrder: [3, 6, 8, 10, 15, 20] */


		//===here the structure of the node is a bit different as we have another
		//=== variable named hd(horizontal distance).
class Node {
	private Node left, right;
	private int value, hd;

	public Node(int value, int hd) {
		this.value = value;
		this.hd = hd;
		this.left = null;
		this.right = null;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public void setHd(int hd) {
		this.hd = hd;
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

	public int getHd() {
		return this.hd;
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

	//=====below list only used in the horizontal distance method.
	ArrayList<Integer> indexListOfNodesInBfsOrder = new ArrayList<>();

	public BinarySearchTree() {
		this.root = null;
	}

	public void setRoot(int rootValue, int hd) {
		this.root = new Node(rootValue, hd);
	}

	public void setRoot(int rootValue) {
		this.root = new Node(rootValue, 0);
	}

	public Node getRoot() {
		return this.root;
	}


	public boolean insert(int value, int hd) {
		Node newNode = new Node(value, hd);
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

	public boolean find(int value, int hd) {
		Node nodeToFind = new Node(value, hd);
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

	/*_______________TREE TRAVERSAL KA PART_______________*/

	
	//breadthFirstSearch- row wise print karo
	//EDIT: this also is a bit different that is Horizontal ditance gets calculated here.
	public ArrayList<Node> breadthFirstSearch() {
		ArrayList<Node> queue = new ArrayList<>();		//just to help us out
		ArrayList<Node> visited = new ArrayList<>(); //main result wala array.

		Node currentNode = this.root;
		queue.add(currentNode);

		while(!queue.isEmpty()) {
			currentNode = queue.get(0);
			int parentHd = currentNode.getHd();

			indexListOfNodesInBfsOrder.add(currentNode.getValue());
			Node newNode = new Node(currentNode.getValue(), parentHd);
			visited.add(newNode);
			queue.remove(0);
			if(currentNode.getLeft() != null) {
				int leftChildHd = parentHd - 1;
				currentNode.getLeft().setHd(leftChildHd);
				queue.add(currentNode.getLeft());
			}
			if(currentNode.getRight() != null) {
				int rightChildHd = parentHd + 1;
				currentNode.getRight().setHd(rightChildHd);
				queue.add(currentNode.getRight());
			}
		}
		return visited;
	}



	//-------=-=-=-=--=-=-=-=-=-=-===-----------
	// view == 1 means TOP VIEW
	// view == 2 means BOTTOM VIEW
	//-------=-=-=-=--=-=-=-=-=-=-===-----------
	public void findHorizontalDistanceOfNodes(int view) {
		ArrayList<Node> visitedNodes = breadthFirstSearch();
		HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
		
		ArrayList<Integer> sortedKeys = new ArrayList<>();

		for(Node currentNode: visitedNodes) {
			int horizontalDistance = currentNode.getHd();
			int nodeVal = currentNode.getValue();
			if(!map.containsKey(horizontalDistance)) {
				ArrayList<Integer> list = new ArrayList<>();
				list.add(nodeVal);
				map.put(horizontalDistance ,list);
				sortedKeys.add(horizontalDistance);
			} else {
				ArrayList<Integer> list = map.get(horizontalDistance);
				list.add(nodeVal);
				map.replace(horizontalDistance, list);
			}
		}

		// displaying keys and values of horizontal distance and respective nodes.
		for(Map.Entry<Integer, ArrayList<Integer>> entry: map.entrySet()) {
			System.out.println(entry.getKey() +": "+ entry.getValue());
		}

		Collections.sort(sortedKeys);
		ArrayList<Integer> result = new ArrayList<>();
		for(int key: sortedKeys) {
			int index = -1;
			for(int i=0; i<map.get(key).size(); i++) {
				int node = map.get(key).get(i);
				int newIndex = indexListOfNodesInBfsOrder.indexOf(node);	
				
				if(view == 1) {
					if(index == -1 || index > newIndex) {
						index = newIndex;
					}
				} else if(view == 2) {
					if(index == -1 || index < newIndex) {
						index = newIndex;
					}
				}
			}
			result.add(indexListOfNodesInBfsOrder.get(index));
		}

		System.out.println("Result: " + result);
	}


	public void topViewOfBinaryTree() {
		findHorizontalDistanceOfNodes(1);
	}


	public void bottomViewOfBinaryTree() {
		findHorizontalDistanceOfNodes(2);
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

