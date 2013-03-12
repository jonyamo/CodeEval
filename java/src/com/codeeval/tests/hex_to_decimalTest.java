package com.codeeval.tests;

import com.codeeval.challenges.hex_to_decimal;
import org.testng.Assert;
import org.testng.annotations.*;

public class hex_to_decimalTest
{
    @Test
    public void test()
    {
        Assert.assertEquals(hex_to_decimal.hexToDecimal("2AF3"),10995);
    }
}
