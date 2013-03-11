package com.codeeval.tests;

import com.codeeval.challenges.fizzbuzz;
import org.testng.Assert;
import org.testng.annotations.*;

public class fizzbuzzTest
{
    @Test
    public void testFizzbuzzer()
    {
        Assert.assertEquals(fizzbuzz.fizzbuzzer(3,5,9),"F");
        Assert.assertEquals(fizzbuzz.fizzbuzzer(2,7,7),"B");
        Assert.assertEquals(fizzbuzz.fizzbuzzer(3,5,15),"FB");
        Assert.assertEquals(fizzbuzz.fizzbuzzer(2,7,15),"15");
    }
}
