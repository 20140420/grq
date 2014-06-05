<!-------------------------------
*  COPYRIGHT(C) 2013 杭州伯才团队
*   ALL RIGHTS RESERVED
*
* [FILE]      
*     msidebar.jsp
*
* [DESCRIPTION]   
*     本页是管理员后台侧栏
*
* [NOTE]
*     
*
* [VERSION]
*    v1.00  2013/11/27 姜泉  首版制作    
* --------------------------------->
<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<s:url action="msidebar_webserver" namespace="/pages"	var="msidebar_webserver"></s:url>
<s:url action="msidebar_webdatabase" namespace="/pages"	var="msidebar_webdatabase"></s:url>
<s:url action="msidebar_webotherinformation" namespace="/pages"	var="msidebar_webotherinformation"></s:url>
<s:url action="msidebar_adminuser" namespace="/pages"	var="msidebar_adminuser"></s:url>
<s:url action="msidebar_playeruser" namespace="/pages"	var="msidebar_playeruser"></s:url>
<s:url action="msidebar_assetgiro" namespace="/pages"	var="msidebar_assetgiro"></s:url>
<s:url action="msidebar_assetsilver" namespace="/pages"	var="msidebar_assetsilver"></s:url>
<s:url action="msidebar_assetinvest" namespace="/pages"	var="msidebar_assetinvest"></s:url>
<s:url action="msidebar_operatesales" namespace="/pages"	var="msidebar_operatesales"></s:url>
<s:url action="msidebar_operateoption" namespace="/pages"	var="msidebar_operateoption"></s:url>
<!-- 类别 -->
<s:url action="category_add" namespace="/pages" var="category_add"></s:url>
<s:url action="category_list" namespace="/pages" var="category_list"></s:url>
<!-- 商品 -->
<s:url action="product_add" namespace="/pages" var="product_add"></s:url>
<s:url action="product_list" namespace="/pages"	var="product_list"></s:url>
<!--<div class="side-bar" id="J_sideBar">-->
		<h3><a href="index">首页</a></h3>
		<h3>网站管理</h3>
		<ul class="hide">
			<li><a target="mdetail" href="${msidebar_webserver}">服务器信息</a></li>
			<li><a target="mdetail" href="${msidebar_webdatabase}">数据库信息</a></li>
			<li><a target="mdetail" href="${msidebar_webotherinformation}">其他信息</a></li>
		</ul>        
		<h3>用户管理</h3>
		<ul>
            <li><a target="mdetail" href="${msidebar_adminuser}">管理员</a></li>
            <li><a target="mdetail" href="${msidebar_playeruser}">玩家</a></li>
		</ul>
		<h3>资产管理</h3>
		<ul>
			<li><a target="mdetail" href="${msidebar_assetgiro}">转账管理</a></li>
            <li><a target="mdetail" href="${msidebar_assetsilver}">银币管理</a></li>
            <li><a target="mdetail" href="${msidebar_assetinvest}">投资管理</a></li>
		</ul>        
		<h3>运营管理</h3>
		<ul>
			<li><a target="mdetail" href="${msidebar_operatesales}">活动管理</a></li>
			<li><a target="mdetail" href="${msidebar_operateoption}">游戏设定</a></li>
		</ul>
		<h3>商品管理</h3>
		<ul class="hide">
			<li><a target="mdetail" href="${category_add}">添加类别</a></li>
			<li><a target="mdetail" href="${category_list}">查看类别</a></li>
			<li><a target="mdetail" href="${product_add}">添加商品</a></li>
			<li><a target="mdetail" href="${product_list}">查看商品</a></li>
		</ul>
<!--</div>-->