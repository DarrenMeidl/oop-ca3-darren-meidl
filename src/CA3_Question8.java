import java.util.Scanner;
import java.util.Stack;
/**
 *  Name: Darren Meidl
 *  Class Group: GD2b
 */
public class CA3_Question8 {
    public static void main(String[] args) {
        boolean isRunning = true;
        while (isRunning){
            Scanner in = new Scanner(System.in);
            System.out.println("Enter an arithmetic expression below:       (Q to Quit)");
            String equation = in.nextLine().replaceAll("\\s", ""); // Removes all spaces

            Stack<Integer> numbers = new Stack<>(); // Numbers stack for storing numbers from equation
            Stack<Character> operators = new Stack<>(); // Operators stack for storing operations from equation
            // If user wants to quit
            if (equation.equalsIgnoreCase("q") || equation.equalsIgnoreCase("quit")){
                return; // End program
            }

            // Runs through all characters in the equation string
            for (int i = 0; i < equation.length(); i++){
                char c = equation.charAt(i); // Gets current character

                if (Character.isDigit(c)){ // If the character reads as a number
                    int num = c - '0'; // Subtracts the ASCII value of '0' (which is 48) from c
                    while (i + 1 < equation.length() && Character.isDigit(equation.charAt(i + 1))) { // Runs through the next character to see if its a digit
                        num = num * 10 + (equation.charAt(i + 1) - '0'); // Add it to the number
                        i++; // Increment count
                    }
                    numbers.push(num); // Push the final number to numbers stack
                }

                else if (c == '('){ // If we read a (
                    operators.push(c); // Push the operator to the operators stack
                }

                else if (c == ')') { // If we read a )
                    while (operators.peek() != '(') { // While top of operators stack isn't a (
                        numbers.push(applyOperation(operators.pop(), numbers.pop(), numbers.pop())); // Push results of operations method to numbers stack
                    }
                    operators.pop(); // Remove the top element from operators stack
                }

                else if (c == '+' || c == '-' || c == '*' || c == '/'){ // Else if we read an operator
                    // While operators stack isn't empty & top of the stack has a higher precedence than c
                    while(!operators.isEmpty() && hasHigherPrecedence(c, operators.peek())){
                        numbers.push(applyOperation(operators.pop(), numbers.pop(), numbers.pop())); // Push results of operations method to numbers stack
                    }
                    operators.push(c); // Push c onto the stack
                }
            }
            // Once there is no more input
            while(!operators.isEmpty()) { // While the operators stack isn't empty
                numbers.push(applyOperation(operators.pop(), numbers.pop(), numbers.pop())); // Push results of operations method to numbers stack
            }
            System.out.println("The answer is: " + numbers.pop()); // Prints final results, remove last number from numbers stack
        }

    }

    // Method that checks between two chars which one has higher precedence
    public static boolean hasHigherPrecedence(char op1, char op2) {
        if (op2 == '(' || op2 == ')') {
            return false;
        }
        if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-')) {
            return false;
        }
        return true;
    }

    public static int applyOperation(char op, int b, int a) {
        // Combine the numbers with that operator
        switch (op) { // Switch to check and perform each type of operation
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                if (b == 0) {
                    System.out.println("Error! Dividing by zero is not allowed."); // If bottom number is a 0 then, print an error
                }
                return a / b;
        }
        return 0;
    }


}
