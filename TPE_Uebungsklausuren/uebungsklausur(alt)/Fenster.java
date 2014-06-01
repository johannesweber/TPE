import javax.swing.*;
import java.awt.*;

/**
 * Created by Johannes on 11.01.14.
 */
public class Fenster {

    JFrame frame = new JFrame("TPE2009");

    JPanel panel = new JPanel();

    JButton northButton = new JButton("North");
    JButton southButton = new JButton("South");
    JButton eastButton = new JButton("East");
    JButton westButton = new JButton("West");
    JButton centerButton = new JButton("Center");

    public void show(){

        frame.setLayout(new BorderLayout());
        frame.add(panel);

        panel.add(northButton, BorderLayout.NORTH);
        panel.add(centerButton, BorderLayout.CENTER);
        panel.add(eastButton, BorderLayout.EAST);
        panel.add(westButton, BorderLayout.WEST);
        panel.add(southButton, BorderLayout.SOUTH);

        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[]args){

        new Fenster().show();
    }
}
