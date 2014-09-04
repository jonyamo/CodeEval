package com.codeeval.challenges.SumOfIntegersFromFile;

import java.io.*;
import java.util.Scanner;
import org.testng.Assert;
import org.testng.annotations.*;

public class Main
{
    @Test
    public void testRun()
    {
        String filename = System.getProperty("user.dir")
            + "/../testdata/SumOfIntegersFromFile.txt";
        String expectedOutput = "17\n";
        Assert.assertEquals(run(filename),expectedOutput);
    }

    public static String run(String filename)
    {
        String output = "";

        try {
            Scanner scanner = new Scanner(new File(filename));

            int sum = 0;
            while (scanner.hasNextInt()) {
                sum += scanner.nextInt();
            }

            output += sum + "\n";
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }

        return output;
    }

    public static void main(String[] args)
    {
        System.out.print(run(args[0]));
    }
}

