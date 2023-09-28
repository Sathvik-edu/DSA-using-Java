package DataStructures.Graphs;

import java.util.ArrayList;
import java.util.HashMap;


public class Graph {

    // Creating New HashMap with the name adjList //
    private HashMap<String, ArrayList<String>> adjList = new HashMap<>();

    // Create Empty HashMap //
    public HashMap<String, ArrayList<String>> getAdjList() {
        return adjList;
    }

    public void printGraph() {
        System.out.println(adjList);
    }






    // WRITTEN ADD VERTEX METHOD HERE //
    public boolean addVertex(String vertex) {
        // Check if the vertex already exists in the graph
        if (adjList.get(vertex) == null) {
            // If it does not exist, add it to the graph with an empty adjacency list
            adjList.put(vertex, new ArrayList<String>());
            // Return true to indicate that the vertex was added successfully
            return true;
        }
        // If the vertex already exists, return false to indicate that it was not added
        return false;
    }







    // WRITTEN ADD EDGE METHOD HERE //
    public boolean addEdge(String vertex1, String vertex2) {
        // Check if both vertices exist in the graph
        if (adjList.get(vertex1) != null && adjList.get(vertex2) != null) {
            // If both vertices exist, add an edge between them in both directions
            adjList.get(vertex1).add(vertex2);
            adjList.get(vertex2).add(vertex1);
            // Return true to indicate that the edge was added successfully
            return true;
        }
        // If at least one vertex does not exist, return false to indicate that the edge was not added
        return false;
    }






    // WRITTEN REMOVE EDGE METHOD HERE //
    public boolean removeEdge(String vertex1, String vertex2) {
        // Check if both vertices exist in the graph
        if (adjList.get(vertex1) != null && adjList.get(vertex2) != null) {
            // If both vertices exist, remove the edge between them in both directions
            adjList.get(vertex1).remove(vertex2);
            adjList.get(vertex2).remove(vertex1);
            // Return true to indicate that the edge was removed successfully
            return true;
        }
        // If at least one vertex does not exist, return false
        // to indicate that the edge was not removed
        return false;
    }






    // WRITTEN REMOVE VERTEX METHOD HERE //
    public boolean removeVertex(String vertex) {
        // Check if the vertex exists in the adjacency list
        if (adjList.get(vertex) == null) {
            // Vertex not found, return false
            return false;
        }
        // Iterate over all vertices adjacent to the given vertex
        for (String otherVertex : adjList.get(vertex)) {
            // Remove the given vertex from the adjacency list of each adjacent vertex
            adjList.get(otherVertex).remove(vertex);
        }
        // Remove the vertex from the adjacency list
        adjList.remove(vertex);
        // Return true to indicate successful removal
        return true;
    }


}




