package com.codeeval.tests;

import com.codeeval.challenges.position;
import org.testng.Assert;
import org.testng.annotations.*;

public class positionTest
{
    @Test
    public void testCompareBits()
    {
        Assert.assertEquals(position.compareBits(86,2,3),true);
        Assert.assertEquals(position.compareBits(125,1,2),false);
    }
}
