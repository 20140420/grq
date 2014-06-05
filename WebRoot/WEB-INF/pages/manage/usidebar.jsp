<!---------------------------------
*  COPYRIGHT(C) 2013 杭州伯才团队
*   ALL RIGHTS RESERVED
*
* [FILE]      
*     usidebar.jsp
*
* [DESCRIPTION]   
*     本页是普通用户基本简介界面
*
* [NOTE]
*     
*
* [VERSION]
*    v1.00  2013/11/29 姜泉  首版制作    
* --------------------------------->
<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<s:url action="usidebar_usilverbuy" namespace="/pages"	var="usidebar_usilverbuy"></s:url>
<s:url action="usidebar_usilversell" namespace="/pages"	var="usidebar_usilversell"></s:url>
<s:url action="usidebar_uinquiryaccount" namespace="/pages"	var="usidebar_uinquiryaccount"></s:url>
<s:url action="usidebar_uinquirysilverrecord" namespace="/pages"	var="usidebar_uinquirysilverrecord"></s:url>
<s:url action="usidebar_uinquirygame" namespace="/pages"	var="usidebar_uinquirygame"></s:url>
<s:url action="usidebar_uinvest" namespace="/pages"	var="usidebar_uinvest"></s:url>
<s:url action="usidebar_uinvestrecord" namespace="/pages"	var="usidebar_uinvestrecord"></s:url>
<s:url action="usidebar_ugiro" namespace="/pages"	var="usidebar_ugiro"></s:url>
<s:url action="usidebar_ugirorecord" namespace="/pages"	var="usidebar_ugirorecord"></s:url>
<s:url action="usidebar_uprofile" namespace="/pages"	var="usidebar_uprofile"></s:url>
<s:url action="usidebar_upassquestion" namespace="/pages"	var="usidebar_upassquestion"></s:url>
<s:url action="usidebar_ubankcard" namespace="/pages"	var="usidebar_ubankcard"></s:url>
<s:url action="usidebar_umaster" namespace="/pages"	var="usidebar_umaster"></s:url>
<s:url action="usidebar_uapprentice" namespace="/pages"	var="usidebar_uapprentice"></s:url>
<!-- 购物车 -->
<s:url action="#" namespace="/pages" var="#"></s:url>
<!-- 订单 -->
<s:url action="#" namespace="/pages" var="#"></s:url>

<!--<div class="sidebar1">-->
		<h3><a href="index">首页</a></h3>
        <h3><a target="mdetail" href="${usidebar_usilverbuy}">银币买入</a></h3>
		<h3><a target="mdetail" href="${usidebar_usilversell}">银币卖出</a></h3>
		<h3>查询</h3>
		<ul>
			<li><a target="mdetail" href="${usidebar_uinquiryaccount}">账户资金</a></li>
			<li><a target="mdetail" href="${usidebar_uinquirysilverrecord}">资金明细</a></li>
			<li><a target="mdetail" href="${usidebar_uinquirygame}">当日游戏</a></li>
		</ul>
		<h3>投资理财</h3>
		<ul>
			<li><a target="mdetail" href="${usidebar_uinvest}">固定收益投资</a></li>
            <li><a target="mdetail" href="${usidebar_uinvestrecord}">投资明细</a></li>
		</ul>        
  		<h3>转账</h3>
		<ul>
			<li><a target="mdetail" href="${usidebar_ugiro}">转入转出</a></li>
			<li><a target="mdetail" href="${usidebar_ugirorecord}">转账记录</a></li>
		</ul>
	    <h3>个人账户</h3>
		<ul>
            <li><a target="mdetail" href="${usidebar_uprofile}">个人资料</a></li>
			<li><a target="mdetail" href="${usidebar_upassquestion}">账户密保</a></li>
			<li><a target="mdetail" href="${usidebar_ubankcard}">关联银行</a></li>      
		</ul>		
  		<h3>师徒关系</h3>
		<ul class="hide">
			<li><a target="mdetail" href="${usidebar_umaster}">师傅</a></li>
			<li><a target="mdetail" href="${usidebar_uapprentice}">徒弟</a></li>
		</ul>
  		<h3>交割单</h3>
		<ul class="hide">
			<li><a target="mdetail" href="${#}">我的购物车</a></li>
			<li><a target="mdetail" href="${#}">我的订单</a></li>
		</ul>
<!--</div> -->