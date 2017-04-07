package com.culture.util;

import java.util.List;



public class Page<T>{
	  
	@SuppressWarnings("unused")
	private int pageCount; //有多少页
	private int pageIndex;  //当前页码
	private int pageSize;   //页面大小，一页有多少条
	@SuppressWarnings("unused")
	private int reultCount; //当前页返回条数
	private int reultAllCount;  //总共有多少条数
	private List<T> list;
	public Page() {
	}
	public Page(int pageCount, int pageIndex, int pageSize, List<T> list) {
		this.pageCount = pageCount;
		this.pageIndex = pageIndex;
		this.pageSize = pageSize;
		this.list = list;
	}
	public int getPageCount() {
		int count=0;
		if(reultAllCount !=0){
			if(reultAllCount % pageSize==0){
				count=reultAllCount/pageSize;
			}else{
				
				count=reultAllCount/pageSize+1;
			}
		}
		return count;
	}
	public int getPageIndex() {
		return pageIndex;
	}
	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	public int getReultCount() {
		return this.list.size();
	}
	public int getReultAllCount() {
		return reultAllCount;
	}
	public void setReultAllCount(int reultAllCount) {
		this.reultAllCount = reultAllCount;
	}
	public void setReultCount(int reultCount) {
		this.reultCount = reultCount;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
}
