package me.ktpark.websvc.base.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

public class Event {

    /* Using @Valid 를 위해서 spring boot starter validation 의존성 추가가 필요하다 */
    @Min(0)
    private Integer eventId;
    @NotEmpty
    private String eventName;
    private String eventDesc;

    public Integer getEventId() {
        return eventId;
    }

    public void setEventId(Integer eventId) {
        this.eventId = eventId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventDesc() {
        return eventDesc;
    }

    public void setEventDesc(String eventDesc) {
        this.eventDesc = eventDesc;
    }
}
