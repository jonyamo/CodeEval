package com.codeeval.challenges.HexToDecimal;

import java.io.*;
import java.util.Hashtable;
import java.util.Scanner;
import org.testng.Assert;
import org.testng.annotations.*;

public class Main
{
    @Test
    public void testRun()
    {
        String filename = System.getProperty("user.dir")
            + "/../testdata/HexToDecimal.txt";
        String expectedOutput = "159\n17\n";
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
                // easy way
                //output += Integer.valueOf(line, 16);

                // learning way
                output += hexToDecimal(line);
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

    public static int hexToDecimal(String hex)
    {
        int decimal = 0;
        int power = 0;

        // There's definitely a better way to do this...
        // This is one of those things I'll look back on with a face palm!
        Hashtable<String,Integer> hexTable = new Hashtable<String,Integer>();
        hexTable.put("0",  0);
        hexTable.put("1",  1);
        hexTable.put("2",  2);
        hexTable.put("3",  3);
        hexTable.put("4",  4);
        hexTable.put("5",  5);
        hexTable.put("6",  6);
        hexTable.put("7",  7);
        hexTable.put("8",  8);
        hexTable.put("9",  9);
        hexTable.put("A", 10);
        hexTable.put("B", 11);
        hexTable.put("C", 12);
        hexTable.put("D", 13);
        hexTable.put("E", 14);
        hexTable.put("F", 15);

        for (int i = hex.length(); i --> 0;) {
            decimal += hexTable.get((hex.charAt(i)+"").toUpperCase())* Math.pow(16,power);
            power++;
        }

        return decimal;
    }
}

