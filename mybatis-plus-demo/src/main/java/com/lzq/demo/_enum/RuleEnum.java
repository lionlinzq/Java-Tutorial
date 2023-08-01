package com.lzq.demo._enum;

public enum RuleEnum {

    org("org", 1),

    position("position", 2);
    private String dimension;
    private Integer code;

    RuleEnum(String dimension, Integer code) {
        this.dimension = dimension;
        this.code = code;
    }

    public String getDimension() {
        return dimension;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public static String getDimensionByCode(Integer code) {

        RuleEnum[] values = values();
        for (RuleEnum rule : values) {
            if (rule.getCode().equals(code)) {
                return rule.getDimension();
            }
        }
        return null;
    }
}