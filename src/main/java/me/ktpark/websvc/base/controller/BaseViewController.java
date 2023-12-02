package me.ktpark.websvc.base.controller;

import me.ktpark.websvc.base.extension.DefaultTransactionData;
import me.ktpark.websvc.base.extension.DefaultTransactionService;
import me.ktpark.websvc.base.extension.ServiceManager;
import me.ktpark.websvc.base.extension.TransactionSpec;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Controller
public class BaseViewController implements ApplicationContextAware {

    private ApplicationContext applicationContext;
    private Map<String, Object> serviceMap;

    // String decoded = URLDecoder.decode(s, StandardCharsets.UTF_8);
    // String encoded = URLEncoder.encode(result, StandardCharsets.UTF_8);

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
        serviceMap = this.applicationContext.getBeansWithAnnotation(TransactionSpec.class);

        serviceMap.entrySet().forEach((set) -> {
            System.out.println("serviceMap : " + set.getKey() + " / " + set.getValue());
        });
    }

    @RequestMapping("/{path1}")
    public String baseViewPage1(@PathVariable String path1, @RequestParam Map<String, Object> param, ModelMap modelMap) {

        DefaultTransactionData defaultTransactionData = applicationContext.getBean(DefaultTransactionData.class).build();

        defaultTransactionData.putRequestParam(param);

        DefaultTransactionService transactionService = (DefaultTransactionService) serviceMap.get(path1);

        if (transactionService != null) {
            transactionService.doService(defaultTransactionData);
        }

        modelMap.put("bodyReq", defaultTransactionData.getRequestParam());
        modelMap.put("bodyRes", defaultTransactionData.getResponseParam());

        return String.format("/websvc/%s", path1);
    }

    @RequestMapping("/{path1}/{path2}")
    public String baseViewPage2(@PathVariable String path1, @PathVariable String path2, @RequestParam Map<String, Object> param, ModelMap modelMap) {

        DefaultTransactionData defaultTransactionData = applicationContext.getBean(DefaultTransactionData.class).build();

        defaultTransactionData.putRequestParam(param);

        DefaultTransactionService transactionService = (DefaultTransactionService) serviceMap.get(path2);

        if (transactionService != null) {
            transactionService.doService(defaultTransactionData);
        }

        modelMap.put("bodyReq", defaultTransactionData.getRequestParam());
        modelMap.put("bodyRes", defaultTransactionData.getResponseParam());

        return String.format("/websvc/%s/%s", path1, path2);
    }

    @RequestMapping("/{path1}/{path2}/{path3}")
    public String baseViewPage3(@PathVariable String path1, @PathVariable String path2, @PathVariable String path3, @RequestParam Map<String, Object> param, ModelMap modelMap) {

        DefaultTransactionData defaultTransactionData = applicationContext.getBean(DefaultTransactionData.class).build();

        defaultTransactionData.putRequestParam(param);

        DefaultTransactionService transactionService = (DefaultTransactionService) serviceMap.get(path3);

        if (transactionService != null) {
            transactionService.doService(defaultTransactionData);
        }

        modelMap.put("bodyReq", defaultTransactionData.getRequestParam());
        modelMap.put("bodyRes", defaultTransactionData.getResponseParam());

        return String.format("/websvc/%s/%s/%s", path1, path2, path3);
    }

}