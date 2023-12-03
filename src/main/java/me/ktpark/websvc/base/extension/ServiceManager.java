package me.ktpark.websvc.base.extension;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class ServiceManager {

    @Autowired
    private ApplicationContext applicationContext;

    public DefaultTransactionData getCurrentTransactionData() {
        DefaultTransactionData defaultTransactionData = applicationContext.getBean(DefaultTransactionData.class);
        return defaultTransactionData;
    }

    public void serviceManagerTest() {
        System.out.println("서비스 매니저 사용 가능합니다.");
    }
}
