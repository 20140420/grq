<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<s:set var="context_path" value="#request.get('javax.servlet.forward.context_path')"></s:set>
<link href="%{context_path}/css/game.css" rel="stylesheet" type="text/css" />
<!----><div class="gpanel">
  <div class="gpanel_count">
	<div class="gpanel_silver_available"><input type="text" value="可用银币"></div>
	<div class="gpanel_silver_dividend"><input type="text" value="装饰用彩金数"></div>
	<div class="gpanel_silver_profit"><input type="text" value="70*14"></div>
  </div>
  <div class="gpanel_uncommon">
  	<!-- 显示押注 -->
    <div class="gpanel_bird"><input type="text" value="47*16"></div>
    <div class="gpanel_silver_shark"><input type="text" value=""></div>
    <div class="gpanel_bomb"><input type="text" value=""></div>
    <div class="gpanel_gold_shark"><input type="text" value=""></div>
    <div class="gpanel_beast"><input type="text" value=""></div>
    <!-- 按键 -->
    <div class="gpanel_key_bird"><img width="50" height="42" /></div>
    <div class="gpanel_key_silver_shark"><img width="50" height="42" /></div>
    <div class="gpanel_key_bomb"><img width="50" height="42" /></div>
    <div class="gpanel_key_gold_shark"><img width="50" height="42" /></div>
    <div class="gpanel_key_beast"><img width="50" height="42" /></div>
  </div>
  <div class="gpanel_regulate">
  	<!-- 押注单量显示 -->
    <div class="gpanel_single_bet"><input type="text" value="87*14"></div>
    <!-- 按键 -->
    <div class="gpanel_key_continue"><img width="48" height="26" /></div>
    <div class="gpanel_key_cancel"><img width="48" height="26" /></div>
    <div class="gpanel_key_change"><img width="48" height="26" /></div>
  </div>
  <div class="gpanel_common">
	<div class="gpanel_times">
    	<div class="gpanel_times_swallow"><input type="text" value="63*21"></div>
        <div class="gpanel_times_pigeon"><input type="text" value="6"></div>
      <div class="gpanel_times_peafowl"><input type="text" value="8"></div>
        <div class="gpanel_times_eagle"><input type="text" value="24"></div>
        <div class="gpanel_times_lion"><input type="text" value="24"></div>
        <div class="gpanel_times_panda"><input type="text" value="8"></div>
        <div class="gpanel_times_monkey"><input type="text" value="6"></div>
        <div class="gpanel_times_rabbit"><input type="text" value="6"></div>
    </div>
    <div class="gpanel_personal">
    	<div class="gpanel_personal_swallow"><input type="text" value="63*16"></div>
        <div class="gpanel_personal_pigeon"><input type="text" value=""></div>
        <div class="gpanel_personal_peafowl"><input type="text" value=""></div>
        <div class="gpanel_personal_eagle"><input type="text" value=""></div>
        <div class="gpanel_personal_lion"><input type="text" value=""></div>
        <div class="gpanel_personal_panda"><input type="text" value=""></div>
        <div class="gpanel_personal_monkey"><input type="text" value=""></div>
        <div class="gpanel_personal_rabbit"><input type="text" value=""></div>
    </div>
    <div class="gpanel_key_swallow"><s:submit type="image" src="%{context_path}/imgsystem/key_swallow.png"></s:submit></div>
    <div class="gpanel_key_pigeon"><s:submit type="image" src="%{context_path}/imgsystem/key_pigeon.png"></s:submit></div>
    <div class="gpanel_key_peafowl"><s:submit type="image" src="%{context_path}/imgsystem/key_peafowl.png"></s:submit></div>
    <div class="gpanel_key_eagle"><s:submit type="image" src="%{context_path}/imgsystem/key_eagle.png"></s:submit></div>
    <div class="gpanel_key_lion"><s:submit type="image" src="%{context_path}/imgsystem/key_lion.png"></s:submit></div>
    <div class="gpanel_key_panda"><s:submit type="image" src="%{context_path}/imgsystem/key_panda.png"></s:submit></div>
    <div class="gpanel_key_monkey"><s:submit type="image" src="%{context_path}/imgsystem/key_monkey.png"></s:submit></div>
    <div class="gpanel_key_rabbit"><s:submit type="image" src="%{context_path}/imgsystem/key_rabbit.png"></s:submit></div>
  </div>
<!----></div>
