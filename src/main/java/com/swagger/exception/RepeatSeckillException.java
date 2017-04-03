package com.swagger.exception;

/**
 * 重覅秒杀异常
 *      Spring的声明式事物只在出现运行时异常的时候才会回滚
 * Created by zzhu8 on 2017/4/2.
 */
public class RepeatSeckillException extends SeckillException{

    public RepeatSeckillException(String message) {
        super(message);
    }

    public RepeatSeckillException(String message, Throwable cause) {
        super(message, cause);
    }
}
