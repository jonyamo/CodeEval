package com.codeeval.challenges;

import java.io.*;
import java.util.Scanner;

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
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}

