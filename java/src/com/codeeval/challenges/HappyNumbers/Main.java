package com.codeeval.challenges.HappyNumbers;

import java.io.*;
import java.util.HashSet;
import java.util.Scanner;
import org.testng.Assert;
import org.testng.annotations.*;

public class Main
{
    @Test
    public void testRun()
    {
        String filename = System.getProperty("user.home")
            + "/hacking/CodeEval/testdata/HappyNumbers.txt";
        String expectedOutput = "1\n1\n0\n";
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

                int n = scanner.nextInt();

                output += isHappyNum(n)?"1":"0";
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

    public static boolean isHappyNum(int n)
    {
        HashSet<Integer> sums = new HashSet<Integer>();

        while (true) {
            int sum = 0;
            while (n != 0) {
                sum += (n%10) * (n%10);
                n /= 10;
            }
            if (sum == 1) {
                return true;
            } else if (sums.contains(sum)) {
                return false;
            }
            sums.add(sum);
            n = sum;
        }
    }
}

