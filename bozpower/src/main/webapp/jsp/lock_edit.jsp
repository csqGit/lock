<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="s" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- <%@ taglib prefix="s" uri="/struts-tags"%> --%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
	<meta http-equiv="content-type" content="text/html;charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="<%=path %>/css/default.css" />
<style type="text/css">
* {
    background: none repeat scroll 0 0 transparent;
    border: 1 none;
    margin: 0;
    padding: 0;
    vertical-align: baseline;
	font-family:微软雅黑;
	overflow:hidden;
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
	margin-top:20px;
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
	text-align:left;
	width:98%;
	font-size:16px;
}
table {border:1px solid gray; margin: 0 auto; }
table tr{height: 45px;}
table tr td{padding-left: 10px;}
table tr td input{width: 200px; height: 30px; margin-top: 5px;padding-left: 10px;}
table tr td select{width: 215px; height: 30px; text-align: center; margin-top: 5px;padding-left: 10px;}
</style>
<body>
<script type="text/javascript" src="../js/Calendar3.js"></script>

<div id="navi">
	<div id='naviDiv'>
		<span><img src="../images/arror.gif" width="7" height="11" border="0" alt=""></span>&nbsp;锁管理<span>&nbsp;</span>
		<span><img src="../images/arror.gif" width="7" height="11" border="0" alt=""></span>&nbsp;<a href="<%=path%>/pcLock/selectLockList?page=1">锁列表</a><span>&nbsp;</span>
	</div>
</div>
<div id="tips">
</div>
<div id="mainContainer">

<strong style="margin: 0 auto;">修改锁信息</strong>
<br>
<br>
<form name="addForm" action="<%=path%>/pcLock/updateLock" method="post">
<input type="hidden"  name="id" value="${lock.id }">
<table width="400" >

  <tr>
    <td width="30%">did：</td>
    <td><input type="text" name="did" value="${lock.did }" /></td>
  </tr>
  <tr>
    <td width="30%">mac：</td>
    <td><input type="text" name="mac" value="${lock.mac }" /></td>
  </tr>
    <tr>
    <td width="30%">passcode：</td>
    <td><input type="text" name="passcode" value="${lock.passcode }" /></td>
  </tr>
  <tr>
    <td>所属公司：</td>
    <td>
    	<select name="companyName">
    		<option value="">---请选择---</option>
    		<s:forEach var="company" items="${companyList }" >
    			<option  value="${company.companyName }" ${company.companyName == lock.companyName ? "selected" : "" }>${company.companyName }</option>
    		</s:forEach>
    	</select>
    </td>
  </tr>
  <tr>
    <td>所属变电站：</td>
    <td>
    	<select name="transformerSubName">
    		<option value="">---请选择---</option>
    		<s:forEach var="trans" items="${transformerSubList }" >
    			<option value="${trans.transformerSubName }" ${trans.transformerSubName == lock.transformerSubName ? "selected" : "" }>${trans.transformerSubName }</option>
    		</s:forEach>
    	</select>
    </td>
  </tr>
  <tr>
    <td colspan="2" align="center"><input class="button" type="submit" value="提交"></td>
  </tr>
</table>
</form>


</div>
</body>
</html>