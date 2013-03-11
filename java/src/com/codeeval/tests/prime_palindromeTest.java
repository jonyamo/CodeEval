package com.codeeval.tests;

import com.codeeval.challenges.prime_palindrome;
import org.testng.Assert;
import org.testng.annotations.*;

public class prime_palindromeTest
{
    @Test
    public void testIsPrime()
    {
        Assert.assertEquals(prime_palindrome.isPrime(13),true);
        Assert.assertEquals(prime_palindrome.isPrime(137),true);
        Assert.assertEquals(prime_palindrome.isPrime(99),false);
    }

    @Test
    public void testIsPalindrome()
    {
        Assert.assertEquals(prime_palindrome.isPalindrome(1331),true);
        Assert.assertEquals(prime_palindrome.isPalindrome(9999),true);
        Assert.assertEquals(prime_palindrome.isPalindrome(1234),false);
    }

    @Test
    public void testReverse()
    {
        Assert.assertEquals(prime_palindrome.reverse(1234),4321);
    }
}
