<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>用户登录</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
<div class="container">
	<div class="header">
		<%@ include file="/WEB-INF/pages/header.jsp"%>
	</div><!-- end .header -->
	<div class="content">
	  <div class="login">	
        <form name="login" action="login" method="post">
            <table>
            	<tr>
                	<th colspan="3" align="center">用户登录</th>
                </tr>
                <tr>
                    <td class="col1">用户：</td>
                    <td class="col2" colspan="2"><input name="email" type="text" placeholder="用户ID或邮箱"></td>
              </tr>
                <tr>
                    <td class="col1">密码：</td>
                    <td class="identification"><input name="password" type="password" placeholder="由字母和数字组成"></td>
                    <td align="center"><input type="submit" value="忘记密码？"></td>
                </tr>
                <!-- 制作验证码防止恶心登入请求，提高安全性 -->
                <tr>
                    <td class="col1">验证码：</td>
                    <td class="identification"><input type="text" placeholder="从邮箱或手机"></td>
                    <td align="center"><input type="submit" value="获取验证码"></td>
				</tr>
                <tr>
                    <td colspan="3" align="center"><input type="submit" value="登录"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input name="重置" type="reset" value="重置"/></td>
                </tr>
          </table>
        </form>
		</div> 
        <!--<div id="sample">
         ...
        </div> <!-- #sample END -->
	</div>
    <!--<div class="sidebar1">
        侧边（选择）
	</div>-->   
  <div class="footer"><%@ include file="/WEB-INF/pages/footer.jsp"%><!-- end .footer --></div>
</div>
<script>
// 你的代码
</script>
  </body>
</html>
