package com.codeeval.tests;

import com.codeeval.challenges.dupes;
import org.testng.Assert;
import org.testng.annotations.*;

public class dupesTest
{
    @Test
    public void testRemoveDupes()
    {
        Assert.assertEquals(dupes.removeDupes("1,1,1,2,2,3,3,4,4"),"1,2,3,4");
    }
}
