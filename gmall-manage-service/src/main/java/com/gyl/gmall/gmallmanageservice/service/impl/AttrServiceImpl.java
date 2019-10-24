package com.gyl.gmall.gmallmanageservice.service.impl;

import com.gyl.gmall.bean.PmsBaseAttrInfo;
import com.gyl.gmall.bean.PmsBaseAttrValue;
import com.gyl.gmall.bean.PmsBaseSaleAttr;
import com.gyl.gmall.gmallmanageservice.mapper.PmsBaseAttrInfoMapper;
import com.gyl.gmall.gmallmanageservice.mapper.PmsBaseAttrValueMapper;
import com.gyl.gmall.gmallmanageservice.mapper.PmsBaseSaleAttrMapper;
import com.gyl.gmall.service.AttrrService;
import org.apache.dubbo.common.utils.StringUtils;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.function.Consumer;

@Service
public class AttrServiceImpl implements AttrrService {
    @Autowired
    PmsBaseAttrInfoMapper pmsBaseAttrInfoMapper;
    @Autowired
    PmsBaseAttrValueMapper pmsBaseAttrValueMapper;

    @Autowired
    PmsBaseSaleAttrMapper pmsBaseSaleAttrMapper;

    @Override
    public List<PmsBaseAttrInfo> select(PmsBaseAttrInfo pmsBaseAttrInfo) {
        return pmsBaseAttrInfoMapper.select(pmsBaseAttrInfo);
    }

    @Override
    public String saveAttrInfo(PmsBaseAttrInfo pmsBaseAttrInfo) {

        String id=pmsBaseAttrInfo.getId();
        if (StringUtils.isBlank(id)) {
            //保存属性
            pmsBaseAttrInfoMapper.insertSelective(pmsBaseAttrInfo);//insertSelective:是否将null插入数据库
            //保存属性值
            List<PmsBaseAttrValue> attrValueList = pmsBaseAttrInfo.getAttrValueList();
            for (PmsBaseAttrValue pmsBaseAttrValue : attrValueList) {
                pmsBaseAttrValue.setAttrId(pmsBaseAttrInfo.getId());
                pmsBaseAttrValueMapper.insertSelective(pmsBaseAttrValue);
            }
        }
        else{
            //id不空，修改

            //属性
            Example example=new Example(PmsBaseAttrInfo.class);
            example.createCriteria().andEqualTo("id",pmsBaseAttrInfo.getId());
            pmsBaseAttrInfoMapper.updateByExampleSelective(pmsBaseAttrInfo,example);
            //属性值
            List<PmsBaseAttrValue> attrValueList=pmsBaseAttrInfo.getAttrValueList();
            /* 删除 */
            PmsBaseAttrValue pmsBaseAttrValue=new PmsBaseAttrValue();
            pmsBaseAttrValue.setAttrId(pmsBaseAttrInfo.getId());
            pmsBaseAttrValueMapper.delete(pmsBaseAttrValue);
            for (PmsBaseAttrValue pmsBaseAttrValue1:attrValueList)
            {
                pmsBaseAttrValueMapper.insertSelective(pmsBaseAttrValue1);
            }
        }
        return "succcess";
    }

    @Override
    public List<PmsBaseSaleAttr> baseSaleAttrList() {
        return pmsBaseSaleAttrMapper.selectAll();
    }


}
