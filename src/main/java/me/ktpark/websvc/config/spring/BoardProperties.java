package me.ktpark.websvc.config.spring;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("board")
public class BoardProperties {

    private Boolean isAvailable;
    private Integer canWriteCommentCount;
    private Integer maxCount;
    private Boolean hasSecret;

    public Boolean getIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(Boolean available) {
        isAvailable = available;
    }

    public Integer getCanWriteCommentCount() {
        return canWriteCommentCount;
    }

    public void setCanWriteCommentCount(Integer canWriteCommentCount) {
        this.canWriteCommentCount = canWriteCommentCount;
    }

    public Integer getMaxCount() {
        return maxCount;
    }

    public void setMaxCount(Integer maxCount) {
        this.maxCount = maxCount;
    }

    public Boolean getHasSecret() {
        return hasSecret;
    }

    public void setHasSecret(Boolean hasSecret) {
        this.hasSecret = hasSecret;
    }

    @Override
    public String toString() {
        return "BoardProperties{" +
                "isAvailable=" + isAvailable +
                ", canWriteCommentCount=" + canWriteCommentCount +
                ", maxCount=" + maxCount +
                ", hasSecret=" + hasSecret +
                '}';
    }
}
