/**
 * Name: Saul Ouellet
 * Date: Feb 7tu 2022
 * Description: Program creates a MyPoint class to simulate a coordinate on a 2D grid.
 * Implements methods to print, calculate distance, find in an array, and
 * determine if points make a line.
 */

package Lab;

/***
 * Testing grounds for MyPoint class
 */
public class Main {

    /***
     * It's a main, what else is there to say?
     * @param args supplies args to main
     */
    public static void main(String[] args){

        MyPoint p1 = new MyPoint();
        MyPoint p2 = new MyPoint(1.0,5.5);
        MyPoint p3 = new MyPoint(1.0,1.0);
        MyPoint p4 = new MyPoint(2.0,2.0);
        MyPoint p5 = new MyPoint(3.0,3.0);
        MyPoint p6 = new MyPoint(3.0,3.0);
        MyPoint p7 = new MyPoint(3.5,3.5);
        MyPoint p8 = new MyPoint(4.5,4.0);

        MyPoint pA = new MyPoint(0,0);
        MyPoint pB = new MyPoint(0,1);
        MyPoint pC = new MyPoint(0,2);
        MyPoint pD = new MyPoint(1,2);


        MyPoint points[] = {p3,p4,p5};
        MyPoint check[] = {p3,p4,p5,p7,p8};
        MyPoint check2[] = {pA,pB,pC,pD};

        /*
        p1.toString();
        p2.toString();

        p1.setPoint(6.0,8.0);
        p1.toString();

        p1.distance(3.5,3.5);

        p1.distance(p2);
         */

        //MyPoint.contains(points, p6);

        //MyPoint.horizontal(points);

        MyPoint.horizontal(check);

        MyPoint.horizontal(check2);


    }
}



