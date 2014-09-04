package com.codeeval.challenges.LowestCommonAncestor;

import java.io.*;
import java.util.Scanner;
import org.testng.Assert;
import org.testng.annotations.*;

class BinaryTree
{
    private Node root;

    private static class Node
    {
        Node left, right;
        int data;

        Node(int data)
        {
            left  = null;
            right = null;
            this.data = data;
        }
    }

    public void BinaryTree()
    {
        root = null;
    }

    public void insert(int data)
    {
        root = insert(root, data);
    }

    private Node insert(Node node, int data)
    {
        if (node == null) {
            node = new Node(data);
        } else {
            if (data <= node.data) {
                node.left = insert(node.left, data);
            } else {
                node.right = insert(node.right, data);
            }
        }

        return node;
    }

    public int size()
    {
        return size(root);
    }

    private int size(Node node)
    {
        if (node == null) {
            return 0;
        }

        return size(node.left) + 1 + size(node.right);
    }

    public String toString()
    {
        return toString(root).trim();
    }

    private String toString(Node node)
    {
        String s = "";

        if (node != null) {
            s = toString(node.left)
                + node.data + " "
                + toString(node.right);
        }

        return s;
    }

    public int lowestCommonAncestor(int a, int b)
    {
        return lowestCommonAncestor(root, a, b);
    }

    private int lowestCommonAncestor(Node node, int a, int b)
    {
        while (node != null) {
            if (a < node.data && b < node.data) {
                node = node.left;
            } else if (a > node.data && b > node.data) {
                node = node.right;
            } else {
                return node.data;
            }
        }

        return -1;
    }
}

public class Main
{
    @Test
    public void testRun()
    {
        String filename = System.getProperty("user.dir")
            + "/../testdata/LowestCommonAncestor.txt";
        String expectedOutput = "30\n8\n";
        Assert.assertEquals(run(filename),expectedOutput);
    }

    public static String run(String filename)
    {
        String output = "";

        BinaryTree tree = new BinaryTree();
        int[] input = {30, 8, 52, 3, 20, 10, 29};
        for (int i : input) {
            tree.insert(i);
        }

        try {
            BufferedReader in = new BufferedReader(
                    new FileReader(new File(filename)));

            String line;
            while ((line = in.readLine()) != null) {
                Scanner scanner = new Scanner(line);
                output += tree.lowestCommonAncestor(scanner.nextInt(),scanner.nextInt());
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

