package com.gyl.gmall.service;

import com.gyl.gmall.bean.PmsBaseAttrInfo;
import com.gyl.gmall.bean.PmsBaseAttrValue;
import com.gyl.gmall.bean.PmsBaseSaleAttr;

import java.util.List;

public interface AttrrService {
    List<PmsBaseAttrInfo> select(PmsBaseAttrInfo pmsBaseAttrInfo);


    String saveAttrInfo(PmsBaseAttrInfo pmsBaseAttrInfo);

    List<PmsBaseSaleAttr> baseSaleAttrList();
}
