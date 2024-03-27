package com.sparta.shh.functional;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Calculator {
    private final Integer num1;
    private final Integer num2;

    public Calculator(Integer num1, Integer num2)
    {
        this.num1 = num1;
        this.num2 = num2;
    }

    public Integer getCustomResult(BiFunction<Integer,Integer,Integer> calculation)
    {
        return calculation.apply(num1,num2);
    }

    public Double getCustomResultPi(Function<Integer,Double> calculation)
    {
        return calculation.apply(num1);
    }

    public Boolean getCustomResulCheck(BiFunction<Integer,Integer,Boolean> calculation)
    {
        return calculation.apply(num1,num2);
    }
}
