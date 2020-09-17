package com.dexin.phenixflowerblooming.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Builder.Default;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.web.bind.annotation.RequestParam;

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
public class Donation implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 记录id
     */
    @TableId(value = "id", type = IdType.AUTO)
    @NotNull
    private Integer id;

    /**
     * 捐赠者姓名
     */
    @NotNull
    private String name;

    /**
     * 捐赠者的user_id
     */
    @JsonProperty(value = "user_id")
    private Integer userId;

    /**
     * 捐赠者头像
     */
    private String avatar;

    /**
     * 捐赠者手机号
     */
    @NotNull
    private String connect;

    /**
     * 是否匿名：0-否，1-匿名
     */
    @NotNull
    private Integer isAnonymous;

    /**
     * 捐赠金额数目
     */
    @NotNull
    private Double money;

    /**
     * 捐赠留言/捐赠备注
     */
    private String comment;

    /**
     * 管理员id 0-系统
     */
    private Integer adminId;

    /**
     * 创建时间
     */
    private LocalDateTime gmtCreate;

    /**
     * 是否已发放：0-未发放，1-已发放
     */
    private Integer isDistributed;

    /**
     * 发放时间
     */
    private LocalDateTime gmtDistributed;


}
