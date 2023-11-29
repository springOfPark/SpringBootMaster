package me.ktpark.websvc.base.service;

import me.ktpark.websvc.base.controller.extension.DefaultTransactionData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    @Autowired
    DefaultTransactionData defaultTransactionData;

    public void service() {

        System.out.println("Test Service -----------------------------------------------------");
        defaultTransactionData.printDefaultTransactionDataClass();
        System.out.println(defaultTransactionData.getRequestParam());
        System.out.println("// Test Service -----------------------------------------------------");

    }

}
