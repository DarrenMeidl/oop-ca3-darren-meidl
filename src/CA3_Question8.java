import java.util.Scanner;
import java.util.Stack;
/**
 *  Name: Darren Meidl
 *  Class Group: GD2b
 */
public class CA3_Question8 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter an arithmetic expression below: ");
        String equation = in.nextLine();
        Stack<Integer> numbers = new Stack<>(); // Numbers stack for storing numbers from equation
        Stack<Character> operators = new Stack<>(); // Operators stack for storing operations from equation

        // Runs through all characters in the equation string
        for (char c : equation.toCharArray()){
            if (Character.isDigit(c)){ // If the character reads as a number
                int num = Character.getNumericValue(c); // Convert char to an integer using a built-in method
                numbers.push(num); // Push the integer to the numbers stack
            }
            else if (c == '('){ // If we read a (
                operators.push(c); // Push the operator to the operators stack
            }
            else if (c == '+' || c == '-' || c == '*' || c == '/'){
                boolean running = true; // Boolean controls while loop
                while (running){ // While the top of the stack has a higher precedence than op
                    // Evaluate the top
                }
                // push c onto the stack
            }
            else if (c == ')'){
                while(operators.peek() != c){
                    // Evaluate the top
                }
                // Pop the (
            }
            // Else if there is no more input
                while(!operators.isEmpty()){
                    // Evaluate the top
                }
        }


    }
}
