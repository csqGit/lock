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
	<title>管理员信息页面</title>
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
.bg{background: rgb(234, 234, 234); line-heitht: 40px; }
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
			window.location.href = "<%=path %>/pcUser/selectUserList?page=1";
		});
		
		$("#prePage").click(function(){
			if(currentPage == 1){
				return false;
			}
			currentPage --;
			window.location.href="<%=path %>/pcUser/selectUserList?page=" + currentPage;
		});
		$("#next").click(function(){
			if(currentPage == pages){
				return false;
			}
			currentPage ++;
			window.location.href = "<%=path %>/pcUser/selectUserList?page=" + currentPage;
		});
		$("#end").click(function(){
			if(currentPage == pages){
				return false;
			}
			window.location.href = "<%=path %>/pcUser/selectUserList?page=" + pages;
		});
	})
	
</script>
<body>
<div id="navi">
	<div id='naviDiv'>
		<span><img src="../images/arror.gif" width="7" height="11" border="0" alt=""></span>
		&nbsp;管理员管理<span>&nbsp;</span>
		<span><img src="../images/arror.gif" width="7" height="11" border="0" alt=""></span>&nbsp;
		<a href="<%=path%>/pcAdmin/selectAdminList?page=1">管理员列表</a><span>&nbsp;</span>
	</div>
</div>
<div id="tips">
	<div id="buttonGroup">
		<div class="button" onmouseout="this.style.backgroundColor='';this.style.fontWeight='normal'" onmouseover="this.style.backgroundColor='#77D1F6';this.style.fontWeight='bold'">
			<a href="<%=path%>/pcAdmin/requestType?param=add">添加用户</a>
		</div>
		
		<%-- <form action="<%=path%>/pcLock/selectLockByName">
	<div class="button" style="width: 130px; height: 30px; margin-left: 20px; background: none;">
			<input style="width: 120px;height: 30px; padding-left: 10px; background: none; border: none; 
			outline:none;" name="lockName" type="text" placeholder="请输入用户名称" />
		</div>
		<div class="button" onmouseout="this.style.backgroundColor='';this.style.fontWeight='normal'" onmouseover="this.style.backgroundColor='#77D1F6';this.style.fontWeight='bold'">
			<input type="submit" value="查询" />
		</div>
		</form> --%>
	</div>
</div>
<div id="mainContainer">
<!-- 从session中获取学生集合 -->

<table class="default" width="100%">
	<col width="5%">
	<col width="10%">
	<col width="15%">
	<%-- <col width="10%"> --%>
	<col width="15%">
	<col width="10%">
	<col width="10%">
	<col width="10%">
	<col width="10%">
	<col width="10%">
	<tr class="title" height="40px">
		<td>编号</td>
		<td>用户名</td>
		<td>真实姓名</td>
		<!-- <td>运检班组</td> -->
		<td>密码</td>
		<td>电话号码</td>
		<td>所属公司</td>
		<td>管理级别</td>
		<td>工号</td>
		<td>操作</td>
	</tr>
	
	<!-- 遍历开始 -->
	
	<c:forEach var="obj" items="${adminList }" varStatus="i">
		<tr class="bg" height="30px;" style="line-height:30px;">
			<td>${i.index + 1 }</td>
			<td>${obj.username }</td>
			<td>${obj.realname }</td>
			<td><%-- ${obj.password } --%>******</td>
			<td>${obj.telephone }</td>
			<td>${obj.companyname }</td>
			<td>
    			<c:if test="${obj.type == 1 }">超级用户</c:if>
    			<c:if test="${obj.type == 2 }">一般用户</c:if>
    			<c:if test="${obj.type == 3 }">普通用户</c:if>
    		</td>
			<td>${obj.jobnumber }</td>
			<td>
				<a href="<%=path %>/pcAdmin/requestType?param=update&id=${obj.id}">修改</a>
				&nbsp;&nbsp;
				<a href="<%=path%>/pcAdmin/deleteAdmin?id=${obj.id}" onclick="javascript:return confirm('真的要删除吗？');">删除</a>
			</td>
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