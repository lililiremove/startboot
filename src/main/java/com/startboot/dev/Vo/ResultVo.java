package com.startboot.dev.Vo;

import lombok.Data;

/**
 * Created by wdnnccey on 2018/4/13 下午2:00.
 */

@Data
public class ResultVo<T> {

    private Integer code;

    private String msg;

    private T Data;

//    public static ResultVo sendSuccess(){
//        ResultVo resultVo = new ResultVo();
//        return ResultVo;
//    }

}
