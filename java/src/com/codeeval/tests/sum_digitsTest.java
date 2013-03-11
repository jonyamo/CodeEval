package com.codeeval.tests;

import com.codeeval.challenges.sum_digits;
import org.testng.Assert;
import org.testng.annotations.*;

public class sum_digitsTest
{
    @Test
    public void testSumDigits()
    {
        Assert.assertEquals(sum_digits.sumDigits(23),5);
        Assert.assertEquals(sum_digits.sumDigits(496),19);
    }
}
