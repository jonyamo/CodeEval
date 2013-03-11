package com.codeeval.challenges;

import java.io.*;
import java.util.*;

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
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Usage: " + getMainClass() + " filename");
            System.exit(1);
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

    public static String getMainClass()
    {
        StackTraceElement[] stack = Thread.currentThread().getStackTrace();
        StackTraceElement main = stack[stack.length - 1];
        return main.getClassName();
    }
}

