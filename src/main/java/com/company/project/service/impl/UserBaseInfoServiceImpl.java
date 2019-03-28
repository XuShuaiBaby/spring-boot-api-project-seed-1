package com.company.project.service.impl;

import com.company.project.dao.UserBaseInfoMapper;
import com.company.project.model.UserBaseInfo;
import com.company.project.service.UserBaseInfoService;
import com.company.project.core.AbstractService;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2018/12/21.
 */
@Service
public class UserBaseInfoServiceImpl extends AbstractService<UserBaseInfo> implements UserBaseInfoService {
    @Resource
    private UserBaseInfoMapper userBaseInfoMapper;

    @Override
    @Delete("delete * from user_info")
    public void save(UserBaseInfo userBaseInfo) {
        userBaseInfoMapper.insert(userBaseInfo);
    }

    @Override
    public void update(UserBaseInfo userBaseInfo) {
        userBaseInfoMapper.updateByPrimaryKeySelective(userBaseInfo);
    }

}
