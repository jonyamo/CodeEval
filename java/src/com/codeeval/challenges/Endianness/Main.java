package com.codeeval.challenges.Endianness;

import org.testng.Assert;
import org.testng.annotations.*;

public class Main
{
    @Test
    public void testRun()
    {
        String expectedOutput = "LittleEndian";
        Assert.assertEquals(run(),expectedOutput);
    }

    public static String run()
    {
        String output = "";
        if (java.nio.ByteOrder.nativeOrder().toString() == "LITTLE_ENDIAN") {
            output = "LittleEndian";
        } else {
            output = "BigEndian";
        }
        return output;
    }

    public static void main(String[] args)
    {
        System.out.println(run());
    }
}

