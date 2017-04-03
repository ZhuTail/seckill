package com.swagger.service;

import com.swagger.dto.Exposer;
import com.swagger.dto.SeckillExecution;
import com.swagger.entity.Seckill;

import java.util.List;

/**
 * 秒杀业务接口
 * 站在使用者的角度设计接口，参数尽可能简单，返回尽可能直观
 * <p>
 * Created by zzhu8 on 2017/4/2.
 */
public interface SeckillService {

    /**
     * 获得所有的秒杀业务
     *
     * @return
     */
    public List<Seckill> queryAll();

    /**
     * 根据ID获得秒杀对象
     *
     * @param seckillId
     * @return
     */
    public Seckill queryById(long seckillId);


    /**
     * 获得秒杀地址
     * @param seckillId
     * @return
     */
    Exposer exportSeckillUrl(long seckillId);

    /**
     * 执行秒杀
     * @param seckillId
     * @param userPhone
     * @param md5
     * @return
     */
    SeckillExecution executeSeckill(long seckillId, long userPhone, String md5);


}
