package me.ktpark.websvc.base.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
public class TestController {

    @PostMapping("/transaction/test/userTest")
    public ResponseEntity<Map<String, Object>> userTest(@RequestBody Map<String, Object> param, HttpServletRequest req) {
        ResponseEntity<Map<String, Object>> mapResponseEntity = new ResponseEntity<>(param, HttpStatus.OK);
        return mapResponseEntity;

    }
    @GetMapping("/test/test")
    public String test(@RequestBody String body) {
        return body;
    }
    @GetMapping("/test/json")
    public Map<String, Object> testJson(@RequestBody Map<String, Object> body) {
        return body;
    }

}
