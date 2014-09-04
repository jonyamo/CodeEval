package com.codeeval.challenges.QueryBoard;

import java.io.*;
import java.util.Scanner;
import org.testng.Assert;
import org.testng.annotations.*;

public class Main
{
    final static int ROWS = 256;
    final static int COLS = 256;
    static int[][] matrix = new int[ROWS][COLS];

    @Test
    public void testRun()
    {
        String filename = System.getProperty("user.dir")
            + "/../testdata/QueryBoard.txt";
        String expectedOutput = "5118\n34\n1792\n3571\n";
        Assert.assertEquals(run(filename),expectedOutput);
    }

    public static String run(String filename)
    {
        String output = "";

        try {
            BufferedReader in = new BufferedReader(
                    new FileReader(new File(filename)));

            String line;
            while ((line = in.readLine()) != null) {
                Scanner scanner = new Scanner(line);

                String queryType = scanner.next();
                if (queryType.matches("Set.*")) {
                    set(queryType, scanner.nextInt(), scanner.nextInt());
                } else if (queryType.matches("Query.*")) {
                    output += query(queryType, scanner.nextInt()) + "\n";
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }

        return output;
    }

    public static void main(String[] args)
    {
        System.out.print(run(args[0]));
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

