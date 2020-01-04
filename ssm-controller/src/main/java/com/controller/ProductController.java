package com.controller;

import com.entity.ProductEntity;
import com.entity.TypeEntity;
import com.github.pagehelper.PageInfo;
import com.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;


    //商品主页面

    @RequestMapping("/list2")
    public String list(@RequestParam(value = "pageNum",required = false,defaultValue = "1") int pageNum,
                        @RequestParam(value = "pageSize",required = false,defaultValue = "3") int pageSize,
                         Model model){
        List<ProductEntity> productEntities = productService.getPageHelper(pageNum,pageSize);
        PageInfo pageInfo = new PageInfo(productEntities);
        model.addAttribute("pro",pageInfo);
        return "/be/product/list";
    }



    @RequestMapping("/delete")
    public String delete(int tid){
        productService.delete(tid);
        return "redirect:/product/list2";
    }

    @RequestMapping("/update")
    @ResponseBody
    public String update(ProductEntity productEntity){
        System.out.println("productEntity = " + productEntity);
        productService.update(productEntity);
        return "redirect:/product/list2";
    }

    @RequestMapping("/insert")
    @ResponseBody
    public String insert(ProductEntity productEntity){
        System.out.println("productEntity = " + productEntity);
        productService.insert(productEntity);
        return "redirect:/product/list2";
    }

    //错误地址404

    @RequestMapping("/error")
    public String error(){
        return "/error";
    }
}
