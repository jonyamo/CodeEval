package com.codeeval.challenges.NumberOfOnes;

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
            + "/../testdata/NumberOfOnes.txt";
        String expectedOutput = "2\n3\n3\n";
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
                output += numberOfOnes(scanner.nextInt());
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

    public static int numberOfOnes(int n)
    {
        int count = 0;
        String bin = Integer.toString(n,2);

        for (int i = bin.length(); i --> 0;) {
            if (bin.charAt(i) == '1') {
                count++;
            }
        }

        return count;
    }
}

