package com.codeeval.challenges;

import java.io.*;
import java.util.*;

public class armstrong
{
    public static void main(String[] args)
    {
        try {
            BufferedReader in = new BufferedReader(
                    new FileReader(new File(args[0])));

            String line;
            while ((line = in.readLine()) != null) {
                Scanner scanner = new Scanner(line);

                int n = scanner.nextInt();

                System.out.println(isArmstrong(n)?"True":"False");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Usage: " + getMainClass() + " filename");
            System.exit(1);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public static boolean isArmstrong(int n)
    {
        String digits = Integer.toString(n);
        return n == sumDigitsPower(n,digits.length());
    }

    public static int sumDigitsPower(int n, int power)
    {
        int sum = (int)Math.pow(n%10,power);

        while ((n /= 10) > 0) {
            sum += (int)Math.pow(n%10,power);
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

