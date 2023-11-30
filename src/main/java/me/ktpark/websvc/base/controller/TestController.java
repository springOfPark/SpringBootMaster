package me.ktpark.websvc.base.controller;

import me.ktpark.websvc.base.extension.BaseControllerTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
public class TestController extends BaseControllerTemplate {

    @PostMapping("/transaction/test/userTest")
    public ResponseEntity<Map<String, Object>> userTest(@RequestBody Map<String, Object> param, HttpServletRequest req) {

        printRequestInfo(req);

        System.out.println(param);

        ResponseEntity<Map<String, Object>> mapResponseEntity = new ResponseEntity<>(param, HttpStatus.OK);
        return mapResponseEntity;

    }

}
