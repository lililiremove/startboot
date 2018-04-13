package com.startboot.dev.enums;

import lombok.Getter;

/**
 *
 * 测试枚举类
 *
 * Created by wdnnccey on 2018/4/13 下午2:28.
 */

@Getter
public class TestEnum {

    private Integer code;

    private String msg;

    TestEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
