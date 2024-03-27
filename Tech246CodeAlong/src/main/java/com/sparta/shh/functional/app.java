package com.sparta.shh.functional;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static java.lang.Math.PI;

public class app
{
    public static void main(String[] args) {
//        List<Integer> numbers = new ArrayList<>(List.of(5,20,9,6,2,1));
//
//        numbers.removeIf(i -> i > 10);
//        System.out.println(numbers.toString());
//
//        numbers.removeIf(i -> i % 3 == 0);
//        System.out.println(numbers.toString());
//
//        numbers.removeIf(i -> i >= 5);
//        System.out.println(numbers.toString());
//
//        numbers.removeIf(i -> i % 2 != 0);
//        System.out.println(numbers.toString());

        List<Integer> numbers = new ArrayList<>(List.of(5,20,9,6,2,1));

        List<Integer> numbersPlusOne = numbers.stream().map(n -> n + 1).toList();

        System.out.println(numbersPlusOne);

        numbersPlusOne.forEach(System.out::println);

        Calculator myCalc = new Calculator(5,10);

        System.out.println(myCalc.getCustomResult((n1,n2)-> (n1 + n2) * 10));

        System.out.println(myCalc.getCustomResultPi((n1) -> (n1 * Math.PI)));

        System.out.println(myCalc.getCustomResulCheck(Integer::equals));

    }





}
