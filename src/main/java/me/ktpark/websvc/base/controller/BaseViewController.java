package me.ktpark.websvc.base.controller;

import me.ktpark.websvc.base.extension.DefaultTransactionData;
import me.ktpark.websvc.base.extension.DefaultTransactionService;
import me.ktpark.websvc.base.extension.TransactionSpec;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
@RequestMapping("/websvc")
public class BaseViewController implements ApplicationContextAware {

    private ApplicationContext applicationContext;
    private Map<String, Object> serviceMap;

    @Value("${app.base.package}")
    private String basePackage;

    // String decoded = URLDecoder.decode(s, StandardCharsets.UTF_8);
    // String encoded = URLEncoder.encode(result, StandardCharsets.UTF_8);

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
        serviceMap = this.applicationContext.getBeansWithAnnotation(TransactionSpec.class);
    }

    @GetMapping("/{path1}")
    public String baseViewPage1(@PathVariable String path1, @RequestParam Map<String, Object> param, Model model) {

        DefaultTransactionData defaultTransactionData = applicationContext.getBean(DefaultTransactionData.class).build();

        defaultTransactionData.putRequestParam(param);

        String servicePkg = basePackage + "." + path1;
        DefaultTransactionService transactionService = (DefaultTransactionService) serviceMap.get(servicePkg);

        if (transactionService != null) {
            transactionService.doService(defaultTransactionData);
        }

        model.addAttribute("bodyReq", defaultTransactionData.getRequestParam());
        model.addAttribute("bodyRes", defaultTransactionData.getResponseParam());

        return String.format("/websvc/%s", path1);
    }

    @GetMapping("/{path1}/{path2}")
    public String baseViewPage2(@PathVariable String path1, @PathVariable String path2, @RequestParam Map<String, Object> param, Model model) {

        DefaultTransactionData defaultTransactionData = applicationContext.getBean(DefaultTransactionData.class).build();

        defaultTransactionData.putRequestParam(param);

        String servicePkg = basePackage + "." + path1 + "." + path2;
        DefaultTransactionService transactionService = (DefaultTransactionService) serviceMap.get(servicePkg);

        if (transactionService != null) {
            transactionService.doService(defaultTransactionData);
        }

        model.addAttribute("bodyReq", defaultTransactionData.getRequestParam());
        model.addAttribute("bodyRes", defaultTransactionData.getResponseParam());

        return String.format("/websvc/%s/%s", path1, path2);
    }

    @GetMapping("/{path1}/{path2}/{path3}")
    public String baseViewPage3(@PathVariable String path1, @PathVariable String path2, @PathVariable String path3, @RequestParam Map<String, Object> param, Model model) {

        DefaultTransactionData defaultTransactionData = applicationContext.getBean(DefaultTransactionData.class).build();

        defaultTransactionData.putRequestParam(param);

        DefaultTransactionService transactionService = (DefaultTransactionService) serviceMap.get(path3);

        if (transactionService != null) {
            transactionService.doService(defaultTransactionData);
        }

        model.addAttribute("bodyReq", defaultTransactionData.getRequestParam());
        model.addAttribute("bodyRes", defaultTransactionData.getResponseParam());

        return String.format("/websvc/%s/%s/%s", path1, path2, path3);
    }

}