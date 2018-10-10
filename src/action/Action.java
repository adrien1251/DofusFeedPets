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
        this.robot.delay(200);
        this.robot.keyPress(KeyEvent.VK_ALT);
        this.robot.keyPress(KeyEvent.VK_TAB);
        this.robot.keyRelease(KeyEvent.VK_TAB);
        this.robot.keyRelease(KeyEvent.VK_ALT);
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
                this.robot.keyPress(KeyEvent.VK_SHIFT);
                this.robot.keyPress(KeyEvent.VK_3);
                this.robot.keyRelease(KeyEvent.VK_3);
                this.robot.keyRelease(KeyEvent.VK_SHIFT);
            } else {
                this.robot.keyPress(KeyEvent.getExtendedKeyCodeForChar(lettre));
                this.robot.keyRelease(KeyEvent.getExtendedKeyCodeForChar(lettre));
            }
        }
        robot.delay(500);
    }

    public void disconnectAccount(Point[] points){
        this.robot.mouseMove((int) points[0].getX(), (int) points[0].getY());
        this.robot.mousePress(MouseEvent.BUTTON3_MASK);
        this.robot.delay(500);
        this.robot.mouseMove((int) points[1].getX(), (int) points[1].getY());
        this.robot.mouseRelease(MouseEvent.BUTTON3_MASK);
        this.robot.delay(500);
        pressedAndReleased(points[2], 3000);
        pressedAndReleased(points[3], 1000);
        pressedAndReleased(points[4], 500);
    }
}
