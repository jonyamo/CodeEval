package com.codeeval.challenges;

import java.io.*;
import java.util.*;

public class hex_to_decimal
{
    public static void main(String[] args)
    {
        try {
            BufferedReader in = new BufferedReader(
                    new FileReader(new File(args[0])));

            String line;
            while ((line = in.readLine()) != null) {
                // easy way
                //System.out.println(Integer.valueOf(line, 16));

                // learning way
                System.out.println(hexToDecimal(line));
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Usage: " + getMainClass() + " filename");
            System.exit(1);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public static int hexToDecimal(String hex)
    {
        int decimal = 0;
        int power = 0;

        // There's definitely a better way to do this...
        // This is one of those things I'll look back on with a face palm!
        Hashtable<String,Integer> hexTable = new Hashtable<String,Integer>();
        hexTable.put("0",  0);
        hexTable.put("1",  1);
        hexTable.put("2",  2);
        hexTable.put("3",  3);
        hexTable.put("4",  4);
        hexTable.put("5",  5);
        hexTable.put("6",  6);
        hexTable.put("7",  7);
        hexTable.put("8",  8);
        hexTable.put("9",  9);
        hexTable.put("A", 10);
        hexTable.put("B", 11);
        hexTable.put("C", 12);
        hexTable.put("D", 13);
        hexTable.put("E", 14);
        hexTable.put("F", 15);

        for (int i = hex.length(); i --> 0;) {
            decimal += hexTable.get((hex.charAt(i)+"").toUpperCase())* Math.pow(16,power);
            power++;
        }

        return decimal;
    }

    public static String getMainClass()
    {
        StackTraceElement[] stack = Thread.currentThread().getStackTrace();
        StackTraceElement main = stack[stack.length - 1];
        return main.getClassName();
    }
}

