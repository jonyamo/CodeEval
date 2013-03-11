package com.codeeval.tests;

import com.codeeval.challenges.intersection;
import org.testng.Assert;
import org.testng.annotations.*;

public class intersectionTest
{
    @Test
    public void testGetIntersection()
    {
        Assert.assertEquals(
                intersection.getIntersection("7,8,9;8,9,10,11,12"),"8,9");
    }
}
