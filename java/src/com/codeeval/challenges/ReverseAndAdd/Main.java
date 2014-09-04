package com.codeeval.challenges.ReverseAndAdd;

import java.io.*;
import java.util.Scanner;
import org.testng.Assert;
import org.testng.annotations.*;

class ReverseAndAdd
{
    private int iterations = 0;
    private int palindrome;

    public ReverseAndAdd(int n)
    {
        iterate(n);
    }

    public int getIterations()
    {
        return iterations;
    }

    public int getPalindrome()
    {
        return palindrome;
    }

    private void iterate(int n)
    {
        if (iterations > 1000) {
            iterations = -1;
        } else if (isPalindrome(n)) {
            palindrome = n;
        } else {
            iterations++;
            iterate(n + reverse(n));
        }
    }

    private int reverse(int n)
    {
        int nReversed = 0;

        while (n > 0) {
            nReversed = nReversed*10 + n%10;
            n = n/10;
        }

        return nReversed;
    }

    private boolean isPalindrome(int n)
    {
        return n == reverse(n);
    }
}

public class Main
{
    @Test
    public void testRun()
    {
        String filename = System.getProperty("user.dir")
            + "/../testdata/ReverseAndAdd.txt";
        String expectedOutput = "4 9339\n";
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
                ReverseAndAdd raa = new ReverseAndAdd(scanner.nextInt());
                output += raa.getIterations() + " " + raa.getPalindrome();
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
}

