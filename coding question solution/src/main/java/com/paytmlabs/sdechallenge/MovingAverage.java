package com.paytmlabs.sdechallenge;

import java.util.Queue;

/**
 *
 * This interface allows 3 operations:
 * 1. Providing moving average of the last N elements added
 * 2. Adding the elements
 * 3. Accessing the elements added
 *
 * @Author Ankita Narang
 */
public interface MovingAverage<T> {
    /**
     * Method to return the average of last N digits
     * @return the average of last n digits
     */
    public T calculateMovingAverage();

    /**
     * Method to add element to the data structure
     */
    public void addElement(T element);

    /**
     * Function to access elements present in the data structure
     * @return List containing the elements
     */
    public Queue<T> getElements();
}