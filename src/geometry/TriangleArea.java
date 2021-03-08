package geometry;

import test.Test;

public class TriangleArea {
    public static void main(String[] args) {
        double[] points = {15, 15, 23, 30, 50, 25};
        getAreaFromPoints(points);
    }

    public static void getAreaFromPoints(double[] points){
        double a = Math.sqrt(Math.pow(points[0] - points[2], 2) + Math.pow(points[1] - points[3], 2));
        double b = Math.sqrt(Math.pow(points[2] - points[4], 2) + Math.pow(points[3] - points[5], 2));
        double c = Math.sqrt(Math.pow(points[4] - points[0], 2) + Math.pow(points[5] - points[1], 2));
        double s = (a + b + c) / 2;
        double area = Math.sqrt(s * (s - a) * (s - b) * (s - c));
        Test.printStuffs(a, b, c, area);
    }
}
