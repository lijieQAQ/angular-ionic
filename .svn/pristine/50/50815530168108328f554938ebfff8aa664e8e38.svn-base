package com.culture.serviceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.culture.mapper.DocMapper;
import com.culture.model.Culture_article;
import com.culture.service.ArticleService;

@Service
public class ArticleServiceImpl implements ArticleService {
	
	@Autowired
	private DocMapper docDao;

	@Override
	public Culture_article getDocById(int id) {
		Map<String, Integer>  params=new HashMap<String, Integer>();
		params.put("id", id);
		return docDao.getDocById(params);
	}

	@Override
	public int updateDoc(Culture_article doc) {
		return docDao.updateDoc(doc);
	}

	@Override
	public int addDoc(Culture_article doc) {

		return docDao.addDoc(doc);
	}

	@Override
	public int deleteById(int id) {
		Culture_article doc=getDocById(id);
		if(doc!=null){
			Map<String, Integer>  params=new HashMap<String, Integer>();
			params.put("id", id);
			return docDao.deleteById(params);
		}
		return 0;
	}

	//获取当个或所有模块的文章的分页数据  docType=0时是查询所有
	
	@Override
	public Map<String, Object> getForPage(int docType, int index, int count) {
		Map<String, Object>  result=new HashMap<String, Object>();
		Map<String, Integer>  params=new HashMap<String, Integer>();
		int start=(index-1)*count;
		params.put("start", start);
		params.put("end", count);
		params.put("docType",docType);
		System.out.println("params==="+params.toString());
		result.put("list", docDao.getForPage(params));
		System.out.println(docDao.getCount(params).toString());
		result.put("allCount", docDao.getCount(params).get("count"));
		result.put("pageIndex", index);
		result.put("pageCount", count);
		return result;
	}

	//获取当个模块的轮播数据
	@Override
	public List<Culture_article> getShufflingList(int docType) {
		Map<String, Integer>  params=new HashMap<String, Integer>();
		params.put("docType",docType);
		return docDao.getShufflingList(params);
	}

	
	//获取当个模块的上线的文章分页数据
	@Override
	public Map<String, Object> getOnlineForPage(int docType, int index,
			int count) {
		Map<String, Object>  result=new HashMap<String, Object>();
		Map<String, Integer>  params=new HashMap<String, Integer>();
		int start=(index-1)*count;
		params.put("start", start);
		params.put("end", count);
		params.put("docType",docType);
		result.put("list", docDao.getOnlineForPage(params));
		result.put("allCount", docDao.getCountOnline(params).get("count"));
		result.put("pageIndex", index);
		result.put("pageCount", count);
		return result;
	}
	//根据文章标题查询单个或所有模块的列表数据   docType=0时是查询所有
	@Override
	public Map<String, Object> getByTitleForPage(String title, int docType,
			int index, int count) {
		Map<String, Object>  result=new HashMap<String, Object>();
		Map<String, Object>  params=new HashMap<String, Object>();
		int start=(index-1)*count;
		params.put("start", start);
		params.put("end",count);
		params.put("docType",docType);
		params.put("title",title);
		result.put("list", docDao.getByTitleForPage(params));
		result.put("allCount", docDao.getCountByTitle(params).get("count"));
		result.put("pageIndex", index);
		result.put("pageCount", count);
		return result;
	}

	@Override
	public int updateDoc(int docid, char state) {
		Map<String, Object>  result=new HashMap<String, Object>();
		result.put("docId", docid);
		result.put("state", state);
		return docDao.updateDocState(result);
	}

	@Override
	public Map<String, Object> getByTitelOrStateOrTypeOrIsPlayForPage(
			int docType, char state, char isPlay, String title, int index,
			int count) {
		Map<String, Object>  result=new HashMap<String, Object>();
		Map<String, Object>  params=new HashMap<String, Object>();
		int start=(index-1)*count;
		params.put("start", start);
		params.put("end",count);
		params.put("docType",docType);
		params.put("title","".equals(title)?null:title);
		params.put("state",state);
		params.put("isPlay",isPlay);
		System.out.println("params==="+params.toString());
		
		result.put("list", docDao.getByTitelOrStateOrTypeOrIsPlayForPage(params));
		result.put("allCount", docDao.getCountByTitelOrStateOrTypeOrIsPlay(params).get("count"));
		result.put("pageIndex", index);
		result.put("pageCount", count);
		return result;
	}





}
