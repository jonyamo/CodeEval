package com.codeeval.challenges;

import java.io.*;
import java.util.*;

public class reverse_words
{
    public static void main(String[] args)
    {
        try {
            BufferedReader in = new BufferedReader(
                    new FileReader(new File(args[0])));

            String line;
            while ((line = in.readLine()) != null) {
                System.out.println(reverseLine(line));
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Usage: " + getMainClass() + " filename");
            System.exit(1);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public static String reverseLine(String line)
    {
        String[] words = line.split("\\b");
        StringBuilder sb = new StringBuilder();

        for (int i = words.length; i --> 0;) {
            sb.append(words[i]);
        }

        return sb.toString();
    }

    public static String getMainClass()
    {
        StackTraceElement[] stack = Thread.currentThread().getStackTrace();
        StackTraceElement main = stack[stack.length - 1];
        return main.getClassName();
    }
}

