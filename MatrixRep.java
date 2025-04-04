import java.util.*;

public class MatrixRep {
    private final int[][] adjacencyMatrix;
    private final ArrayList<Integer>[] adjacencyList;
    private final int vertices;
    private final boolean isDirected;

    // Constructor
    public MatrixRep(int vertices, boolean isDirected) {
        this.vertices = vertices;
        this.isDirected = isDirected;
        adjacencyMatrix = new int[vertices][vertices];
        adjacencyList = new ArrayList[vertices];
        for (int i = 0; i < vertices; i++) {
            adjacencyList[i] = new ArrayList<>();
        }
    }

    // Method to add an edge
    public void addEdge(int from, int to) {
        adjacencyMatrix[from][to] = 1; // Edge from 'from' node to 'to' node
        adjacencyList[from].add(to); // Add to adjacency list
        if (!isDirected) { //make it symmetric for an undirected graph
            adjacencyMatrix[to][from] = 1; // Undirected edge
            adjacencyList[to].add(from);
        }
    }

    // Method to display the adjacency matrix
    public void displayMatrix() {
        System.out.println("Adjacency Matrix:");
        System.out.print("    ");
        for (int i = 1; i < vertices; i++) {
            System.out.print(i + "   ");
        }
        System.out.println();

        for (int i = 1; i < vertices; i++) {
            System.out.print(i + " | ");
            for (int j = 1; j < vertices; j++) {
                System.out.print(adjacencyMatrix[i][j] + "   ");
            }
            System.out.print("|");
            System.out.println();
        }
    }

    // Method to display the adjacency list
    public void displayList() {
        System.out.println("Adjacency List:");
        for (int i = 1; i < vertices; i++) {
            System.out.print(i + " -> " + adjacencyList[i] + "\n");
        }
    }

    public static void main(String[] args) {
        // Create a directed graph with 6 vertices
        System.out.println("Directed Graph:");
        MatrixRep directedGraph = new MatrixRep(7, true);
        directedGraph.addEdge(1, 2);
        directedGraph.addEdge(1, 4);
        directedGraph.addEdge(2, 5);
        directedGraph.addEdge(3, 5);
        directedGraph.addEdge(3, 6);
        directedGraph.addEdge(4, 2);
        directedGraph.addEdge(5, 4);
        directedGraph.addEdge(6, 6);
        directedGraph.displayMatrix();
        directedGraph.displayList();

        // Create an undirected graph with 5 vertices
        System.out.println("\nUndirected Graph:");
        MatrixRep undirectedGraph = new MatrixRep(6, false);
        undirectedGraph.addEdge(1, 2);
        undirectedGraph.addEdge(1, 5);
        undirectedGraph.addEdge(2, 3);
        undirectedGraph.addEdge(2, 4);
        undirectedGraph.addEdge(2, 5);
        undirectedGraph.addEdge(3, 4);
        undirectedGraph.addEdge(4, 5);
        undirectedGraph.displayMatrix();
        undirectedGraph.displayList();
    }
}
