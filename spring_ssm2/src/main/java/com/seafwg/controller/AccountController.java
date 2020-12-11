package com.seafwg.controller;

import com.seafwg.domain.Account;
import com.seafwg.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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
}
