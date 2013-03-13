package com.codeeval.challenges;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedHashSet;

public class dupes
{
    public static void main(String[] args)
    {
        try {
            BufferedReader in = new BufferedReader(
                    new FileReader(new File(args[0])));

            String line;
            while ((line = in.readLine()) != null) {
                System.out.println(removeDupes(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public static String removeDupes(String s)
    {
        LinkedHashSet<String> unique = new LinkedHashSet<String>(
                Arrays.asList(s.split(",")));

        return unique.toString().replaceAll("\\[", "").replaceAll("\\]", "")
            .replaceAll(" ", "");
    }
}

