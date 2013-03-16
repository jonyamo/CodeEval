package com.codeeval.challenges.SumOfPrimes;

import org.testng.Assert;
import org.testng.annotations.*;

public class Main
{
    @Test
    public void testRun()
    {
        Assert.assertEquals(run(),3682913);
    }

    public static int run()
    {
        int sum = 2, primes = 0;

        for (int i = 3; primes < 999; i += 2) {
            if (isPrime(i)) {
                sum += i;
                primes++;
            }
        }

        return sum;
    }

    public static void main(String[] args)
    {
        System.out.println(run());
    }

    public static boolean isPrime(int n)
    {
        if (n == 2) {
            return true;
        }

        if (n % 2 == 0) {
            return false;
        }

        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }
}

