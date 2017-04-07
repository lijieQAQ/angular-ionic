package com.culture.model;

import java.io.Serializable;
import java.util.Date;

public class Culture_article implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5487877871435416666L;
	private int id;
	private String title;
	private String passage;  //简介
	private String content;  //内容
	private int doctypeid;   //类型
	private char state;      //状态
	private char isPlay;      //是否轮播
	private char isReply;      //是否可以评论
	private char isThumbsUp;      //是否可以点赞
	private String url;     //封面图片地址
	private int reviewcount;  //评论数
	private int writerid;     //作者
	private int creatorid;   //创建人id
	private String creatorname;
	private Date createTime;  //创建时间
	private Date releaseTime;  //发布时间
	public Culture_article() {

	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	public String getPassage() {
		return passage;
	}
	public void setPassage(String passage) {
		this.passage = passage;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getDoctypeid() {
		return doctypeid;
	}
	public void setDoctypeid(int doctypeid) {
		this.doctypeid = doctypeid;
	}
	public char getState() {
		return state;
	}
	public void setState(char state) {
		this.state = state;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public int getReviewcount() {
		return reviewcount;
	}
	public void setReviewcount(int reviewcount) {
		this.reviewcount = reviewcount;
	}
	public int getWriterid() {
		return writerid;
	}
	public void setWriterid(int writerid) {
		this.writerid = writerid;
	}
	public int getCreatorid() {
		return creatorid;
	}
	public void setCreatorid(int creatorid) {
		this.creatorid = creatorid;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getReleaseTime() {
		return releaseTime;
	}
	public void setReleaseTime(Date releaseTime) {
		this.releaseTime = releaseTime;
	}
	public String getCreatorname() {
		return creatorname;
	}
	public void setCreatorname(String creatorname) {
		this.creatorname = creatorname;
	}
	public char getIsPlay() {
		return isPlay;
	}
	public void setIsPlay(char isPlay) {
		this.isPlay = isPlay;
	}
	public char getIsReply() {
		return isReply;
	}
	public void setIsReply(char isReply) {
		this.isReply = isReply;
	}
	public char getIsThumbsUp() {
		return isThumbsUp;
	}
	public void setIsThumbsUp(char isThumbsUp) {
		this.isThumbsUp = isThumbsUp;
	}
	
	
	
}
