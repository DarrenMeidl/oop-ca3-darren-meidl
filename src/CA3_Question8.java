import java.util.Scanner;
import java.util.Stack;
/**
 *  Name: Darren Meidl
 *  Class Group: GD2b
 */
public class CA3_Question8 {

    /*
        Reads in an equation from the user
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Stack<Integer> results = new Stack<Integer>();
        System.out.println("Please enter an equation one number or operation per line, Q to stop.");
        boolean done = false;

        while (!done){
            String input = in.nextLine().trim();

            // if the input is an operator then take out the last two numbers and push the new result

            if (input.equals("+")){
                results.push(results.pop() + results.pop());
            }
            if (input.equals("-")){
                Integer arg2 = results.pop();
                results.push(results.pop() - arg2);
            }
            if (input.equals("*") || input.equals("x")){
                results.push(results.pop() * results.pop());
            }
            if (input.equals("/")){
                Integer arg2 = results.pop();
                results.push(results.pop() / arg2);
            }
        }

    }
}
