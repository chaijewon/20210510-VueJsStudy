package com.sist.web;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.*;
import com.sist.dao.*;
@Controller
// forward , snedRedirect
/*
 *          �°�
 *    �޼ҵ� ====> ������ 
 *    malloc()  => new
 *    free()    => delete
 *    
 *    ������̼� 
 *    �޼ҵ忡�� ���Ǵ� ������̼� ======> Ŭ�������� ����ϴ� ������̼� 
 *      @ResopnseBody                 @RestController
 */
public class MovieController {
  
  @Autowired
  @Qualifier("movieDAO")
  private MovieDAO dao;
	
  @GetMapping("movie/list.do")
  public String movie_list(Model model)
  {
	  model.addAttribute("main_jsp", "../movie/list.jsp");
	  return "main/main";
  }
  @GetMapping(value="movie/movie_list.do",produces="text/plain;charset=UTF-8")
  @ResponseBody
  public String movie_movie_list(String page)
  {
	  String json="";
	  try
	  {
		if(page==null)
			page="1";
		int curpage=Integer.parseInt(page);
		Map map=new HashMap();
		int rowSize=12;
		int start=(rowSize*curpage)-(rowSize-1);
		int end=rowSize*curpage;
		map.put("start", start);
		map.put("end", end);
		List<MovieVO> list=dao.movieListData(map);
		//[{}..]
		JSONArray arr=new JSONArray();
		for(MovieVO vo:list)
		{
			JSONObject obj=new JSONObject();
			obj.put("mno", vo.getMno());
			obj.put("title", vo.getTitle());
			obj.put("poster",vo.getPoster());
			
			arr.add(obj);
		}
		json=arr.toJSONString();
	  }catch(Exception ex){}
	  return json;
  }
  @GetMapping("movie/movie_total.do")
  @ResponseBody
  public String movie_total()
  {
	  int total=dao.movieTotalPage();
	  return String.valueOf(total);
  }
  
  @GetMapping("movie/detail.do")
  public String movie_detail(int mno,Model model)
  {
	  model.addAttribute("mno", mno);
	  model.addAttribute("main_jsp", "../movie/detail.jsp");
	  return "main/main";
  }
}














