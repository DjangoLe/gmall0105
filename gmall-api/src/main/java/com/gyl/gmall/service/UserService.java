package com.gyl.gmall.service;


import com.gyl.gmall.bean.UmsMember;
import com.gyl.gmall.bean.UmsMemberReceiveAddress;


import java.util.List;


public interface UserService {

    List<UmsMember> getAllUser();
    UmsMember test();

    List<UmsMemberReceiveAddress> getReceiveAddressesById(String memberId);
    String User_test();

}
