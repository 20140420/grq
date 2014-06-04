<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>

<link href="css/web.css" rel="stylesheet" type="text/css" />
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
        <li><a href="sales.jsp">活动</a></li>
        <li><a href="ranking.jsp">排名</a></li>
        <li><a href="investments.jsp">投资</a></li>
        <li><a href="index.jsp">主页</a></li>           
	</ul>
</div>