package com.miaoshaproject.controller;

import com.miaoshaproject.error.BusinessException;
import com.miaoshaproject.error.EmBussinessError;
import com.miaoshaproject.response.CommonReturnType;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Lion test log
 * @date 2019/8/14 17:39
 * @Version 1.0
 */
public class BaseController {

    public static final String CONTENT_TYPE_FORMED = "application/x-www-form-urlencoded";

    //定义exceptionhandler解决未被controller层吸收的exception
//    @ExceptionHandler(Exception.class)
//    @ResponseStatus(HttpStatus.OK)
//    @ResponseBody
//    public Object handlerException(HttpServletRequest request, Exception ex){
//        Map<String,Object> responseData = new HashMap<>();
//        //判断异常是否为BusinessException
//        if (ex instanceof BusinessException){
//            //强转为businessException
//            BusinessException businessException = (BusinessException)ex;
//
//            responseData.put("errCode",businessException.getErrCode());
//            responseData.put("errMsg",businessException.getErrMsg());
//        }else {
//            responseData.put("errCode", EmBussinessError.UNKNOWN_ERROR.getErrCode());
//            responseData.put("errMsg",EmBussinessError.UNKNOWN_ERROR.getErrMsg());
//        }
//
//        //打印异常信息
//        ex.printStackTrace();
//        return CommonReturnType.create(responseData,"fail");
//    }

}
