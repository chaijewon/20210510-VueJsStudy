<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.min.js"></script>
  <script src="https://unpkg.com/axios/dist/axios.min.js"></script>
  <style type="text/css">
  .recipe_images:hover{
    cursor: pointer;
    border: 2px solid red;
  }
  </style>
</head>
<body>
   <div style="height: 50px"></div>
   <div class="container-fluid">
     <div class="col-md-8">
       <template id="recipe-template">
          <div class="col-md-4" v-for="vo in recipe_data">
		     <div class="thumbnail">
                <img :src="vo.poster" alt="Lights" style="width:100%" class="recipe_images" v-on:click="showDetail(vo.no)">
		        <div class="caption">
		          <p style="font-size: 9px">{{vo.title}}</p>
		          <sub style="font-size:8px">{{vo.chef}}</sub>
		        </div>
		    </div>
       </template>
       <div style="height: 20px"></div>
       <div class="text-center">
         <button class="btn btn-sm btn-primary">이전</button>
          {{curpage}} page / {{totalpage}} pages
         <button class="btn btn-sm btn-primary">다음</button>
       </div>
     </div>
     <div class="col-md-4">
     
     </div>
   </div>
   <!-- 
       created = mounted = updated = destoryed : 생명주기 함수 
       ======================================= Vue에서 지원하는 함수 (Callback함수:시스템에 의해서 자동호출)
       
       class A
       {
           B b=new B(){
             this (B)
           }
       }
    -->
   <script>
    Vue.component('recipe',{
    	props:['recipe'],
    	template:'#recipe-template'
    })
    new Vue({
    	el:'.container-fluid',
    	data:{
    		recipe_data:[],
    		curpage:1,
    		totalpage:1,
    		recipe_detail:{}
    	},
    	mounted:function(){
    		// 데이터 읽기
    		let _this=this;
    		axios.get("http://localhost/web/recipe/list.do").then(function(response)
    		{
    			_this.recipe_data=response.data
    		});
    		// 총페이지 읽기
    		axios.get("http://localhost/web/recipe/total.do").then(function(response){
    			_this.totalpage=response.data
    		})
    	},
    	methods:{
    		showDetail:function(no){
    			// http://localhost/web/recipe/detail.do?rno=1
    		    let _this=this
    			axios.get("http://localhost/web/recipe/detail.do",{
    				params:{
    					rno:no
    				}
    			}).then(function(response){
    				_this.recipe_detail=response.data
    			})
    		}
    	}
    })
   </script>
</body>
</html>

















