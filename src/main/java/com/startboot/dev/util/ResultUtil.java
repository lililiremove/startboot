package com.startboot.dev.util;

import com.startboot.dev.Vo.ResultVo;

/**
 * 返回结果
 * 返回类型：ResultVo<T>
 * Created by wdnnccey on 2018/4/13 下午2:02.
 */
public class ResultUtil {

    /**
     * 返回success
     * @param object
     * @return
     */
    public static ResultVo success(Object object) {
        ResultVo resultVo = new ResultVo();
        resultVo.setCode(0);
        resultVo.setMsg("请求成功");
        resultVo.setData(object);
        return resultVo;
    }

    /**
     * 无需返回值类型
     * @return
     */
    public static ResultVo success() {
        return success(null);
    }

    /**
     * 返回error
     * @param code
     * @param msg
     * @return
     */
    public static ResultVo error(Integer code, String msg) {
        ResultVo resultVo = new ResultVo();
        resultVo.setCode(code);
        resultVo.setMsg(msg);
        return resultVo;

    }

}
