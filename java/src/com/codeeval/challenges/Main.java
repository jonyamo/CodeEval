package com.codeeval.challenges;

import java.io.*;
import java.util.Scanner;
import java.util.Stack;

public class Main
{
    public static void main(String[] args)
    {
        try {
            BufferedReader in = new BufferedReader(
                    new FileReader(new File(args[0])));

            String line;
            while ((line = in.readLine()) != null) {
                String output = "";
                Stack<Integer> stack = new Stack<Integer>();
                Scanner scanner = new Scanner(line);

                while (scanner.hasNextInt()) {
                    stack.push(scanner.nextInt());
                }

                int i = 0;
                while (!stack.empty()) {
                    int n = stack.pop();
                    if ((i & 1) == 0) {
                        output += n + " ";
                    }
                    i++;
                }
                System.out.println(output.trim());
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}

