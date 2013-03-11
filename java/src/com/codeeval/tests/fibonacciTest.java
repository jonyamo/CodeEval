package com.codeeval.tests;

import com.codeeval.challenges.fibonacci;
import org.testng.Assert;
import org.testng.annotations.*;

public class fibonacciTest
{
    @Test
    public void testFib()
    {
        Assert.assertEquals(fibonacci.fib(5),5);
        Assert.assertEquals(fibonacci.fib(12),144);
    }
}
