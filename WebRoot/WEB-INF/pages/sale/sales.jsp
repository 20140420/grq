<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!doctype html>
<html>
<head>
    <base href="<%=basePath%>">
    
    <title>活动大优惠</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
</head>
<body>
	<%@ include file="/WEB-INF/pages/sale/head.jsp"%>
	<div id="box">
		<div id="left">
			<div id="left_s01">
				<s:a action="customer_login" namespace="/customer">
					<img src="${context_path}/imgweb/sale/index_23.gif" class="imgx5" />
				</s:a>
				<s:a action="customer_reg" namespace="/customer">
					<img src="${context_path}/imgweb/sale/index_26.gif" class="imgx5" />
				</s:a>
					<img src="${context_path}/imgweb/sale/index_27.gif" />
			</div>
			<div id="left_s02">
				<img src="${context_path}/imgweb/sale/index_25.gif" width="489" height="245"	class="imgz5" />
			</div>
			<!-- 类别 -->
			<s:iterator value="categories">
			<div id="left_x">
			<div id="left122">
			<table style="float: left;height: auto;width: 678px; vertical-align: middle; ">
			    <tr>   
			       <td class="word14" style="width: 22px; padding-left: 10px;">
			           <s:property value="name"/>
			       </td>
			        <td style="padding-bottom: 3px;"> 
						<div id="left122_y">
						<!-- 二级 -->
						<s:if test="!children.isEmpty">
							<s:iterator value="children">
								<div style="white-space:nowrap; width: 28%;float: left; margin-top: 5px; margin-bottom: 5px; margin-left: 26px;">
								<b style="color: #990000;"><s:property value="name" escape="false"/></b>　
									<!-- 三级 -->
									<s:if test="!children.isEmpty">
										<span>
											<s:iterator value="children">
												<s:a action="product_getByCategoryId" namespace="/sale">
													<s:param name="category.id" value="id"></s:param>
													<s:property value="name" escape="false"/>
												</s:a>
											</s:iterator>
										</span>
									</s:if>
								</div>
							</s:iterator>
						</s:if>
						</div>
			       </td>
			    </tr>
			</table>
			</div>
			</div>
			</s:iterator>
		</div>
		<%@ include file="/WEB-INF/pages/sale/right.jsp"%>
		<div id="foot"></div>
	</div>
</body>
</html>

