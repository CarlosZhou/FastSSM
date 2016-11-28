package com.ssm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.abel533.entity.Example;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ssm.bean.EasyUIResult;
import com.ssm.mapper.UserMapper;
import com.ssm.pojo.User;

/**
 * 
 * All rights Reserved, Designed By carlos-y
 * @ClassName:  UserService   
 * @Description:
 * @author: carlos-y
 * @date:   2016年11月28日 下午3:29:41
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;
    
    public EasyUIResult queryUserList(Integer page, Integer rows) {
         
        //配置分页参数
        PageHelper.startPage(page, rows);
        
        //查询User数据(如果无查询条件 则设置为null)
       // List<User> users = userMapper.select(null);
        
        //加条件查询updated
        Example example = new Example(User.class);
        example.setOrderByClause("updated DESC");
        List<User> users = userMapper.selectByExample(example);

        
        //获取分页后的信息
        PageInfo<User> pageInfo= new PageInfo<User>(users);
        
        
        return new EasyUIResult(pageInfo.getTotal(),pageInfo.getList());
    }

    /**
     * 根据逐渐查询
     * @param id
     * @return
     */
    
    public User queryUserById(Long id) {
        User user = userMapper.selectByPrimaryKey((Long)id);
        return user;
    }

    /**
     * 保存
     * @param user
     * @return
     */
	public Boolean saveUser(User user) {
		return  userMapper.insert(user)==1;
	}

    /**
     * 更新
     * @param user
     * @return
     */
	public Boolean updateUser(User user) {
		return userMapper.updateByPrimaryKeySelective(user)==1;
	}

    /**
     * 删除
     * @param user
     * @return
     */
	public Boolean deleteUser(Long id) {
		// TODO Auto-generated method stub
		return userMapper.deleteByPrimaryKey(id)==1;
	}

    
    
}
