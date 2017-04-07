<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">      
    <meta http-equiv="X-UA-Compatible" content="IE=12;IE=11;IE=10;IE=9;IE=8;IE=7;IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>政企文化 | 模块管理</title>
      <!-- Bootstrap Core CSS -->
      <link href="resources/lib/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">

      <!-- MetisMenu CSS -->
      <link href="resources/lib/metisMenu/dist/metisMenu.min.css" rel="stylesheet">

      <!-- Timeline CSS -->
      <link href="resources/dist/css/timeline.css" rel="stylesheet">

      <!-- Custom CSS -->
      <link href="resources/dist/css/sb-admin-2.css" rel="stylesheet">

      <link href="resources/dist/css/DRA-ui.css" rel="stylesheet">
      <!-- jQuery -->
      <script src="resources/lib/jquery/dist/jquery.min.js"></script>

      <!-- Bootstrap Core JavaScript -->
      <script src="resources/lib/bootstrap/dist/js/bootstrap.min.js"></script>

      <!-- Metis Menu Plugin JavaScript -->
      <script src="resources/lib/metisMenu/dist/metisMenu.min.js"></script>

      <!-- Morris Charts JavaScript -->
      <script src="resources/lib/raphael/raphael-min.js"></script>
      <script src="resources/lib/morrisjs/morris.min.js"></script>
      <!-- Custom Theme JavaScript -->
      <script src="resources/dist/js/sb-admin-2.js"></script>
      <script src="resources/dist/js/jquery.validate.js"></script>
      <script src="<%=path %>/resources/js/util.js"></script>

  </head>
  <script type="text/javascript">
  $(function(){
	  $.ajax({
          type: "post",
          url: "/culture/model/operation.htm",
          data: {
        	  cmd:"getAll"
        	  },
          success: function(data){
        	  var list=JSON.parse(data).body;
        	  for(var i=0;i<list.length;i++){
        		  var data=new Date(list[i].createtime).Format("yyyy-MM-dd hh:mm:ss");
        		  list[i].createtime=data;
        		  var tr=$("<tr></tr>").append($("<td></td>").text(i)).append($("<td></td>").text(list[i].name))
        		  			.append($("<td></td>").text(list[i].creatorname)).append($("<td></td>").text(data))
        		  			.append($("<td></td>").text(list[i].lastupdateuser)).append($("<td></td>").text(new Date(list[i].lastupdatetime).Format("yyyy-MM-dd hh:mm:ss")))
        		  			.append($("<td></td>").text(list[i].sort));
        		  if(list[i].state=="1"){
        			  tr.append($("<td></td>").text("已上线")).append($("<td></td>").html("<button type=\"button\" class=\"btn btn-link my-link\" onclick='update(0,"+list[i].id+")'>下线</button>  <button type=\"button\" class=\"btn btn-link my-link\" data-toggle='modal' data-target='#myModal1' onclick='editModule("+list[i].id+")'>修改</button> <button type=\"button\" class=\"btn btn-link my-link\" onclick='delmodule("+list[i].id+")'>删除</button>"));
        		  }else{
        			  tr.append($("<td></td>").text("已下线")).append($("<td></td>").html("<button type=\"button\" class=\"btn btn-link my-link\" onclick='update(1,"+list[i].id+")'>上线</button>  <button type=\"button\" class=\"btn btn-link my-link\" data-toggle='modal' data-target='#myModal1' onclick='editModule("+list[i].id+")'>修改</button> <button type=\"button\" class=\"btn btn-link my-link\" onclick='delmodule("+list[i].id+")'>删除</button>"));
        		  }
        		  $("#moduleList").append(tr);
        		  console.log(data);
        	  }
          }
	  });
	  $("#addForm ").validate({
	        rules: {
	        	moduleName: "required",
			   moduleSort: {
			    required: false,
			    digits: true,
			   }
	        }
	  });
	  $("#updateForm ").validate({
	        rules: {
	        	name: "required",
			   	sort: {
			    required: false,
			    digits: true,
			   }
	        }
	  });
  });
  function update(state,id){
	  $.ajax({
          type: "post",
          url: "model/operation.htm",
          data: {
        	  cmd:"updateState",
        	  state:state,
        	  id:id
        	  },
          success: function(data){
        	  if(data==1){
        		  window.location.reload();
        	  }
          }
	  });
  }
  function delmodule(id){
	  $.ajax({
          type: "post",
          url: "model/operation.htm",
          data: {
        	  cmd:"delete",
        	  id:id
        	  },
          success: function(data){
        	  if(data==1){
        		  window.location.reload();
        	  }
          }
	  });
  }
  function editModule(id){
	  $.ajax({
          type: "post",
          url: "model/operation.htm",
          data: {
        	  cmd:"getModuleByid",
        	  id:id
        	  },
          success: function(data){
        	  var list=JSON.parse(data).body;
        	  for(var i=0;i<list.length;i++){
        		  $("#moduleid").val(list[i].id);
        		  $("#name").val(list[i].name);
        		  $("#sort").val(list[i].sort);
        	  }
          }
	  });
  }
  </script>
  <body>
  <div class="container-fluid content">
 <div class="row" style="margin-top: 10px;margin-bottom: 10px;">
 	<div class="col-lg-11 col-md-10 col-sm-9 col-xs-7 ">
 	</div>
 	<div class="col-lg-1  col-md-2 col-sm-3 col-xs-5 text-center" > <button  data-toggle="modal" data-target="#myModal" class="btn btn-outline btn-default" >新增</button></div>
 </div>
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
				<h4 class="modal-title" id="myModalLabel">新增模块</h4>
			</div>
			<form action="model/operation.htm" method="post" name="form" id="addForm">
				<div class="modal-body">
					<input type="hidden" name="cmd" value="add">
					<label>名称：</label>&nbsp;<input type="text" name="moduleName" id="moduleName"><br><br>
					<label>排序：</label>&nbsp;<input type="text" name="moduleSort" id="moduleSort"><br><br>
					<label>状态：</label>&nbsp;
					<select name="state">
						<option value="1">立即启用</option>
						<option value="0">暂不启用</option>
					</select>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="submit" class="btn btn-primary">提交</button>
				</div>
			</form>
			</div>
		</div>
	</div>
	
	<div class="modal fade" id="myModal1" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
				<h4 class="modal-title" id="myModalLabel">修改模块</h4>
			</div>
			<form action="model/operation.htm" method="post" id="updateForm" name="form">
				<div class="modal-body">
					<input type="hidden" name="cmd" value="update">
					<input type="hidden" name="moduleid" id="moduleid">
					<label>名称：</label>&nbsp;<input type="text" name="name" id="name"><br><br>
					<label>排序：</label>&nbsp;<input type="text" name="sort" id="sort"><br><br>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="submit" class="btn btn-primary">提交</button>
				</div>
			</form>
			</div>
		</div>
	</div>
