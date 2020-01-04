package com.entity;

import lombok.Data;

/**
 * 员工表
 */

@Data
public class EmployeeEntity {

    private Integer eid;

    //姓名

    private String ename;

    //性别

    private String sex;

    //部门

    private String section;

    //岗位

    private String post;


    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }
}
