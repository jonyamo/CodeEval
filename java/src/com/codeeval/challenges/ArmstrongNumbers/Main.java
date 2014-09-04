package com.codeeval.challenges.ArmstrongNumbers;

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
            + "/../testdata/ArmstrongNumbers.txt";
        String expectedOutput = "True\nTrue\nFalse\n";
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

                output += isArmstrong(n)?"True":"False";
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

    public static boolean isArmstrong(int n)
    {
        String digits = Integer.toString(n);
        return n == sumDigitsPower(n,digits.length());
    }

    public static int sumDigitsPower(int n, int power)
    {
        int sum = (int)Math.pow(n%10,power);

        while ((n /= 10) > 0) {
            sum += (int)Math.pow(n%10,power);
        }

        return sum;
    }
}

