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

<!--<div class="side-bar" id="J_sideBar">-->
		<h3><s:a action="indexweb" namespace="/" target="_blank">首页</s:a></h3>
		<h3>网站管理</h3>
		<ul class="hide">
			<li><s:a action="msidebar_webserver" namespace="/admin" target="mdetail">服务器信息</s:a></li>
			<li><s:a action="msidebar_webdatabase" namespace="/admin" target="mdetail">数据库信息</s:a></li>
			<li><s:a action="msidebar_webotherinformation" namespace="/admin" target="mdetail">其他信息</s:a></li>
		</ul>        
		<h3>用户管理</h3>
		<ul>
            <li><s:a action="msidebar_adminuser" namespace="/admin" target="mdetail">管理员</s:a></li>
            <li><s:a action="msidebar_playeruser" namespace="/admin" target="mdetail">玩家</s:a></li>
		</ul>
		<h3>资产管理</h3>
		<ul>
			<li><s:a action="msidebar_assetgiro" namespace="/admin" target="mdetail">转账管理</s:a></li>
            <li><s:a action="msidebar_assetsilver" namespace="/admin" target="mdetail">银币管理</s:a></li>
            <li><s:a action="msidebar_assetinvest" namespace="/admin" target="mdetail">投资管理</s:a></li>
		</ul>        
		<h3>运营管理</h3>
		<ul>
			<li><s:a action="msidebar_operatesales" namespace="/admin" target="mdetail">活动管理</s:a></li>
			<li><s:a action="msidebar_operateoption" namespace="/admin" target="mdetail">游戏设定</s:a></li>
		</ul>
		<h3>商品管理</h3>
		<ul class="hide">
			<li><s:a action="category_add" namespace="/admin/product" target="mdetail">添加类别</s:a></li>
			<li><s:a action="category_list" namespace="/admin/product" target="mdetail">所有类别</s:a></li>
			<li><s:a action="product_add" namespace="/admin/product" target="mdetail">添加商品</s:a></li>
			<li><s:a action="product_list" namespace="/admin/product" target="mdetail">所有商品</s:a></li>
			<li><s:a action="order_query" namespace="/admin/product" target="mdetail">订单查询</s:a></li>
			<li><s:a action="order_list" namespace="/admin/product" target="mdetail">所有订单</s:a></li>
		</ul>
<!--</div>-->