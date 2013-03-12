package com.codeeval.tests;

import com.codeeval.challenges.self_describing_numbers;
import org.testng.Assert;
import org.testng.annotations.*;

public class self_describing_numbersTest
{
    @Test
    public void testIsSelfDescribing()
    {
        Assert.assertEquals(self_describing_numbers.isSelfDescribing(2020),true);
    }

    @Test
    public void testCountCharacter()
    {
        Assert.assertEquals(self_describing_numbers.countCharacter("3211000","0"),3);
    }
}
