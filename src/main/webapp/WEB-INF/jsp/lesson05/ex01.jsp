<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL Core 라이브러리(1)</title>
</head>
<body>
	<h1>1. 변수 정의 (c:set)</h1>
	<%-- 두가지 방법, 하지만 value가 더 좋다. --%>
	<c:set var="number1" value="100" /> <%-- 숫자여도 따옴표 안에! 꼭 닫아야함!!! 노란줄이 나오면 import 안 한것 --%>
	<c:set var="number2">250</c:set>
	number1: ${number1} <br> <%-- 빨간줄이 나와도 브라우저에서만 잘 나오면 에러가 아니다. --%>
	number2: ${number2} <br>
	number1 + number2: ${number1 + number2} <br>
	
	<h1>2. 변수 출력하기 (c:out)</h1>
	<c:out value="hello world" /><br>
	<c:out value="${number1}" /> <br>
	
	<%-- 동작 안하게 하고 string으로 나오게 하기 --%>
	<%-- 문자열 escape라는 코드 --%>
	<c:out value="<script>alert('얼럿창 띄우기')</script>" /> <br>
	<%-- escapeXml = "true"가 기본값, 생략가능 --%>
	<c:out value="<script>alert('얼럿창 띄우기')</script>" escapeXml = "true" /> <br>
	<%-- alert창 띄우기 --%>
	<%-- 
	<c:out value="<script>alert('얼럿창 띄우기')</script>" escapeXml = "false" /> <br>
	--%>
	
	<h1>3. 조건문 (c:if)</h1>
	<c:if test="${number1 > 50}"> <%-- true면 안쪽으로 들어간다. 연산을 EL 안에서 해야한다.--%>
		number1은 50보다 크다. <br>
	</c:if>
	<%-- ==는 error가 날 때 있다. --%>
	<c:if test="${number1 == 100}">
		number1은 100이다. <br>
	</c:if>
	<%-- 정석 equal문 --%>
	<%-- == > eq, != > ne --%>
	<c:if test="${number1 eq 100}">
		number1은 100이다. <br>
	</c:if>
	
	
	<c:if test="${number1 != 50}">
		number1은 50이 아니다. <br>
	</c:if>
	<c:if test="${number1 ne 50}">
		number1은 50이 아니다. <br>
	</c:if>
	
	<%-- 나중에 많이 사용한다. --%>
	<c:if test="${empty number1}">
		number1은 비어있다. <br>
	</c:if>
	<%-- empty의 반대 방법 2가지 --%>
	<c:if test="${!empty number1}">
		number1은 비어있다. <br>
	</c:if>
	<%-- 정석 --%>
	<c:if test="${not empty number1}">
		number1은 비어있다. <br>
	</c:if>
	
	
</body>
</html>