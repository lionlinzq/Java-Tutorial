package com.lzq.grammer.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Objects;

/**
 * 用户
 *
 * @author lin
 * @date 2023/06/18
 */
@Data
public class User {

    private String username;

    private String password;

    private int userId;

    /**
     * 归属门店id
     */
    private int storeId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return userId == user.userId && storeId == user.storeId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, storeId);
    }
}

