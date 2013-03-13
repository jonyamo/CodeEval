package com.codeeval.challenges;

import java.io.*;
import java.util.Scanner;

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
}

