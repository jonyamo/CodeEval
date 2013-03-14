package com.codeeval.challenges;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

//public class Main
public class MthToLast
{
    public static void main(String[] args)
    {
        try {
            BufferedReader in = new BufferedReader(
                    new FileReader(new File(args[0])));

            String line;
            while ((line = in.readLine()) != null) {
                ArrayList<String> items = new ArrayList<String>();
                Scanner scanner = new Scanner(line);

                while (scanner.hasNext()) {
                    if (scanner.hasNextInt()) {
                        int mth = items.size() - scanner.nextInt();
                        if (mth >= 0) {
                            System.out.println(items.get(mth));
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
    }
}

