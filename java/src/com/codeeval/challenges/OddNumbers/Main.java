package com.codeeval.challenges.OddNumbers;

import org.testng.Assert;
import org.testng.annotations.*;

public class Main
{
    @Test
    public void testRun()
    {
        String expectedOutput =
            "1\n" +
            "3\n" +
            "5\n" +
            "7\n" +
            "9\n" +
            "11\n" +
            "13\n" +
            "15\n" +
            "17\n" +
            "19\n" +
            "21\n" +
            "23\n" +
            "25\n" +
            "27\n" +
            "29\n" +
            "31\n" +
            "33\n" +
            "35\n" +
            "37\n" +
            "39\n" +
            "41\n" +
            "43\n" +
            "45\n" +
            "47\n" +
            "49\n" +
            "51\n" +
            "53\n" +
            "55\n" +
            "57\n" +
            "59\n" +
            "61\n" +
            "63\n" +
            "65\n" +
            "67\n" +
            "69\n" +
            "71\n" +
            "73\n" +
            "75\n" +
            "77\n" +
            "79\n" +
            "81\n" +
            "83\n" +
            "85\n" +
            "87\n" +
            "89\n" +
            "91\n" +
            "93\n" +
            "95\n" +
            "97\n" +
            "99\n";
        Assert.assertEquals(run(),expectedOutput);
    }

    public static String run()
    {
        String output = "";

        for (int i = 1; i < 100; i++) {
            if ((i & 1) == 1) {
                output += i + "\n";
            }
        }

        return output;
    }

    public static void main(String[] args)
    {
        System.out.print(run());
    }
}

