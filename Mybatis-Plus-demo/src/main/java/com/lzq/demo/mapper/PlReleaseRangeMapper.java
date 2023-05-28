package com.lzq.demo.mapper;

import com.lzq.demo.domain.PlReleaseRange;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
* @author lin
* @description 针对表【pl_release_range(投放范围表)】的数据库操作Mapper
* @createDate 2023-05-27 00:18:47
* @Entity com.lzq.demo.domain.PlReleaseRange
*/
public interface PlReleaseRangeMapper extends BaseMapper<PlReleaseRange> {


    @Select("select orgstructid,positionid\n" +
            "from pl_questionnaire qu join form_rule rule on qu.id = rule.questionnaire_id\n" +
            "join pl_release_range prr on rule.rule_id = prr.rule_id;")
    List<Map<String,Object>> select();

}




