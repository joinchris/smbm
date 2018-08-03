<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'billAdd.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" href="<%=basePath%>css/public.css"/>
    <link rel="stylesheet" href="<%=basePath%>css/style.css"/>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
<body>
<!--头部-->
<header class="publicHeader">
    <h1>超市账单管理系统</h1>

    <div class="publicHeaderR">
        <p><span>下午好！</span><span style="color: #fff21b"> Admin</span> , 欢迎你！</p>
        <a href="<%=basePath%>user/loginOut.com">退出</a>
    </div>
</header>
<!--时间-->
<section class="publicTime">
    <span id="time">2015年1月1日 11:11  星期一</span>
    <a href="#">温馨提示：为了能正常浏览，请使用高版本浏览器！（IE10+）</a>
</section>
<!--主体内容-->
<section class="publicMian ">
    <div class="left">
        <h2 class="leftH2"><span class="span1"></span>功能列表 <span></span></h2>
        <nav>
            <ul class="list">
                <li><a href="<%=basePath%>bill/selectList.com">账单管理</a></li>
	            <li id="active"><a href="<%=basePath%>provider/selectList.com">供应商管理</a></li>
	            <li><a href="<%=basePath%>user/selectList.com">用户管理</a></li>
	            <li><a href="<%=basePath%>public/password.com">密码修改</a></li>
	            <li><a href="<%=basePath%>user/loginOut.com">退出系统</a></li>
            </ul>
        </nav>
    </div>
    <div class="right">
        <div class="location">
            <strong>你现在所在的位置是:</strong>
            <span>供应商管理页面</span>
        </div>
        <div class="search">
            <span>供应商名称：</span>
            <input type="text" id="proName" placeholder="请输入供应商的名称"/>
            <input type="button" value="查询" onclick="selectLike();"/>
            <a href="<%=basePath%>provider/providerAddJsp.com">添加供应商</a>
        </div>
        <!--供应商操作表格-->
        <table class="providerTable" cellpadding="0" cellspacing="0">
            <tr class="firstTr">
                <th width="10%">供应商编码</th>
                <th width="20%">供应商名称</th>
                <th width="10%">联系人</th>
                <th width="10%">联系电话</th>
                <th width="10%">传真</th>
                <th width="10%">创建时间</th>
                <th width="30%">操作</th>
            </tr>
            <c:forEach items="${providerList }" var="provider" >
            	<tr>
	                <td>${provider.proCode }</td>
	                <td>${provider.proName }</td>
	                <td>${provider.proContact }</td>
	                <td>${provider.proPhone }</td>
	                <td>${provider.proFax }</td>
	                <td><fmt:formatDate value="${provider.creationDate }" pattern="yyyy-MM-dd"/></td>
	                <td>
	                    <a href="<%=basePath%>provider/viewJsp.com?id=${provider.id}"><img src="<%=basePath%>img/read.png" alt="查看" title="查看"/></a>
	                    <a href="<%=basePath%>provider/updateJsp.com?id=${provider.id}"><img src="<%=basePath%>img/xiugai.png" alt="修改" title="修改"/></a>
	                    <a pid="${provider.id}" class="removeProvider"><img src="<%=basePath%>img/schu.png" alt="删除" title="删除"/></a>
	                </td>
            	</tr>
            </c:forEach>
        </table>
    </div>
</section>

<!--点击删除按钮后弹出的页面-->
<div class="zhezhao"></div>
<div class="remove" id="removeProv">
   <div class="removerChid">
       <h2>提示</h2>
       <div class="removeMain" >
           <p>你确定要删除该供应商吗？</p>
           <a href="#" id="yes">确定</a>
           <a href="#" id="no">取消</a>
       </div>
   </div>
</div>


<footer class="footer">
    版权归北大青鸟
</footer>

<script src="<%=basePath%>js/jquery.js"></script>
<script src="<%=basePath%>js/provider.js"></script>
<script src="<%=basePath%>js/time.js"></script>

</body>
</html>