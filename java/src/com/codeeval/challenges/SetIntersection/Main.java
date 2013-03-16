package com.codeeval.challenges.SetIntersection;

import java.io.*;
import java.util.TreeSet;
import org.testng.Assert;
import org.testng.annotations.*;

public class Main
{
    @Test
    public void testRun()
    {
        String filename = System.getProperty("user.home")
            + "/hacking/CodeEval/testdata/SetIntersection.txt";
        String expectedOutput = "4\n8,9\n";
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
                output += getIntersection(line) + "\n";
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

    public static String getIntersection(String s)
    {
        TreeSet<String> intersection = new TreeSet<String>();

        String[] lists = s.split(";");
        String[] nums1 = lists[0].split(",");
        String[] nums2 = lists[1].split(",");

        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i].equals(nums2[j])) {
                    intersection.add(nums1[i]);
                }
            }
        }

        return intersection.toString().replaceAll("\\[", "")
            .replaceAll("\\]", "").replaceAll(" ", "");
    }
}

