package com.codeeval.challenges;

import java.io.*;
import java.util.Scanner;

public class self_describing_numbers
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

                System.out.println(isSelfDescribing(n)?"1":"0");
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public static boolean isSelfDescribing(int n) {
        String digits = Integer.toString(n);
        int len = digits.length();

        for (int i = 0; i < len; i++) {
            int digit = Integer.parseInt(digits.charAt(i) + "");

            if (digit >= len || digit != countCharacter(digits,Integer.toString(i))) {
                return false;
            }
        }

        return true;
    }

    public static int countCharacter(String word, String ch)
    {
        int pos = word.indexOf(ch);
        return pos == -1 ? 0 : 1 + countCharacter(word.substring(pos+1),ch);
    }
}

