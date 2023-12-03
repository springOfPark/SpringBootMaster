package me.ktpark.websvc.base.controller;

import me.ktpark.websvc.base.extension.DefaultTransactionData;
import me.ktpark.websvc.base.extension.TransactionSpec;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
public class TransactionController implements ApplicationContextAware {

    static final Logger LOGGER = LoggerFactory.getLogger(TransactionController.class);

    private ApplicationContext applicationContext;

    private Map<String, Object> serviceMap;

    @Value("${app.base.package}")
    private String basePackage;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
        serviceMap = applicationContext.getBeansWithAnnotation(TransactionSpec.class);
    }

    @PostMapping("/transaction/{path1}")
    public ResponseEntity<Map<String, Object>> transactionPath1(@PathVariable String path1, @RequestBody Map<String, Object> param, HttpServletRequest requset) {
        return new ResponseEntity<>(param, HttpStatus.OK);
    }

    @PostMapping("/transaction/{path1}/{path2}")
    public ResponseEntity<Map<String, Object>> transactionPath1(@PathVariable String path1, @PathVariable String path2, @RequestBody Map<String, Object> param, HttpServletRequest requset) {
        ResponseEntity<Map<String, Object>> mapResponseEntity = new ResponseEntity<>(param, HttpStatus.OK);
        return mapResponseEntity;
    }
}
