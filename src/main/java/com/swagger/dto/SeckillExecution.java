package com.swagger.dto;

import com.swagger.entity.SeckillDetail;

/**
 * 秒杀成功
 * Created by zzhu8 on 2017/4/2.
 */
public class SeckillExecution {

    public Long seckillId;;

    public int state;

    public String stateInfo;

    public SeckillDetail seckillDetail;

    public SeckillExecution(Long seckillId, int state, String stateInfo, SeckillDetail seckillDetail) {
        this.seckillId = seckillId;
        this.state = state;
        this.stateInfo = stateInfo;
        this.seckillDetail = seckillDetail;
    }

    public SeckillExecution(Long seckillId, int state, String stateInfo) {
        this.seckillId = seckillId;
        this.state = state;
        this.stateInfo = stateInfo;
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
}
