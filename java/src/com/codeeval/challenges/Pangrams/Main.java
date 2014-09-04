package com.codeeval.challenges.Pangrams;

import java.io.*;
import org.testng.Assert;
import org.testng.annotations.*;

public class Main
{
    @Test
    public void testRun()
    {
        String filename = System.getProperty("user.dir")
            + "/../testdata/Pangrams.txt";
        String expectedOutput = "NULL\nbjkmqz\n";
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
                if (line.trim().length() == 0) {
                    continue;
                }

                String letters = getMissingLetters(line.toLowerCase());

                if (letters.length() == 0) {
                    output += "NULL";
                } else {
                    output += letters;
                }

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

    public static String getMissingLetters(String s)
    {
        String missingLetters = "";

        for (char c = 'a'; c <= 'z'; c++) {
            if (s.indexOf(c) == -1) {
                missingLetters += c;
            }
        }

        return missingLetters;
    }
}

