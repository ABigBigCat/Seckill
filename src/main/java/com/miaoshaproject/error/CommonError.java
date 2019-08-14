package com.miaoshaproject.error;

/**
 * Created by 刘家辉 on 2019/8/14 14:46
 */
public interface CommonError {
    public int getErrCode();
    public String getErrMsg();
    public CommonError setErrMsg(String errMsg);


}
