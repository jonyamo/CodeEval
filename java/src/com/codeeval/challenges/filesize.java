package com.codeeval.challenges;

import java.io.File;

public class filesize
{
    public static void main(String[] args)
    {
        try {
            File file = new File(args[0]);
            System.out.println(file.length());
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Usage: " + getMainClass() + " filename");
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

