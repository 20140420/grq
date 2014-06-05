<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<s:set var="context_path" value="#request.get('javax.servlet.forward.context_path')"></s:set>

<!doctype html>
<html>
<head>
<base href="<%=basePath%>">
<meta charset="utf-8" />
<title>主页</title>

</head>
<body>
<div class="container">
	<div class="header"><!--start .header --><%@ include file="header.jsp" %> <!--end .header --></div>
	<div class="content">

      <div class="index">
      		 
            <!-- <div class="content-welcome">
            	欢迎 Welcome!
            </div>-->
			<div class="content-welcome">
				<iframe border="0" id="content" src="index-pic.html" frameborder="0" height="100%" width="100%"></iframe>
			</div><!-- -->
			<div class="menu-control">
                <ul>
                <li><s:a action="shark_main" namespace="/shark" target="_blank">金鲨银鲨</s:a></li>
                <li><s:a action="snake_main" namespace="/snake" target="_blank">小蛇快逃</s:a></li>
                <li><s:a action="invest_main" namespace="/invest" target="_blank">投资理财</s:a></li>
                <li><s:a action="price_main" namespace="/price" target="_blank">实时价格</s:a></li>              
                <li><s:a action="prepare_main" namespace="/prepare" target="_blank">汽车强国</s:a></li>
              </ul>
            </div>       
      </div> <!-- index END -->
	</div>
    <!--<div class="sidebar1">
        侧边（选择）
	</div>-->   
</div>
<script>
// 你的代码
</script>
</body>
</html>

