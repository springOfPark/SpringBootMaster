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
    DefaultTransactionData defaultTransactionData;

}