<table id="moduleList" class="table table-striped table-bordered table-hover">
    <thead>
        <tr>
            <th>序号</th>
            <th>名称</th>
            <th>创建人</th>
            <th>创建时间</th>
            <th>最后修改人</th>
            <th>最后修改时间</th>
            <th>排序</th>
            <th>状态</th>
            <th>操作</th>
        </tr>
    </thead>
</table> 
  
   </div>
  </body>
</html>






<%--     <!-- Bootstrap -->
    <link href="<%=path %>/resources/lib/bootstrap_v3.3.5/css/bootstrap.css" rel="stylesheet">
    <link href="<%=path %>/resources/css/model.css" rel="stylesheet">
    <script src="<%=path %>/resources/lib/jquery-1.11.3.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="<%=path %>/resources/lib/bootstrap_v3.3.5/js/bootstrap.min.js"></script>
<script src="<%=path %>/resources/js/util.js"></script>
<script src="<%=path %>/resources/js/jquery.validate.js"></script>
<script src="<%=path %>/resources/js/message.js"></script>
   
  </head>
  <script type="text/javascript">
  $(function(){
	  $.ajax({
          type: "post",
          url: "model/operation.htm",
          data: {
        	  cmd:"getAll"
        	  },
          success: function(data){
        	  var list=JSON.parse(data).body;
        	  for(var i=0;i<list.length;i++){
        		  var data=new Date(list[i].createtime).Format("yyyy-MM-dd hh:mm:ss");
        		  list[i].createtime=data;
        		  var tr=$("<tr></tr>").append($("<td></td>").text(i)).append($("<td></td>").text(list[i].name))
        		  			.append($("<td></td>").text(list[i].creatorname)).append($("<td></td>").text(data))
        		  			.append($("<td></td>").text(list[i].lastupdateuser)).append($("<td></td>").text(new Date(list[i].lastupdatetime).Format("yyyy-MM-dd hh:mm:ss")))
        		  			.append($("<td></td>").text(list[i].sort));
        		  if(list[i].state=="1"){
        			  tr.append($("<td></td>").text("已上线")).append($("<td></td>").html("<button type=\"button\" class=\"btn btn-link\" onclick='update(0,"+list[i].id+")'>下线</button>  <button type=\"button\"  <button type=\"button\" class=\"btn btn-link\" onclick='delmodule("+list[i].id+")'>删除</button>"));
        		  }else{
        			  tr.append($("<td></td>").text("已下线")).append($("<td></td>").html("<button type=\"button\" class=\"btn btn-link\" onclick='update(1,"+list[i].id+")'>上线</button>  <button type=\"button\" class=\"btn btn-link\" data-toggle='modal' data-target='#myModal1' onclick='editModule("+list[i].id+")'>修改</button> <button type=\"button\" class=\"btn btn-link\" onclick='delmodule("+list[i].id+")'>删除</button>"));
        		  }
        		  $("#moduleList").append(tr);
        		  console.log(data);
        	  }
          }
	  });
	  $("#addForm ").validate({
	        rules: {
	        	moduleName: "required",
			   moduleSort: {
			    required: false,
			    digits: true,
			   }
	        }
	  });
	  $("#updateForm ").validate({
	        rules: {
	        	name: "required",
			   	sort: {
			    required: false,
			    digits: true,
			   }
	        }
	  });
  });
  function update(state,id){
	  $.ajax({
          type: "post",
          url: "model/operation.htm",
          data: {
        	  cmd:"updateState",
        	  state:state,
        	  id:id
        	  },
          success: function(data){
        	  if(data==1){
        		  window.location.reload();
        	  }
          }
	  });
  }
  function delmodule(id){
	  $.ajax({
          type: "post",
          url: "model/operation.htm",
          data: {
        	  cmd:"delete",
        	  id:id
        	  },
          success: function(data){
        	  if(data==1){
        		  window.location.reload();
        	  }
          }
	  });
  }
  function editModule(id){
	  $.ajax({
          type: "post",
          url: "model/operation.htm",
          data: {
        	  cmd:"getModuleByid",
        	  id:id
        	  },
          success: function(data){
        	  var list=JSON.parse(data).body;
        	  for(var i=0;i<list.length;i++){
        		  $("#moduleid").val(list[i].id);
        		  $("#name").val(list[i].name);
        		  $("#sort").val(list[i].sort);
        	  }
          }
	  });
  }
  </script>
  <body>
  <div class="container-fluid content">
 <div class="row">
 	<div class="col-lg-11 col-md-10 col-sm-9 col-xs-7 ">
 	</div>
 	<div class="col-lg-1  col-md-2 col-sm-3 col-xs-5 text-center"> <button  data-toggle="modal" data-target="#myModal" class="d-btn all-bg" >新增</button></div>
 </div>
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
				<h4 class="modal-title" id="myModalLabel">新增模块</h4>
			</div>
			<form action="model/operation.htm" method="post" name="form" id="addForm">
				<div class="modal-body">
					<input type="hidden" name="cmd" value="add">
					<label>名称：</label>&nbsp;<input type="text" name="moduleName" id="moduleName"><br><br>
					<label>排序：</label>&nbsp;<input type="text" name="moduleSort" id="moduleSort"><br><br>
					<label>状态：</label>&nbsp;
					<select name="state">
						<option value="1">立即启用</option>
						<option value="0">暂不启用</option>
					</select>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="submit" class="btn btn-primary">提交</button>
				</div>
			</form>
			</div>
		</div>
	</div>
	
	<div class="modal fade" id="myModal1" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
				<h4 class="modal-title" id="myModalLabel">修改模块</h4>
			</div>
			<form action="model/operation.htm" method="post" id="updateForm" name="form">
				<div class="modal-body">
					<input type="hidden" name="cmd" value="update">
					<input type="hidden" name="moduleid" id="moduleid">
					<label>名称：</label>&nbsp;<input type="text" name="name" id="name"><br><br>
					<label>排序：</label>&nbsp;<input type="text" name="sort" id="sort"><br><br>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="submit" class="btn btn-primary">提交</button>
				</div>
			</form>
			</div>
		</div>
	</div>
<table id="moduleList" class="table table-bordered d-tatle">
    <tr>
        <th>序号</th>
        <th>名称</th>
        <th>创建人</th>
        <th>创建时间</th>
        <th>最后修改人</th>
        <th>最后修改时间</th>
        <th>排序</th>
        <th>状态</th>
        <th>操作</th>
    </tr>
</table> 
  
   </div>
  
  

  </body>
</html> --%>
