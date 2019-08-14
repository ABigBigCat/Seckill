package com.miaoshaproject.response;

public class CommonReturnType {

    //表名对应请求的返回处理结果 “success” 或 “fail”
    private String status;

    //若status=success，data返回前端需要的json
    //若status=fail，data返回通用的错误码格式
    private Object data;

    //定义一个通用的创建方法
    public static CommonReturnType create(Object result){
        return create(result,"success");
    }

    public static CommonReturnType create(Object result,String status){
        CommonReturnType commonReturnType = new CommonReturnType();
        commonReturnType.setStatus(status);
        commonReturnType.setData(result);
        return commonReturnType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
