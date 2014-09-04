package com.codeeval.challenges.StackImplementation;

import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import org.testng.Assert;
import org.testng.annotations.*;

class MyStack<E> extends ArrayList<E>
{
    // found some help with this here:
    // http://www.vogella.com/articles/JavaDatastructures/article.html#stack

    private static final long serialVersionUID = 1L;

    public E pop()
    {
        E e = get(size() - 1);
        remove(size() - 1);
        return e;
    }

    public void push(E e)
    {
        add(e);
    }

    public boolean isEmpty()
    {
        return size() == 0;
    }
}

public class Main
{
    @Test
    public void testRun()
    {
        String filename = System.getProperty("user.dir")
            + "/../testdata/StackImplementation.txt";
        String expectedOutput = "4 2\n4 -2\n";
        Assert.assertEquals(run(filename),expectedOutput);
    }

    public static String run(String filename)
    {
        String output = "";

        try {
            BufferedReader in = new BufferedReader(
                    new FileReader(new File(filename)));

            String line, outputLine;
            while ((line = in.readLine()) != null) {
                outputLine = "";
                MyStack<Integer> stack
                    = new MyStack<Integer>();
                Scanner scanner = new Scanner(line);

                while (scanner.hasNextInt()) {
                    stack.push(scanner.nextInt());
                }

                int i = 0;
                while (!stack.isEmpty()) {
                    int n = stack.pop();
                    if ((i & 1) == 0) {
                        outputLine += n + " ";
                    }
                    i++;
                }

                output += outputLine.trim() + "\n";
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
