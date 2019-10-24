package com.gyl.gmall.gmallmanageweb.controller;


import com.gyl.gmall.bean.PmsBaseAttrInfo;
import com.gyl.gmall.bean.PmsBaseAttrValue;
import com.gyl.gmall.bean.PmsBaseSaleAttr;
import com.gyl.gmall.service.AttrrService;
import com.gyl.gmall.service.CatalogService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@CrossOrigin
public class AttrController {

    @Reference(url = "localhost:12345")
    AttrrService attrrService;
    @ResponseBody
    @RequestMapping("/attrInfoList")
    public List<PmsBaseAttrInfo> attrInfoList(String catalog3Id)
    {
        PmsBaseAttrInfo pmsBaseAttrInfo=new PmsBaseAttrInfo();
        pmsBaseAttrInfo.setCatalog3Id(catalog3Id);
        List<PmsBaseAttrInfo> pmsBaseAttrInfoList=attrrService.select(pmsBaseAttrInfo);
        return pmsBaseAttrInfoList;
    }
//    @ResponseBody
//    @RequestMapping("/getAttrValueList")
//    public List<PmsBaseAttrValue> getAttrValueList(String attrId)
//    {
//        PmsBaseAttrValue pmsBaseAttrValue=new PmsBaseAttrValue();
//        pmsBaseAttrValue.setAttrId(attrId);
//        List<PmsBaseAttrValue> pmsBaseAttrValueList=attrrService.updata(pmsBaseAttrValue);
//        return pmsBaseAttrValueList;
//    }
    @ResponseBody
    @RequestMapping("/saveAttrInfo")
    public String  saveAttrInfo(@RequestBody PmsBaseAttrInfo pmsBaseAttrInfo)
    {
        String success=attrrService.saveAttrInfo(pmsBaseAttrInfo);
        return "success";
    }
    @ResponseBody
    @RequestMapping("/baseSaleAttrList")
    public List<PmsBaseSaleAttr>  baseSaleAttrList()
    {
        List<PmsBaseSaleAttr>  pmsBaseSaleAttrList=attrrService.baseSaleAttrList();
        return pmsBaseSaleAttrList;
    }
}
