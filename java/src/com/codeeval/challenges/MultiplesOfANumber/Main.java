package com.codeeval.challenges.MultiplesOfANumber;

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
            + "/../testdata/MultiplesOfANumber.txt";
        String expectedOutput = "16\n32\n";
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
                Scanner scanner = new Scanner(line).useDelimiter(",");

                int x = scanner.nextInt();
                int n = scanner.nextInt();

                output += smallestGreaterMultiple(x,n) + "\n";
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

    public static int smallestGreaterMultiple(int x, int n)
    {
        while (n < x) {
            n += n;
        }

        return n;
    }
}

