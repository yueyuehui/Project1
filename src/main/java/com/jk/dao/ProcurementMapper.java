package com.jk.dao;

import com.jk.model.Procurement;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * Created by Microsoft on 2017/11/15.
 */
@Mapper
public interface ProcurementMapper {
    //查询 条件  分页
    @Select("select * from cg limit ${page},${rows}")
    List<Procurement> selAllOrg(Map<String, Object> map);

    //总条数
    @Select("select count(*) from cg")
    Long queryCount(Map<String, Object> map);
    @Select("select * from cg")
    List<Procurement> procurementList();
    @Select("select * from cg #{sb}")
    List<Procurement> purchaseQuery(String sb);
}
