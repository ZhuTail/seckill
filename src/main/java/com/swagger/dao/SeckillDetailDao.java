package com.swagger.dao;

import com.swagger.entity.SeckillDetail;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/3/30.
 */
public interface SeckillDetailDao {

    
	int insertDetail(SeckillDetail seckollDetail);
	
	/**
     * 根据Id获得秒杀明细
     * @param seckillId
     * @param createTime
     * @return
     */
    SeckillDetail queryByIdWithSeckill(long seckillId);
    
}
