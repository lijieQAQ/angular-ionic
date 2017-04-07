package com.culture.serviceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.culture.mapper.NiceMapper;
import com.culture.model.Culture_article;
import com.culture.model.Culture_nice;
import com.culture.service.NiceService;

@Service
public class NiceServiceImpl implements NiceService{
	
	@Autowired
	private NiceMapper nDao;

	@Override
	public int addNice(Culture_nice nice) {
		return nDao.addNice(nice);
	}

	@Override
	public int deleteById(int id) {
		Culture_nice dn=getById(id);
		if(dn!=null){
			Map<String, Integer>  params=new HashMap<String, Integer>();
			params.put("id", id);
			return nDao.deleteById(params);
		}		
		return 0;
		
	}

	@Override
	public int updateNice(Culture_nice nice) {
		return nDao.updateNice(nice);
	}

	@Override
	public List<Culture_nice> getNiceByDocId(int docId) {
		Map<String, Integer>  params=new HashMap<String, Integer>();
		params.put("docId", docId);
		return nDao.getNiceByDocId(params);
	}

	@Override
	public Culture_nice getById(int id) {
		Map<String, Integer>  params=new HashMap<String, Integer>();
		params.put("id", id);
		return nDao.getById(params);
	}

	@Override
	public long getNiceCountByDocId(int docId) {
		Map<String, Integer>  params=new HashMap<String, Integer>();
		params.put("docId", docId);
		return nDao.getNiceCountByDocId(params).get("count");
	}

	@Override
	public Boolean getNiceByDocidAndUserid(String docid, String userid) {
		Map<String, Integer>  params=new HashMap<String, Integer>();
		params.put("docid",Integer.valueOf(docid));
		params.put("userid",Integer.valueOf(userid));
		int Mnice=nDao.getNiceByDocidAndUserid(params);
		if (Mnice>0) {
			return true;
		}else{
			return false;
		}
	}

	@Override
	public int deleteNice(Culture_nice nice) {
		return nDao.deleteNice(nice);
		
	}
	
	
	
	

}
