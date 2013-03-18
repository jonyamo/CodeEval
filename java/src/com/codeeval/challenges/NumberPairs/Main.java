package com.codeeval.challenges.NumberPairs;

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
            + "/hacking/CodeEval/testdata/NumberPairs.txt";
        String expectedOutput = "1,4;2,3\n5,15;9,11\nNULL\n";
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
                ArrayList<Integer> list = new ArrayList<Integer>();
                Scanner scanner = new Scanner(line).useDelimiter(";");
                Scanner nums = new Scanner(scanner.next()).useDelimiter(",");
                int sum = scanner.nextInt();

                while (nums.hasNextInt()) {
                    list.add(nums.nextInt());
                }

                output += getNumberPairs(list, sum);
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

    public static String getNumberPairs(ArrayList<Integer> list, int sum)
    {
        String pairs = "";

        for (int i = 0; i < list.size(); i++) {
            for (int j = 1; j < list.size(); j++) {
                if (j <= i) {
                    continue;
                }
                int result = list.get(i) + list.get(j);
                if (result == sum) {
                    pairs += list.get(i)+","+list.get(j)+";";
                }
            }
        }

        if (pairs.length() == 0) {
            pairs = "NULL";
        } else {
            pairs = pairs.replaceAll(";$","");
        }

        return pairs;
    }
}

