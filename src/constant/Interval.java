package constant;

import java.awt.*;

public class Interval {
    public final static int X_INTERVAL = 40;
    public final static int Y_INTERVAL = 40;
    public final static int SPEED = 500;

    public static Point[] FEED_PETS_POINTS = new Point[6];
    public static Point[] LOG_POINTS = new Point[3];
    public static Point[] BASKET_POINT = new Point[3];
    public static Point[] DISCONNECT_POINT = new Point[5];

    public static void setFeedPetsPoints(int i, Point point){
        FEED_PETS_POINTS[i] = point;
    }
    public static void setLogPoint(int i, Point point){
        LOG_POINTS[i] = point;
    }
    public static void setBasketPoint(int i, Point point){
        BASKET_POINT[i] = point;
    }
    public static void setDisconnectPoint(int i, Point point){
        DISCONNECT_POINT[i] = point;
    }
}
