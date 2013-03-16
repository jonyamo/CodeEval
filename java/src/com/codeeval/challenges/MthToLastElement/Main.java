package com.codeeval.challenges.MthToLastElement;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import org.testng.Assert;
import org.testng.annotations.*;

public class Main
{
    @Test
    public void testRun()
    {
        String filename = System.getProperty("user.home")
            + "/hacking/CodeEval/testdata/MthToLastElement.txt";
        String expectedOutput = "a\ng\n";
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
                ArrayList<String> items = new ArrayList<String>();
                Scanner scanner = new Scanner(line);

                while (scanner.hasNext()) {
                    if (scanner.hasNextInt()) {
                        int mth = items.size() - scanner.nextInt();
                        if (mth >= 0) {
                            output += items.get(mth) + "\n";
                        }
                    } else {
                        items.add(scanner.next());
                    }
                }
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

