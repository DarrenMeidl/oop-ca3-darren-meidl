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
        // driveway and street integer stacks
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
            else { // if the current operation isn't 0 or a positive number, remove that car from driveway
                int carNum = Math.abs(operation); // changes negative integer to positive integer, allows us to remove the car of our choice e.g. '-2' removes car '2'
                while (!driveway.isEmpty() && driveway.peek() != carNum) { // as long as the driveway isn't empty & the top value isn't the car we want, move it out of the driveway and onto the street
                    street.push(driveway.pop()); // pop returns a reference before removing the car
                }
                if (!driveway.isEmpty()){ // the previous statement ends once we're on the car we want, if the driveway still isn't empty then remove that car from the driveway
                    driveway.pop();
                    System.out.println("Car "+carNum+" has left the driveway.");
                }
                while (!street.isEmpty()){ // if there are any cars on the street, removes them and adds them into the driveway
                    driveway.push(street.pop());
                }
            }
        }
    }


}
