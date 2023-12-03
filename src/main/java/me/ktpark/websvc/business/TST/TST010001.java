package me.ktpark.websvc.business.TST;

import me.ktpark.websvc.base.extension.DefaultTransactionData;
import me.ktpark.websvc.base.extension.DefaultTransactionService;
import me.ktpark.websvc.base.extension.ServiceManager;
import me.ktpark.websvc.base.extension.TransactionSpec;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

@TransactionSpec
public class TST010001 extends DefaultTransactionService {

    @Autowired
    private ServiceManager serviceManager;

    @Override
    public void doService(DefaultTransactionData defaultTransactionData) {
        Map<String, Object> responseParam = defaultTransactionData.getResponseParam();
        responseParam.put("RESULT", "Y");
        responseParam.put("SUBMIT_DESC", "SUBMIT TEST OK! GOOD JOB!");
    }
}
