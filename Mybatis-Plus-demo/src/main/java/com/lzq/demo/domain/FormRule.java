package com.lzq.demo.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * 
 * @TableName form_rule
 */
@TableName(value ="form_rule")
@Data
public class FormRule implements Serializable {
    /**
     * 主键
     */
    private String ruleId;

    /**
     * 创建人名称
     */
    private Integer createorname;

    /**
     * 更新人名称
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
     * 状态
     */
    private Integer status;

    /**
     * 创建人
     */
    private String createop;

    /**
     * 更新人
     */
    private String updateop;

    /**
     * 规则，类似org_position_level
     */
    private String rules;

    /**
     * 问卷id
     */
    private String questionnaireId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}