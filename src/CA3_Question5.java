import java.util.LinkedList;
import java.util.PriorityQueue;
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
        takeoffQueue.add(plane);
    }
    public void land(PriorityQueue<String> land, String plane){
        landQueue.add(plane);
    }


    public static void main(String[] args)
    {

    }
}
