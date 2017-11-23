package com.jk.dao;

import java.util.List;

import com.jk.model.Tree;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface SystemMapper {

	@Select("select * from tree where pid = #{pid}")
	List<Tree> queryTreeByPid(@Param("pid")String pid);
}
