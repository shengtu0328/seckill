package com.xrq.seckill.service.model;

import lombok.Data;

/**
 * @program: seckill
 * @author: rqxiao
 * @create: 2018-12-06 17:21
 **/

@Data
public class UserModel {

    private Integer id;
    private String name;
    private Byte gender;
    private Integer age;
    private String telephone;
    private String registerMode;
    private String thirdPartyId;


    private String encrptPassword;


}
