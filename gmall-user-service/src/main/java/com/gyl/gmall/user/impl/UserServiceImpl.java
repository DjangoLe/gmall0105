package com.gyl.gmall.user.impl;



import com.gyl.gmall.bean.UmsMember;
import com.gyl.gmall.bean.UmsMemberReceiveAddress;
import com.gyl.gmall.service.UserService;
import com.gyl.gmall.user.mapper.UmsMemberReceiveAddressMapper;
import com.gyl.gmall.user.mapper.UserMapper;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    UserMapper userMapper;
    @Autowired
    UmsMemberReceiveAddressMapper umsMemberReceiveAddressMapper;

    @Override
    public List<UmsMember> getAllUser() {
        System.out.println("==================================");
        List<UmsMember> umsMemberList=userMapper.selectAllUser();
        return  umsMemberList;
    }

    @Override
    public UmsMember test() {
        UmsMember umsMember = new UmsMember();
        umsMember.setId("1");
        UmsMember umsMember1=userMapper.selectByPrimaryKey(1);
//        userMapper.selectByPrimaryKey()
        return umsMember1;
    }

    @Override
    public List<UmsMemberReceiveAddress> getReceiveAddressesById(String memberId) {


//        UmsMemberReceiveAddress umsMemberReceiveAddress=new UmsMemberReceiveAddress();
//        umsMemberReceiveAddress.setMemberId(memberId);
//        return umsMemberReceiveAddressMapper.select(umsMemberReceiveAddress);

        Example e=new Example(UmsMemberReceiveAddress.class);
        e.createCriteria().andEqualTo("memberId",memberId);
        return umsMemberReceiveAddressMapper.selectByExample(e);


    }

    @Override
    public String User_test() {
        return "ssssss";
    }
}
