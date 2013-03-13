package com.codeeval.challenges;

import java.io.*;

public class reverse_words
{
    public static void main(String[] args)
    {
        try {
            BufferedReader in = new BufferedReader(
                    new FileReader(new File(args[0])));

            String line;
            while ((line = in.readLine()) != null) {
                System.out.println(reverseLine(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public static String reverseLine(String line)
    {
        String[] words = line.split("\\b");
        StringBuilder sb = new StringBuilder();

        for (int i = words.length; i --> 0;) {
            sb.append(words[i]);
        }

        return sb.toString();
    }
}

