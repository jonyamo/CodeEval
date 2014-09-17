package com.codeeval.challenges.TheMajorElement;

import java.io.*;

public class Main
{
    public static void main(String[] args)
    {
        try {
            BufferedReader in = new BufferedReader(
                    new FileReader(new File(args[0])));

            String line;
            while ((line = in.readLine()) != null) {
                System.out.println(getMajorElement(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public static String getMajorElement(String seq)
    {
        int largestNum = 100;
        int[] counts = new int[largestNum+1];
        String[] nums = seq.split(",");
        for (String num : nums)
            counts[Integer.valueOf(num)]++;
        for (int i = 0; i <= largestNum; i++) {
            if (counts[i] > nums.length / 2)
                return Integer.toString(i);
        }
        return "None";
    }
}

