<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html ng-app="addApp" ng-controller="addCtorl">
  <head>
    <base href="<%=basePath%>">
    <meta http-equiv="X-UA-Compatible" content="IE=12;IE=11;IE=10;IE=9;IE=8;IE=7;IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>政企文化 | 文章添加</title>
      <!-- Bootstrap Core CSS -->
      <link href="resources/lib/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">

      <!-- MetisMenu CSS -->
      <link href="resources/lib/metisMenu/dist/metisMenu.min.css" rel="stylesheet">

      <!-- Timeline CSS -->
      <link href="resources/dist/css/timeline.css" rel="stylesheet">

      <!-- Custom CSS -->
      <link href="resources/dist/css/sb-admin-2.css" rel="stylesheet">

      <link href="resources/dist/css/DRA-ui.css" rel="stylesheet">
    <script type="text/javascript" charset="utf-8" src="ueditor/ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8" src="ueditor/ueditor.all.js"></script>
    <script type="text/javascript" charset="utf-8" src="ueditor/lang/zh-cn/zh-cn.js"></script>
    
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="//cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="//cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

  </head>
  
<body>
<div class="container-fluid content">
	<form method="POST" enctype="multipart/form-data" id="addFrom" action="<%=path %>/doc/addAndUpdate.do"> 
      <input type="hidden" name="docId" value="{{doc.id}}">
    <div class="row line-magin" style="margin-bottom: 0px;">
         <div class="col-lg-6  col-md-6 col-sm-6 col-xs-6 form-group">
             <label class="content-right">模&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;块:</label>
         	<select class="selectpicker btn btn-default" name="docType" id="docType">
		    	<option value="{{item.id}}" ng-bind="item.name" ng-repeat="item in types" ></option>
            </select>
         </div>
        
	</div>
 <div class="row line-magin">
          <div class="col-lg-6  col-md-6 col-sm-6 col-xs-6 form-group">
              <label class="content-right">标&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;题:</label>
              <input type="text"  name="title"  ng-model="doc.title"/></div>
 </div>
 <div class="row line-magin">
  		 <div class="col-lg-12  col-md-12 col-sm-12 col-xs-12 form-group">
             <label class="content-right">是否轮播:</label>
             <input type="checkbox" id="play" >
            <input type="hidden" name="state" value="{{doc.state}}" id="state">
            <input type="hidden" name="isPlay" value="{{doc.isPlay}}" id="isPlay">
         </div>
 </div>
 <div class="row line-magin">
  		 <div class="col-lg-12  col-md-12 col-sm-12 col-xs-12 form-group">
             <label class="content-right">能否评论:</label>
             <input type="checkbox" id="reply" checked="true" >
            <input type="hidden" name="isReply" value="{{doc.isReply}}" id="isReply">
         </div>
 </div>
 <div class="row line-magin">
  		 <div class="col-lg-12  col-md-12 col-sm-12 col-xs-12 form-group">
             <label class="content-right">能否点赞:</label>
             <input type="checkbox" id="thumbsUp" checked="true" >
            <input type="hidden" name="isThumbsUp" value="{{doc.isThumbsUp}}" id="isThumbsUp">
         </div>
 </div>
<div class="row line-magin" >
        <div class="col-lg-1  col-md-1 col-sm-1 col-xs-1 form-group">
            <label class="content-right">封面图片:</label>

        </div>

        <div class="col-lg-1  col-md-1 col-sm-2 col-xs-2 " style="height: 50px;">
			<img ng-src="{{doc.url}}" ng-mousemove="like($event)" ng-mouseout="likeout()" style="width: 60px;height: 40px;" id="headimg" onerror="javascript:this.src='resources/docImg/Picture.png'">   
        </div>
                <div class="col-lg-5  col-md-5 col-sm-8 col-xs-8 ">
             <input type="file" name="headImg" id="imgLoad" style="display: none" >
            <label for="imgLoad" class="btn btn-outline btn-default" style="margin-top: 5px;"  >添加封面</label>
          	<input type="hidden" name="headUrl" id="imgUrl" value="{{doc.url}}">
          		<span id="imgAlt" style="position: relative;top:10px;margin-left: 20px;color:red;">提示: 请上传比例为 480*320 的图片</span>
          	
        </div>
</div>    
 	<script id="editor" type="text/plain" name="content" style="height:500px;"></script>
 	<input type="hidden" name="passage" ng-model="doc.passage" id="passage">
    </form>
    <div style="margin-top: 10px;text-align: center;margin-bottom: 10px;">
    	<button class="btn btn-outline btn-default" ng-click="back()">取消</button>&nbsp;&nbsp;
    	<button class="btn btn-outline btn-default" ng-click="save()">保存</button>&nbsp;&nbsp;
    </div>
 	
       
