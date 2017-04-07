package com.culture.model;

import java.io.Serializable;
import java.util.Date;

public class Culture_doctype implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -849508552218326261L;
	private int id;
	private String name;
	private char state;
	private int sort;
	private int creatorid;
	private String creatorname;
	private Date createtime;
	private int  lastupdateuserid;
	private String lastupdateuser;
	private Date lastupdatetime;
	private char isdelete;
	public Culture_doctype() {

	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public char getState() {
		return state;
	}
	public void setState(char state) {
		this.state = state;
	}
	public int getSort() {
		return sort;
	}
	public void setSort(int sort) {
		this.sort = sort;
	}
	public int getCreatorid() {
		return creatorid;
	}
	public void setCreatorid(int creatorid) {
		this.creatorid = creatorid;
	}
	public String getCreatorname() {
		return creatorname;
	}
	public void setCreatorname(String creatorname) {
		this.creatorname = creatorname;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	public int getLastupdateuserid() {
		return lastupdateuserid;
	}
	public void setLastupdateuserid(int lastupdateuserid) {
		this.lastupdateuserid = lastupdateuserid;
	}
	public String getLastupdateuser() {
		return lastupdateuser;
	}
	public void setLastupdateuser(String lastupdateuser) {
		this.lastupdateuser = lastupdateuser;
	}
	public Date getLastupdatetime() {
		return lastupdatetime;
	}
	public void setLastupdatetime(Date lastupdatetime) {
		this.lastupdatetime = lastupdatetime;
	}
	public char getIsdelete() {
		return isdelete;
	}
	public void setIsdelete(char isdelete) {
		this.isdelete = isdelete;
	}


}
