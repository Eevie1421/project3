/* Mountain Tracker V 0.1 - Evelyn Totman.
 * Mountain Tracker handles the main functionality of the program. Has functionality for preparing the simulator for
 * the day, and opening as well as closing the trails. Each time the tracker runs through a day cycle it should print
 * to a file the names of all the hikers who came down to mountain in a random order.
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Scanner;

public class MountainTracker {
    /* Using LinkedList for Queue since it does not have a capacity and will let us add and remove
     * from Queue with a runtime complexity of O(1), also when checking for a stack less than 10
     * it enables the function to remove the head and add it at the back with runtime complexity
     * of O(1).
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
    private int trail1Total;
    private int trail2Total;
    private int trail3Total;
    private LinkedList<String> allHikers;
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
        trail1Total = 0;
        trail2Total = 0;
        trail3Total = 0;
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

    /**
     * Takes the stacks from each trail and prints their name to a file keeping track of the total of each trail.
     */
    public void openTrails(){
        try{
            PrintWriter pw = new PrintWriter(nameList);
            while(!trail1.isEmpty()){
                ArrayStack<Hiker> temp = trail1.poll();
                if(temp.size() != 10 && !trail1.isEmpty()){
                    trail1.offer(temp);
                }
                else{
                    while(!temp.stackEmpty()){
                        pw.println(temp.stackPop().toString());
                        trail1Total++;
                    }
                }
            }
            while (!trail2.isEmpty()){
                ArrayStack<Hiker> temp = trail2.poll();
                if(temp.size() != 10 && !trail2.isEmpty()){
                    trail2.offer(temp);
                }
                else{
                    while(!temp.stackEmpty()){
                        pw.println(temp.stackPop().toString());
                        trail2Total++;
                    }
                }
            }
            while(!trail3.isEmpty()){
                ArrayStack<Hiker> temp = trail3.poll();
                if(temp.size() != 10 && !trail3.isEmpty()){
                    trail3.offer(temp);
                }
                else{
                    while(!temp.stackEmpty()){
                        pw.println(temp.stackPop().toString());
                        trail3Total++;
                    }
                }
            }
            pw.close();
        } catch(FileNotFoundException e){
            System.out.println(e.getMessage());
            System.out.println("Enter new file: ");
            Scanner scnr = new Scanner(System.in);
            nameList = new File(scnr.next());
            openTrails();
        }
    }

    /**
     * Takes names from the file of names created in open trails and writes them to a new file.
     * To randomize the order printed a random number 0 1 is created and each name is either added
     * to the back of a deque allHikers or the front.
     */
    public void closeTrails(){
        try{
            Scanner scnr = new Scanner(nameList);
            PrintWriter pw = new PrintWriter(endOfDayList);
            String buffer;
            while(scnr.hasNext()){
                buffer = scnr.nextLine();
                int rand = (int)(Math.random() * 2);
                if(rand == 0){
                    allHikers.offerFirst(buffer);
                }else {
                    allHikers.offerLast(buffer);
                }
            }
            while(!allHikers.isEmpty()){
                pw.println(allHikers.poll());
            }
            scnr.close();
            pw.close();
        }catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        }
    }

    public int getTotalVisitors() {
        return totalVisitors;
    }

    public int getTrail1Total() {
        return trail1Total;
    }

    public int getTrail2Total() {
        return trail2Total;
    }

    public int getTrail3Total() {
        return trail3Total;
    }
}
