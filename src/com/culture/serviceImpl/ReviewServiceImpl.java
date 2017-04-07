package com.culture.serviceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.culture.mapper.ReviewMapper;
import com.culture.model.Culture_review;
import com.culture.service.ReviewService;

@Service
public class ReviewServiceImpl implements ReviewService{
	
	@Autowired
	private ReviewMapper rDao;

	@Override
	public int addReview(Culture_review review) {
		return rDao.addReview(review);
	}

	@Override
	public int updateReview(Culture_review review) {
		return rDao.updateReview(review);
	}

	@Override
	public int Reviewnices(Culture_review review) {
		return rDao.Reviewnices(review);
	}
	@Override
	public int deleteById(int id) {
		Culture_review dr=getById(id);
		if(dr!=null){
			Map<String, Integer>  params=new HashMap<String, Integer>();
			params.put("id", id);
			return rDao.deleteById(params);
		}
		return 0;
	}

	@Override
	public Culture_review getById(int id) {
		Map<String, Integer>  params=new HashMap<String, Integer>();
		params.put("id", id);
		return rDao.getById(params);
	}

	@Override
	public List<Culture_review> getByDocId(int docId) {
		Map<String, Integer>  params=new HashMap<String, Integer>();
		params.put("docId", docId);
		return rDao.getByDocId(params);
	}

}
