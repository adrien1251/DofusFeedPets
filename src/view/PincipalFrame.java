package view;

import action.FeedPets;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PincipalFrame extends JFrame {
    private final NumberPetsPanel numberPetsPanel = new NumberPetsPanel();
    private final FindStartPosition findStartPosition = new FindStartPosition();

    public PincipalFrame() {
        this.setLayout(new FlowLayout());

        JButton startBtn = new JButton("Start");
        startBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!FindStartPosition.find) {
                    new FeedPets(findStartPosition.getStartPosition(), numberPetsPanel.getNumberPets()).start();
                    JOptionPane.showMessageDialog(null, "Your pets was feed with succees ! =D");
                }
            }
        });

        this.add(numberPetsPanel);
        this.add(findStartPosition);
        this.add(startBtn);
        this.setTitle("Dofus FeedPets");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(300, 130);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setResizable(false);
    }

    public static void main(String... args) {
        Toolkit.getDefaultToolkit().addAWTEventListener(
                new FindStartPosition.Listener(), AWTEvent.MOUSE_EVENT_MASK | AWTEvent.FOCUS_EVENT_MASK);
        new PincipalFrame();
    }
}
