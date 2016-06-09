package com.github.temnovdn;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.lang.Math.sqrt;
import static java.lang.Math.pow;

public class RtriangleProviderTest {

    private static final Double PRECISION = 1000D;

    @Test
    public void testIfTriangle() {
        Rtriangle triangle = RtriangleProvider.getRtriangle();
        List<Double> sortedSides = asSortedList(triangle);
        Assert.assertNotEquals(sortedSides.get(0), 0.0);
        Assert.assertTrue( sortedSides.get(0)+sortedSides.get(1) > sortedSides.get(2) );
    }

    @Test
    public void testIfRectangular() {
        Rtriangle triangle = RtriangleProvider.getRtriangle();
        List<Double> sortedSides = asSortedList(triangle);
        Assert.assertEquals(pow(sortedSides.get(0), 2D) + pow(sortedSides.get(1), 2D), pow(sortedSides.get(2), 2D),
                sortedSides.get(0)/PRECISION);
    }

    private List<Double> asSortedList(final Rtriangle triangle) {
        List<Double> sideLengths = new ArrayList<Double>();

        sideLengths.add(sqrt(
                pow(triangle.getApexX1() - triangle.getApexX2(), 2D) +
                pow(triangle.getApexY1() - triangle.getApexY2(), 2D)
                ));

        sideLengths.add( sqrt(
                pow(triangle.getApexX2() - triangle.getApexX3(), 2D) +
                pow(triangle.getApexY2() - triangle.getApexY3(), 2D)
        ));

        sideLengths.add(sqrt(
                pow(triangle.getApexX1() - triangle.getApexX3(), 2D) +
                pow(triangle.getApexY1() - triangle.getApexY3(), 2D)
        ));

        Collections.sort(sideLengths);

        return sideLengths;
    }

}
