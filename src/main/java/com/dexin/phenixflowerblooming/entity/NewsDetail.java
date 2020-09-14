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
public class NewsDetail implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 新闻咨询id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 新闻标题
     */
    private String title;

    /**
     * 新闻副标题
     */
    private String subtitle;

    /**
     * 内容
     */
    private String content;

    /**
     * 点击率
     */
    private Integer count;

    /**
     * 发布时间
     */
    private LocalDateTime gmtCreate;

    /**
     * 新闻图片
     */
    private String images;

    /**
     * 状态：0-未推荐，1-推荐
     */
    private Integer state;


}
