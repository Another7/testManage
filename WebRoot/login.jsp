<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String socketPath=request.getServerName()+":"+request.getServerPort()+path+"/";
//getServerName先得到服务器的ip地址，getServerPort()得到相应的端口号；
//getContextPath得到的是上下文路径，其实就是发布了项目的文件名，
//如："ws:139.129.47.176:8089/web//ws"
%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="css/bootstrap.min.css" type="text/css" rel="stylesheet">
<link href="css/font-awesome.min.css" type="text/javascript" rel="stylesheet">
<link href="css/bootsnav.css" type="text/css" rel="stylesheet">
<link href="css/normalize.css" type="text/css" rel="stylesheet">
<link href="css/css.css" rel="stylesheet" type="text/css">

<script src="js/jquery-1.11.0.min.js" type="text/javascript"></script>
<script src="js/jquery.min.js" type="text/javascript"></script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>
<script src="js/bootsnav.js" type="text/javascript"></script>
<script src="js/jquery.js" type="text/javascript"></script>
<!--[if IE]><script src="js/html5.js"></script><![endif]-->
<title>登录</title>
</head>
<body class="logobg_style">
  	<div id="large-header" class="large-header login-page">
  		<canvas id="demo-canvas" width="1590" height="711"></canvas>
  		<div class="login-form">
  			<div class="login-content">
  			
  				<h1 class="title_name">账户登录</h1>
  				<form method="post" role="form" id="form_login" class="login_padding">
				<div class="form-group clearfix">
					<div class="input-group">
						<div class="input-group-addon">
							<i class="icon_user"></i>
						 </div>
						<input type="text" class="form-control" name="username" id="username" placeholder="用户名/邮箱" autocomplete="off">
					</div>
				</div>   
  
				<div class="form-group clearfix">

					<div class="input-group">
						<div class="input-group-addon">
							<i class="icon_password"></i>
						</div>

						<input type="password" class="form-control" name="password" id="password" placeholder="密码" autocomplete="off">
					</div>

				</div>
					<div class=" textright"><a href="#" class="forget">忘记密码？</a></div>
                  <div class="tishi"></div>
				<div class="form-group">
					<a href="javascript:;" type="submit" class="btn btn-danger btn-block btn-login" onClick="cliLogin()">
						<i class="fa fa-sign-in"></i>
						登录
					</a>
				</div>
				<div class=" textright"><a href="registered.html" class="forget">立即注册</a></div>
				<!-- Implemented in v1.1.4 -->				<div class="form-group">
					
				</div>
			</form>
  			</div>
  			
  		</div>
  	</div>
  	
<script src="js/TweenLite/TweenLite.min.js"></script>
<script src="js/TweenLite/EasePack.min.js"></script>
<script src="js/TweenLite/rAF.js"></script>
<script src="js/TweenLite/demo-1.js"></script>
</body>
</html>
