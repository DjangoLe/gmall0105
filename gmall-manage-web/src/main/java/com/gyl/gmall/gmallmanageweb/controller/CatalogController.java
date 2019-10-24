package com.gyl.gmall.gmallmanageweb.controller;

import com.gyl.gmall.bean.PmsBaseCatalog1;
import com.gyl.gmall.bean.PmsBaseCatalog2;
import com.gyl.gmall.bean.PmsBaseCatalog3;
import com.gyl.gmall.service.CatalogService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@CrossOrigin
public class CatalogController {

    @Reference(url = "localhost:12345")
    CatalogService catalogService;

    @ResponseBody
    @RequestMapping("/getCatalog1")
    public List<PmsBaseCatalog1> getCatalog1()
    {
        List<PmsBaseCatalog1> catalog1s=catalogService.getCatalog1();
        return catalog1s;
    }
    @ResponseBody
    @RequestMapping("/getCatalog2")
    public List<PmsBaseCatalog2> getCatalog2(String catalog1Id)
    {
        List<PmsBaseCatalog2> catalog2s=catalogService.getCatalog2(catalog1Id);
        return catalog2s;
    }
    @ResponseBody
    @RequestMapping("/getCatalog3")
    public List<PmsBaseCatalog3> getCatalog3(String catalog2Id)
    {
        System.out.println("sssss");
        List<PmsBaseCatalog3> catalog3s=catalogService.getCatalog3(catalog2Id);
        return catalog3s;
    }
}
