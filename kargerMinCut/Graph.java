package kargerMinCut;
import java.io.File;
import java.io.IOException;
import java.util.*;

public class Graph {

    HashMap<Integer, ArrayList<Integer>> hashMap;

    public Graph(String graphName) {
        hashMap = generateGraph(graphName);
    }

    private HashMap<Integer, ArrayList<Integer>> generateGraph(String input) {
        HashMap<Integer, ArrayList<Integer>> result = new HashMap<>();

        try(Scanner in = new Scanner(new File("/Users/CalvinNguyen/Desktop/Computer Science/algorithm-Standford/assignment4.txt"))) {


        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }




}
