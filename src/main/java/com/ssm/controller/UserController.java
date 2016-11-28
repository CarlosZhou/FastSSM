package com.ssm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssm.bean.EasyUIResult;
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
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;
    
    
    /**
     * http://localhost:8080/rest/user/list?page=1&rows=5
     * @Title: queryUserList  (因为spring事物管理配置了query打头的方法只能查询不能修改)
     * @Description: TODO 
     * @param: @return      
     * @return: EasyUIResult      
     * @throws
     */
    @RequestMapping(value="list",method=RequestMethod.GET)
    @ResponseBody
    public EasyUIResult queryUserList(@RequestParam("page") Integer page,
                                      @RequestParam("rows") Integer rows){
        /**
         * Pathvariable 用于使用 value = "{id}"
         * @RequestParam 用于使用请求传来的参数 注意区别
         */
        
        EasyUIResult easyUIResult = userService.queryUserList(page,rows);
        
        return easyUIResult;
    }
    
}
