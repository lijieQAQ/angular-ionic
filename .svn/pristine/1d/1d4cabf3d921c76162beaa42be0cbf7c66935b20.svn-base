
angular.module("doc",[]).controller("docCtorl",function($scope,$http){
	var path=$("#path").val();
	//新增功能
	$scope.addDoc=function(){
		window.location.href=path+"/admin/menu.do?url=add";
	}
    $scope.docs=[];
    $scope.pageData={};
    $scope.types=[];
    $scope.maxPage=3;
    $scope.maxPageIndex=1;
    $scope.docsparams={index:1,count:10,"cmd":"getTypeList",docType:"0",state:"0",isPlay:"0",title:null};
    $scope.typesparams={"cmd":"getAll"};
    $.getJSON("model/operation.htm?v="+new Date().getTime(),$scope.typesparams,function(data){
    	if(data.state=="0"){
        	$scope.$apply(function(){
        		$scope.types=data.body;
        		localStorage.clear();
        		localStorage.setItem("types", JSON.stringify($scope.types));
        	    $.getJSON("doc/operation.htm?v="+new Date().getTime(),$scope.docsparams,function(data){
        	    	if(data.state=="0"){
        	        	$scope.$apply(function(){
        	        		$scope.docs=data.body.doclist;
        	        		$scope.pageData=data.page;
        	        		$scope.pageData.pages=getPageAllNum(data.page.allCount,data.page.pageCount);
        	        		createPage();
        	        		pageEvent();
        	        	});
        	    	}

        	    });
        	});
    	}
    	
    });
    function pageEvent(){
		$(".pageNum").click(function(){
			var me=$(this);
			$(".active").removeClass("active");
			me.addClass("active");
			$scope.docsparams.index=parseInt(me.text());
		    $.getJSON("doc/operation.htm?v="+new Date().getTime(),$scope.docsparams,function(data){
		    	if(data.state=="0"){
		        	$scope.$apply(function(){
		        		$scope.docs=data.body.doclist;
		        		});
		        	
		    	}
		    });
		});	
		
		$(".previ").click(function(){
			var me=$(".active");
			var nowMum=parseInt(me.text());
			var prev=me.prev();
			if(nowMum==1){
				return;
			}
			me.removeClass("active");
			$scope.docsparams.index=nowMum-1;
			
		    $.getJSON("doc/operation.htm?v="+new Date().getTime(),$scope.docsparams,function(data){
		    	if(data.state=="0"){
		        	$scope.$apply(function(){
		        		$scope.docs=data.body.doclist;
		        		});
		        	
		    	}
		    });
		    if(prev.text()=="..."){
		    	$scope.maxPageIndex-=1;
		    	createPage();
		    	pageEvent();
		    }else{
		    	prev.addClass("active");
		    }
			
		});
		
		$(".next").click(function(){
			
			var that=$(".active");
			var nowNum=parseInt(that.text());
			var next=that.next();
			if(nowNum==$scope.pageData.pages){
				return;
			}
			that.removeClass("active");
			$scope.docsparams.index=nowNum+1;
		    $.getJSON("doc/operation.htm?v="+new Date().getTime(),$scope.docsparams,function(data){
		    	if(data.state=="0"){
		        	$scope.$apply(function(){
		        		$scope.docs=data.body.doclist;
		        		});
		        	
		    	}
		    });
			if(next.text()=="..."){
				$scope.maxPageIndex+=1;
		    	createPage();
		    	pageEvent();
			}else{
		    	next.addClass("active");
		    }
			
		});
		
		
		
    }
    
    function createPage(){
		var pageLi="";
		var previ="<li class='previ'><a>上一页</a></li>";
		var next="<li class='next'><a>下一页</a></li>";
		var startNum=$scope.maxPage*($scope.maxPageIndex-1);
		var lastNum=$scope.pageData.pages-startNum;
		if(lastNum<=$scope.maxPage){
			if(startNum!=0){
				pageLi+="<li class=\"more\"><a>...</a></li>";
			}
    		for (var i = startNum; i < $scope.pageData.pages; i++) {
    			var c="";
    			if((i+1)==parseInt($scope.docsparams.index)){
    				c="active";
    			}
    			pageLi+="<li class=\"pageNum "+c+"\"><a>"+(i+1)+"</a></li>";
			}
		}else{
    		for (var i = 0; i < $scope.maxPage; i++) {
    			var c="";
    			if((i+1)==parseInt($scope.docsparams.index)){
    				c="active";
    			}
    			pageLi+="<li class=\"pageNum "+c+"\"><a>"+(startNum+i+1)+"</a></li>";
			}
    		pageLi+="<li class=\"more\"><a>...</a></li>";
		}
		$(".page-index").empty();
		$(".page-index").html(previ+pageLi+next); 
    }
    
    
    
    function getPageAllNum(all,count){
    	if(all%count==0){
    		return all/count;
    	}else{
    		return (all-(all%count))/count+1;
    	}
    }
    
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
    $scope.$watch("docsparams.docType",function(newData,oldData){
    	if(newData!=oldData){
    		var searchParams={cmd:"searchDoc",index:1};
    		searchParams=$.extend(searchParams,$scope.docsparams);
            $.getJSON("doc/operation.htm?v="+new Date().getTime(),searchParams,function(data){
                console.log(data);
                if(data.state=="0"){
                    $scope.$apply(function(){
                        $scope.docs=data.body.doclist;
                        $scope.pageData=data.page;
                        $scope.pageData.pages=getPageAllNum(data.page.allCount,data.page.pageCount);
    	        		createPage();
    	        		pageEvent();
                    });
                }

            });
    	}
    });
    $scope.$watch("docsparams.state",function(newData,oldData){
    	if(newData!=oldData){
    		var searchParams={cmd:"searchDoc",index:1};
    		searchParams=$.extend($scope.docsparams,searchParams);
    		$.getJSON("doc/operation.htm?v="+new Date().getTime(),searchParams,function(data){
    			console.log(data);
    			if(data.state=="0"){
    				$scope.$apply(function(){
    					$scope.docs=data.body.doclist;
    					$scope.pageData=data.page;
    					$scope.pageData.pages=getPageAllNum(data.page.allCount,data.page.pageCount);
    					createPage();
    					pageEvent();
    				});
    			}
    			
    		});
    	}
    });
    $scope.$watch("docsparams.isPlay",function(newData,oldData){
    	if(newData!=oldData){
    		var searchParams={cmd:"searchDoc",index:1};
    		searchParams=$.extend($scope.docsparams,searchParams);
    		$.getJSON("doc/operation.htm?v="+new Date().getTime(),searchParams,function(data){
    			console.log(data);
    			if(data.state=="0"){
    				$scope.$apply(function(){
    					$scope.docs=data.body.doclist;
    					$scope.pageData=data.page;
    					$scope.pageData.pages=getPageAllNum(data.page.allCount,data.page.pageCount);
    					createPage();
    					pageEvent();
    				});
    			}
    			
    		});
    	}
    });

    function searchByall(){
		$scope.searchParams={index:1,count:10,"cmd":"getTypeByTitle",docType:$("#types").val(),};
		$scope.docsparams.index=1;
	    $.getJSON("doc/operation.htm?v="+new Date().getTime(),$scope.searchParams,function(data){
	    	console.log(data);
	    	if(data.state=="0"){
	        	$scope.$apply(function(){
	        		$scope.docs=data.body.doclist;
	        		$scope.pageData=data.page;
                    $scope.pageData.pages=getPageAllNum(data.page.allCount,data.page.pageCount);
	        		createPage();
	        		pageEvent();
	        	});
	    	}
	    });	
    }
    
    //搜索功能
	$scope.search=function(){
		$scope.searchParams={index:1,count:10,"cmd":"getTypeByTitle",docType:$("#types").val(),title:$scope.docsparams.search_title};
		$scope.docsparams.index=1;
	    $.getJSON("doc/operation.htm?v="+new Date().getTime(),$scope.searchParams,function(data){
	    	console.log(data);
	    	if(data.state=="0"){
	        	$scope.$apply(function(){
	        		$scope.docs=data.body.doclist;
	        		$scope.pageData=data.page;
                    $scope.pageData.pages=getPageAllNum(data.page.allCount,data.page.pageCount);
	        		createPage();
	        		pageEvent();
	        	});
	    	}
	    });		
		
	}
	
	$('#myModal').on('hide.bs.modal', function () {
		$(".docContent").html("");
	})
	
	//预览
	$scope.likeDoc=function(index){
		var doc=$scope.docs[index];
		$.ajax({url:"doc/operation.htm?v="+new Date().getTime(),method:"get",dataType:"json",data:{"cmd":"getOne","docId":doc.id},
			success:function(data){
				$scope.$apply(function(){
					$scope.doc=data.body.doc;
					$(".docContent").html($scope.doc.content);
				});
						
		}});

		
	}
	// 修改
	$scope.updateDoc=function(index){
		var doc=$scope.docs[index];
		window.location.href="/culture/admin/menu.do?url=add&docId="+doc.id;
	}	
	//上线
	$scope.upDoc=function(index){
		var doc=$scope.docs[index];
		$scope.StateManage(doc, 2,index);	
	}
	
	// 下线
	$scope.downDoc=function(index){
		var doc=$scope.docs[index];
		$scope.StateManage(doc, 1,index);
	}	
	//轮播
	$scope.upPlayDoc=function(index){
		var doc=$scope.docs[index];
		$scope.playManage(doc, 2,index);
	}
	//轮播下线
	$scope.downPlayDoc=function(index){
		var doc=$scope.docs[index];
		$scope.playManage(doc, 1,index);
	}	
	// 删除
	$scope.deleteDoc=function(index){
		var doc=$scope.docs[index];
		$scope.StateManage(doc, 0,index);
	}	
	$scope.playManage = function(doc, state,index){
		$scope.upDocParams={"cmd":"updatePlay", "docId":doc.id, "isPlay":state};
	    $.getJSON("doc/operation.htm?v="+new Date().getTime(),$scope.upDocParams,function(data){
	    	
	    	if(data.state==0){
		    	 $scope.$apply(function(){
		    		 $scope.docs[index]=data.body;
	             });	
	    	}
	    });	
	}
	
	$scope.StateManage = function(doc, state,index){
		$scope.upDocParams={"cmd":"updateState", "docId":doc.id, "state":state};
	    $.getJSON("doc/operation.htm?v="+new Date().getTime(),$scope.upDocParams,function(data){
	    	
	    	if(data.state==0){
		    	 $scope.$apply(function(){
		    		 $scope.docs[index]=data.body;
	             });	
	    	}
	    });	
	}
    
	$scope.isUpdate=function(item){
		if(item.state==1 || item.isPlay==1){
			return true;
		}
		return false;
	}
	

}).filter("DRA_Date",function(){
    return function(ins,out){
        var data = "";
        if(ins!='' && ins!=null){
            data=new Date(ins).Format(out);
        }
        return data;
    };
}).filter("state",function(){
    return function(ins,out){
    	if(ins=="1"){
    		return "已下线";
    	}
    	if(ins=="2"){
    		return "已上线";
    	}
    	return "已下线";
    };
}).filter("d_play",function(){
    return function(ins,out){
    	if(ins=="1"){
    		return "否";
    	}
    	if(ins=="2"){
    		return "是";
    	}
    	return "否";
    };
}).filter("d_Reply",function(){
    return function(ins,out){
    	if(ins=="1"){
    		return "否";
    	}
    	if(ins=="2"){
    		return "是";
    	}
    	return "否";
    };
}).filter("d_ThumbsUp",function(){
    return function(ins,out){
    	if(ins=="1"){
    		return "否";
    	}
    	if(ins=="2"){
    		return "是";
    	}
    	return "否";
    };
}).filter("D_model",function(){
    return function(ins,out){
    	var types=localStorage.getItem("types");
    	if(types && types!=null && types!="[]"){
    		types=JSON.parse(types);
    		for (var i = 0; i < types.length; i++) {
				if(ins==types[i].id){
					return types[i].name;
				}
			}
    	}
    	return "";
    };
});
