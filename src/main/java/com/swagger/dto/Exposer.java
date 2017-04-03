package com.swagger.dto;

/**
 * 暴露秒杀接口
 * Created by zzhu8 on 2017/4/2.
 */
public class Exposer {

    public boolean flag;

    public String md5;

    public Long seckillId;

    public Long now;

    public Long start;

    public Long end;

    public Exposer(boolean flag, String md5, Long seckillId) {
        this.flag = flag;
        this.md5 = md5;
        this.seckillId = seckillId;
    }

    public Exposer(boolean flag, Long seckillId, Long now, Long start, Long end) {
        this.flag = flag;
        this.seckillId = seckillId;
        this.now = now;
        this.start = start;
        this.end = end;
    }

    public Exposer(boolean flag, Long seckillId) {
        this.flag = flag;
        this.seckillId = seckillId;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    public Long getSeckillId() {
        return seckillId;
    }

    public void setSeckillId(Long seckillId) {
        this.seckillId = seckillId;
    }

    public Long getNow() {
        return now;
    }

    public void setNow(Long now) {
        this.now = now;
    }

    public Long getStart() {
        return start;
    }

    public void setStart(Long start) {
        this.start = start;
    }

    public Long getEnd() {
        return end;
    }

    public void setEnd(Long end) {
        this.end = end;
    }

    @Override
    public String toString() {
        return "Exposer{" +
                "flag=" + flag +
                ", md5='" + md5 + '\'' +
                ", seckillId=" + seckillId +
                ", now=" + now +
                ", start=" + start +
                ", end=" + end +
                '}';
    }
}
