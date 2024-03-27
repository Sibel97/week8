package com.sparta.shh.typeconversion;

import java.sql.SQLOutput;

public class TypeConversionApp
{
    public static void main(String[] args) {
        var result = 5.50 / 5;
        var myInt = 5;
        double myNum = myInt;
        // you can convert an int to a double because theres no danger
        //that you are losing precision or truncating - theres plenty
        // of space within a double (double is big enough to hold any
        //possible integer value as a double)
        //safe type conversion - any int can be safely converted to double
        //implicit

        //Safe conversions - widening
        //int to double, int to float, int to long

        //unsafe - no guarentee that new type can hold all number
        //double to int, float to int, long to int.
        //narrowing conversion

        double x = Math.PI;
        //float y = x;  Doesnt work
        //programmer needs to signal that this is safe

        float y = (float)x;
        System.out.println(x);
        System.out.println(y);
        //3.141592653589793
        //3.1415927

        long popUKLong = 67_890_000;
        int popUK = (int)popUKLong;
        System.out.println(popUKLong);
        System.out.println(popUK);

        long popWorldLong = 7_900_000_000L;
        int popWorld = (int)popWorldLong;
        System.out.println(popWorldLong);
        System.out.println(popWorld); // really messes it up!
        // Silent overflow - no exception, no warning

        var sum = Integer.MAX_VALUE + 1;
        System.out.println(Integer.MAX_VALUE);
        System.out.println("max value + 1");
        System.out.println(sum);
        // it works like a circle, max + 1 goes to minimum

        //var sum2 = Math.addExact(Integer.MAX_VALUE, 1);
        // throws exception
        var popUKExact = Math.toIntExact(popUKLong);
        //var popWorldExact = Math.toIntExact(popWorldLong);
        //throws exception
        System.out.println(popUKExact);
        //System.out.println(popWorldExact);

        //Strings to primitive types & vice versa

        String strnum = "5";
        // Cant do this
        //int num = (int)strnum;
        // no conversion between them, incompatible types
        //String s = (string)5; - no worky

        //Number to String
        int myNum2 = 42;
        String a = " " + myNum2 ;
        System.out.println(a);

        String b = String.valueOf(myNum2);
        System.out.println(b);
        String c = Integer.toString(myNum2);
        System.out.println(c);

        //String to int
        int d = Integer.parseInt(strnum);
        System.out.println(d);
        //int e = Integer.parseInt("five"); // not formatted as
        //a number so it doesnt work.
        //System.out.println(e);

        //int f = Integer.parseInt("790000000");
        //System.out.println(f); //too large


    }
}
