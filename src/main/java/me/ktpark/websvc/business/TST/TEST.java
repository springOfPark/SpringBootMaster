package me.ktpark.websvc.business.TST;

import me.ktpark.websvc.base.extension.DefaultTransactionData;
import me.ktpark.websvc.base.extension.DefaultTransactionService;
import me.ktpark.websvc.base.extension.TransactionSpec;
import me.ktpark.websvc.define.TEST_ENUM;

import java.util.Map;

@TransactionSpec
public class TEST extends DefaultTransactionService {

    @Override
    public void doService(DefaultTransactionData transactionData) {

        Map<String, Object> res = transactionData.getResponseParam();

        String sessionId = "P0004801";
        String reqReqEno = "P0004801";
        String regDprtCd = "007500";

        boolean isCanEditVer1 = TEST_ENUM.checkDayEditYn(sessionId, reqReqEno, regDprtCd);
        boolean isCanEditVer2 = TEST_ENUM.checkDayEditYnWithToday(sessionId, reqReqEno, regDprtCd, "2023-12-11");

        res.put("isCanEditVer1", isCanEditVer1);
        res.put("isCanEditVer2", isCanEditVer2);

    }
}
