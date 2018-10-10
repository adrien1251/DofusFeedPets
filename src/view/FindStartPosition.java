package view;

import action.Action;
import constant.Interval;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FindStartPosition extends JPanel {
    private static Point startPosition = new Point(664, 280);
    private static int nbClick = 0;

    private static JButton btnFindPosition = new JButton("Find start position");
    private static JButton showLogInput = new JButton("Show log input");
    private static JButton showBasketInput = new JButton("Show Basket");
    private static JButton showDisconnectInput = new JButton("Show disconnect");

    public static boolean find = false;
    public static boolean findLogInput = false;
    public static boolean findBasketInput = false;
    public static boolean findDisconnectInput = false;

    public FindStartPosition() {
        btnFindPosition.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!find && !findLogInput && !findBasketInput && !findDisconnectInput) {
                    find = true;
                }
            }
        });

        add(btnFindPosition);

        showLogInput.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!find && !findLogInput && !findBasketInput && !findDisconnectInput) {
                    findLogInput = true;
                }
            }
        });

        add(showLogInput);

        showBasketInput.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!find && !findLogInput && !findBasketInput && !findDisconnectInput) {
                    findBasketInput = true;
                }
            }
        });

        add(showBasketInput);

        showDisconnectInput.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!find && !findLogInput && !findBasketInput && !findDisconnectInput) {
                    findDisconnectInput = true;
                }
            }
        });

        add(showDisconnectInput);
    }

    public Point getStartPosition() {
        return startPosition;
    }

    public static class Listener implements AWTEventListener {
        public void eventDispatched(AWTEvent event) {
            if (FocusEvent.FOCUS_LOST == event.getID()) {
                if (find) {
                   find = fillTableClick(Interval.FEED_PETS_POINTS);
                } else if (findLogInput) {
                    findLogInput = fillTableClick(Interval.LOG_POINTS);
                } else if (findBasketInput) {
                    findBasketInput = fillTableClick(Interval.BASKET_POINT);
                } else if (findDisconnectInput) {
                    findDisconnectInput = fillTableClick(Interval.DISCONNECT_POINT);
                }
            }
        }
    }

    private static boolean fillTableClick(Point[] tableToFill) {
        nbClick++;
        tableToFill[nbClick - 1] = MouseInfo.getPointerInfo().getLocation();
        Action.getInstance().alt_tab();

        if (nbClick == tableToFill.length) {
            nbClick = 0;
            return false;
        }
        return true;
    }
}
