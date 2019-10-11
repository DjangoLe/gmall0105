package com.gyl.gmall.user.controller;

import com.gyl.gmall.user.bean.UmsMember;
import com.gyl.gmall.user.bean.UmsMemberReceiveAddress;
import com.gyl.gmall.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    @ResponseBody
    @RequestMapping("/index")
    public String index()
    {
        return "hell0";
    }

    @ResponseBody
    @RequestMapping("/getAllUser")
    public List<UmsMember> getAllUser()
    {
        List<UmsMember> umsMember=userService.getAllUser();
        return umsMember;
    }

    @ResponseBody
    @RequestMapping("/getReceiveAddressesById")
    public List<UmsMemberReceiveAddress> getReceiveAddressesById(String memberId)
    {
        List<UmsMemberReceiveAddress> umsMemberReceiveAddresses=userService.getReceiveAddressesById(memberId);
        return umsMemberReceiveAddresses;
    }





    @ResponseBody
    @RequestMapping("/test")
    public UmsMember test()
    {
        UmsMember umsMember=userService.test();
        return umsMember;
    }

}
