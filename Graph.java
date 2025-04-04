import java.util.*;

class Vertex {
    int id;
    String color;
    int distance;
    Vertex parent;

    Vertex(int id) {
        this.id = id;
        this.color = "WHITE";
        this.distance = Integer.MAX_VALUE;
        this.parent = null;
    }
}

public class Graph{
    private final ArrayList<Integer>[] adjacencyList;
    private final Vertex[] vertices;


    // Constructor
    public Graph(int numVertices) {
        adjacencyList = new ArrayList[numVertices];
        vertices = new Vertex[numVertices];

        for (int i = 0; i < numVertices; i++) {
            adjacencyList[i] = new ArrayList<>();
            vertices[i] = new Vertex(i);
        }
    }

    // Method to add an edge
    public void addEdge(int from, int to) {
        adjacencyList[from].add(to); // Add to adjacency list
        adjacencyList[to].add(from);
        }


    public void bfs(int start){
        //color everything white, have distance be infinity, and parent null
        for (Vertex u : vertices) {
            u.color = "white";
            u.distance = Integer.MAX_VALUE;
            u.parent = null;
        }

        //color first vertex grey, and start distance as 0 and parent null
        Vertex s = vertices[start];
        s.color = "grey";
        s.distance = 0;
        s.parent = null;

        //create empty queue Q
        Queue<Vertex> queue = new LinkedList<>();
        queue.add(s);
        System.out.println("BFS Order:");
        //enqueue empty Q by dequeuing G
        while (!queue.isEmpty()) {
            Vertex u = queue.remove();
            System.out.print(u.id + " ");
            for (int i : adjacencyList[u.id]){
                Vertex v = vertices[i];
                if (v.color.equals("white")){
                    v.color = "grey";
                    v.distance = u.distance + 1;
                    v.parent = u;
                    queue.add(v);
                }
            }
            u.color = "black";
        }
        System.out.println();
    }




    public static void main(String[] args) {
        Graph graph = new Graph(10);
        graph.addEdge(1,2);
        graph.addEdge(1,4);
        graph.addEdge(2,3);
        graph.addEdge(2,5);
        graph.addEdge(2,6);
        graph.addEdge(3,5);
        graph.addEdge(4,6);
        graph.addEdge(5,7);
        graph.addEdge(5,9);
        graph.addEdge(6,7);
        graph.addEdge(6,9);
        graph.addEdge(8,9);

        System.out.println("BFS starting from vertex 1:");
        graph.bfs(1);
    }
}
