package com.codeeval.challenges.HiddenDigits;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.testng.Assert;
import org.testng.annotations.*;

class HiddenDigits
{
    private final String text;

    private static String[] search  = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j" };
    private static String[] replace = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" };

    public HiddenDigits(String str)
    {
        text = str;
    }

    public String toString()
    {
        String hiddenDigits = "";
        Pattern p = Pattern.compile("[a-j]|\\d");
        Matcher m = p.matcher(text);
        while (m.find())
            hiddenDigits += m.group();
        if (hiddenDigits.length() == 0)
            return "NONE";
        for (int i = 0; i < search.length; i++)
            hiddenDigits = hiddenDigits.replaceAll(search[i], replace[i]);
        return hiddenDigits;
    }
}

public class Main
{
    @Test
    public void testRun()
    {
        String filename = System.getProperty("user.dir")
            + "/../testdata/HiddenDigits.txt";
        String expectedOutput = "012345678\n05\nNONE\n6240488\n";
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
                HiddenDigits hd = new HiddenDigits(line);
                output += hd.toString() + "\n";
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

