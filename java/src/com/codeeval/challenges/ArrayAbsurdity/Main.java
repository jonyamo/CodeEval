package com.codeeval.challenges.ArrayAbsurdity;

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
        String filename = System.getProperty("user.home")
            + "/hacking/CodeEval/testdata/ArrayAbsurdity.txt";
        String expectedOutput = "0\n4\n";
        Assert.assertEquals(run(filename),expectedOutput);
    }

    public static String run(String filename)
    {
        String output = "";

        try {
            ArrayList<Integer> list = new ArrayList<Integer>();

            BufferedReader in = new BufferedReader(
                    new FileReader(new File(filename)));

            String line;
            while ((line = in.readLine()) != null) {
                if (line.length() == 0) {
                    continue;
                }

                String[] parts = line.split(";");
                Scanner scanner = new Scanner(parts[1]).useDelimiter(",");
                list.clear();
                while (scanner.hasNextInt()) {
                    int i = scanner.nextInt();
                    if (list.indexOf(i) > -1) {
                        output += i + "\n";
                        break;
                    }
                    list.add(i);
                }
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

