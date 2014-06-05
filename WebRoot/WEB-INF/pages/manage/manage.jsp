<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%@taglib prefix="s" uri="/struts-tags"%>
<s:action name="manage_mbody" namespace="/pages" executeResult="true"></s:action>
    <div class="content">
    欢迎！admin
    <iframe src="${usidebar_uinquiryaccount}" name="mdetail" scrolling="auto" frameborder="0" width="100%" height="500px"></iframe>
    <!-- end .content --></div>
<s:action name="manage_mfooter" namespace="/pages" executeResult="true"></s:action>
  