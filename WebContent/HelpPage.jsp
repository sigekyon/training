<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<jsp:useBean id="userInfo" scope="session" class="user.bean.UserInfo" />
<html>
<head>
<link rel="stylesheet" href="Task.css" type="text/css" />
<title>サービス一覧</title>	
</head>
<body>

	<%@ include file="Header.jsp" %>

	<div id="main">
		只今、お助けすることができません。<br />
		<div id="back">
		<a href="javascript:history.back();" style="text-decoration: none">戻る</a>
		</div>
	</div>

	<%@ include file="Footer.jsp" %>
</body>
</html>