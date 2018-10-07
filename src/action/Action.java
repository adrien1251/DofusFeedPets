package action;

import constant.Interval;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class Action {
    private static Action ourInstance = new Action();
    private Robot robot;

    public static Action getInstance() {
        return ourInstance;
    }

    private Action() {
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    public void moveMouseToNextPets(Point actualMousePosition) {
        actualMousePosition.setLocation(actualMousePosition.getX() + Interval.X_INTERVAL, actualMousePosition.getY());
    }

    public void moveMouseNewLine(Point mouseStartPosition, Point actualMousePosition) {
        actualMousePosition.setLocation(mouseStartPosition.getX(), actualMousePosition.getY() + Interval.Y_INTERVAL);
    }

    public void pressedAndReleased(Point point) {
        this.robot.mouseMove((int) point.getX(), (int) point.getY());
        this.robot.mousePress(MouseEvent.BUTTON3_MASK);
        this.robot.mouseRelease(MouseEvent.BUTTON3_MASK);
        this.robot.delay(Interval.SPEED);
    }

    public void alt_tab() {
        robot.delay(200);
        robot.keyPress(KeyEvent.VK_ALT);
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_ALT);
    }

    public void feedPets() {
        for (Point point : Interval.FEED_PETS_POINTS) {
            pressedAndReleased(point);
        }
    }

    public void logIn(){

    }
}
