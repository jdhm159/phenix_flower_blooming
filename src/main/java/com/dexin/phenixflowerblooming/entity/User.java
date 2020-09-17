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
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码（MD5加密）
     */
    private String password;

    /**
     * 姓名
     */
    private String name;

    /**
     * 联系方式
     */
    private String connect;

    /**
     * 头像
     */
    private String images;

    /**
     * 是否管理员，0-否，1-是
     */
    private Integer isAdministrator;

    /**
     * 状态，0-禁用，1-启用
     */
    private Integer state;

    /**
     * 创建时间
     */
    private LocalDateTime gmtCreate;

    /**
     * 修改时间
     */
    private LocalDateTime gmtModify;


}
