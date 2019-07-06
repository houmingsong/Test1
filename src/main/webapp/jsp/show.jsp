<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!-- 在所有的链接前面加上动态获取的绝对全路径 -->
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>展示用户</title>
<script src="jquery/jquery-2.1.4.js"></script>
<script type="text/javascript">
$(function(){
	var currentPage = 1;
	$.getJSON("show.lovo",{currentPage:currentPage},fillData);
	
	$("input[type=button]").click(function(){
		 var operation = this.value;
		 currentPage = parseInt($("input[name=currentPage]").val());
		 var totalPage = $("input[name=totalPage]").val();
		 if(operation == "生产Excel表格"){
			 window.location.href='poi.lovo';
		 }
	 	 if (operation == "|<") {
			
			 currentPage = 1;
		 } else if(operation == "<"){
			
			 currentPage = currentPage - 1;
		 } else if(operation == ">"){
			
			 currentPage = currentPage + 1;
		 } else {//尾页

			 currentPage = totalPage;
		 }
		 $.getJSON("show.lovo",{currentPage:currentPage},fillData);
	});
});
function fillData(data){
	var $table = $("table");
	$table.empty();
	var head = "<tr><th>ID</th><th>用户名</th><th>密码</th></tr>";
	$table.append(head);
	$.each(data.list, function(i,e){
		
		var tr = "<tr><td>" + e.id+ "</td><td>" + e.username+ "</td><td>" +e.password + "</td></tr>";
		$table.append(tr);
	});
	
	$("input[name=currentPage]").val(data.currentPage);
	$("input[name=totalPage]").val(data.totalPage);
	$("span").html(data.currentPage + "/" + data.totalPage);
}	
</script>
</head>
<body>
<div>
	<table>
	
	</table>
</div>
<div>
	<input type="button" name="operator" value="|<"/>
    <input type="button" name="operator" value="<"/>
    <span> </span>
    <input type="button" name="operator" value=">"/>
    <input type="button" name="operator" value=">|"/>
    <input type="hidden" name="currentPage">
	<input type="hidden" name="totalPage">
	<input type="button" value="生产Excel表格" name="operator">
</div>
</body>
</html>