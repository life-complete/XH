package com.aaa.controller;

import com.aaa.ser.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * fileName:UserController
 * description:
 * author:zz
 * createTime:2019/3/2 16:44
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * user list
     * @return
     */
    @ResponseBody
    @RequestMapping("/list")
    public Object list(){
        return userService.getUserList();
    }
}
