package com.culture.model;

import java.io.Serializable;

public class Culture_nice implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7331131462418641173L;
	private int id;
	private int uid;
	private int docid;
	private String uame;
	public Culture_nice() {

	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public int getDocid() {
		return docid;
	}
	public void setDocid(int docid) {
		this.docid = docid;
	}
	public String getUame() {
		return uame;
	}
	public void setUame(String uame) {
		this.uame = uame;
	}

}
