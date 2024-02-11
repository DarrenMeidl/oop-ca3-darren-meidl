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
            String equation = in.nextLine();

            if (equation.equalsIgnoreCase("q") || equation.equalsIgnoreCase("quit")){
                isRunning = false;
            }

            // Variables
            int num = 0;
            boolean isNum = false;
            Stack<Integer> numbers = new Stack<>(); // Numbers stack for storing numbers from equation
            Stack<Character> operators = new Stack<>(); // Operators stack for storing operations from equation

            // Runs through all characters in the equation string
            for (char c : equation.toCharArray()){
                if (Character.isDigit(c)){ // If the character reads as a number
                    num = num * 10 + Character.getNumericValue(c); // Build up the number then convert char to an integer using a built-in method
                    isNum = true;
                }
                else{
                    if (isNum){
                        numbers.push(num); // Push the number to the numbers stack
                        num = 0;
                        isNum = false;
                    }


                    else if (c == '('){ // If we read a (
                        operators.push(c); // Push the operator to the operators stack
                    }


                    else if (c == '+' || c == '-' || c == '*' || c == '/'){ // Else if we read an operator
                        // While the top of the stack has a higher precedence than c & operators stack isn't empty
                        while(!operators.isEmpty() && hasHigherPrecedence(operators.peek(), c)){
                            // Error checks
                            if (numbers.size() < 2) { // If the numbers stack has less than 2 elements
                                System.out.println("Error: Not enough numbers in the stack.");
                                return;
                            }

                            // Evaluate the top
                            // Pop two numbers off the number stack
                            int num2 = numbers.pop();
                            int num1 = numbers.pop();
                            // Pop an operator off the operator stack
                            char operator = operators.pop();

                            // Combine the numbers with that operator & push the result onto the numbers stack
                            switch (operator) { // Switch to check and perform each type of operation
                                case '+':
                                    numbers.push(num1 + num2); // If it's a plus, add them, push to numbers stack
                                    break;
                                case '-':
                                    numbers.push(num1 - num2); // If it's a minus, subtract them, push to numbers stack
                                    break;
                                case '*':
                                    numbers.push(num1 * num2); // If it's a star, multiply them, push to numbers stack
                                    break;
                                case '/':
                                    if (num2 != 0) {
                                        numbers.push(num1 / num2); // If it's a slash, divide them, push to numbers stack
                                    } else {
                                        System.out.println("Error! Dividing by zero is not allowed."); // If bottom number is a 0 then, print an error
                                        return;
                                    }
                                    break;
                            }

                        }
                        operators.push(c); // Push c onto the stack
                    }


                    else if (c == ')'){
                        while(!operators.isEmpty() && operators.peek() != '('){
                            // Error checks
                            if (numbers.size() < 2) { // If the numbers stack has less than 2 elements
                                System.out.println("Error: Not enough numbers in the stack.");
                                return;
                            }

                            // Evaluate the top
                            // Pop two numbers off the number stack
                            int num2 = numbers.pop();
                            int num1 = numbers.pop();
                            // Pop an operator off the operator stack
                            char operator = operators.pop();

                            // Combine the numbers with that operator & push the result onto the numbers stack
                            switch (operator) { // Switch to check and perform each type of operation
                                case '+':
                                    numbers.push(num1 + num2); // If it's a plus, add them, push to numbers stack
                                    break;
                                case '-':
                                    numbers.push(num1 - num2); // If it's a minus, subtract them, push to numbers stack
                                    break;
                                case '*':
                                    numbers.push(num1 * num2); // If it's a star, multiply them, push to numbers stack
                                    break;
                                case '/':
                                    if (num2 != 0) {
                                        numbers.push(num1 / num2); // If it's a slash, divide them, push to numbers stack
                                    } else {
                                        System.out.println("Error! Dividing by zero is not allowed."); // If bottom number is a 0 then, print an error
                                        return;
                                    }
                                    break;
                            }

                        }
                        if (!operators.isEmpty()){
                            operators.pop(); // Pop the (
                        }
                    }
                }
            }
            // Check if isNum is true in case input string ends in number, ensures multi-digit numbers are included
            if (isNum){
                numbers.push(num); // Pushes last number to numbers stack
            }
            // Once there is no more input
            while(!operators.isEmpty()) { // While the operators stack isn't empty
                // Error checks
                if (numbers.size() < 2) { // If the numbers stack has less than 2 elements
                    System.out.println("Error: Not enough numbers in the stack.");
                    return;
                }

                // Evaluate the top
                // Pop two numbers off the number stack
                int num2 = numbers.pop();
                int num1 = numbers.pop();
                // Pop an operator off the operator stack
                char operator = operators.pop();

                // Combine the numbers with that operator & push the result onto the numbers stack
                switch (operator) { // Switch to check and perform each type of operation
                    case '+':
                        numbers.push(num1 + num2); // If it's a plus, add them, push to numbers stack
                        break;
                    case '-':
                        numbers.push(num1 - num2); // If it's a minus, subtract them, push to numbers stack
                        break;
                    case '*':
                        numbers.push(num1 * num2); // If it's a star, multiply them, push to numbers stack
                        break;
                    case '/':
                        if (num2 != 0) {
                            numbers.push(num1 / num2); // If it's a slash, divide them, push to numbers stack
                        } else {
                            System.out.println("Error! Dividing by zero is not allowed."); // If bottom number is a 0 then, print an error
                            return;
                        }
                        break;
                }

            }

            System.out.println("The answer is: " + numbers.peek()); // Prints final results
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

    public static int applyOperation(char op, int a, int b) {
        // Combine the numbers with that operator & push the result onto the numbers stack
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
