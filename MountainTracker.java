/* Mountain Tracker V 0.1 - Evelyn Totman.
 * Mountain Tracker handles the main functionality of the program. Has functionality for preparing the simulator for
 * the day, and opening as well as closing the trails. Each time the tracker runs through a day cycle it should print
 * to a file the names of all the hikers who came down to mountain in a random order.
 */
import java.io.File;
import java.util.LinkedList;

public class MountainTracker {
    /* Using LinkedList for Queue since it does not have a capacity and will let us add and remove
     * from Queue with a runtime complexity of O(1).
     *
     * Since the stack's all have a capacity of 10 we can use array and not have to resize when adding. This will also
     * allow us for access to array's functions for size as well as enable us to add and remove based on index of top
     * of stack giving us runtime complexity of O(1) on adds and removes.
     */
    private LinkedList<ArrayStack<Hiker>> trail1;
    private LinkedList<ArrayStack<Hiker>> trail2;
    private LinkedList<ArrayStack<Hiker>> trail3;
    private File hikerList1;
    public MountainTracker(String output){
        hikerList1 = new File(output);
        trail1 = new LinkedList<>();
        trail2 = new LinkedList<>();
        trail3 = new LinkedList<>();
    }

    public void start(){

    }

    public void openTrails(){

    }

    public void closeTrails(){

    }

}
