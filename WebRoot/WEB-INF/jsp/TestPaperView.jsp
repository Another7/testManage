<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-81">
<title>试卷展示</title>
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/bootstrap-select.js"></script>
<link href="css/bootstrap.min.css" rel="stylesheet">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-select@1.13.12/dist/css/bootstrap-select.min.css">

<!-- Latest compiled and minified JavaScript -->
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap-select@1.13.12/dist/js/bootstrap-select.min.js"></script>

<script
	src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.10.0/js/i18n/defaults-zh_CN.min.js"></script>
	
	<script type="text/javascript">
	
		function CreateTestPaper(){
			var tpId='${tpId}';
			window.location.href ="/testManage/exportTestPaper.action?tpId="+tpId;//跳转到展示页面
		
		}
	</script>
<style type="text/css">
.bg {
	background-color: #b0c4de;
	background-size: contain;
}

.top-buffer {
	margin-top: 10px;
	font-family:SimSun;
}
</style>
</head>

<body>

	<ul class="breadcrumb">
		<li>
			<h3>
				<a href="#">我的试卷</a>
			</h3>
		</li>

		<li class="active">试卷预览</li>


		<a class="btn btn-primary btn-" href="#" style="float:right">返回</a>


	</ul>


	<hr>
	<div class="container">
		<div class="row clearfix">

			<div id="TestPaper">

				<div>
					<!-- 试卷标题 -->
					<div class="col-md-12 column">
						<h2 align="center">中&nbsp;原&nbsp;工&nbsp;学&nbsp;院</h2>
						<h3 align="center">${testPaperView.tpTerm }&nbsp;</h3>
						<h3 align="center">
							<ins>${testPaperView.tpClass } </ins>
							专业
							<ins>${testPaperView.tpMajor }</ins>
							课程 ${testPaperView.tpIllustrate }
						</h3>
					</div>

					<!-- 试卷内容 -->
					<br>
					<hr>
					<br>
					
					<div class="col-md-2 column "></div>
					<div class="col-md-8 column bg-success">

						<!-- 加载单选试题 -->
						<c:if test="${!empty  testPaperView.scQuestions}">
							<p class="sc">
								<!-- 试题标号 -->
								<strong>一、单项选择	</strong>
								
								<c:forEach var="scQuestion"
									items="${ testPaperView.scQuestions}" varStatus="status">
									<div class="row top-buffer">
										<div class="col-md-12">
											<!-- 题干 -->${status.index+1 }.
											<c:out value="${scQuestion.sc_stem}"></c:out>
										</div>
										<c:forEach var="option" items="${scQuestion.sc_option }"
											varStatus="status">
											<div class="col-md-3">
												<c:out value="${option}"></c:out>
											</div>
										</c:forEach>
									</div>
								</c:forEach>							
							</p>
						</c:if>
						<!-- 加载多选试题 -->
						<c:if test="${! empty  testPaperView.mcQuestions}">
							<p class="mc">
								<!-- 试题标号 -->
								<strong>二、多项选择</strong>
								<c:forEach var="mcQuestion"
									items="${ testPaperView.mcQuestions}" varStatus="status">
									<div class="row top-buffer">
										<div class="col-md-12">
											<!-- 题干 -->${status.index+1 }.
											<c:out value="${mcQuestion.mc_stem}"></c:out>
										</div>
										<c:forEach var="option" items="${mcQuestion.mc_option }"
											varStatus="status">

											<div class="col-md-3">
												<c:out value="${option}"></c:out>
											</div>

										</c:forEach>
									</div>
								</c:forEach>
							</p>
						</c:if>
						<!-- 加载填空题 -->
						<c:if test="${! empty  testPaperView.fbQuestions}">
							<p class="fb">
								<!-- 试题标号 -->
								<strong>三、填空题</strong>
								<c:forEach var="fbQuestion"
									items="${ testPaperView.fbQuestions}" varStatus="status">
									<div class="row top-buffer">
										<div class="col-md-12">
											<!-- 题干 -->${status.index+1 }.
											<c:out value="${fbQuestion.fb_term}"></c:out>
										</div>


									</div>
								</c:forEach>
							</p>
						</c:if>
						<!-- 加载判断题 -->
						<c:if test="${! empty  testPaperView.tfQuestions}">
							<p class="tf">
								<!-- 试题标号 -->
								<strong>四、判断题</strong>
								<c:forEach var="tfQuestion"
									items="${ testPaperView.tfQuestions}" varStatus="status">
									<div class="row top-buffer">
										<div class="col-md-12">
											<!-- 题干 -->${status.index+1 }.
											<c:out value="${tfQuestion.tf_term}"></c:out>
										</div>


									</div>
								</c:forEach>
							</p>
						</c:if>
						<!-- 加载简答题 -->
						<c:if test="${! empty  testPaperView.qaQuestion}">
							<p class="qa">
								<!-- 试题标号 -->
								<strong>五、简答</strong>
								<c:forEach var="qaQuestion"
									items="${ testPaperView.qaQuestion}" varStatus="status">
									<div class="row top-buffer">
										<div class="col-md-12">${status.index+1 }.
											<c:out value="${qaQuestion.qa_term}"></c:out>
										</div>
										<p></p>
									</div>
								</c:forEach>
							</p>
						</c:if>




					</div>
				</div>

			</div>
			<div class="col-md-2 column"></div>

		</div>
	</div>
	<div class="row">
		<div class="col-md-12">
		<h1></h1>
			<div style="text-align:center">
			<button class="btn btn-primary" onclick="CreateTestPaper()" >导出试卷</button>	
			</div>
			<h1></h1>
		</div>
	</div>

</body>
</html>