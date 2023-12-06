package me.ktpark.websvc.base.extension;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class ServiceManager implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public DefaultTransactionData getCurrentTransactionData() {
        DefaultTransactionData defaultTransactionData = applicationContext.getBean(DefaultTransactionData.class);
        return defaultTransactionData.build();
    }

    public void serviceManagerTest() {
        System.out.println("서비스 매니저 사용 가능합니다.");
    }


}
