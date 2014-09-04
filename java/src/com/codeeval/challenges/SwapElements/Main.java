package com.codeeval.challenges.SwapElements;

import java.io.*;
import org.testng.Assert;
import org.testng.annotations.*;

public class Main
{
    @Test
    public void testRun()
    {
        String filename = System.getProperty("user.dir")
            + "/../testdata/SwapElements.txt";
        String expectedOutput = "9 2 3 4 5 6 7 8 1\n2 4 3 1 5 6 7 8 9 10\n";
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
                String[] parts = line.split(":");
                String[] elements = parts[0].split(" ");
                String[] swaps = parts[1].split(",");
                String[] swappedElements = swapElements(elements, swaps);
                StringBuilder sb = new StringBuilder();
                for (String element : swappedElements) {
                    sb.append(element);
                    sb.append(" ");
                }
                output += sb.toString().trim() + "\n";
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

    public static String[] swapElements(String[] elements, String[] swaps)
    {
        for (String swap : swaps) {
            String[] pos = swap.split("-");
            int pos_a = Integer.parseInt(pos[0].trim());
            int pos_b = Integer.parseInt(pos[1].trim());
            String val_a = elements[pos_a];
            String val_b = elements[pos_b];
            elements[pos_a] = val_b;
            elements[pos_b] = val_a;
        }
        return elements;
    }
}

