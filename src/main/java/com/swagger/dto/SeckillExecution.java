package com.swagger.dto;

import com.swagger.entity.SeckillDetail;
import com.swagger.enums.SeckillStateEnum;

/**
 * 秒杀成功
 * Created by zzhu8 on 2017/4/2.
 */
public class SeckillExecution {

    public Long seckillId;;

    public int state;

    public String stateInfo;

    public SeckillDetail seckillDetail;

    public SeckillExecution(Long seckillId, SeckillStateEnum stateEnum, SeckillDetail seckillDetail) {
        this.seckillId = seckillId;
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
        this.seckillDetail = seckillDetail;
    }

    public SeckillExecution(Long seckillId,SeckillStateEnum stateEnum) {
        this.seckillId = seckillId;
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
    }

    public Long getSeckillId() {

        return seckillId;
    }

    public void setSeckillId(Long seckillId) {
        this.seckillId = seckillId;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }

    public SeckillDetail getSeckillDetail() {
        return seckillDetail;
    }

    public void setSeckillDetail(SeckillDetail seckillDetail) {
        this.seckillDetail = seckillDetail;
    }

    @Override
    public String toString() {
        return "SeckillExecution{" +
                "seckillId=" + seckillId +
                ", state=" + state +
                ", stateInfo='" + stateInfo + '\'' +
                ", seckillDetail=" + seckillDetail +
                '}';
    }
}
