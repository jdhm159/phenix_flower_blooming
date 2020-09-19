package com.dexin.phenixflowerblooming.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Poverty {
    private Integer id;
    private Integer userId;
    private String name;
    private String town;
    private String avatar;
    private String address;
    private String village;
    private String cardCode;
    private String connect;
    private String intro;
    private Integer status;
    private Integer admin_id;
    private Date gmt_create;
    private Date gmt_validate;


}
