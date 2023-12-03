package me.ktpark.websvc.base.controller;

import me.ktpark.websvc.base.extension.DefaultTransactionData;
import me.ktpark.websvc.base.extension.DefaultTransactionService;
import me.ktpark.websvc.base.extension.TransactionSpec;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
@RequestMapping("/submit")
public class SubmitController implements ApplicationContextAware {

    private ApplicationContext applicationContext;
    private Map<String, Object> serviceMap;

    @Value("${app.base.package}")
    private String basePackage;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
        serviceMap = applicationContext.getBeansWithAnnotation(TransactionSpec.class);
    }

    final static Logger LOGGER = LoggerFactory.getLogger(SubmitController.class);

    @PostMapping("/{path1}")
    public String transactionPath1(@PathVariable String path1, @RequestParam Map<String, Object> param, HttpServletRequest requset, Model model) {

        DefaultTransactionData defaultTransactionData = new DefaultTransactionData().build();

        defaultTransactionData.putRequestParam(param);

        String servicePkg = basePackage + "." + path1;
        DefaultTransactionService transactionService = (DefaultTransactionService) serviceMap.get(servicePkg);

        if (transactionService != null) {
            transactionService.doService(defaultTransactionData);
        }

        model.addAttribute(defaultTransactionData);

        return "/websvc/common/submitResult";
    }

    @PostMapping("/{path1}/{path2}")
    public String transactionPath1(@PathVariable String path1, @PathVariable String path2, @RequestParam Map<String, Object> param, HttpServletRequest requset, Model model) {

        DefaultTransactionData defaultTransactionData = applicationContext.getBean(DefaultTransactionData.class).build();

        defaultTransactionData.putRequestParam(param);

        String servicePkg = basePackage + "." + path1 + "." + path2;
        DefaultTransactionService transactionService = (DefaultTransactionService) serviceMap.get(servicePkg);

        if (transactionService != null) {
            transactionService.doService(defaultTransactionData);
        }

        model.addAttribute("bodyReq", defaultTransactionData.getRequestParam());
        model.addAttribute("bodyRes", defaultTransactionData.getResponseParam());

        return "/websvc/common/submitResult";

    }

    @ExceptionHandler
    public ResponseEntity<Map<String, Object>> exceptionProc(Throwable throwable) {
        throwable.printStackTrace();
        Map<String, Object> exMap = Map.of("exceptionMsg", throwable.getMessage());
        ResponseEntity<Map<String, Object>> mapResponseEntity = new ResponseEntity<>(exMap, HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
