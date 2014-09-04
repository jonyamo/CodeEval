package com.codeeval.challenges.BitPositions;

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
            + "/../testdata/BitPositions.txt";
        String expectedOutput = "true\nfalse\n";
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

                int n  = scanner.nextInt();
                int p1 = scanner.nextInt();
                int p2 = scanner.nextInt();

                output += compareBits(n,p1,p2) + "\n";
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

    public static boolean compareBits(int n, int p1, int p2)
    {
        String bin = Integer.toString(n,2);
        return bin.charAt(bin.length()-p1) == bin.charAt(bin.length()-p2);
    }
}

