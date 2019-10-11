package com.gyl.gmall.user.mapper;

import com.gyl.gmall.user.bean.UmsMember;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

//@Mapper
public interface UserMapper extends tk.mybatis.mapper.common.Mapper<UmsMember> {
    List<UmsMember> selectAllUser();
}
