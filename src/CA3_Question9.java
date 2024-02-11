import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

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
    public static int[][]  createMaze() {
        int[][] arr = new int[10][10]; // 10 x 10 grid of integers
        // Set entire grid to 0s, acts as 'blank canvas'
        for (int x = 0; x < 10; x++){ // For each x value
            for(int y = 0; y < 10; y++){ // run through all y values
                arr[x][y] = 0; // Initialize current cells as open paths
            }
        }

    // OUTER WALLS
        // LEFT WALL
        for (int i = 0; i < 10; i++) {
            arr[i][0] = -1; // -1 represents a wall
        }
        // RIGHT WALL
        for (int i = 0; i < 10; i++) {
            arr[i][9] = -1; // -1 represents a wall
        }
        // BOTTOM WALL
        for (int i = 0; i < 10; i++) {
            arr[9][i] = -1; // -1 represents a wall
        }
        // TOP WALL
        for (int i = 0; i < 10; i++) {
            arr[0][i] = -1; // -1 represents a wall
        }

    // INNER WALLS
        // WALL 1
        arr[5][3] = -1;
        arr[5][4] = -1;
        arr[5][5] = -1;
        arr[5][6] = -1;
        arr[5][7] = -1;
        // WALL 2
        arr[2][7] = -1;
        arr[3][7] = -1;
        arr[4][7] = -1;
        // WALL 3
        arr[1][5] = -1;
        arr[2][5] = -1;
        arr[3][5] = -1;
        // WALL 4
        arr[3][4] = -1;
        arr[3][3] = -1;
        arr[3][2] = -1;

        // START & EXIT POINTS
        arr[4][4] = 1; // 1 means start point
        arr[9][5] = 2; // 2 means exit point



        return arr;
    }







    public static void solve(int x, int y, DIRECTION dir, int[][] arr)
    {
        // DEFINING DIRECTIONS
        Map<DIRECTION, int[]> directionMap = new HashMap<>(); // new hashmap, direction enum as key & integer array as value
        directionMap.put(DIRECTION.NORTH, new int[]{-1, 0});
        directionMap.put(DIRECTION.EAST, new int[]{0, 1});
        directionMap.put(DIRECTION.SOUTH, new int[]{1, 0});
        directionMap.put(DIRECTION.WEST, new int[]{0, -1});

        // CREATING STACK
        Stack<int[]> directionsStack = new Stack<>();
        directionsStack.push(new int[]{x, y}); // Add starting point (in method parameter) to stack

        // ALGORITHM
        while (!directionsStack.isEmpty()) {
            int[] position = directionsStack.pop(); // Remove top position from stack
            x = position[0]; // extracts x position
            y = position[1]; // extracts y position

            // Check if the current position is the exit
            if (arr[x][y] == 2) {
                System.out.println("Exit found at (" + x + ", " + y + ")");
                return;
            }

            // Mark the current position as visited
            arr[x][y] = -1;

            // Check the specified direction first
            int[] direction = directionMap.get(dir); // gets int array value from hashmap & assigns to new direction integer array
            int newX = x + direction[0]; // adds x direction to current x
            int newY = y + direction[1]; // adds y direction to current y

            // Check if the new position is within the maze & not visited
            if (newX >= 0 && newX < arr.length && newY >= 0 && newY < arr[0].length && arr[newX][newY] != -1) {
                System.out.println("Moving to position: (" + newX + ", " + newY + ")"); // Print new position
                directionsStack.push(new int[]{newX, newY});
                continue; // Ensures the while loop continues to the next position in the stack without checking other directions
            }

            // If the specified direction is blocked, check all other directions
            for (DIRECTION d : DIRECTION.values()) {
                if (d == dir) continue; // Skip the specified direction
                direction = directionMap.get(d);
                newX = x + direction[0];
                newY = y + direction[1];

                // Check if the new position is within the maze and not visited
                if (newX >= 0 && newX < arr.length && newY >= 0 && newY < arr[0].length && arr[newX][newY] != -1) {
                    System.out.println("Moving to position: (" + newX + ", " + newY + ")"); // Print new position
                    directionsStack.push(new int[]{newX, newY});
                }
            }
        }

        System.out.println("No exit found.");
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
    public static void start()
    {
        int[][] arr = createMaze(); // Fills in a new maze into the int array
        display(arr); // Calls the display method to print out the int array
        solve(1, 1, DIRECTION.valueOf("SOUTH"), arr); // Calls the solve method to find the exit in the int array
    }

    public static void main(String[] args) {
        start();
    } // Calls the start method
}
