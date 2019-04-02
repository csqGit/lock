<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- <%@ taglib prefix="s" uri="/struts-tags"%> --%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
	<meta http-equiv="content-type" content="text/html;charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="<%=path %>/css/default.css" />
	<title>公司信息页面</title>
<style type="text/css">
* {
    background: none repeat scroll 0 0 transparent;
    border: 0 none;
    margin: 0;
    padding: 0;
    vertical-align: baseline;
	font-family:微软雅黑;
	overflow:hidden;
	list-style: none;
}
#navi{
	width:100%;
	position:relative;
	word-wrap:break-word;
	border-bottom:1px solid #065FB9;
	margin:0;
	padding:0;
	height:40px;
	line-height:40px;
	vertical-align:middle;
    background-image: -moz-linear-gradient(top,#EBEBEB, #BFBFBF);
    background-image: -webkit-gradient(linear, left top, left bottom, color-stop(0, #EBEBEB),color-stop(1, 
#BFBFBF));
}
#naviDiv{
	font-size:14px;
	color:#333;
	padding-left:10px;
}
#tips{
	margin-top:10px;
	width:100%;
	height:40px;
}
#buttonGroup{
	padding-left:10px;
	float:left;
	height:35px;
}
.button{
	float:left;
	margin-right:10px;
	padding-left:10px;
	padding-right:10px;
	font-size:14px;
	width:70px;
	height:30px;
	line-height:30px;
	vertical-align:middle;
	text-align:center;
	cursor:pointer;
    border-color: #77D1F6;
    border-width: 1px;
    border-style: solid;
    border-radius: 6px 6px;
    -moz-box-shadow: 2px 2px 4px #282828;
    -webkit-box-shadow: 2px 2px 4px #282828;
    background-image: -moz-linear-gradient(top,#EBEBEB, #BFBFBF);
    background-image: -webkit-gradient(linear, left top, left bottom, color-stop(0, #EBEBEB),color-stop(1, #BFBFBF));
}
#mainContainer{
	padding-left:10px;
	padding-right:10px;
	text-align:center;
	width:98%;
	font-size:12px;
}

.delete_color a:link{
	color:white;
}
.delete_color a:visited{
	color:white;
}

.delete_color a:hover{
	color:red;
}

#bottom{
	width:100%;
	height:30px;
}
#bottom ul{
	width:800px;
	margin:0 auto;
}
#bottom ul li{
	float:left;
	width:150px;
	height:30px;
	line-height:30px;
	text-align:center;
	cursor:pointer;
}
#bottom ul li:hover{
	color:red;
}
.default{margin: 0 auto;}
.tit{line-height: 30px; background: rgb(234, 234, 234)}
</style>
<script type="text/javascript" src="<%=path%>/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
	$(function(){
		var pagesStr = $("#pages").text();
		var currentPageStr = $("#currentPage").text();
		var pages = parseInt(pagesStr);
		var currentPage = parseInt(currentPageStr);
		$("#first").click(function(){
			if(currentPage == 1){
				return false;
			}
			window.location.href = "<%=path %>/pcCompany/selectCompanyList?page=1";
		});
		
		$("#prePage").click(function(){
			if(currentPage == 1){
				return false;
			}
			currentPage --;
			window.location.href="<%=path %>/pcCompany/selectCompanyList?page=" + currentPage;
		});
		$("#next").click(function(){
			if(currentPage == pages){
				return false;
			}
			currentPage ++;
			window.location.href = "<%=path %>/pcCompany/selectCompanyList?page=" + currentPage;
		});
		$("#end").click(function(){
			if(currentPage == pages){
				return false;
			}
			window.location.href = "<%=path %>/pcCompany/selectCompanyList?page=" + pages;
		});
	})
	
</script>
<body>
<div id="navi">
	<div id='naviDiv'>
		<span><img src="../images/arror.gif" width="7" height="11" border="0" alt=""></span>&nbsp;单位管理<span>&nbsp;</span>
		<span><img src="../images/arror.gif" width="7" height="11" border="0" alt=""></span>&nbsp;
		<a href="<%=path%>/teachers/Teachers_query.action">单位列表</a><span>&nbsp;</span>
	</div>
</div>
<div id="tips">
	<div id="buttonGroup">
		<div class="button" onmouseout="this.style.backgroundColor='';this.style.fontWeight='normal'" onmouseover="this.style.backgroundColor='#77D1F6';this.style.fontWeight='bold'">
			<a href="<%=path%>/company/company_add.jsp">添加单位</a>
		</div>
		<div class="button" onmouseout="this.style.backgroundColor='';this.style.fontWeight='normal'" onmouseover="this.style.backgroundColor='#77D1F6';this.style.fontWeight='bold'">
			<a href="<%=path %>/company/company_add.jsp">查找单位</a>
		</div>
	</div>
</div>
<div id="mainContainer">
<!-- 从session中获取学生集合 -->

<table class="default" width="60%">
	<col width="40%">
	<col width="40%">
	<col width="20%">
	<tr class="title" height="40px">
		<td>编号</td>
		<td>单位名称</td>
		<td>操作</td>
	</tr>
	
	<!-- 遍历开始 -->
	<c:forEach var="company" items="${companyList }" varStatus="i">
		<tr class="tit" height="30" >
			<td>${i.index + 1 }</td>
			<td>${company.companyName }</td>
			<td><a href="<%=path %>/pcCompany/selectCompanyById?param=update&id=${company.id }">修改</a>&nbsp;&nbsp;
			<a href="<%=path%>/pcCompany/deleteCompany?id=${company.id }" onclick="javascript:return confirm('真的要删除吗？');">删除</a></td>
		</tr>
	</c:forEach>
	<!-- 遍历结束 -->
</table>
	
	<div id="bottom">
		<ul>
			<li><font id="first">首页</font></li>
			<li><font id="prePage">上一页</font></li>
			<li><font id="currentPage">${pageData.page }</font>/<font id="pages">${pageData.pages }</font></li>
			<li><font id="next">下一页</font></li>
			<li><font id="end">尾页</font></li>
		</ul>
	</div>
</div>
</body>
</html>