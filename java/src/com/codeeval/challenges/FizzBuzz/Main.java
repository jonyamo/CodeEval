package com.codeeval.challenges.FizzBuzz;

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
            + "/../testdata/FizzBuzz.txt";
        String expectedOutput = "1 2 F 4 B F 7 8 F B\n"
            + "1 F 3 F 5 F B F 9 F 11 F 13 FB 15\n";
        Assert.assertEquals(run(filename),expectedOutput);
    }

    public static void main(String[] args)
    {
        System.out.print(run(args[0]));
    }

    public static String run(String filename)
    {
        String output = "";

        try {
            BufferedReader in = new BufferedReader(
                    new FileReader(new File(filename)));

            String line, outputLine;
            while ((line = in.readLine()) != null) {
                outputLine = "";
                Scanner scanner = new Scanner(line);

                int fizz  = scanner.nextInt();
                int buzz  = scanner.nextInt();
                int count = scanner.nextInt();

                for (int i = 1; i <= count; i++) {
                    outputLine += fizzOrBuzz(fizz,buzz,i) + " ";
                }

                output += outputLine.trim() + "\n";
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }

        return output;
    }

    public static String fizzOrBuzz(int fizz, int buzz, int n)
    {
        if (n % fizz == 0 && n % buzz == 0) {
            return "FB";
        }

        if (n % fizz == 0) {
            return "F";
        }

        if (n % buzz == 0) {
            return "B";
        }

        return Integer.toString(n);
    }
}

