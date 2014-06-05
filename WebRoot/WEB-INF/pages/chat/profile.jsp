<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html>
<link href="${context_path}/css/game.css" rel="stylesheet" type="text/css" />
<div class="profile">
  <div class="profile-face"><img src="${context_path}/imgweb/user_face/profile_face_a01.png" width="48" height="48" /></div>
  <div class="profile-title-nickname">昵&nbsp;&nbsp;&nbsp;&nbsp;称：</div>
  <div class="profile-nickname"><input type="text" placeholder="昵称" value="个人与团队"></div>
  <div class="profile-title-apprentice_number">徒&nbsp;&nbsp;&nbsp;&nbsp;弟：</div>
  <div class="profile-apprentice_number"><input type="text" placeholder="徒弟数量" value="108"></div>
  <div class="profile-title-silver_available">可用银币：</div>
  <div class="profile-silver_available"><input type="text" placeholder="可用银币数量" value="2100"></div>
  <!--end .profile -->
</div>
