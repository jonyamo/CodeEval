package com.codeeval.challenges.DoubleSquares;

import java.io.*;
import java.util.Scanner;
import org.testng.Assert;
import org.testng.annotations.*;

public class Main
{
    @Test
    public void testRun()
    {
        String filename = System.getProperty("user.home")
            + "/hacking/CodeEval/testdata/DoubleSquares.txt";
        String expectedOutput = "1\n2\n0\n1\n1\n";
        Assert.assertEquals(run(filename),expectedOutput);
    }

    public static String run(String filename)
    {
        String output = "";

        try {
            BufferedReader in = new BufferedReader(
                    new FileReader(new File(filename)));

            int testCases = 0;
            String line;
            while ((line = in.readLine()) != null) {
                Scanner scanner = new Scanner(line);

                if (testCases == 0) {
                    testCases = scanner.nextInt();
                    continue;
                }

                output += getDoubleSquareCounts(scanner.nextInt());
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

    public static int getDoubleSquareCounts(int n)
    {
        int max = (int)Math.sqrt(n);
        int j = 0, cnt = 0;


        for (int i = max + 1; i --> 0;) {
            while (j <= max) {
                if (j > i) {
                    break;
                }

                int result = i*i + j*j;

                if (result > n) {
                    break;
                }

                if (result == n) {
                    cnt++;
                }

                j++;
            }
        }

        return cnt;
    }
}

