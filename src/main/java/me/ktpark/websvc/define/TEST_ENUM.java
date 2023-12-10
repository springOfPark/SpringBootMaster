package me.ktpark.websvc.define;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum TEST_ENUM {

    DEFAULT("NONE", "NONE")
    , P0004801("007500", "007500")
    , P0004781("112000", "112000")
    , P0004778("600000", "600000")
    ;

    TEST_ENUM(String dprtCd, String testName) {
        this.dprtCd = dprtCd;
        this.testName = testName;
    }

    private final String dprtCd;
    private final String testName;

    // CREATE CACHE ENUM MAP
    private static final Map<String, TEST_ENUM> cacheTestEnumMap = Collections.unmodifiableMap(
            Stream.of(TEST_ENUM.values()).collect(Collectors.toMap(TEST_ENUM::name, Function.identity()))
    );

    private static Logger logger = LoggerFactory.getLogger(TEST_ENUM.class);

    public static TEST_ENUM findByKey(String sessionId) {
        return Optional.ofNullable(cacheTestEnumMap.get(sessionId)).orElse(TEST_ENUM.DEFAULT);
    }

    public static boolean checkDayEditYn(String sessionId, String regId, String regDprtCd) {

        TEST_ENUM testEnum = findByKey(sessionId);

        boolean manageYn = regDprtCd.equals(testEnum.getDprtCd());
        if (manageYn) {
            return regId.startsWith("P");
        }

        return false;

    }

    public static boolean checkDayEditYnWithToday(String sessionId, String regId, String regDprtCd, String exctDate) {

        try {

            boolean manageYn = checkDayEditYn(sessionId, regId, regDprtCd);

            String yyyyMMdd = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
            boolean isToday = yyyyMMdd.equals(exctDate.replaceAll("-", ""));

            return manageYn && isToday;

        } catch (Exception e) {
            return false;
        }

    }

    public String getDprtCd() {
        return dprtCd;
    }
}
