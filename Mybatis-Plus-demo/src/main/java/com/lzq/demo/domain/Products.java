package com.lzq.demo.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName products
 */
@TableName(value ="products")
@Data
public class Products implements Serializable {
    /**
     * 商品ID
     */
    @TableId
    private Integer productId;

    /**
     * 商品名称
     */
    private String productName;

    /**
     * 商品描述
     */
    private String productDescription;

    /**
     * 商品价格
     */
    private BigDecimal productPrice;

    /**
     * 商品类别
     */
    private String productCategory;

    /**
     * 商品图片
     */
    private String productImage;

    /**
     * 商品是否可用
     */
    private Integer productAvailable;

    /**
     * 商品创建日期
     */
    private Date productCreatedDate;

    /**
     * 商品更新日期
     */
    private Date productUpdatedDate;

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
        Products other = (Products) that;
        return (this.getProductId() == null ? other.getProductId() == null : this.getProductId().equals(other.getProductId()))
            && (this.getProductName() == null ? other.getProductName() == null : this.getProductName().equals(other.getProductName()))
            && (this.getProductDescription() == null ? other.getProductDescription() == null : this.getProductDescription().equals(other.getProductDescription()))
            && (this.getProductPrice() == null ? other.getProductPrice() == null : this.getProductPrice().equals(other.getProductPrice()))
            && (this.getProductCategory() == null ? other.getProductCategory() == null : this.getProductCategory().equals(other.getProductCategory()))
            && (this.getProductImage() == null ? other.getProductImage() == null : this.getProductImage().equals(other.getProductImage()))
            && (this.getProductAvailable() == null ? other.getProductAvailable() == null : this.getProductAvailable().equals(other.getProductAvailable()))
            && (this.getProductCreatedDate() == null ? other.getProductCreatedDate() == null : this.getProductCreatedDate().equals(other.getProductCreatedDate()))
            && (this.getProductUpdatedDate() == null ? other.getProductUpdatedDate() == null : this.getProductUpdatedDate().equals(other.getProductUpdatedDate()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getProductId() == null) ? 0 : getProductId().hashCode());
        result = prime * result + ((getProductName() == null) ? 0 : getProductName().hashCode());
        result = prime * result + ((getProductDescription() == null) ? 0 : getProductDescription().hashCode());
        result = prime * result + ((getProductPrice() == null) ? 0 : getProductPrice().hashCode());
        result = prime * result + ((getProductCategory() == null) ? 0 : getProductCategory().hashCode());
        result = prime * result + ((getProductImage() == null) ? 0 : getProductImage().hashCode());
        result = prime * result + ((getProductAvailable() == null) ? 0 : getProductAvailable().hashCode());
        result = prime * result + ((getProductCreatedDate() == null) ? 0 : getProductCreatedDate().hashCode());
        result = prime * result + ((getProductUpdatedDate() == null) ? 0 : getProductUpdatedDate().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", productId=").append(productId);
        sb.append(", productName=").append(productName);
        sb.append(", productDescription=").append(productDescription);
        sb.append(", productPrice=").append(productPrice);
        sb.append(", productCategory=").append(productCategory);
        sb.append(", productImage=").append(productImage);
        sb.append(", productAvailable=").append(productAvailable);
        sb.append(", productCreatedDate=").append(productCreatedDate);
        sb.append(", productUpdatedDate=").append(productUpdatedDate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}