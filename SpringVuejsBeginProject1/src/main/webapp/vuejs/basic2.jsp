<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!-- 
     디렉티브 
     제어문 
   ====
   v-if : 조건문
   v-for : 반복문 
   v-else 
   v-show : 화면 보여주기 
   v-hide : 화면 감추기 
   v-model : 양방향 통신 (입력값 => 출력)
   
     이벤트 처리 : 버튼 클릭 ,콤보박스 선택 ...
   
     컴포넌트 제작 => 이벤트 버스 (양방향 채팅이 가능) 
     
     템플릿, 라우트  
 -->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.row {
  margin: 0px auto;
  width:900px
}
h1{
   text-align: center
}
</style>
<script src="https://unpkg.com/vue"></script>
</head>
<body>
   <div style="height: 40px"></div>
   <div class="container">
     <h1>영화목록</h1>
     <div class="row" id="app">
       
     </div>
   </div>
</body>
</html>













