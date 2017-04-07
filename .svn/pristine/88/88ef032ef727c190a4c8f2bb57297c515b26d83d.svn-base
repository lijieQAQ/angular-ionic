package com.culture.service;

import java.util.List;

import com.culture.model.Culture_doctype;

public interface DocTypeService {
	
	//添加模块
	int addDocType(Culture_doctype type); 
	//修改模块
	int updateDocType(Culture_doctype type);
	
	Culture_doctype getById(int id);
	
	//根据id删除模块
	int deleteDocTypeById(int id);
	
	//获取所有模块信息
	List<Culture_doctype> getAll();
	
	//获取所有有效的模块
	List<Culture_doctype> getEffectiveAll();
		
	//获取删除的模块
	List<Culture_doctype> getDelete();
	
	//更新模块状态
	int updateState(Culture_doctype model);
	
	//根据模块id逻辑删除模块
	int deleteModuleById(Culture_doctype model);
	
	//根据id获取模块信息
	Culture_doctype getModuleByid(Culture_doctype mos);
}
