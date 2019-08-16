package com.miaoshaproject.service.impl;

import com.miaoshaproject.dao.UserDOMapper;
import com.miaoshaproject.dao.UserPasswordDOMapper;
import com.miaoshaproject.dataobject.UserDO;
import com.miaoshaproject.dataobject.UserPasswordDO;
import com.miaoshaproject.error.BusinessException;
import com.miaoshaproject.error.EmBussinessError;
import com.miaoshaproject.service.UserService;
import com.miaoshaproject.service.model.UserModel;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDOMapper userDOMapper;

    @Autowired
    private UserPasswordDOMapper userPasswordDOMapper;


    /**
     * 获取用户信息
     * Created by 刘家辉 on 2019/8/15 17:18
     */
    @Override
    public UserModel getUserById(Integer id) {
        //调用userdomapper获取对用的用户信息
        UserDO userDO = userDOMapper.selectByPrimaryKey(id);

        if (userDO == null){
            return null;
        }

        //根据用户id获取对应的用户加密密码信息
        UserPasswordDO userPasswordDO = userPasswordDOMapper.selectByUserId(userDO.getId());

        return convertFromDateObject(userDO,userPasswordDO);

    }

    /**
     * 用户注册实现
     * Created by 刘家辉 on 2019/8/15 17:13
     */
    @Override
    @Transactional
    public void register(UserModel userModel) throws BusinessException {
        if (userModel == null){
            throw new BusinessException(EmBussinessError.PARAMETER_VALIDATION_ERROR);
        }
        if (StringUtils.isEmpty(userModel.getName())
            || userModel.getAge() == null
            || userModel.getGender() == null
            || StringUtils.isEmpty(userModel.getTelphone())){
            throw new BusinessException(EmBussinessError.PARAMETER_VALIDATION_ERROR);
        }

        //实现model-->dataobject
        UserDO userDO = converFromModel(userModel);

        userDOMapper.insertSelective(userDO);

        UserPasswordDO userPasswordDO = converPassWordFromModel(userModel);

        userPasswordDOMapper.insertSelective(userPasswordDO);


    }

    private UserPasswordDO converPassWordFromModel(UserModel userModel){
        if (userModel == null){
            return null;
        }

        UserPasswordDO userPasswordDO = new UserPasswordDO();
        userPasswordDO.setEncrptPassword(userModel.getEncrptPassword());
        userPasswordDO.setUserId(userModel.getId());
        return userPasswordDO;
    }

    private UserDO converFromModel(UserModel userModel){

        if (userModel == null){
            return null;
        }
        UserDO userDO = new UserDO();
        BeanUtils.copyProperties(userModel,userDO);
        return userDO;

    }

    /**
     * 组装userModel
     * @param userDO
     * @param userPasswordDO
     * @return
     */
    private UserModel convertFromDateObject(UserDO userDO, UserPasswordDO userPasswordDO){

        if (userDO == null){
            return null;
        }

        UserModel userModel = new UserModel();
        BeanUtils.copyProperties(userDO,userModel);

        if (userPasswordDO != null){
            userModel.setEncrptPassword(userPasswordDO.getEncrptPassword());
        }


        return userModel;
    }
}
