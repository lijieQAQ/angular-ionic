angular.module('starter.controllers', [])
.controller('indexController',['$scope','$stateParams','$http','$rootScope','$location','$window','$state',function($scope, $stateParams,$http,$rootScope,$location,$window,$state){
	var query=window.location.search;
	var username=query.split("username=")[1];
	$http({
        url:'/culture/admin/login.htm',
        method:'post',
        params:{username:username}
    }).success(function(data) {//响应成功
    	$window.sessionStorage["userid"]=data.userid;
    	$window.sessionStorage["nickname"]=data.nickname;
    	$state.go("tab.newsList");
    });
}])
.controller('newsListCtrl', function($scope) {})
.controller('DetailCtrl',['$scope','$stateParams','$http','$rootScope','$sce','$window','$state','$ionicPopover','$ionicPopup',function($scope, $stateParams,$http,$rootScope,$sce,$window,$state,$ionicPopover,$ionicPopup) {
	$scope.username=$window.sessionStorage["nickname"];
	$scope.nice=[];
	$scope.niceState=[];
	$scope.nicecount=null;
	$scope.thumbUpStyle={
			"-webkit-text-stroke":"1px rgba(214,214,214,1)","color":"rgba(214,214,214,1)","font-size": "30px",
	};
	//获取内容
	$http({
        url:'/culture/doc/operation.htm',
        method:'get',
        params:{cmd:'getOne',docId:$stateParams.id}
    }).success(function(data) {//响应成功
	   	 console.log(data.body.doc);
	   	 console.log(data.body.review);
	   	 $scope.doc=data.body.doc;
	   	$scope.nicecount=data.body.niceCount;
	   	 $scope.docContent=$sce.trustAsHtml(data.body.doc.content);
	   	 var review=data.body.review;
	   	 $scope.reviewCount=data.body.review.length;
	   	if(review!=null&&review.length>0){
	   		for(var i=0;i<review.length;i++){
	   			review[i].time=new Date(review[i].time).Format("yyyy-MM-dd hh:mm:ss");
	   			if(review[i].nices!=null&&review[i].nices.length>0){
	   				$scope.nice.push((review[i].nices.split('}')).length-1);
	   				if(review[i].nices.indexOf($window.sessionStorage["userid"])>0){
	   					$scope.niceState.push(true);
	   				}else{
	   					$scope.niceState.push(false);
	   				}
		   		}else{
		   			$scope.nice.push(0);
		   			$scope.niceState.push(false);
		   		}
	   		}
	   	 }
	   	 $scope.reviews=review;
    });
	//获取该用户对该文章的点赞状态
	$http({
        url:'/culture/doc/operation.htm',
        method:'get',
        params:{cmd:'getNiceByDocidAndUserid',docId:$stateParams.id,userid:$window.sessionStorage["userid"]}
    }).success(function(data) {//响应成功
	   	 if(data.state=="true"){
	   		$("#thumbUp").removeAttr("style");
	   		$scope.thumbUpStyle={
	   				"font-size":"30px","color":"#387EF5",
        	};
	   	 }
    });
	//点赞事件 根据路径对点赞进行点赞和取消点赞事件
    $scope.thumbUp= function(id){
    	if(JSON.stringify($scope.thumbUpStyle).indexOf("webkit")>0){
    		$http({
                url:'/culture/doc/operation.htm',
                method:'get',
                params:{cmd:'clickNice',docId:id,userid:$window.sessionStorage["userid"],operation:"add"}
            }).success(function(data) {//响应成功
            	$scope.nicecount=$scope.nicecount+1;
            	$("#thumbUp").removeAttr("style");
            	$scope.thumbUpStyle={
            			"font-size":"30px","color":"#387EF5",
            	};
            	/* $state.go("tab.detail",{
                     id: id
             });*/
            });
    	}else{
    		$http({
                url:'/culture/doc/operation.htm',
                method:'get',
                params:{cmd:'clickNice',docId:id,userid:$window.sessionStorage["userid"],operation:"delete"}
            }).success(function(data) {//响应成功
            	$scope.nicecount=$scope.nicecount-1;
            		$("#thumbUp").removeAttr("style");
                	$scope.thumbUpStyle={
                			"-webkit-text-stroke":"1px rgba(214,214,214,1)","color":"rgba(214,214,214,1)","font-size": "30px",
                	};
            });
    	}
    };
    //回复
    $scope.reply= function(id){
    	var replyContent=document.getElementById("replyid"+id).value;
    	if(replyContent==""||replyContent==null){
                 var alertPopup = $ionicPopup.alert({
                   title: '警告',
                   template: '回复不能为空！'
                 });
                 alertPopup.then(function(res) {
                   console.log('Thank you for not eating my delicious ice cream cone');
                 });
    	}
    	$http({
            url:'/culture/doc/operation.htm',
            method:'get',
            params:{cmd:'revicewDoc',docId:id,userid:$window.sessionStorage["userid"],msg:replyContent}
        }).success(function(data) {//响应成功
        	document.getElementById("replyid"+id).value="";
        	$http({
                url:'/culture/doc/operation.htm',
                method:'get',
                params:{cmd:'getreview',docId:id}
            }).success(function(data) {//响应成功
            	$scope.nice=[];
	   			$scope.niceState=[];
        	   	 var review=data.body.review;
        	   	 $scope.reviewCount=data.body.review.length;
        	   	if(review!=null&&review.length>0){
        	   		for(var i=0;i<review.length;i++){
        	   			review[i].time=new Date(review[i].time).Format("yyyy-MM-dd hh:mm:ss");
        	   			if(review[i].nices!=null&&review[i].nices.length>0){
        	   				$scope.nice.push((review[i].nices.split('}')).length-1);
        	   				if(review[i].nices.indexOf($window.sessionStorage["userid"])>0){
        	   					$scope.niceState.push(true);
        	   				}else{
        	   					$scope.niceState.push(false);
        	   				}
        		   		}else{
        		   			$scope.nice.push(0);
        		   			$scope.niceState.push(false);
        		   		}
        	   		}
        	   	 }
        	   	 $scope.reviews=review;
            });
       });
    };
    //打开回复
    $scope.showPopup = function(id,toname,toid) {
        $scope.data = {}
    var myPopup = $ionicPopup.show({
        template: '<input id="popup" type="text">',
        title: '请输出回复内容',
        scope: $scope,
        buttons: [
          { text: '取消' },
          {
            text: '<b>回复</b>',
            type: 'button-positive',
            onTap: function(e) {
            	if($("#popup").val()==""||$("#popup").val()==null){
            		var alertPopup = $ionicPopup.alert({
                        title: '警告',
                        template: '回复不能为空！'
                      });
                      alertPopup.then(function(res) {
                        console.log('Thank you for not eating my delicious ice cream cone');
                      });
            	}
            	$http({
                    url:'/culture/doc/operation.htm',
                    method:'get',
                    params:{cmd:'revicewDoc',docId:id,userid:$window.sessionStorage["userid"],msg:$("#popup").val(),toname:toname,toid:toid}
                }).success(function(data) {//响应成功
                	$http({
                        url:'/culture/doc/operation.htm',
                        method:'get',
                        params:{cmd:'getreview',docId:id}
                    }).success(function(data) {//响应成功
                    	$scope.nice=[];
                    	$scope.niceState=[];
                	   	 var review=data.body.review;
                	   	 $scope.reviewCount=data.body.review.length;
                	   	 if(review!=null&&review.length>0){
                	   		for(var i=0;i<review.length;i++){
                	   			review[i].time=new Date(review[i].time).Format("yyyy-MM-dd hh:mm:ss");
                	   			if(review[i].nices!=null&&review[i].nices.length>0){
                	   				$scope.nice.push((review[i].nices.split('}')).length-1);
                	   				if(review[i].nices.indexOf($window.sessionStorage["userid"])>0){
                	   					$scope.niceState.push(true);
                	   				}else{
                	   					$scope.niceState.push(false);
                	   				}
                		   		}else{
                		   			$scope.nice.push((review[i].nices.split('}')).length-1);
            	   					$scope.niceState.push(false);
            	   				}
                	   		}
                	   	 }
                	   	 $scope.reviews=review;
                    });
               });
            }
          },
        ]
      });
    };
    $scope.nices=function(id,index){
    	$http({
            url:'/culture/doc/operation.htm',
            method:'get',
            params:{cmd:'revicew_nice',revicewId:id,userid:$window.sessionStorage["userid"]}
        }).success(function(data) {
        	if($scope.niceState[index]==true){
        		$scope.nice[index]-=1;
        	}else{
        		$scope.nice[index]+=1;
        	}
        	$scope.niceState[index]=!$scope.niceState[index];
        });
    };
    $scope.doRefresh = function() {
    	$scope.today = new Date();
	 // 停止广播ion-refresher
		 $scope.$broadcast('scroll.refreshComplete');
	  };
}]).controller('personDeptCtrl',['$scope','$location','$state','$http','$ionicScrollDelegate','$ionicSlideBoxDelegate','$rootScope','$timeout',
        function($scope,$location,$state,$http,$ionicScrollDelegate,$ionicSlideBoxDelegate,$rootScope,$timeout){
	 		$scope.moduleList=null;
	 		$scope.docPlay=[];
	 		$scope.doclist=[];
	 		var hasmore = false;
	 		var count=12;
	 		var index=1;
			 $http({
                 url:'/culture/model/operation.htm',
                 method:'POST',
                 params:{cmd:'getAll'}
             }).success(function(data) {//响应成功
            	 $scope.moduleList=data.body;
            	 console.log($scope.moduleList);
             })
             $http({
                 url:'/culture/doc/operation.htm',
                 method:'get',
                 params:{cmd:'getAppList',index:index,count:count,docType:'1'}
             }).success(function(data) {//响应成功
            	 index++;
            	 $scope.docPlay=[];
            	 $scope.docPlay=data.body.docPlay;
            	 var list=data.body.doclist;
            	 hasmore=list.length>count-1;
            	 $scope.doclist=[];
            	 for(var i=0;i<list.length;i++){
            		 if(list[i].title.length>25){
            			 list[i].title=list[i].title.substring(0,20)+"...";
            		 }
	            	 $scope.doclist.push(list[i]);
            	 }
            	 $scope.$broadcast('scroll.infiniteScrollComplete');
            	 $ionicSlideBoxDelegate.update();
            	 $("#1").attr("style","font-size:16px;color:#387EF5");
            	 /*$ionicSlideBoxDelegate.slide($scope.docPlay.length- 1, 1);*/
             	});
			  //上拉刷新
			 $scope.doRefresh = function() {
				 $scope.today = new Date();
				 index=1;
			 // 停止广播ion-refresher
				 $scope.$broadcast('scroll.refreshComplete');
			  };  
			  //更多
			  $scope.loadMore = function() {
				  if(!hasmore){
					  return;
				  }
				 $http({
	                 url:'/culture/doc/operation.htm',
	                 method:'get',
	                 params:{cmd:'getAppList',index:index,count:count,docType:'1'}
	             }).success(function(data) {//响应成功
	            	 index++;
	            	 var list=data.body.doclist;
	            	 hasmore=list.length>count-1;
	            	 for(var i=0;i<list.length;i++){
		            	 $scope.doclist.push(list[i]);
		            	 }
	            	 $scope.$broadcast('scroll.infiniteScrollComplete');
	             	});
			 }
//			  $scope.moreDataCanBeLoaded = function(){
//				  return hasmore;
//			  }

            $scope.todetail=function(id){
                $state.go("tab.detail",{
                    id: id
            });
			};
			//模块切换
			$scope.changeModule=function(id){
				$("label").attr("style","");
				$("#"+id+"").attr("style","font-size:16px;color:#387EF5");
				$ionicScrollDelegate.scrollTop(false);
				$scope.docPlay=[];
				index=1;
				 $http({
	                 url:'/culture/doc/operation.htm',
	                 method:'get',
	                 params:{cmd:'getAppList',index:index,count:count,docType:id}
	             }).success(function(data) {//响应成功
	            	 index++;
        			 $scope.docPlay=data.body.docPlay;
	            	 var list=data.body.doclist;
	            	 hasmore=list.length>count-1;
	            	 $scope.doclist=[];
	            	 for(var i=0;i<list.length;i++){
		            	 $scope.doclist.push(list[i]);
	            	 }
	            	 $ionicSlideBoxDelegate.update();
             	});  
				 
	        }
           
            $scope.model = {
                activeIndex:0
            };

//此事件对应的是pager-click属性，当显示图片是有对应数量的小圆点，这是小圆点的点击事件
           $scope.pageClick = function(index){
                $scope.model.activeIndex = 2;
            };

//当图片切换后，触发此事件，注意参数
       	/* $ionicSlideBoxDelegate.update();*/
        }]);
