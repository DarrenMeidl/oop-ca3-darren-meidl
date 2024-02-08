
import java.util.*;

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
        Deque<Block> arr = new ArrayDeque<>(); // array that can be added on both ends
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
                Block newShare = new Block(qty, price);
                arr.addFirst(newShare);
            }
            else if(command.equals("sell"))
            {
                System.out.print("Enter quantity: ");
                int qty = in.nextInt();
                System.out.print("\nEnter Price: ");
                double price = in.nextDouble();

                if (arr.isEmpty()){
                    System.out.println("Error. No shares to sell.");
                }
                else if (qty >= arr.getLast().getQuantity() && !arr.isEmpty()){
                    double profit = (  arr.getLast().getQuantity() * ( price - arr.getLast().getPrice() )  );
                    qty = qty - arr.getLast().getQuantity();
                    arr.remove(arr.getLast());
                    if (qty < arr.getLast().getQuantity()){
                        arr.getLast().setQuantity( arr.getLast().getQuantity() - qty );
                        profit = profit + (  arr.getLast().getQuantity() * ( price - arr.getLast().getPrice() )  );
                        System.out.println("Profit is: "+profit);

                        if(arr.isEmpty()){
                            System.out.println("ArrayDeque is empty lol");
                        }
                    }
                }

            }
            else if(command.equals("quit"))
            {
                System.out.println("Ending program..");
                return;
            }
        }while(!command.equalsIgnoreCase("quit"));
    }
}