package com.lzq.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lzq.demo.domain.PlForm;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @description 轻表单配置协议Mapper
 * @author lin
 * @date 2023-05-17
 */
@Mapper
public interface PlFormMapper extends BaseMapper<PlForm> {

    @Select(
            "<script>select t0.* from pl_form t0 " +
                    //add here if need left join
                    "where 1=1" +
                    "<when test='name!=null and name!=&apos;&apos; '> and t0.name=#{name}</when> " +
                    "<when test='title!=null and title!=&apos;&apos; '> and t0.title=#{title}</when> " +
                    "<when test='code!=null and code!=&apos;&apos; '> and t0.code=#{code}</when> " +
                    "<when test='tablename!=null and tablename!=&apos;&apos; '> and t0.tablename=#{tablename}</when> " +
                    "<when test='objectmark!=null and objectmark!=&apos;&apos; '> and t0.objectmark=#{objectmark}</when> " +
                    "<when test='appcode!=null and appcode!=&apos;&apos; '> and t0.appcode=#{appcode}</when> " +
                    "<when test='modulecode!=null and modulecode!=&apos;&apos; '> and t0.modulecode=#{modulecode}</when> " +
                    "<when test='groupcode!=null and groupcode!=&apos;&apos; '> and t0.groupcode=#{groupcode}</when> " +
                    "<when test='descr!=null and descr!=&apos;&apos; '> and t0.descr=#{descr}</when> " +
                    "<when test='protocol!=null and protocol!=&apos;&apos; '> and t0.protocol=#{protocol}</when> " +
                    "<when test='publishstatus!=null and publishstatus!=&apos;&apos; '> and t0.publishstatus=#{publishstatus}</when> " +
                    "<when test='createtime!=null and createtime!=&apos;&apos; '> and t0.createtime=#{createtime}</when> " +
                    "<when test='updatetime!=null and updatetime!=&apos;&apos; '> and t0.updatetime=#{updatetime}</when> " +
                    "<when test='createopname!=null and createopname!=&apos;&apos; '> and t0.createopname=#{createopname}</when> " +
                    "<when test='updateopname!=null and updateopname!=&apos;&apos; '> and t0.updateopname=#{updateopname}</when> " +
                    "<when test='platstatus!=null and platstatus!=&apos;&apos; '> and t0.platstatus=#{platstatus}</when> " +
                    "<when test='icon!=null and icon!=&apos;&apos; '> and t0.icon=#{icon}</when> " +
                    "<when test='usedtype!=null and usedtype!=&apos;&apos; '> and t0.usedtype=#{usedtype}</when> " +
                    "<when test='moduleid!=null and moduleid!=&apos;&apos; '> and t0.moduleid=#{moduleid}</when> " +
                    //add here if need page limit
                    //" limit ${page},${limit} " +
                    " </script>")
    List<PlForm> pageAll(PlForm queryParamDTO, int page, int limit);

    @Select("<script>select count(1) from pl_form t0 " +
            //add here if need left join
            "where 1=1" +
            "<when test='name!=null and name!=&apos;&apos; '> and t0.name=#{name}</when> " +
            "<when test='title!=null and title!=&apos;&apos; '> and t0.title=#{title}</when> " +
            "<when test='code!=null and code!=&apos;&apos; '> and t0.code=#{code}</when> " +
            "<when test='tablename!=null and tablename!=&apos;&apos; '> and t0.tablename=#{tablename}</when> " +
            "<when test='objectmark!=null and objectmark!=&apos;&apos; '> and t0.objectmark=#{objectmark}</when> " +
            "<when test='appcode!=null and appcode!=&apos;&apos; '> and t0.appcode=#{appcode}</when> " +
            "<when test='modulecode!=null and modulecode!=&apos;&apos; '> and t0.modulecode=#{modulecode}</when> " +
            "<when test='groupcode!=null and groupcode!=&apos;&apos; '> and t0.groupcode=#{groupcode}</when> " +
            "<when test='descr!=null and descr!=&apos;&apos; '> and t0.descr=#{descr}</when> " +
            "<when test='protocol!=null and protocol!=&apos;&apos; '> and t0.protocol=#{protocol}</when> " +
            "<when test='publishstatus!=null and publishstatus!=&apos;&apos; '> and t0.publishstatus=#{publishstatus}</when> " +
            "<when test='createtime!=null and createtime!=&apos;&apos; '> and t0.createtime=#{createtime}</when> " +
            "<when test='updatetime!=null and updatetime!=&apos;&apos; '> and t0.updatetime=#{updatetime}</when> " +
            "<when test='createopname!=null and createopname!=&apos;&apos; '> and t0.createopname=#{createopname}</when> " +
            "<when test='updateopname!=null and updateopname!=&apos;&apos; '> and t0.updateopname=#{updateopname}</when> " +
            "<when test='platstatus!=null and platstatus!=&apos;&apos; '> and t0.platstatus=#{platstatus}</when> " +
            "<when test='icon!=null and icon!=&apos;&apos; '> and t0.icon=#{icon}</when> " +
            "<when test='usedtype!=null and usedtype!=&apos;&apos; '> and t0.usedtype=#{usedtype}</when> " +
            "<when test='moduleid!=null and moduleid!=&apos;&apos; '> and t0.moduleid=#{moduleid}</when> " +
            " </script>")
    int countAll(PlForm queryParamDTO);

}