</div>


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

<script src="resources/dist/js/angular.min.js"></script>

 	<script src="resources/lib/angular.min.js"></script>
	<script src="resources/js/util.js"></script>
	<script src="resources/lib/alert.js"></script>
	<script src="resources/js/add.js"></script>
  </body>
</html> 
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
  <%--   <!-- Bootstrap -->
    <script type="text/javascript">var path="<%=path %>";</script>
    
    <link href="<%=path %>/resources/lib/bootstrap_v3.3.5/css/bootstrap.css" rel="stylesheet">
    <link href="<%=path %>/resources/css/model.css" rel="stylesheet">
    <script type="text/javascript" charset="utf-8" src="<%=path %>/ueditor/ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8" src="<%=path %>/ueditor/ueditor.all.js"></script>
    <script type="text/javascript" charset="utf-8" src="<%=path %>/ueditor/lang/zh-cn/zh-cn.js"></script>
    
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="//cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="//cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

  </head>
  
<body>
<div class="container-fluid content">
	<form method="POST" enctype="multipart/form-data" id="addFrom" action="<%=path %>/doc/addAndUpdate.do"> 
      <input type="hidden" name="docId" value="{{doc.id}}">
    <div class="row">
         <div class="col-lg-1  col-md-1 col-sm-1 col-xs-1 "><label class="content-right">模&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;块:</label></div>
  
         <div class="col-lg-11  col-md-11 col-sm-11 col-xs-11 ">            
         	<select class="selectpicker all-bg" name="docType" id="docType">
		    	<option value="{{item.id}}" ng-bind="item.name" ng-repeat="item in types" ></option>
            </select>
         </div>
        
	</div>
 <div class="row line-magin">
          <div class="col-lg-1  col-md-1 col-sm-1 col-xs-1"> <label class="content-right">标&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;题:</label></div>
          <div class="col-lg-11  col-md-11 col-sm-11 col-xs-11 "><input type="text" class="d-input" name="title"  ng-model="doc.title"/></div>
 </div>
 <div class="row line-magin">
  		 <div class="col-lg-1  col-md-1 col-sm-1 col-xs-1 ">
         	<label class="content-right">是否轮播:</label>
         </div>
  		 <div class="col-lg-11  col-md-11 col-sm-11 col-xs-11 ">
  		 	<input type="checkbox" id="play" >
            <input type="hidden" name="state" value="{{doc.state}}" id="state">
            <input type="hidden" name="isPlay" value="{{doc.isPlay}}" id="isPlay">
         </div>
 </div>
<div class="row line-magin" >
        <div class="col-lg-1  col-md-1 col-sm-1 col-xs-1 ">
            <label class="content-right">封面图片:</label>
        </div>

        <div class="col-lg-3  col-md-3 col-sm-6 col-xs-6 " style="height: 50px;">
			<img ng-src="{{doc.url}}" ng-mousemove="like($event)" ng-mouseout="likeout()" style="width: 60px;height: 40px;" id="headimg" onerror="javascript:this.src='resources/docImg/Picture.png'">
        	<span id="imgAlt" style="position: relative;top:10px;margin-left: 20px;color:red;">提示: 请上传比例为 480*320 的图片</span>
        </div>
                <div class="col-lg-2  col-md-2 col-sm-4 col-xs-4 ">
             <input type="file" name="headImg" id="imgLoad" >
            <label for="imgLoad" class="d-btn all-bg"  style="margin-top: 10px">添加封面</label>
          	<input type="hidden" name="headUrl" id="imgUrl" value="{{doc.url}}">
          	
        </div>
</div>    
 	<script id="editor" type="text/plain" name="content" style="height:500px;"></script>
 	<input type="hidden" name="passage" ng-model="doc.passage" id="passage">
    </form>
    <div style="margin-top: 10px;text-align: center;margin-bottom: 10px;">
    	<button class="d-btn all-bg" ng-click="back()">取消</button>&nbsp;&nbsp;
    	<button class="d-btn all-bg" ng-click="save()">保存</button>&nbsp;&nbsp;
    </div>
 	
       
</div>




 <script src="<%=path %>/resources/lib/jquery-1.11.3.min.js"></script>
 <script src="<%=path %>/resources/lib/alert.js"></script>
 <script src="<%=path %>/resources/js/util.js"></script>

 	<script src="<%=path %>/resources/lib/angular.min.js"></script>
	<script src="<%=path %>/resources/js/add.js"></script> 
  </body>
</html>
 --%>