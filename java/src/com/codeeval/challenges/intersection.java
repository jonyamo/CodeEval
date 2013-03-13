package com.codeeval.challenges;

import java.io.*;
import java.util.TreeSet;

public class intersection
{
    public static void main(String[] args)
    {
        try {
            BufferedReader in = new BufferedReader(
                    new FileReader(new File(args[0])));

            String line;
            while ((line = in.readLine()) != null) {
                System.out.println(getIntersection(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
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

