package com.lzq.demo.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName logs
 */
@TableName(value ="logs")
@Data
public class Logs implements Serializable {
    /**
     * 日志ID
     */
    @TableId
    private Integer logId;

    /**
     * 日志类型
     */
    private String logType;

    /**
     * 日志信息
     */
    private String logMessage;

    /**
     * 日志日期
     */
    private Date logDate;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Logs other = (Logs) that;
        return (this.getLogId() == null ? other.getLogId() == null : this.getLogId().equals(other.getLogId()))
            && (this.getLogType() == null ? other.getLogType() == null : this.getLogType().equals(other.getLogType()))
            && (this.getLogMessage() == null ? other.getLogMessage() == null : this.getLogMessage().equals(other.getLogMessage()))
            && (this.getLogDate() == null ? other.getLogDate() == null : this.getLogDate().equals(other.getLogDate()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getLogId() == null) ? 0 : getLogId().hashCode());
        result = prime * result + ((getLogType() == null) ? 0 : getLogType().hashCode());
        result = prime * result + ((getLogMessage() == null) ? 0 : getLogMessage().hashCode());
        result = prime * result + ((getLogDate() == null) ? 0 : getLogDate().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", logId=").append(logId);
        sb.append(", logType=").append(logType);
        sb.append(", logMessage=").append(logMessage);
        sb.append(", logDate=").append(logDate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}