<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>notice5/list.jsp</title>
<style type="text/css">
* {
	font-family: gulim;
	font-size: 24px;
}
</style>
<link href="../css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<DIV class="title">공지사항 목록</DIV>
	<TABLE>
		<TR>
			<TH>번호</TH>
			<TH>내용</TH>
			<th>작성자</th>
			<TH>등록일</TH>
		</TR>
		<c:forEach var="dto" items="${list }">
			<tr>
				<td>${dto.noticeno }</td>
				<td><a href="./read.do?noticeno=${dto.noticeno}">${dto.title }</a></td>
				<td>${dto.rname }</td>
				<td>${dto.rdate }</td>
				<td><input type="button" value="수정" onclick="location.href='./update.do?noticeno=${dto.noticeno }'"> <input type="button" value="삭제"
					onclick="location.href='./delete.do?noticeno=${dto.noticeno }'"></td>
			</tr>
		</c:forEach>
	</TABLE>
	<c:if test="${!(empty requestScope.list) }">
		<!-- 검색 -->
		<br>
		<table>
			<tr>
				<td style="text-align: center; height:50px">
					<form method="get" action="search.do">
						<select name="col">
							<option value="title">제목
							<option value="rname">작성자
							<option value="title_ranme">제목+작성자
						</select>
						 <input type="text" name="word">
						 <input type="submit" value="검색">
					</form>
				</td>
			</tr>
		</table>
	</c:if>
	<div class="bottom">
		<input type="button" value="등록" onclick="location.href='./create.do?noticeno=${noticeno}'">
	</div>
</body>
</html>
