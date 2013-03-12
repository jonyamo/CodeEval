package com.codeeval.tests;

import com.codeeval.challenges.armstrong;
import org.testng.Assert;
import org.testng.annotations.*;

public class armstrongTest
{
    @Test
    public void test()
    {
        Assert.assertEquals(armstrong.isArmstrong(153),true);
        Assert.assertEquals(armstrong.isArmstrong(351),false);
    }
}
