<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
	<head>
	 <base href="<%=basePath%>">
		<title>Unicorn Admin</title>
		<meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<link rel="stylesheet" href="css/bootstrap.min.css" />
		<link rel="stylesheet" href="css/bootstrap-responsive.min.css" />
        <link rel="stylesheet" href="css/colorpicker.css" />
        <link rel="stylesheet" href="css/datepicker.css" />
		<link rel="stylesheet" href="css/uniform.css" />
		<link rel="stylesheet" href="css/select2.css" />		
		<link rel="stylesheet" href="css/unicorn.main.css" />
		<link rel="stylesheet" href="css/unicorn.grey.css" class="skin-color" />	
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	 <script language="javascript">
function checkform(){
	alert("修改成功！");
	}
</script>
</head>
	<body>
		
		
		<div id="header">
			<h1><a href="./dashboard.html">Unicorn Admin</a></h1>		
		</div>
		
		<div id="search">
			<input type="text" placeholder="Search here..." /><button type="submit" class="tip-right" title="Search"><i class="icon-search icon-white"></i></button>
		</div>
		<div id="user-nav" class="navbar navbar-inverse">
            <ul class="nav btn-group">
                <li class="btn btn-inverse"><a title="" href="#"><i class="icon icon-user"></i> <span class="text">个人中心</span></a></li>
                <li class="btn btn-inverse dropdown" id="menu-messages"><a href="#" data-toggle="dropdown" data-target="#menu-messages" class="dropdown-toggle"><i class="icon icon-envelope"></i> <span class="text">信息</span> <span class="label label-important">5</span> <b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li><a class="sAdd" title="" href="#">new message</a></li>
                        <li><a class="sInbox" title="" href="#">inbox</a></li>
                        <li><a class="sOutbox" title="" href="#">outbox</a></li>
                        <li><a class="sTrash" title="" href="#">trash</a></li>
                    </ul>
             
                <li class="btn btn-inverse"><a title="" href="#"><i class="icon icon-cog"></i> <span class="text">设置</span></a></li>
                <li class="btn btn-inverse"><a title="" href="login.html"><i class="icon icon-share-alt"></i> <span class="text">注销</span></a></li>
            </ul>
        </div>
            
		<div id="sidebar">
			<a href="#" class="visible-phone"><i class="icon icon-home"></i> 首页</a>
			<ul>
				<li ><a href="Student.jsp"><i class="icon icon-home"></i> <span>首页</span></a></li>
				<li class="submenu">
					<a href="#"><i class="icon icon-th-list"></i> <span>填写志愿</span> <span class="label">3</span></a>
					<ul>
						<li><a href="student/teacherinfo">导师信息</a></li>
						<li><a href="student/select">选择导师</a></li>
					</ul>
				</li>
				<li class="active"><a href="student/querys"><i class="icon icon-pencil"></i> <span>修改信息</span></a></li>
				
		</div>
		
		
		<div id="style-switcher">
			<i class="icon-arrow-left icon-white"></i>
			<span>Style:</span>
			<a href="#grey" style="background-color: #555555;border-color: #aaaaaa;"></a>
			<a href="#blue" style="background-color: #2D2F57;"></a>
			<a href="#red" style="background-color: #673232;"></a>
		</div>
		
		<div id="content">
		 <form action="student/edit" method="post" class="form-horizontal" />
			
			<div id="content-header">
				<h1>修改信息</h1>
				<div class="btn-group">
					<a class="btn btn-large tip-bottom" title="Manage Files"><i class="icon-file"></i></a>
					<a class="btn btn-large tip-bottom" title="Manage Users"><i class="icon-user"></i></a>
					<a class="btn btn-large tip-bottom" title="Manage Comments"><i class="icon-comment"></i><span class="label label-important">5</span></a>
					<a class="btn btn-large tip-bottom" title="Manage Orders"><i class="icon-shopping-cart"></i></a>
				</div>
			</div>
			<div id="breadcrumb">
				<a href="index.html" title="Go to Home" class="tip-bottom"><i class="icon-home"></i> </a>
				<a href="#" class="tip-bottom">信息</a>
			</div>
			<div class="container-fluid">
				<div class="row-fluid">
					<div class="span12">
					<div class="widget-box">
							<div class="widget-title">
								<span class="icon">
									<i class="icon-align-justify"></i>									
								</span>
								<h5>我的信息</h5>
									
							</div>
				<div class="control-group">
										
										<div class="controls">
											<input type="text" style="display:none"/>
										</div>
									</div>
							
									
							
			<table class="table table-bordered table-striped">
									
									<thead>
										<tr>
											<th>学生</th>
												<th>账号</th>
													<th>密码</th>
										</tr>
									</thead>
									<tbody>
					            <tr>
					               <c:forEach var="studentlist" items="${studentlist}">   
					            <td valign="top"><input type="text" style="border:0px;" name="sname" value="${studentlist.sname}" readonly/></td> 
					            <td valign="top"><input type="text" style="border:0px;" name="sid" value="${studentlist.sid}" readonly/></td> 
					            <td valign="top"><input type="text" style="border:0px;" name="spwd" value="${studentlist.spwd}" /></td> 
					            </c:forEach>
					            </tr>
									</tbody>
									
								</table>	
					<table class="table table-bordered table-striped">
									
									<thead>
										<tr>
											<th>性别</th>
												<th>出生年月</th>
													<th>联系方式</th>
										</tr>
									</thead>
									<tbody>
					            <tr>
					                    <c:forEach var="studentlist" items="${studentlist}">   
					            <td valign="top"><input type="text" style="border:0px;" name="sex" value="${studentlist.sex}" readonly/></td> 
					            <td valign="top"><input type="text" style="border:0px;" name="birth" value="${studentlist.birth}" /></td> 
					            <td valign="top"><input type="text" style="border:0px;" name="tel" value="${studentlist.tel}" /></td>
					            </c:forEach> 
					            </tr>
									</tbody>
									
								</table>	
								<table class="table table-bordered table-striped">
									
									<thead>
										<tr>
											<th>准考证号</th>
												<th>专业</th>
													<th>介绍</th>
										</tr>
									</thead>
									<tbody>
					            <tr>
					                  <c:forEach var="studentlist" items="${studentlist}">   
					            <td valign="top"><input type="text" style="border:0px;" name="eid" value="${studentlist.eid}" readonly/></td> 
					            <td valign="top"><input type="text" style="border:0px;" name="mno" value="${studentlist.mno}" readonly/></td> 
					            <td valign="top"><input type="text" style="border:0px;" name="tips" value="${studentlist.tips}" readonly/></td> 
					            </c:forEach>
					            </tr>
									</tbody>
									
								</table>	
								
			<div class="form-actions">
                    <span class="pull-center"><input type="submit" class="btn btn-inverse" value="确定修改" onclick="checkform()"/></span>
                </div>
						</div>
						</form>
						</div>
					</div>
			
            
            <script src="js/jquery.min.js"></script>
            <script src="js/jquery.ui.custom.js"></script>
            <script src="js/bootstrap.min.js"></script>
            <script src="js/bootstrap-colorpicker.js"></script>
            <script src="js/bootstrap-datepicker.js"></script>
            <script src="js/jquery.uniform.js"></script>
            <script src="js/select2.min.js"></script>
            <script src="js/unicorn.js"></script>
            <script src="js/unicorn.form_common.js"></script>
	</body>
</html>
