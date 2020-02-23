package com.cfh.service.impl;

import com.cfh.dao.UserDao;
import com.cfh.entity.User;
import com.cfh.service.UserService;
import com.cfh.util.MybatisUtil;

/**
 * @author origg
 * @version 1.0
 * @date 2020/2/22 18:02
 */
public class UserServiceImpl implements UserService {
    @Override
    public User login(String username, String password) {
        UserDao dao = MybatisUtil.getMapper(UserDao.class);
        User user = dao.queryOneUser(username);
        if(user != null && password.equals(user.getPassword())){
            MybatisUtil.close();
            return user;
        }
        MybatisUtil.close();
        return null;
    }
}
