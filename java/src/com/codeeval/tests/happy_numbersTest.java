package com.codeeval.tests;

import com.codeeval.challenges.happy_numbers;
import org.testng.Assert;
import org.testng.annotations.*;

public class happy_numbersTest
{
    @Test
    public void testHappyNum()
    {
        Assert.assertEquals(happy_numbers.isHappyNum(7),true);
        Assert.assertEquals(happy_numbers.isHappyNum(22),false);
    }
}
