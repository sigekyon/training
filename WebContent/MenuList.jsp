<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<link rel="stylesheet" href="Task.css" type="text/css" />
<title>サービス一覧</title>	
</head>
<body>

	<%@ include file="Header.jsp" %>

	<div id="main">
		サービス一覧<hr color=white width=30%>
		<p><a href="RegistList" style="text-decoration: none">登録者一覧</a></p>
		<p><a href="RegRegist.jsp" style="text-decoration: none">登録者登録</a></p>
		<p><a href="RegistInfo.jsp" style="text-decoration: none">登録者一覧(詳細込)</a></p>
	</div>

	<%@ include file="Footer.jsp" %>
</body>
</html>