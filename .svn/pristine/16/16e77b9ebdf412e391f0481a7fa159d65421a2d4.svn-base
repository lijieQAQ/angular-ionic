package com.culture.serviceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.culture.mapper.DocTypeMapper;
import com.culture.model.Culture_doctype;
import com.culture.service.DocTypeService;

@Service
public class DocTypeServiceImpl implements DocTypeService{
	
	@Autowired
	private DocTypeMapper docTypeDao;

	@Override
	public int addDocType(Culture_doctype type) {
		return docTypeDao.addDocType(type);
	}

	@Override
	public int updateDocType(Culture_doctype type) {
		return docTypeDao.updateDocType(type);
	}

	@Override
	public Culture_doctype getById(int id) {
		Map<String, Integer>  params=new HashMap<String, Integer>();
		params.put("id", id);
		return docTypeDao.getById(params);
	}
	
	@Override
	public int deleteDocTypeById(int id) {
		Culture_doctype dtype=getById(id);
		if(dtype!=null){
			dtype.setIsdelete('1');
			return docTypeDao.updateDocType(dtype);
		}
		return 0;
	}

	@Override
	public List<Culture_doctype> getAll() {

		return docTypeDao.getAll();
	}

	@Override
	public List<Culture_doctype> getEffectiveAll() {
		return docTypeDao.getEffectiveAll();
	}

	@Override
	public List<Culture_doctype> getDelete() {
		return docTypeDao.getDelete();
	}

	@Override
	public int updateState(Culture_doctype model) {
		return docTypeDao.updateState(model);
	}

	@Override
	public int deleteModuleById(Culture_doctype model) {
		return docTypeDao.deleteModuleById(model);
		
	}

	@Override
	public Culture_doctype getModuleByid(Culture_doctype mos) {
		return docTypeDao.getModuleByid(mos);
	}



}
