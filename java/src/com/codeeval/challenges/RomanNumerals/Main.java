package com.codeeval.challenges.RomanNumerals;

import java.io.*;
import java.util.Scanner;
import org.testng.Assert;
import org.testng.annotations.*;

// http://stackoverflow.com/a/12968022
class RomanNumeral
{
    private final int num;

    private static int[] numbers = { 1000, 900, 500, 400, 100, 90, 50, 40, 10,
        9, 5, 4, 1 };
    private static String[] letters = { "M", "CM", "D", "CD", "C", "XC", "L",
        "XL", "X", "IX", "V", "IV", "I" };

    public RomanNumeral(int arabic)
    {
        if (arabic < 1)
            throw new NumberFormatException(
                    "Value of RomanNumeral must be positive.");
        if (arabic > 3999)
            throw new NumberFormatException(
                    "Value of RomanNumeral must be 3999 or less.");
        num = arabic;
    }

    public String toString()
    {
        String roman = "";
        int n = num;
        for (int i = 0; i < numbers.length; i++) {
            while (n >= numbers[i]) {
                roman += letters[i];
                n -= numbers[i];
            }
        }
        return roman;
    }
}

public class Main
{
    @Test
    public void testRun()
    {
        String filename = System.getProperty("user.dir")
            + "/../testdata/RomanNumerals.txt";
        String expectedOutput = "CLIX\nCCXCVI\nMMMCMXCII\n";
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
                RomanNumeral n = new RomanNumeral(scanner.nextInt());
                output += n.toString() + "\n";
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

