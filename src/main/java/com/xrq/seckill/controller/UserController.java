package com.xrq.seckill.controller;

import com.sun.org.apache.regexp.internal.RE;
import com.xrq.seckill.controller.vo.UserVo;
import com.xrq.seckill.dao.UserDOMapper;
import com.xrq.seckill.service.UserService;
import com.xrq.seckill.service.model.UserModel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @program: seckill
 * @author: rqxiao
 * @create: 2018-12-06 16:40
 **/

@Controller("user")
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping("/get")
    @ResponseBody
    public UserVo getUser(@RequestParam(name = "id") Integer id) {
        UserModel userModel = userService.getUserById(id);
        return convertFromModel(userModel);
    }

    private UserVo convertFromModel(UserModel userModel) {
        if (userModel == null) {
            return null;
        }
        UserVo userVo = new UserVo();
        BeanUtils.copyProperties(userModel, userVo);
        return userVo;
    }

}
