package com.swagger.entity;

import com.swagger.entity.Seckill;

import java.util.Date;

/**
 * Created by Administrator on 2017/3/30.
 */
public class SeckollDetail {

    private Long SeckillId;

    private Long userPhone;

    private int status;

    private Date createTime;

    private Seckill seckill;

    public Long getSeckillId() {
        return SeckillId;
    }

    public void setSeckillId(Long seckillId) {
        SeckillId = seckillId;
    }

    public Long getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(Long userPhone) {
        this.userPhone = userPhone;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Seckill getSeckill() {
        return seckill;
    }

    public void setSeckill(Seckill seckill) {
        this.seckill = seckill;
    }
}
