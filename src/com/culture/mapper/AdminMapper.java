package com.culture.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Select;

public interface AdminMapper {

	@Select("select count(*) from culture_admin where username=#{username} and password=#{password}")
	int isAdmin(Map<String,String> params);
}
