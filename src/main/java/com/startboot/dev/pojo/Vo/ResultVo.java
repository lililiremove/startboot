package com.startboot.dev.pojo.Vo;

/**
 * Created by wdnnccey on 2018/4/13 下午2:00.
 */

//@Data
public class ResultVo<T> {

    private Integer code;

    private String msg;

    private T Data;

//    public static ResultVo sendSuccess(){
//        ResultVo resultVo = new ResultVo();
//        return ResultVo;
//    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return Data;
    }

    public void setData(T data) {
        Data = data;
    }

    @Override
    public String toString() {
        return "ResultVo{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", Data=" + Data +
                '}';
    }
}
