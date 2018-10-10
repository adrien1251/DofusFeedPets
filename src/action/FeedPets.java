package action;

import constant.Interval;
import constant.Log;

import java.awt.*;
import java.util.TimerTask;

public class FeedPets extends TimerTask {
    private final Action ACTION = Action.getInstance();
    private Point mouseStartPosition;
    private int nbPets;

    public FeedPets(Point mouseStartPosition, int nbPets){
        this.mouseStartPosition = mouseStartPosition;
        this.nbPets = nbPets;
    }

    public void start(boolean feedFirst){
        Point actualMousePosition = (Point)mouseStartPosition.clone();
        //Skip the first pets cause we already feed him
        int startIndex=0;
        if(!feedFirst) {
            startIndex = 1;
            ACTION.moveMouseToNextPets(actualMousePosition);
        }

        for (int i=startIndex; i < nbPets; i++) {
            if (i != 0 && i % 5 == 0) {
                ACTION.moveMouseNewLine(mouseStartPosition, actualMousePosition);
            }
            ACTION.pressedAndReleased(actualMousePosition, Interval.SPEED);
            ACTION.feedPets();

            ACTION.moveMouseToNextPets(actualMousePosition);
        }
    }

    public void start3Hours(){
        ACTION.typeText(Interval.LOG_POINTS[0], Log.LOGIN.toCharArray());
        ACTION.typeText(Interval.LOG_POINTS[1], Log.PASSWORD.toCharArray());
        ACTION.pressedAndReleased(Interval.LOG_POINTS[2], 10000);
        ACTION.pressedAndReleased(Interval.BASKET_POINT[0], 5000);
        ACTION.pressedAndReleased(Interval.BASKET_POINT[1], 1000);
        ACTION.typeText(Interval.BASKET_POINT[2], "peki".toCharArray());

        start(true);

        ACTION.disconnectAccount(Interval.DISCONNECT_POINT);
    }

    public void run(){
        System.out.println("On commence");
        start3Hours();
    }
}
