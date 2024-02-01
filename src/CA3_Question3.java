import java.io.FileNotFoundException;
import java.util.*;
import java.io.File;

/**
 *  Name: Darren Meidl
 *  Class Group: GD2b
 */

public class CA3_Question3
{
    public static void readFile(String fileName) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(fileName)); // Scan new file into scanner
        Map<String, HashSet<Integer>> map = new TreeMap<>(); // New tree map
        int lineNumber = 1;

        while(scanner.hasNextLine()){ // Check if there's a next line
            Scanner in = new Scanner(scanner.nextLine());
            in.useDelimiter("[^A-Za-z0-9_]+");
            while(in.hasNext()){ // Goes through each word & adds each to map
                String token = in.next();

                if (map.containsKey(token)){ // assign a line number to the token
                    map.get(token).add(lineNumber);
                }
                else{
                    HashSet<Integer> set = new HashSet<>(); // New hash set
                    map.put(token, set); // add the token & its set to the map
                }
            }
            lineNumber++;
        }

        for (Map.Entry<String, HashSet<Integer>> entry : map.entrySet()) {
            String str = entry.getKey();
            HashSet<Integer> hashSet = entry.getValue();
            System.out.println("Key: " + str + ", Value: " + hashSet);
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        readFile("src/CA3_Question1.java");
    }
}
