 /*
  * Copyright 2019 tuhu.cn All right reserved. This software is the
  * confidential and proprietary information of tuhu.cn ("Confidential
  * Information"). You shall not disclose such Confidential Information and shall
  * use it only in accordance with the terms of the license agreement you entered
  * into with Tuhu.cn
  */
 package com.example.demo.service.impl;


 import com.example.demo.core.universal.AbstractService;
 import com.example.demo.dao.UserInfoMapper;
 import com.example.demo.entity.UserInfo;
 import com.example.demo.service.UserInfoService;
 import lombok.extern.slf4j.Slf4j;
 import org.hibernate.service.spi.ServiceException;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.stereotype.Service;

 import java.util.List;


 /**
  * @author chendesheng chendesheng@tuhu.cn
  * @since 2019/5/6 10:05
  */
 @Service
 @Slf4j
 public class UserInfoServiceImpl extends AbstractService<UserInfo> implements UserInfoService {
     
     @Autowired
     UserInfoMapper userInfoMapper;
     @Override
     public List<UserInfo> selectAlla(int pageNum, int pageSize) {
         return userInfoMapper.selectAll(pageNum,pageSize);
     }
    
     
     public UserInfo selectById(Integer id){
         UserInfo userInfo = userInfoMapper.selectByPrimaryKey(id);
         log.info("得到:[{}]",userInfo);
         if (userInfo==null){
             throw new ServiceException("暂无该用户");
         }
         return userInfo;
     }
    
     
 }
