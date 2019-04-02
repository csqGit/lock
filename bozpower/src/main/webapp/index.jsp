<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    String path = request.getContextPath();
  String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
  response.sendRedirect(path+"/admin/admin_login.jsp");
    %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	h1 {
		width: 800px;
		height: 50px;
		line-heitht: 50px;
		padding:100px;
		margin: 0 auto;background: rgb(234, 234, 234);
		color: green;
	}
	h2{width:800px; line-height:50px; margin:10px auto; background: rgb(234, 234, 234);padding:50px 100px;}
</style>
</head>
<body>

<h1>欢迎访问西安博展电力技术有限责任公司</h1>
<h2>智能钥匙管理系统</h2>
<a style="margin-left: 25%;" href="<%=path %>/jsp/item.jsp">点击进入</a>

</body>
</html>