package view;

import action.FeedPets;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;

public class PrincipalFrame extends JFrame {
    private final NumberPetsPanel numberPetsPanel = new NumberPetsPanel();
    private final FindStartPosition findStartPosition = new FindStartPosition();

    public PrincipalFrame() {
        this.setLayout(new FlowLayout());

        JButton startBtn = new JButton("Start");
        startBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!FindStartPosition.find && !FindStartPosition.findLogInput) {
                    new FeedPets(findStartPosition.getStartPosition(), numberPetsPanel.getNumberPets()).start(false);
                }
            }
        });
        JButton start3HoursBtn = new JButton("Start 3 hours");
        start3HoursBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!FindStartPosition.find && !FindStartPosition.findLogInput) {
                    Timer timer = new Timer();
                    timer.schedule(new FeedPets(findStartPosition.getStartPosition(), numberPetsPanel.getNumberPets()), (1000*60*60*3), (1000*60*60*3)+(1000*60*5));
                }
            }
        });

        this.add(numberPetsPanel);
        this.add(findStartPosition);
        this.add(startBtn);
        this.add(start3HoursBtn);
        this.setTitle("Dofus FeedPets");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 180);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setResizable(false);
        this.setAlwaysOnTop(true);
    }

    public static void main(String... args) {
        Toolkit.getDefaultToolkit().addAWTEventListener(
                new FindStartPosition.Listener(), AWTEvent.MOUSE_EVENT_MASK | AWTEvent.FOCUS_EVENT_MASK);

        new PrincipalFrame();
    }
}
