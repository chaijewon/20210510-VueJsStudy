package com.sist.dao;
/*
 *  MNO        NOT NULL NUMBER        
	CNO                 NUMBER        
	POSTER     NOT NULL VARCHAR2(260) 
	TITLE      NOT NULL VARCHAR2(200) 
	REGDATE             VARCHAR2(200) 
	GENRE      NOT NULL VARCHAR2(100) 
	NATION     NOT NULL VARCHAR2(50)  
	GRADE      NOT NULL VARCHAR2(50)  
	TIME       NOT NULL VARCHAR2(50)  
	SCORE               NUMBER(2,1)   
	SHOWUSER            VARCHAR2(30)  
	BOXOFFICE           VARCHAR2(10)  
	STORY               CLOB          
	KEY                 VARCHAR2(30)       
 */
public class MovieVO {
    private int mno,cno,replycount;
    private String poster,title,regdate,genre,nation,grade,time,showUser,boxoffice,story,key;
    private double score;
    
	public int getReplycount() {
		return replycount;
	}
	public void setReplycount(int replycount) {
		this.replycount = replycount;
	}
	public int getMno() {
		return mno;
	}
	public void setMno(int mno) {
		this.mno = mno;
	}
	public int getCno() {
		return cno;
	}
	public void setCno(int cno) {
		this.cno = cno;
	}
	public String getPoster() {
		return poster;
	}
	public void setPoster(String poster) {
		this.poster = poster;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getNation() {
		return nation;
	}
	public void setNation(String nation) {
		this.nation = nation;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getShowUser() {
		return showUser;
	}
	public void setShowUser(String showUser) {
		this.showUser = showUser;
	}
	public String getBoxoffice() {
		return boxoffice;
	}
	public void setBoxoffice(String boxoffice) {
		this.boxoffice = boxoffice;
	}
	public String getStory() {
		return story;
	}
	public void setStory(String story) {
		this.story = story;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
   
}
