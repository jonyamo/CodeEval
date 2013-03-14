package com.codeeval.tests;

import com.codeeval.challenges.StackImplementation;
import org.testng.Assert;
import org.testng.annotations.*;

public class StackImplementationTest
{
    private StackImplementation<Integer> stack;

    @BeforeMethod
    public void setUp() {
        stack = new StackImplementation<Integer>();
    }

    @Test
    public void testPop()
    {
        stack.push(1);
        stack.push(2);
        stack.push(3);
        Assert.assertTrue(3 == stack.pop());
    }

    @Test
    public void testPush()
    {
        stack.push(1);
        Assert.assertTrue(1 == stack.size());
    }

    @Test
    public void testIsEmpty()
    {
        Assert.assertTrue(stack.isEmpty());
        stack.push(1);
        Assert.assertFalse(stack.isEmpty());
    }
}
