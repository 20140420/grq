<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html>
<link href="${context_path}/css/game.css" rel="stylesheet" type="text/css" />
<div class="chat">
  <div class="chat-content">
	<div id="console-container">
		<div id="console"></div>
	</div>
  </div>
  <div class="chat-expression"><img src="${context_path}/imgsystem/chat_expression.png" width="53" height="23"></div>
  <div class="chat-color"><img src="${context_path}/imgsystem/chat_color.png" width="53" height="23"></div>
  <div class="chat-shield"><img src="${context_path}/imgsystem/chat-shield.png" width="55" height="23"></div>
  <div class="chat-horn"><img src="${context_path}/imgsystem/chat-horn.png" width="53" height="23"></div>
  <div class="chat-input"><input type="text" placeholder="请输入并按Enter键" id="chat" /></div>
  <div class="chat-enter"><input type="submit" value=" "></div>
<!-- end .chat -->
</div>

