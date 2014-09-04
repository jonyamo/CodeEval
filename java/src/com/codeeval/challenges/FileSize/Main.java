package com.codeeval.challenges.FileSize;

import java.io.File;
import org.testng.Assert;
import org.testng.annotations.*;

public class Main
{
    @Test
    public void testRun()
    {
        String filename = System.getProperty("user.dir")
            + "/../testdata/FileSize.txt";
        String expectedOutput = "4\n";
        Assert.assertEquals(run(filename),expectedOutput);
    }

    public static String run(String filename)
    {
        File file = new File(filename);
        return file.length() + "\n";
    }

    public static void main(String[] args)
    {
        System.out.print(run(args[0]));
    }
}

