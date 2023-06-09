<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>home</title>
    <link rel="stylesheet" href="resources/css/home.css">
</head>
<body>
    <h2>사용자 매뉴얼 </h2>
    <div class="wrapper">
	<div class="wrap">
		<div class="top_gnb_area">
			<h1>gnb area</h1>
		</div>
		<div class="top_area">
			<div class="logo_area">
				<h1>logo area</h1>
			</div>
			<div class="search_area">
				<h1>Search area</h1>
			</div>
			<div class="login_area">
			
				<!-- 로그인 하지 않은 상태 -->
                <c:if test = "${memberDTO == null }">
                    <div class="login_button"><a href="/member/login">로그인</a></div>
                    <span><a href="/member/join">회원가입</a></span>                
                </c:if>    
                
                <!-- 로그인한 상태 -->
                <c:if test="${ memberDTO != null }">
                <div class="login_success_area">
            		<span>회원이름 :${memberDTO.memberName} </span>
            		<a href="/member/logout">로그아웃</a>
            		</div>
                </c:if>
				
			</div>
			<div class="clearfix"></div>			
		</div>
		<div class="navi_bar_area">
			<h1>navi area</h1>
		</div>
		<div class="content_area">
			<h1>content area</h1>
		</div>
	</div>
</div>
</body>
</html>