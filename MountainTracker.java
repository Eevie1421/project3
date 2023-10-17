import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.LinkedList;
import java.util.Scanner;

public class MountainTracker extends JPanel implements ActionListener{
    private LinkedList<ArrayStack<Hiker>> trail1;
    private LinkedList<ArrayStack<Hiker>> trail2;
    private LinkedList<ArrayStack<Hiker>> trail3;
    private Button start;
    private Button openTrails;
    private Button closeTrails;
    private TextArea txt;
    private File daylist;

    public MountainTracker(){

        daylist = new File("day1");
        trail1 = new LinkedList<>();
        trail2 = new LinkedList<>();
        trail3 = new LinkedList<>();

        setPreferredSize(new Dimension(600, 600));
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        start = new Button("Start");
        start.setPreferredSize(new Dimension(200, 200));
        openTrails = new Button("Open Trails");
        openTrails.setPreferredSize(new Dimension(200, 200));
        closeTrails = new Button("Close Trails");
        closeTrails.setPreferredSize(new Dimension(200, 200));
        txt = new TextArea();
        txt.setPreferredSize(new Dimension(600, 400));
        c.gridx = 0;
        c.gridy = 0;
        add(start, c);
        c.gridx = 1;
        add(openTrails, 1);
        c.gridx = 2;
        add(closeTrails, c);
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 3;
        c.gridheight = 2;
        add(txt, c);
        setVisible(true);
    }

    /**
     * start - Creates a Hiker object for each hiker, writes their info to text, adds them to stacks of ten, and randomly assigns each group a trail.
     */
    private void start(){
        //For purpose of simulator we will use a file of randomly generated names
        Scanner scnr = new Scanner("hikerTest");
        int hikerNum = 1;
        ArrayStack<Hiker> group = new ArrayStack<>(10);
        do {
            String tempName = scnr.next();
            Hiker temp = new Hiker(tempName, hikerNum);
            group.stackPush(temp);
            txt.setText(temp.toString());
            txt.repaint();
            hikerNum++;
            if(group.getCapacity() == 10){
                Double trail = Math.random() * 100;
                if(trail <= 33){
                    trail1.offer(group);
                }
                else if (trail > 33 && trail <= 66){
                    trail2.offer(group);
                }
                else{
                    trail3.offer(group);
                }
                group = new ArrayStack<>(10);
            }
            else if(!scnr.hasNext()){
                Double trail = Math.random() * 100;
                if(trail <= 33){
                    trail1.offer(group);
                }
                else if (trail > 33 && trail <= 66){
                    trail2.offer(group);
                }
                else{
                    trail3.offer(group);
                }
            }
        } while(scnr.hasNext());
    }

    private void openTrails(){

    }

    private void closeTrails(){

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.equals(start)){
            start();
        }
        else if(e.equals(openTrails)){
            openTrails();
        }
        else if(e.equals(closeTrails)){
            closeTrails();
        }
    }
}
