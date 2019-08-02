<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
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
		<link rel="stylesheet" href="css/myinput.css" />
		<link rel="stylesheet" href="css/myselect.css" />
		<link rel="stylesheet" href="css/unicorn.grey.css" class="skin-color" />
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /></head>
		
	<body>
		<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><div id="header">
			<h1><a href="./Manager.jsp">student</a></h1>		
		</div>
		
		
		<div id="user-nav" class="navbar navbar-inverse">
            <ul class="nav btn-group">
                <li class="btn btn-inverse"><a title="" href="#"><i class="icon icon-user"></i> <span class="text">个人中心</span></a></li>
                <li class="btn btn-inverse dropdown" id="menu-messages"><a href="#" data-toggle="dropdown" data-target="#menu-messages" class="dropdown-toggle"><i class="icon icon-envelope"></i> <span class="text">消息</span> <span class="label label-important">5</span> <b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li><a class="sAdd" title="" href="#">new message</a></li>
                        <li><a class="sInbox" title="" href="#">inbox</a></li>
                        <li><a class="sOutbox" title="" href="#">outbox</a></li>
                        <li><a class="sTrash" title="" href="#">trash</a></li>
                    </ul>
                </li>
                <li class="btn btn-inverse"><a title="" href="#"><i class="icon icon-cog"></i> <span class="text">设置</span></a></li>
                <li class="btn btn-inverse"><a title="" href="login.html"><i class="icon icon-share-alt"></i> <span class="text">注销</span></a></li>
            </ul>
        </div>
            
		<div id="sidebar">
			<a href="#" class="visible-phone"><i class="icon icon-home"></i> 首页</a>
			<ul>
				<li class="active"><a href="redirect:/cmanager/queryst""><i class="icon icon-home"></i> <span>分配导师</span></a></li>
				<li class="submenu">
					<a href="#"><i class="icon icon-th-list"></i> <span>查看</span> <span class="label">2</span></a>
					<ul>
						<li><a href="manager/querystudent">学生选导师信息</a></li>
						<li><a href="cmanager/queryteacher">导师选学生信息</a></li>
						
					</ul>
				</li>
				<li><a href="cmanager/final"><i class="icon icon-tint"></i> <span>导出导师选择信息</span></a></li>
				
		</div>
		
		<div id="style-switcher">
			<i class="icon-arrow-left icon-white"></i>
			<span>Style:</span>
			<a href="#grey" style="background-color: #555555;border-color: #aaaaaa;"></a>
			<a href="#blue" style="background-color: #2D2F57;"></a>
			<a href="#red" style="background-color: #673232;"></a>
		</div>
		
		<div id="content">
			<div id="content-header">
				<h1>欢迎</h1>
				<div class="btn-group">
					<a class="btn btn-large tip-bottom" title="Manage Files"><i class="icon-file"></i></a>
					<a class="btn btn-large tip-bottom" title="Manage Users"><i class="icon-user"></i></a>
					<a class="btn btn-large tip-bottom" title="Manage Comments"><i class="icon-comment"></i><span class="label label-important">5</span></a>
					<a class="btn btn-large tip-bottom" title="Manage Orders"><i class="icon-shopping-cart"></i></a>
				</div>
			</div>
			
		<div id="breadcrumb">
				<a href="index.html" title="Go to Home" class="tip-bottom"><i class="icon-home"></i> </a>
				<a href="#" class="tip-bottom">首页</a>
			</div>
			<div class="container-fluid">
				<div class="row-fluid">
					<div class="span12">
					<div class="widget-box">
							<div class="widget-title">
								<span class="icon">
									<i class="icon-align-justify"></i>									
								</span>
								<h5>信息</h5>					
		<table class="table table-bordered table-striped">
									
									<thead>
										<tr>
										<th>学号</th>
											<th>学生姓名</th>
												<th>志愿一</th>
													<th>志愿二</th>
													    <th>志愿三</th>
										</tr>
									</thead>
									<tbody>
									 <c:forEach var="cstudent" items="${cstudentlist}">   
					            <tr>
					         
					            <td valign="top"><input type="text" style="border:0px;" name="sid" value="${cstudent.sid}"/></td> 
					              <td valign="top"><input type="text" style="border:0px;" name="sname" value="${cstudent.sname}" /></td>
					                 <c:forEach var="wanted" items="${cstudent.wanted}">    
					                <td valign="top"><input type="text" style="border:0px;"  value="${wanted}" /></td>
					                      </c:forEach>     
					           
					            </tr>
					             </c:forEach>
									</tbody>
									
								</table>	
				
								</div>
								
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
