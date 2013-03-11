package com.codeeval.tests;

import com.codeeval.challenges.multiples;
import org.testng.Assert;
import org.testng.annotations.*;

public class multiplesTest
{
    @Test
    public void testSmallestGreaterMultiple()
    {
        Assert.assertEquals(multiples.smallestGreaterMultiple(13,8),16);
        Assert.assertEquals(multiples.smallestGreaterMultiple(17,16),32);
    }
}
