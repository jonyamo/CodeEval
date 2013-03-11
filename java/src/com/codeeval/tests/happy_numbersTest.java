package com.codeeval.tests;

import com.codeeval.challenges.happy_numbers;
import org.testng.Assert;
import org.testng.annotations.*;

public class happy_numbersTest
{
    @Test
    public void testHappyNum()
    {
        Assert.assertEquals(happy_numbers.happyNum(7),1);
        Assert.assertEquals(happy_numbers.happyNum(22),0);
    }
}
