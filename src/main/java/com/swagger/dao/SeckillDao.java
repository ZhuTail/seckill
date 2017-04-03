package com.swagger.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.swagger.entity.Seckill;

/**
 * Created by Administrator on 2017/3/30.
 */
public interface SeckillDao {

    /**
     * 根据Id获得秒杀对象
     *
     * @param seckillId
     * @return
     */
    Seckill queryById(long seckillId);

    /**
     * 查询所有的秒杀对象
     *
     * @param offset
     * @param limit
     * @return
     */
    List<Seckill> queryAll(@Param("offset") int offset, @Param("limit") int limit);

    /**
     * 减少库存
     *
     * @param seckillId
     * @param seckillTime
     * @return
     */
    int redurceSeckill(@Param("seckillId") long seckillId, @Param("seckillTime") Date seckillTime);


}
