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
        Deque<Block> arr = new ArrayDeque<>(); // queue that can be added on both ends
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
                int totalQuantity = 0;

                // If there's no shares in the queue, then we can't sell anything
                if (arr.isEmpty()){
                    System.out.println("Error. No shares to sell.");
                }


                // Otherwise, if there is at least 1 or more shares
                else {
                    // Calculate the total quantity of all shares we own
                    for (Block b : arr){
                        totalQuantity += b.getQuantity();
                    }


                    // If our total quantity is bigger or equal to the amount we want to sell, then we can sell
                    if (totalQuantity >= qty){

                        double profit = 0; // Profit defaults to 0
                        boolean soldTotal = false; // Controls while loop
                        // This loop continues to calculate the profit until the entire selling quantity is 0 or lower
                        while(!soldTotal){

                            // If the quantity is 0 or lower, the calculation is complete
                            if (qty <= 0){
                                System.out.println("Total Profit is: "+profit); // Print total profit
                                soldTotal = true; // End while loop
                            }

                            // If the quantity we want to sell is more or equal to the quantity of the last block in the queue
                            else if (qty >= arr.getLast().getQuantity()){
                                // Calculate the profit from the selling the entire quantity of the last block
                                profit += profit + (  arr.getLast().getQuantity() * ( price - arr.getLast().getPrice() )  );
                                qty -= arr.getLast().getQuantity(); // We've sold an entire block's quantity, take it away from the amount we want to sell
                                totalQuantity -= arr.getLast().getQuantity(); // We've sold an entire block's quantity, take it away from our total quantity
                                arr.remove(arr.getLast()); // Since we sold the entire last block, remove it from the queue
                                System.out.println("Sold an entire block. Current profit is: "+profit);
                            }

                            // If the amount we want to sell is less than the quantity of the last block in the queue
                            else if (qty < arr.getLast().getQuantity()){
                                profit += ( (qty * price) - (qty * arr.getLast().getPrice())); // Since we know we can sell the entire selling quantity from 1 block, we use the selling qty in the calculation
                                arr.getLast().setQuantity( arr.getLast().getQuantity() - qty ); // Take that selling amount from the last block's quantity
                                totalQuantity -= qty; // Take that selling amount from our total quantity
                                qty = 0; // Take that selling amount from itself
                                System.out.println("Sold part of block. Current profit is: "+profit); // Prints out profit
                            }
                        }



                    }
                    // If we don't have enough quantity across all blocks to sell the amount we want, we can't sell. e.g. sell 150, but we have only one block with 70 or two blocks with 50
                    else {
                        System.out.println("Error. Not enough shares to sell. Buy some before selling.");
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