import java.util.*;
public class Main {
	public static void main(String[] args) {
		Graph g = new Graph();

		g.addVertex("A");
		g.addVertex("B");
		g.addVertex("C");
		g.addVertex("D");
		g.addVertex("E");
		g.addVertex("F");

		g.addEdge("A", "B");
		g.addEdge("A", "C");
		g.addEdge("B", "D");
		g.addEdge("C", "E");
		g.addEdge("D", "E");
		g.addEdge("D", "F");
		g.addEdge("E", "F");

		g.printGraph();

		// g.dfsRecursive("A");
		// g.dfsIterative("A");
		g.bfsIterative("A");
	}
}

// ---------Undirected Graph is being implemented here(IMP)-----------
class Graph {

	//Hashmap has a structure of String as keys that stores vertex/ndoe
	//... and value as an ArrayList of strings that stores all 
	//... edges the node is connected to.
	private HashMap<String, ArrayList<String>> adjacencyList;

	public Graph() {
		this.adjacencyList = new HashMap<String, ArrayList<String>>();
	}

	// adding a vertex/node as a key in a hashmap.
	public void addVertex(String key) {
		if(adjacencyList.containsKey(key)) {
			System.out.println("Vertex already exists.");
		} else {
			adjacencyList.put(key, new ArrayList<String>());
		}
	}

	// takes two vertex as an argument and
	// adds vertex2 as value in the vertex1's list
	// similarly adds vertex1 as value in the vertex2's list
	// this way a connection is attached to both the vertex.
	// error handling/invalid vertices not done here.
	// we are adding both vertexes to both of lists as it is an undirected grph.
	// But incase of directed graph we will just add vertex to one of the list
	// ... depending on the connection.
	public void addEdge(String vertex1, String vertex2) {
		ArrayList<String> list1 = adjacencyList.get(vertex1);
		list1.add(vertex2); 

		ArrayList<String> list2 = adjacencyList.get(vertex2);
		list2.add(vertex1);
		
		// System.out.println(list1);
		// System.out.println(list2);
		// updating both the vertex list with the new list(after adding new elem.)
		adjacencyList.replace(vertex1, list1);
		adjacencyList.replace(vertex2, list2);
	}

	// Similar to addEdge method. Only difference is vertex are being removed
	// ...from the arraylist.
	public void removeEdge(String vertex1, String vertex2) {
		ArrayList<String> list1 = adjacencyList.get(vertex1);
		list1.remove(vertex2); 

		ArrayList<String> list2 = adjacencyList.get(vertex2);
		list2.remove(vertex1);
		
		// System.out.println(list1);
		// System.out.println(list2);
		// updating both the vertex list with the new list(after adding new elem.)
		adjacencyList.replace(vertex1, list1);
		adjacencyList.replace(vertex2, list2);	
	}

	// pehle entered vertex ke saare connections severe karenge
	// by looping all the elements it contains in its arraylist
	// when all the connections have been removed we finally delete the
	// ... verted(key) itself.  
	public void removeVertex(String vertex) {
		ArrayList<String> list = adjacencyList.get(vertex);

		// we did this using while loop instead of using forOf or for loop
		// ... because the list elements would be getting deleted one by 
		// ... one(in removeEdge method) so forOf/ for loop won't work.  
		while(list.size() > 0) {
			this.removeEdge(vertex, list.get(0));
		}
		adjacencyList.remove(vertex);
	}


	//============================TRAVERSAL=============================

		// EXAMPLE GRAPH:
		//				A
		//			  /	 \
		//           B    C
		//          |     |
		//			D --- E
		//			\    /
		//            F


	// =========1.Recursive Approach========
	public void dfsRecursive(String start) {
		ArrayList<String> visitedVertices = new ArrayList<>();
		helperMethod(start, visitedVertices);
		System.out.println("DFS(R): " + visitedVertices);
	}

	public void helperMethod(String vertex, ArrayList<String> visitedVertices) {
		if(visitedVertices.contains(vertex)) {
			return;
		}
		visitedVertices.add(vertex);
		for(String val: adjacencyList.get(vertex)) {
			if(!visitedVertices.contains(val)) {
				helperMethod(val, visitedVertices);
			}
		}
	}

	// =========2.Iterative Approach=========
	public void dfsIterative(String start) {
		ArrayList<String> stack = new ArrayList<>(),
		visitedVertices = new ArrayList<>();
		stack.add(start);
		String currentVertex;

		while(stack.size() > 0) {
			currentVertex = stack.remove(stack.size()-1);
			if(!visitedVertices.contains(currentVertex)) {
				visitedVertices.add(currentVertex);
				for(String val: adjacencyList.get(currentVertex)) {
					stack.add(val);
				}
			}			
		}

		System.out.println("DFS(I): " + visitedVertices);
	}

	// =========3.BreadthFirstSearch=========
	// Almost same as dfsIterative. Only difference is we remove first element
	// instead of the last element form the array(queue). Hence named as queue
	// instead of stack
	public void bfsIterative(String start) {
		ArrayList<String> queue = new ArrayList<>(),
		visitedVertices = new ArrayList<>();
		queue.add(start);
		String currentVertex;

		while(queue.size() > 0) {
			currentVertex = queue.remove(0);
			if(!visitedVertices.contains(currentVertex)) {
				visitedVertices.add(currentVertex);
				for(String val: adjacencyList.get(currentVertex)) {
					queue.add(val);
				}
			}			
		}

		System.out.println("BFS(I): " + visitedVertices);
	}


	// prints the whole graph.
	public void printGraph() {
		System.out.println("============Graph=============");
		for(Map.Entry<String, ArrayList<String>> entry: adjacencyList.entrySet()) {
			System.out.println(entry.getKey()+": "+entry.getValue());
		}
	}


}