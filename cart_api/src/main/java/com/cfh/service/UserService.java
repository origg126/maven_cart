package com.cfh.service;

import com.cfh.entity.User;

/**
 * @author origg
 * @version 1.0
 * @date 2020/2/22 18:02
 */
public interface UserService {
    /**
     * 登陆
     * @param username
     * @param password
     * @return
     */
    User login(String username, String password);
}
