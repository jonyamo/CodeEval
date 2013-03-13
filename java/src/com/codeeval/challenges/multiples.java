package com.codeeval.challenges;

import java.io.*;
import java.util.Scanner;

public class multiples
{
    public static void main(String[] args)
    {
        try {
            BufferedReader in = new BufferedReader(
                    new FileReader(new File(args[0])));

            String line;
            while ((line = in.readLine()) != null) {
                Scanner scanner = new Scanner(line).useDelimiter(",");

                int x = scanner.nextInt();
                int n = scanner.nextInt();

                System.out.println(smallestGreaterMultiple(x,n));
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public static int smallestGreaterMultiple(int x, int n)
    {
        while (n < x) {
            n += n;
        }

        return n;
    }
}

