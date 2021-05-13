package com.sist.web;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import com.sist.dao.*;
@RestController
public class RecipeController {
   @Autowired
   @Qualifier("dao")
   private RecipeDAO dao;
   
   @GetMapping(value="recipe/list.do",produces="text/plain;charset=UTF-8")
   public String recipe_list(String page)
   {
	   String json="";
	   try
	   {
		   if(page==null)
			   page="1";
		   int curpage=Integer.parseInt(page);
		   int rowSize=12;
		   int start=(rowSize*curpage)-(rowSize-1);
		   int end=rowSize*curpage;
		   Map<String,Integer> map=new HashMap<String,Integer>();
		   map.put("start", start);
		   map.put("end", end);
		   List<RecipeVO> list=dao.recipeListData(map);
		   //[]
		   JSONArray arr=new JSONArray();
		   //{} ==> [{},{},{}...]
		  
		   for(RecipeVO vo:list)
		   {
			   JSONObject obj=new JSONObject();
			   String ss=vo.getTitle();
			   if(ss.length()>24)
			   {
				   ss=ss.substring(0, 24)+"...";
			   }
			   obj.put("no", vo.getNo());
			   obj.put("title", ss);
			   obj.put("poster", vo.getPoster());
			   obj.put("chef", vo.getChef()); //{}
			   arr.add(obj);
		   }
		   
		   json=arr.toJSONString();
		   System.out.println(json);
	   }catch(Exception ex)
	   {
		   ex.printStackTrace();
	   }
	   return json;
   }
   @GetMapping("recipe/total.do")
   public String recipe_total()
   {
	   int total=dao.recipeTotalPage();
	   return String.valueOf(total);
   }
   /*
    *   POSTER      NOT NULL VARCHAR2(260)  
		CHEF        NOT NULL VARCHAR2(200)  
		CHEF_POSTER NOT NULL VARCHAR2(260)  
		TITLE       NOT NULL VARCHAR2(2000) 
		CONTENT     NOT NULL VARCHAR2(4000) 
		INFO1       NOT NULL VARCHAR2(20)   
		INFO2       NOT NULL VARCHAR2(20)   
		INFO3       NOT NULL VARCHAR2(20)   
		FOOD_MAKE   NOT NULL CLOB           
		CHEF_INFO   NOT NULL VARCHAR2(1000) 
    */
   /*
    *          axios.get("http://localhost/web/recipe/detail.do",{
    				params:{
    					rno:no
    				}
    			})
    */
   @GetMapping(value="recipe/detail.do",produces="text/plain;charset=UTF-8")
   public String recipe_detail(int rno)
   {
	   String json="";
	   try
	   {
		   RecipeDetailVO vo=dao.recipeDetailData(rno);
		   JSONObject obj=new JSONObject();//{}
		   obj.put("poster", vo.getPoster());
		   obj.put("chef", vo.getChef());
		   obj.put("chef_poster", vo.getChef_poster());
		   obj.put("title", vo.getTitle());
		   obj.put("content", vo.getContent());
		   obj.put("info1", vo.getInfo1());
		   obj.put("info2", vo.getInfo2());
		   obj.put("info3", vo.getInfo3());
		   obj.put("food_make", vo.getFood_make());
		   obj.put("chef_info", vo.getChef_info());
		   
		   json=obj.toJSONString();
	   }catch(Exception ex){}
	   return json;
   }
}





























