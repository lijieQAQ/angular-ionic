<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

    
<!DOCTYPE html>
<html lang="en">
<head>
    <base href="<%=basePath%>">
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>login</title>
	<link rel="stylesheet" href="static/css/bootstrap.min.css">
    <link rel="stylesheet" href="css/main.css">
    <script src="/culture/resources/lib/angular.min.js"></script>
    <script src="/culture/resources/lib/jquery-1.11.3.min.js"></script>
</head>
<body>
    <div class="home">
        <div class="row">
            <div class="col-md-4 col-md-offset-4">
                <div class="login-panel panel panel-default">
                    <div class="panel-body">
                        <form action="user/login" name="form" method="post">
                                <div class="form-group">
                                    <input class="form-control" placeholder="name" name="username" type="text" autofocus>
                                </div>
                                <div class="form-group">
                                    <input class="form-control" placeholder="Password" name="password" type="password" value="">
                                </div>
                                <div class="checkbox">
                                    <label>
                                        <input name="remember" type="checkbox" value="Remember Me">记住我
                                    </label>
                                </div>
                                <a href="javascript:;" class="btn btn-lg btn-info btn-block" id="login">登陆</a>
                                ${flag}
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
<script>
   $(function(){
	   $("#login").click(function(){
// 		   alert(document.forms[0].action)
// 		   document.forms[0].action = "<%=basePath%>user/login";
		   document.form.submit();
	   })
   })
</script>