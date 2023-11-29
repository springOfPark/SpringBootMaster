package me.ktpark.websvc.base.controller;

import me.ktpark.websvc.base.controller.extension.BaseControllerTemplate;
import me.ktpark.websvc.base.controller.extension.DefaultTransactionData;
import me.ktpark.websvc.base.service.TestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.spi.LoggerFactoryBinder;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.Map;

@RestController
public class TransactionController extends BaseControllerTemplate {

    static final Logger LOGGER = LoggerFactory.getLogger(TransactionController.class);

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private DefaultTransactionData defaultTransactionData;

    @PostMapping("/transaction/{path1}")
    public ResponseEntity<Map<String, Object>> transactionPath1(@PathVariable String path1, @RequestBody Map<String, Object> param, HttpServletRequest requset) {

        printRequestInfo(requset);
        System.out.println(param);

        defaultTransactionData.build();

        defaultTransactionData.putRequestParam(param);

        defaultTransactionData.printDefaultTransactionDataClass();

        TestService testService = applicationContext.getBean(TestService.class);
        testService.service();

        return new ResponseEntity<>(param, HttpStatus.OK);
    }

    @PostMapping("/transaction/{path1}/{path2}")
    public ResponseEntity<Map<String, Object>> transactionPath1(@PathVariable String path1, @PathVariable String path2, @RequestBody Map<String, Object> param, HttpServletRequest requset) {
        printRequestInfo(requset);
        System.out.println(param);
        ResponseEntity<Map<String, Object>> mapResponseEntity = new ResponseEntity<>(param, HttpStatus.OK);
        return mapResponseEntity;
    }

}
