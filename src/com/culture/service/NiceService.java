package com.culture.service;

import java.util.List;

import com.culture.model.Culture_nice;

public interface NiceService {
	
	int addNice(Culture_nice nice);
	
	int deleteById(int id);
	
	int updateNice(Culture_nice nice);
	
	List<Culture_nice> getNiceByDocId(int docId);
	
	Culture_nice getById(int id);
	
	long getNiceCountByDocId(int docId);

	Boolean getNiceByDocidAndUserid(String docid, String userid);

	int deleteNice(Culture_nice nice);

}
