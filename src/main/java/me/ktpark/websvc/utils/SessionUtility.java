package me.ktpark.websvc.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Component
public class SessionUtility {

    static final Logger log = LoggerFactory.getLogger(SessionUtility.class);

    public void printSessionInfo(HttpSession session) {

        long creationTime = session.getCreationTime();
        long lastAccessedTime = session.getLastAccessedTime();
        LocalDateTime sessionCreateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(creationTime), ZoneId.systemDefault());
        LocalDateTime sessionLastAccessedTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(lastAccessedTime), ZoneId.systemDefault());

        System.out.println("세션이 새로 생성 되었는가? ==> " + session.isNew());
        System.out.println("세션 생성 시간 ==> " + sessionCreateTime);
        System.out.println("세션 아이디 ==> " + session.getId());
        System.out.println("세션 마지막 접근 시간 ==> " + sessionLastAccessedTime);
        System.out.println("세션 제한 시간 ==> " +  session.getMaxInactiveInterval());

        session.getAttributeNames().asIterator().forEachRemaining((attrKey) -> {
            log.info("세션 [{}] : [{}]", attrKey, session.getAttribute(attrKey));
        });

    }

}
