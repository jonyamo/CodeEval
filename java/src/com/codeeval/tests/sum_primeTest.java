package com.codeeval.tests;

import com.codeeval.challenges.sum_prime;
import org.testng.Assert;
import org.testng.annotations.*;

public class sum_primeTest
{
    @Test
    public void testSumPrimes()
    {
        Assert.assertEquals(sum_prime.sumPrimes(100),24133);
    }
}
