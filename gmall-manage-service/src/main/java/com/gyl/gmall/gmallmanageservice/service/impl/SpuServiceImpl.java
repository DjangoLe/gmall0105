package com.gyl.gmall.gmallmanageservice.service.impl;

import com.gyl.gmall.bean.PmsProductImage;
import com.gyl.gmall.bean.PmsProductInfo;
import com.gyl.gmall.gmallmanageservice.mapper.PmsProductImageMapper;
import com.gyl.gmall.gmallmanageservice.mapper.PmsProductInfoMapper;
import com.gyl.gmall.service.SpuService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class SpuServiceImpl implements SpuService {

    @Autowired
    PmsProductInfoMapper pmsProductInfoMapper;
    @Autowired
    PmsProductImageMapper pmsProductImageMapper;
    @Override
    public List<PmsProductInfo> spuList(String catalog3Id) {
        PmsProductInfo pmsProductInfo=new PmsProductInfo();
        pmsProductInfo.setCatalog3Id(catalog3Id);
        return pmsProductInfoMapper.select(pmsProductInfo);
    }

    @Override
    public String saveSpuInfo(PmsProductInfo pmsProductInfo) {

        System.out.println(pmsProductInfo);
        pmsProductInfoMapper.insert(pmsProductInfo);
        String productId=pmsProductInfo.getId();
        for (PmsProductImage pmsProductImage:pmsProductInfo.getSpuImageList())
        {
            pmsProductImage.setProductId(productId);
            pmsProductImageMapper.insert(pmsProductImage);
        }
        return "success";
    }
}
