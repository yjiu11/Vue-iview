package com.ptw.pojo;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author yjiu
 * @since 2019-10-21
 */
@TableName("sys_params")
public class SysParams implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 编码类型，用以区分
     */
    @TableField("code")
    private String code;
    /**
     * 说明编码类型是干什么的
     */
    @TableField("remark")
    private String remark;
    /**
     * 键排序
     */
    @TableField("sort")
    private Integer sort;
    /**
     * 键
     */
    @TableField("label")
    private String label;
    /**
     * 值
     */
    @TableField("value")
    private String value;
    /**
     * 父节点
     */
    @TableField("pid")
    private Integer pid;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    @Override
    public String toString() {
        return "SysParams{" +
        ", id=" + id +
        ", code=" + code +
        ", remark=" + remark +
        ", sort=" + sort +
        ", label=" + label +
        ", value=" + value +
        ", pid=" + pid +
        "}";
    }
}
