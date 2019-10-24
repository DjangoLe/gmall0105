package com.gyl.gmall.user.controller;



import com.gyl.gmall.bean.UmsMember;
import com.gyl.gmall.bean.UmsMemberReceiveAddress;
import com.gyl.gmall.service.UserService;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserController {
    @Reference(url = "dubbo://192.168.137.1:12345")
//    @Reference
    UserService userService;

    @ResponseBody
    @RequestMapping("/index")
    public String index()
    {
        String s=userService.User_test();
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
