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
        Stack<String> tagStack = new Stack<>(); // stack
        Scanner scanner = new Scanner(new File(filename)); // scanning file

        while(scanner.hasNextLine()){ // run through each line
            String line = scanner.nextLine(); // gets next line
            String[] tags = line.split(" "); // splits line into tags

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
        // if any of the tags aren't closed then the html code is incomplete and needs to be fixed, so function ends
        return tagStack.isEmpty();
    }

    /*
        This function tests the files in the files array to see if
         they are valid.
         tags_valid.txt should return true;
         tags_invalid.txt should output as invalid;


     */
    public static void main(String[] args) throws FileNotFoundException {
        String[] files = {"tags_valid.txt", "tags_invalid.txt"};
        for(String fName: files) {
            System.out.print(fName +": ");
            validate(fName);
            if (validate(fName)) {
                System.out.println("This file is valid");
            } else {
                System.out.println("This file is invalid");
            }
        }
    }
}
