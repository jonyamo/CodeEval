package com.codeeval.challenges.UniqueElements;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedHashSet;
import org.testng.Assert;
import org.testng.annotations.*;

public class Main
{
    @Test
    public void testRun()
    {
        String filename = System.getProperty("user.dir")
            + "/../testdata/UniqueElements.txt";
        String expectedOutput = "1,2,3,4\n2,3,4,5\n";
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
                output += removeDupes(line) + "\n";
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

    public static String removeDupes(String s)
    {
        LinkedHashSet<String> unique = new LinkedHashSet<String>(
                Arrays.asList(s.split(",")));

        return unique.toString().replaceAll("\\[", "").replaceAll("\\]", "")
            .replaceAll(" ", "");
    }
}

