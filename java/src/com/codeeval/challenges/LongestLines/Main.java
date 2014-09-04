package com.codeeval.challenges.LongestLines;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import org.testng.Assert;
import org.testng.annotations.*;

class LongestLines implements Comparator<String>
{
    public int compare(String x, String y)
    {
        if (x == null) {
            return y == null ? 0 : -1;
        } else if (y == null) {
            return +1;
        } else {
            int lenX = x.length();
            int lenY = y.length();

            if (lenX == lenY) {
                return x.compareTo(y);
            } else {
                return lenX < lenY ? -1 : +1;
            }
        }
    }
}

public class Main
{
    @Test
    public void testRun()
    {
        String filename = System.getProperty("user.dir")
            + "/../testdata/LongestLines.txt";
        String expectedOutput = "Bob Maloogaloogaloogaloogalooga\nSan Francisco\n";
        Assert.assertEquals(run(filename),expectedOutput);
    }

    public static String run(String filename)
    {
        String output = "";

        try {
            BufferedReader in = new BufferedReader(
                    new FileReader(new File(filename)));

            int numLines = 0;
            ArrayList<String> lines = new ArrayList<String>();

            String line;
            while ((line = in.readLine()) != null) {
                Scanner scanner = new Scanner(line);

                if (scanner.hasNext()) {
                    if (scanner.hasNextInt()) {
                        numLines = scanner.nextInt();
                        continue;
                    }
                    lines.add(line.trim());
                }
            }

            output = getLongestLines(numLines, lines);
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

    public static String getLongestLines(int n, ArrayList<String> lines)
    {
        String longLines = "";

        Collections.sort(lines, new LongestLines());
        for (int i = lines.size(); i --> lines.size() - n;) {
            longLines += lines.get(i) + "\n";
        }

        return longLines;
    }
}

