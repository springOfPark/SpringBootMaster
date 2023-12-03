package me.ktpark.websvc.config.session;

import me.ktpark.websvc.utils.SessionUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@Component
public class SessionListener implements HttpSessionListener {

    @Autowired
    private SessionUtility sessionUtility;

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        se.getSession().setMaxInactiveInterval(1200);
        sessionUtility.printSessionInfo(se.getSession());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println(":::::::::::::::::::::::: 세션 DESTROYED ::::::::::::::::::::::::");
        HttpSessionListener.super.sessionDestroyed(se);
    }
}
