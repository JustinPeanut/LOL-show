package com.peanut.entity.po;

public class PlanPO {
    private Integer id;

    private String planDate;

    private String planEvent;

    private Integer lastTime;

    private Integer memberId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPlanDate() {
        return planDate;
    }

    public void setPlanDate(String planDate) {
        this.planDate = planDate == null ? null : planDate.trim();
    }

    public String getPlanEvent() {
        return planEvent;
    }

    public void setPlanEvent(String planEvent) {
        this.planEvent = planEvent == null ? null : planEvent.trim();
    }

    public Integer getLastTime() {
        return lastTime;
    }

    public void setLastTime(Integer lastTime) {
        this.lastTime = lastTime;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    @Override
    public String toString() {
        return "PlanPO{" +
                "id=" + id +
                ", planDate='" + planDate + '\'' +
                ", planEvent='" + planEvent + '\'' +
                ", lastTime=" + lastTime +
                ", memberId=" + memberId +
                '}';
    }
}