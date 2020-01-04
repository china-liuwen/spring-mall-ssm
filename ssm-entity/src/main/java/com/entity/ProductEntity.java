package com.entity;

import lombok.Data;

/**
 * 产品表
 */
@Data
public class ProductEntity {

    //编号

    private Integer pid;

    //名称

    private String pname;

    //副标题

    private String subtitle;

    //图片

    private String image;

    //图片地址，

    private String siteimage;

    //商品详情

    private String detail;

    //价格

    private String price;

    //库存

    private String stock;

}
