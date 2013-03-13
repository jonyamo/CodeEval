package com.codeeval.tests;

import com.codeeval.challenges.cycle_detection;
import org.testng.Assert;
import org.testng.annotations.*;

public class cycle_detectionTest
{
    @Test
    public void test()
    {
        Assert.assertEquals(
                cycle_detection.getSequence("2 0 6 3 1 6 3 1 6 3 1"),"6 3 1");
    }
}
