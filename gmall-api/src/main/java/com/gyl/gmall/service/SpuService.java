package com.gyl.gmall.service;

import com.gyl.gmall.bean.PmsProductInfo;

import java.util.List;

public interface SpuService {
    List<PmsProductInfo> spuList(String catalog3Id);

    String saveSpuInfo(PmsProductInfo pmsProductInfo);
}
