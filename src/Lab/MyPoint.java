package Lab;

import java.lang.Math.*;

/***
 * Class represents a coordinate(point) in a 2D plane. Composed of one double array with size 2.
 */
public class MyPoint {
    private double[] point = new double[2];     //point[0] is x, point[1] is y

    /***
     * Default constructor. Initializes x and y to be 0
     */
    MyPoint(){
        this.point[0] = 0;
        this.point[1] = 0;
    }

    /***
     * Constructor with parameters
     * @param x supplies x coordinate for object
     * @param y supplies y coordinate for object
     */
    MyPoint(double x, double y){
        this.point[0] = x;
        this.point[1] = y;
    }

    /***
     * point getter
     * @return returns double array with both coordinates in it
     */
    public double[] getPoint(){
        return this.point;
    }

    /***
     * point setter
     * @param x supplies function with new x coordinate
     * @param y supplies function with new y coordinate
     */
    public void setPoint(double x, double y){
        this.point[0] = x;
        this.point[1] = y;
    }

    /***
     * function that allows us to print/return a String of our point formatted (x,y).
     * @return returns String object with format (x,y)
     */
    public String toString(){
        System.out.println("(" + this.point[0] + ", " + this.point[1] + ")");
        return "(" + this.point[0] + ", " + this.point[1] + ")";
    }

    /***
     * calculates the distance between 2 points given direct x y coordinates
     * @param x2 supplies x of point to compare to
     * @param y2 supplies y of point to compare to
     * @return returns a double of the length
     */
    public double distance(double x2, double y2){
        //sqrt ( (x2-x1)^2 + (y2-y1)^2 )
        System.out.println("Distance is: " + Math.sqrt(Math.pow((x2-this.point[0]),2) + Math.pow((y2-
        this.point[1]),2)));
        return Math.sqrt(Math.pow((x2-this.point[0]),2) + Math.pow((y2-this.point[1]),2));
    }

    /***
     * Calculates the distance between 2 points given another MyPoint object
     * @param a supplies MyPoint object to function
     * @return returns a double of the length
     */
    public double distance(MyPoint a){
        //sqrt ( (x2-x1)^2 + (y2-y1)^2 )
        System.out.println("Distance is: " + Math.sqrt(Math.pow((a.point[0]-this.point[0]),2) + Math.
        pow((a.point[1]-this.point[1]),2)));
        return Math.sqrt(Math.pow((a.point[0]-this.point[0]),2) + Math.pow((a.point[1]-this.point[1])
        ,2));
    }

    /***
     * Checks to see if list of MyPoints contains a specific MyPoint
     * @param points supplies list of MyPoints to funciton
     * @param p supplies MyPoint object to try and find in list
     * @return returns boolean if we found it or not.
     */
    public static boolean contains(MyPoint[] points, MyPoint p){
        for(int i = 0; i < points.length; i++){
            if(p.getPoint()[0] == points[i].getPoint()[0] && p.getPoint()[1] == points[i].getPoint()[1]){
                System.out.println("Point found. Returning true.");
                return true;
            }
        }
        System.out.println("Point not found. Returning false.");
        return false;
    }

    /***
     * Function checks to see if points make up a line. Base case is slope from 0th and 1st points,
     * then checks to see if its the same slope between 0th and ith points.
     * @param points supplies MyPoint array to the function.
     * @return returns boolean if found or not
     */
    public static boolean horizontal(MyPoint[] points){
        if(points.length <= 1){
            System.out.println("0 or 1 point is not a line, returning false.");
            return false;
        }
        if(points.length <= 2){
            if(points[0].getPoint()[0] == points[1].getPoint()[0] &&    //x,y of both points match
            points[0].getPoint()[1] == points[1].getPoint()[1]){
                System.out.println("2 overlapping points don't make a line, returning false.");
                return false;
            }
            System.out.println("2 unique points always make a line, returning true.");  //points don't match
            return true;

        }
        double num = points[0].getPoint()[1] - points[1].getPoint()[1];     //y2 - y1
        double den = points[0].getPoint()[0] - points[1].getPoint()[0];     //x2 - x1
        if(den != 0.0){                                    //horizontal line + all diagonal lines
            double slope = num / den;   //Base Case Slope
            System.out.println("Slope  p[0] and p[1]: " + slope);
            for (int i = 2; i < points.length; i++){       //start at p[2] since we know p[0] vs p[1] already
                double num2 = points[0].getPoint()[1] - points[i].getPoint()[1];
                double den2 = points[0].getPoint()[0] - points[i].getPoint()[0];
                //System.out.println("Num1: " + num1 + " den1: " + den1);
                if(den2 == 0.0){    //check if ever den is 0 (can't perform div)
                    if(num2 == 0.0) {
                        continue;   //if den && num 0, then point is same as initial, move on.
                    }
                    System.out.println("Points aren't in a line. Failed between p[0] and p[" + i + "]" +
                     " returning false.");
                    return false;
                }
                double slope2 = num2 / den2;    //Inductive Case Slope
                System.out.println("Slope  p[0] and p[" + i + "]: " + slope2);
                if (slope != slope2){
                    System.out.println("Points aren't in a line. Failed between p[0] and p[" + i + "] retu" +
                     "rning false.");
                    return false;
                }
            }
            System.out.println("Points are in a line, returning true.");
            return true;
        }

        //Here, our first denominator is 0.0, we only need to check den to make sure it's strictly a vertical line
        for (int i = 2; i < points.length; i++){
            double den2 = points[0].getPoint()[0] - points[i].getPoint()[0];
            if (den != den2){
                System.out.println("Points aren't in a line, returning false.");
                return false;
            }
        }
        System.out.println("Points are in a vertical line, returning true.");
        return true;

    }

}