package me.ktpark.websvc.base.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionController {

    @ExceptionHandler
    public void globalExceptionCatch(Exception e) {
        e.printStackTrace();
    }


}
