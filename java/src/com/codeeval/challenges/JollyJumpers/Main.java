package com.codeeval.challenges.JollyJumpers;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import org.testng.Assert;
import org.testng.annotations.*;

public class Main
{
    @Test
    public void testRun()
    {
        String filename = System.getProperty("user.dir")
            + "/../testdata/JollyJumpers.txt";
        String expectedOutput = "Jolly\nNot jolly\n";
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
                Scanner scanner = new Scanner(line);
                int[] seq = new int[scanner.nextInt()];
                for (int i = 0; i < seq.length; i++) {
                    seq[i] = scanner.nextInt();
                }
                output += isJollyJumper(seq)?"Jolly":"Not jolly";
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

    public static boolean isJollyJumper(int[] seq)
    {
        if (seq.length == 0) {
            return false;
        }

        if (seq.length == 1) {
            return true;
        }

        ArrayList<Integer> results = new ArrayList<Integer>();

        for (int i = 0; i < seq.length - 1; i++) {
            int diff = Math.abs(seq[i] - seq[i+1]);

            if (diff == 0) {
                return false;
            }

            if (diff >= seq.length) {
                return false;
            }

            if (results.contains(diff)) {
                return false;
            }

            results.add(diff);
        }

        return true;
    }
}

