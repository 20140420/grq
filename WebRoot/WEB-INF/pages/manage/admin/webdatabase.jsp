<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<s:set var="context_path" value="#request.get('javax.servlet.forward.context_path')"></s:set>
<link href="${context_path}/css/manage.css" rel="stylesheet" type="text/css" />
    <div class="content">
<div class="webdatabase">
      <table>
        <tr>
          <td colspan="3" align="left">Database Status</td>
          <td colspan="3" class="col3">最近查询时间：2014-01-02 15:47:11</td>
        </tr>
        <tr>
          <th colspan="6" align="left">Database Information</th>
        </tr>
        <tr>
          <th><small>Database Type：</small></th>
          <td><small>MySQL</small></td>
          <th><small>Database Version：</small></th>
          <td><small>5.6.12</small></td>
          <th><small>Database Vendor：</small></th>
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
          <th><small>&nbsp;Character Set</small></th>
          <td><small>UTF-8 Unicode (utf8)</small></td>
        </tr>
      </table>
</div>
    <!-- end .content --></div>
