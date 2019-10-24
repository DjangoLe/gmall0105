package com.gyl.gmall.gmallmanageweb.controller;

import com.gyl.gmall.bean.PmsProductInfo;
import com.gyl.gmall.gmallmanageweb.util.PmsUploadUtil;
import com.gyl.gmall.service.CatalogService;
import com.gyl.gmall.service.SpuService;
import org.apache.dubbo.config.annotation.Reference;
import org.csource.common.MyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Controller
@CrossOrigin
public class SpuController {

    @Reference(url = "localhost:12345")
    SpuService spuService;

    @ResponseBody
    @RequestMapping("/spuList")
    public List<PmsProductInfo> spuList(String catalog3Id)
    {
        List<PmsProductInfo> pmsProductInfoList=spuService.spuList(catalog3Id);
        return pmsProductInfoList;
    }
    @ResponseBody
    @RequestMapping("/saveSpuInfo")
    public String saveSpuInfo(@RequestBody PmsProductInfo pmsProductInfo)
    {
        String success=spuService.saveSpuInfo(pmsProductInfo);
        return "success";
    }
    @ResponseBody
    @RequestMapping("/fileUpload")
    public String fileUpload(@RequestParam("file") MultipartFile multipartFile) throws IOException, MyException {
        //将图片或者音频上传到分布式的文件存储系统


        //将图片的存储路径返回给页面
        String imgUrl=PmsUploadUtil.uploadImage(multipartFile);
        System.out.println(imgUrl);
        return imgUrl;
    }
}
