/**
 * Created by Administrator on 2016/3/29.
 */
function getParam(paramName)
{
    paramValue = "";
    isFound = false;
    if (this.location.search.indexOf("?") == 0 && this.location.search.indexOf("=")>1)
    {
        arrSource = unescape(this.location.search).substring(1,this.location.search.length).split("&");
        i = 0;
        while (i < arrSource.length && !isFound)
        {
            if (arrSource[i].indexOf("=") > 0)
            {
                if (arrSource[i].split("=")[0].toLowerCase()==paramName.toLowerCase())
                {
                    paramValue = arrSource[i].split("=")[1];
                    isFound = true;
                }
            }
            i++;
        }

    }
    return paramValue;
}

Date.prototype.Format = function(fmt)
{
    var o = {
        "M+" : this.getUTCMonth()+1,                 //月份
        "d+" : this.getUTCDate(),                    //日
        "h+" : this.getUTCHours()-6,                   //小时
        "m+" : this.getUTCMinutes(),                 //分
        "s+" : this.getUTCSeconds(),                 //秒
        "q+" : Math.floor((this.getUTCMonth()+3)/3), //季度
        "S"  : this.getUTCMilliseconds()             //毫秒
    };
    if(/(y+)/.test(fmt))
        fmt=fmt.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length));
    for(var k in o)
        if(new RegExp("("+ k +")").test(fmt))
            fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));
    return fmt;
};

function getMousePos(event) {
    var e = event || window.event;
    var scrollX = document.documentElement.scrollLeft || document.body.scrollLeft;
    var scrollY = document.documentElement.scrollTop || document.body.scrollTop;
    var x = e.pageX || e.clientX + scrollX;
    var y = e.pageY || e.clientY + scrollY;
    return { 'x': x, 'y': y };
}
$.fn.createUrl=function(){
	var $file = $(this);
	  var fileObj = $file[0];
	  var windowURL = window.URL || window.webkitURL;
	  var dataURL;   	    			   
	  if(fileObj && fileObj.files && fileObj.files[0]){
	  dataURL = windowURL.createObjectURL(fileObj.files[0]);
	  console.log(dataURL);
	  return dataURL;
	  }
}



