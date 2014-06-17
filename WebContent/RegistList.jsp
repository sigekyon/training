<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="user.bean.RegistrantInfo" import="java.util.ArrayList"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<jsp:useBean id="userInfo" scope="session" class="user.bean.UserInfo" />
<html>
<head>
<link rel="stylesheet" href="Task.css" type="text/css" />
<script type="text/javascript" src="js/RegSort.js">
</script>
<script type="text/javascript" src="js/RegFilter2.js">
</script>
<title>登録者一覧</title>
</head>
<body>

	<%@ include file="Header.jsp"%>

	<div id="main">
		登録者一覧
		<hr color=white width=30%>
		<table class="regList" id="regList">
		<tbody>
			<tr><td><input type='text' name='filterName' width="50" id="fKey"></td>
				<td><input type='button' value='IDをフィルタ' onclick="tableFilter(this);"></td>
			</tr>
			<tr>
				<th width="150" onclick="tableSort(this,0,'','▲','▼');"
					style="text-decoration: none">ID</th>
				<th width="200" onclick="tableSort(this,1,'','▲','▼');"
					style="text-decoration: none">名前</th>
			</tr>
			<%
				RegistrantInfo[] rInfo = (RegistrantInfo[]) session
						.getAttribute("regList");

				for (int i = 0; i < rInfo.length; i++) {
			%>
			<tr>
				<td><a href="RegistDetail.jsp?onNum=<%=i%>"
					style="text-decoration: none" id=<%="regList"+i %>><%=rInfo[i].getrId()%></a></td>
				<td><%=rInfo[i].getrName()%></td>
			</tr>
				<%
					}
				%>
		</tbody>
		</table>
		<br />
		<div id="back">
			<a href="javascript:history.back();" style="text-decoration: none">戻る</a>
		</div>
	</div>

	<%@ include file="Footer.jsp"%>
	
</body>
</html>