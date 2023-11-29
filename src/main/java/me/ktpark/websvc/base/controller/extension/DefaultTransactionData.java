package me.ktpark.websvc.base.controller.extension;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class DefaultTransactionData {

    Map<String, Object> paramPath = new HashMap<>();
    Map<String, Object> resultPath = new HashMap<>();

    public void printDefaultTransactionDataClass() {
        System.out.println("defaultTransactionData : " + this);
    }

    public DefaultTransactionData build() {

        paramPath.put("/body/request/param", new HashMap<>());
        resultPath.put("/body/response/result", new HashMap<>());

        return this;

    }

    public void putRequestParam(Map<String, Object> param) {

        Map<String, Object> requestParam = (Map<String, Object>) paramPath.get("/body/request/param");
        requestParam.putAll(param);

    }

    public Map<String, Object> getRequestParam() {

        Map<String, Object> requestParam = (Map<String, Object>) paramPath.get("/body/request/param");
        return requestParam;

    }


}
