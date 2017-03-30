package com.swagger.dao;

import com.swagger.entity.SeckollDetail;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/3/30.
 */
public interface SeckillDetailDao {

    /**
     * 根据Id获得秒杀明细
     * @param seckillId
     * @param createTime
     * @return
     */
    SeckollDetail queryById(long seckillId, Date createTime);

    /**
     * 查询所有的秒杀对象
     * @param offset
     * @param lomit
     * @return
     */
    List<SeckollDetail> queryAll(int offset, int lomit);
}
