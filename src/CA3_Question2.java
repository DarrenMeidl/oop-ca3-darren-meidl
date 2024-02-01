import java.util.Scanner;
import java.util.Stack;

/**
 *  Name: Darren Meidl
 *  Class Group: GD2b
 */
public class CA3_Question2
{
    /*
        Starter function to create the 2D array and populate it with 0

     */
    public static int[][]  floodFillStart() {
        Scanner kb = new Scanner(System.in);
        int[][] arr = new int[10][10];
        for (int x = 0; x < 10; x++)
        {
            for (int y = 0; y < 10; y++)
            {
                arr[x][y] = 0;
            }
        }
       return arr;
    }
    /*
        Helper function to display the image
     */
    public static void display(int[][] arr)
    {
        for (int x = 0; x < 10; x++)
        {
            for (int y = 0; y < 10; y++)
            {
                System.out.printf("%4d", arr[x][y]);
            }
            System.out.println();
        }
    }
    private static void fill(int r, int c, int[][] arr)
    {
        Stack<Pair> needsPainting = new Stack<>();
        int num = 1;
        needsPainting.push(new Pair(r,c)); // initial start point
        while (!needsPainting.isEmpty()){
            Pair current = needsPainting.pop(); // Removes current point from stack, it is now painted
            // Gets X & Y of current point
            int x = current.getX();
            int y = current.getY();
            if (arr[x][y] == 0){
                arr[x][y] = num++; // Keeps track of sequence of colours by adding a unique integer value to current point
            }
            else{
                break;
            }

            // Visiting new spaces (North, South, East, West)
            // North
            if (x>0 && arr[x-1][y] == 0){
                needsPainting.push(new Pair(x-1, y));
            }
            // South
            if (x<9 && arr[x+1][y] == 0){
                needsPainting.push(new Pair(x+1, y));
            }
            // East
            if (y<9 && arr[x][y+1] == 0){
                needsPainting.push(new Pair(x, y+1));
            }
            // West
            if (y>0 && arr[x][y-1] == 0){
                needsPainting.push(new Pair(x, y-1));
            }
            display(arr);
            System.out.println();
        }
    }

    public static void start()
    {
        System.out.println("BEFORE PAINTING...");
        int[][] arr = floodFillStart();
        display(arr);
        System.out.println("AFTER PAINTING...");
        fill(0, 0, arr);
        display(arr);
    }
    public static void main(String[] args) {
        start();
    }

}
