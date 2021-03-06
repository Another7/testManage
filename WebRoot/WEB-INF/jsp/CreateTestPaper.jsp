<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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


<style type="text/css">
.abc{ color:#999} 
</style>
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
	       	   //	alert(res.length);
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
    	
    	
    	function getQuestionNum(){//当用户选择完章节时，ajax发送章节id获取试题数量
    		var selectedValues =[];    
			 $("#addChapter:selected").each(function(){
			     selectedValues.push($(this).val()); 
			     
		      });
		      selectedValues=$("#addChapter").val();
		      console.log(selectedValues);
		      
		      
    	$.ajax({
	       	   method:"post",
	       	   
	         	url:"/testManage/questionLevelNumber.action",
	          
	         	data:{"data":selectedValues},
			 	dataType:'json',
			 	traditional: true, 
			 	
	       	   	success:function (res) {
	       	   			
	       	   			if(res.length == 0){
	                        //如果一级没有对应的二级 则清空二级并不往下执行
	                        $("#SCLevel1").empty();
	                         $("#SCLevel2").empty();
	                          $("#SCLevel3").empty();
	                           $("#SCLevel4").empty();
	                           
	                         $("#MCLevel1").empty();
	                          $("#MCLevel2").empty();
	                           $("#MCLevel3").empty();
	                            $("#MCLevel4").empty();
	                            
	                         $("#FBLevel4").empty();
	                          $("#FBLevel4").empty();
	                           $("#FBLevel4").empty();
	                            $("#FBLevel4").empty();
	                         
	                         $("#TFLevel1").empty();
	                          $("#TFLevel2").empty();
	                           $("#TFLevel3").empty();
	                            $("#TFLevel4").empty();
	                               
	                          $("#QALevel1").empty();
	                          $("#QALevel2").empty();
	                           $("#QALevel3").empty();
	                            $("#QALevel4").empty();
	                                
	                        $("#SCLevel1").selectpicker("refresh");
	                         $("#SCLevel2").selectpicker("refresh");
	                          $("#SCLevel3").selectpicker("refresh");
	                           $("#SCLevel4").selectpicker("refresh");
	                         
	                        $("#MCLevel1").selectpicker("refresh"); 
	                         $("#MCLevel2").selectpicker("refresh");
	                          $("#MCLevel3").selectpicker("refresh");
	                         
	                       $("#FBLevel4").selectpicker("refresh");  
	                        $("#FBLevel1").selectpicker("refresh"); 
	                         $("#FBLevel2").selectpicker("refresh");
	                          $("#FBLevel3").selectpicker("refresh");
	                           $("#FBLevel4").selectpicker("refresh");  
	                          
	                        $("#QALevel1").selectpicker("refresh"); 
	                         $("#QALevel2").selectpicker("refresh");
	                          $("#QALevel3").selectpicker("refresh");
	                           $("#QALevel4").selectpicker("refresh");  
	                           
	                        $("#TFLevel1").selectpicker("refresh"); 
	                         $("#TFLevel2").selectpicker("refresh");
	                          $("#TFLevel3").selectpicker("refresh");
	                           $("#TFLevel4").selectpicker("refresh");  
	                          
	                        return ;
	                   	 }
	                   	 
	                   /* 	alert(res.length);  
	       	   			alert(res.scQuestionNumber.level1+","+res.scQuestionNumber.level2+","+res.scQuestionNumber.level3+","+res.scQuestionNumber.level4);
	       	   			alert(res.mcQuestionNumber.level1+","+res.mcQuestionNumber.level2+","+res.mcQuestionNumber.level3+","+res.mcQuestionNumber.level4);
	       	   			alert(res.tfQuestionNumber.level1+","+res.tfQuestionNumber.level2+","+res.tfQuestionNumber.level3+","+res.tfQuestionNumber.level4);
	       	   			alert(res.fbQuestionNumber.level1+","+res.fbQuestionNumber.level2+","+res.fbQuestionNumber.level3+","+res.fbQuestionNumber.level4); 
	       	   			alert(res.qaQuestionNumber.level1+","+res.qaQuestionNumber.level2+","+res.qaQuestionNumber.level3+","+res.qaQuestionNumber.level4); */
	       	   			 
	                   	// alert(res.length);
	                   	  $("#SCLevel1").empty(); $("#SCLevel1").append("<option value='0'>0</option>");
	                         $("#SCLevel2").empty();$("#SCLevel2").append("<option value='0'>0</option>");
	                          $("#SCLevel3").empty();$("#SCLevel3").append("<option value='0'>0</option>");
	                           $("#SCLevel4").empty();$("#SCLevel4").append("<option value='0'>0</option>");
	                           
	                         $("#MCLevel1").empty();$("#MCLevel1").append("<option value='0'>0</option>");
	                          $("#MCLevel2").empty();$("#MCLevel2").append("<option value='0'>0</option>");
	                           $("#MCLevel3").empty();$("#MCLevel3").append("<option value='0'>0</option>");
	                            $("#MCLevel4").empty();$("#MCLevel4").append("<option value='0'>0</option>");
	                            
	                         $("#FBLevel1").empty();$("#FBLevel1").append("<option value='0'>0</option>");
	                          $("#FBLevel2").empty();$("#FBLevel2").append("<option value='0'>0</option>");
	                           $("#FBLevel3").empty();$("#FBLevel3").append("<option value='0'>0</option>");
	                            $("#FBLevel4").empty();$("#FBLevel4").append("<option value='0'>0</option>");
	                         
	                         $("#TFLevel1").empty();$("#TFLevel1").append("<option value='0'>0</option>");
	                          $("#TFLevel2").empty();$("#TFLevel2").append("<option value='0'>0</option>");
	                           $("#TFLevel3").empty();$("#TFLevel3").append("<option value='0'>0</option>");
	                            $("#TFLevel4").empty();$("#TFLevel4").append("<option value='0'>0</option>");
	                               
	                          $("#QALevel1").empty();$("#QALevel1").append("<option value='0'>0</option>");
	                          $("#QALevel2").empty();$("#QALevel2").append("<option value='0'>0</option>");
	                           $("#QALevel3").empty();$("#QALevel3").append("<option value='0'>0</option>");
	                            $("#QALevel4").empty(); $("#QALevel4").append("<option value='0'>0</option>");
	                            
	                            
		          		 var str1="";
		           	  	for (var i = 1; i <= res.scQuestionNumber.level1; i++) {
		            	 	  str1+="<option value='"+i+"'>"+i+"</option>";
		         	 	 }
		         	 	 $("#SCLevel1").append(str1);
		         	 	 $("#SCLevel1").find("0").attr("selected",true);$("#sclevel1").text(res.scQuestionNumber.level1);
		         	 	 str1="";
		         	 	 for (var i = 1; i <= res.scQuestionNumber.level2; i++) {
		            	 	  str1+="<option value='"+i+"'>"+i+"</option>";
		         	 	 }
		         	 	 $("#SCLevel2").append(str1);
		         	 	 $("#SCLevel2").find("0").attr("selected",true);$("#sclevel2").text(res.scQuestionNumber.level2);
		         	 	 
		         	 	  str1="";
		         	 	 for (var i = 1; i <= res.scQuestionNumber.level3; i++) {
		            	 	  str1+="<option value='"+i+"'>"+i+"</option>";
		         	 	 }
		         	 	 $("#SCLevel3").append(str1);
		         	 	 $("#SCLevel3").find("0").attr("selected",true);$("#sclevel3").text(res.scQuestionNumber.level3);
		         	 	 
		         	 	 
		         	 	 str1="";
		         	 	 for (var i = 1; i <= res.scQuestionNumber.level4; i++) {
		            	 	  str1+="<option value='"+i+"'>"+i+"</option>";
		         	 	 }
		         	 	 $("#SCLevel4").append(str1);
		         	 	 $("#SCLevel4").find("0").attr("selected",true); $("#sclevel4").text(res.scQuestionNumber.level4);
		         	 	 
		         	 	//2////////////////////////////////////////////////////////// 
		         	 	 var str2="";
		         	 	 for (var i = 1; i <= res.mcQuestionNumber.level1; i++) {
		            	 	  str2+="<option value='"+i+"'>"+i+"</option>";
		         	 	 }
		         	 	 $("#MCLevel1").append(str2);
		         	 	 $("#MCLevel1").find("0").attr("selected",true); $("#mclevel1").text(res.mcQuestionNumber.level1);
		         	 	
		         	 	 var str2="";
		         	 	 for (var i = 1; i <=res.mcQuestionNumber.level2; i++) {
		            	 	  str2+="<option value='"+i+"'>"+i+"</option>";
		         	 	 }
		         	 	 $("#MCLevel2").append(str2);
		         	 	 $("#MCLevel2").find("0").attr("selected",true); $("#mclevel2").text(res.mcQuestionNumber.level2);
		         	 	 
		         	 	  var str2="";
		         	 	 for (var i = 1; i <= res.mcQuestionNumber.level3; i++) {
		            	 	 str2+="<option value='"+i+"'>"+i+"</option>";
		         	 	 }
		         	 	 $("#MCLevel3").append(str2);
		         	 	 $("#MCLevel3").find("0").attr("selected",true); $("#mclevel3").text(res.mcQuestionNumber.level3);
		         	 	 
		         	 	  var str2="";
		         	 	 for (var i = 1; i <= res.mcQuestionNumber.level4; i++) {
		            	 	 str2+="<option value='"+i+"'>"+i+"</option>";
		         	 	 }
		         	 	 $("#MCLevel4").append(str2);
		         	 	 $("#MCLevel4").find("0").attr("selected",true); $("#mclevel4").text(res.mcQuestionNumber.level4);
		         	 	//3//////////////////////////////////////////////////////////////// 
		         	 	var str3="";
		         	 	  for (var i = 1; i <=res.fbQuestionNumber.level1; i++) {
		            	 	 str3+="<option value='"+i+"'>"+i+"</option>";
		         	 	 }
		         	 	 $("#FBLevel1").append(str3);
		         	 	 $("#FBLevel1").find("0").attr("selected",true); $("#fblevel1").text(res.fbQuestionNumber.level1);
		         	 	 
		         	 	 var str3="";
		         	 	  for (var i = 1; i <= res.fbQuestionNumber.level2; i++) {
		            	 	 str3+="<option value='"+i+"'>"+i+"</option>";
		         	 	 }
		         	 	 $("#FBLevel2").append(str3);
		         	 	 $("#FBLevel2").find("0").attr("selected",true); $("#fblevel2").text(res.fbQuestionNumber.level2);
		         	 	 
		         	 	 var str3="";
		         	 	  for (var i = 1; i <= res.fbQuestionNumber.level3; i++) {
		            	 	 str3+="<option value='"+i+"'>"+i+"</option>";
		         	 	 }
		         	 	 $("#FBLevel3").append(str3);
		         	 	 $("#FBLevel3").find("0").attr("selected",true); $("#fblevel3").text(res.fbQuestionNumber.level3);
		         	 	 
		         	 	 var str3="";
		         	 	  for (var i = 1; i <= res.fbQuestionNumber.level4; i++) {
		            	 	 str3+="<option value='"+i+"'>"+i+"</option>";
		         	 	 }
		         	 	 $("#FBLevel4").append(str3);
		         	 	 $("#FBLevel4").find("0").attr("selected",true); $("#fblevel4").text(res.fbQuestionNumber.level4);
		         	 	 
		         	 	 //4///////////////////////////////////////////////////////////////////
		         	 	 
		         	 	 
		         	 	var str4="";
		         	 	  for (var i = 1; i <= res.tfQuestionNumber.level1; i++) {
		            	 	 str4+="<option value='"+i+"'>"+i+"</option>";
		         	 	 }
		         	 	 $("#TFLevel1").append(str4);
		         	 	 $("#TFLevel1").find("0").attr("selected",true); $("#tflevel1").text(res.tfQuestionNumber.level1);
		         	 	 
		         	 	 var str4="";
		         	 	  for (var i = 1; i <= res.tfQuestionNumber.level2; i++) {
		            	 	 str4+="<option value='"+i+"'>"+i+"</option>";
		         	 	 }
		         	 	 $("#TFLevel2").append(str4);
		         	 	 $("#TFLevel2").find("0").attr("selected",true); $("#tflevel2").text(res.tfQuestionNumber.level2);
		         	 	 
		         	 	 var str4="";
		         	 	  for (var i = 1; i <= res.tfQuestionNumber.level3; i++) {
		            	 	 str4+="<option value='"+i+"'>"+i+"</option>";
		         	 	 }
		         	 	 $("#TFLevel3").append(str4);
		         	 	 $("#TFLevel3").find("0").attr("selected",true); $("#tflevel3").text(res.tfQuestionNumber.level3);
		         	 	 
		         	 	 var str4="";
		         	 	  for (var i = 1; i <= res.tfQuestionNumber.level4; i++) {
		            	 	 str4+="<option value='"+i+"'>"+i+"</option>";
		         	 	 }
		         	 	 $("#TFLevel4").append(str4);
		         	 	 $("#TFLevel4").find("0").attr("selected",true); $("#tflevel4").text(res.tfQuestionNumber.level4);
		         	 	 
		         	 	 
		         	 	 var str5="";
		         	 	  for (var i = 1; i <= res.qaQuestionNumber.level1; i++) {
		            	 	 str5+="<option value='"+i+"'>"+i+"</option>";
		         	 	 }
		         	 	 $("#QALevel1").append(str5);
		         	 	 $("#QALevel1").find("0").attr("selected",true);$("#qalevel1").text(res.qaQuestionNumber.level1); 
		         	 	 
		         	 	  var str5="";
		         	 	  for (var i = 1; i <= res.qaQuestionNumber.level2; i++) {
		            	 	 str5+="<option value='"+i+"'>"+i+"</option>";
		         	 	 }
		         	 	 $("#QALevel2").append(str5);
		         	 	 $("#QALevel2").find("0").attr("selected",true); $("#qalevel2").text(res.qaQuestionNumber.level2); 
		         	 	 
		         	 	  var str5="";
		         	 	  for (var i = 1; i <= res.qaQuestionNumber.level3; i++) {
		            	 	 str5+="<option value='"+i+"'>"+i+"</option>";
		         	 	 }
		         	 	 $("#QALevel3").append(str5);
		         	 	 $("#QALevel3").find("0").attr("selected",true);$("#qalevel3").text(res.qaQuestionNumber.level3);  
		         	 	 
		         	 	  var str5="";
		         	 	  for (var i = 1; i <= res.qaQuestionNumber.level4; i++) {
		            	 	 str5+="<option value='"+i+"'>"+i+"</option>";
		         	 	 }
		         	 	 $("#QALevel4").append(str5);
		         	 	 $("#QALevel4").find("0").attr("selected",true); $("#qalevel4").text(res.qaQuestionNumber.level4); 
		         	 	 
		         	 	 
		         	 	
		           	 
		          	 
	       	   		
	          }
	   	 });
    	
    	
    	}
    	
    	//点击输入试卷名称时，
    	function getChapterId(){
    			
    	}
    	//计算总分
    	function countScore(){
    		var sc=$("#scScore").val();
    		var mc=$("#mcScore").val();
    		var fb=$("#fbScore").val();
    		var tf=$("#tfScore").val();
    		var qa=$("#qaScore").val();
    		
    		var scl1=$("#SCLevel1").val();
    		var scl2=$("#SCLevel2").val();
    		var scl3=$("#SCLevel3").val();
    		var scl4=$("#SCLevel4").val();
    		var mcl1=$("#MCLevel1").val();
    		var mcl2=$("#MCLevel2").val();
    		var mcl3=$("#MCLevel3").val();
    		var mcl4=$("#MCLevel4").val();
    		var fbl1=$("#FBLevel1").val();
    		var fbl2=$("#FBLevel2").val();
    		var fbl3=$("#FBLevel3").val();
    		var fbl4=$("#FBLevel4").val();
    		var tfl1=$("#TFLevel1").val();
    		var tfl2=$("#TFLevel2").val();
    		var tfl3=$("#TFLevel3").val();
    		var tfl4=$("#TFLevel4").val();
    		var qal1=$("#QALevel1").val();
    		var qal2=$("#QALevel2").val();
    		var qal3=$("#QALevel3").val();
    		var qal4=$("#QALevel4").val();
    		
    		var totalScore=(Number(scl1)+Number(scl2)+Number(scl3)+Number(scl4))*Number(sc)+
    				(Number(mcl1)+Number(mcl2)+Number(mcl3)+Number(mcl4))*Number(mc)+
    				(Number(fbl1)+Number(fbl2)+Number(fbl3)+Number(fbl4))*Number(fb)+
    				(Number(tfl1)+Number(tfl2)+Number(tfl3)+Number(tfl4))*Number(tf)+
    				(Number(qal1)+Number(qal2)+Number(qal3)+Number(qal4))*Number(qa);
    		$("#totalScore").val(totalScore);   
    		
    		//alert(totalScore);
	                       
	                    
    	}
    	//用户点击生成试卷方法
    	function CreateTestPaper(){
    		res=confirm("确定生成试卷?"); //在页面上弹出对话框
    		var chapterIds =[];    
			 
		      chapterIds=$("#addChapter").val();
		      
    		var name=$("#tpName").val();
    		var illustrate=$("#tpIllustrate").val();
    		var term=$("#tpTerm").val();
    		var major=$("#tpMajor").val();
    		var clazz=$("#tpClazz").val();
    		
    		
    		
    		
    		var scNumber={level1:$("#SCLevel1").val(),level2:$("#SCLevel2").val(),level3:$("#SCLevel3").val(),level4:$("#SCLevel4").val()};
    		var mcNumber={level1:$("#MCLevel1").val(),level2:$("#MCLevel2").val(),level3:$("#MCLevel3").val(),level4:$("#MCLevel4").val()};
    		var fbNumber={level1:$("#FBLevel1").val(),level2:$("#FBLevel1").val(),level3:$("#FBLevel1").val(),level4:$("#FBLevel1").val()};
    		var tfNumber={level1:$("#TFLevel1").val(),level2:$("#TFLevel1").val(),level3:$("#TFLevel1").val(),level4:$("#TFLevel1").val()};
    		var qaNumber={level1:$("#QALevel1").val(),level2:$("#QALevel1").val(),level3:$("#QALevel1").val(),level4:$("#QALevel1").val()};
    		var score=$("#totalScore").val();
    		var data={tpName:name,tpIllustrate:illustrate,tpTerm:term,tpClass:clazz,scNumber:scNumber,mcNumber:mcNumber,fbNumber:fbNumber,tfNumber:tfNumber,qaNumber:qaNumber,chapterIds:chapterIds,tpScore:score,tpMajor:major};
    		
    		
			if(res==true){
			 //显示
                $('#loadingModal').modal({backdrop: 'static', keyboard: false});
                $("#loadingModal").modal('show');
                $.ajax({
                    type: "post",
                    url:"/testManage/createTestPaper.action",
                    contentType: 'application/json; charset=UTF-8', 
                    data:JSON.stringify(data),   
                    dataType: "json",                           
                    success: function(data) {
                        
                        if(data.result=="yes"){
                        	//表明创建试卷成功，获取试卷id,跳转到试卷展示页面
                        	
                        	//隐藏进度条
                        	$("#loadingModal").modal('hide');
                        	//获取model中的试卷id
                        	var tpid=data.tpId;
                        	//alert(tpid);
                        	window.location.href ="/testManage/getTestPaperByTpid.action?tpId="+tpid;//跳转到展示页面
                        }
                   },
                   error: function(data) {
                     //隐藏
                       $("#loadingModal").modal('hide');
                     	alert("试卷生成出错！")
                   }
                });
			
			}
			else{
			}
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
										class="selectpicker show-tick form-control" multiple  onchange="getQuestionNum()">
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
						 <input type="text" id="tpName" class="form-control"   placeholder="如：数据结构测试题">
						</div>
						 <div class="col-md-2">
				   		 </div>
					</div>
					<div class="form-group">
						<label class=" col-md-2 control-label">填写试卷用途说明</label> 
						<div class="col-md-8">
						 <input type="text" id="tpIllustrate" class="form-control"  placeholder="如：期中测试">
						</div>
						<div class="col-md-2">
				   		</div>
					</div>
					 
					<div class="form-group">
						<label   for="text" class=" col-md-2 control-label">填写学期</label> 
						<div class="col-md-8">
						 <input type="text" id="tpTerm" class="form-control"  placeholder="格式：2018-2019学年上学期">
						</div>
						<div class="col-md-2">
				    	</div>
				    </div>
			<div class="form-group">
						<label   for="text" class=" col-md-2 control-label">填写所在专业</label> 
						<div class="col-md-8">
						 <input type="text" id="tpMajor" class="form-control"  placeholder="如：软件工程专业">
						</div>
						<div class="col-md-2">
				    	</div>
				    </div>
				
				
				<div class="form-group">
						<label   for="text" class=" col-md-2 control-label">填写所在班级</label> 
						<div class="col-md-8">
						 <input type="text" id="tpClazz" class="form-control"  placeholder="如：RB软工**班">
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
						<label class=" col-xs-2 control-label">单选题</label> 
						<div class="col-xs-2 " style="overflow: hidden;">
						<!-- 一级下拉框 -->
						
						 简单题&nbsp;
						 <select id="SCLevel1" class=" form-control " style="width: 60px">
									<option value="0">0</option>
						</select>
						&nbsp;<div class="abc form-inline">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span id="sclevel1" ></span>道可选</div>
						</div>
						
						<div class="col-xs-2" >
						<!-- 一级下拉框 -->
						 一般题&nbsp;<select id="SCLevel2" class=" form-control " style="width: 60px"
											>
											<option value="0">0</option>
										</select>&nbsp;<div class="abc form-inline">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span id="sclevel2" ></span>道可选</div>
						</div>
						
						<div class="col-xs-2">
						<!-- 一级下拉框 -->
						 较难题&nbsp;<select id="SCLevel3" class=" form-control " style="width: 60px">
											<option value="0">0</option>
										</select>&nbsp;<div class="abc form-inline">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span id="sclevel3" ></span>道可选</div>
						</div>
						
						<div class="col-xs-2">
						<!-- 一级下拉框 -->
						 困难题&nbsp;<select id="SCLevel4" class=" form-control " style="width: 60px"
											>
											<option value="0">0</option>
										</select>&nbsp;<div class="abc form-inline">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span id="sclevel4" ></span>道可选</div>
						</div>
						 <div class="col-xs-2">
						 	每题&nbsp;<input type="text" id="scScore" onchange="countScore()" class="form-control"  placeholder="0" style="width: 60px">&nbsp;分
				   		 </div>
						</div>
					</div>
					<div class="form-group">
					<div class="form-inline">
						<label class=" col-xs-2 control-label">多选题</label> 
				<div class="col-md-2">
						<!-- 一级下拉框 -->
						 简单题&nbsp;<select id="MCLevel1" class=" form-control " style="width: 60px">
											<option value="0">0</option>
										</select>&nbsp;<div class="abc form-inline">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span id="mclevel1" ></span>道可选</div>
						</div>
						<div class="col-xs-2">
						<!-- 一级下拉框 -->
						 一般题&nbsp;<select id="MCLevel2" class=" form-control " style="width: 60px">
											<option value="0">0</option>
										</select>&nbsp;<div class="abc form-inline">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span id="mclevel2" ></span>道可选</div>
						</div>
						<div class="col-xs-2">
						<!-- 一级下拉框 -->
						 较难题&nbsp;<select id="MCLevel3" class=" form-control " style="width: 60px">
											<option value="0">0</option>
										</select>&nbsp;<div class="abc form-inline">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span id="mclevel3" ></span>道可选</div>
						</div>
						<div class="col-xs-2">
						<!-- 一级下拉框 -->
						 困难题&nbsp;<select id="MCLevel4" class=" form-control " style="width: 60px">
											<option value="0">0</option>
										</select>&nbsp;<div class="abc form-inline">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span id="mclevel4" ></span>道可选</div>
						</div>
						 <div class="col-xs-2">
						 	每题&nbsp;<input type="text" id="mcScore" onchange="countScore()" class="form-control"  placeholder="0" style="width: 60px">&nbsp;分
				   		 </div>
						</div>
					</div>
					<div class="form-group">
						<div class="form-inline">
						<label class=" col-xs-2 control-label">填空题</label> 
					<div class="col-md-2">
						<!-- 一级下拉框 -->
						 简单题&nbsp;<select id="FBLevel1" class=" form-control " style="width: 60px">
											<option value="0">0</option>
										</select>&nbsp;<div class="abc form-inline">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span id="fblevel1" ></span>道可选</div>
						</div>
						<div class="col-xs-2">
						<!-- 一级下拉框 -->
						 一般题&nbsp;<select id="FBLevel2" class=" form-control " style="width: 60px">
											
											<option value="0">0</option>
										</select>&nbsp;<div class="abc form-inline">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span id="fblevel2" ></span>道可选</div>
						</div>
						<div class="col-xs-2">
						<!-- 一级下拉框 -->
						 较难题&nbsp;<select id="FBLevel3" class=" form-control " style="width: 60px">
											<option value="0">0</option>
										</select>&nbsp;<div class="abc form-inline">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span id="fblevel3" ></span>道可选</div>
						</div>
						<div class="col-xs-2">
						<!-- 一级下拉框 -->
						 困难题&nbsp;<select id="FBLevel4" class=" form-control " style="width: 60px">
											<option value="0">0</option>
										</select>&nbsp;<div class="abc form-inline">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span id="fblevel4" ></span>道可选</div>
						</div>
						 <div class="col-xs-2">
						 	每题&nbsp;<input type="text" id="fbScore" onchange="countScore()" class="form-control"  placeholder="0" style="width: 60px">&nbsp;分
				   		 </div>
						</div>
					</div>
					<div class="form-group">
					<div class="form-inline">
						<label class=" col-xs-2 control-label">判断题</label> 
					<div class="col-md-2">
						<!-- 一级下拉框 -->
						 简单题&nbsp;<select id="TFLevel1" class=" form-control " style="width: 60px">
											<option value="0">0</option>
										</select>&nbsp;<div class="abc form-inline">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span id="tflevel1" ></span>道可选</div>
						</div>
						<div class="col-xs-2">
						<!-- 一级下拉框 -->
						 一般题&nbsp;<select id="TFLevel2" class=" form-control " style="width: 60px">
											<option value="0">0</option>
										</select>&nbsp;<div class="abc form-inline">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span id="tflevel2" ></span>道可选</div>
						</div>
						<div class="col-xs-2">
						<!-- 一级下拉框 -->
						 较难题&nbsp;<select id="TFLevel3" class=" form-control " style="width: 60px">
											<option value="0">0</option>
										</select>&nbsp;<div class="abc form-inline">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span id="tflevel3" ></span>道可选</div>
						</div>
						<div class="col-xs-2">
						<!-- 一级下拉框 -->
						 困难题&nbsp;<select id="TFLevel4" class=" form-control " style="width: 60px">
											<option value="0">0</option>
										</select>&nbsp;<div class="abc form-inline">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span id="tflevel4" ></span>道可选</div>
						</div>
						 <div class="col-xs-2">
						 	每题&nbsp;<input type="text" id="tfScore" onchange="countScore()" class="form-control"  placeholder="0" style="width: 60px">&nbsp;分
				   		 </div>
						</div>
					</div>
					<div class="form-group">
					<div class="form-inline">
						<label class=" col-xs-2 control-label">简答题</label> 
						<div class="col-md-2">
						<!-- 一级下拉框 -->
						 简单题&nbsp;<select id="QALevel1" class=" form-control " style="width: 60px">
											<option value="0">0</option>
										</select>&nbsp;<div class="abc form-inline">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span id="qalevel1" ></span>道可选</div>
						</div>
						<div class="col-xs-2">
						<!-- 一级下拉框 -->
						 一般题&nbsp;<select id="QALevel2" class=" form-control " style="width: 60px">
											<option value="0">0</option>
										</select>&nbsp;<div class="abc form-inline">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span id="qalevel2" ></span>道可选</div>
						</div>
						<div class="col-xs-2">
						<!-- 一级下拉框 -->
						 较难题&nbsp;<select id="QALevel3" class=" form-control " style="width: 60px">
											<option value="0">0</option>
										</select>&nbsp;<div class="abc form-inline">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span id="qalevel3" ></span>道可选</div>
						</div>
						<div class="col-xs-2">
						<!-- 一级下拉框 -->
						 困难题&nbsp;<select id="QALevel4" class=" form-control " style="width: 60px">
											<option value="0">0</option>
										</select>&nbsp;<div class="abc form-inline">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span id="qalevel4" ></span>道可选</div>
						</div>
						 <div class="col-xs-2">
						 	每题&nbsp;<input type="text" id="qaScore" onchange="countScore()" class="form-control"  placeholder="0" style="width: 60px">&nbsp;分
				   		 </div>
						</div>
					</div>
					<hr>
					<div class="form-group ">
					<div class="form-inline">
						 <div class="col-md-8"></div>
						<div class="col-md-4">
							<button class="btn btn-primary " onclick="countScore()">总分</button>
							<input type="text" id="totalScore" class="form-control"  placeholder="0">分
							
						</div>
					</div>
						
					
					</div>
					
				</form>
			</div>
		</div>
		<hr>
		<div style="text-align:center">
		<button class="btn btn-primary" onclick="CreateTestPaper()" >生成试卷</button>	
		</div>
		
		<hr>
	<div class="modal fade" id="loadingModal">
    <div style="width: 200px;height:20px; z-index: 20000; position: absolute; text-align: center; left: 50%; top: 50%;margin-left:-100px;margin-top:-10px">
        <div class="progress progress-striped active" style="margin-bottom: 0;">
            <div class="progress-bar" style="width: 100%;"></div>
        </div>
        <h5>正在生成试卷...</h5>
    </div>
</div>
	</div>
	</div>
	</div>
</body>
</html>