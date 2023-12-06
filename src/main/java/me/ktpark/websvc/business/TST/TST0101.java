package me.ktpark.websvc.business.TST;

import me.ktpark.websvc.base.extension.DefaultTransactionData;
import me.ktpark.websvc.base.extension.DefaultTransactionService;
import me.ktpark.websvc.base.extension.ServiceManager;
import me.ktpark.websvc.base.extension.TransactionSpec;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

@TransactionSpec
public class TST0101 extends DefaultTransactionService {

    @Autowired
    private ServiceManager serviceManager;

    @Override
    public void doService(DefaultTransactionData transactionData) {

        Map<String, Object> param = transactionData.getRequestParam();
        Map<String, Object> res = transactionData.getResponseParam();

        res.put("resultString", "결과 값 세팅합니다.");
        res.put("resultMap", Map.of("name", "Park Kyung Taek", "movie", "Harry Poter"));

        serviceManager.serviceManagerTest();
        serviceManager.getCurrentTransactionData();

    }
}
