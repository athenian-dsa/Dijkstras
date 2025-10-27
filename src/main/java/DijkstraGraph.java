import java.util.*;

public class DijkstraGraph {
    HashMap<String, WeightedVertex> vertices;

    public DijkstraGraph() {
        vertices = new HashMap<>();
    }

    // This method carries out Dijkstra's algorithm
    // The algorithm returns a HashMap containing the distances calculated
    // along the way. The distance to destination is guaranteed to be minimal,
    // although other distances may not be (but are included so that the tests can
    // ensure you implemented the algorithm efficiently).
    // If the destination is not found, the map of distances to all nodes reachable
    // from source should be returned.
    public HashMap<String, Integer> dijkstra(String source, String destination) {
        // YOUR CODE HERE
        return null;
    }

    // Prints out the graph. May be useful for debugging.
    public void printGraph() {
        int longest = 7;
        for (String str: vertices.keySet()) {
            longest = Math.max(longest, str.length() + 1);
        }

        String line = "Vertex ";
        for (int i = 7; i < longest; i++)
            line += " ";
        int leftLength = line.length();
        line += "| Adjacent Vertices";
        System.out.println(line);

        for (int i = 0; i < line.length(); i++)
        {
            System.out.print("-");
        }
        System.out.println();

        for (String str: vertices.keySet()) {
            WeightedVertex v1 = vertices.get(str);

            for (int i = str.length(); i < leftLength; i++) {
                str += " ";
            }
            System.out.print(str + "| ");

            for (int i = 0; i < v1.edges.size()-1; i++) {
                DijkstraEdge edge1 = v1.edges.get(i);
                System.out.print(edge1.destination.label + ": " + edge1.weight+ ", ");
            }

            if (!v1.edges.isEmpty()) {
                DijkstraEdge edge1 = v1.edges.get(v1.edges.size()-1);
                System.out.print(edge1.destination.label + ": " + edge1.weight);
            }

            System.out.println();
        }
    }

    // Adds a vertex to the graph
    public void addVertex(String label) {
        // Check vertex doesn't already exist before adding it
        if (!vertices.containsKey(label)) {
            WeightedVertex v1 = new WeightedVertex(label);
            vertices.put(label, v1);
        }
    }

    // Adds an edge to the graph
    public void addEdge(String label1, String label2, int weight) {
        // Check vertices exist before adding an edge between them
        if (vertices.containsKey(label1) && vertices.containsKey(label2)) {
            WeightedVertex v1 = vertices.get(label1);
            WeightedVertex v2 = vertices.get(label2);

            v1.edges.add(new DijkstraEdge(v1, v2, weight));
            v2.edges.add(new DijkstraEdge(v2, v1, weight));
        }
    }
}