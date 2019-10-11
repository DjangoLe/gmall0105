package com.gyl.gmall.user.service;

import com.gyl.gmall.user.bean.UmsMember;
import com.gyl.gmall.user.bean.UmsMemberReceiveAddress;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {

    List<UmsMember> getAllUser();
    UmsMember test();

    List<UmsMemberReceiveAddress> getReceiveAddressesById(String memberId);
}
