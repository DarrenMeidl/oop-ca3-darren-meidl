import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.PriorityQueue;
import java.util.HashMap;

/**
 *  Name: Darren Meidl
 *  Class Group: GD2b
 */
public class CA3_Question10
{
    public static void main(String[] args) throws FileNotFoundException {
        readFile("cities.txt");
    }

    public static void readFile(String fileName) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(fileName)); // Scan new file into scanner
        Map<String, TreeSet<DistanceTo>> citiesMap = new TreeMap<>(); // New tree map

        while(scanner.hasNextLine()){ // Check if there's a next line
            Scanner in = new Scanner(scanner.nextLine());
            PriorityQueue<DistanceTo> queue = new PriorityQueue<>(); // new priority queue

            // Algorithm
            String from = in.next(); // Let from be the starting point.
            queue.add(new DistanceTo(from, 0)); // Add DistanceTo(from, 0) to a priority queue.
            Map<String, Integer> shortestKnownDistance = new HashMap<>(); // Construct a map 'shortestKnownDistance' from city names to distances.
            while(!queue.isEmpty()){ // While the queue isn't empty
                DistanceTo smallest = queue.peek(); // Get smallest element
                if (!shortestKnownDistance.containsKey(from)){ // If the target city is not a key in 'shortestKnownDistance'
                    int d = smallest.getDistance(); // Let d be the distance to that target.
                    shortestKnownDistance.put(from, d); // Put (target, d) into shortestKnownDistance.
                    for (DistanceTo dt : citiesMap.get(from)) {
                        String c = dt.getTarget(); // Get the city name from the DistanceTo object
                        // Add DistanceTo(c, d + distance from target to c) to the priority queue.
                    }

                }
            }

        }
    }
}
