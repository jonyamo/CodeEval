package com.codeeval.challenges.PrimeNumbers;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import org.testng.Assert;
import org.testng.annotations.*;

class SieveOfEratosthenes
{
    private ArrayList<Integer> sieve = new ArrayList<Integer>();

    public SieveOfEratosthenes(int n)
    {
        sieve.add(2);
        for (int i = 3; i <= n; i += 2) {
            sieve.add(i);
        }

        iterate(3);
    }

    public String toString()
    {
        Iterator<Integer> itr = sieve.iterator();
        StringBuilder sb = new StringBuilder();

        if (!itr.hasNext()) {
            return "";
        }

        for (;;) {
            Integer prime = itr.next();
            sb.append(prime);
            if (!itr.hasNext()) {
                return sb.toString();
            }
            sb.append(",");
        }
    }

    private void iterate(int p)
    {
        Iterator<Integer> itr = sieve.iterator();
        while (itr.hasNext()) {
            Integer i = itr.next();
            if (i == p) {
                continue;
            }
            if (i % p == 0) {
                itr.remove();
            }
        }

        int index = sieve.indexOf(p) + 1;
        if (index < sieve.size()) {
            iterate(sieve.get(index));
        }
    }
}

public class Main
{
    @Test
    public void testRun()
    {
        String filename = System.getProperty("user.home")
            + "/hacking/CodeEval/testdata/PrimeNumbers.txt";
        String expectedOutput =
            "2,3,5,7\n" +
            "2,3,5,7,11,13,17,19\n" +
            "2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,73,79,83,89,97\n";
        Assert.assertEquals(run(filename),expectedOutput);
    }

    public static String run(String filename)
    {
        String output = "";

        try {
            BufferedReader in = new BufferedReader(
                    new FileReader(new File(filename)));

            String line;
            while ((line = in.readLine()) != null) {
                Scanner scanner = new Scanner(line);
                SieveOfEratosthenes sieve = new SieveOfEratosthenes(scanner.nextInt());
                output += sieve.toString();
                output += "\n";
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }

        return output;
    }

    public static void main(String[] args)
    {
        System.out.print(run(args[0]));
    }
}

