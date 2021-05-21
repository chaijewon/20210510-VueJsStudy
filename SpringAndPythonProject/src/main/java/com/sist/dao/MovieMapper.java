package com.sist.dao;
import java.util.*;
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
import org.apache.ibatis.annotations.Select;
public interface MovieMapper {
   @Select("SELECT mno,poster,title,regdate,genre,nation,grade,time,score,num "
		  +"FROM (SELECT mno,poster,title,regdate,genre,nation,grade,time,score,rownum as num "
		  +"FROM (SELECT /*+ INDEX_ASC(daum_movie dm_mno_pk) */ mno,poster,title,regdate,genre,nation,grade,time,score "
		  +"FROM daum_movie)) "
		  +"WHERE num BETWEEN #{start} AND #{end}")
   public List<MovieVO> movieListData(Map map);
   
   @Select("SELECT * FROM daum_movie "
		  +"WHERE mno=#{mno}")
   public MovieVO movieDetailData(int mno);
   
}















