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
            in.useDelimiter("[^A-Za-z0-9_]+"); // Get rid of anything that does not match these parameters: A-Z, a-z, 0-9 and _
            while(in.hasNext()){ // Goes through each word & adds each to map
                String token = in.next(); // Gets next word

                if (map.containsKey(token)){ // If the map has this key already, assign a line number to the token
                    map.get(token).add(lineNumber);
                }
                else{ // Otherwise, create a new HashSet & add the word (as a key) and the new HashSet (as a value)
                    HashSet<Integer> set = new HashSet<>(); // New HashSet
                    set.add(lineNumber); // add the line number to the HashSet
                    map.put(token, set); // add the token & its set to the map

                }
            }
            lineNumber++; // Increment the line number
        }
        // Loop that runs through each entry in the map's entry set & prints them
        for (Map.Entry<String, HashSet<Integer>> entry : map.entrySet()) {
            String str = entry.getKey(); // the current entry's key
            HashSet<Integer> hashSet = entry.getValue(); // the current entry's value
            System.out.println("Key: " + str + ", Value: " + hashSet);
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        readFile("src/CA3_Question1.java");
    }
}
