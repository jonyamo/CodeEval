package com.codeeval.challenges.DecimalToBinary;

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
            + "/../testdata/DecimalToBinary.txt";
        String expectedOutput = "10\n1010\n1000011\n";
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
                Scanner scanner = new Scanner(line);
                // easy way
                //output += Integer.toString(scanner.nextInt(), 2);

                // learning way
                output += decimalToBinary(scanner.nextInt());

                output += "\n";
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

    public static String decimalToBinary(int n)
    {
        String bin = "";

        while (n > 0) {
            bin = n%2 + bin;
            n /= 2;
        }

        return bin;
    }
}

