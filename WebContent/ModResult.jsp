<%@ page language="java" contentType="text/html; charset=UTF-8" import="user.bean.RegistrantInfo" pageEncoding="Windows-31J" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<jsp:useBean id="userInfo" scope="session" class="user.bean.UserInfo" />
<jsp:useBean id="modInfo" scope="request" class="user.bean.RegistrantInfo" />
<html>
<head>
<link rel="stylesheet" href="Task.css" type="text/css" />
<title>登録者変更</title>	
</head>
<body>
	<%@ include file="Header.jsp" %>

	<div id="main">
		登録者変更<hr color=white width=30%>
		更新しました<br />
		<table class="regList">
		<tr>
			<th width="150">ID</th>
			<td width="200"><jsp:getProperty name="modInfo" property="rId" /></td>
		</tr>
		<tr>
			<th>名前</th>
			<td><jsp:getProperty name="modInfo" property="rName" /></td>
		</tr>
		<tr>
			<th>年齢</th>
			<td><jsp:getProperty name="modInfo" property="rAge" /></td>
		</tr>
		</table>
		<br />
		<div id="menu"><a href="MenuList.jsp" style="text-decoration: none">一覧へ</a></div>
 	</div>

	<%@ include file="Footer.jsp" %>
</body>
</html>