<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<s:set var="context_path" value="#request.get('javax.servlet.forward.context_path')"></s:set>

<link href="${context_path}/css/web.css" rel="stylesheet" type="text/css" />
<div class="header-inner">
	<ul>
        <li>
        <div>
            <s:if test="#session.customer != null">
				[欢迎: <s:property value="#session.customer.username"/>]
				|[<s:a action="customer_logout" namespace="/customer">退出</s:a>]
			</s:if>
			<s:else>
				[<s:a action="customer_reg" namespace="/customer">注册</s:a>]
				|[<s:a action="customer_login" namespace="/customer">登入</s:a>]
			</s:else>
        </div>
        </li> 
        <li><s:a action="sale_main" namespace="/sale" target="_blank">活动</s:a></li>
        <li><s:a action="invest_ranking" namespace="/invest">排名</s:a></li>
        <li><s:a action="invest_main" namespace="/invest" target="_blank">投资</s:a></li>
        <li><s:a action="indexweb" namespace="/">主页</s:a></li>           
	</ul>
</div>