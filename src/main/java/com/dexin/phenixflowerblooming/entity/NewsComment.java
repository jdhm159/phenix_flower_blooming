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
public class NewsComment implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 新闻评论id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 对应新闻id
     */
    private Integer newsId;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 评论内容
     */
    private String content;

    /**
     * 状态：0-未审核，1-已审核
     */
    private Integer state;

    /**
     * 状态：0-未审核，1-已审核
     */
    private Integer status;

    /**
     * 创建时间
     */
    private LocalDateTime gmtCreate;


}
