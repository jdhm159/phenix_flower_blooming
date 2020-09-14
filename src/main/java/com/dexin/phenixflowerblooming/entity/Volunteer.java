package com.dexin.phenixflowerblooming.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author 2017101044 林浚颖
 * @since 2020-09-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Volunteer implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 志愿者id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 申请人姓名
     */
    private String name;

    /**
     * 镇
     */
    private String town;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 村
     */
    private String village;

    /**
     * 家庭住址
     */
    private String address;

    /**
     * 身份证号
     */
    private String cardCode;

    /**
     * 联系电话
     */
    private String connect;

    /**
     * 座右铭
     */
    private String intro;

    /**
     * 状态：0-未审核，1-已审核
     */
    private Integer status;

    /**
     * 管理员ID
     */
    private Integer adminId;

    /**
     * 创建时间
     */
    private LocalDateTime gmtCreate;

    /**
     * 审核时间
     */
    private LocalDateTime gmtValidate;


}
