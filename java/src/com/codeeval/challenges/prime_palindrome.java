package com.codeeval.challenges;

public class prime_palindrome
{
    public static void main(String[] args)
    {
        for (int i = 1000; i >= 0; i--) {
            if (isPrime(i) && isPalindrome(i)) {
                System.out.println(i);
                System.exit(0);
            }
        }
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

    public static boolean isPalindrome(int n)
    {
        return n == reverse(n);
    }

    public static int reverse(int n)
    {
        int nReversed = 0;

        while (n > 0) {
            nReversed = nReversed*10 + n%10;
            n = n/10;
        }

        return nReversed;
    }
}

