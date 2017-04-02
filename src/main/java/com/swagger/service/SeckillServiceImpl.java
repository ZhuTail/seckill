package com.swagger.service;

import com.swagger.dao.SeckillDao;
import com.swagger.dto.Exposer;
import com.swagger.dto.SeckillExecution;
import com.swagger.entity.Seckill;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.List;

/**
 * 秒杀service实现
 * Created by zzhu8 on 2017/4/2.
 */
public class SeckillServiceImpl implements SeckillService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private SeckillDao seckillDao;

    private static final String slat = "sasdasdasfafasawf";


    public List<Seckill> queryAll() {
        return seckillDao.queryAll(0, 4);
    }

    public Seckill queryById(Long seckillId) {
        return seckillDao.queryById(seckillId);
    }

    /**
     * 暴露秒杀接口地址
     *      使用md5加密，防止恶意秒杀
     *
     * @param seckillId
     * @return
     */
    public Exposer exportSeckillUrl(Long seckillId) {

        Seckill seckill = this.queryById(seckillId);
        if (seckill == null) {
            return new Exposer(false, seckillId);
        }

        Long now = new Date().getTime();
        Long start = seckill.getStartTome().getTime();
        Long end = seckill.getEndTime().getTime();

        //判断秒杀是否开始
        if (now < start || now > end) {
            logger.info("seckill closed");
            return new Exposer(false, seckillId, now, start, end);
        }
        return new Exposer(true,getMD5(seckillId),seckillId);
    }


    /**
     * md5加密
     * @param seckillId
     * @return
     */
    private String getMD5(Long seckillId) {

        String base = seckillId+"/"+slat;
        String md5 = DigestUtils.md5DigestAsHex(base.getBytes());
        return md5;
    }

    /**
     * 执行秒杀
     * @param seckillId
     * @param userPhones
     * @param md5
     * @return
     */
    public SeckillExecution executeSeckill(Long seckillId, Long userPhones, String md5) {

        if (md5==null||!md5.equals(this.getMD5(seckillId))){
            return new SeckillExecution(seckillId,-1,"秒杀失败");
        }



        return null;
    }
}
