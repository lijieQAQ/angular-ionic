<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html ng-app="doc" ng-controller="docCtorl">
  <head>
    <base href="<%=basePath%>">
    <meta http-equiv="X-UA-Compatible" content="IE=12;IE=11;IE=10;IE=9;IE=8;IE=7;IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>政企文化 | 管理系统</title>
    
       <!-- Bootstrap Core CSS -->
      <link href="resources/lib/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">

      <!-- MetisMenu CSS -->
      <link href="resources/lib/metisMenu/dist/metisMenu.min.css" rel="stylesheet">

      <!-- Timeline CSS -->
      <link href="resources/dist/css/timeline.css" rel="stylesheet">

      <!-- Custom CSS -->
      <link href="resources/dist/css/sb-admin-2.css" rel="stylesheet">

      <link href="resources/dist/css/DRA-ui.css" rel="stylesheet">
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="//cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="//cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
<body  >
<input id="path" type="hidden" value="<%=path%>">
<div class="container-fluid content">
<div class="row" style="margin-top: 5px;margin-bottom: 10px;">
	<div class="col-lg-5 col-md-5 col-sm-5 col-xs-5">
		<label style="display: inline-block;">模&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;块:</label>&nbsp;&nbsp;
		<select class="selectpicker btn btn-default"  id="types" ng-model="docsparams.docType">
		    <option value="0" >全部</option>
		    <option value="{{item.id}}" ng-bind="item.name" ng-repeat="item in types" ></option>
		</select>
	</div>
	<div class="col-lg-7 col-md-7 col-sm-7 col-xs-7">
		<label style="display: inline-block;float: left;line-height: 35px;color: inherit;">标&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;题:&nbsp;&nbsp;</label>
		<div class="input-group" style="float: left;width: 80%;">
			<input type="text" class="form-control"  ng-model="docsparams.search_title">
			<span class="input-group-addon" ng-click="search()">搜索</span>
		</div>
	</div>
</div>
<div class="row" style="margin-top: 5px;margin-bottom: 10px;">
	<div class="col-lg-5 col-md-5 col-sm-5 col-xs-5">
		<label style="display: inline-block;">状&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;态:</label>&nbsp;&nbsp;
		<select class="selectpicker btn btn-default"  id="states" ng-model="docsparams.state">
		    <option value="0" >全部</option>
		    <option value="1" >已下线</option>
		    <option value="2" >已上线</option>
		</select>
	</div>

	<div class="col-lg-5 col-md-5 col-sm-5 col-xs-5">
		<label style="display: inline-block;">是否轮播:</label>&nbsp;
		<select class="selectpicker btn btn-default"  id="isPlay" ng-model="docsparams.isPlay">
		    <option value="0" >全部</option>
		    <option value="2" >是</option>
		    <option value="1" >否</option>
		</select>
	</div>
	<div class="col-lg-2 col-md-2 col-sm-2 col-xs-2" ><button class="btn btn-outline btn-default" style="float: right;margin-right: 5px;" ng-click="addDoc()">新增</button></div>	
</div>
<table class="table table-striped table-bordered table-hover">
    <thead>
    <tr>
        <th>序号</th>
        <th>模块</th>
        <th>标题</th>
        <th>创建人</th>
        <th>评论数</th>
        <th>创建时间</th>
        <th>发布时间</th>
        <th>封面</th>
        <th>状态</th>
        <th>是否轮播</th>
        <th>能否评论</th>
        <th>是否点赞</th>
        <th>操作</th>
    </tr>
    </thead>
    <tbody>
    <tr ng-repeat="item in docs">
        <td >
        <span ng-bind="$index+1"></span>
        	<input type="hidden" value="item.id" class="docId"/>
        </td>
        <td ng-bind="item.doctypeid | D_model" class="doc-type"></td>
        <td ng-bind="item.title" class="doc-title"></td>
        <td ng-bind="item.creatorname" class="doc-crname"></td>
        <td ng-bind="item.reviewcount"></td>
        <td ng-bind="item.createTime | DRA_Date:'yyyy-MM-dd hh:mm:ss'" class="doc-time"></td>
        <td ng-bind="item.releaseTime | DRA_Date:'yyyy-MM-dd hh:mm:ss'" class="doc-time"></td>
        <td>
        	<img ng-src="{{item.url}}" ng-mousemove="like($event)" ng-mouseout="likeout()" onerror="javascript:this.src='resources/docImg/Picture.png'" style="max-height:1em;">
        </td>
        <td ng-bind="item.state | state"></td>
        <td ng-bind="item.isPlay | d_play"></td>
        <td ng-bind="item.isReply | d_Reply"></td>
        <td ng-bind="item.isThumbsUp | d_ThumbsUp"></td>
        <td>
                <button type="button" class="btn btn-link my-link" ng-click="likeDoc($index)" data-toggle="modal" data-target="#myModal">预览</button>
                <button type="button" class="btn btn-link my-link" ng-if="item.state==1" ng-click="updateDoc($index)">修改</button>
                <button type="button" class="btn btn-link my-link" ng-if="item.state==1" ng-click="upDoc($index)">上线</button>
                <button type="button" class="btn btn-link my-link" ng-if="item.state==2" ng-click="downDoc($index)">下线</button>
        </td>
    </tr>
    </tbody>
</table>
<ul class="pagination page-index">
  <li><a>上一页</a></li>
  <li class="active"><a>1</a></li>
  <li><a>下一页</a></li>
