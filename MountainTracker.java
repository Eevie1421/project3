/* Mountain Tracker V 0.1 - Evelyn Totman.
 * Mountain Tracker handles the main functionality of the program. Has functionality for preparing the simulator for
 * the day, and opening as well as closing the trails. Each time the tracker runs through a day cycle it should print
 * to a file the names of all the hikers who came down to mountain in a random order.
 */
import java.io.File;
import java.util.LinkedList;
import java.util.Scanner;

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
    private String[] nameOpts;
    private File nameList;
    private File endOfDayList;
    private int totalVisitors;
    public MountainTracker(String output1, String output2, String nameFile){
        nameOpts = new String[100];
        int i = 0;
        Scanner scnr = new Scanner(nameFile);
        while (scnr.hasNext() && i < 100){
            nameOpts[i] = scnr.next();
            i++;
        }
        nameList = new File(output1);
        endOfDayList = new File(output2);
        trail1 = new LinkedList<>();
        trail2 = new LinkedList<>();
        trail3 = new LinkedList<>();
    }

    /**
     * ranName - generates a random int between 0 and 99 and returns
     * the name at the index from an array of different options
     * @return - random name.
     */
    public String randName(){
        int index;
        index = (int)(Math.random() * 100);
        return nameOpts[index];
    }

    /**
     * Start will create a number of hikers from 50 to 100.
     * These hikers will than be placed in Stacks and added to a random trail.
     */
    public void start(){
        int totalHikers = 50 + (int)(Math.random() * 51);
        while(totalVisitors < totalHikers){
            ArrayStack<Hiker> temp = new ArrayStack<>(10);
            int trailNum = (int)(1 + Math.random() * 3);
            for(int i = 0; i < 10; i++){
                totalVisitors++;
                temp.stackPush(new Hiker(randName(), totalVisitors));
                if(totalVisitors == totalHikers){
                    if(trailNum == 1){
                        trail1.offer(temp);
                    }else if(trailNum == 2){
                        trail2.offer(temp);
                    }else{
                        trail3.offer(temp);
                    }
                    break;
                }
            }
        }
    }

    public void openTrails(){

    }

    public void closeTrails(){

    }

}
