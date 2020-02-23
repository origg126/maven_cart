package com.cfh;

import com.cfh.entity.User;
import com.cfh.service.impl.UserServiceImpl;
import sun.util.resources.cldr.ml.CalendarData_ml_IN;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        UserServiceImpl userService = new UserServiceImpl();
        User login = userService.login("admin", "admin");
        System.out.println(login);


    }
}
