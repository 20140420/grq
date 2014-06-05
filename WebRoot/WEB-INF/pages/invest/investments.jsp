<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8" />
<title>投资理财</title>
<link href="css/web.css" rel="stylesheet" type="text/css" />
<!--<link rel="stylesheet" href="css_example_url" />
<script src="js_example_url"></script>-->
</head>
<body>
<div class="container">
	<div class="header"><%@ include file="/WEB-INF/pages/header.jsp"%></div><!-- end .header -->
	<div class="content">
<div class="investment">
<h1 style='text-align:center;'>
定额定期固定收益投资		
</h1>
<p>				
前言：<br/>
本平台经营两个业务，一个是游戏平台的运营，另一个就是和金融机构合作的定额定期固定收益投资。		
</p>
<p>					
定额：<br/>
定额顾名思义就是金额具有一定限制，但和通常的定额有一定区别。本平台中的理财投资产品具体定额有客户自己给定，本平台只是做了个额度范围的限定。							
</p>
<p>
定期：<br/>
相对定额的灵活性，本平台定期相应显得很死，目前平台只有一年期理财投资产品。	
</p>
<p>						
固定收益投资：<br/>
固定收益投资很显然就是具有固定利率的、有保障的投资。那么，具体利率是多少呢？我们以“不低于银行存款利率，不高银行贷款利率”为基本点来执行。现在来看下最新的银行存贷款基准利率表：							
</p>

<table cellspacing="0">
	<tr>
		<th>2012年7月6日执行</th>
		<th>利率	</th>
	</tr>
	<tr>
		<td>活期存款</td>
		<td>0.35</td>
	</tr>
	<tr>
		<td>整存整取定期存款</td>
		<td>-</td>
	</tr>
	<tr>
		<td>三个月</td>
		<td>2.6</td>
	</tr>
	<tr>
		<td>半年	</td>
		<td>2.8</td>
	</tr>
	<tr>
		<td>一年</td>
		<td>3</td>
	</tr>
	<tr>
		<td>二年</td>
		<td>3.75</td>
	</tr>
	<tr>
		<td>三年</td>
		<td>4.25</td>
	</tr>
	<tr>
		<td>五年</td>
		<td>4.75</td>
	</tr>
	<tr>
		<td>各项贷款</td>
		<td>利率</td>
	</tr>
	<tr>
		<td>六个月</td>
		<td>5.6</td>
	</tr>
	<tr>
		<td>一年</td>
		<td>6</td>
	</tr>
	<tr>
		<td>一至三年</td>
		<td>6.15</td>
	</tr>
	<tr>
		<td>三至五年</td>
		<td>6.4</td>
	</tr>
	<tr>
		<td>五年以上</td>
		<td>6.55</td>
	</tr>
	<tr>
		<td>公积金贷款</td>
		<td>-</td>
	</tr>
	<tr>
		<td>五年以下（含五年）</td>
		<td>4</td>
	</tr>
	<tr>
		<td>五年以上</td>
		<td>4.5</td>
	</tr>
	<tr>
		<td>综上所述：</td>
		<td>本平台定额定期固定收益投资理财产品为</td>
	</tr>
</table>
						
<table cellspacing="0">
<tr>
		<th>定额</th>
		<th>定期</th>
		<th>固定收益率</th>
	</tr>
	<tr>
		<td>0至小于1万</td>
		<td>一年</td>
		<td>5</td>
	</tr>
	<tr>
		<td>1万至小于10万</td>
		<td>一年</td>
		<td>5.5</td>
	</tr>
	<tr>
		<td>10万以上</td>
		<td>一年</td>
		<td>6</td>
	</tr>
</table>					

<p>					
如此合理的理财投资产品适合社会各界人士的需求。
</p>
<p>							
购买理财产品投资流程：						
</p>					
<p>							
购买了理财产品后，还未到期时想提前结束投资，可以索取并填写提交《违约投资申请表》，审理通过后可以提前解冻投资资金。	
</p>
</div>
<div class="investment-nav">
	<ul>
    	<li><a href="manage/uinvest.jsp">存款</a></li>
    	<li><a href="joinbc.jsp">索取申请表</a></li>
    </ul>    
</div>
 
        <!--<div id="sample">
         ...
        </div>  #sample END -->
	</div>
    <!--<div class="sidebar1">
        侧边（选择）
	</div>-->   
  <div class="footer"><%@ include file="/WEB-INF/pages/footer.jsp"%><!-- end .footer --></div>
</div>
<script>
// 你的代码
</script>
</body>
</html>

