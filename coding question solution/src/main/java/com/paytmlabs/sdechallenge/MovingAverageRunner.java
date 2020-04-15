package com.paytmlabs.sdechallenge;
/**
 * This is the runner class which uses the implementation class to add elements,
 * calculate moving average and access elements added. The elements added are of
 * Double type
 *
 * @author Ankita Narang
 */
public class MovingAverageRunner {
    public static void main(String[] args) {
        int window = 3; //This is the 'N' elements as per question
        MovingAverageImpl movingAverageImpl = new MovingAverageImpl(window);

        //Adding the elements
        movingAverageImpl.addElement(1d);
        movingAverageImpl.addElement(2d);
        movingAverageImpl.addElement(3d);
        //calculating and printing average
        System.out.println("Average is: "+ movingAverageImpl.calculateMovingAverage());
        //Get the queue contents
        System.out.println(movingAverageImpl.getElements());

        //Adding more elements
        movingAverageImpl.addElement(4d);
        movingAverageImpl.addElement(5d);
        //calculating and printing average
        System.out.println("Average is: "+ movingAverageImpl.calculateMovingAverage());
        //Get the queue contents
        System.out.println(movingAverageImpl.getElements());

        //Adding even more elements
        movingAverageImpl.addElement(6d);
        movingAverageImpl.addElement(7d);
        movingAverageImpl.addElement(8d);
        //calculating and printing average
        System.out.println("Average is: "+ movingAverageImpl.calculateMovingAverage());
        //Get the queue contents
        System.out.println(movingAverageImpl.getElements());
    }
}

