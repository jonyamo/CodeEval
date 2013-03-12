package com.codeeval.tests;

import com.codeeval.challenges.nmodm;
import org.testng.Assert;
import org.testng.annotations.*;

public class nmodmTest
{
    @Test
    public void test()
    {
        Assert.assertEquals(nmodm.modulo(5,2),1);
        Assert.assertEquals(nmodm.modulo(9,3),0);
    }
}
