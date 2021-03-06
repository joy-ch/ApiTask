 /*
  * Copyright 2019 tuhu.cn All right reserved. This software is the
  * confidential and proprietary information of tuhu.cn ("Confidential
  * Information"). You shall not disclose such Confidential Information and shall
  * use it only in accordance with the terms of the license agreement you entered
  * into with Tuhu.cn
  */
 package com.example.demo.controller;

 import com.example.demo.core.ret.RetResponse;
import com.example.demo.core.ret.RetResult;
import com.example.demo.entity.UserInfo;
import com.example.demo.service.UserInfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

 /**
  * @author chendesheng chendesheng@tuhu.cn
  * @since 2019/5/6 10:05
  */
 @RestController
 @RequestMapping("userInfo")
 @Api(tags = {"用户操作接口"}, description = "userInfoControler")
 public class UserInfoController {
     
     @Autowired
     UserInfoService userInfoService;
    
     @PostMapping("/hello")
     public String hello() {
         return "hello SpringBoot";
     }
    
     @ApiOperation(value = "查询用户", notes = "根据用户ID查询用户")
     @ApiImplicitParams({
             @ApiImplicitParam(name = "id", value = "用户ID", required = true,
                     dataType = "String", paramType = "query")
     })
     @PostMapping("/selectById")
     @Cacheable(value = "user",key = "#id")
     public RetResult<UserInfo> selectById(@RequestParam String id) {
         UserInfo userInfo = userInfoService.selectById(id);
         return RetResponse.makeOKRsp(userInfo);
     }
    
     @PostMapping("/testException")
     public RetResult<UserInfo> testException(String id) {
         List a = null;
         a.size();
         UserInfo userInfo = userInfoService.selectById(id);
         return RetResponse.makeOKRsp(userInfo);
     }
    
     @ApiOperation(value = "查询用户", notes = "分页查询用户所有")
     @ApiImplicitParams({
             @ApiImplicitParam(name = "page", value = "当前页码",
                     dataType = "Integer", paramType = "query"),
             @ApiImplicitParam(name = "size", value = "每页显示条数",
                     dataType = "Integer", paramType = "query")
     })
     @PostMapping("/selectAll")
     public RetResult<PageInfo<UserInfo>> selectAll(@RequestParam(defaultValue = "0") Integer page,
                                                    @RequestParam(defaultValue = "0") Integer size) {
         PageHelper.startPage(page,size);
         List<UserInfo> userInfoList = userInfoService.selectAll();
         PageInfo<UserInfo> pageInfo = new PageInfo<>(userInfoList);
         return RetResponse.makeOKRsp(pageInfo);
     }
    
     @PostMapping("/selectAlla")
     public RetResult<PageInfo<UserInfo>> selectAlla(@RequestParam(defaultValue = "0") Integer page,
                                                     @RequestParam(defaultValue = "0") Integer size) {
         List<UserInfo> list = userInfoService.selectAlla(page, size);
         PageInfo<UserInfo> pageInfo = new PageInfo<>(list);
         return RetResponse.makeOKRsp(pageInfo);
     }
     
     
 
     
     
     
 }
