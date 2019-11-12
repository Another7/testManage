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
	function reset() {
	    $("#chapterName").val("");
	  /*   $("#new_customerFrom").val("")
	    $("#new_custIndustry").val("")
	    $("#new_custLevel").val("")
	    $("#new_linkMan").val("");
	    $("#new_phone").val("");
	    $("#new_mobile").val("");
	    $("#new_zipcode").val("");
	    $("#new_address").val(""); */
	} 
	//用户点击修改知识点按钮，把知识点内容呈现
	function editKnowledgePoint(id) {
	alert(id);
	    $.ajax({
       	   method:"get",
         	url:"/testManage/getKnowledgePointByKpId.action?kp_id="+id,
         	contentType: 'application/json; charset=UTF-8',
		 	dataType:'json',
       	   	success:function (data) {
       	   	
       	   		$("#updateKpName").val(data.kp_name);
       	   		$("#kp_c_id").val(data.kp_c_id);
       	   		$("#kp_ct_id").val(data.ct_num);
       	   		$("#kp_id").val(data.kp_id);
       	   		
         	 }
   	 });
	}
	// 删除章节
	function deleteKnowledgePoint(id,ctid) {
		if (confirm("确定删除该知识点？")==true){ 
			 	$.ajax({
		       	   method:"get",
		       	   contentType: 'application/json; charset=UTF-8',
		         	url:"/testManage/deleteKnowledgePointByKp_id.action?kp_id="+id,
				 	dataType:'json',
		       	   	success:function (data) {
		       	   		if(data.status_code=="1"){
								alert("知识点删除成功！");
						}else{
								alert("删除失败！");
						}
						window.location.href ="/testManage/getKnowledgePointByCt2_id.action?ct_id="+ctid+"&ct_c_id="+id;//更新数据
						
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
				<h1 class="page-header">知识点管理</h1>
			</div>
			
			
	</div>
	<div class="panel panel-default">
			<div class="panel-body">
				<form class="form-inline" method="post" >
					<div class="form-group">
						<label for="knowledgePointName">知识点名称</label> 
						<input type="text" class="form-control" id="knowledgePointName" 
						                   value="" name="knowledgePointName" />
					</div>
				
					<button type="submit" class="btn btn-primary">查询</button>
				</form>
			</div>
		</div>
		<a href="#" class="btn btn-primary" data-toggle="modal" 
		           data-target="#createKnowledgePoint" onclick="reset()">新建知识点</a>
			<div class="row">
			<div class="col-lg-12">
				<div class="panel panel-default">
					<div class="panel-heading">知识点信息列表</div>
					<!-- /.panel-heading -->
					<table class="table table-bordered table-striped">
						<thead>
							<tr>
								<th>编号</th>
								<th>知识点名称</th>
								<th>操作</th>
							</tr>
						</thead>
						<tbody>
						<c:if test="${ !empty knowledgePoint}">
							<c:forEach items="${knowledgePoint}" var="KnowledgePoint"  varStatus="status">
								<tr>
									<td>${status.index+1 }</td>
									<td>${KnowledgePoint.kp_name}</td>
									<td>
										<a href="#" class="btn btn-primary btn-xs" data-toggle="modal" data-target="#myModal" onclick= "editKnowledgePoint(${KnowledgePoint.kp_id})">修改</a>
										<a href="javascript:void(0);" class="btn btn-danger btn-xs" onclick="deleteKnowledgePoint(${KnowledgePoint.kp_id},${KnowledgePoint.kp_ct_id })">删除</a>
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
		  
		           
		           
		           
		           
		<!-- -----------------------------添加章节的模态框---------------------------------------------- -->
				   			<div class="modal fade" id="createKnowledgePoint"  tabindex="-1" role="diaog" aria-labelledby="myModalLabel" aria-hidden="true">
				   				
				   				<div class="modal-dialog">
				   					<div class="modal-content">
				   						<div class="modal-header">
				   							<button type="button" class="close" data-dismiss="modal"  aria-hidden="true">&times;</button>
				   							<h4 class="modal-title" id="myModalLabel">新建知识点</h4>
				   						</div>
				   						<div class="modal-body">
				   						<form class="form-horizontal" role="form" id="addTB">
				   								
												
											  <div class="form-group">
											    <label for="stem" class="col-md-3 control-label">知识点名称</label>
											    <div class="col-md-9">
													<input id="kpName" type="text" class="form-control"  placeholder="">
											    </div>
											    <div class="col-md-2">
											    	
											    </div>
											  </div><!-- /form-gromp -->	
											
											  <script type="text/javascript">
											  /*用户点击添加章节*/
											  function addknowledgePoint(){	
											  		var ct_id='${ct_id}'; 
											  		var c_id='${ct_c_id}'; 
											  		  	
										    		var kp_name=$("#kpName").val();
										    		
										    		var data={kp_c_id:c_id,kp_ct_id:ct_id,kp_name:kp_name};
										    		
										    	
										    		$.ajax({
												       	   method:"post",
												         	url:"/testManage/addknowledgePoint.action",
												         	contentType: 'application/json; charset=UTF-8',
												         	data:JSON.stringify(data),
														 	dataType:'json',
												       	   	success:function (data) {
												       	   		
												       	   		if(data.status_code=="1"){
										     						alert("添加成功");
																	$("#createknowledgePoint").modal('hide');  //手动关闭
																
																	window.location.href ="/testManage/getKnowledgePointByCt2_id.action?ct_id="+ct_id+"&ct_c_id="+c_id;
																}else{
																	alert("保存失败");
															    }
															    $("#knowledgePointName").val("");
												          	  
												         	 }
												   	 });
											   	
											   	 };
											   	 
											   	 
											   	 /* 根据所选择的科目，查找该科目下的课程列表，并显示在select里*/
												function change(id){	    	
										    		var code = $("#selectSubject").val();
										    		//alert(code);
										    		$.ajax({
											       	   method:"post",
											         	url:"/testManage/getCourses.action",
											         	data:{"data":code},
													 	dataType:'json',
											       	   	success:function (res) {
											       	   		if(res.length == 0){
										                        //如果一级没有对应的二级 则清空二级并不往下执行
										                        $("#selectCourse").empty();
										                        $("#selectCourse").selectpicker("refresh");
										                          
										                        return ;
										                   	 }
										                   	// alert(res.length);
											          		 var str="";
											           	  	for (var i = 0; i < res.length; i++) {
											            	 	  str+="<option value='"+res[i].c_id+"'>"+res[i].c_name+"</option>";
											         	 	 } 
											           	  $("#selectCourse").append(str);
											          	  $("#selectCourse").find("option[text='--请选择--']").attr("selected",true);
											          }
											   	 });
										    	}
											   	 
											  
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
											      <button type="button" class="btn btn-primary" onclick="addknowledgePoint()">提交</button>
											      <button type="reset" class="btn btn-default" onclick="reset()" >重置</button>
				   								
											    </div>
											  </div>
				   						</div>
				   					</div><!--/ model-content -->
				   				</div><!--/ model-dialog -->
				   			</div><!--/ model -->
				   			<!-- --------------结束---------------添加章节的模态框---------------------------------------------- -->
				   			
<!-- -----------------------------修改的模态框开始---------------------------------------------- -->
				   			<div class="modal fade" id="#myModal"  tabindex="-1" role="diaog" aria-labelledby="myModalLabel" aria-hidden="true">
				   				
				   				<div class="modal-dialog">
				   					<div class="modal-content">
				   						<div class="modal-header">
				   							<button type="button" class="close" data-dismiss="modal"  aria-hidden="true">&times;</button>
				   							<h4 class="modal-title" id="myModalLabel">修改知识点信息</h4>
				   						</div>
				   						<div class="modal-body">
				   						<form class="form-horizontal" role="form" id="addTB">
				   								
												
											  <div class="form-group">
											    <label for="stem" class="col-md-2 control-label">知识点名称</label>
											    <div class="col-md-8">
											    <input type="hidden" id="kp_id" name="kp_id"/><!-- 知识点id -->
											    <input type="hidden" id="kp_ct_id" name="kp_ct_id"/><!-- 知识点所属章节id -->
											     <input type="hidden" id="kp_c_id" name="kp_c_id"/><!-- 所属课程id -->
											      <input type="text" class="form-control" id="updateKpName" placeholder="">
											    </div>
											    <div class="col-md-2"></div>
											  </div><!-- /form-gromp -->	
											 
											  <script type="text/javascript">
											
										    // 点击保存修改章节操作
											function updateChapter() {
												var id=$("#kp_id").val();
												var ctid=$("#kp_ct_id").val();
												var cid=$("#kp_c_id").val();
												var kpname= $("#updateKpName").val();
												var data={kp_id:id,kp_c_id:cid,kp_ct_id:ctid,kp_name:kpname};
												$.ajax({
											       	   method:"post",
											         	url:"/testManage/updateKnowledgePoint.action",
											         	contentType: 'application/json; charset=UTF-8',
											         	data:JSON.stringify(data),
													 	dataType:'json',
											       	   	success:function (data) {
											       	   		if(data.status_code=="1"){
																alert("知识点更新成功！");
																$("#myModal").modal('hide');  //手动关闭
																window.location.href ="/testManage/getKnowledgePointByCt2_id.action?ct_id="+ctid+"&ct_c_id="+cid;//更新添加成功后的数据
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
											<button type="button" class="btn btn-primary" onclick="updateChapter()">保存修改</button>
										</div>
				   					</div><!--/ model-content -->
				   				</div><!--/ model-dialog -->
				   			</div><!--/ model -->
				   			<!-- --------------结束---------------修改章节的模态框---------------------------------------------- -->
    </div>
  </body>
</html>
