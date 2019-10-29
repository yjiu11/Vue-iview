package com.ptw.pojo;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author yjiu
 * @since 2019-10-21
 */
@TableName("question")
@Data
@Accessors(chain=true)
public class Question implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 题目
     */
    @TableField("name")
    private String name;
    /**
     * 1:选择题;2:填空题;3:大题;0:多选题
     */
    @TableField("type")
    private Integer type;
    /**
     * 选项
     */
    @TableField("options")
    private String options;
    /**
     * 答案
     */
    @TableField("answer")
    private String answer;
    /**
     * 分类
     */
    @TableField("category")
    private String category;
    /**
     * 创建时间
     */
    @TableField("create_time")
    private Date createTime;
    /**
     * 修改时间
     */
    @TableField("update_time")
    private Date updateTime;
}
