package com.lzq.demo.domain;

import lombok.Builder;
import lombok.Data;

@Data
public class rule {
    private String codePath;

    private String level;

    private String position;

    public rule() {
    }

    public rule(String codePath, String level, String position) {
        this.codePath = codePath;
        this.level = level;
        this.position = position;
    }
}
