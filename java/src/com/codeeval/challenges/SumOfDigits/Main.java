package com.codeeval.challenges.SumOfDigits;

import java.io.*;
import org.testng.Assert;
import org.testng.annotations.*;

public class Main
{
    @Test
    public void testRun()
    {
        String filename = System.getProperty("user.home")
            + "/hacking/CodeEval/testdata/SumOfDigits.txt";
        String expectedOutput = "5\n19\n";
        Assert.assertEquals(run(filename),expectedOutput);
    }

    public static String run(String filename)
    {
        String output = "";

        try {
            BufferedReader in = new BufferedReader(
                    new FileReader(new File(filename)));

            String line;
            while ((line = in.readLine()) != null) {
                int n = Integer.parseInt(line);
                output += sumDigits(n) + "\n";
            }
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

    public static int sumDigits(int n)
    {
        int sum = n % 10;

        while ((n /= 10) > 0) {
            sum += n % 10;
        }

        return sum;
    }
}

