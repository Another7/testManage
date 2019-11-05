<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() 
	                   + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>知识点管理页面</title>
    
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	
	 <script src="js/jquery.min.js"></script>
 	<script src="js/bootstrap.min.js"></script>
 <link href="css/bootstrap.min.css" rel="stylesheet">
 <script type="text/javascript">
 //清空新建课程窗口中的数据
	function clearCustomer() {
	    $("#new_customerName").val("");
	    $("#new_customerFrom").val("")
	    $("#new_custIndustry").val("")
	    $("#new_custLevel").val("")
	    $("#new_linkMan").val("");
	    $("#new_phone").val("");
	    $("#new_mobile").val("");
	    $("#new_zipcode").val("");
	    $("#new_address").val("");
	} 
	//用户点击修改课程按钮
	function editCourse(id) {
	//alert(id);
	    $.ajax({
       	   method:"get",
         	url:"/testManage/getCourseById.action?c_id"+id,
         	contentType: 'application/json; charset=UTF-8',
         	data:{"c_id":id},
		 	dataType:'json',
       	   	success:function (data) {
       	   	
       	   		$("#updateCourseName").val(data.c_name);
       	   		$("#c_id").val(data.c_id);
       	   		$("#c_chapter_num").val(data.c_chapter_num);
       	   		$("#c_s_id").val(data.c_s_id);
       	   		
         	 }
   	 });
	}
	// 删除课程
	function deleteCourse(id) {
		if (confirm("确定删除该试题？")==true){ 
			 	$.ajax({
	       	   method:"post",
	       	   contentType: 'application/json; charset=UTF-8',
	         	url:"/testManage/deleteCourse.action",
	         	data:{c_id:id},
			 	dataType:'json',
	       	   	success:function (data) {
	       	   		if(data.result=="1"){
							alert("课程删除成功！");
					}else if(data.result=="-1"){
							alert("该课程下有章节，不能删除！");
					}else{
							alert("课程删除失败！");
					}
	          }
		   	 });
		 }else{ 
		  	return false;
		 } 
   	 		   	 
	   
	}
 </script>

	

  </head>
  <style>
	/* #page-wrapper {
	    padding: 0 15px;
	    min-height: 100%;
	    background-color: #fff;
	} */
	</style>  
	
  <body>
   
    

	<div class="container">
     <div class="row">
			<div class="col-md-12">
				<h1 class="page-header">章节知识管理</h1>
			</div>
			
			
	</div>
	<div class="panel panel-default">
			<div class="panel-body">
				<form class="form-inline" method="post" >
					<div class="form-group">
						<label for="courseName">课程名称</label> 
						<input type="text" class="form-control" id="courseName" 
						                   value="" name="courseName" />
					</div>
				
					<button type="submit" class="btn btn-primary">查询</button>
				</form>
			</div>
		</div>
		<a href="#" class="btn btn-primary" data-toggle="modal" 
		           data-target="#myModal" onclick="clearCustomer()">新建课程</a>
			<div class="row">
			<div class="col-lg-12">
				<div class="panel panel-default">
					<div class="panel-heading">课程信息列表</div>
					<!-- /.panel-heading -->
					<table class="table table-bordered table-striped">
						<thead>
							<tr>
								<th>编号</th>
								<th>课程名称</th>
								<th>所属科目</th>
								<th>章节个数</th>
								<th>章节</th>
								<th>操作</th>
							</tr>
						</thead>
						<tbody>
						<c:if test="${ !empty Courses}">
							<c:forEach items="${Courses}" var="course"  varStatus="status">
								<tr>
									<td>${status.index+1 }</td>
									<td>${course.c_name}</td>
									<td>${course.c_chapter_num}</td>
									<td>${course.c_s_id}</td>
									<td>
										<a href="getChapterByCid.action?c_id=${course.c_id}" class="btn btn-primary btn-xs"  >查看章节</a>
										
									</td>
									<td>
										<a href="#" class="btn btn-primary btn-xs" data-toggle="modal" data-target="#updateCourseModal" onclick= "editCourse(${course.c_id})">修改</a>
										<a href="#" class="btn btn-danger btn-xs" onclick="deleteCourse(${course.c_id})">删除</a>
									</td>
								</tr>
							</c:forEach>
						</c:if>
						</tbody>
					</table>
					<div class="col-md-12 text-right">
						<%-- <itheima:page url="${pageContext.request.contextPath }/customer/list.action" /> --%>
					</div>
					<!-- /.panel-body -->
				</div>
				<!-- /.panel -->
			</div>
			<!-- /.col-lg-12 -->
		</div>           
		  
		           
		           
		           
		           
		<!-- -----------------------------添加课程的模态框---------------------------------------------- -->
				   			<div class="modal fade" id="myModal"  tabindex="-1" role="diaog" aria-labelledby="myModalLabel" aria-hidden="true">
				   				
				   				<div class="modal-dialog">
				   					<div class="modal-content">
				   						<div class="modal-header">
				   							<button type="button" class="close" data-dismiss="modal"  aria-hidden="true">&times;</button>
				   							<h4 class="modal-title" id="myModalLabel">添加课程</h4>
				   						</div>
				   						<div class="modal-body">
				   						<form class="form-horizontal" role="form" id="addTB">
				   								<div class="form-group">
													<label class=" col-md-2 control-label">科目</label> 
													<div class="col-md-8">
													<!-- 一级下拉框 -->
													<select	class=" form-control " id="addSubject2" name="subject" ">
														<option value="">--请选择--</option>
														<c:forEach items="${sessionScope.SUBJECTS_SESSION}" var="item">
															<option	 value="${item.s_id}">${item.s_name}</option>
														</c:forEach>
													</select>
													</div>
													 <div class="col-md-2">
													 	
											   		 </div>
												</div><!-- /form-gromp -->	
												
											  <div class="form-group">
											    <label for="stem" class="col-md-2 control-label">课程名称</label>
											    <div class="col-md-8">
											      <input type="text" class="form-control" id="addTBName" placeholder="">
											    </div>
											    <div class="col-md-2"></div>
											  </div><!-- /form-gromp -->	
											  <div class="form-group" id="chapter-num">
											    <label for="text" class="col-md-2 control-label">章节个数</label>
											    <div class="col-md-8">
											      <select id="addChapterNum"	class=" form-control "  onchange="change2(this.id)" >
														<option value="">--请选择--</option>
														<option value="1">1</option>
														<option value="2">2</option>
														<option value="3">3</option>
														<option value="4">4</option>
														<option value="5">5</option>
														<option value="6">6</option>
														<option value="7">7</option>
														<option value="8">8</option>
														<option value="9">9</option>
														<option value="10">10</option>
														<option value="11">11</option>
														<option value="12">12</option>
														<option value="13">13</option>
														<option value="14">14</option>
														<option value="15">15</option>
														<option value="16">16</option>
														<option value="17">17</option>
														<option value="18">18</option>
														<option value="19">19</option>
													</select>
											    </div>
											    <div class="col-md-2">
											    	<!-- <a id ="addChoice" class="btn btn-default btn-md"  href="#" role="button" onclick="addCt">
											    		<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
											    	</a> -->
											    	
											    </div>
											  </div><!-- /form-gromp -->
											  <script type="text/javascript">
											  /*用户点击添加课程*/
											  function addBook(){	    	
										    		var c_s_id = $("#addSubject2").val();
										    		var c_name=$("#addTBName").val();
										    		var c_chapter_num=$("#addChapterNum").val();
										    		var str="";
										    		//children()方法：获取该元素下的直接子集元素
													//find()方法：获取该元素下的所有子集元素
										    		$("#addChapterHeader").find("input").each(function(){
										    			//alert(this.value);
										    			str+=this.value+"@@";
										    		});
										    		var c_chapter_headers=str;
										    		//alert(str);
										    		//alert("c_s_id:"+c_s_id+" c_name:"+c_name+" c_chapter_num:"+c_chapter_num+" c_chapter_headers:"+c_chapter_headers);
										    		var data={c_name:c_name,c_chapter_num:c_chapter_num,c_chapter_headers:c_chapter_headers,c_s_id:c_s_id};
										    		$.ajax({
												       	   method:"post",
												         	url:"/testManage/addCourse.action",
												         	contentType: 'application/json; charset=UTF-8',
												         	data:JSON.stringify(data),
														 	dataType:'json',
														 	
												       	   	success:function (data) {
												       	   		if(data.result=="yes"){
																alert("添加成功");
																$("#myModal").modal('hide');  //手动关闭
																reset();//清除模态框缓存数据
																window.location.href ="/testManage/getAllCourses.action";//更新添加成功后的数据
																}else{
																	alert("保存失败");
															    }
												          	  
												         	 }
												   	 });
											   	
											   	 };
											   	 /*用户选择章节数目之后，添加章节到模态框*/
											  	function change2(id){
											  		var num = $("#addChapterNum").val();
											  			var str="<div>请输入各章节标题</div>";
											  			//alert(num);		
										           	  	for (var i = 1; i <= num; i++) {
										           	  		  str+="<div class='form-group'>"+
										           	  		  "<label for='text' class='col-md-2 control-label'>第"+i+"章</label>"+
										           	  		  "<div class='col-md-10'>"+
										           	  		  "<input type='text' class='form-control' >"+
										           	  		  "</div>"+
										           	  		  "</div>";
										         	 	 } 
										           	 	 
											  			/* $("#chapter-num").after(str); */
											  			$("#addChapterHeader").append(str);
											  			
											  			//alert();
											  	};
											  	function reset(){
											  		
											  		/* $("#addTB")[0].reset(); */
											  		 $("#addSubject2").find("option[text='--请选择--']").attr("selected",true);
											  		 $("#addChapterNum").find("option[text='--请选择--']").attr("selected",true);
											  		 $("#addTBName").val("");
											  		
											  		 $("#addChapterHeader").empty();
											  		  $("#addChapterHeader").html();
											  	};
											  	$('body').on('hidden.bs.modal', '.modal', function () {
												    $(this).removeData('bs.modal');
												});
											  </script>	
											  <!-- <div>请输入各章节标题</div>
											  <div class="form-group" id="chapter-header" >
											  		<label for="text" class="col-md-2 control-label"></label>
											  		<div class="col-md-10">
												      <input type="text" class="form-control" >
												    </div>
											  </div> -->
											  <div id="addChapterHeader">
											  		<!-- js动态填充内容 -->
											  </div>
											</form>  
				   						</div>
				   						<div class="modal-footer">
				   							<div class="form-group">
											    <div class="col-sm-offset-2 col-sm-10">
											      <button type="button" class="btn btn-primary" onclick="addBook()">提交</button>
											      <button type="button" class="btn btn-default" onclick="reset()" >重置</button>
				   								
											    </div>
											  </div>
				   						</div>
				   					</div><!--/ model-content -->
				   				</div><!--/ model-dialog -->
				   			</div><!--/ model -->
				   			<!-- --------------结束---------------添加课程的模态框---------------------------------------------- -->
				   			
