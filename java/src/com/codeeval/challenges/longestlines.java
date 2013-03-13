package com.codeeval.challenges;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class longestlines implements Comparator<String>
{
    public static void main(String[] args)
    {
        try {
            BufferedReader in = new BufferedReader(
                    new FileReader(new File(args[0])));

            int numLines = 0;
            ArrayList<String> lines = new ArrayList<String>();

            String line;
            while ((line = in.readLine()) != null) {
                Scanner scanner = new Scanner(line);

                if (scanner.hasNext()) {
                    if (scanner.hasNextInt()) {
                        numLines = scanner.nextInt();
                        continue;
                    }
                    lines.add(line.trim());
                }
            }

            printLongestLines(numLines, lines);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public static void printLongestLines(int n, ArrayList<String> lines)
    {
        Collections.sort(lines, new longestlines());

        for (int i = lines.size(); i --> lines.size() - n;) {
            System.out.println(lines.get(i));
        }
    }

    public int compare(String x, String y)
    {
        if (x == null) {
            return y == null ? 0 : -1;
        } else if (y == null) {
            return +1;
        } else {
            int lenX = x.length();
            int lenY = y.length();

            if (lenX == lenY) {
                return x.compareTo(y);
            } else {
                return lenX < lenY ? -1 : +1;
            }
        }
    }
}

