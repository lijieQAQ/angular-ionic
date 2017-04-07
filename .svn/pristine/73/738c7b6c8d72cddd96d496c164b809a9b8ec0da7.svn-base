angular.module("addApp",[]).controller("addCtorl",function($scope,$http){
		$scope.doc={id:null,"title":"","passage":"","state":"1","doctypeid":1,"reviewcount":0,"creatorname":"","url":"",content:"",isPlay:"1"};
		$scope.ue = UE.getEditor('editor');
		var docId=getParam("docId");
		if(docId!=""){
			$.ajax({url:"doc/operation.htm",method:"get",dataType:"json",data:{"cmd":"getOne","docId":docId},
					success:function(data){
						console.log(data);
						$scope.$apply(function(){
							$scope.doc=data.body.doc;
							if($scope.doc.isPlay==2){
								$("#play").attr("checked",true);
							}if($scope.doc.isReply==2){
								$("#reply").attr("checked",true);
							}else if($scope.doc.isReply==1){
								$("#reply").attr("checked",false);
							}if($scope.doc.isThumbsUp==2){
								$("#thumbsUp").attr("checked",true);
							}else if($scope.doc.isThumbsUp==1){
								$("#thumbsUp").attr("checked",false);
							}
							$("#docType").val($scope.doc.doctypeid);
							$scope.ue.addListener( 'ready', function( editor ) {
								$scope.ue.execCommand('inserthtml', $scope.doc.content);
					 			});
						});
								
			}});

		}
		$scope.types=[];
	    $scope.typesparams={"cmd":"getAll"};
	    $.getJSON("model/operation.htm",$scope.typesparams,function(data){
	    	
	    	if(data.state=="0"){
	        	$scope.$apply(function(){
	        		$scope.types=data.body;
	        		console.log($scope.types);
	        	});
	    	}

	    });
		
		$scope.back=function(){
			window.location.href="admin/menu.do?url=article";
		}
		
		function isSubmit(){
			
			if($scope.doc.title=="" || $scope.doc.title==null){
				warn.init("<p style='color:red;font-size:18px'>请输入标题 ！<p>");
				return false;
			}
			if($scope.doc.title.length>20){
				warn.init("<p style='color:red;font-size:18px'>标题不能大于20个汉字 ！<p>");
				return false;
			}
			if(!$scope.ue.hasContents()){
				warn.init("<p style='color:red;font-size:18px'>请输入文章内容 ！<p>");
				return false;
			}
			if(docId!=""){
				if($scope.doc.url=="" || $scope.doc.url==null){
					warn.init("<p style='color:red;font-size:18px'>请上传封面图片 ！<p>");
					return false;
				}
			}else{
				if($("#imgLoad").val()==""||$("#imgLoad").val()==null){
					warn.init("<p style='color:red;font-size:18px'>请上传封面图片 ！<p>");
					return false;
				}
			}
			return true;
		}
		
		$scope.save=function(){
			
			if(!isSubmit()){
				return;
			}
			
			if($("#play")[0].checked==true){
				$("#isPlay").val("2");
			}else{
				$("#isPlay").val("1");
			}
			if($("#reply")[0].checked==true){
				$("#isReply").val("2");
			}else{
				$("#isReply").val("1");
			}
			if($("#thumbsUp")[0].checked==true){
				$("#isThumbsUp").val("2");
			}else{
				$("#isThumbsUp").val("1");
			}
			if($scope.ue.getContentLength()<30){
				$("#passage").val($scope.ue.getContentTxt());
			}else{
				$("#passage").val($scope.ue.getContentTxt().substring(0,29));
			}
			$scope.ue.setContent(check($scope.ue.getContent()));
			$("#addFrom").submit();						
		}
		
		function check(str){
			var con=$("<div>"+str+"</div>");
			con.find("img").each(function(){
				$(this).css("max-width","100%");
				$(this).parent("p").attr("style","");
			});
			return con.html();
		}
		$("#imgLoad").change(function(){
			var me=$(this);
			var url=me.createUrl();
			$("#headimg").attr("src",url);
		});
	
		$scope.up=function(){
			if(!isSubmit()){
				return;
			}
			
			if($("#play")[0].checked==true){
				$("#isPlay").val("2");
			}else{
				$("#isPlay").val("0");
			}
			if($("#reply")[0].checked==true){
				$("#isReply").val("2");
			}else{
				$("#isReply").val("0");
			}if($("#thumbsUp")[0].checked==true){
				$("#isThumbsUp").val("2");
			}else{
				$("#isThumbsUp").val("0");
			}
			if($scope.ue.getContentLength()<30){
				$("#passage").val($scope.ue.getContentTxt());
			}else{
				$("#passage").val($scope.ue.getContentTxt().substring(0,29));
			}
			
			$("#addFrom").submit();	
		};
	    $scope.isLike=false;
		$scope.like=function(e){
			var me=$(e.target);
			var wz=getMousePos(e);
			var imgUrl=me.attr("src");
			if(imgUrl!="" && imgUrl!=null){
				 if(!$scope.isLike){
						var img=$("<img class=\"likeImg\" src=\""+imgUrl+"\">");
						var w=$(document.body).width();
						var wy=$(document.body).height();
						if(parseInt(w)-wz.x<300){
							wz.x=wz.x-300;
						}
						if(parseInt(wy)-wz.y<200){
							wz.y=wz.y-200;
						}					
						img.css({"left":wz.x+"px","top":wz.y+"px"});
						$(document.body).append(img);
						$scope.isLike=true;
				 } 
			}
		};
	$scope.likeout=function(){
		$scope.isLike=false;
		$(".likeImg").remove();
	};
			
});