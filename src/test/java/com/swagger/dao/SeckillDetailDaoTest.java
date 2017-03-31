package com.swagger.dao;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.swagger.entity.SeckillDetail;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class SeckillDetailDaoTest {

    @Resource
    private SeckillDetailDao dao;

    @Test
    public void testInsertDetail() {
        SeckillDetail seckollDetail = new SeckillDetail();
        seckollDetail.setSeckillId(1001L);
        seckollDetail.setUserPhone(15665412278L);
        dao.insertDetail(seckollDetail);
    }

    @Test
    public void testQueryByIdWithSeckill() {
        SeckillDetail queryByIdWithSeckill = dao.queryByIdWithSeckill(1001);
        System.out.println(queryByIdWithSeckill.getSeckill().getName());
    }

}
