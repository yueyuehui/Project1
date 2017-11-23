package com.jk.controller;

import com.alibaba.fastjson.JSON;
import com.jk.model.UserBO;
import com.jk.service.IUserService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yangzhichao on 2017-11-14.
 */
@RestController
public class UserController extends BaseController{

    @Autowired
    private IUserService userService;

    @RequestMapping("/userList")
    public List<UserBO> userList() {
        List<UserBO> userBOs = userService.userList();
        return userBOs;
    }

    @RequestMapping("/findUserByName")
    public UserBO findUserByName(String name) {
        return userService.findUserByName(name);
    }

    @RequestMapping("/user/show")
    public void exchangeJson(HttpServletRequest request, String callback, Integer id, String name, Integer age, HttpServletResponse response) {
        System.out.println("id:" + id + " name:" + name + " age:" + age);
        List<UserBO> userBOs = userService.userList();
        String json = JSON.toJSONStringWithDateFormat(userBOs, "yyyy-MM-dd HH:mm:ss");
        //加上返回参数
        json=callback+"("+json+")";
        super.outString(json, response);
    }
}
