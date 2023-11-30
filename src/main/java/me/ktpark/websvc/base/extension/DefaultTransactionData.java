package me.ktpark.websvc.base.extension;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.HashMap;
import java.util.Map;

@Component
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class DefaultTransactionData {

    private final Map<String, Object> header = new HashMap<>();
    private final Map<String, Object> body = new HashMap<>();
    private final Map<String, Object> tail = new HashMap<>();

    private final String DEFAULT_REQUEST_PARAM_PATH = "/request/param";
    private final String DEFAULT_RESPONSE_RESULT_PATH = "/response/result";

    public void printDefaultTransactionDataClass() {
        System.out.println("defaultTransactionData : " + this);
    }

    public DefaultTransactionData build() {

        body.put(DEFAULT_REQUEST_PARAM_PATH, new HashMap<>());
        body.put(DEFAULT_RESPONSE_RESULT_PATH, new HashMap<>());

        return this;

    }

    public void putRequestParam(Map<String, Object> param) {
        Map<String, Object> requestParam = (Map<String, Object>) body.get(DEFAULT_REQUEST_PARAM_PATH);
        requestParam.putAll(param);
    }

    public Map<String, Object> getRequestParam() {
        Map<String, Object> requestParam = (Map<String, Object>) body.get(DEFAULT_REQUEST_PARAM_PATH);
        return requestParam;
    }

    public void putResponseParam(Map<String, Object> param) {
        Map<String, Object> responseParam = (Map<String, Object>) body.get(DEFAULT_RESPONSE_RESULT_PATH);
        responseParam.putAll(param);
    }

    public Map<String, Object> getResponseParam() {
        Map<String, Object> responseParam = (Map<String, Object>) body.get(DEFAULT_RESPONSE_RESULT_PATH);
        return responseParam;
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("DefaultTransactionData ==> Post Consturct 실행 : 빈 생성 후 실행");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("DefaultTransactionData ==> Pre Destory 실행 : 요청이 끝나면 소멸");
    }

    public Map<String, Object> getBody() {
        System.out.println(this);
        System.out.println(this.body);
        return this.body;
    }
}
