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
        dao.insertDetail(1001L,15665412278L);
    }

    @Test
    public void testQueryByIdWithSeckill() {
        SeckillDetail queryByIdWithSeckill = dao.queryByIdWithSeckill(1000);
        System.out.println(queryByIdWithSeckill.getSeckill().getName());
    }

}
