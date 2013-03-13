package com.codeeval.challenges;

import java.io.*;
import java.util.Arrays;

public class beautiful_strings
{
    public static void main(String[] args)
    {
        try {
            BufferedReader in = new BufferedReader(
                    new FileReader(new File(args[0])));

            String line;
            while ((line = in.readLine()) != null) {
                System.out.println(getBeauty(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public static int getBeauty(String s)
    {
        // For some reason I wasn't able to comprehend the problem statement.
        //
        // I was getting lost trying to translate this: "The beauty of each
        // letter is an integer between 1 and 26, inclusive, and no two
        // letters have the same beauty."
        //
        // Into this: "Count the number of occurrences for each letter and
        // assign higher values to the letters that occur most frequently."
        // WTF!?
        //
        // So, thanks to this site, http://argote.mx/?p=353, I was able to
        // make sense out of it. And since I am doing all of this as a
        // learning experience, my solution more or less mimics the one found
        // there.
        int sum = 0;

        // uppercase vs lowercase doesn't affect the beauty of a character, so
        // just lowercase everything.
        char[] chars = s.toLowerCase().toCharArray();
        
        // create an array of occurrences and initialize all counts to 0.
        int[] occurrences = new int[26];
        Arrays.fill(occurrences, 0);

        // now count the occurrence of each valid character
        for (char c : chars) {
            if (c < 'a' || c > 'z') {
                continue;
            }
            occurrences[c - 'a']++;
        }

        // finally, value the most frequently appearing characters highest.
        Arrays.sort(occurrences);
        for (int i = 0; i < 26; ++i) {
            sum += occurrences[25 - i] * (26 - i);
        }

        return sum;
    }
}

