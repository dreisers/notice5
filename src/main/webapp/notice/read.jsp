<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>notice5/read.jsp</title>
<style type="text/css">
* {
	font-family: gulim;
	font-size: 24px;
}
</style>
<link href="../css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<DIV class="title">공지사항</DIV>
	<table>
		<tr>
		<th>번호</th>
		<td>${dto.noticeno }</td>
		</tr>
		<tr>
		<th>내용</th>
		<td>${dto.title }</td>
		</tr>
		<tr>
		<th>작성자</th>
		<td>${dto.rname }</td>
		<th>등록일</th>
		<td>${dto.rdate }</td>
		</tr>	
	</table>

	<div class="bottom">
		<input type="button" value="목록" onclick="location.href='./list.do?noticeno=${dto.noticeno}'">
	</div>
	
</body>
</html>
