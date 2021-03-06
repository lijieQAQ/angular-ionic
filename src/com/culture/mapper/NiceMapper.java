package com.culture.mapper;

import java.util.List;
import java.util.Map;


import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.culture.model.Culture_nice;

public interface NiceMapper {
	
	@Insert("insert into culture_nice(uid,uame,docid) values(#{uid},#{uame},#{docid})")
	int addNice(Culture_nice nice);
	
	@Delete("delete from culture_nice where id=#{id}")
	int deleteById(Map<String,Integer> params);
	
	@Update("update culture_nice set uid=#{uid},uame=#{uame},docid=#{docid} where id=#{id}")
	int updateNice(Culture_nice nice);
		
	@Select("select id,uid,uname,docid from culture_nice where docid=#{docid}")
	List<Culture_nice> getNiceByDocId(Map<String,Integer> params);
	
	@Select("select id,uid,uname,docid from culture_nice where id=#{id}")
	Culture_nice getById(Map<String,Integer> params);
	
	@Select("select count(1) as count from culture_nice where docid=#{docId}")
	Map<String,Long> getNiceCountByDocId(Map<String,Integer> params);

	@Select("select count(1) as count from culture_nice where docid=#{docid} and uid=#{userid}")
	int getNiceByDocidAndUserid(Map<String,Integer> params);

	@Delete("delete from culture_nice where docid=#{docid} and uid=#{uid}")
	int deleteNice(Culture_nice nice);

}	
