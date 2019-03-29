<%@ page contentType="text/html; charset=UTF-8" %> 
<!DOCTYPE html> 
<html> 
<head> 
  <meta charset="UTF-8"> 
  <title>notice5/createForm.jsp</title> 
  <style type="text/css"> 
  *{ 
    font-family: gulim; 
    font-size: 24px; 
  } 
  </style> 
  <link href="../css/style.css" rel="stylesheet" type="text/css">
</head> 
<body>
  <div class="title">공지사항 등록</div>
  <form name='frm' method='POST' action='./create.do'>
    <TABLE class='table'>
    <TR>
      <TH>공지사항 내용</TH>
      <TD><textarea rows="3" cols="30" name="title" maxlength="300"></textarea></TD>
    </TR>
    <TR>
      <TH>작성자</TH>
      <TD><input type='text' name='rname' size='20'></TD>
    </TR>
    </TABLE>

    <div class='bottom'>
      <input type='submit' value='등록'>
      <input type='button' value='목록' onclick="location.href='./list.do'">
    </div>
  </form>
</body> 
</html> 
