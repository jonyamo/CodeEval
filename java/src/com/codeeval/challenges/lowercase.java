package com.codeeval.challenges;

import java.io.*;

public class lowercase
{
    public static void main(String[] args)
    {
        try {
            BufferedReader in = new BufferedReader(
                    new FileReader(new File(args[0])));

            String line;
            while ((line = in.readLine()) != null) {
                System.out.println(line.toLowerCase());
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}

