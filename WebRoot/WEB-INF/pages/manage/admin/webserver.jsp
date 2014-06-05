<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<s:set var="context_path" value="#request.get('javax.servlet.forward.context_path')"></s:set>
<link href="${context_path}/css/manage.css" rel="stylesheet" type="text/css" />
    <div class="content">
<div class="webserver">
      <table>
        <tr>
          <td colspan="3" align="left">Server Status</td>
          <td colspan="3" class="col3">最近查询时间：2014-01-02 15:47:11</td>
        </tr>
        <tr>
          <th colspan="6" align="left">Server Information</th>
        </tr>
        <tr>
          <th><small>Tomcat Version：</small></th>
          <td><small>Apache Tomcat/7.0.47</small></td>
          <th><small>JVM Version：</small></th>
          <td><small>1.7.0_15-b03</small></td>
          <th><small>JVM Vendor：</small></th>
          <td><small>Oracle Corporation</small></td>
        </tr>
        <tr>
          <th><small>OS Name：</small></th>
          <td><small>Windows XP</small></td>
          <th><small>OS Version：</small></th>
          <td><small>5.1</small></td>
          <th><small>OS Architecture：</small></th>
          <td><small>x86</small></td>
        </tr>
        <tr>
          <th><small>Hostname：</small></th>
          <td><small>BD</small></td>
          <th><small>IP Address：</small></th>
          <td><small>192.168.1.104</small></td>
          <th><small>&nbsp;</small></th>
          <td><small>&nbsp;</small></td>
        </tr>
      </table>
</div>
  <!-- end .content --></div>
