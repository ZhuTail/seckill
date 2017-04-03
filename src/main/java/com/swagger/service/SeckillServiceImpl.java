package com.swagger.service;

import com.swagger.dao.SeckillDao;
import com.swagger.dao.SeckillDetailDao;
import com.swagger.dto.Exposer;
import com.swagger.dto.SeckillExecution;
import com.swagger.entity.Seckill;
import com.swagger.entity.SeckillDetail;
import com.swagger.enums.SeckillStateEnum;
import com.swagger.exception.RepeatSeckillException;
import com.swagger.exception.SeckillCloseException;
import com.swagger.exception.SeckillException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.List;

/**
 * 秒杀service实现
 * Created by zzhu8 on 2017/4/2.
 */
@Service
public class SeckillServiceImpl implements SeckillService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private SeckillDao seckillDao;
    @Autowired
    private SeckillDetailDao seckillDetailDao;

    private static final String slat = "sasdasdasfafasawf";


    public List<Seckill> queryAll() {
        return seckillDao.queryAll(0, 4);
    }

    public Seckill queryById(long seckillId) {
        return seckillDao.queryById(seckillId);
    }

    /**
     * 暴露秒杀接口地址
     * 使用md5加密，防止恶意秒杀
     *
     * @param seckillId
     * @return
     */
    public Exposer exportSeckillUrl(long seckillId) {

        Seckill seckill = this.queryById(seckillId);
        if (seckill == null) {
            return new Exposer(false, seckillId);
        }

        Long now = new Date().getTime();
        Long start = seckill.getStartTime().getTime();
        Long end = seckill.getEndTime().getTime();

        //判断秒杀是否开始
        if (now < start || now > end) {
            logger.info("seckill closed");
            return new Exposer(false, seckillId, now, start, end);
        }
        return new Exposer(true, getMD5(seckillId), seckillId);
    }


    /**
     * md5加密
     *
     * @param seckillId
     * @return
     */
    private String getMD5(long seckillId) {

        String base = seckillId + "/" + slat;
        String md5 = DigestUtils.md5DigestAsHex(base.getBytes());
        return md5;
    }

    /**
     * 执行秒杀
     *
     * @param seckillId
     * @param userPhones
     * @param md5
     * @return
     */
    @Transactional
    public SeckillExecution executeSeckill(long seckillId, long userPhones, String md5) {

        if (md5 == null || !md5.equals(this.getMD5(seckillId))) {
            throw new SeckillException("seckill exception");
        }
        try {
            //执行秒杀：减库存。插入秒杀明细
            int updateCount = seckillDao.redurceSeckill(seckillId, new Date());
                if (updateCount <= 0) {
                throw new SeckillCloseException("seckill is closed");
            } else {
                int insertCount = seckillDetailDao.insertDetail(seckillId, userPhones);
                //采用联合主键seckillId+userPhone保证唯一性
                if (insertCount <= 0) {
                    throw new RepeatSeckillException("seckill repeat");
                } else {
                    SeckillDetail seckillDetail = seckillDetailDao.queryByIdWithSeckill(seckillId);
                    return new SeckillExecution(seckillId, SeckillStateEnum.SUCCESS, seckillDetail);
                }
            }
        }catch (SeckillCloseException e1){
            throw  e1;
        } catch (RepeatSeckillException e2){
            throw  e2;
        }catch (Exception e){
            logger.error(e.getMessage());
            //所有编译期异常转换为运行期异常
            throw new SecurityException(e.getMessage());
        }

    }
}
