import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 *  Name: Darren Meidl
 *  Class Group: GD2b
 */
public class CA3_Question1
{
    public static void main(String[] args) {
        int[] operations = {1, 2, 3, 4, 7, -2, -1, 6, 0};
        runSimulation(operations);
    }
    public static void runSimulation(int[] operations)
    {
        // drivewat and street integer stacks
        Stack<Integer> driveway = new Stack<>();
        Stack<Integer> street = new Stack<>();
        // for loop where all operations are executed
        for (int operation : operations) {
            if (operation == 0){ // if the current operation is 0, end the simulation
                System.out.println("Ending Simulation...");
                break;
            }
            else if (operation > 0) { // if the current operation is a positive number, add to driveway
                driveway.push(operation);
                System.out.println("Car " + operation + " has entered the driveway.");
            }
        }
    }


}
