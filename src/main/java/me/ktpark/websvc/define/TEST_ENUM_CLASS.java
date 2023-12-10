package me.ktpark.websvc.define;

import org.springframework.stereotype.Service;

@Service
public class TEST_ENUM_CLASS {

    public enum TestInsideEnum {

        SPIRNG,
        SUMMER,
        FALL,
        WINTER

    }

    public TestInsideEnum getSpring() {
        return TestInsideEnum.SPIRNG;
    }

    public TestInsideEnum getSummer() {
        return TestInsideEnum.SUMMER;
    }
    public TestInsideEnum getFall() {
        return TestInsideEnum.FALL;
    }
    public TestInsideEnum getWinter() {
        return TestInsideEnum.WINTER;
    }
}
