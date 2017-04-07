package com.culture.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.culture.model.Culture_article;
import com.culture.model.Culture_nice;
import com.culture.model.Culture_review;
import com.culture.model.User;
import com.culture.service.ArticleService;
import com.culture.service.DocTypeService;
import com.culture.service.NiceService;
import com.culture.service.ReviewService;
import com.culture.util.Message;


@Controller
public class AriticleCtorl {
	
	@Autowired
	private ArticleService docSV;
	@Autowired
	private DocTypeService docTypeSV;
	@Autowired
	private NiceService niceSV;
	
	@Autowired
	private ReviewService talkSV;
	
//	@RequestMapping(value="doc/operation.htm",method=RequestMethod.POST)
	@SuppressWarnings("unchecked")
	@RequestMapping(value="doc/operation.htm",method=RequestMethod.GET)  //文章模块的操作
	public void docOperation(HttpServletRequest request,HttpServletResponse response){
		JSONObject jo=null;
		String cmd=request.getParameter("cmd");
		System.out.println(cmd);
		try{
			 if("delete".equals(cmd)){
				String id=request.getParameter("docId");
				if(id==null || "".equals(id)){
					jo=Message.getParamMsg();
					return;
				}
				
				docSV.deleteById(Integer.valueOf(id));
				jo=Message.getSuccessMsg();
			}else if("getOne".equals(cmd)){
				String id=request.getParameter("docId");
				if(id==null || "".equals(id)){
					jo=Message.getParamMsg();
					return;
				}
				Culture_article doc=docSV.getDocById(Integer.valueOf(id));
				List<Culture_review> talks=talkSV.getByDocId(Integer.valueOf(id));
				JSONObject jbody=new JSONObject();
				if(talks!=null){
					jbody.put("review", new JSONArray(talks));
				}else{
					jbody.put("review", new JSONArray());
				}
				long nices=niceSV.getNiceCountByDocId(Integer.valueOf(id));
				jbody.put("doc",new JSONObject(doc));
				jbody.put("niceCount", nices);
				jo=Message.getSuccessMsg();
				jo.put("body", jbody);
			}
			else if("getreview".equals(cmd)){
				String id=request.getParameter("docId");
				if(id==null || "".equals(id)){
					jo=Message.getParamMsg();
					return;
				}
				Culture_article doc=docSV.getDocById(Integer.valueOf(id));
				List<Culture_review> talks=talkSV.getByDocId(Integer.valueOf(id));
				JSONObject jbody=new JSONObject();
				if(talks!=null){
					jbody.put("review", new JSONArray(talks));
				}else{
					jbody.put("review", new JSONArray());
				}
				jo=Message.getSuccessMsg();
				jo.put("body", jbody);
			}else if("getAppList".equals(cmd)){
				String[] params=new String[3];
				params[0]=request.getParameter("index");
				params[1]=request.getParameter("count");
				params[2]=request.getParameter("docType");
				if(isEmpty(params)){
					jo=Message.getParamMsg();
					return;
				}
				Map<String, Object> result=docSV.getOnlineForPage(Integer.valueOf(params[2]), Integer.valueOf(params[0]), Integer.valueOf(params[1]));
				JSONObject jpage=new JSONObject();
				jpage.put("pageIndex", result.get("pageIndex"));
				jpage.put("pageCount", result.get("pageCount"));
				jpage.put("allCount", result.get("allCount"));
				
				JSONObject jdocs=new JSONObject();
				if(result.get("list")!=null){
					jdocs.put("doclist",new JSONArray((List<Culture_article>)result.get("list")));
				}else{
					jdocs.put("doclist",new JSONArray());
				}
				List<Culture_article> shuffling=docSV.getShufflingList(Integer.valueOf(params[2]));
				if(shuffling!=null){
					jdocs.put("docPlay",new JSONArray(shuffling));
				}else{
					jdocs.put("docPlay",new JSONArray());
				}
				
				jo=Message.getSuccessMsg();
				jo.put("body",jdocs);
				jo.put("page", jpage);	
			}else if("getTypeList".equals(cmd)){
				String[] params=new String[3];
				params[0]=request.getParameter("index");
				params[1]=request.getParameter("count");
				params[2]=request.getParameter("docType");
				if(isEmpty(params)){
					jo=Message.getParamMsg();
					return;
				}
				Map<String, Object> result=docSV.getForPage(Integer.valueOf(params[2]), Integer.valueOf(params[0]), Integer.valueOf(params[1]));
				JSONObject jpage=new JSONObject();
				jpage.put("pageIndex", result.get("pageIndex"));
				jpage.put("pageCount", result.get("pageCount"));
				jpage.put("allCount", result.get("allCount"));
				
				JSONObject jdocs=new JSONObject();
				if(result.get("list")!=null){
					jdocs.put("doclist",new JSONArray((List<Culture_article>)result.get("list")));
				}else{
					jdocs.put("doclist",new JSONArray());
				}			
				jo=Message.getSuccessMsg("获取列表成功!");
				jo.put("body",jdocs);
				jo.put("page", jpage);					
			}else if("getTypeByTitle".equals(cmd)){
				String[] params=new String[3];
				params[0]=request.getParameter("index");
				params[1]=request.getParameter("count");
				params[2]=request.getParameter("docType");
				if(isEmpty(params)){
					jo=Message.getParamMsg();
					return;
				}
				String title=request.getParameter("title");
				Map<String, Object> result=docSV.getByTitleForPage(title,Integer.valueOf(params[2]), Integer.valueOf(params[0]), Integer.valueOf(params[1]));
				JSONObject jpage=new JSONObject();
				jpage.put("pageIndex", result.get("pageIndex"));
				jpage.put("pageCount", result.get("pageCount"));
				jpage.put("allCount", result.get("allCount"));
				
				JSONObject jdocs=new JSONObject();
				if(result.get("list")!=null){
					jdocs.put("doclist",new JSONArray((List<Culture_article>)result.get("list")));
				}else{
					jdocs.put("doclist",new JSONArray());
				}			
				jo=Message.getSuccessMsg("获取列表成功!");
				jo.put("body",jdocs);
				jo.put("page", jpage);
			}else if("getNiceByDocidAndUserid".equals(cmd)){
				String docid=request.getParameter("docId");
				String userid=request.getParameter("userid");
				if(docid==null||userid==null){
					return ;
				}
				boolean state=niceSV.getNiceByDocidAndUserid(docid,userid);
				jo=Message.getSuccessMsg();
				jo.put("state",new String().valueOf(state));
				
			}else if("clickNice".equals(cmd)){
				User user=(User) request.getSession().getAttribute("user");
				String[] params=new String[2];
				params[0]=request.getParameter("docId");
				params[1]=request.getParameter("userid");
				if(isEmpty(params)){
					jo=Message.getParamMsg();
					return;
				}
				Culture_nice nice=new Culture_nice();
				nice.setDocid(Integer.valueOf(params[0]));
				nice.setUid(Integer.valueOf(params[1]));
				nice.setUame(user.getUsername());
				String operation=request.getParameter("operation");
				if(operation.equals("add")){
					niceSV.addNice(nice);
					jo=Message.getSuccessMsg();
				}else if (operation.equals("delete")) {
					niceSV.deleteNice(nice);
					jo=Message.getSuccessMsg();
				}
			}else if("revicewDoc".equals(cmd)){  //评论文章
				SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
				User u=(User)request.getSession().getAttribute("user");
				String[] params=new String[3];
				params[0]=request.getParameter("docId");
				params[1]=request.getParameter("userid");
				params[2]=request.getParameter("msg");
				if(isEmpty(params)){
					jo=Message.getParamMsg();
					return;
				}
				String toid=request.getParameter("toid");
				String toname=request.getParameter("toname");
				Culture_review review=new Culture_review();
				review.setDocid(Integer.valueOf(params[0]));
				review.setTime(new Date());
				review.setUserid(Integer.valueOf(params[1]));
				review.setUname(u.getNickname());
				review.setNices("");
				Date date=new Date();
				review.setTime(dateFormat.parse(dateFormat.format(date)));
				if(toid!=null){
					review.setToid(Integer.valueOf(toid));
				}
				if(toname!=null){
					review.setToname(toname);
				}
				review.setMsg(params[2]);
				talkSV.addReview(review);
				Culture_article doc=docSV.getDocById(Integer.valueOf(params[0]));
				doc.setReviewcount(doc.getReviewcount()+1);
				docSV.updateDoc(doc);
				jo=Message.getSuccessMsg();
			}else if("revicew_nice".equals(cmd)){
				String[] params=new String[2];
				params[0]=request.getParameter("revicewId");
				params[1]=request.getParameter("userid");
				if(isEmpty(params)){
					jo=Message.getParamMsg();
					return;
				}
				Culture_review review=talkSV.getById(Integer.valueOf(params[0]));
				String nices=review.getNices();
				String unice="{"+params[1]+"}";
				if(nices.indexOf(unice)!=-1){
					nices=nices.replace(unice, "");
				}else{
					nices+=unice;
				}
				review.setNices(nices);
				talkSV.Reviewnices(review);
				jo=Message.getSuccessMsg();
				
			}else if("updateState".equals(cmd)){   //修改文章状态
				String[] params=new String[2];
				params[0]=request.getParameter("docId");
				params[1]=request.getParameter("state");
				if(isEmpty(params)){
					jo=Message.getParamMsg();
					return;
				}
				Culture_article doc=docSV.getDocById(Integer.valueOf(params[0]));
				doc.setState(params[1].charAt(0));
				doc.setReleaseTime(new Date());
				docSV.updateDoc(doc);
				jo=Message.getSuccessMsg();
				jo.put("body", new JSONObject(doc));
			}else if("searchDoc".equals(cmd)){   //修改文章状态
				String[] params=new String[5];
				params[0]=request.getParameter("docType");
				params[1]=request.getParameter("isPlay");
				params[2]=request.getParameter("state");
				params[3]=request.getParameter("index");
				params[4]=request.getParameter("count");
				if(isEmpty(params)){
					jo=Message.getParamMsg();
					return;
				}
				String title=request.getParameter("title");
				Map<String, Object> result=docSV.getByTitelOrStateOrTypeOrIsPlayForPage(Integer.valueOf(params[0]), params[2].trim().charAt(0), params[1].trim().charAt(0), title.trim(), Integer.valueOf(params[3]), Integer.valueOf(params[4]));
				JSONObject jpage=new JSONObject();
				jpage.put("pageIndex", result.get("pageIndex"));
				jpage.put("pageCount", result.get("pageCount"));
				jpage.put("allCount", result.get("allCount"));
				
				JSONObject jdocs=new JSONObject();
				if(result.get("list")!=null){
					jdocs.put("doclist",new JSONArray((List<Culture_article>)result.get("list")));
				}else{
					jdocs.put("doclist",new JSONArray());
				}			
				jo=Message.getSuccessMsg("获取列表成功!");
				jo.put("body",jdocs);
				jo.put("page", jpage);
			}else if("updatePlay".equals(cmd)){   //修改文章状态
				String[] params=new String[2];
				params[0]=request.getParameter("docId");
				params[1]=request.getParameter("isPlay");
				if(isEmpty(params)){
					jo=Message.getParamMsg();
					return;
				}
				Culture_article doc=docSV.getDocById(Integer.valueOf(params[0]));
				doc.setIsPlay(params[1].charAt(0));
				doc.setReleaseTime(new Date());
				docSV.updateDoc(doc);
				jo=Message.getSuccessMsg();
				jo.put("body", new JSONObject(doc));
			}else{
				jo=Message.getParamMsg("cmd 地址错误 \n cmd="+cmd);
			}
		} catch (Exception e){
			jo=Message.getErrorMsg();
			e.printStackTrace();
		}finally{
			try {
				byte[] jsonBytes = jo.toString().getBytes("utf-8");
				response.setContentType("text/json;charset=utf-8");
				response.setCharacterEncoding("UTF-8");
				response.setContentLength(jsonBytes.length);
				response.getOutputStream().write(jsonBytes);
				response.getOutputStream().flush();
				response.getOutputStream().close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
	}
	@RequestMapping(value="doc/addAndUpdate.do",method=RequestMethod.POST)
	public String addAndUpdateDoc(HttpServletRequest request){
		try{
			MultipartHttpServletRequest multipartRequest=(MultipartHttpServletRequest)request;
			Culture_article doc=new Culture_article();
			User u=(User)request.getSession().getAttribute("user");
			String docId=multipartRequest.getParameter("docId");
			boolean isAdd=true;
			if(docId!=null && !"".equals(docId)){
				isAdd=false;
				doc.setId(Integer.valueOf(docId));
			}else{
				doc.setCreateTime(new Date());
				doc.setCreatorname(u.getNickname());
				doc.setCreatorid(Integer.valueOf(u.getUserid()));
			}	
			String title=multipartRequest.getParameter("title");
			if(title!=null && !"".equals(title)){
				doc.setTitle(title);
			}
			String docType=multipartRequest.getParameter("docType");
			if(docType!=null && !"".equals(docType)){
				doc.setDoctypeid(Integer.valueOf(docType));
			}	
			String content=multipartRequest.getParameter("content");
			if(content!=null && !"".equals(content)){
				doc.setContent(content);
			}
			String passage=multipartRequest.getParameter("passage");
			if(passage!=null && !"".equals(passage)){
				doc.setPassage(passage);
			}
			String state=multipartRequest.getParameter("state");
			if(state!=null && !"".equals(state)){
				doc.setState(state.charAt(0));
				if(!"1".equals(state)){
					doc.setReleaseTime(new Date());
				}
			}
			String isPlay=multipartRequest.getParameter("isPlay");
			if(isPlay!=null && !"".equals(isPlay)){
				doc.setIsPlay(isPlay.charAt(0));
	
			}
			String isReply=multipartRequest.getParameter("isReply");
			if(isReply!=null && !"".equals(isReply)){
				doc.setIsReply(isReply.charAt(0));
	
			}
			String isThumbsUp=multipartRequest.getParameter("isThumbsUp");
			if(isThumbsUp!=null && !"".equals(isThumbsUp)){
				doc.setIsThumbsUp(isThumbsUp.charAt(0));
	
			}
			String headUrl=multipartRequest.getParameter("headUrl");
			if(headUrl!=null && !"".equals(headUrl)){
				doc.setUrl(headUrl);
			}
			MultipartFile file=multipartRequest.getFile("headImg");
			if(file.getSize()>0){
				String name=file.getOriginalFilename();
				String imgName=new Date().getTime()+name.substring(name.lastIndexOf("."));
				File img=new File(request.getRealPath("/")+"resources/docImg/"+imgName);
				FileOutputStream out=new FileOutputStream(img);
				byte[] bytes=new byte[1024];
				int leng=0;
				InputStream in=file.getInputStream();
				while ((leng=in.read(bytes))!=-1) {
					out.write(bytes, 0, leng);
				}
				out.flush();
				out.close();
				doc.setUrl("resources/docImg/"+imgName);
			}

			if(isAdd){
				docSV.addDoc(doc);
			}else{
				docSV.updateDoc(doc);
			}
		}catch(Exception e){
			e.printStackTrace();
			return "add";
		}
		return "article";
	}

	private boolean isEmpty(String[] strs){
		for (int i = 0; i < strs.length; i++) {
			if(strs[i]==null || "".equals(strs[i])){
				return true;
			}
		}
		return false;
		
	}
}
