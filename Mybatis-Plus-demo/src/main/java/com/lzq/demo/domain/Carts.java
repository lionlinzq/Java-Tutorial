package com.lzq.demo.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName carts
 */
@TableName(value ="carts")
@Data
public class Carts implements Serializable {
    /**
     * 购物车ID
     */
    @TableId
    private Integer cartId;

    /**
     * 用户ID
     */
    private Integer userId;

    /**
     * 购物车创建日期
     */
    private Date cartCreatedDate;

    /**
     * 购物车更新日期
     */
    private Date cartUpdatedDate;

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
        Carts other = (Carts) that;
        return (this.getCartId() == null ? other.getCartId() == null : this.getCartId().equals(other.getCartId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getCartCreatedDate() == null ? other.getCartCreatedDate() == null : this.getCartCreatedDate().equals(other.getCartCreatedDate()))
            && (this.getCartUpdatedDate() == null ? other.getCartUpdatedDate() == null : this.getCartUpdatedDate().equals(other.getCartUpdatedDate()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCartId() == null) ? 0 : getCartId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getCartCreatedDate() == null) ? 0 : getCartCreatedDate().hashCode());
        result = prime * result + ((getCartUpdatedDate() == null) ? 0 : getCartUpdatedDate().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", cartId=").append(cartId);
        sb.append(", userId=").append(userId);
        sb.append(", cartCreatedDate=").append(cartCreatedDate);
        sb.append(", cartUpdatedDate=").append(cartUpdatedDate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}