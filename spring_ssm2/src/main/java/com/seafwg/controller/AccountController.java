package com.seafwg.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.seafwg.domain.Account;
import com.seafwg.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @RequestMapping(value = "/save", produces = "application/json;charset=utf-8")
    @ResponseBody
    public String save(Account account) {
        accountService.save(account);
        return "保存成功...";
    }

    @RequestMapping("/list")
    public ModelAndView findAll() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("accountList", accountService.findAll());
        modelAndView.setViewName("list");
        return modelAndView;
    }

    @RequestMapping("/listData")
    @ResponseBody
    public String findAllList() {
        List<Account> accountList = accountService.findAll();
        ObjectMapper mapper = new ObjectMapper();
        String json = null;
        try {
            json = mapper.writeValueAsString(accountList);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
        return json;
    }
}
