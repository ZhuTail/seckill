package com.swagger.service;

import com.swagger.dto.Exposer;
import com.swagger.dto.SeckillExecution;
import com.swagger.exception.RepeatSeckillException;
import com.swagger.exception.SeckillCloseException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by zzhu8 on 2017/4/3.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml", "classpath:spring/spring-service.xml"})
public class SeckillServiceTest {

    @Autowired
    private SeckillService seckillService;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void queryAll() throws Exception {
        logger.info("list={}", seckillService.queryAll());
    }

    @Test
    public void queryById() throws Exception {
        logger.info("seckill={}", seckillService.queryById(1000));
    }

    /**
     * 测试的持续性和完整性
     * @throws Exception
     */
    @Test
    public void testExecuteSeckill() throws Exception {
        Exposer exposer = seckillService.exportSeckillUrl(1000);

        if (exposer.isFlag()){
            String md5 = exposer.getMd5();
            try {
                SeckillExecution seckillExecution = seckillService.executeSeckill(exposer.getSeckillId(), 15665412278L, md5);
                logger.info("seckillExecution={}",seckillExecution);
            }catch (SeckillCloseException e){
                logger.error(e.getMessage());
            }catch (RepeatSeckillException e1){
                logger.error(e1.getMessage());
            }

        }else {
            logger.warn("exposer={}", exposer);
        }

    }


}