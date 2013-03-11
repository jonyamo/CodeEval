package com.codeeval.challenges;

public class sum_prime
{
    public static void main(String[] args)
    {
        System.out.println(sumPrimes(1000));
    }

    public static int sumPrimes(int n)
    {
        int sum = 2, primes = 0;

        for (int i = 3; primes < n-1; i += 2) {
            if (isPrime(i)) {
                sum += i;
                primes++;
            }
        }

        return sum;
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

