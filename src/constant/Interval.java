package constant;

import java.awt.*;

public class Interval {
    public final static int X_INTERVAL = 40;
    public final static int Y_INTERVAL = 40;
    public final static int SPEED = 500;
    public static Point[] FEED_PETS_POINTS = new Point[]{
            new Point(305, 662),
            new Point(406, 538),
            new Point(649, 271),
            new Point(984, 221)
    };

    public static void setFeedPetsPoints(int i, Point point){
        FEED_PETS_POINTS[i] = point;
    }
}
