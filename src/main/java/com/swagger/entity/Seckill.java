package com.swagger.entity;

import java.util.Date;

/**
 * Created by Administrator on 2017/3/30.
 */
public class Seckill {

    private Long SeckillId;

    private String name;

    private Long number;

    private Date startTime;

    private Date endTime;

    private Date createTime;

    public Long getSeckillId() {
        return SeckillId;
    }

    public void setSeckillId(Long seckillId) {
        SeckillId = seckillId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Seckill{" +
                "SeckillId=" + SeckillId +
                ", name='" + name + '\'' +
                ", number=" + number +
                ", startTome=" + startTime +
                ", endTime=" + endTime +
                ", createTime=" + createTime +
                '}';
    }
}
