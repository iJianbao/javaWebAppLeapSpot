package com.smart.web;

import com.smart.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/user")
public class UserController {
    @RequestMapping(value = "/createUser", method = RequestMethod.GET)
    public String createUser(@ModelAttribute("user")User user) {
        return "user/createSuccess";
    }
    @RequestMapping(value = "/rigister")
    public String regisiter(@ModelAttribute("user")User user) {
        return "user/rigister";
    }
    @RequestMapping(value = "/{userId}")
    public ModelAndView showDetail(@PathVariable("userId")String userId) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("user/showDetail");

        return mv;
    }
    //在方法上注解，每次调用其他方法都会先调用此方法
    @ModelAttribute("user")
    public User getUser() {
        User user = new User();
        user.setUserId(1001);

        return user;
    }
    @RequestMapping(value = "/model2")
    public String handleModel2(@ModelAttribute("user")User user) {
        user.setUserName("tom");
        return "showUser";
    }
    @RequestMapping(value = "/showUserListByJson")
    @ResponseBody
    public Map<String, Object> showUserListInJson(ModelMap mm) {
        User user = (User) mm.get("user");
        user.setUserId(1);
        user.setUserName("2");
        ArrayList<User> list = new ArrayList<User>();
        list.add(user);
        Map<String, Object> mapMode = new HashMap<String, Object>();
        mapMode.put("userList", list);
        mapMode.put("word", "研发");

        return mapMode;
    }

    @RequestMapping(value = "/valid1")
    @ResponseBody
    public Map<String, Object> handleValid1(@Valid @ModelAttribute("user")User user, BindingResult bindingResult) {
        Map<String, Object> mapMode = new HashMap<String, Object>();
        if (!bindingResult.hasErrors()) {
            mapMode.put("code", 0);
            mapMode.put("message", "success");
            mapMode.put("data", "");
            return mapMode;
        }
        Map<String, String> errorMapMode = new HashMap<String, String>();
        for (FieldError error : bindingResult.getFieldErrors()) {
            errorMapMode.put(error.getField(), error.getDefaultMessage());
        }
        mapMode.put("code", 1001);
        mapMode.put("message", "数据错误");
        mapMode.put("data", errorMapMode);
        return mapMode;
    }

    @RequestMapping(value = "/valid2", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> handleValid2(@Valid @ModelAttribute("user")User user, BindingResult bindingResult) {
        Map<String, Object> mapMode = new HashMap<String, Object>();
        if (!bindingResult.hasErrors()) {
            mapMode.put("code", 0);
            mapMode.put("message", "success");
            mapMode.put("data", "");
            return mapMode;
        }
        Map<String, String> errorMapMode = new HashMap<String, String>();
        for (FieldError error : bindingResult.getFieldErrors()) {
            errorMapMode.put(error.getField(), error.getDefaultMessage());
        }
        mapMode.put("code", 1001);
        mapMode.put("message", "数据错误");
        mapMode.put("data", errorMapMode);
        return mapMode;
    }
}
