import java.util.LinkedList;
import java.util.Queue;
/**
 *  Name: Darren Meidl
 *  Class Group: GD2b
 */

public class CA3_Question5
{
    Queue<String> takeoffQueue = new LinkedList<>(); // takeoff queue
    Queue<String> landQueue = new LinkedList<>(); // landing queue
    boolean active = true; // boolean to end simulation

    public void takeoff(String plane){
        takeoffQueue.add(plane); // Adds plane to takeoff queue
    }
    public void land(String plane){
        landQueue.add(plane); // Adds plane to landing queue
    }

    public void next(){
        // If active is false, then the simulation ends
        if (!active) {
            System.out.println("Simulation has ended.");
            return;
        }
        // If the landing queue isn't empty
        if (!landQueue.isEmpty()) {
            System.out.println("Landing " + landQueue.poll()); // prints the plane at the front of the landing queue and removes it
        }
        // If the landing queue is empty but the takeoff queue isn't empty
        else if (!takeoffQueue.isEmpty()) {
            System.out.println("Takeoff " + takeoffQueue.poll()); // prints the plane at the front of the takeoff queue and removes it
        }
        else {
            System.out.println("No flights in queue"); // Otherwise, there aren't anymore flights
        }
    }
    // Method to tell the simulation to end
    public void quit(){
        active = false;
        System.out.println("Simulation ending..");
    }

    public static void main(String[] args)
    {
        CA3_Question5 airport = new CA3_Question5(); // Create instance of the class
        airport.takeoff("Flight-100");
        airport.takeoff("Flight-220");
        airport.land("Flight-320");
        airport.takeoff("Flight-107");
        airport.land("Flight-487");
        airport.next();  // Landing Flight-320
        airport.next();  // Landing Flight-487
        airport.next();  // Takeoff Flight-100
        airport.next();  // Takeoff Flight-220
        airport.next();  // Takeoff Flight-107
        airport.quit();  // Simulation ending..
    }
}
