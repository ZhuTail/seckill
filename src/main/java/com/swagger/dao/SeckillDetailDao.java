package com.swagger.dao;

import com.swagger.entity.SeckillDetail;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/3/30.
 */
public interface SeckillDetailDao {

	/**
	 * 插入秒杀明细
	 * @param seckillId
	 * @param userPhone
	 * @return
	 */
	int insertDetail(@Param("seckillId") long seckillId, @Param("userPhone") long userPhone);
	
	/**
     * 根据Id获得秒杀明细
     * @param seckillId
     * @return
     */
    SeckillDetail queryByIdWithSeckill(long seckillId);
    
}
