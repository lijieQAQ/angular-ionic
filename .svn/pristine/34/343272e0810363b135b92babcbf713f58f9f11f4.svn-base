/**
 * 公用的提示
 */ 

//window.onload = function(){
//	warn.init("你确定要输出吗？",true).confirmfn(function(){
//		alert('ajax操作后台');
//	}).cancelfn().closefn();
//	warn.init("保存成功").closefn(function(){
//		window.location.href="http://www.baidu.com";
//	})
//}

;(function($,undefined){
	var warn = {
			dialog : $("<div>").attr("id","qt_pupDialog").addClass("dra_dialog"),	
			title : $("<div>").css("color","#000").append($("<h3>").attr("style","margin:10px;").text("提示")),//提示
			msg : $("<div>").attr("id","qt_msg").css({"height":"auto","padding":"20px"}),//提示信息
			close : $("<div>").attr("id","qt_close").text("关闭").css({"float":"right","margin-right":"30px","margin-bottom":"10px"}).attr("class","d-btn all-bg"),//关闭
			shade : $("<div>").attr("data","share").attr("id","qt_shade").css({"width":"100%","height":"100%","background-color":"#000",
				"z-index":"1002","opacity":" 0.5","position":"absolute","top":"0px","left":"0px"}),
			bottom : $("<div>").attr("id","qt_bottom").css({"height":"45px","width":"100%","border-top": "1px solid RGBA(0,0,0,0.7)","padding-top": "5px"}),
			confirm : $("<div>").attr("id","qt_confirm").css({"float":"right","margin-right":"30px"}).text("确定").attr("class","d-btn all-bg"),
	        cancel : $("<div>").attr("id","qt_cancel").css({"float":"right","margin-right":"30px"}).text("取消").attr("class","d-btn all-bg"),
	        blueHr : $("<hr>").css("border","1px solid RGBA(0,0,0,0.7)"),
	        hr : $("<hr style='margin-top: 20px;margin-bottom: 10px;'>"),
			init:function(tipMsg,isConfirm){//自定义
				$("#qt_bottom").remove();
				$("#qt_close").remove();
				$("#qt_pupDialog").remove();
				$("#qt_shade").remove();
				this.msg.html(tipMsg);
				this.dialog.append(this.title).append(this.blueHr).append(this.msg).append(this.hr);
				if(isConfirm){//为真 (确定和取消)
					this.dialog.append(this.bottom.append(this.confirm).append(this.cancel));
				}else{
					this.dialog.append(this.close);
				}
				$(document.body).append(this.shade).append(this.dialog);
				$("#qt_pupDialog").css("display","");
				$("#qt_shade").css("display","");
				this.dialog.animate({"top":"15%"});
				this.closefn();
				return this;
			},
			closefn:function(fn){//提示关闭
				this.close.on("click",function(){
					warn.dialog.hide();
					warn.shade.hide();
					warn.dialog.css("top","0px");
					if(!fn){
					}else{
						fn();
					}
				});
				return this;
			},
			cancelfn:function(){//取消	
				this.cancel.on("click",function(){
					warn.dialog.hide();
					warn.shade.hide();
				});
				return this;
			},
			confirmfn:function(fn){//确定删除
				this.confirm.on("click",function(){
					fn();
				});
				return this;
			}
	};
	// 暴露接口
    window.warn = warn;
})($);


