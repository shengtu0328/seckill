package com.xrq.seckill.service.impl;

import com.xrq.seckill.dao.UserDOMapper;
import com.xrq.seckill.dao.UserPasswordDOMapper;
import com.xrq.seckill.dataobject.UserDO;
import com.xrq.seckill.dataobject.UserPasswordDO;
import com.xrq.seckill.service.UserService;
import com.xrq.seckill.service.model.UserModel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: seckill
 * @author: rqxiao
 * @create: 2018-12-06 16:43
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDOMapper userDOMapper;

    @Autowired
    private UserPasswordDOMapper userPasswordDOMapper;

    @Override
    public UserModel getUserById(Integer id) {
        UserDO userDO = userDOMapper.selectByPrimaryKey(id);
        if(userDO==null){
            return null;
        }
        UserPasswordDO userPasswordDO=userPasswordDOMapper.selectByUserId(userDO.getId());
        return convertFromDataObject(userDO,userPasswordDO);
    }

    private UserModel convertFromDataObject(UserDO userDO, UserPasswordDO userPasswordDO){
        if(userDO==null){
            return null;
        }
        UserModel userModel= new UserModel();
        BeanUtils.copyProperties(userDO,userModel);

        if(userPasswordDO!=null){
            userModel.setEncrptPassword(userPasswordDO.getEncrptPassword());
        }
        return userModel;

    }
}
