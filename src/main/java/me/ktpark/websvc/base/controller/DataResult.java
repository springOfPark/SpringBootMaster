package me.ktpark.websvc.base.controller;

import org.springframework.http.HttpStatus;

public class DataResult {

    private String resultYn;
    private HttpStatus httpStatus;
    private Boolean isError;

    @Override
    public String toString() {
        return "DataResult{" +
                "resultYn='" + resultYn + '\'' +
                ", httpStatus=" + httpStatus +
                ", isError=" + isError +
                '}';
    }

    public String getResultYn() {
        return resultYn;
    }

    public void setResultYn(String resultYn) {
        this.resultYn = resultYn;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public Boolean getError() {
        return isError;
    }

    public void setError(Boolean error) {
        isError = error;
    }
}
