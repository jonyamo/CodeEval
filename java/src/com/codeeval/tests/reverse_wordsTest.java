package com.codeeval.tests;

import com.codeeval.challenges.reverse_words;
import org.testng.Assert;
import org.testng.annotations.*;

public class reverse_wordsTest
{
    @Test
    public void testReverseLine()
    {
        Assert.assertEquals(reverse_words.reverseLine("Hello World"),"World Hello");
    }
}
