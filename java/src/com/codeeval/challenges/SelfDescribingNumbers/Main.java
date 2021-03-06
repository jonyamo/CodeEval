package com.codeeval.challenges.SelfDescribingNumbers;

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
            + "/../testdata/SelfDescribingNumbers.txt";
        String expectedOutput = "1\n0\n1\n";
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

                output += isSelfDescribing(n)?"1":"0";
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

    public static boolean isSelfDescribing(int n) {
        String digits = Integer.toString(n);
        int len = digits.length();

        for (int i = 0; i < len; i++) {
            int digit = Integer.parseInt(digits.charAt(i) + "");

            if (digit >= len || digit != countCharacter(digits,Integer.toString(i))) {
                return false;
            }
        }

        return true;
    }

    public static int countCharacter(String word, String ch)
    {
        int pos = word.indexOf(ch);
        return pos == -1 ? 0 : 1 + countCharacter(word.substring(pos+1),ch);
    }
}

