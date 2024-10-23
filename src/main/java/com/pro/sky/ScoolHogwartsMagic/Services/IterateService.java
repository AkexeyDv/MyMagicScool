package com.pro.sky.ScoolHogwartsMagic.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;
@Service
public class IterateService {
    @Autowired
    public Integer iterateCalculate(){
        int sum = Stream.iterate(1, a -> a +1).parallel() .limit(1_000_000) .reduce(0, (a, b) -> a + b );
        return sum;
    }
}
