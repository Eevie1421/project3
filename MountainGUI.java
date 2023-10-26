import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MountainGUI extends JPanel implements ActionListener {
    //Using two filenames which do not exist and a file which contains random names to test MountainTracker.
    private MountainTracker test;
    private Button start;
    private Button open;
    private Button close;
    private JTextField txt;

    public MountainGUI(){
        setSize(new Dimension(900, 900));
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        test = new MountainTracker("file1", "file2", "nametest");
        start = new Button("Start");
        start.setPreferredSize(new Dimension(300, 300));
        open = new Button("Open Trails");
        open.setPreferredSize(new Dimension(300, 300));
        close = new Button("Close Trails");
        close.setPreferredSize(new Dimension(300, 300));
        txt = new JTextField("Click Start to begin day");
        txt.setPreferredSize(new Dimension(900, 600));

        c.gridx = 0;
        c.gridy = 0;
        add(start, c);
        c.gridx = 1;
        add(open, c);
        c.gridx = 2;
        add(close, c);
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 3;
        c.gridheight = 2;
        add(txt, c);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.equals(start)){
            test.start();
        }
        else if(e.equals(open)){
            test.openTrails();
        }
        else if(e.equals(close)){
            test.closeTrails();

        }
    }

    public static void main(String args[]){
        MountainGUI test = new MountainGUI();
        JFrame mountain = new JFrame();
        mountain.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mountain.setSize(900, 900);
        mountain.add(test);
        mountain.pack();
        mountain.setVisible(true);
    }
}
