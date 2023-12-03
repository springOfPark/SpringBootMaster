package me.ktpark.websvc.base.extension;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.HashMap;
import java.util.Map;

@Component
@Scope(value = "request")
public class DefaultTransactionData {

    private final Map<String, Object> header = new HashMap<>();
    private final Map<String, Object> body = new HashMap<>();

    private final String DEFAULT_REQUEST_PARAM_PATH = "/request/param";
    private final String DEFAULT_RESPONSE_RESULT_PATH = "/response/result";

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

    public Map<String, Object> getBody() {
        return this.body;
    }
}
