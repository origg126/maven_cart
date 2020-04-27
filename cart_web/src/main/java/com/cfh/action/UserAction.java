package com.cfh.action;

import com.cfh.entity.User;
import com.cfh.service.impl.UserServiceImpl;
import org.apache.struts2.ServletActionContext;
import javax.servlet.http.HttpSession;
import static com.opensymphony.xwork2.Action.SUCCESS;

/**
 * @author origg
 * @version 1.0
 * @date 2020/2/22 18:34
 */
public class UserAction {
    private String username;
    private String password;
    private User user;

    /**
     * 222
     * @return
     */
    public String execute() {
        UserServiceImpl userService = new UserServiceImpl();
        user = userService.login(username, password);
        HttpSession session = ServletActionContext.getRequest().getSession();
        session.setAttribute("user", user);
        return SUCCESS;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
