<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<s:set var="context_path" value="#request.get('javax.servlet.forward.context_path')"></s:set>

<link href="${context_path}/css/web.css" rel="stylesheet" type="text/css" />
<div class="header-inner">
	<ul>
        <li>
        <div>
			<%   if(2>1){//注意权限为游客时%>
            [<a href="register.jsp">注册</a>]|[<a href="login.jsp">登入</a>]
            <% } else { %>
            <span>欢迎光临:<i><% %></i>[<a href="control/front/#">注销</a>]</span>
            <%}%>
        </div>
        </li> 
        <li><s:a action="invest_sales" namespace="/invest" target="_blank">活动</s:a></li>
        <li><s:a action="invest_ranking" namespace="/invest" target="_blank">排名</s:a></li>
        <li><s:a action="invest_main" namespace="/invest" target="_blank">投资</s:a></li>
        <li><s:a action="indexweb" namespace="/" target="_blank">主页</s:a></li>           
	</ul>
</div>