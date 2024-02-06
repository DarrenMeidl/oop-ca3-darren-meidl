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
        Map<String, TreeSet<DistanceTo>> citiesMap = new TreeMap<>(); // Tree map where all direct connections between cities are stored

        while(scanner.hasNextLine()){ // Check if there's a next line
            Scanner in = new Scanner(scanner.nextLine()); // new scanner
            PriorityQueue<DistanceTo> queue = new PriorityQueue<>(); // new priority queue
            // Algorithm
            String from = in.next(); // Let 'from' be the starting point.
            queue.add(new DistanceTo(from, 0)); // Add DistanceTo(from, 0) to a priority queue.
            Map<String, Integer> shortestKnownDistance = new HashMap<>(); // Construct a map 'shortestKnownDistance' (from city names to distances)
            while(!queue.isEmpty()){ // While the queue isn't empty
                DistanceTo smallest = queue.poll(); // Get smallest element
                from = smallest.getTarget(); // Update 'from' to be target of smallest distance
                if (!shortestKnownDistance.containsKey(from)){ // If the target city is not a key in 'shortestKnownDistance'
                    int d = smallest.getDistance(); // Let d be the distance to that target.
                    shortestKnownDistance.put(from, d); // Put (target, d) into shortestKnownDistance.
                    if(citiesMap.containsKey(from)) {
                        for (DistanceTo dt : citiesMap.get(from)) { // For all cities 'c' that have a direct connection from target
                            String c = dt.getTarget(); // Get the city name from the DistanceTo object
                            int distanceToC = dt.getDistance(); // Get distance to city c
                            int total = d + distanceToC;// Calculate the total distance from the target to city c
                            queue.add(new DistanceTo(c, total));// Add DistanceTo(c, d + distance from target to c) to the priority queue.
                        }
                    }
                }
            }

            // Print shortest distance to all other cities
            // Loop that runs through each entry in the map's entry set & prints them
            for (Map.Entry<String, Integer> entry : shortestKnownDistance.entrySet()) {
                String str = entry.getKey(); // the current entry's key
                int integer = entry.getValue(); // the current entry's value
                System.out.println("Key: " + str + ", Value: " + integer);
            }

        }


    }
}
