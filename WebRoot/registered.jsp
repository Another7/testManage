<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() 
	                   + ":" + request.getServerPort() + path + "/";
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
<script src="js/jquery.step.js"></script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>
<script src="js/bootsnav.js" type="text/javascript"></script>

<script src="js/jquery.js" type="text/javascript"></script>
<!--[if IE]><script src="js/html5.js"></script><![endif]-->
<title>注册</title>
</head>

<body class="logobg_style">
  <div id="large-header" class="large-header login-page">
  	<canvas id="demo-canvas" width="1590" height="711"></canvas>
  	
  	<div class="Retrieve_style">
  	  <div class="Retrieve-content step-body" id="myStep">
  	  
  		<h1 class="title_name">用户注册</h1>
  		
  		<div class="step-header"> <ul><li><p>输入邮箱</p></li><li><p>确认密码</p></li><li><p>完成注册</p></li></ul></div>
 		  <div class="step-content">
  			<div class="step-list login_padding">
  				<form  role="form" id="form_login" class="">
				 <div class="form-group clearfix">
				 
					<div class="input-group col-lg-12 col-md-12 col-xs-12">
						<div class="input-group-addon"><i class="icon_phone"></i></div>
                        <input type="text" class="form-control text_phone" name="email" id="email" placeholder="请填写你的邮箱" autocomplete="off">
					</div>
                         <!-- <div class="col-lg-4 col-md-4 col-xs-4 fl"><input type="button" id="btn" class="btn_mfyzm" value="获取验证码" onclick="Sendpwd(this)"/></div> -->
				
				</div>
				<!-- <div class="form-group clearfix">
				 <div class="input-group">
					<div class="input-group-addon"><i class="icon_yanzhen"></i></div>
                    <input type="text"  class="form-control"  name="Verification" id="Verification"   placeholder="短信验证码" autocomplete="off">
					</div>
				</div> -->
             <div class="tishi"></div>
             </form> 
            <div class="form-group">
					<button  class="btn btn-danger btn-block btn-login" id="applyBtn" onclick="Sendpwd(this)" >下一步</button>
				</div>	
			
			</div>
			<div class="step-list">
				<form method="post" role="form" id="" class="login_padding">
				  <div class="form-group clearfix">
					<div class="input-group">
						<div class="input-group-addon">
							<i class="icon_password"></i>
						</div>
						<input type="password" class="form-control" name="password" id="password" placeholder="设置密码" autocomplete="off">
					</div>

				</div>
				<div class="form-group clearfix">
					<div class="input-group"> 
						<div class="input-group-addon">
							<i class="icon_password"></i>
						</div>
						<input type="password" class="form-control" name="confirmpwd" id="confirmpwd" placeholder="再次输入密码" autocomplete="off">
					</div>
				</div>
				 <div class="tishis"></div>
				<div class="form-group">
					<a href="javascript:void(0);" type="submit" class="btn btn-danger btn-block btn-login" id="submitBtn">下一步</a>
				</div>
				</form>
				</div>
					<div class="step-list">
					<div class="ok_style center">
                            <h2><img src="images/ok.png"></h2>
	                        <h5 class="color2 mtb20">你已成功注册<b id="sec">3</b>秒后跳转到登录页面</h5>
	                        <a href="JavaScript：ovid()" class="btn btn-danger">首页</a>
	                        <a href="JavaScript：ovid()" class="btn btn-primary">从新注册</a>
					</div>
				</div>
			</div>
  		</div> 			
  </div>
 </div> 	
<script src="js/TweenLite/TweenLite.min.js"></script>
<script src="js/TweenLite/EasePack.min.js"></script>
<script src="js/TweenLite/rAF.js"></script>
<script src="js/TweenLite/demo-1.js"></script>
</body>
</html>
<script type="text/javascript">
	
</script>
