package com.swagger.exception;

/**
 * 秒杀异常
 * Created by zzhu8 on 2017/4/2.
 */
public class SeckillException extends RuntimeException{
    public SeckillException() {
        super();
    }

    public SeckillException(String message, Throwable cause) {
        super(message, cause);
    }
}
