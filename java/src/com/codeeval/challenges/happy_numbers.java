package com.codeeval.challenges;

import java.io.*;
import java.util.HashSet;
import java.util.Scanner;

public class happy_numbers
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

                System.out.println(happyNum(n));
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public static int happyNum(int n)
    {
        HashSet<Integer> sums = new HashSet<Integer>();

        while (true) {
            int sum = 0;
            while (n != 0) {
                sum += (n%10) * (n%10);
                n /= 10;
            }
            if (sum == 1) {
                return 1;
            } else if (sums.contains(sum)) {
                return 0;
            }
            sums.add(sum);
            n = sum;
        }
    }
}

