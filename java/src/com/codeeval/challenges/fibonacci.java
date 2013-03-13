package com.codeeval.challenges;

import java.io.*;
import java.util.Scanner;

public class fibonacci
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

                System.out.println(fib(n));
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public static int fib(int n)
    {
        if (n == 0 || n == 1) {
            return n;
        }

        return fib(n-2) + fib(n-1);
    }
}

