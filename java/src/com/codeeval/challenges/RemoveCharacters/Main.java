package com.codeeval.challenges.RemoveCharacters;

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
            + "/../testdata/RemoveCharacters.txt";
        String expectedOutput = "how re you\nhllo worl\n";
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
                output += scrub(scanner.next(),scanner.next());
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

    public static String scrub(String str, String letters)
    {
        String scrubbedStr = "";

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == ' ' || letters.indexOf(c) == -1) {
                scrubbedStr += c;
            }
        }

        return scrubbedStr.trim();
    }
}

