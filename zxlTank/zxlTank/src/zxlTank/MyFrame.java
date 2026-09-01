package zxlTank;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MyFrame extends JFrame {

    private MyPanel map;

    public static void main(String[] args) {
        new MyFrame();
    }
    public MyFrame(){
        map = new  MyPanel();
        new Thread(map).start();
        this.add(map);
        this.setSize(1300,750);
        this.addKeyListener(map);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                Record.write();
                System.exit(0);
            }
        });
    }
}
