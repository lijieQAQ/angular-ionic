package com.culture.mapper;

import java.util.List;





import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.culture.model.Culture_doctype;

public interface DocTypeMapper {
	//添加模块
	@Insert("insert into culture_doctype(id,name,state,sort,creatorid,creatorname,createtime,lastupdateuserid,lastupdateuser,lastupdatetime,isdelete) "
			+ "values(#{id},#{name},#{state},#{sort},#{creatorid},#{creatorname},#{createtime},#{lastupdateuserid},#{lastupdateuser},#{lastupdatetime},#{isdelete})")
	int addDocType(Culture_doctype type); 
	
	//修改模块
	@Update("update culture_doctype set name=#{name},sort=#{sort},lastupdatetime = #{lastupdatetime},lastupdateuser = #{lastupdateuser},lastupdateuserid=#{lastupdateuserid} where id = #{id}")
	int updateDocType(Culture_doctype type);
	
	@Select("select id,name,state,sort,creatorid,creatorname,createtime,lastupdateuserid,lastupdateuser,lastupdatetime,isdelete from culture_doctype where id=#{id}")
	Culture_doctype getById(Map<String,Integer> params);
	
	
	//根据id删除模块
	@Delete("delete from culture_doctype where id=#{id}")
	int deleteDocTypeById(Map<String,Integer> params);
	
	//根据id删除模块
	@Update("update culture_doctype set isdelete=#{isdelete} where id=#{id}")
	int deleteModuleById(Culture_doctype model);
	//获取所有模块信息
	
	@Select("select id,name,state,sort,creatorid,creatorname,createtime,lastupdateuserid,lastupdateuser,lastupdatetime,isdelete from culture_doctype where isdelete='0' order by sort asc")
	List<Culture_doctype> getAll();
	
	//获取所有有效的模块
	@Select("select id,name,state,sort,creatorid,creatorname,createtime,lastupdateuserid,lastupdateuser,lastupdatetime,isdelete from culture_doctype where state='1' and isdelete='0'")
	List<Culture_doctype> getEffectiveAll();
	
	//获取删除的模块
	@Select("select id,name,state,sort,creatorid,creatorname,createtime,lastupdateuserid,lastupdateuser,lastupdatetime,isdelete from culture_doctype where isdelete='1'")
	List<Culture_doctype> getDelete();
	
	//修改模块状态
	@Update("update culture_doctype set lastupdatetime = #{lastupdatetime},state = #{state},lastupdateuser = #{lastupdateuser},lastupdateuserid=#{lastupdateuserid} where id = #{id}")
	int updateState(Culture_doctype model);

	//根据id获得模块信息
	@Select("select * from culture_doctype where id=#{id}")
	Culture_doctype getModuleByid(Culture_doctype culture_doctype);
}
