import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *  Name: Darren Meidl
 *  Class Group: GD2b
 */

public class CA3_Question3
{
    public static void readFile(String fileName) throws FileNotFoundException {
        Scanner in = new Scanner(new File(fileName)); // Creates a scanner that scans the file we pass in as a string parameter
        in.useDelimiter("[^A-Za-z0-9_]+"); // Defining delimiter pattern

        Map<String, List<String>> identifiers = new HashMap<>(); // new hasmap called identifiers
        int lineNumber = 1; // integer for tracking line number
    }

    public static void main(String[] args) throws FileNotFoundException {
        readFile("src/CA3_Question1.java");
    }
}
