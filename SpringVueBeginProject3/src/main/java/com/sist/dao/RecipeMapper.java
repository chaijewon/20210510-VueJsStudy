package com.sist.dao;

import org.apache.ibatis.annotations.Select;
import java.util.*;
/*
 *  NO     NOT NULL NUMBER         
POSTER NOT NULL VARCHAR2(260)  
TITLE  NOT NULL VARCHAR2(1000) 
CHEF   NOT NULL VARCHAR2(200) 
 */
public interface RecipeMapper {
   @Select("SELECT no,poster,title,chef,num "
		 +"FROM (SELECT no,poster,title,chef,rownum as num "
		 +"FROM (SELECT /*+ INDEX_ASC(recipe recipe_no_pk)*/ no,poster,title,chef "
		 +"FROM recipe)) "
		 +"WHERE num BETWEEN #{start} AND #{end}")
   public List<RecipeVO> recipeListData(Map map);
   
   @Select("SELECT CEIL(COUNT(*)/12.0) FROM recipe")
   public int recipeTotalPage();
   
   @Select("SELECT * FROM recipe_make "
		  +"WHERE rno=#{rno}")
   public RecipeDetailVO recipeDetailData(int rno);
}
