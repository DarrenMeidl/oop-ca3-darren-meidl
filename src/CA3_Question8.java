import java.util.Scanner;
import java.util.Stack;
/**
 *  Name: Darren Meidl
 *  Class Group: GD2b
 */
public class CA3_Question8 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Stack<Integer> results = new Stack<Integer>(); // results stack where we'll store numbers and results of operations from user's equation
        System.out.println("Using the Reverse Polish Expression, please enter an equation one number or operation per line, Q to stop.");
        boolean done = false; // boolean to control when the while loop ends

        while (!done){
            String input = in.nextLine().trim(); // User's input string, using trim to remove any whitespace characters

            /*
                if the input is an operator then take out the last two numbers and push the new result
            */

            if (input.equals("+")){ // if it's plus, add them
                results.push(results.pop() + results.pop());
            }
            if (input.equals("-")){ // if it's minus, take them away
                Integer arg2 = results.pop();
                results.push(results.pop() - arg2);
            }
            if (input.equals("*") || input.equals("x")){ // if it's multiply, multiply them together
                results.push(results.pop() * results.pop());
            }
            if (input.equals("/")){ // if it's divide, divide them
                Integer arg2 = results.pop();
                results.push(results.pop() / arg2);
            }
            else if (input.equals("Q") | input.equals("q")){ // if they enter Q, end the calculation
                done = true;
            }
            else {
                // otherwise, if the input isn't an operator, add the number to the stack
                results.push(Integer.parseInt(input));
            }
            System.out.println(results);
        }
    }
}
