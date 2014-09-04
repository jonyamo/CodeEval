package com.codeeval.challenges.ReverseWords;

import java.io.*;
import org.testng.Assert;
import org.testng.annotations.*;

public class Main
{
    @Test
    public void testRun()
    {
        String filename = System.getProperty("user.dir")
            + "/../testdata/ReverseWords.txt";
        String expectedOutput = "World Hello\nCodeEval Hello\n";
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
                output += reverseLine(line) + "\n";
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

    public static String reverseLine(String line)
    {
        String[] words = line.split("\\b");
        StringBuilder sb = new StringBuilder();

        for (int i = words.length; i --> 0;) {
            sb.append(words[i]);
        }

        return sb.toString();
    }
}

