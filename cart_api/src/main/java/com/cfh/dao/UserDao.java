package com.cfh.dao;

import com.cfh.entity.User;

/**
 * @author origg
 * @version 1.0
 * @date 2020/2/22 17:51
 */
public interface UserDao {

    /**
     * 根据用户名查询用户
     * @param username
     * @return
     */
    User queryOneUser(String username);
}
