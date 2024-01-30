import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 *  Name: Darren Meidl
 *  Class Group: GD2b
 */

public class CA3_Question3
{
    public static void readFile(String fileName) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(fileName)); // Creates a scanner that scans the file we pass in as a string parameter
        scanner.useDelimiter("[^A-Za-z0-9_]+"); // Defining delimiter pattern

        Map<String, List<String>> identifiers = new HashMap<>(); // new hashmap called identifiers
        int lineNumber = 1; // integer for tracking line number

        while (scanner.hasNextLine()) { // While the scanner has the current line, change the delimiter of lineScanner
            String line = scanner.nextLine(); // put current line into a string
            Scanner lineScanner = new Scanner(line); // Use a different scanner called 'lineScanner' to scan the string
            lineScanner.useDelimiter("[^A-Za-z0-9_]+"); // change the delimiter of lineScanner

            while (lineScanner.hasNext()) { // While lineScanner has the current line
                String identifier = lineScanner.next(); // reads next token and assigns to string
                identifiers.putIfAbsent(identifier, new ArrayList<>()); // if the identifier isn't in the map, add an empty arraylist as its new value
                identifiers.get(identifier).add("Line " + lineNumber + ": " + line); // adds a new string containing the line number and line itself to the arraylist of the identifier
            }

            lineNumber++;
            lineScanner.close();
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        readFile("src/CA3_Question1.java"); // java file we're reading
    }
}
