package com.xrq.seckill.response;

import lombok.Data;

/**
 * @program: seckill
 * @author: rqxiao
 * @create: 2018-12-07 10:54
 **/
@Data
public class CommonReturnType {

    //success 或者 fail
    private String status;

    //status=success  data返回前端需要的json数据
    //status=fail     data返回通用的错误码格式
    private Object data;

    public static CommonReturnType create(Object result){
        return CommonReturnType.create(result,"success");
    }

    public static CommonReturnType create(Object result,String status){
        CommonReturnType commonReturnType=new CommonReturnType();
        commonReturnType.setData(result);
        commonReturnType.setStatus(status);
        return commonReturnType;
    }


}
