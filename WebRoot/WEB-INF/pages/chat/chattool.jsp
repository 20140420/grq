<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<s:set var="context_path"
	value="#request.get('javax.servlet.forward.context_path')"></s:set>
<!DOCTYPE html>
<link href="${context_path}/css/game.css" rel="stylesheet" type="text/css" />
<script type="application/javascript" src="${context_path}/js/chat.js"></script>
<div class="sidebar1">
	<ul class="nav">
      <li>
        <div class="minsales">
        <%@ include file="minsales.jsp"%>
        </div>
      </li>
      <li>
        <div class="profile">
        <%@ include file="profile.jsp"%>
        </div>
      </li>
      <li>
        <div class="online">
        <%@ include file="online.jsp"%>
        </div>
      </li>
      <li>
        <div class="chat">
        <%@ include file="chat.jsp"%>
        <!-- end .chat --></div>
      </li>
  </ul>
<!-- end .sidebar1 --></div>
