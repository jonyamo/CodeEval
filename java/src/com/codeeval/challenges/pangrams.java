package com.codeeval.challenges;

import java.io.*;

public class pangrams
{
    public static void main(String[] args)
    {
        try {
            BufferedReader in = new BufferedReader(
                    new FileReader(new File(args[0])));

            String line;
            while ((line = in.readLine()) != null) {
                if (line.trim().length() == 0) {
                    continue;
                }

                String letters = getMissingLetters(line.toLowerCase());

                if (letters.length() == 0) {
                    System.out.println("NULL");
                } else {
                    System.out.println(letters);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public static String getMissingLetters(String s)
    {
        String missingLetters = "";

        for (char c = 'a'; c <= 'z'; c++) {
            if (s.indexOf(c) == -1) {
                missingLetters += c;
            }
        }

        return missingLetters;
    }
}

