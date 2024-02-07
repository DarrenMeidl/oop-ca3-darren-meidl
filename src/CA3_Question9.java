import java.util.Scanner;

/**
 *  Name: Darren Meidl
 *  Class Group: GD2b
 */

/*
Direction enum used to indicate direction.
 */
enum DIRECTION {NORTH, SOUTH,EAST,WEST};

public class CA3_Question9
{
    public static int[][]  floodFillStart() {
        int[][] arr = new int[10][10]; // 10 x 10 grid of integers
        for (int x = 0; x < 10; x++){ // For each x value
            for(int y = 0; y < 10; y++){ // run through all y values
                arr[x][y] = 0; // Initialize current cells as open paths
            }
        }
        return arr;
    }
    public static void display(int[][] image)
    {
        for (int x = 0; x < image.length; x++)
        {
            for (int y = 0; y < image[0].length; y++)
            {
                System.out.printf("%4d", image[x][y]);
            }
            System.out.println();
        }
    }
    public void solve(int x, int y, DIRECTION dir)
    {

    }

    public static void start()
    {
        int[][] arr = floodFillStart();
        display(arr);
    }

    public static void main(String[] args) {
        start();
    }
}
