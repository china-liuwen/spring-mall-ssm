package com.controller;

import com.entity.EmployeeEntity;
import com.github.pagehelper.PageInfo;
import com.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    //员工主页面 js

//    @RequestMapping("/index2")
//    public String index(){
//        return "be/employee/list";
//    }

    @RequestMapping("/list")
    @ResponseBody
    public List<EmployeeEntity> list(@RequestParam(value = "pageNum",required = false,defaultValue = "1") int pageNum,
                       @RequestParam(value = "pageSize",required = false,defaultValue = "3") int pageSize,
                       Model model){
//        List<EmployeeEntity> employeeEntities = employeeService.getAllemp(pageNum,pageSize);
//        PageInfo pageInfo = new PageInfo((employeeEntities));
//        model.addAttribute("page",pageInfo);
//        return "/be/employee/list";
        return employeeService.getAllemp(pageNum,pageSize);
    }


    //员工主页面 分页

    @RequestMapping("/list2")
    public String list2(@RequestParam(value = "pageNum",required = false,defaultValue = "1") int pageNum,
                       @RequestParam(value = "pageSize",required = false,defaultValue = "3") int pageSize,
                       Model model){
        List<EmployeeEntity> employeeEntities = employeeService.getAllemp(pageNum,pageSize);
       PageInfo pageInfo = new PageInfo(employeeEntities);
       model.addAttribute("pageEmployee",pageInfo);
        return "be/employee/list";
    }

    @RequestMapping("/delete")
    public String delete(int eid) {
        employeeService.delete(eid);
        return "redirect:/employee/list2";
    }

    @RequestMapping("/update")
    public String update( EmployeeEntity employeeEntity ) {
        System.out.println("employeeEntity = " + employeeEntity);
        employeeService.update(employeeEntity);
        return "redirect:/employee/list2";
    }



    @RequestMapping("/insert")
    public String insert(EmployeeEntity employeeEntity){
        System.out.println("employeeEntity = " + employeeEntity);
        employeeService.insert(employeeEntity);
        return "redirect:/employee/list2";
    }

    //错误地址404

    @RequestMapping("/error")
    public String error(){
        return "/error";
    }

}



































































