package com.lzq.demo.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lzq.demo._enum.RuleEnum;
import com.lzq.demo.domain.PlReleaseRange;
import com.lzq.demo.domain.ReleaseRule;
import com.lzq.demo.domain.RuleDTO;
import com.lzq.demo.domain.rule;
import com.lzq.demo.mapper.PlReleaseRangeMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.*;

@SpringBootTest
public class ruleTest {

    @Autowired
    private PlReleaseRangeMapper mapper;

    @Test
    public void test() {
        List<Map<String, Object>> select = mapper.select();
        System.out.println(select);
    }

    @Test
    public void testGift() {
        rule rule = new rule("1", "2", "123");
        String org = rule.getCodePath();
        String level = rule.getLevel();

        String position = rule.getPosition();

        QueryWrapper wrapper = new QueryWrapper<PlReleaseRange>();
        String orgPosition = "orgstructid,positionid";

        HashMap<String, String> map = new HashMap<>();
        map.put("orgstructid", org);
        map.put("level", level);
        map.put("positionid", position);

        HashMap<String, String> actualMap = new HashMap<>();
        String[] split = orgPosition.split(",");
        for (int i = 0; i < split.length; i++) {
            actualMap.put(split[i], map.get(split[i]));
        }
        System.out.println(actualMap);


        wrapper.allEq(actualMap, false);
        System.out.println(wrapper.getSqlSegment());
        List list = mapper.selectList(wrapper);
        System.out.println(list);
    }

    @Test
    public void testGift2() {
        rule rule = new rule("1", "2", "123");
        String org = rule.getCodePath();
        String level = rule.getLevel();
        String position = rule.getPosition();

        StringBuffer buffer = new StringBuffer("select * from pl_release_range where 1 = 1 ");
        if (rule.getCodePath() != null) {
            buffer.append(String.format("and orgstructid = %s ", org));
        }
        if (rule.getPosition() != null) {
            buffer.append(String.format("and positionid = %s ", position));
        }

        System.out.println(buffer.toString());

    }

    @Test
    public void testGift3() {
        String json = "[\n" +
                "    {\n" +
                "        \"releaseObject\": \"channel\",\n" +
                "        \"releaseRules\": [\n" +
                "            {\n" +
                "                \"dimension\": \"org\",\n" +
                "                \"rangeList\": [\n" +
                "                    \"组织1\",\n" +
                "                    \"组织2\",\n" +
                "                    \"组织3\"\n" +
                "                ]\n" +
                "            },\n" +
                "            {\n" +
                "                \"dimension\": \"user\",\n" +
                "                \"rangeList\": [\n" +
                "                    \"人员1\",\n" +
                "                    \"人员2\",\n" +
                "                    \"人员3\"\n" +
                "                ]\n" +
                "            }\n" +
                "        ]\n" +
                "    },\n" +
                "    {\n" +
                "        \"releaseObject\": \"store\",\n" +
                "        \"releaseRules\": [\n" +
                "            {\n" +
                "                \"dimension\": \"org\",\n" +
                "                \"rangeList\": [\n" +
                "                    \"组织1\",\n" +
                "                    \"组织2\",\n" +
                "                    \"组织3\"\n" +
                "                ]\n" +
                "            },\n" +
                "            {\n" +
                "                \"dimension\": \"position\",\n" +
                "                \"rangeList\": [\n" +
                "                    \"职位1\",\n" +
                "                    \"职位2\",\n" +
                "                    \"职位3\"\n" +
                "                ]\n" +
                "            }\n" +
                "        ]\n" +
                "    }\n" +
                "]";

        ArrayList<String> releaseRules;

        JSONArray array = JSON.parseArray(json);
        for (int i = 0; i < array.size(); i++) {
            releaseRules = new ArrayList<>();

            JSONObject list = array.getJSONObject(i);
            String releaseObject = (String) list.get("releaseObject");
            System.out.println("投放对参是------" + releaseObject);

            JSONArray rules = (JSONArray) list.get("releaseRules");
            System.out.println("rules" + rules);
            for (int i1 = 0; i1 < rules.size(); i1++) {
                JSONObject ruleJSONObject = rules.getJSONObject(i1);
                String dimension = ruleJSONObject.getString("dimension");
                System.out.println("投放维度是:-----" + dimension);

                releaseRules.add(dimension);

                JSONArray rangeList = ruleJSONObject.getJSONArray("rangeList");
                for (int i2 = 0; i2 < rangeList.size(); i2++) {
                    System.out.println(dimension + "是------" + rangeList.get(i2));
                }
            }

            Collections.sort(releaseRules);
            String rule = String.join(",", releaseRules);
            System.out.println(rule);
        }
    }

    @Test
    public void testCubeData() {
        List<String> rangeList = Arrays.asList(new String[]{"1", "2", "3"});
        ReleaseRule rule1 = new ReleaseRule(2, rangeList);
        ReleaseRule rule2 = new ReleaseRule(1, rangeList);
        ArrayList<ReleaseRule> arrayList = new ArrayList<>();
        arrayList.add(rule1);
        arrayList.add(rule2);
        RuleDTO ruleDTO = new RuleDTO(1, arrayList);

        List<ReleaseRule> rules = ruleDTO.getRules();
        System.out.println(rules);
        Collections.sort(rules);
        System.out.println(rules);

        // 用户查询待填写问卷

        int[] arr = new int[]{1, 2, 4, 3};
        Arrays.sort(arr);
        StringBuffer sql = new StringBuffer("select * from pl_form where 1 = 1 ");
        String dimension;
        for (int i = 0; i < arr.length; i++) {
            if ((dimension = RuleEnum.getDimensionByCode(arr[i])) != null) {
                sql.append(String.format(" and %s in (%s)",dimension,new String("1,2,3")));
            }
        }
        System.out.println(sql.toString());

        // 调度查询待填写问卷


        StringBuffer sql1 = new StringBuffer("select * from pl_form where 1 = 1 ");
        String dimension1;
        for (int i = 0; i < arr.length; i++) {
            if ((dimension1 = RuleEnum.getDimensionByCode(arr[i])) != null) {
                sql.append(String.format(" and %s in (%s)",dimension1,new String("1,2,3")));
            }
        }
        System.out.println(sql.toString());
    }

    @Scheduled(cron = "* * * * * * ")
    @Test
    public void testSchdule() {
        System.out.println(System.currentTimeMillis());
    }
}
