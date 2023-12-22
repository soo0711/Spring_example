<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL core 라이브러리 (2)</title>
</head>
<body>
	<h1>1. 조건문 (c:choose, c:when, c:otherwise)</h1>
	<c:set var="weight" value="85" />
	<%-- ul 같은 tag --%>
	<c:choose>
		<%-- li 같은 tag --%>
		<c:when test="${weight < 60 }">
			떡볶이 먹자! <br>
		</c:when>
		<%-- else if 역할, 60이상 ~ 69이하 --%>
		<c:when test="${weight < 70 }">
			샐러드 먹자! <br>
		</c:when>
		<%-- c:otherwise 생략 가능 else 역할 --%>
		<%-- 70kg 이상 --%>
		<c:otherwise>
			굶자ㅠ <br>
		</c:otherwise>
	</c:choose>
	
	<%-- 대소문자 구분 잘해야함, forEach 노란색 경고 무시 --%>
	<h1>2. 반복문 (c:forEach)</h1>
	<%-- 시작과 끝 값 포함 --%>
	<%-- step="-1"이면 하나씩 빠진다. --%>
	<c:forEach begin="0" end="5" step="1" var="i">
		${i } <br>
	</c:forEach>
	
	<%-- 16 ~ 20: 5번 --%>	
	<%-- 지역변수라서 i 반복 사용 가능 --%>
	<%-- varStatus 쓸 때 보통 status로 지정 --%>
	<c:forEach begin="16" end="20" step="1" var="i" varStatus="status">
		var: ${i } 
		<%-- 현재 수는 --%>
		current: ${status.current } 
		<%-- 첫번째로 시작? --%>
		first: ${status.first }
		<%-- 마지막으로 끝? --%>
		last: ${status.last }
		<%-- index는 0부터 시작, 숫자로 돌리면 그 숫자부터 나온다. --%>
		index: ${status.index }
		<%-- 1부터 count --%>
		count: ${status.count }
		<br>
	</c:forEach>
	
	${fruits} <br>
	
	<%-- 서버에서 가져온 List<String> 출력 --%>
	<%-- 향상된 for문 같다. item과 var의 이름은 달라야한다. --%>
	<c:forEach items="${fruits }" var="fruit" varStatus="status">
		${fruit } ::: index: ${status.index} ::: count: ${status.count }
		<br>
	</c:forEach>

	<%-- 서버에서 가져온 List<Map> 테이블 출력 --%>
	<table border="1">
		<thead>
			<tr>
				<th>번호</th>
				<th>이름</th>
				<th>나이</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${users }" var="user" varStatus="status">
				<tr>
					<td>${status.count }</td>
					<td>${user.name }</td>
					<td>${user.age }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
</body>
</html>