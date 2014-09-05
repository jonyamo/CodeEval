package com.codeeval.challenges.MorseCode;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import org.testng.Assert;
import org.testng.annotations.*;

class MorseCode
{
    private final String clicks;
    private static Map<String, String> map = new HashMap<String, String>();

    static
    {
        map.put("A", ".-");
        map.put("B", "-...");
        map.put("C", "-.-.");
        map.put("D", "-..");
        map.put("E", ".");
        map.put("F", "..-.");
        map.put("G", "--.");
        map.put("H", "....");
        map.put("I", "..");
        map.put("J", ".---");
        map.put("K", "-.-");
        map.put("L", ".-..");
        map.put("M", "--");
        map.put("N", "-.");
        map.put("O", "---");
        map.put("P", ".--.");
        map.put("Q", "--.-");
        map.put("R", ".-.");
        map.put("S", "...");
        map.put("T", "-");
        map.put("U", "..-");
        map.put("V", "...-");
        map.put("W", ".--");
        map.put("X", "-..-");
        map.put("Y", "-.--");
        map.put("Z", "--..");
        map.put("0", "-----");
        map.put("1", ".----");
        map.put("2", "..---");
        map.put("3", "...--");
        map.put("4", "....-");
        map.put("5", ".....");
        map.put("6", "-....");
        map.put("7", "--...");
        map.put("8", "---..");
        map.put("9", "----.");
    }

    public MorseCode(String str)
    {
        clicks = str;
    }

    public String getText(String clicks)
    {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (clicks.equals(entry.getValue())) {
                return entry.getKey();
            }
        }
        return null;
    }

    public String getClicks(String text)
    {
        if (map.containsKey(text))
            return map.get(text);
        return null;
    }

    public String toText()
    {
        String text = "";
        String[] words = clicks.split("\\s\\s");
        for (int i = 0; i < words.length; i++) {
            String[] letters = words[i].split("\\s");
            if (i > 0)
                text += " ";
            for (int j = 0; j < letters.length; j++)
                text += getText(letters[j]);
        }
        return text;
    }
}

public class Main
{
    @Test
    public void testRun()
    {
        String filename = System.getProperty("user.dir")
            + "/../testdata/MorseCode.txt";
        String expectedOutput = "AV2WHIECX 45\nBH3\n";
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
                MorseCode clicks = new MorseCode(line);
                output += clicks.toText() + "\n";
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

