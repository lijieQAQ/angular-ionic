<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=12;IE=11;IE=10;IE=9;IE=8;IE=7;IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>政企文化 | 管理系统</title>

    <!-- Bootstrap -->
    <link href="<%=path %>/resources/lib/bootstrap_v3.3.5/css/bootstrap.css" rel="stylesheet">
    <link href="<%=path %>/resources/css/login.css" rel="stylesheet">
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="//cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="//cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>


        <div class="login_box">
            <div class="login-box-n">
                <form   action="<%=path %>/admin/login.do" method="post" name="form">
                <div class="row">
                    <div class="col-lg-3 col-md-2 col-sm-1 col-xs-0">

                    </div>
                    <div class="col-lg-6 col-md-8 col-sm-10 col-xs-12">
                        <h3 class="login-title">政企文化登陆系统</h3>
                    </div>
                    <div class="col-lg-3 col-md-2 col-sm-1 col-xs-0 rh">

                    </div>
                </div>
                <div class="row">
                    <div class="col-lg-3 col-md-3 col-sm-2 col-xs-1">
                        <span class="glyphicon glyphicon-user icon" ></span>
                    </div>
                    <div class="col-lg-6 col-md-8 col-sm-9 col-xs-10">
                        <input type="text" class="input-lg d-input" name="username" id="uname">
                    </div>
                    <div class="col-lg-3 col-md-1 col-sm-1 col-xs-1 rh-3">

                    </div>
                </div>
                <div class="row">
                    <div class="col-lg-3 col-md-3 col-sm-2 col-xs-1">
                        <span class="glyphicon glyphicon-lock icon" ></span>
                    </div>
                    <div class="col-lg-6 col-md-8 col-sm-9 col-xs-10">
                        <input type="password" class="input-lg d-input" name="password" id="upwd" onblur="">
                    </div>
                    <div class="col-lg-3 col-md-1 col-sm-1 col-xs-1" style="height:60px">

                    </div>
                </div>
                 <div class="row">
                    <div class="col-lg-3" style="height:40px"> </div>
                    <div class="col-lg-8 " style="color:red" id="msg">
                    	${errorResult}
                    </div>
                </div>
                <div class="row">
                    <div class="col-lg-3">
                    </div>
                    <div class="col-lg-6" style="text-align: center;">
                        <button type="submit"  class="btn-success btn-lg btn-submit">登&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;陆</button>
                    </div>
                </div>
                </form>
            </div>
        </div>
<script src="<%=path %>/resources/lib/jquery-1.11.3.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="<%=path %>/resources/lib/bootstrap_v3.3.5/js/bootstrap.min.js"></script>
<script type="text/javascript">
	$(function(){
		$("#uname").blur(function(){
			if(this.value!=""){
				$("#msg").text("");
			}else{
				$("#msg").text("请输入用户名!");
			}
		});
		$("#upwd").blur(function(){
			if(this.value!=""){
				$("#msg").text("");
			}else{
				$("#msg").text("请输入密码!");
			}
		});
	
		$(".btn-submit").click(function(){
			var uname=$("#uname").val();
			if(uname==null ||uname=="" ){
				$("#msg").text("请输入用户名!");
				return false;
			}
			uname=$("#upwd").val();
			if(uname==null ||uname=="" ){
				$("#msg").text("请输入密码!");
				return false;
			}
			
				
		});
	
	
	})
</script>
</body>
</html>
