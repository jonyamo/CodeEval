package com.codeeval.challenges.TrailingString;

import java.io.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.testng.Assert;
import org.testng.annotations.*;

public class Main
{
    @Test
    public void testRun()
    {
        String filename = System.getProperty("user.home")
            + "/hacking/CodeEval/testdata/TrailingString.txt";
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
                Scanner scanner = new Scanner(line).useDelimiter(",");
                output += isTrailingString(scanner.next(),scanner.next())?"1":"0";
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

    public static boolean isTrailingString(String s1, String s2)
    {
        Pattern pattern = Pattern.compile(".*" + s2 + "$");
        Matcher matcher = pattern.matcher(s1);
        return matcher.find();
    }
}

