package action;

import action.Action;

import java.awt.*;

public class FeedPets {
    private final Action ACTION = Action.getInstance();
    private Point mouseStartPosition;
    private int nbPets;

    public FeedPets(Point mouseStartPosition, int nbPets){
        this.mouseStartPosition = mouseStartPosition;
        this.nbPets = nbPets;
    }

    public void start(){
        Point actualMousePosition = (Point)mouseStartPosition.clone();

        for (int i = 0; i < nbPets; i++) {
            if (i != 0 && i % 5 == 0) {
                ACTION.moveMouseNewLine(mouseStartPosition, actualMousePosition);
            }
            ACTION.pressedAndReleased(actualMousePosition);
            ACTION.feedPets();

            ACTION.moveMouseToNextPets(actualMousePosition);
        }
    }
}