package com.codeeval.challenges;

import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

//public class Main<E> extends ArrayList<E>
public class StackImplementation<E> extends ArrayList<E>
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

    public static void main(String[] args)
    {
        try {
            BufferedReader in = new BufferedReader(
                    new FileReader(new File(args[0])));

            String line;
            while ((line = in.readLine()) != null) {
                String output = "";
                StackImplementation<Integer> stack
                    = new StackImplementation<Integer>();
                Scanner scanner = new Scanner(line);

                while (scanner.hasNextInt()) {
                    stack.push(scanner.nextInt());
                }

                int i = 0;
                while (!stack.isEmpty()) {
                    int n = stack.pop();
                    if ((i & 1) == 0) {
                        output += n + " ";
                    }
                    i++;
                }

                System.out.println(output.trim());
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}

