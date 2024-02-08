
import java.util.Scanner;
/**
 *  Name: Darren Meidl
 *  Class Group: GD2b
 */
public class CA3_Question6
{

    /*
    Will repeatedly ask the user to enter the commands in the format
    buy qty price
    or
    sell qty price
    or
    quit
     */
    public static void main(String[] args) {

       Scanner in = new Scanner(System.in);
        String command="";
            do {
            System.out.print(">");
            command = in.next();
            if(command.equalsIgnoreCase("buy"))
            {
                System.out.print("Enter quantity: ");
                int qty = in.nextInt();
                System.out.print("\nEnter Price: ");
                double price = in.nextDouble();

            }
            else if(command.equals("sell"))
            {
                System.out.print("Enter quantity: ");
                int qty = in.nextInt();
                System.out.print("\nEnter Price: ");
                double price = in.nextDouble();
            }
            else if(command.equals("quit"))
            {
                System.out.println("Ending program..");
                return;
            }
        }while(!command.equalsIgnoreCase("quit"));
    }
}