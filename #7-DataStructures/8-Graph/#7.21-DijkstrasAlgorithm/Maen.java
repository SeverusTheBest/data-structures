import java.util.*;
public class Maen {
	public static void main(String[] args) {
		WeightedGraph graph = new WeightedGraph();
		graph.addVertex("A");		
		graph.addVertex("B");		
		graph.addVertex("C");		
		graph.addVertex("D");		
		graph.addVertex("E");		
		graph.addVertex("F");		

		graph.addEdge("A", "B", 4);
		graph.addEdge("A", "C", 2);
		graph.addEdge("B", "E", 3);
		graph.addEdge("C", "D", 2);
		graph.addEdge("C", "F", 4);
		graph.addEdge("D", "E", 3);
		graph.addEdge("D", "F", 1);
		graph.addEdge("E", "F", 1);

		graph.printGraph();
		graph.applyDijkstrasAlgorithm("A", "E");
		// graph.applyDijkstrasAlgorithm("A", "F");
		graph.printGraph();
	}
}


// -------Undirected but Weighted Graph is being implemented here(IMP)--------
class WeightedGraph {

	//Hashmap has a structure of String as keys that stores vertex/node
	//... and value as an ArrayList of an object Vertex containing  
	//... (String node, int weight) that stores all edges the vertex 
	//... is connected to.
	private HashMap<String, ArrayList<Vertex>> adjacencyList;

	public WeightedGraph() {
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

	// =-=-=-=-=-=-=Dijkstra's Algo Part=-=-=-=-=-=-=-=-=
	public void applyDijkstrasAlgorithm(String startingVertex, String endingVertex) {
		// woh 0, infinity wagera store karte hai yeh woh hai 
		Map<String, Integer> distances = new TreeMap<>();

		// yeh woh variable hai jisme sare previous vertex store honge ki kaha se aaya 
		Map<String, String> previous = new TreeMap<>();
		int infinity = Integer.MAX_VALUE;

		// nodes are sorted by their priority value. 
		PriorityQueue nodes = new PriorityQueue();

		// storing the result/ shortest path
		ArrayList<String> path = new ArrayList<>();

		// build up initial state
		for(String vertex: adjacencyList.keySet()) {
			if(vertex.equals(startingVertex)) {
				distances.put(vertex, 0);
				nodes.enqueue(vertex, 0);
			} else {
				distances.put(vertex, infinity);
				nodes.enqueue(vertex, infinity);
			}
			previous.put(vertex, null);
		}

		// as long as there is something to visit.
		while(nodes.size() > 0) {
			// removing the smallest vertex from the priority queue.
			String removedVertex = nodes.dequeue();
			if(removedVertex.equals(endingVertex)) {
				break;
			} 
			if(distances.get(removedVertex) != infinity) {
				for(int i=0; i<adjacencyList.get(removedVertex).size(); i++) {
					// System.out.println(adjacencyList.get(removedVertex).get(i).getNode());
					int currentDistance = distances.get(removedVertex) + adjacencyList.get(removedVertex).get(i).getWeight();
					String currentNode = adjacencyList.get(removedVertex).get(i).getNode();
					
					if(currentDistance < distances.get(currentNode)) {
						distances.replace(currentNode, currentDistance);
						previous.replace(currentNode, removedVertex);
						nodes.enqueue(currentNode, currentDistance);
					}
				}
			}
		}

		for (Map.Entry<String, String> entry : previous.entrySet()) {
		    System.out.println(entry.getKey() + " => " + entry.getValue());
		}

		while(previous.size() > 0) {
			path.add(endingVertex);
			if(previous.get(endingVertex) != null) {
				String temp = previous.get(endingVertex);
				previous.remove(endingVertex); 
				endingVertex = temp;
			} else {
				Collections.reverse(path);
				break;
			}
		}
		System.out.println("Shortest Path:- "+path);
	

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

class PriorityQueue {
	private ArrayList<Pair> values;

	public PriorityQueue() {
		values = new ArrayList<>();
	}

	public void enqueue(String val, int priority) {
		Pair newPair = new Pair(val, priority);
		values.add(newPair);
		sortValuesByPriority(values);
	}

	public String dequeue() {
		return values.remove(0).getVal();
		// System.out.println("Removed:- {"+removedPair.getVal()+", "+removedPair.getPriority()+"}");
	}

	public void sortValuesByPriority(ArrayList<Pair> values) {
		int lastIndex = values.size() - 1; 
		for(int i=0; i<values.size(); i++) {
			if(values.get(i).getPriority() > values.get(lastIndex).getPriority()) {
				Pair currentPair = values.get(i);
				values.set(i, values.get(lastIndex));
				values.set(lastIndex, currentPair);
			}
		}
	}

	public void printQueue() {
		for(Pair singlePair: values) {
			System.out.print("{"+singlePair.getVal()+", "+singlePair.getPriority()+
				"}\t");
		}
		System.out.println();
	}

	public int size() {
		return this.values.size();
	}

}

// vertex is a part of Weighted graph
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

// whereas Pair is a part of priority queue
class Pair {
	private String val;
	private int priority;

	public Pair(String val, int priority) {
		this.val = val;
		this.priority = priority;
	}

	public String getVal() {
		return val;
	}

	public int getPriority() {
		return priority;
	}
}