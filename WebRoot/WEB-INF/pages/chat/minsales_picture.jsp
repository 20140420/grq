<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>股如泉www.guruquan.com</title>
<style type="text/css">
body{
	text-align: center;
	margin: 0px;
	padding: 0px;
}
td {
	font-size: 12px;
	margin: 0px;
	padding: 0px;
}
.bottomline {
	BORDER-BOTTOM: #c3c3c3 1px solid;
	margin: 0px;
	padding: 0px;
}
.solidbox {
	BORDER: #c3c3c3 1px solid;
	width: 268px;
}
</style>
<SCRIPT src="<%=basePath%>js/bbs.js"></SCRIPT>
</head>
<body>
<DIV id=top_slider>
<!--bbs s1 -->
<DIV id=bbs_s1 class=solidbox>
<TABLE cellSpacing=0 cellPadding=0 width="268" border=0>
  <TBODY>
    <TR>
      <TD style="PADDING-RIGHT: 0px; PADDING-LEFT: 0px; PADDING-BOTTOM: 2px; PADDING-TOP: 0px">
      	<A href="http://www.guruquan.com" target=_blank>
        	<IMG height=60 src="<%=basePath%>imgweb/chat/01.jpg" width=268 border=0>
        </A>
      </TD>
    </TR>
	<TR>
      <TD width="264" align=middle>
          <TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
            <TBODY>
              <TR>
                <TD align=middle width=30><STRONG>①</STRONG></TD>
                <TD width=10><IMG src="<%=basePath%>imgsystem/bbs_sl_p1.gif" height="20"></TD>
                <TD class=bottomline align=middle width=30><a href="javascript:setFocus(2);"><STRONG>②</STRONG></A></TD>
                <TD width=10><IMG src="<%=basePath%>imgsystem/bbs_sl_p2.gif" height="20"></TD>
                <TD class=bottomline align=middle width=30><a href="javascript:setFocus(3);"><STRONG>③</STRONG></A></TD>
                <TD width=10><IMG src="<%=basePath%>imgsystem/bbs_sl_p2.gif" height="20"></TD>
                <TD class=bottomline align=right>
                    <TABLE cellSpacing=0 cellPadding=0 width=110 border=0>
                      <TBODY>
                      	<TR>
                        	<TD align=right>
                          	<A href="javascript:pre_img();"><IMG src="<%=basePath%>imgsystem/bu_back.gif" border=0></A>
                            <!-- <A href="javascript:;"><IMG onclick=playorpau(this) src="<%=basePath%>imgsystem/bu_pau.gif" border=0></A> -->
                            <A href="javascript:next_img();"><IMG src="<%=basePath%>imgsystem/bu_next.gif" border=0></A>
                           </TD>
                        </TR>
                      </TBODY>
                    </TABLE>
                 </TD>
              </TR>
            </TBODY>
          </TABLE>
      </TD>
    </TR>
  </TBODY>
</TABLE>
</div>

<!--bbs s2 -->
<DIV id=bbs_s2 class=solidbox style="DISPLAY: none">
<table cellspacing=0 cellpadding=0 width="268" border=0>
  <tbody>
    <tr>
      <td style="PADDING-RIGHT: 0px; PADDING-LEFT: 0px; PADDING-BOTTOM: 2px; PADDING-TOP: 0px">
      <a href="http://www.guruquan.com" target=_blank>
      	<img height=60 src="<%=basePath%>imgweb/chat/02.jpg" width=268 border=0>
      </a>
      </td>
    </tr>
    <tr>
      <td width="264" align=middle>
      <table cellspacing=0 cellpadding=0 width="100%" border=0>
        <tbody>
          <tr>
            <td class=bottomline align=middle width=30><a 
            href="javascript:setFocus(1);"><strong>①</strong></a></td>
            <td width=10><img src="<%=basePath%>imgsystem/bbs_sl_p2.gif" height="20"></td>
            <td align=middle width=30><strong>②</strong></td>
            <td width=10><img src="<%=basePath%>imgsystem/bbs_sl_p1.gif" height="20"></td>
            <td class=bottomline align=middle width=30><a 
            href="javascript:setFocus(3);"><strong>③</strong></a></td>
            <td width=10><img src="<%=basePath%>imgsystem/bbs_sl_p2.gif" height="20"></td>
            <td class=bottomline align=right>
            <table cellspacing=0 cellpadding=0 width=110 border=0>
              <tbody>
                <tr>
                  <td align=right>
                  <a href="javascript:pre_img();"><img src="<%=basePath%>imgsystem/bu_back.gif" border=0></a>
                  <!-- <a href="javascript:;"><img onClick=playorpau(this) src="<%=basePath%>imgsystem/bu_pau.gif" border=0></a> -->
                  <a href="javascript:next_img();"><img src="<%=basePath%>imgsystem/bu_next.gif" border=0></a>
                  </td>
                </tr>
              </tbody>
            </table>
            </td>
          </tr>
        </tbody>
      </table>
      </td>
    </tr>
  </tbody>
</table>
</div>

<!--bbs s3 -->
<DIV id=bbs_s3 class=solidbox style="DISPLAY: none">
<table cellspacing=0 cellpadding=0 width="268" border=0>
  <tbody>
    <tr>
      <td style="PADDING-RIGHT: 0px; PADDING-LEFT: 0px; PADDING-BOTTOM: 2px; PADDING-TOP: 0px">
      <a href="http://www.guruquan.com" target=_blank>
      	<img height=60 src="<%=basePath%>imgweb/chat/03.jpg" width=268 border=0>
        </a>
      </td>
    </tr>
	<tr>
      <td width="264" align=middle><table cellspacing=0 cellpadding=0 width="100%" border=0>
        <tbody>
          <tr>
            <td class=bottomline align=middle width=30><a 
            href="javascript:setFocus(1);"><strong>①</strong></a></td>
            <td width=10><img src="<%=basePath%>imgsystem/bbs_sl_p2.gif" height="20"></td>
            <td class=bottomline align=middle width=30><a 
            href="javascript:setFocus(2);"><strong>②</strong></a></td>
            <td width=10><img src="<%=basePath%>imgsystem/bbs_sl_p2.gif" height="20"></td>
            <td align=middle width=30><strong>③</strong></td>
            <td width=10><img src="<%=basePath%>imgsystem/bbs_sl_p1.gif" height="20"></td>
            <td class=bottomline align=right>
            <table cellspacing=0 cellpadding=0 width=110 border=0>
              <tbody>
                <tr>
                  <td align=right>
                  <a href="javascript:pre_img();"><img src="<%=basePath%>imgsystem/bu_back.gif" border=0></a>
                  <!-- <a href="javascript:;"><img onClick=playorpau(this) src="<%=basePath%>imgsystem/bu_pau.gif" border=0></a> -->
                  <a href="javascript:next_img();"><img src="<%=basePath%>imgsystem/bu_next.gif" border=0></a>
                  </td>
                </tr>
              </tbody>
            </table>
            </td>
          </tr>
        </tbody>
      </table>
      </td>
    </tr>
  </tbody>
</table>
</div>
</DIV>
</body>
</html>
