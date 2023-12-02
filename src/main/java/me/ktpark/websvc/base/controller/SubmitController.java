package me.ktpark.websvc.base.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class SubmitController {

    static final Logger LOGGER = LoggerFactory.getLogger(SubmitController.class);

    @PostMapping("/submit/{path1}")
    public ModelAndView transactionPath1(@PathVariable String path1, HttpServletRequest requset, ModelAndView modelAndView) {
        System.out.println(modelAndView);
        return modelAndView;
    }

    @PostMapping("/submit/{path1}/{path2}")
    public ResponseEntity<Map<String, Object>> transactionPath1(@PathVariable String path1, @PathVariable String path2, HttpServletRequest requset) {
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @ExceptionHandler
    public ResponseEntity<Map<String, Object>> exceptionProc(Throwable throwable) {
        System.out.println("Exceptions.");
        throwable.printStackTrace();
        Map<String, Object> exMap = Map.of("exceptionMsg", throwable.getMessage());
        ResponseEntity<Map<String, Object>> mapResponseEntity = new ResponseEntity<>(exMap, HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
