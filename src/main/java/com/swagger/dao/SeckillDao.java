package com.swagger.dao;

import com.swagger.entity.Seckill;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/3/30.
 */
public interface SeckillDao {

    /**
     * 根据Id获得秒杀对象
     * @param seckillId
     * @return
     */
    Seckill queryById(long seckillId);


    /**
     * 查询所有的秒杀对象
     * @param offset
     * @param lomit
     * @return
     */
    List<Seckill> queryAll(int offset,int lomit);


    /**
     * 减少库存
     * @param seckillId
     * @return
     */
    int redurceSeckoll(long seckillId);


}
