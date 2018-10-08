package action;

import constant.Interval;
import constant.Log;

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

    public void pressedAndReleased(Point point, int speed) {
        this.robot.mouseMove((int) point.getX(), (int) point.getY());
        this.robot.mousePress(MouseEvent.BUTTON3_MASK);
        this.robot.mouseRelease(MouseEvent.BUTTON3_MASK);
        this.robot.delay(speed);
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
            pressedAndReleased(point, Interval.SPEED);
        }
    }

    public void typeText(Point point, char[] text){
        pressedAndReleased(point, 100);
        for(char lettre: text){
            if (lettre == '3') {
                robot.keyPress(KeyEvent.VK_SHIFT);
                robot.keyPress(KeyEvent.VK_3);
                robot.keyRelease(KeyEvent.VK_3);
                robot.keyRelease(KeyEvent.VK_SHIFT);
            } else {
                robot.keyPress(KeyEvent.getExtendedKeyCodeForChar(lettre));
                robot.keyRelease(KeyEvent.getExtendedKeyCodeForChar(lettre));
            }
        }
        robot.delay(500);
    }
}
