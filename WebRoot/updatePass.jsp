<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() 
	                   + ":" + request.getServerPort() + path + "/";
%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>修改密码</title>
</head>
<body>
<!-- 选项卡3-资料修改 -->
							<h4 align="center">&nbsp;</h4>
							<div class="row form-group">
								<div class="col-md-3">
									<label class="old-label">旧密码:</label>
								</div>
								<div class="col-md-9">
									<input type="text" class="form-control old-pwd">
								</div>
								
							</div>
							<div class="row form-group">
								<div class="col-md-3">
									<label class="old-label">新密码:</label>
								</div>
								<div class="col-md-9">
									<input type="text" class="form-control old-pwd">
								</div>
								
							</div>
							<div class="row form-group">
								<div class="col-md-3">
									<label class="old-label">再次输入新密码:</label>
								</div>
								<div class="col-md-9">
									<input type="text" class="form-control old-pwd">
								</div>
								
							</div>
							<div class="row form-group">
								<div class="col-md-12" style="margin-left: 242px;">
									<button type="button" class="btn btn-success" >确认修改</button>&nbsp;
									<button type="button" class="btn btn-success" >重置</button>
								</div>
								
								
							</div>
						</div>
</body>
</html>