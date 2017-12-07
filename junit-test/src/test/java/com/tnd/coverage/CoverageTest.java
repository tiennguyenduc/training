package com.tnd.coverage;

import org.junit.Assert;
import org.junit.Test;

public class CoverageTest {

    private static int[] visitedLines = new int[14];

    public static int absSumModified(Integer op1, Integer op2) {
        visitedLines[0] = 1;
        if (op1 == null) {
            visitedLines[1] = 1;
            if (op2 == null) {
                visitedLines[2] = 1;
                return 0;
            } else {
                visitedLines[3] = 1;
            }
        } else {
            visitedLines[4] = 1;
        }
        visitedLines[5] = 1;
        if (op1 == null) {
            visitedLines[6] = 1;
            if (op2 != null) {
                visitedLines[7] = 1;
                return Math.abs(op2);
            } else {
                visitedLines[8] = 1;
            }
        } else {
            visitedLines[9] = 1;
        }
        visitedLines[10] = 1;
        if (op2 == null) {
            visitedLines[11] = 1;
            return Math.abs(op1);
        } else {
            visitedLines[12] = 1;
        }
        visitedLines[13] = 1;
        return Math.abs(op1) + Math.abs(op2);
    }

    public static void main(String[] args) {

        Integer op1 = null;
        Integer op2 = null;

        absSumModified(op1, op2);

        for (int i=0; i<visitedLines.length; i++) {
            System.out.println(i + " -- " + visitedLines[i]);
        }
    }

    @Test
    public void absSumModifiedTest() {

        Assert.assertEquals(0, absSumModified(null, null));

        Assert.assertEquals(1, absSumModified(1, null));

        Assert.assertEquals(2, absSumModified(null, 2));

        Assert.assertEquals(3, absSumModified(1, 2));

    }

}
