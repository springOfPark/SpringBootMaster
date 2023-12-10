package me.ktpark;

import me.ktpark.websvc.define.TEST_ENUM;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class SpringBootAppRunner implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Stream<TEST_ENUM> stream = Arrays.stream(TEST_ENUM.values());

        // Collections.unmodifiableMap();
        Map<String, TEST_ENUM> collect = Stream.of(TEST_ENUM.values())
                .collect(
                        Collectors.toMap(TEST_ENUM::name, Function.identity())
                );

        collect.forEach((key, val) -> {
            System.out.println(key + " //// " + val);
        });

        Map<String, TEST_ENUM> stringTESTEnumMap = Collections.unmodifiableMap(Stream.of(TEST_ENUM.values()).collect(Collectors.toMap(TEST_ENUM::name, Function.identity())));
        stringTESTEnumMap.forEach((key, val) -> {
            System.out.println(key + " |||| " + val);
        });

    }
}
