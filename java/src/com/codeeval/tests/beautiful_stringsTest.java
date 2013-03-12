package com.codeeval.tests;

import com.codeeval.challenges.beautiful_strings;
import org.testng.Assert;
import org.testng.annotations.*;

public class beautiful_stringsTest
{
    @Test
    public void test()
    {
        Assert.assertEquals(beautiful_strings.getBeauty("ABBCCC"),152);
    }
}
