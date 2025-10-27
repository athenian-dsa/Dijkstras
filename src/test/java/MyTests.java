import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

public class MyTests {
    @Test
    public void dijkstraTest_1() {
        HashMap<String, Integer> expected = new HashMap<>();
        expected.put("A", 0);
        expected.put("B", 3);
        expected.put("C", 4);
        expected.put("D", 6);
        expected.put("E", 8);
        expected.put("F", 7);
        expected.put("G", 11);
        expected.put("H", 13);

        DijkstraGraph g1 = new DijkstraGraph();
        g1.addVertex("A");
        g1.addVertex("B");
        g1.addVertex("C");
        g1.addVertex("D");
        g1.addVertex("E");
        g1.addVertex("F");
        g1.addVertex("G");
        g1.addVertex("H");

        g1.addEdge("A", "B", 3);
        g1.addEdge("A", "C", 5);
        g1.addEdge("A", "D", 8);
        g1.addEdge("B", "C", 1);
        g1.addEdge("B", "F", 4);
        g1.addEdge("C", "D", 2);
        g1.addEdge("C", "F", 6);
        g1.addEdge("D", "E", 3);
        g1.addEdge("D", "G", 6);
        g1.addEdge("E", "F", 1);
        g1.addEdge("E", "G", 3);
        g1.addEdge("E", "H", 6);
        g1.addEdge("F", "H", 11);
        g1.addEdge("G", "H", 2);

        assertTrue(mapsAreEqual(expected, g1.dijkstra("A", null)));
    }

    @Test
    public void dijkstraTest_2() {
        HashMap<String, Integer> expected = new HashMap<>();
        expected.put("A", 0);
        expected.put("B", 1);
        expected.put("C", 2);
        expected.put("D", 3);
        expected.put("E", 4);
        expected.put("F", 5);
        expected.put("G", 6);
        expected.put("H", 7);

        DijkstraGraph g2 = new DijkstraGraph();
        g2.addVertex("A");
        g2.addVertex("B");
        g2.addVertex("C");
        g2.addVertex("D");
        g2.addVertex("E");
        g2.addVertex("F");
        g2.addVertex("G");
        g2.addVertex("H");

        g2.addEdge("A", "B", 1);
        g2.addEdge("B", "C", 1);
        g2.addEdge("C", "D", 1);
        g2.addEdge("D", "E", 1);
        g2.addEdge("E", "F", 1);
        g2.addEdge("F", "G", 1);
        g2.addEdge("G", "H", 1);

        assertTrue(mapsAreEqual(expected, g2.dijkstra("A", null)));
    }

    @Test
    public void dijkstraTest_3() {
        HashMap<String, Integer> expected = new HashMap<>();
        expected.put("A", 0);
        expected.put("B", 4);
        expected.put("C", 8);
        expected.put("D", 2);
        expected.put("E", 4);
        expected.put("F", 9);
        expected.put("G", 12);
        expected.put("H", 2);

        DijkstraGraph g3 = new DijkstraGraph();
        g3.addVertex("A");
        g3.addVertex("B");
        g3.addVertex("C");
        g3.addVertex("D");
        g3.addVertex("E");
        g3.addVertex("F");
        g3.addVertex("G");
        g3.addVertex("H");

        g3.addEdge("A", "B", 4);
        g3.addEdge("A", "D", 2);
        g3.addEdge("B", "C", 4);
        g3.addEdge("D", "E", 2);
        g3.addEdge("C", "F", 1);
        g3.addEdge("A", "H", 2);
        g3.addEdge("E", "F", 5);
        g3.addEdge("G", "H", 10);

        assertTrue(mapsAreEqual(expected, g3.dijkstra("A", null)));
    }


    @Test
    public void dijkstraTestEfficiency() {
        HashMap<String, Integer> expected = new HashMap<>();
        expected.put("A", 0);
        expected.put("B", 8);
        expected.put("C", 2);
        expected.put("D", 4);
        expected.put("E", 6);
        expected.put("F", 5);
        expected.put("G", 10);

        DijkstraGraph g3 = new DijkstraGraph();
        g3.addVertex("A");
        g3.addVertex("B");
        g3.addVertex("C");
        g3.addVertex("D");
        g3.addVertex("E");
        g3.addVertex("F");
        g3.addVertex("G");
        g3.addVertex("H");

        g3.addEdge("A", "B", 10);
        g3.addEdge("A", "C", 2);
        g3.addEdge("C", "D", 2);
        g3.addEdge("D", "E", 2);
        g3.addEdge("E", "B", 2);
        g3.addEdge("A", "F", 5);
        g3.addEdge("F", "G", 5);
        g3.addEdge("G", "H", 5);

        assertTrue(mapsAreEqual(expected, g3.dijkstra("A", "B")));
    }

    public boolean mapsAreEqual(HashMap<String, Integer> mapA, HashMap<String, Integer> mapB) {

        try{
            for (String k : mapB.keySet())
            {
                if (!mapA.get(k).equals(mapB.get(k))) {
                    return false;
                }
            }
            for (String y : mapA.keySet())
            {
                if (!mapB.containsKey(y)) {
                    return false;
                }
            }
        } catch (NullPointerException np) {
            return false;
        }
        return true;
    }
}