package com.codeeval.challenges.FirstNonRepeatedCharacter;

import java.io.*;
import org.testng.Assert;
import org.testng.annotations.*;

public class Main
{
    @Test
    public void testRun()
    {
        String filename = System.getProperty("user.dir")
            + "/../testdata/FirstNonRepeatedCharacter.txt";
        String expectedOutput = "y\nh\n";
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
                output += getFirstNonRepeatingLetter(line);
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

    public static String getFirstNonRepeatingLetter(String s)
    {
        String letter = "";

        for (int i = 0; i < s.length(); i++) {
            letter = s.charAt(i) + "";
            if (s.indexOf(letter) == s.lastIndexOf(letter)) {
                return letter;
            }
        }

        return letter;
    }
}

