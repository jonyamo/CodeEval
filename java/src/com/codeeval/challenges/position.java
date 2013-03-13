package com.codeeval.challenges;

import java.io.*;
import java.util.Scanner;

public class position
{
    public static void main(String[] args)
    {
        try {
            BufferedReader in = new BufferedReader(
                    new FileReader(new File(args[0])));

            String line;
            while ((line = in.readLine()) != null) {
                Scanner scanner = new Scanner(line).useDelimiter(",");

                int n  = scanner.nextInt();
                int p1 = scanner.nextInt();
                int p2 = scanner.nextInt();

                System.out.println(compareBits(n,p1,p2));
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public static boolean compareBits(int n, int p1, int p2)
    {
        String bin = Integer.toString(n,2);
        return bin.charAt(bin.length()-p1) == bin.charAt(bin.length()-p2);
    }
}

