package com.culture.model;

import java.io.Serializable;
import java.util.Date;

public class Culture_review implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5645655173306001016L;
	private int id;
	private int docid;
	private int userid;
	private String uname;
	private Date time;
	private String msg;
	private int toid;
	private String toname;
	private String nices;
	public Culture_review() {

	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getDocid() {
		return docid;
	}
	public void setDocid(int docid) {
		this.docid = docid;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public int getToid() {
		return toid;
	}
	public void setToid(int toid) {
		this.toid = toid;
	}
	public String getToname() {
		return toname;
	}
	public void setToname(String toname) {
		this.toname = toname;
	}
	public String getNices() {
		return nices;
	}
	public void setNices(String nices) {
		this.nices = nices;
	}
	
	
	
	
}
