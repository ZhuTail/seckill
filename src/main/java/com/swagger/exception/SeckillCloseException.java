package com.swagger.exception;

/**
 * 秒杀结束异常
 * Created by zzhu8 on 2017/4/2.
 */
public class SeckillCloseException extends SeckillException{
    public SeckillCloseException(String message) {
        super(message);
    }

    public SeckillCloseException(String message, Throwable cause) {
        super(message, cause);
    }
}
