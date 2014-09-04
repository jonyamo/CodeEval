package com.codeeval.challenges.DetectingCycles;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.testng.Assert;
import org.testng.annotations.*;

public class Main
{
    @Test
    public void testRun()
    {
        String filename = System.getProperty("user.dir")
            + "/../testdata/DetectingCycles.txt";
        String expectedOutput = "6 3 1\n";
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
                output += getSequence(line) + "\n";
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

    public static String getSequence(String s)
    {
        Pattern pattern = Pattern.compile("(.+ .+)( \\1)+");
        Matcher matcher = pattern.matcher(s);
        while (matcher.find()) {
            return matcher.group(1);
        }
        return "";
    }
}

