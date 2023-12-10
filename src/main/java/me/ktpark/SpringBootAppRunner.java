package me.ktpark;

import me.ktpark.websvc.define.TEST_ENUM_CLASS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class SpringBootAppRunner implements ApplicationRunner {

    @Autowired
    private TEST_ENUM_CLASS testEnumClass;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        TEST_ENUM_CLASS testEnumClass = new TEST_ENUM_CLASS();
        TEST_ENUM_CLASS.TestInsideEnum spring = testEnumClass.getSpring();
        System.out.println(spring);

        System.out.println(testEnumClass.getWinter());

    }
}
