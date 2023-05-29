package com.lzq.demo.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * 问卷
 * @TableName pl_questionnaire
 */
@TableName(value ="pl_questionnaire")
@Data
public class PlQuestionnaire implements Serializable {
    /**
     * 主键
     */
    private String id;

    /**
     * 创建人
     */
    private Integer createorname;

    /**
     * 更新人
     */
    private Integer updateorname;

    /**
     * 创建时间
     */
    private LocalDateTime createtime;

    /**
     * 更新时间
     */
    private LocalDateTime updatetime;

    /**
     * 状态 0未发布 1已发布 2废弃
     */
    private Integer status;

    /**
     * 问卷开始时间
     */
    private String startTime;

    /**
     * 问卷结束时间
     */
    private String endTime;

    /**
     * 问卷名称
     */
    private String name;

    /**
     * 背景图
     */
    private String background;

    /**
     * 引用表单code
     */
    private String formcode;

    /**
     * 问卷说明
     */
    private String description;

    /**
     * 通知规则
     */
    private String noticeRule;

    /**
     * 填报规则
     */
    private String submitRules;

    /**
     * 投放规则（json，用于问卷反查投放范围）
     */
    private String deliveryRule;

    /**
     * 逻辑删除字段 1代表未删除 2代表逻辑删除
     */
    private String isDeleted;

    /**
     * 
     */
    private String createop;

    /**
     * 
     */
    private String updateop;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}