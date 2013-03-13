package com.codeeval.tests;

import com.codeeval.challenges.pangrams;
import org.testng.Assert;
import org.testng.annotations.*;

public class pangramsTest
{
    @Test
    public void test()
    {
        Assert.assertEquals(
                pangrams.getMissingLetters(
                    "A slow yellow fox crawls under the proactive dog"),"bjkmqz");
    }
}
