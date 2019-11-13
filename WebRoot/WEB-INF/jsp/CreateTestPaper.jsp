<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-81">
<title>创建试卷</title>
 <script src="js/jquery.min.js"></script>
 <script src="js/bootstrap.min.js"></script>
  <script src="js/bootstrap-select.js"></script>
 <link href="css/bootstrap.min.css" rel="stylesheet">
 <!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-select@1.13.12/dist/css/bootstrap-select.min.css">

<!-- Latest compiled and minified JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap-select@1.13.12/dist/js/bootstrap-select.min.js"></script>

<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.10.0/js/i18n/defaults-zh_CN.min.js"></script>
  <script type="text/javascript">
  		/* 根据所选择的科目，查找该科目下的课程列表，并显示在select里*/
		function change(id){	    	
    		var code = $("#addSubject").val();
    		//alert(code);
    		$.ajax({
	       	   method:"post",
	         	url:"/testManage/getCourses.action",
	         	data:{"data":code},
			 	dataType:'json',
	       	   	success:function (res) {
	       	   		if(res.length == 0){
                        //如果一级没有对应的二级 则清空二级并 不往下执行
                       
                        $("#addCourse").empty();
                        $("#addCourse").selectpicker("refresh");
                        return ;
                   	 }
                   	// alert(res.length);
	          		 var str="";
	           	  	for (var i = 0; i < res.length; i++) {
	            	 	  str+="<option value='"+res[i].c_id+"'>"+res[i].c_name+"</option>";
	         	 	 } 
	           	  $("#addCourse").append(str);
	          	  $("#addCourse").find("option[text='--请选择--']").attr("selected",true);
	          }
	   	 });
    	}
    	/* 当科目改变时，获取该科目下的章节列表，给对应的下拉框赋值 */
    	function changeBook(id){
    		var kemu=$("#addCourse").val();
    		//alert(kemu);
    		$.ajax({
	       	   method:"post",
	         	url:"/testManage/getChapters.action",
	         	data:{"data":kemu},
			 	dataType:'json',
	       	   	success:function (res) {
	       	   	//$('#addChapter').selectpicker('val', res);
	       	   	alert(res.length);
	       	   		if(res.length == 0){
                        //如果一级没有对应的二级 则清空二级并 不往下执行
                       // $("#addChapter").empty();
                       
                        return ;
                   	 }
                  
	          		 var str="";
	           	  	for (var i = 0; i < res.length; i++) {
	            	 	  str+="<option value='"+res[i].ct_id+"'>"+(i+1)+"."+res[i].ct_name+"</option>";
	         	 	 } 
	           	  $("#addChapter").append(str);
	          	  $("#addChapter").find("option[text='--请选择--']").attr("selected",true);
	          	   $('.selectpicker').selectpicker('refresh');  //刷新数据
	          }
	   	 });
    	}
    	function getChapterId(){
    			var selectedValues = [];    
			 $("#addChapter:selected").each(function(){
			     selectedValues.push($(this).val()); 
			     
		      });
		      console.log(selectedValues);
    	
    	
    	}
    	/* 当章节改变时，获取该章节下的知识点列表，给对应的下拉框赋值 */
    	function changeChapter(id){
    		var chapterId=$("#addChapter").val();
    		//alert(kemu);
    		$.ajax({
	       	   method:"post",
	         	url:"/testManage/getKnowledgePointByCt_id.action",
	         	data:{"ct_id":chapterId},
			 	dataType:'json',
	       	   	success:function (res) {
	       	   			alert(res.length);    
	       	   		if(res.length == 0){
                        //如果一级没有对应的二级 则清空二级并 不往下执行
                        $("#addChapter").empty();
                        return ;
                   	 }
                   	 
	          		 var str="";
	           	  	for (var i = 0; i < res.length; i++) {
	            	 	   str+="<option value='"+res[i].kp_id+"'>"+res[i].kp_name+"</option>";
	         	 	 } 
	           	  $("#point").append(str);
	           	//  alert($("#point")==null);
	          	  $("#point").find("option[text='--请选择--']").attr("selected",true);
	          }
	   	 });
    	}
    		
    	/*用户点击添加选项*/
    	function addXuanXiang(){
    		//alert($("#choices").children().length);
    		var choiceNum=$("#choices").children().length;
    		var str="";
    		str+=" <div class='form-group'>"+
    			"<label for='text' class='col-md-2 control-label'>选项"+(choiceNum+1)+"</label>"+
    			"<div class='col-md-8'>"+
    			"<input type='text' class='form-control'>"+
    			"</div>"+
    			"<div class='col-md-2'></div>";
    		$("#choices").append(str);
    		
		}	
		/*单选试题的提交*/
		function submitAll(){
    		var stem=$("#SCStem").val();	
    		var str="";
   			$("#choices").find("input").each(function(){
    			str+=this.value+"@@";
    		});
    		var option=str;
    		var answer=$("#answer").val();
    		var analysis=$("#analysis").val();	
    		var subject=$("#addSubject").val();
    		var c_id=$("#addCourse").val();
    		var ct_id=$("#addChapter").val();
    		var point=$("#point").val();
    		var level=$("#level").val();
		   var data={sc_subject:subject,sc_point:point,sc_stem:stem,sc_option:option,sc_answer:answer,sc_analysis:analysis,sc_c_id:c_id,sc_ct_id:ct_id,sc_level:level};
		   	$.ajax({
		       	   method:"post",
		         	url:"/testManage/addSCQuestion.action",
		         	contentType: 'application/json; charset=UTF-8',
		         	data:JSON.stringify(data),
				 	dataType:'json',
		       	   	success:function (data) {
		       	   		if(data.result=="yes"){
							alert("添加成功");
							self.location.reload();
						}else{
							alert("保存失败");
					    }
		         	 }
		   	 });
		   	 
    		
		   	
    	}	  
    	
 </script>	
