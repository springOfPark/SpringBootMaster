package me.ktpark.websvc.base.service;

import me.ktpark.websvc.base.extension.DefaultTransactionData;
import me.ktpark.websvc.base.extension.ServiceManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubTestService {

    @Autowired
    private ServiceManager serviceManager;

    @Autowired
    private DefaultTransactionData defaultTransactionData;

    public void ready() {

        // defaultTransactionData = serviceManager.getDefaultTransactionData();
        System.out.println(defaultTransactionData);
        System.out.println(defaultTransactionData.getBody());

    }

}
