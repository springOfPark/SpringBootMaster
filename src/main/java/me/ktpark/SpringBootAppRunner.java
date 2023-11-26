package me.ktpark;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class SpringBootAppRunner implements ApplicationRunner {

    @Autowired
    Environment environment;

    @Override
    public void run(ApplicationArguments args) throws Exception {

    }
}
