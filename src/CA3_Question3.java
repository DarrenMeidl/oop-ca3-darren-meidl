import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;
import java.util.HashSet;
import java.util.Map;
import java.util.TreeMap;

/**
 *  Name: Darren Meidl
 *  Class Group: GD2b
 */

public class CA3_Question3
{
    public static void readFile(String fileName) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(fileName)); // Scan new file into scanner
        Map<String, HashSet<Integer>> map = new TreeMap<>(); // New tree map
        HashSet<Integer> set = new HashSet<>(); // New hash set
        int lineNumber = 1;

        while(scanner.hasNextLine()){ // Check if there's a next line
            Scanner in = new Scanner(scanner.nextLine());
            in.useDelimiter("[A-Za-z0-9_]+");
            while(in.hasNext()){ // Goes through each word & adds each to map
                String token = in.next();

                if (map.containsKey(token)){ // assign a line number to the token
                    map.get(token).add(lineNumber);
                }
                else{
                    map.put(token, set); // add the token & its set to the map
                }
            }

            lineNumber++;
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        readFile("src/CA3_Question1.java");
    }
}
