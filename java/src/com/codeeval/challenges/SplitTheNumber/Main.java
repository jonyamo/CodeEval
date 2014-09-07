package com.codeeval.challenges.SplitTheNumber;

import java.io.*;

class SplitTheNumber
{
    private final String pattern;

    public SplitTheNumber(String str)
    {
        pattern = str;
    }

    public String toString()
    {
        String leftSide = "";
        String rightSide = "";
        String[] parts = pattern.split("\\s");
        String digits = parts[0];
        String formula = parts[1];
        int operatorPos;
        char operator;

        operatorPos = formula.indexOf("+");
        if (operatorPos == -1) {
            operatorPos = formula.indexOf("-");
        }
        operator = formula.charAt(operatorPos);

        for (int i = 0; i < digits.length(); i++) {
            if (i < operatorPos)
                leftSide += Character.toString(digits.charAt(i));
            else
                rightSide += Character.toString(digits.charAt(i));
        }

        if (operator == '+')
            return Integer.toString(Integer.parseInt(leftSide) + Integer.parseInt(rightSide));
        else
            return Integer.toString(Integer.parseInt(leftSide) - Integer.parseInt(rightSide));
    }
}

public class Main
{
    public static void main(String[] args)
    {
        String output = "";

        try {
            BufferedReader in = new BufferedReader(
                    new FileReader(new File(args[0])));

            String line;
            while ((line = in.readLine()) != null) {
                SplitTheNumber pattern = new SplitTheNumber(line);
                output += pattern.toString() + "\n";
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }

        System.out.print(output);
    }
}

