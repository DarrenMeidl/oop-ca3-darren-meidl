import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;
/**
 *  Name: Darren Meidl
 *  Class Group: GD2b
 */
public class CA3_Question4 {

    /*
        filename: name of the file to test.
     */
    public static boolean validate(String filename) throws FileNotFoundException
    {
        Stack<String> tagStack = new Stack<>(); // stack storing strings for tags
        Scanner scanner = new Scanner(new File(filename)); // Scanner for scanning a new file

        while(scanner.hasNextLine()){ // run through each line
            String line = scanner.nextLine(); // gets next line & stores into a string
            String[] tags = line.split(" "); // Stores an entire line until it reaches a space into a String array called 'tags'

            for (String tag : tags){ // Runs through every individual tag
                if(tag.startsWith("</")){ // If it's a closing tag
                    String openingTag = "<" + tag.substring(2); // Creates a new opening tag

                    if (tagStack.isEmpty() || !tagStack.peek().equals(openingTag)){ // if the stack is empty or the last tag isn't the same as the opening tag, then the tags are wrongly nested
                        return false;
                    }
                    tagStack.pop(); // remove the opening tag from the stack
                }
                else{ // If it's an opening tag
                    tagStack.push(tag); // Adds tag to stack
                }
            }
        }
        // Returns true if all tags are properly nested and closed, otherwise this will return false
        return tagStack.isEmpty();
    }

    public static void main(String[] args) throws FileNotFoundException {
        String[] files = {"tags_valid.txt", "tags_invalid.txt"}; // Array of string containing the names of text files
        for(String fName: files) { // Runs through all strings in the array
            System.out.print(fName +": "); // Print the name
            if (validate(fName)) {
                System.out.println("This file is valid");
            } else {
                System.out.println("This file is invalid");
            }
        }
    }
}
