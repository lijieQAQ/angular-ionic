package com.culture.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.culture.model.Culture_review;


public interface ReviewMapper {
	
	@Insert("insert into culture_review(docid,userid,uname,time,msg,toid,toname,nices) values(#{docid},#{userid},#{uname},#{time},#{msg},#{toid},#{toname},#{nices})")
	int addReview(Culture_review review);
	
	@Update("update culture_review set docid=#{docid},userid=#{userid},uname=#{uname},time=#{time},"
			+ "msg=#{msg},toid=#{toid},toname=#{toname},nices=#{nices} where id=#{id}")
	int updateReview(Culture_review review);
	
	@Delete("delete from culture_review where id=#{id}")
	int deleteById(Map<String,Integer> params);
	
	@Select("select id,docid,userid,uname,time,msg,toid,toname,nices from culture_review where id=#{id}")
	Culture_review getById(Map<String,Integer> params);
	
	
	@Select("select id,docid,userid,uname,time,msg,toid,toname,nices from culture_review where docid=#{docId}")
	List<Culture_review> getByDocId(Map<String,Integer> params);
	

	@Update("update culture_review set nices=#{nices} where id=#{id}")
	int Reviewnices(Culture_review review);
}
