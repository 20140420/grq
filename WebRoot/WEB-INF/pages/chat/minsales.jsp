<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%@taglib prefix="s" uri="/struts-tags"%>
<!-- chat的minsales页面 -->
<s:url action="chat_minsales" namespace="/chat" var="chat_minsales"></s:url>
<link href="${context_path}/css/game.css" rel="stylesheet" type="text/css" />

<script src="${context_path}/js/bbs.js"></script>
<div class="minsales">
  <div class="minsales-content">
  	<!-- 切换图片 270*84 -->
	<iframe border="0" id="content" src="${chat_minsales}" frameborder="0" height="100%" width="100%"></iframe>
  </div>
<!-- end .minsales --></div>