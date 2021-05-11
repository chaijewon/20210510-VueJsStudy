package com.sist.web;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import com.sist.dao.*;
// VueJs로 값을 전송 
@RestController
public class FoodRestController {
   @Autowired
   private FoodDAO dao;
   @GetMapping(value="food/category.do",produces="text/plain;charset=UTF-8")
   public String food_category(int no)
   {
	   String json="";
	   try
	   {
		   // DAO에서 값을 읽어 온다 
		   Map map=new HashMap();
		   int start=0;
		   int end=0;
		   if(no==1)
		   {
			   start=1;
			   end=12;
		   }
		   else if(no==2)
		   {
		       start=13;
		       end=18;
		   }
		   else if(no==3)
		   {
			   start=19;
			   end=30;
		   }
		   map.put("start", start);
		   map.put("end", end);
		   List<FoodCategoryVO> list=dao.foodCategoryData(map);
		   //[{},{},{}] => [] => List  , {} => VO
		   JSONArray arr=new JSONArray();
		   for(FoodCategoryVO vo:list)
		   {
			   JSONObject obj=new JSONObject();
			   obj.put("no", vo.getNo());
			   obj.put("title", vo.getTitle());
			   obj.put("poster", vo.getPoster());
			   obj.put("subject", vo.getSubject());
			   // 배열에 첨부
			   arr.add(obj);
		   }
		   
		   json=arr.toJSONString();
	   }catch(Exception ex){}
	   return json;
   }
}














