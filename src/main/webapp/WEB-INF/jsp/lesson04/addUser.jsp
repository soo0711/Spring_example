<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"
	integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
	integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct"
	crossorigin="anonymous"></script>
</head>
<body>
	<div class="container">
		<h1>회원가입</h1>
		<form method="post" action="/lesson04/ex01/add-user">
			<div class="form-group"> 
				<label for="name">이름</label>
				<input type="text" class="form-control col-4" name="name" id="name">
			</div>
			<div class="form-group"> 
				<label for="yyyymmdd">생년월일</label>
				<input type="text" class="form-control col-4" name="yyyymmdd" id="yyyymmdd" placeholder="예) 19990101">
			</div>
			<div class="form-group"> 
				<label for="email">이메일</label>
				<input type="text" class="form-control col-4" name="email" id="email">
			</div>
			<div>
				<label for="introduce">자기소개</label>
				<textarea class="form-control" name="introduce" id="introduce"></textarea>
			</div>
			
			<input type="submit" value="회원가입" class="btn btn-success mt-3">
			
		</form>
	</div>
</body>
</html>