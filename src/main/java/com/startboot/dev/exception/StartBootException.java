package com.startboot.dev.exception;

import com.startboot.dev.enums.TestEnum;

/**
 *
 * 统一异常处理
 *
 * Created by wdnnccey on 2018/4/13 下午2:19.
 */
public class StartBootException extends RuntimeException{


    public StartBootException(TestEnum testEnum){
        super(testEnum.getMsg());
        this.code=testEnum.getCode();

    }

    private Integer code;

    private String msg;


    public StartBootException(Integer code, String defaultMessage) {
        super(defaultMessage);
        this.code=code;

    }

}
