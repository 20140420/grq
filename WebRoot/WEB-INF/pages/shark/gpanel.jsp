<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<s:set var="context_path" value="#request.get('javax.servlet.forward.context_path')"></s:set>

<script type="text/javascript" src="<%=basePath%>js/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="<%=basePath%>js/payfor.js"></script>
<link href="<%=basePath%>css/payfor.css" rel="stylesheet" type="text/css" />

<link href="<%=basePath%>css/game.css" rel="stylesheet" type="text/css" />
<!----><div class="gpanel">
  <div class="gpanel_count">
	<div class="gpanel_silver_available"><input type="text" value="可用银币"></div>
	<div class="gpanel_silver_dividend"><input type="text" value="装饰用彩金数"></div>
	<div class="gpanel_silver_profit"><input type="text" value="70*14"></div>
  </div>
  <div class="gpanel_uncommon">
  	<!-- 显示押注 -->
    <div class="gpanel_bird">
	<input type="text" name="qty_item_9" value="0" id="qty_item_9" onKeyUp="setAmount.modify('#qty_item_9')" class="text" /></div>
    <div class="gpanel_silver_shark">
	<input type="text" name="qty_item_10" value="0" id="qty_item_10" onKeyUp="setAmount.modify('#qty_item_10')" class="text" /></div>
    <div class="gpanel_bomb">
    <input type="text" name="qty_item_11" value="0" id="qty_item_11" onKeyUp="setAmount.modify('#qty_item_11')" class="text" /></div>
    <div class="gpanel_gold_shark">
	<input type="text" name="qty_item_12" value="0" id="qty_item_12" onKeyUp="setAmount.modify('#qty_item_12')" class="text" /></div>
    <div class="gpanel_beast">
    <input type="text" name="qty_item_13" value="47*16" id="qty_item_13" onKeyUp="setAmount.modify('#qty_item_13')" class="text" /></div>
    <!-- 按键 -->
    <div class="gpanel_key_bird">
        <div class="f_l add_chose">
			<a class="add" onClick="setAmount.add('#qty_item_9')" href="javascript:void(0)"><img src="<%=basePath%>imgsystem/key_bird.png" width="50" height="42" /></a>
		</div>
	</div>
    <div class="gpanel_key_silver_shark">
        <div class="f_l add_chose">
			<a class="add" onClick="setAmount.add('#qty_item_10')" href="javascript:void(0)"><img src="<%=basePath%>imgsystem/key_silver_shark.png" width="50" height="42" /></a>
		</div>
    </div>
    <div class="gpanel_key_bomb">
        <div class="f_l add_chose">
			<a class="add" onClick="setAmount.add('#qty_item_11')" href="javascript:void(0)"><img src="<%=basePath%>imgsystem/key_bomb.png" width="50" height="42" /></a>
		</div>
    </div>
    <div class="gpanel_key_gold_shark">
        <div class="f_l add_chose">
			<a class="add" onClick="setAmount.add('#qty_item_12')" href="javascript:void(0)"><img src="<%=basePath%>imgsystem/key_gold_shark.png" width="50" height="42" /></a>
		</div>
	</div>
    <div class="gpanel_key_beast">
        <div class="f_l add_chose">
			<a class="add" onClick="setAmount.add('#qty_item_13')" href="javascript:void(0)"><img src="<%=basePath%>imgsystem/key_beast.png" width="50" height="42" /></a>
		</div>
    </div>
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
    	<div class="gpanel_times_swallow"><input type="text" name="times_swallow" value="6"></div>
        <div class="gpanel_times_pigeon"><input type="text" name="times_pigeon" value="6"></div>
		<div class="gpanel_times_peafowl"><input type="text" name="times_peafowl" value="8"></div>
        <div class="gpanel_times_eagle"><input type="text" name="times_eagle" value="24"></div>
        <div class="gpanel_times_lion"><input type="text" name="times_loin" value="24"></div>
        <div class="gpanel_times_panda"><input type="text" name="times_panda" value="8"></div>
        <div class="gpanel_times_monkey"><input type="text" name="times_monkey" value="倍数"></div>
        <div class="gpanel_times_rabbit"><input type="text" name="times_rabbit" value="63*21"></div>
    </div>
    <div class="gpanel_personal">
    	<div class="gpanel_personal_swallow">
    	<input type="text" name="qty_item_1" value="0" id="qty_item_1" onKeyUp="setAmount.modify('#qty_item_1')" class="text" /></div>
        <div class="gpanel_personal_pigeon">
		<input type="text" name="qty_item_2" value="0" id="qty_item_2" onKeyUp="setAmount.modify('#qty_item_2')" class="text" /></div>
        <div class="gpanel_personal_peafowl">
		<input type="text" name="qty_item_3" value="0" id="qty_item_3" onKeyUp="setAmount.modify('#qty_item_3')" class="text" /></div>
        <div class="gpanel_personal_eagle">
		<input type="text" name="qty_item_4" value="0" id="qty_item_4" onKeyUp="setAmount.modify('#qty_item_4')" class="text" /></div>
        <div class="gpanel_personal_lion">
        <input type="text" name="qty_item_5" value="0" id="qty_item_5" onKeyUp="setAmount.modify('#qty_item_5')" class="text" /></div>
        <div class="gpanel_personal_panda">
		<input type="text" name="qty_item_6" value="0" id="qty_item_6" onKeyUp="setAmount.modify('#qty_item_6')" class="text" /></div>
        <div class="gpanel_personal_monkey">
        <input type="text" name="qty_item_7" value="筹码" id="qty_item_7" onKeyUp="setAmount.modify('#qty_item_7')" class="text" /></div>
        <div class="gpanel_personal_rabbit">
        <input type="text" name="qty_item_8" value="63*16" id="qty_item_8" onKeyUp="setAmount.modify('#qty_item_8')" class="text" /></div>
    </div>
    <div class="gpanel_key_swallow">
    	<div class="f_l add_chose">
			<a class="add" onClick="setAmount.add('#qty_item_1')" href="javascript:void(0)"><img src="<%=basePath%>imgsystem/key_swallow.png" width="70" height="42" /></a>
		</div>
    </div>
    <div class="gpanel_key_pigeon">
        <div class="f_l add_chose">
			<a class="add" onClick="setAmount.add('#qty_item_2')" href="javascript:void(0)"><img src="<%=basePath%>imgsystem/key_pigeon.png" width="70" height="42" /></a>
		</div>
	</div>
    <div class="gpanel_key_peafowl">
        <div class="f_l add_chose">
			<a class="add" onClick="setAmount.add('#qty_item_3')" href="javascript:void(0)"><img src="<%=basePath%>imgsystem/key_peafowl.png" width="70" height="42" /></a>
		</div>
    </div>
    <div class="gpanel_key_eagle">
        <div class="f_l add_chose">
			<a class="add" onClick="setAmount.add('#qty_item_4')" href="javascript:void(0)"><img src="<%=basePath%>imgsystem/key_eagle.png" width="70" height="42" /></a>
		</div>
	</div>
    <div class="gpanel_key_lion">
        <div class="f_l add_chose">
			<a class="add" onClick="setAmount.add('#qty_item_5')" href="javascript:void(0)"><img src="<%=basePath%>imgsystem/key_lion.png" width="70" height="42" /></a>
		</div>
	</div>
    <div class="gpanel_key_panda">
        <div class="f_l add_chose">
			<a class="add" onClick="setAmount.add('#qty_item_6')" href="javascript:void(0)"><img src="<%=basePath%>imgsystem/key_panda.png" width="70" height="42" /></a>
		</div>
	</div>
    <div class="gpanel_key_monkey">
        <div class="f_l add_chose">
			<a class="add" onClick="setAmount.add('#qty_item_7')" href="javascript:void(0)"><img src="<%=basePath%>imgsystem/key_monkey.png" width="70" height="42" /></a>
		</div>
	</div>
    <div class="gpanel_key_rabbit">
        <div class="f_l add_chose">
			<a class="add" onClick="setAmount.add('#qty_item_8')" href="javascript:void(0)"><img src="<%=basePath%>imgsystem/key_rabbit.png" width="70" height="42" /></a>
		</div>
	</div>
  </div>
<!----></div>
