package com.sparta.shh.regex;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexApp
{
    public static void main(String[] args) {
        String input = "Cathy,Phil, Nish,  Manish, Alex Blunt";

        var splitString = input.split(",");
        //split on a coma

        var splitStringSpace = input.split(" ");
        //split on a space

        var splitStringSpace2 = input.split("\\s");
        //split on one or more spaces

        var splitStringEither = input.split("[,\\s*]");

        var splitStringCommaWithorWithoutFollwoingSpace = input.split(",\\s*");

        //System.out.println(Arrays.toString(splitStringCommaWithorWithoutFollwoingSpace));

        String emailRegex = "[a-z.]+@[a-z.]+";
        String email = "shassan@spartaglobal.com";
        String email2 = "s_hassan97@hotmail.co.uk";

        //System.out.println(email.matches(emailRegex));
        //System.out.println(email.matches(emailRegex));

        String postcode1 = "N18 2JX";
        String postcode2 = "HP13 5GG";
        String postcode3 = "EC3";

        //create compiled regex
        Pattern emailPattern = Pattern.compile("[a-z.]+@[a-z.]+");
        Matcher matcher = emailPattern.matcher(email2);
        System.out.println(matcher.find());

     }
}
