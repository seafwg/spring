package com.seafwg.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.seafwg.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;

@Controller
public class UserController {
    /**
     * SpringMVC的请求-③获取结合类型的数据(应用)
     * ajax请求时添加属性contentType:"application/json;charset=utf-8"
     * @param userList
     */
    @RequestMapping("/quick11")
    @ResponseBody
    public void save11(@RequestBody List<User> userList) {
        System.out.println(userList);
    }
    /**
     * SpringMVC的请求-③获取数组类型数据(应用)
     * http://localhost/quick10?strs=1&strs=2
     * [1,2]
     * @param strs
     */
    @RequestMapping("/quick10")
    @ResponseBody
    public void save10(String[] strs) {
        System.out.println(Arrays.asList(strs));
    }
    /**
     * SpringMVC的请求-②获得POJO类型参数(应用)
     * 允许参数为空
     * @param user
     */
    @RequestMapping("/quick9")
    @ResponseBody
    public void save9(User user) {
        System.out.println(user);
    }
    /**
     * SpringMVC数据请求-①基本数据类型
     * 不允许参数为空
     * @param username
     * @param age
     */
    @RequestMapping("/quick8")
    @ResponseBody
    public void save8(String username, int age) {
        System.out.println(username);
        System.out.println(age);
    }

    /**
     * 数据回写-③返回值类型为对象或者集合:
     * @return
     */
    @RequestMapping("/quick7")
    @ResponseBody
    public User save7() {
        User user = new User();
        user.setUsername("haifu");
        user.setAge(32);
        return user;
    }
    /**
     * 数据回写-②返回值类型为json格式字符串对象:
     * @return
     * @throws JsonProcessingException
     */
    @RequestMapping("/quick6")
    @ResponseBody
    public String save6() throws JsonProcessingException {
        User user = new User();
        user.setUsername("seafwg");
        user.setAge(23);
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(user);
        return json;
    }
    /**
     * 数据回写-①返回值类型为String:在方法上添加注解@ResponseBody
     * @return
     */
    @RequestMapping("/quick5")
    @ResponseBody
    public String save5() {
        return "seafwg hello";
    }
    /**
     * 页面跳转-④返回值类型为String，接收参数HttpServletRequest
     * @param httpServletRequest
     * @return
     */
    @RequestMapping("/quick4")
    public String save4(HttpServletRequest httpServletRequest) {
        httpServletRequest.setAttribute("username","张婷怡");
        return "success";
    }
    /**
     * 页面跳转-③返回值类型为String，接收参数Model
     * @param model
     * @return String
     */
    @RequestMapping("/quick3")
    public String save3(Model model) {
        model.addAttribute("username","wunwu");
        return "success";
    }
    /**
     * 页面跳转--②返回类型为ModelAndView
     * @param modelAndView
     * @return
     */
    @RequestMapping("/quick2")
    public ModelAndView save2(ModelAndView modelAndView) {
        modelAndView.addObject("username", "assassion");
        modelAndView.setViewName("success");
        return modelAndView;
    }
    /**
     * 页面跳转--①返回类型为ModelAndView
     * @return
     */
    @RequestMapping("/quick1")
    public ModelAndView save1() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("username","seafwg");
        modelAndView.setViewName("success");
        return modelAndView;
    }
    @RequestMapping("/quick")
    public String save() {
        System.out.println("save running...");
        return "success";
    }
}
