package com.lzq.demo.domain;

import java.util.List;

/**
 * @author lin
 */
public class RuleDTO {

    private Integer type;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public RuleDTO(Integer type, List<ReleaseRule> rules) {
        this.type = type;
        this.rules = rules;
    }

    List<ReleaseRule> rules;

    public RuleDTO(List<ReleaseRule> rules) {
        this.rules = rules;
    }

    public List<ReleaseRule> getRules() {
        return rules;
    }

    public void setRules(List<ReleaseRule> rules) {
        this.rules = rules;
    }
}
