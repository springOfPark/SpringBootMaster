package me.ktpark.websvc.base.service;

import me.ktpark.websvc.base.extension.DefaultTransactionData;
import me.ktpark.websvc.base.extension.DefaultTransactionService;
import me.ktpark.websvc.base.extension.ServiceManager;
import me.ktpark.websvc.base.extension.TransactionSpec;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

@TransactionSpec
public class TST01 extends DefaultTransactionService {

    @Autowired
    private SubTestService subTestService;

    @Autowired
    private ServiceManager serviceManager;

    @Override
    public void doService(DefaultTransactionData defaultTransactionData) {

        System.out.println("TST01 ==> do Service");
        Map<String, Object> param = defaultTransactionData.getRequestParam();
        System.out.println(param);
        System.out.println("TST01 ==> do Service End");

        System.out.println("TST01 ==> CALL OTHER SERVICE");
        subTestService.ready();

    }

}
