package com.codeeval.challenges.MixedContent;

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
            + "/../testdata/MixedContent.txt";
        String expectedOutput = "melon,apricot,peach,pineapple"
            + "|8,33,21,0,16,50,37,0,7,17,21\n24,13,14,43,41\n";
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
                ArrayList<String> digits = new ArrayList<String>();
                ArrayList<String> words  = new ArrayList<String>();
                Scanner scanner = new Scanner(line).useDelimiter(",");
                while (scanner.hasNext()) {
                    if (scanner.hasNextInt()) {
                        digits.add(scanner.next());
                    } else {
                        words.add(scanner.next());
                    }
                }
                StringBuilder sb = new StringBuilder();
                if (words.size() > 0) {
                    for (int i = 0; i < words.size(); i++) {
                        if (i > 0)
                            sb.append(",");
                        sb.append(words.get(i));
                    }
                    if (digits.size() > 0)
                        sb.append("|");
                }
                if (digits.size() > 0) {
                    for (int i = 0; i < digits.size(); i++) {
                        if (i > 0)
                            sb.append(",");
                        sb.append(digits.get(i));
                    }
                }
                output += sb.toString() + "\n";
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

