package com.swagger.dao;

import javax.annotation.Resource;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.swagger.entity.Seckill;

/**
 * Created by Administrator on 2017/3/30.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class SeckillDaoTest {

	@Resource
	private SeckillDao seckillDao;
	
    @org.junit.Test
    public void queryById() throws Exception {

    	long id = 1000;
    	Seckill seckill = seckillDao.queryById(id);
    	System.out.println(seckill.toString());
    }

    @org.junit.Test
    public void queryAll() throws Exception {

    }

    @org.junit.Test
    public void redurceSeckoll() throws Exception {

    }

}