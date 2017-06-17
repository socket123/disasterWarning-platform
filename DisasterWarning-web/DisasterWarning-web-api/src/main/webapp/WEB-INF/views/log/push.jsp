<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/commons/taglibs.jsp"%>
<%@ include file="/WEB-INF/views/commons/jquery.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>消息推送</title>

<style type="text/css">

body{text-align: center;}
.main{margin:0 auto;}
.int input,.int select,.int textarea{border: 1px solid #ccc;border-radius: 3px;float: right;width:84%;height: 30px;font-size: 16px;font-family:Microsoft YaHei;}
.int{width: 300px;height: 37px;border:none;overflow: hidden;margin: 0 auto;margin-top: 30px;}
.int4 input{width: 300px;height: 37px;border-radius: 3px;margin-top: 30px;border: none;background: #1C99F3;color: #fff;font-size: 16px;cursor:pointer;}
.int3,#content{height:100px;}

</style>

</head>
<body>
<div class="main">
	<div class="int"> 任务:<select  id="task">
				<option value="">全部</option>
				<c:forEach items="${tasks}" var="t">
				<option value="${t.taskName}">${t.taskName } </option>
				</c:forEach>
			</select>
	</div>
	<div class="int"> 标题:<input id="title" type="text"/></div>
	<div class="int int3">内容:<textarea id="content" type="text"> </textarea></div>

	<!-- <a  id="send" href="javascript:void(0)" >发送</a> -->
	<div class="int4"><input type="button" name="" id="send"  onclick="" value="发送" /></div>
</div>

<script type="text/javascript">
	
$(document).ready(function(){
	  
	$("#send").click(function(){
		
		var task = $("#task").val();
		var title = $("#title").val();
		var content = $("#content").val();
		
		$.ajax({
			url:"${ctx}/log/web/send",
			data:{
				taskName:task,
				logTitle:title,
				logContent:content
			},
			type:"POST",
			success:function(data){
				var obj=JSON.parse(data);
				if(obj.success){				
					alert("发送完成");
				}else{
					alert(obj.message);
				}
			}
		});
		
		/*  alert($("#title").val());*/
	 });
})
	

</script>

</body>
</html>