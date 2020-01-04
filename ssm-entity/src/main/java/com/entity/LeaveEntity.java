package com.entity;

import lombok.Data;

import java.util.Date;

/**
 * 留言表
 */
@Data
public class LeaveEntity {

    //编号

    private Integer lid;

    //内容

    private String content;

    //创建时间

    private Date createTime;

    //修改时间

    private Date updateTime;
}
