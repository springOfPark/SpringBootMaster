package me.ktpark.websvc.base.controller;

import me.ktpark.websvc.base.controller.extension.BaseControllerTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@Controller
public class SubmitController extends BaseControllerTemplate {

    static final Logger LOGGER = LoggerFactory.getLogger(SubmitController.class);

    @PostMapping("/submit/{path1}")
    public ResponseEntity<Map<String, Object>> transactionPath1(@PathVariable String path1, Map<String, Object> param, HttpServletRequest requset) {
        printRequestInfo(requset);
        System.out.println(param);
        ResponseEntity<Map<String, Object>> mapResponseEntity = new ResponseEntity<>(param, HttpStatus.OK);
        return mapResponseEntity;
    }

    @PostMapping("/submit/{path1}/{path2}")
    public ResponseEntity<Map<String, Object>> transactionPath1(@PathVariable String path1, @PathVariable String path2, Map<String, Object> param, HttpServletRequest requset) {
        printRequestInfo(requset);
        System.out.println(param);
        ResponseEntity<Map<String, Object>> mapResponseEntity = new ResponseEntity<>(param, HttpStatus.OK);
        return mapResponseEntity;
    }

    @ExceptionHandler
    public ResponseEntity<Map<String, Object>> exceptionProc(Throwable throwable) {
        System.out.println("Exceptions.");
        throwable.printStackTrace();
        Map<String, Object> exMap = Map.of("exceptionMsg", throwable.getMessage());
        ResponseEntity<Map<String, Object>> mapResponseEntity = new ResponseEntity<>(exMap, HttpStatus.OK);
        return mapResponseEntity;
    }

}
