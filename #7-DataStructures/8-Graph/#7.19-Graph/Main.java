import java.util.*;
public class Main {
	public static void main(String[] args) {
		Graph g = new Graph();
		g.addVertex("Mumbai");
		g.addVertex("Delhi");
		g.addVertex("Chennai");
		g.addVertex("Kerela");

		g.addEdge("Mumbai", "Chennai");
		g.addEdge("Chennai", "Delhi");
		g.addEdge("Chennai", "Kerela");
		g.addEdge("Mumbai", "Delhi");
		g.addEdge("Mumbai", "Kerela");
		g.addEdge("Delhi", "Kerela");

		g.printGraph();

		g.removeEdge("Chennai", "Chennai");

		g.printGraph();

		g.removeVertex("Mumbai");

		g.printGraph();

	}
}

// ---------Undirected Graph is being implemented here(IMP)-----------
class Graph {

	//Hashmap has a structure of String as keys that stores vertex/node
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
	// we are adding both vertices to both of lists as it is an undirected grph.
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



	// prints the whole graph.
	public void printGraph() {
		System.out.println("============Graph=============");
		for(Map.Entry<String, ArrayList<String>> entry: adjacencyList.entrySet()) {
			System.out.println(entry.getKey()+": "+entry.getValue());
		}
	}
}