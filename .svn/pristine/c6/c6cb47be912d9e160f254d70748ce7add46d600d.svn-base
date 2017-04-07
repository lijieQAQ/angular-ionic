package com.culture.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

import com.culture.model.Culture_article;


public interface ArticleService {

	public Culture_article getDocById(int id);   //根据id 获取文章
	
	int updateDoc(Culture_article doc);
	
	int updateDoc(int docid,char state);
	
	int addDoc(Culture_article doc);
	
	int deleteById(int id);
	
	/**params
	 * int docType
	 * int start  第几页
	 * int end 单页条数
	 * 
	 * */
	Map<String,Object> getForPage(int docType,int index,int count);  //获取单个模块的所有文章分页
	
	
	List<Culture_article> getShufflingList(int docType);   //获取单个模块的轮播文章
	
	
	Map<String,Object> getOnlineForPage(int docType,int index,int count);    //获取单个模块的上线文章
	
	Map<String,Object> getByTitelOrStateOrTypeOrIsPlayForPage(int docType,char state,char isPlay,String title,int index,int count);
	
	/**params
	 * String title  标题
	 * int docType  文章类型
	 * int start  第几页
	 * int end 单页条数
	 * 
	 * */		
	Map<String,Object> getByTitleForPage(String title,int docType,int index,int count); //根据标题获取单个模块的文章  基于分页

}
