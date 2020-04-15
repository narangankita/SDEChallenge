package com.paytmlabs.sdechallenge;
/**
 * This class provides the implementation for MovingAverage interface.
 * In this implementation, the values added to the data structure are considered to be of Double type.
 *
 * @author Ankita Narang
 */

import java.util.LinkedList;
import java.util.Queue;

public class MovingAverageImpl<T> implements MovingAverage<Double> {
    // Variable denotes the number of elements from the end for which the average needs to be calculated
    private int windowSize;
    // A queue to store all the numbers added and for accessing
    private Queue<Double> numberList;

    //variable sum will store the sum of last N digits,i.e. windowSize
    private Double sum;

    public MovingAverageImpl(int windowSize) {
        this.windowSize = windowSize;
        this.numberList = new LinkedList<Double>();
        this.sum = 0d;
    }

    /**
     * Calculates the moving average of last N digits,i.e. windowSize
     *
     * @return the average of last N digits, i.e. windowSize
     */
    public Double calculateMovingAverage() {
        /*
        * If windowSize > 0 and the list contains elements more than or equal to windowSize, then
        * calculate the average of last N digits,i.e. windowSize or otherwise return null
        */
        if (windowSize > 0 && (numberList.size() > windowSize || numberList.size() == windowSize)) {
        //Calculate and return average
            return sum / windowSize;
        } else if (numberList.size() < windowSize) {
            System.out.println("The size of the list is " + numberList.size() + " which is less than the value of N " + windowSize +
                    ", so cannot find the average of last " + windowSize + " numbers");
        }
        //else return null
        return null;
    }

    /**
     * Method to add element to the data structure
     */
    public void addElement(Double number) {

        if (number == null) {
            throw new IllegalArgumentException("Invalid Argument");
        } else {
        //Add number if it is not null
            numberList.offer(number);
            if (windowSize > 0) {
        //Add the number to the sum
                sum += number;
        /*
        * If size of the list is greater than windowSize, the first element in the window of windowSize N
        * is subtracted so that the sum now holds the sum of last N digits, i.e. windowSize. In this
        * way, it will behave like a moving window.
        */
                if (numberList.size() > windowSize) {
                    sum = sum - numberList.poll();
                }
            }
        }
    }

    /**
     * Function to access elements present in the data structure
     * @return List containing the elements
     */
    public Queue<Double> getElements() {
        return numberList;
    }
}