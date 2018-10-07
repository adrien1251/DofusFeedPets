package action;

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
        //Skip the first pets cause we already feed him
        ACTION.moveMouseToNextPets(actualMousePosition);

        for (int i = 1; i < nbPets; i++) {
            if (i % 5 == 0) {
                ACTION.moveMouseNewLine(mouseStartPosition, actualMousePosition);
            }
            ACTION.pressedAndReleased(actualMousePosition);
            ACTION.feedPets();

            ACTION.moveMouseToNextPets(actualMousePosition);
        }
    }
}
