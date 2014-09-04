package com.codeeval.challenges.SumOfIntegers;

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
            + "/../testdata/SumOfIntegers.txt";
        String expectedOutput = "8\n12\n";
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
                line = line.replaceAll("\\s","");
                Scanner scanner = new Scanner(line).useDelimiter(",");
                while (scanner.hasNextInt()) {
                    list.add(scanner.nextInt());
                }
                output += kadane(list);
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

    // https://en.wikipedia.org/wiki/Maximum_subarray_problem
    public static int kadane(ArrayList<Integer> list)
    {
        int sum = 0, maxSum = 0;

        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i);
            if (sum < 0) {
                sum = 0;
            }
            if (sum > maxSum) {
                maxSum = sum;
            }
        }

        return maxSum;
    }
}

