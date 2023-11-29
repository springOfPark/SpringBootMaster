package me.ktpark.websvc.base.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.spi.LoggerFactoryBinder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.Map;

@RestController
public class TransactionController {

    static final Logger LOGGER = LoggerFactory.getLogger(TransactionController.class);

    @RequestMapping("/transaction/{path1}")
    public ResponseEntity<Map<String, Object>> transactionPath1(@PathVariable String path1,Map<String, Object> param) {
        System.out.println(param);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping("/transaction/{path1}/{path2}")
    public ResponseEntity<Map<String, Object>> transactionPath1(@PathVariable String path1, @PathVariable String path2, Map<String, Object> param) {
        System.out.println(param);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
