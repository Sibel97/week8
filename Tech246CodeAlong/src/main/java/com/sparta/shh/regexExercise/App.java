package com.sparta.shh.regexExercise;

public class App
{
    public static void main(String[] args) {
        String usZip1 = "90210-1234";
        String usZip2 = "10001-5678";
        String zipCodeRegex = "[0-9-]+";
        String zipCodeRegex2 = "[0-9]{5}-+[1-9]{4}";

        System.out.println("ZipCodes");
        System.out.println(usZip1.matches(zipCodeRegex));
        System.out.println(usZip2.matches(zipCodeRegex));
        System.out.println(usZip1.matches(zipCodeRegex2));
        System.out.println(usZip2.matches(zipCodeRegex2));

        String giftcard1 = "FW04-VQ75-HH36-IL80";
        String giftcard2 = "BE93-OK12-UC66-TR27";
        String giftcardRegex = "[0-9,A-Z-]+";
        String giftcardRegex2 = "[0-9,A-Z]{4}-+[0-9,A-Z]{4}-+[0-9,A-Z]{4}-+[0-9,A-Z]{4}";

        System.out.println("Giftcards");

        System.out.println(giftcard2.matches(giftcardRegex));
        System.out.println(giftcard1.matches(giftcardRegex));
        System.out.println(giftcard1.matches(giftcardRegex2));


        String robot1 = "R2-D2";
        String robot2 = "C-3PO";
        String robotRegex = "[0-9,A-Z-]+";


        System.out.println("Robots");
        System.out.println(robot1.matches(robotRegex));
        System.out.println(robot2.matches(robotRegex));

        String website1 = "https://www.example.com";
        String website2 = "https://www.google.com";





    }
}
