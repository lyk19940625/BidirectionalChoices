<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html>
<html lang="en">
<head>
<base href="<%=basePath%>">
<title>研究生导师双选系统</title>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="stylesheet" href="css/bootstrap.min.css" />
<link rel="stylesheet" href="css/bootstrap-responsive.min.css" />
<link rel="stylesheet" href="css/fullcalendar.css" />
<link rel="stylesheet" href="css/unicorn.main.css" />
<link rel="stylesheet" href="css/unicorn.grey.css" class="skin-color" />
<script type="text/javascript" src="js/jquery.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>
<body>
	

	<div id="header">
		<h1>
			<a href="./Teacher.jsp">teacher</a>
		</h1>
	</div>


	<div id="user-nav" class="navbar navbar-inverse">
		<ul class="nav btn-group">
			<li class="btn btn-inverse"><a title="" href="#"><i
					class="icon icon-user"></i> <span class="text">个人中心</span></a></li>
			<li class="btn btn-inverse dropdown" id="menu-messages"><a
				href="#" data-toggle="dropdown" data-target="#menu-messages"
				class="dropdown-toggle"><i class="icon icon-envelope"></i> <span
					class="text">消息</span> <span class="label label-important">5</span>
					<b class="caret"></b></a>
				<ul class="dropdown-menu">
					<li><a class="sAdd" title="" href="#">new message</a></li>
					<li><a class="sInbox" title="" href="#">inbox</a></li>
					<li><a class="sOutbox" title="" href="#">outbox</a></li>
					<li><a class="sTrash" title="" href="#">trash</a></li>
				</ul></li>
			<li class="btn btn-inverse"><a title="" href="#"><i
					class="icon icon-cog"></i> <span class="text">设置</span></a></li>
			<li class="btn btn-inverse"><a title="" href="login.html"><i
					class="icon icon-share-alt"></i> <span class="text">注销</span></a></li>
		</ul>
	</div>

	<div id="sidebar">
		<a href="#" class="visible-phone"><i class="icon icon-home"></i>
			首页</a>
		<ul>
			<li><a href="teacher/queryteacher"><i
					class="icon icon-home"></i> <span>首页</span></a></li>

			<li class="active"><a href="teacher/queryselected"><i class="icon icon-tint"></i> <span>查看结果</span></a></li>
			<li><a href="teacher/query"><i class="icon icon-pencil"></i>
					<span>选择学生</span></a></li>

		</ul>
	</div>

	<div id="style-switcher">
		<i class="icon-arrow-left icon-white"></i> <span>Style:</span> <a
			href="#grey" style="background-color: #555555;border-color: #aaaaaa;"></a>
		<a href="#blue" style="background-color: #2D2F57;"></a> <a href="#red"
			style="background-color: #673232;"></a>
	</div>

	<div id="content">
		<div id="content-header">
			<h1>欢迎</h1>
			<div class="btn-group">
				<a class="btn btn-large tip-bottom" title="Manage Files"><i
					class="icon-file"></i></a> <a class="btn btn-large tip-bottom"
					title="Manage Users"><i class="icon-user"></i></a> <a
					class="btn btn-large tip-bottom" title="Manage Comments"><i
					class="icon-comment"></i><span class="label label-important">5</span></a>
				<a class="btn btn-large tip-bottom" title="Manage Orders"><i
					class="icon-shopping-cart"></i></a>
			</div>
		</div>

		<table class="table table-bordered table-striped">

			<thead>
				<tr>
					<th>顺位</th>
					<th>学生姓名</th>
					<th>性别</th>
					<th>出生日期</th>
					<th>介绍</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="tsed" items="${tlisted}" >
				<tr>
				
						<td valign="top"><input style="width:80px;" type="text"
							style="border:0px;" name='rank' value="${tsed.rank}" /></td>
						<td valign="top"><input style="width:80px;" type="text"
							style="border:0px;" name=sname value="${tsed.sname}" /></td>
						<td valign="top"><input style="width:80px;" type="text"
							style="border:0px;" name="sex" value="${tsed.sex}" /></td>
						<td valign="top"><input style="width:80px;" type="text"
							style="border:0px;" name="birth" value="${tsed.birth}" /></td>
						<td valign="top"><input style="width:80px;" type="text"
							style="border:0px;" name="tips" value="${tsed.tips}" /></td>
					
				</tr>
				</c:forEach>
			</tbody>

		</table>
	 


	</div>





	<script src="js/excanvas.min.js"></script>
	<script src="js/jquery.min.js"></script>
	<script src="js/jquery.ui.custom.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/jquery.flot.min.js"></script>
	<script src="js/jquery.flot.resize.min.js"></script>
	<script src="js/jquery.peity.min.js"></script>
	<script src="js/fullcalendar.min.js"></script>
	<script src="js/unicorn.js"></script>
	<script src="js/unicorn.首页.js"></script>
</body>
</html>
