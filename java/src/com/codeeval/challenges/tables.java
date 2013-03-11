package com.codeeval.challenges;

public class tables
{
    public static void main(String[] args)
    {
        for (int x = 1; x <= 12; x++) {
            for (int y = 1; y <= 12; y++) {
                System.out.format("%4d", x * y);
            }
            System.out.println();
        }
    }
}

