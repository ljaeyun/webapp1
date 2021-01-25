package com.mycompany.webapp.dto;

import java.util.Date;

public class ch14Board {
	private int bno;
	private String btitle;
	private String bcontent;
	private String bwriter;
	private Date bdate;
	private int bhitcount;
	private String battachsavefilename;
	private String battachoriginalfilename;
	private String battachcontenttype;
	
	
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public String getBtitle() {
		return btitle;
	}
	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}
	public String getBcontent() {
		return bcontent;
	}
	public void setBcontent(String bcontent) {
		this.bcontent = bcontent;
	}
	public String getBwriter() {
		return bwriter;
	}
	public void setBwriter(String bwriter) {
		this.bwriter = bwriter;
	}
	public Date getBdate() {
		return bdate;
	}
	public void setBdate(Date bdate) {
		this.bdate = bdate;
	}
	public int getBhitcount() {
		return bhitcount;
	}
	public void setBhitcount(int bhitcount) {
		this.bhitcount = bhitcount;
	}
	public String getBattachsavefilename() {
		return battachsavefilename;
	}
	public void setBattachsavefilename(String battachsavefilename) {
		this.battachsavefilename = battachsavefilename;
	}
	public String getBattachoriginalfilename() {
		return battachoriginalfilename;
	}
	public void setBattachoriginalfilename(String battachoriginalfilename) {
		this.battachoriginalfilename = battachoriginalfilename;
	}
	public String getBattachcontenttype() {
		return battachcontenttype;
	}
	public void setBattachcontenttype(String battachcontenttype) {
		this.battachcontenttype = battachcontenttype;
	}
	
	
	
}
