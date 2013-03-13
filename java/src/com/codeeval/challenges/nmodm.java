package com.codeeval.challenges;

import java.io.*;
import java.util.Scanner;

public class nmodm
{
    public static void main(String[] args)
    {
        try {
            BufferedReader in = new BufferedReader(
                    new FileReader(new File(args[0])));

            String line;
            while ((line = in.readLine()) != null) {
                Scanner scanner = new Scanner(line).useDelimiter(",");

                int n = scanner.nextInt();
                int m = scanner.nextInt();

                System.out.println(modulo(n,m));
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public static int modulo(int n, int m)
    {
        int quotient = n/m;
        return n - m*quotient;
    }
}

