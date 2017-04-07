package com.culture.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.culture.model.Culture_article;



public interface DocMapper {
	
	@Select("select d.id,d.title,d.passage,d.content,d.doctypeid,d.state,d.isPlay,d.isReply,d.isThumbsUp,d.url,d.reviewcount,d.writerid,d.creatorid,d.creatorname,d.createTime,d.releaseTime from culture_article d where id=#{id}")
	public Culture_article getDocById(Map<String,Integer> params);
	
	int updateDoc(Culture_article doc);
	
	@Update("update culture_article set state=#{state} where id=#{docId}")
	int updateDocState(Map<String,Object> params);
	
	int addDoc(Culture_article doc);
	
	@Delete("delete from culture_article where id=#{id}")
	int deleteById(Map<String,Integer> params);
	
	/**params
	 * int docType
	 * int start  第几页
	 * int end 单页条数
	 * */
	List<Culture_article> getForPage(Map<String,Integer> params);  //获取单个模块的所有文章分页
	
	Map<String,Long> getCount(Map<String,Integer> params); //获取单个模块的文章的条数
	
	@Select("select d.id,d.title,d.passage,d.doctypeid,d.state,d.isPlay,d.isReply,d.isThumbsUp,d.url,d.reviewcount,d.writerid,d.creatorid,d.creatorname,d.createTime,d.releaseTime from culture_article d "
			+ "where d.state=2 and d.isPlay=2 and d.doctypeid=#{docType}")
	List<Culture_article> getShufflingList(Map<String,Integer> params);   //获取单个模块的轮播文章
	
	
	@Select("select count(1) as count from culture_article where d.state=2 and d.isPlay=2 and doctypeid=#{docType}")
	Map<String,Long> getCountShuffling(Map<String,Integer> params);   //获取单个模块的轮播文章条数
	
	/**params
	 * int docType
	 * int start  第几页
	 * int end 单页条数
	 * 
	 * */
	@Select("select d.id,d.title,d.passage,d.doctypeid,d.state,d.isPlay,d.isReply,d.isThumbsUp,d.url,d.reviewcount,d.writerid,d.creatorid,d.creatorname,d.createTime,d.releaseTime from culture_article d where "
			+ "d.state=2  and d.isPlay=1 and d.doctypeid=#{docType} order by d.releaseTime desc limit #{start},#{end}")
	List<Culture_article> getOnlineForPage(Map<String,Integer> params);    //获取单个模块的上线文章
	
	
	@Select("select count(1) as count from culture_article c where state=2 and isPlay=1 and doctypeid=#{docType}")
	Map<String,Long> getCountOnline(Map<String,Integer> params);    //获取单个模块的上线文章
	

	
	/**params
	 * String title  标题
	 * int docType  文章类型
	 * int start  第几页
	 * int end 单页条数
	 * 
	 * */	
	
	List<Culture_article> getByTitleForPage(Map<String,Object> params); //根据标题获取单个模块的文章  基于分页
	

	Map<String,Long> getCountByTitle(Map<String,Object> params);  //根据标题获取单个模块的文章
	
	/**params
	 * String title  标题
	 * int docType  文章类型
	 * int state  文章类型
	 * int isPlay  文章类型
	 * int start  第几页
	 * int end 单页条数
	 * 
	 * */	
	List<Culture_article> getByTitelOrStateOrTypeOrIsPlayForPage(Map<String,Object> params); //根据标题获取单个模块的文章  基于分页
	
	
	Map<String,Long> getCountByTitelOrStateOrTypeOrIsPlay(Map<String,Object> params);  //根据标题获取单个模块的文章
	
	

	
	
	
	

}
