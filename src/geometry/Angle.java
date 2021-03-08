package geometry;

import test.Test;

public class Angle {
    public static void main(String[] args) {
        double[] points = {5, 0, -6, 1};
        getLineAngleFromPoints(points);
    }

    public static double getLineAngleFromPoints(double[] points){
        double radianAngle = Math.atan2((points[3] - points[1]), (points[2] - points[0]));
        double degreeAngle = radianAngle * 180 / Math.PI;
        Test.printStuffs(degreeAngle, radianAngle);
        return degreeAngle;
    }
}