</ul>
<!-- 模态框（Modal） -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
   <div class="modal-dialog" style="overflow: hidden;">
      <div class="modal-content">
         <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                  &times;
            </button>
            <h4 class="modal-title" id="myModalLabel">政企文化 | 文章预览</h4>
         </div>
         <div class="modal-body" >
           		 <div class="doc-detail-box">
           		 	<span class="title" ng-bind="doc.title"></span>
           		 	<span class="passage" ng-bind="doc.passage" ></span>
           		 	<span class="time"ng-bind="doc.releaseTime | DRA_Date:'yyyy-MM-dd hh:mm:ss'"></span>
           		 	<span class="review" >评论数:{{doc.reviewcount}}</span>
           		 </div>
           		 <div class="docContent"  >
           		 	
           		 </div>
         </div>
      </div><!-- /.modal-content -->
	</div><!-- /.modal -->
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
     <script src="<%=path %>/resources/js/util.js"></script>
    <script src="resources/dist/js/angular.min.js"></script>
    <script src="resources/js/article.js"></script>
  </body>
</html>
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
<%-- 
    <!-- Bootstrap -->
    <link href="<%=path %>/resources/lib/bootstrap_v3.3.5/css/bootstrap.css" rel="stylesheet">
    <link href="<%=path %>/resources/css/model.css" rel="stylesheet">
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="//cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="//cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
<body  >
<input id="path" type="hidden" value="<%=path%>">
<div class="container-fluid content">
<div class="row">
	<div class="col-lg-2 col-md-3 col-sm-3 col-xs-3">
		<select class="selectpicker all-bg"  id="types" ng-model="docsparams.docType">
		    <option value="0" >全部</option>
		    <option value="{{item.id}}" ng-bind="item.name" ng-repeat="item in types" ></option>
		</select>
	</div>
	<div class="col-lg-6 col-md-2 col-sm-0 col-xs-0"></div>
	<div class="col-lg-2 col-md-3 col-sm-3 col-xs-3"><input type="text" class="d-input" ng-model="search_title"/></div>
	<div class="col-lg-1 col-md-2 col-sm-3 col-xs-3"><button class="d-btn all-bg" ng-click="search()">搜索</button></div>
	<div class="col-lg-1 col-md-2 col-sm-3 col-xs-3"><button class="d-btn all-bg" ng-click="addDoc()">新增</button></div>
</div>
<table class="table table-bordered d-tatle">
    <tr>
        <th>序号</th>
        <th>模块</th>
        <th>标题</th>
        <th>创建人</th>
        <th>评论数</th>
        <th>创建时间</th>
        <th>发布时间</th>
        <th>封面</th>
        <th>状态</th>
        <th>是否轮播</th>
        <th>操作</th>
    </tr>
    <tr ng-repeat="item in docs">
        <td >
        <span ng-bind="$index+1"></span>
        	<input type="hidden" value="item.id" class="docId"/>
        </td>
        <td ng-bind="item.doctypeid | D_model" class="doc-type"></td>
        <td ng-bind="item.title" class="doc-title"></td>
        <td ng-bind="item.creatorname" class="doc-crname"></td>
        <td ng-bind="item.reviewcount"></td>
        <td ng-bind="item.createTime | DRA_Date:'yyyy-MM-dd hh:mm:ss'" class="doc-time"></td>
        <td ng-bind="item.releaseTime | DRA_Date:'yyyy-MM-dd hh:mm:ss'" class="doc-time"></td>
        <td>
        	<img ng-src="{{item.url}}" ng-mousemove="like($event)" ng-mouseout="likeout()" onerror="javascript:this.src='resources/docImg/Picture.png'" style="width:60px;height:40px">
        </td>
        <td ng-bind="item.state | state"></td>
        <td ng-bind="item.isPlay | d_play"></td>
        <td>
                <button type="button" class="btn btn-link" ng-click="likeDoc($index)" data-toggle="modal" data-target="#myModal">预览</button>
                <button type="button" class="btn btn-link" ng-if="isUpdate(item)" ng-click="updateDoc($index)">修改</button>
                <button type="button" class="btn btn-link" ng-if="item.state==1" ng-click="upDoc($index)">上线</button>
                <button type="button" class="btn btn-link" ng-if="item.isPlay==1" ng-click="upPlayDoc($index)">上线</button>
                <button type="button" class="btn btn-link" ng-if="item.state==2" ng-click="downDoc($index)">下线</button>
                <button type="button" class="btn btn-link" ng-if="item.isPlay==2" ng-click="downPlayDoc($index)">下线</button>
        </td>
    </tr>
</table>
<ul class="pagination page-index">
  <li><a>上一页</a></li>
  <li class="active"><a>1</a></li>
  <li><a>下一页</a></li>
</ul>
</div>
<!-- 模态框（Modal） -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" 
   aria-labelledby="myModalLabel" aria-hidden="true">
   <div class="modal-dialog">
      <div class="modal-content">
         <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                  &times;
            </button>
            <h4 class="modal-title" id="myModalLabel">政企文化 | 文章预览</h4>
         </div>
         <div class="modal-body" >
           		 <div class="doc-detail-box">
           		 	<span class="title" ng-bind="doc.title"></span>
           		 	<span class="passage" ng-bind="doc.passage" ></span>
           		 	<span class="time"ng-bind="doc.releaseTime | DRA_Date:'yyyy-MM-dd hh:mm:ss'"></span>
           		 	<span class="review" >评论数:{{doc.reviewcount}}</span>
           		 </div>
           		 <div class="docContent"  >
           		 	
           		 </div>
         </div>
      </div><!-- /.modal-content -->
</div><!-- /.modal -->
<script src="<%=path %>/resources/lib/jquery-1.11.3.min.js"></script>
<script src="<%=path %>/resources/js/util.js"></script>
<script src="<%=path %>/resources/lib/bootstrap_v3.3.5/js/bootstrap.min.js"></script>
<script src="<%=path %>/resources/lib/angular.min.js"></script>
<script src="<%=path %>/resources/js/article.js"></script>
  </body>
</html>
 --%>