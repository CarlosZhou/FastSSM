package com.ssm.controller.base;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * All rights Reserved, Designed By carlos-y
 * @ClassName:  CommonPageController   
 * @Description:通用控制层  控制所有请求页面跳转
 * @author: carlos-y
 * @date:   2016年11月28日 下午2:01:51
 */

@Controller
@RequestMapping("page")
public class CommonPageController {
    
    /**
     * 
     * @Title: toPage   
     * @Description: TODO 
     * @param: @param pageName
     * @param: @return      
     * @return: 视图名称      
     * @throws
     */
    @RequestMapping(value="{pageName}")
    public String toPage(@PathVariable("pageName") String pageName){
        /* ModelAndView mv = new ModelAndView("pageName");
         * 可以返回模型，也可以直接返回视图名称
         * 
         */
      
        return pageName;
    }
 
}
