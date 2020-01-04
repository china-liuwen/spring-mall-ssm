package com.controller;

import com.entity.EmployeeEntity;
import com.entity.TypeEntity;
import com.github.pagehelper.PageInfo;
import com.service.TypeService;
import com.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

/**
 * 类型表控制器
 */
@Controller
@RequestMapping("/type")
public class TypeController {

    @Autowired
    private TypeService typeService;



    //类型主页面

    @RequestMapping("/list2")
    public String list3(@RequestParam(value = "pageNum",required = false,defaultValue = "1") int pageNum,
                        @RequestParam(value = "pageSize",required = false,defaultValue = "3") int pageSize,
                        Model model){
        List<TypeEntity> typeEntities = typeService.getPageHelper(pageNum,pageSize);
        PageInfo pageInfo = new PageInfo(typeEntities);
        model.addAttribute("pagety",pageInfo);
        return "be/type/list2";
    }



    @RequestMapping("/delete")
    public String delete(int tid){
        typeService.delete(tid);
        return "redirect:/type/list2";
    }

    @RequestMapping("/update")
    @ResponseBody
    public String update(TypeEntity typeEntity){
        System.out.println("typeEntity = " + typeEntity);
        typeService.update(typeEntity);
        return "redirect:/type/list2";
    }

    @RequestMapping("/insert")
    @ResponseBody
    public String insert(TypeEntity typeEntity){
        System.out.println("typeEntity = " + typeEntity);
        typeService.insert(typeEntity);
        return "redirect:/type/list2";
    }

    //错误地址404

    @RequestMapping("/error")
    public String error(){
        return "/error";
    }
}


























