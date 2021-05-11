<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<style type="text/css">
.row {
  margin: 0px auto;
}
</style>
</head>
<body>
  <div id="app">
	  <div class="row">
	   <div class="jumbotron text-center">
	     <h1>{{title}}</h1>
	     <h4>{{subject}}</h4>
	   </div>
	  </div>
	  <div class="row">
	  
	  </div>
	  <script>
	   new Vue({
		   el:'#app',
		   data:{
			   title:'',
			   subject:'',
			   food:{},
			   cno:${no},
			   no:1
		   },
		   mounted:function(){
			   
		   }
	   })
	  </script>
  </div>
</body>
</html>