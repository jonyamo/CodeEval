package com.codeeval.challenges.MultiplyLists;

import java.io.*;
import org.testng.Assert;
import org.testng.annotations.*;

public class Main
{
    @Test
    public void testRun()
    {
        String filename = System.getProperty("user.dir")
            + "/../testdata/MultiplyLists.txt";
        String expectedOutput = "135 0 54\n40\n13 16 225 14 120 10\n";
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
                String[] lists = line.split("\\|");
                String[] strArr0 = lists[0].trim().split(" ");
                String[] strArr1 = lists[1].trim().split(" ");
                int[] intArr0 = new int[strArr0.length];
                for (int i = 0; i < strArr0.length; i++) {
                    intArr0[i] = Integer.parseInt(strArr0[i]);
                }
                int[] intArr1 = new int[strArr1.length];
                for (int i = 0; i < strArr1.length; i++) {
                    intArr1[i] = Integer.parseInt(strArr1[i]);
                }
                int[] intArr3 = multiplyLists(intArr0, intArr1);
                StringBuilder sb = new StringBuilder();
                for (int n : intArr3) {
                    sb.append(n);
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

    public static int[] multiplyLists(int[] list1, int[] list2)
    {
        int[] list3 = new int[list1.length];
        for (int i = 0; i < list1.length; i++) {
            list3[i] = list1[i] * list2[i];
        }
        return list3;
    }
}

