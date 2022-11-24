package com.board.model;

public class BoardDTO {
	private int num;
	private String userid;
	private String subject;
	private String email;
	private int readcount;
	private String content;
	private String regdate;
	
	//getter, setter
	public int getNum() {
		return num ;
	}  
	public void setNum(int num) {
	}
	public String getUserid() {
		return userid == null ? "" : userid.trim();
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getSubject() {
		return subject == null ? "" : subject.trim();
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getEmail() {
		return email == null ? "" : email.trim();
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getReadcount() {
		return readcount ;
	}
	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}
	public String getContent() {
		return content == null ? "" : content.trim();
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getRegdate() {
		return regdate == null ? "" : regdate.trim();
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	
	
	
}
