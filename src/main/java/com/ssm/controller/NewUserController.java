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
    
    /**
     * 
     * RESTful demo  提交资源 POST
     */
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> saveUser(User user){
    	
    	try {
			Boolean bool = userService.saveUser(user);
			if(bool){
				 return ResponseEntity.status(HttpStatus.CREATED).build();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
		 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

    }

    
    /**
     * 
     * restFul demo  修改资源 PUT
     * 默认情况下 PUT无法提交表单数据
     * 
     * 解决方法：需要在web.xml中加过滤器
     * org.springframework.web.filter.HttpPutFormContentFilter
     */
    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<Void> updateUser(User user){
    	
    	try {
			Boolean bool = userService.updateUser(user);
			if(bool){
				//204 操作成功 无返回内容
				 return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
		 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

    }
    
    
    
    /**
     * 
     * restFul demo  修改资源 DELETE 
     * 默认情况下 DELETE无法提交表单数据
     * 
     * 解决方法：需要在web.xml中加过滤器 并且制定_method 方法
     * 注意请求的时候不能是DELETE，只能是POST 但是需要加个请求参数：key：_mehtod : value:DELETE
     * org.springframework.web.filter.HiddenHttpMethodFilter
     */
    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteUser(@RequestParam(value="id",defaultValue="0") Long id){
    	
    	try {
    		if(id.longValue()==0){
				 return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

    		}
    		
			Boolean bool = userService.deleteUser(id);
			if(bool){
				//204 操作成功 无返回内容
				 return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
		 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

    }
}
