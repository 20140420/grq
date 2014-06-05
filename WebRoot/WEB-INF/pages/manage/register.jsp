<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!doctype html>
<html>
<head>
<meta charset="utf-8" />
<title>注册页面</title>
<!--<link href="css/web.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="css_example_url" />
<script src="js_example_url"></script>-->
</head>
<body>
<div class="container">
	<div class="header"><%@ include file="/WEB-INF/pages/header.jsp"%></div><!-- end .header -->
	<div class="content">
        <div class="register">
        <form action="#" method="post">
            <table>
            	<tr>
                	<th colspan="3" align="center">用户注册</th>
                    <td class="col3"></td>
                </tr>
                <tr>
                  <td class="col1">昵称：</td>
                  <td colspan="2" class="col2"><input type="text"  placeholder="昵称"  name="nick" class="txt J_Item" data-null="请输入昵称" ></td>
                  <td class="col3"></td>
                </tr>
                <tr>
                  <td class="col1">邮箱：</td>
                  <td colspan="2" class="col2"><input type="text" data-type="email" name="email" data-null="请输入邮箱" data-msg="邮箱格式不正确" placeholder="example@gmail.com"></td>
                  <td class="col3">*</td>
                </tr>
    
                <tr>
                  <td class="col1">密码：</td>
                  <td colspan="2" class="col2"><input type="password"  placeholder="输入8-20位字母和数字的组合" name="pwd" data-null="请输入密码" id="J_Pwd" data-msg="请输入8-20位字母和数字的组合" class="txt J_Item"></td>
                  <td class="col3">*</td>
                </tr>
                <tr>
                  <td class="col1">确认密码：</td>
                  <td colspan="2" class="col2"><input type="password" placeholder="请再次输入密码确认" data-null="请确认密码" data-msg="两次密码不一致" data-equalto="#J_Pwd" class="txt J_Item"></td>
                  <td class="col3">*</td>
                </tr>
                <tr>
                  <td class="col1">手机:</td>
                  <td colspan="2" class="col2"><input type="text" placeholder="手机号用于密保" name="phone" data-null="请输入您的手机号码" data-msg="请输入正确的手机号码" class="txt J_Item"></td>
                  <td class="col3">&nbsp;</td>
                </tr>
                <tr>
                    <td class="col1">验证码：</td>
                  <td class="identification"><input type="text" placeholder="系统生成"></td>
                    <td align="center"><input type="submit" value="获取验证码"></td>
                    <td class="col3"></td>
				</tr>
                <tr>
                    <td colspan="3" align="center"><input type="submit" value="注册">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input name="重置" type="reset" value="重置"></td>
                    <td class="col3"></td>
                </tr>
            </table>	
        </form>
        </div> <!-- register END -->
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

