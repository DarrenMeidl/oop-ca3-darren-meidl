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
        Stack<Integer> driveway = new Stack<>();
        Stack<Integer> street = new Stack<>();

        for (int operation : operations) {
            if (operation == 0){
                System.out.println("Ending Simulation...");
                break;
            }
        }
    }


}
