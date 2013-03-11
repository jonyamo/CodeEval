package com.codeeval.challenges;

import java.io.*;
import java.util.*;

public class fizzbuzz
{
    public static void main(String[] args)
    {
        try {
            BufferedReader in = new BufferedReader(
                    new FileReader(new File(args[0])));

            String line;
            while ((line = in.readLine()) != null) {
                Scanner scanner = new Scanner(line);

                int fizz  = scanner.nextInt();
                int buzz  = scanner.nextInt();
                int count = scanner.nextInt();

                for (int i = 1; i <= count; i++) {
                    System.out.print(fizzbuzzer(fizz,buzz,i));
                    if (i != count) {
                        System.out.print(" ");
                    }
                }
                System.out.println();
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Usage: " + getMainClass() + " filename");
            System.exit(1);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public static String fizzbuzzer(int fizz, int buzz, int n)
    {
        if (n % fizz == 0 && n % buzz == 0) {
            return "FB";
        }

        if (n % fizz == 0) {
            return "F";
        }

        if (n % buzz == 0) {
            return "B";
        }

        return Integer.toString(n);
    }

    public static String getMainClass()
    {
        StackTraceElement[] stack = Thread.currentThread().getStackTrace();
        StackTraceElement main = stack[stack.length - 1];
        return main.getClassName();
    }
}