</head>
<body >
	<!-- 从session获取科目种类 -->
	<div>
	<div>
	<hr>
	<ul class="breadcrumb">
	 <li><a href="#">我要组卷</a></li>
    <li><a href="#">随机组卷</a></li>
   
	</ul>
	<div class="panel panel-default">
			<div class="panel-heading">选择章节</div>
			<div class="panel-body">
					<div>
						<form class="form-horizontal" id="totalForm">

								<div class="form-group">
									<label class=" col-md-2 control-label">科目</label>
									<div class="col-md-8">
										<!-- 一级下拉框 -->
										<select class=" form-control " id="addSubject" name="subject"
											onchange="change(this.id)">
											<option value="">--请选择--</option>
											<c:forEach items="${sessionScope.SUBJECTS_SESSION}" var="item">
												<option value="${item.s_id}">${item.s_name}</option>
											</c:forEach>
										</select>
									</div>
									<div class="col-md-2"></div>
	
								</div>
								<div class="form-group">
									<label class=" col-md-2 control-label">课程</label>
									<div class="col-md-8">
										<!-- 二级下拉框 -->
										<select id="addCourse" class=" form-control " name="Course"
											onchange="changeBook(this.id)">
											<option value="">--请选择--</option>
										</select>
									</div>
									<div class="col-md-2"></div>
	
								</div>
					
		
							<div class="form-group">
								<label for="text" class=" col-md-2 control-label">选择章节</label>
								<div class="col-md-8">
									<!-- 一级下拉框 -->
									<!-- <select id="addChapter"	class=" form-control" name="chapter" onchange="changeChapter(this.id)" >
									<option value="">--请选择--</option>
								</select> -->
									<select id="addChapter"
										class="selectpicker show-tick form-control" multiple>
										<option value="">--请选择--</option>
									</select>
								</div>
								<div class="col-md-2"></div>
							</div>


					</form>
					
				</div>
				
			</div>
		
		</div>
	</div>
	<div class="panel panel-default">
		 <div class="panel-heading">试卷设置</div>
			<div class="panel-body">
				
				<form class="form-horizontal" id="totalForm">
				
					 <div class="form-group">
						<label class=" col-md-2 control-label">试卷名称</label> 
						<div class="col-md-8">
						<!-- 一级下拉框 -->
						 <input type="text" class="form-control"  placeholder="如：数据结构测试题">
						</div>
						 <div class="col-md-2">
						 	
				   		 </div>
						
					</div>
					<div class="form-group">
						<label class=" col-md-2 control-label">填写试卷用途说明</label> 
						<div class="col-md-8">
						 <input type="text" class="form-control"  placeholder="如：期末试题">
						</div>
						<div class="col-md-2">
						
				   		
				   		</div>
					</div>
					 
					<div class="form-group">
						<label   for="text" class=" col-md-2 control-label">填写学期</label> 
						<div class="col-md-8">
						 <input type="text" class="form-control"  placeholder="格式：2018-2019学年上学期">
							
						</div>
						<div class="col-md-2">
							 
				    	</div>
				    </div>
			<div class="form-group">
						<label   for="text" class=" col-md-2 control-label">填写所在专业</label> 
						<div class="col-md-8">
						 <input type="text" class="form-control"  placeholder="如：软件工程专业">
							
						</div>
						<div class="col-md-2">
							 
				    	</div>
				    </div>
				
				
				<div class="form-group">
						<label   for="text" class=" col-md-2 control-label">填写所在班级</label> 
						<div class="col-md-8">
						 <input type="text" class="form-control"  placeholder="如：RB软工卓越161班">
							
						</div>
						<div class="col-md-2">
							 
				    	</div>
				    </div>
				
				</form>
			</div>
		</div>
			
	
	</div>
	<div class="panel panel-default">
		 <div class="panel-heading">试题量设置</div>
			<div class="panel-body">
				
				<form class="form-horizontal" id="totalForm">
					
					 <div class="form-group">
					 <div class="form-inline">
						<label class=" col-sm-2 control-label">单选题</label> 
						<div class="col-md-2">
						<!-- 一级下拉框 -->
						 简单题&nbsp;<select id="SCLevel1" class=" form-control " style="width: 60px"
											onchange="changeBook(this.id)">
											<option value="">0-</option>
										</select>&nbsp;道
						</div>
						<div class="col-xs-2">
						<!-- 一级下拉框 -->
						 一般题&nbsp;<select id="SCLevel2" class=" form-control " style="width: 60px"
											onchange="changeBook(this.id)">
											<option value="">0</option>
										</select>&nbsp;道
						</div>
						<div class="col-xs-2">
						<!-- 一级下拉框 -->
						 较难题&nbsp;<select id="SCLevel3" class=" form-control " style="width: 60px"
											onchange="changeBook(this.id)">
											<option value="">0</option>
										</select>&nbsp;道
						</div>
						<div class="col-xs-2">
						<!-- 一级下拉框 -->
						 困难题&nbsp;<select id="SCLevel4" class=" form-control " style="width: 60px"
											onchange="changeBook(this.id)">
											<option value="">0</option>
										</select>&nbsp;道
						</div>
						 <div class="col-xs-2">
						 	每题&nbsp;<input type="text" class="form-control"  placeholder="0" style="width: 60px">&nbsp;分
				   		 </div>
						</div>
					</div>
					<div class="form-group">
					<div class="form-inline">
						<label class=" col-xs-2 control-label">多选题</label> 
				<div class="col-md-2">
						<!-- 一级下拉框 -->
						 简单题&nbsp;<select id="MCLevel1" class=" form-control " style="width: 60px"
											onchange="changeBook(this.id)">
											<option value="">0-</option>
										</select>&nbsp;道
						</div>
						<div class="col-xs-2">
						<!-- 一级下拉框 -->
						 一般题&nbsp;<select id="MCLevel2" class=" form-control " style="width: 60px"
											onchange="changeBook(this.id)">
											<option value="">0</option>
										</select>&nbsp;道
						</div>
						<div class="col-xs-2">
						<!-- 一级下拉框 -->
						 较难题&nbsp;<select id="MCLevel3" class=" form-control " style="width: 60px"
											onchange="changeBook(this.id)">
											<option value="">0</option>
										</select>&nbsp;道
						</div>
						<div class="col-xs-2">
						<!-- 一级下拉框 -->
						 困难题&nbsp;<select id="MCLevel4" class=" form-control " style="width: 60px"
											onchange="changeBook(this.id)">
											<option value="">0</option>
										</select>&nbsp;道
						</div>
						 <div class="col-xs-2">
						 	每题&nbsp;<input type="text" class="form-control"  placeholder="0" style="width: 60px">&nbsp;分
				   		 </div>
						</div>
					</div>
					<div class="form-group">
						<div class="form-inline">
						<label class=" col-xs-2 control-label">填空题</label> 
					<div class="col-md-2">
						<!-- 一级下拉框 -->
						 简单题&nbsp;<select id="FBLevel1" class=" form-control " style="width: 60px"
											onchange="changeBook(this.id)">
											<option value="">0-</option>
										</select>&nbsp;道
						</div>
						<div class="col-xs-2">
						<!-- 一级下拉框 -->
						 一般题&nbsp;<select id="FBLevel2" class=" form-control " style="width: 60px"
											onchange="changeBook(this.id)">
											<option value="">0</option>
										</select>&nbsp;道
						</div>
						<div class="col-xs-2">
						<!-- 一级下拉框 -->
						 较难题&nbsp;<select id="FBLevel3" class=" form-control " style="width: 60px"
											onchange="changeBook(this.id)">
											<option value="">0</option>
										</select>&nbsp;道
						</div>
						<div class="col-xs-2">
						<!-- 一级下拉框 -->
						 困难题&nbsp;<select id="FBLevel4" class=" form-control " style="width: 60px"
											onchange="changeBook(this.id)">
											<option value="">0</option>
										</select>&nbsp;道
						</div>
						 <div class="col-xs-2">
						 	每题&nbsp;<input type="text" class="form-control"  placeholder="0" style="width: 60px">&nbsp;分
				   		 </div>
						</div>
					</div>
					<div class="form-group">
					<div class="form-inline">
						<label class=" col-xs-2 control-label">判断题</label> 
					<div class="col-md-2">
						<!-- 一级下拉框 -->
						 简单题&nbsp;<select id="TFLevel1" class=" form-control " style="width: 60px"
											onchange="changeBook(this.id)">
											<option value="">0-</option>
										</select>&nbsp;道
						</div>
						<div class="col-xs-2">
						<!-- 一级下拉框 -->
						 一般题&nbsp;<select id="TFLevel2" class=" form-control " style="width: 60px"
											onchange="changeBook(this.id)">
											<option value="">0</option>
										</select>&nbsp;道
						</div>
						<div class="col-xs-2">
						<!-- 一级下拉框 -->
						 较难题&nbsp;<select id="TFLevel3" class=" form-control " style="width: 60px"
											onchange="changeBook(this.id)">
											<option value="">0</option>
										</select>&nbsp;道
						</div>
						<div class="col-xs-2">
						<!-- 一级下拉框 -->
						 困难题&nbsp;<select id="TFLevel4" class=" form-control " style="width: 60px"
											onchange="changeBook(this.id)">
											<option value="">0</option>
										</select>&nbsp;道
						</div>
						 <div class="col-xs-2">
						 	每题&nbsp;<input type="text" class="form-control"  placeholder="0" style="width: 60px">&nbsp;分
				   		 </div>
						</div>
					</div>
					<div class="form-group">
					<div class="form-inline">
						<label class=" col-xs-2 control-label">简答题</label> 
						<div class="col-md-2">
						<!-- 一级下拉框 -->
						 简单题&nbsp;<select id="QALevel1" class=" form-control " style="width: 60px"
											onchange="changeBook(this.id)">
											<option value="">0-</option>
										</select>&nbsp;道
						</div>
						<div class="col-xs-2">
						<!-- 一级下拉框 -->
						 一般题&nbsp;<select id="QALevel2" class=" form-control " style="width: 60px"
											onchange="changeBook(this.id)">
											<option value="">0</option>
										</select>&nbsp;道
						</div>
						<div class="col-xs-2">
						<!-- 一级下拉框 -->
						 较难题&nbsp;<select id="QALevel3" class=" form-control " style="width: 60px"
											onchange="changeBook(this.id)">
											<option value="">0</option>
										</select>&nbsp;道
						</div>
						<div class="col-xs-2">
						<!-- 一级下拉框 -->
						 困难题&nbsp;<select id="QALevel4" class=" form-control " style="width: 60px"
											onchange="changeBook(this.id)">
											<option value="">0</option>
										</select>&nbsp;道
						</div>
						 <div class="col-xs-2">
						 	每题&nbsp;<input type="text" class="form-control"  placeholder="0" style="width: 60px">&nbsp;分
				   		 </div>
						</div>
					</div>
					<hr>
					<div class="form-group ">
					<div class="form-inline">
						 <div class="col-md-8"></div>
						<div class="col-md-4">
							<button class="btn btn-primary ">总分</button>
							<input type="text" class="form-control"  placeholder="0">分
							
						</div>
					</div>
						
					
					</div>
					
				</form>
			</div>
		</div>
		<hr>
		<div style="text-align:center">
		<button class="btn btn-primary" >生成试卷</button>	
		</div>
		
		<hr>
	
	</div>
	</div>
	</div>
</body>
</html>