//<![CDATA[ 
window.onload=function(){
KISSY.Config.combine = true;
KISSY.use("gallery/kcharts/1.2/linechart/index",function(S,LineChart){
  var linechart = new LineChart({
      renderTo:"#demo1",
      points:{
        attr:{
          type:"auto"
        }
      },
      yLabels:{
        css:{
          "marginLeft":"-4px",
          "font-family":"Microsoft Yahei",
          "font-size":"10px"
        }
      },
      xLabels:{
        css:{
          "font-family":"Microsoft Yahei",
           "font-size":"10px"
        }
      },
      title:{
              content:"Silver price"
            },
            anim:{},
            subTitle:{
              content:"Source: www.guruquan.com"
            },
            lineType:"straight",
       xAxis: {
          text:['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun',
                    'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec']
            },
            yAxis:{
              num:7
            },
          comparable:true,
      series:[{
				text: 'bid price',
                data: [110, 110, 110, 110, 110, 110, 110, 110, 110, 110, 110, 110]
            }, {
                text: 'strike price',
                data: [99, 95, 101, 108, 103, 90, 97, 91, 90, 90, 90, 96]
            }
            , {
                
				text: 'ask price',
                data: [90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90]
            }
            ],
      legend:{
        isShow:true,y:-10
      },
      tip:{
        offset:{
                    x:10,
                    y:10
                },
        template:function(e){
          var html = "";
          for(var i in e.datas){
            html +="<span style='font-size:10px;color:"+e.datas[i]['color']+"'>"+e.datas[i]['text'] +" "+e.datas[i]['y']+"\</span><br/>";
          }
          return html;
        }
      }
  });

});
};//]]>