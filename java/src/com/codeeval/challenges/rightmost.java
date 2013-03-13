package com.codeeval.challenges;

import java.io.*;
import java.util.Scanner;

public class rightmost
{
    public static void main(String[] args)
    {
        try {
            BufferedReader in = new BufferedReader(
                    new FileReader(new File(args[0])));

            String line;
            while ((line = in.readLine()) != null) {
                Scanner scanner = new Scanner(line).useDelimiter(",");

                String s = scanner.next();
                String i = scanner.next();

                System.out.println(s.lastIndexOf(i));
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}

