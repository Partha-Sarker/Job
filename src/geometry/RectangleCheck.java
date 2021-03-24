package geometry;

import test.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class RectangleCheck {

    public static void main(String[] args) {
        Point[] points1 = new Point[4];
        points1[0] = new Point(4, 2);
        points1[1] = new Point(2, 4);
        points1[2] = new Point(7, 5);
        points1[3] = new Point(5, 7);
        Point[] points2 = new Point[4];
        points2[0] = new Point(0, 0);
        points2[1] = new Point(0, 0);
        points2[2] = new Point(5, 0 );
        points2[3] = new Point(0, 5);
        System.out.println(checkRectangleFromPoints(points2));
    }

    public static boolean checkRectangleFromPoints(Point[] points){
        ArrayList<Double> dstList = new ArrayList<>();
        for(int i = 0; i < points.length; i++){
            for(int j = i + 1; j < points.length; j++){
                double dst = getDistance(points[i], points[j]);
                dstList.add(dst);
            }
        }
        dstList.sort(Collections.reverseOrder());
//        System.out.println(dstList.toString());
        if(dstList.get(0).equals(dstList.get(1))){
            System.out.println("Diagonal check passed");
            if(!dstList.get(1).equals(dstList.get(2))){
                return true;
            }
        }
        return false;
    }

    public static double getDistance(Point p1, Point p2){
        double y = Math.pow(p2.y - p1.y, 2);
        double x = Math.pow(p2.x - p1.x, 2);
        return Math.sqrt(x + y);
    }
}

class Point{
    int x, y;
    Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}