<!-- -----------------------------修改课程的模态框开始---------------------------------------------- -->
				   			<div class="modal fade" id="updateCourseModal"  tabindex="-1" role="diaog" aria-labelledby="myModalLabel" aria-hidden="true">
				   				
				   				<div class="modal-dialog">
				   					<div class="modal-content">
				   						<div class="modal-header">
				   							<button type="button" class="close" data-dismiss="modal"  aria-hidden="true">&times;</button>
				   							<h4 class="modal-title" id="myModalLabel">修改课程信息</h4>
				   						</div>
				   						<div class="modal-body">
				   						<form class="form-horizontal" role="form" id="addTB">
				   								
												
											  <div class="form-group">
											    <label for="stem" class="col-md-2 control-label">课程名称</label>
											    <div class="col-md-8">
											    <input type="hidden" id="c_id" name="c_id"/><!-- 课程id -->
											    <input type="hidden" id="c_chapter_num" name="c_chapter_num"/><!-- 课程章节数 -->
											     <input type="hidden" id="c_s_id" name="c_s_id"/><!-- 所属科目 -->
											      <input type="text" class="form-control" id="updateCourseName" placeholder="">
											    </div>
											    <div class="col-md-2"></div>
											  </div><!-- /form-gromp -->	
											 
											  <script type="text/javascript">
											
										    // 点击保存修改课程操作
											function updateCourse() {
												var id=$("#c_id").val();
												var num=$("#c_chapter_num").val();
												var sid=$("#c_s_id").val();
												var name= $("#updateCourseName").val();
												var data={c_id:id,c_name:name,c_chapter_num:num,c_s_id:sid};
												$.ajax({
											       	   method:"post",
											         	url:"/testManage/updateCourse.action",
											         	contentType: 'application/json; charset=UTF-8',
											         	data:JSON.stringify(data),
													 	dataType:'json',
											       	   	success:function (data) {
											       	   		if(data.result=="yes"){
																alert("课程信息更新成功！");
																$("#updateCourseModal").modal('hide');  //手动关闭
																window.location.href ="/testManage/getAllCourses.action";//更新添加成功后的数据
															}else{
																alert("保存失败");
														    }
											          	  
											         	 }
											   	 });
													
												
											}
											
													</script>								
											  
											</form>  
				   						</div>
				   						<div class="modal-footer">
											<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
											<button type="button" class="btn btn-primary" onclick="updateCourse()">保存修改</button>
										</div>
				   					</div><!--/ model-content -->
				   				</div><!--/ model-dialog -->
				   			</div><!--/ model -->
				   			<!-- --------------结束---------------添加课程的模态框---------------------------------------------- -->
				   			<!-- 删除模态框 -->
				   			
    </div>
  </body>
</html>
