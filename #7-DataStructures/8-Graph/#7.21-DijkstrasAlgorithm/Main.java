import java.util.*;
public class Main {
	public static void main(String[] args) {
		Graph g = new Graph();

		g.addVertex("A");
		g.addVertex("B");
		g.addVertex("C");

		g.addEdge("A", "B", 7);
		g.addEdge("A", "C", 9);
		g.addEdge("C", "B", 4);
		
		g.printGraph();



	}
}

// -------Undirected but Weighted Graph is being implemented here(IMP)--------
class Graph {

	//Hashmap has a structure of String as keys that stores vertex/node
	//... and value as an ArrayList of an object Vertex containing  
	//... (String node, int weight) that stores all edges the vertex 
	//... is connected to.
	private HashMap<String, ArrayList<Vertex>> adjacencyList;

	public Graph() {
		this.adjacencyList = new HashMap<String, ArrayList<Vertex>>();
	}

	// adding a vertex as a key in a hashmap.
	public void addVertex(String key) {
		if(adjacencyList.containsKey(key)) {
			System.out.println("Vertex already exists.");
		} else {
			adjacencyList.put(key, new ArrayList<Vertex>());
		}
	}

	// takes two vertex and weight between them as an argument and
	// adds vertex2 as value in the vertex1's list
	// similarly adds vertex1 as value in the vertex2's list
	// this way a connection is attached to both the vertex.
	// error handling/invalid vertices not done here.
	// we are adding both vertices to both of lists as it is an undirected grph.
	// But incase of directed graph we will just add vertex to one of the list
	// ... depending on the connection.
	public void addEdge(String vertex1, String vertex2, int weight) {
		Vertex newVertex1 = new Vertex(vertex2, weight);
		ArrayList<Vertex> list1 = adjacencyList.get(vertex1);
		list1.add(newVertex1); 

		Vertex newVertex2 = new Vertex(vertex1, weight);
		ArrayList<Vertex> list2 = adjacencyList.get(vertex2);
		list2.add(newVertex2);
		
		// updating both the vertex list with the new list(after adding new elem.)
		adjacencyList.replace(vertex1, list1);
		adjacencyList.replace(vertex2, list2);
	}


	// ====REMOVE EDGE AND REMOVE VERTEX METHOD ARE NOT NEEDED HERE====

	// prints the whole graph.
	public void printGraph() {
		System.out.println("============Graph=============");
		for(Map.Entry<String, ArrayList<Vertex>> entry: adjacencyList.entrySet()) {
			System.out.print(entry.getKey() + ": ");

			// this for loop to iterate over the elements of the arraylist<vertex>
			for(int i=0; i<entry.getValue().size(); i++) {
				System.out.print("{" + entry.getValue().get(i).getNode() + ", "+
					entry.getValue().get(i).getWeight() + "}");
				if(i!=entry.getValue().size()-1) {
					System.out.print(", ");
				}
			}
			System.out.println();
			
		}
	}


}



class Vertex {
	private String node;
	private int weight;

	public Vertex(String node, int weight) {
		this.node = node;
		this.weight = weight;
	} 

	public String getNode() {
		return node;
	}	 

	public int getWeight() {
		return weight;
	}	 
}