<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- <%@ taglib prefix="s" uri="/struts-tags"%> --%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<meta http-equiv="content-type" content="text/html;charset=UTF-8">
<link rel="stylesheet" type="text/css" href="<%=path%>/css/default.css" />
<style type="text/css">
* {
	background: none repeat scroll 0 0 transparent;
	border: 1 none;
	margin: 0;
	padding: 0;
	vertical-align: baseline;
	font-family: 微软雅黑;
	overflow: hidden;
}

#navi {
	width: 100%;
	position: relative;
	word-wrap: break-word;
	border-bottom: 1px solid #065FB9;
	margin: 0;
	padding: 0;
	height: 40px;
	line-height: 40px;
	vertical-align: middle;
	background-image: -moz-linear-gradient(top, #EBEBEB, #BFBFBF);
	background-image: -webkit-gradient(linear, left top, left bottom, color-stop(0, #EBEBEB),
		color-stop(1, #BFBFBF));
}

#naviDiv {
	font-size: 14px;
	color: #333;
	padding-left: 10px;
}

#tips {
	margin-top: 10px;
	width: 100%;
	height: 40px;
}

#buttonGroup {
	padding-left: 10px;
	float: left;
	height: 35px;
}

.button {
	margin-top: 20px;
	padding-left: 10px;
	padding-right: 10px;
	font-size: 14px;
	width: 70px;
	height: 30px;
	line-height: 30px;
	vertical-align: middle;
	text-align: center;
	cursor: pointer;
	border-color: #77D1F6;
	border-width: 1px;
	border-style: solid;
	border-radius: 6px 6px;
	-moz-box-shadow: 2px 2px 4px #282828;
	-webkit-box-shadow: 2px 2px 4px #282828;
	background-image: -moz-linear-gradient(top, #EBEBEB, #BFBFBF);
	background-image: -webkit-gradient(linear, left top, left bottom, color-stop(0, #EBEBEB),
		color-stop(1, #BFBFBF));
}

#mainContainer {
	padding-left: 10px;
	padding-right: 10px;
	text-align: left;
	width: 98%;
	font-size: 16px;
	overflow-y: scroll;
}

table {
	border: 1px solid gray;
	margin: 0 auto;
}

table tr {
	height: 20px;
}

table tr td {
	padding-left: 10px;
}

table tr td input[type="text"] {
	width: 200px;
	height: 20px;
	margin-top: 5px;
	padding-left: 10px;
}

table tr td input[type="radio"] {
	font-size: 15px;
}

table tr td select {
	width: 215px;
	height: 20px;
	text-align: center;
	margin-top: 5px;
	padding-left: 10px;
}
</style>
<body>
	<script type="text/javascript" src="../js/Calendar3.js"></script>

	<div id="navi">
		<div id='naviDiv'>
			<span><img src="../images/arror.gif" width="7" height="11"
				border="0" alt=""></span>&nbsp;用户管理<span>&nbsp;</span> <span><img
				src="../images/arror.gif" width="7" height="11" border="0" alt=""></span>&nbsp;
			<a href="<%=path%>/pcUser/selectUserList?page=1">用户列表</a><span>&nbsp;</span>
		</div>
	</div>
	<div id="tips">
		<strong
			style="margin: 0 auto; display: block; text-align: center; padding: 10px 0;">添加用户信息</strong>
	</div>
	<div id="mainContainer">

		<form name="addForm" action="<%=path%>/pcUser/insertUser"
			method="post">
			<input type="hidden" name="id" value="">
			<table width="400">

				<tr>
					<td width="30%">用户名</td>
					<td><input type="text" name="username" placeholder="请输入用户名" value="" /></td>
				</tr>
				<tr>
					<td width="30%">真实姓名</td>
					<td><input type="text" name="realname" placeholder="请输入真实姓名" value="" /></td>
				</tr>
				<tr>
					<td width="30%">密码</td>
					<td><input type="text" name="password" placeholder="请输入密码6~11位" value="" /></td>
				</tr>
				<tr>
					<td width="30%">性别</td>
					<td>男：<input type="radio" name="gender" value="男"
						checked="checked" /> 女：<input type="radio" name="gender" value="女" />
					</td>
				</tr>
				<tr>
					<td width="30%">年龄</td>
					<td><input type="text" name="age" placeholder="请输入年龄" value="" /></td>
				</tr>

				<tr>
					<td width="30%">电话</td>
					<td><input type="text" name="phone" placeholder="请输入电话号码11位" maxlength="11" value="" /></td>
				</tr>

				<tr>
					<td width="30%">职位</td>
					<td><select name="post">
							<option value="">---请选择---</option>
							<option value="领导"></option>
							<option value="干活的"></option>
					</select></td>
				</tr>


				<tr>
					<td width="30%">变电站</td>
					<td><select name="transformsub">
							<option value="">---请选择---</option>
							<option value="变电站1"></option>
							<option value="变电站2"></option>
					</select></td>
				</tr>
				<tr>
					<td width="30%">管理员</td>
					<td><input type="text" name="administrators" placeholder="请输入管理员" value="" /></td>
				</tr>
				<tr>
					<td width="30%">使用锁名称</td>
					<td><input type="text" name="lockname" placeholder="请输入使用锁名称" value="" /></td>
				</tr>

				<tr>
					<td colspan="2" align="center"><input class="button"
						type="submit" value="提交"></td>
				</tr>
			</table>
		</form>


	</div>
</body>
</html>