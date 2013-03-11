package com.codeeval.challenges;

import java.io.*;
import java.util.*;

public class sumint
{
    public static void main(String[] args)
    {
        try {
            Scanner scanner = new Scanner(new File(args[0]));

            int sum = 0;
            while (scanner.hasNextInt()) {
                sum += scanner.nextInt();
            }

            System.out.println(sum);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Usage: " + getMainClass() + " filename");
            System.exit(1);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public static String getMainClass()
    {
        StackTraceElement[] stack = Thread.currentThread().getStackTrace();
        StackTraceElement main = stack[stack.length - 1];
        return main.getClassName();
    }
}

