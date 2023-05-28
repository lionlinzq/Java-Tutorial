package com.lzq.demo.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * 投放范围表
 * @TableName pl_release_range
 */
@TableName(value ="pl_release_range")
@Data
public class PlReleaseRange implements Serializable {
    /**
     * 表单主键
     */
    @TableId
    private Long rangeId;

    /**
     * 问卷id（也可以改成占位关联id,如关联知识点id等）
     */
    private Long questionnaireId;

    /**
     * 投放对象 1、品牌商 2、经销商 3、促销导购 4、终端
     */
    private Integer target;

    /**
     * 投放维度 1、组织 2、组织+职位 3、人员  4、经销商 5、经销商+职位 6、经销商类型 7、终端 8、渠道类型 9、终端类型
     */
    private Long dimension;

    /**
     * 组织
     */
    private Long orgstructid;

    /**
     * 职位
     */
    private Long positionid;

    /**
     * 客户类型
     */
    private String customerType;

    /**
     * 创建时间
     */
    private LocalDateTime createtime;

    /**
     * 修改时间
     */
    private LocalDateTime updatetime;

    /**
     * 创建人姓名
     */
    private String createopname;

    /**
     * 修改人姓名
     */
    private String updateopname;

    /**
     * 人员id
     */
    private String userid;

    /**
     * 
     */

    /**
     * 规则id
     */
    private String ruleId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}