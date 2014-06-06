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
<!--<div class="sidebar1">-->
		<h3><s:a action="indexweb" namespace="/" target="_blank">首页</s:a></h3>
        <h3><s:a action="usidebar_usilverbuy" namespace="/user" target="mdetail">银币买入</s:a></h3>
		<h3><s:a action="usidebar_usilversell" namespace="/user" target="mdetail">银币卖出</s:a></h3>
		<h3>查询</h3>
		<ul>
			<li><s:a action="usidebar_uinquiryaccount" namespace="/user" target="mdetail">账户资金</s:a></li>
			<li><s:a action="usidebar_uinquirysilverrecord" namespace="/user" target="mdetail">资金明细</s:a></li>
			<li><s:a action="usidebar_uinquirygame" namespace="/user" target="mdetail">当日游戏</s:a></li>
		</ul>
		<h3>投资理财</h3>
		<ul>
			<li><s:a action="usidebar_uinvest" namespace="/user" target="mdetail">固定收益投资</s:a></li>
            <li><s:a action="usidebar_uinvestrecord" namespace="/user" target="mdetail">投资明细</s:a></li>
		</ul>        
  		<h3>转账</h3>
		<ul>
			<li><s:a action="usidebar_ugiro" namespace="/user" target="mdetail">转入转出</s:a></li>
			<li><s:a action="usidebar_ugirorecord" namespace="/user" target="mdetail">转账记录</s:a></li>
		</ul>
	    <h3>个人账户</h3>
		<ul>
            <li><s:a action="usidebar_uprofile" namespace="/user" target="mdetail">个人资料</s:a></li>
			<li><s:a action="usidebar_upassquestion" namespace="/user" target="mdetail">账户密保</s:a></li>
			<li><s:a action="usidebar_ubankcard" namespace="/user" target="mdetail">关联银行</s:a></li>      
		</ul>		
  		<h3>师徒关系</h3>
		<ul class="hide">
			<li><s:a action="usidebar_umaster" namespace="/user" target="mdetail">师傅</s:a></li>
			<li><s:a action="usidebar_uapprentice" namespace="/user" target="mdetail">徒弟</s:a></li>
		</ul>
  		<h3>交割单</h3>
		<ul class="hide">
			<li><s:a action="usidebar_cart" namespace="/user" target="mdetail">我的购物车</s:a></li>
			<li><s:a action="usidebar_order" namespace="/user" target="mdetail">我的订单</s:a></li>
		</ul>
<!--</div> -->