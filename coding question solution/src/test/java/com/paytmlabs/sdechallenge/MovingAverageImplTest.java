package com.paytmlabs.sdechallenge;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MovingAverageImplTest {

    private MovingAverageImpl movingAverageImpl;

    @Before
    public void setUp() throws Exception {
        movingAverageImpl = new MovingAverageImpl(3);
    }

    // Test to check the count of elements added and being retrieved are same
    @Test
    public void addElementOneTest() {
        movingAverageImpl.addElement(1d);
        assertEquals(1, movingAverageImpl.getElements().size());
    }

    // Test to check the count of elements added and being retrieved are same
    @Test(expected = Exception.class)
    public void addElementNullTest() {
        movingAverageImpl.addElement(null);
    }

    // Test to check the moving average is correct if the count of elements added is
    // same as value of 'windowSize'
    @Test
    public void calculateAverageListCountEqualsNTest() {
        movingAverageImpl.addElement(1d);
        movingAverageImpl.addElement(2d);
        movingAverageImpl.addElement(3d);
        assertEquals(2.0, (double) movingAverageImpl.calculateMovingAverage());
    }

    // Test to check the moving average is correct if the count of elements added is
    // more than the value of 'windowSize'
    @Test
    public void calculateAverageListCountMoreThanNTest() {
        movingAverageImpl.addElement(1d);
        movingAverageImpl.addElement(2d);
        movingAverageImpl.addElement(3d);
        movingAverageImpl.addElement(4d);
        assertEquals(3.0, (double) movingAverageImpl.calculateMovingAverage());
    }

    // Test to check the moving average is correct if the count of elements added is
    // less than the value of 'windowSize'
    @Test
    public void calculateAverageListCountLessThanNTest() {
        movingAverageImpl.addElement(1d);
        movingAverageImpl.addElement(2d);
        assertEquals(null, movingAverageImpl.calculateMovingAverage());
    }

    // Test to check the moving average is null if no element has been added
    @Test
    public void calculateAverageListCountEqualToNullTest() {
        assertEquals(null, movingAverageImpl.calculateMovingAverage());
    }
}