<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="bean.Memo"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MemoApp</title>
</head>
<body>

<h1>memo app</h1>

Welcome !

<form method="post">

	<p>タイトル<br/>
	<input type="text" name="title"></p>

	<p>内容<br/>
	 <textarea rows="5" cols="80" name="text"></textarea></p>

	<p><input type="submit" value="投稿"></p>

</form>

<%
ArrayList<Memo>memoList =  (ArrayList)request.getAttribute("memoList");
for(Memo m:memoList){
	 out.println("<hr/>");
	out.println("投稿者ID : " + m.getId() + "<br/>");
	out.println("タイトル : " + m.getTitle() + "<br/>");
	out.println("内　　容 : " + m.getText() + "<br/>");
	out.println("投稿時間 : " + m.getDatetime() + "<br/>");
}

%>

</body>
</html>