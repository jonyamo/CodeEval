package com.codeeval.challenges;

import java.io.*;
import java.util.Scanner;

public class query_board
{
    final static int ROWS = 256;
    final static int COLS = 256;
    static int[][] matrix = new int[ROWS][COLS];

    public static void main(String[] args)
    {
        try {
            BufferedReader in = new BufferedReader(
                    new FileReader(new File(args[0])));

            String line;
            while ((line = in.readLine()) != null) {
                Scanner scanner = new Scanner(line);

                String queryType = scanner.next();
                if (queryType.matches("Set.*")) {
                    set(queryType, scanner.nextInt(), scanner.nextInt());
                } else if (queryType.matches("Query.*")) {
                    System.out.println(query(queryType, scanner.nextInt()));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public static void set(String type, int n, int x)
    {
        if (type.matches(".*Col") && n <= COLS) {
            for (int i = 0; i < COLS; i++) {
                matrix[i][n] = x;
            }
        } else if (type.matches(".*Row") && n <= ROWS) {
            for (int i = 0; i < ROWS; i++) {
                matrix[n][i] = x;
            }
        }
    }

    public static int query(String type, int n)
    {
        int sum = 0;

        if (type.matches(".*Col") && n <= COLS) {
            for (int i = 0; i < COLS; i++) {
                sum += matrix[i][n];
            }
        } else if (type.matches(".*Row") && n <= ROWS) {
            for (int i = 0; i < ROWS; i++) {
                sum += matrix[n][i];
            }
        }

        return sum;
    }
}

