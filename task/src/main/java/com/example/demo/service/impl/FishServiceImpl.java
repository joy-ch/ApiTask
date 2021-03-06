 /*
  * Copyright 2018 tuhu.cn All right reserved. This software is the
  * confidential and proprietary information of tuhu.cn ("Confidential
  * Information"). You shall not disclose such Confidential Information and shall
  * use it only in accordance with the terms of the license agreement you entered
  * into with Tuhu.cn
  */
 package com.example.demo.service.impl;

 import com.example.demo.dao.FishMapper;
 import com.example.demo.entity.Fish;
 import com.example.demo.service.FishService;
 import com.github.pagehelper.Page;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.stereotype.Service;

 import java.util.List;

 /**
  * @auther chendesheng
  * @date 2018/8/24
  */
 @Service
 public class FishServiceImpl implements FishService {
     
     @Autowired
     FishMapper fishMapper;
     
     @Override
     public List<Fish> listAllFish(int pageNum, int pageSize) {
         return fishMapper.listFish(pageNum,pageSize);
     }
    
     @Override
     public Page<Fish> list() {
         return fishMapper.list();
     }
    
     @Override
     public int insertFish(Fish fish) {
         
         return fishMapper.insert(fish);
     }
    
     @Override
     public int count() {
         return fishMapper.countFish();
     }
    
     @Override
     public int updateFishById(String name, Integer id) {
         return fishMapper.updateStatement(name,id);
     }
    
     @Override
     public List<Fish> select(String name, String publishName, int pageIndex, int pageSize) {
         return fishMapper.selectFish(name,publishName,pageIndex,pageSize);
     }
 }
