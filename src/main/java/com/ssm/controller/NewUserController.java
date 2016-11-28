package com.ssm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssm.bean.EasyUIResult;
import com.ssm.pojo.User;
import com.ssm.service.UserService;

/**
 * 
 * All rights Reserved, Designed By carlos-y
 * @ClassName:  UserController   
 * @Description: 
 * @author: carlos-y
 * @date:   2016年11月28日 下午3:13:14
 */
@Controller
@RequestMapping("new/user")
public class NewUserController {

    @Autowired
    private UserService userService;
    
    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<User> queryUserById(@PathVariable("id") Long id ){
        /**
         * Pathvariable 用于使用 value = "{id}"
         * @RequestParam 用于使用请求传来的参数 注意区别
         */
        try {
            User user = this.userService.queryUserById(id);
            if (null == user) {
                // 资源不存在，响应404
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
            // 资源存在，响应200
            // return ResponseEntity.status(HttpStatus.OK).body(user);
            return ResponseEntity.ok(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }

}
