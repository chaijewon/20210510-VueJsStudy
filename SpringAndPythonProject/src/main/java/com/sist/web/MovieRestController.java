package com.sist.web;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import com.sist.dao.*;
@RestController
public class MovieRestController {
   @Autowired
   private MovieDAO dao;
   
   @GetMapping("movie/list.do")
   public String movie_list(String page)
   {
	   String json="";
	   try
	   {
		   if(page==null)
			   page="1";
		   int curpage=Integer.parseInt(page);
		   int rowSize=10;
		   int start=(rowSize*curpage)-(rowSize-1);
		   int end=rowSize*curpage;
		   Map map=new HashMap();
		   map.put("start", start);
		   map.put("end", end);
		   List<MovieVO> list=dao.movieListData(map);
		   /*
		    *  REGDATE             VARCHAR2(200) 
				GENRE      NOT NULL VARCHAR2(100) 
				NATION     NOT NULL VARCHAR2(50)  
				GRADE      NOT NULL VARCHAR2(50)  
				TIME       NOT NULL VARCHAR2(50)  
		    */
		   //JSON변경 
		   // [{} , {} ]
		   JSONArray arr=new JSONArray();
		   for(MovieVO vo:list)
		   {
			   JSONObject obj=new JSONObject();
			   obj.put("mno", vo.getMno());
			   obj.put("title", vo.getTitle());
			   obj.put("regdate", vo.getRegdate());
			   obj.put("genre", vo.getGenre());
			   obj.put("nation", vo.getNation());
			   obj.put("grade", vo.getGrade());
			   obj.put("time", vo.getTime());
			   
			   arr.add(obj);
		   }
		   json=arr.toJSONString();
	   }catch(Exception ex){}
	   return json;
   }
}













