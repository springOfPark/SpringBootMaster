package me.ktpark.websvc.config.session;

import me.ktpark.websvc.utils.SessionUtility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Component
public class SessionListener implements HttpSessionListener {

    static final Logger log = LoggerFactory.getLogger(SessionListener.class);

    @Autowired
    private SessionUtility sessionUtility;

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        se.getSession().setMaxInactiveInterval(125);
        sessionUtility.printSessionInfo(se.getSession());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        HttpSession session = se.getSession();

        long creationTime = session.getCreationTime();
        long lastAccessedTime = session.getLastAccessedTime();
        LocalDateTime sessionCreateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(creationTime), ZoneId.systemDefault());
        LocalDateTime sessionLastAccessedTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(lastAccessedTime), ZoneId.systemDefault());

        System.out.println("소멸 세션 ID : " + session.getId() + " ==> Created In " + sessionCreateTime + " ==> Destroyed In " + LocalDateTime.now());
        System.out.println("Last AccessedTime : " + sessionLastAccessedTime);
        System.out.println(":::::::::::::::::::::::: 세션 DESTROYED ::::::::::::::::::::::::");
    }
}
