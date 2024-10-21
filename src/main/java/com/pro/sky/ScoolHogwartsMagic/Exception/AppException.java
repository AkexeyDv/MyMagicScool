package com.pro.sky.ScoolHogwartsMagic.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class AppException extends IllegalArgumentException{
    public AppException(String s) {
        super(s);
    }
}
