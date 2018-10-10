package view;

import action.Action;
import constant.Interval;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FindStartPosition extends JPanel {
    private static Point startPosition = new Point(664, 280);
    private static int nbClick = 0;
    private static int nbClickLog = 0;
    private static int nbClickBasket = 0;
    private static int nbDisconnect= 0;

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
                if (!find) {
                    find = true;
                    btnFindPosition.setText("Find start position (First pet)");
                }
            }
        });

        add(btnFindPosition);

        showLogInput.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!findLogInput) {
                    findLogInput = true;
                }
            }
        });

        add(showLogInput);

        showBasketInput.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!findBasketInput) {
                    findBasketInput = true;
                }
            }
        });

        add(showBasketInput);

        showDisconnectInput.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!findDisconnectInput) {
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

                    Action.getInstance().alt_tab();
                }
            } else if (findLogInput) {
                if (FocusEvent.FOCUS_LOST == event.getID()) {
                    nbClickLog++;
                    Interval.setLogPoint(nbClickLog - 1, MouseInfo.getPointerInfo().getLocation());

                    if (nbClickLog == 3) {
                        nbClickLog = 0;
                        findLogInput = false;
                    }
                    Action.getInstance().alt_tab();
                }
            } else if (findBasketInput) {
                if (FocusEvent.FOCUS_LOST == event.getID()) {
                    nbClickBasket++;
                    Interval.setBasketPoint(nbClickBasket - 1, MouseInfo.getPointerInfo().getLocation());

                    if (nbClickBasket == 3) {
                        nbClickBasket = 0;
                        findBasketInput = false;
                    }
                    Action.getInstance().alt_tab();
                }
            } else if (findDisconnectInput) {
                if (FocusEvent.FOCUS_LOST == event.getID()) {
                    nbDisconnect++;
                    Interval.setDisconnectPoint(nbDisconnect - 1, MouseInfo.getPointerInfo().getLocation());

                    if (nbDisconnect == 5) {
                        nbDisconnect = 0;
                        findDisconnectInput = false;
                    }
                    Action.getInstance().alt_tab();
                }
            }
        }
    }
}
