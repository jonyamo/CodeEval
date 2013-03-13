package com.codeeval.challenges;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class cycle_detection
{
    public static void main(String[] args)
    {
        try {
            BufferedReader in = new BufferedReader(
                    new FileReader(new File(args[0])));

            String line;
            while ((line = in.readLine()) != null) {
                System.out.println(getSequence(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public static String getSequence(String s)
    {
        Pattern pattern = Pattern.compile("(.+ .+)( \\1)+");
        Matcher matcher = pattern.matcher(s);
        while (matcher.find()) {
            return matcher.group(1);
        }
        return "";
    }
}

