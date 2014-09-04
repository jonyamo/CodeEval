package com.codeeval.challenges.EmailValidation;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.testng.Assert;
import org.testng.annotations.*;

class EmailValidator
{
    private Pattern pattern;
    private Matcher matcher;

    private static final String EMAIL_REGEX =
        "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    public EmailValidator()
    {
        pattern = Pattern.compile(EMAIL_REGEX);
    }

    public boolean validate(final String s)
    {
        matcher = pattern.matcher(s);
        return matcher.matches();
    }
}

public class Main
{
    @Test
    public void testRun()
    {
        String filename = System.getProperty("user.dir")
            + "/../testdata/EmailValidation.txt";
        String expectedOutput = "true\nfalse\nfalse\ntrue\n";
        Assert.assertEquals(run(filename),expectedOutput);
    }

    public static String run(String filename)
    {
        String output = "";

        try {
            EmailValidator emailValidator = new EmailValidator();

            BufferedReader in = new BufferedReader(
                    new FileReader(new File(filename)));

            String line;
            while ((line = in.readLine()) != null) {
                output += emailValidator.validate(line);
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

