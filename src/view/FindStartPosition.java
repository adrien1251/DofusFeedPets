package view;

import constant.Interval;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FindStartPosition extends JPanel {
    private static Point startPosition = new Point(664, 280);
    private static int nbClick = 0;
    private static JButton btnFindPosition = new JButton("Find start position");
    public static boolean find = false;

    public FindStartPosition() {
        btnFindPosition.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!find) {
                    find = true;
                    btnFindPosition.setText("Find start position (First pet)");
                }
            }
        });

        add(btnFindPosition);
    }

    public Point getStartPosition() {
        return startPosition;
    }

    public static class Listener implements AWTEventListener {
        public void eventDispatched(AWTEvent event) {
            if (find) {
                if (FocusEvent.FOCUS_LOST == event.getID()) {
                    nbClick++;
                    if (nbClick == 1) {
                        startPosition = MouseInfo.getPointerInfo().getLocation();
                        btnFindPosition.setText("Find start position (Action)");
                    } else {
                        Interval.setFeedPetsPoints(nbClick - 2, MouseInfo.getPointerInfo().getLocation());
                        switch (nbClick) {
                            case 2:
                                btnFindPosition.setText("Find start position (Feed)");
                                break;
                            case 3:
                                btnFindPosition.setText("Find start position (Graine)");
                                break;
                            case 4:
                                btnFindPosition.setText("Find start position (Valider)");
                                break;
                            case 5:
                                btnFindPosition.setText("Find start position (OK)");
                                break;
                            case 6:
                                btnFindPosition.setText("Find start position (CLOSE FEED WINDOWS)");
                                break;
                        }
                    }

                    if (nbClick == 7) {
                        find = false;
                        nbClick = 0;
                        btnFindPosition.setText("Find start position");
                    }
                }
            }
        }
    }
}
