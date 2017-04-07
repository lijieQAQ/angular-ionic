var app=angular.module("d-app",[]);
app.directive("hasHeader",function(){
	return{
		 restrict: 'C',
		 link:function(scope, element, attrs){
			console.log(document.body.clientHeight);
			var h=parseInt(document.body.clientHeight)-60+"px";
			element.css({"height":h,"top":"60px"});
		 }
	}
});