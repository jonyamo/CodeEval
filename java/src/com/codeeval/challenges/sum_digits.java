package com.codeeval.challenges;

import java.io.*;
import java.util.*;

public class sum_digits
{
    public static void main(String[] args)
    {
        try {
            BufferedReader in = new BufferedReader(
                    new FileReader(new File(args[0])));

            String line;
            while ((line = in.readLine()) != null) {
                int n = Integer.parseInt(line);
                System.out.println(sumDigits(n));
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Usage: " + getMainClass() + " filename");
            System.exit(1);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public static int sumDigits(int n)
    {
        int sum = n % 10;

        while ((n /= 10) > 0) {
            sum += n % 10;
        }

        return sum;
    }

    public static String getMainClass()
    {
        StackTraceElement[] stack = Thread.currentThread().getStackTrace();
        StackTraceElement main = stack[stack.length - 1];
        return main.getClassName();
    }
}

