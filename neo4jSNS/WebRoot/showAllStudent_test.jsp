<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%!
	private static final int pageSize = 5;
 %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	int pageCounts = (int)session.getAttribute("pageCounts");
	int pageNum = (int)request.getAttribute("page");
	
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>我的好友</title>
    <!-- 引入 ECharts 文件 -->
    <script src="./js/min/echarts.min.js"></script>
	<link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.css" rel="stylesheet">
	<link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap-responsive.css" rel="stylesheet">
	<script src="${pageContext.request.contextPath}/bootstrap/js/jQuery.js"></script>
	<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.js"></script>
	<style type="text/css">
body {
	margin: 0 auto;
	padding: 25px;
}
input[type="text"]{
              height: auto;
	          margin-bottom: 15px;
	          padding: 3px 9px;
            }
center, td, tr {
	color: #DDBF5E;
}
h3 {
	color: red;
}
	</style>
  </head>
  
  <body>
  <form action="searchById" method="post">
	    <br /><h3>Friends</h3><br /><br />
		<center>
		       学号：<input type="text" name="searchId" placeholder="好友学号...空时查找所有好友">
		    <i class="icon-search"></i>&nbsp;<button type="submit" class="btn btn-inverse"> 查找</button>
	    </center>
  </form>
  <div id="chart" style="height:500px; width:100%"></div>
    <script type="text/javascript">
      // 基于准备好的dom，初始化echarts实例
      var chart = echarts.init(document.getElementById('chart'));

	  var arr = new Array();
      var index = 0;
      <c:forEach items="${list}" var="lst">
          arr[index1]=new Array(7);
          arr[index1][0]="${lst.stId}";
          arr[index1][1]="${lst.stName}";
          arr[index1][2]="${lst.stSex}";
          arr[index1][3]="${lst.stAge}";
          arr[index1][4]="${lst.stTel}";
          arr[index1][5]="${lst.stAddress}";
          arr[index1][6]="${lst.stDept}";
          index++;
      </c:forEach>
      //准备好数据
      //以下为节点数据，每一个{}里面为一个节点，category（该节点类别），name（关系连接的关键字，可以理解为键值中的键，可为数字）
      //value(节点的值，可以设置节点半径与该值的关系)，label（该字段是我用来显示该节点标签的，可以改名），大家也可以自己设置其他字段
      var graph = {};//数据
      var index = 0;
      <c:forEach items="${list}" var="lst">
      	  var str = "${lst.stId}"+"-${lst.stName}"+"-${lst.stSex}"+"-${lst.stAge}"+"-${lst.stTel}"+"-${lst.stAddress}"+"-${lst.stDept}";
	      var str2 = "$lst.stName"
	      if(index == 0){
	      	  graph.nodes[0] = [
	      	  	  {category:0, name: 0, value:6, label:str2, del:str}
	      	  ];
	      }else{
		      graph.nodes[index] = [
		          {category:1, name:index, value:3, label:str2, del:str}
		      ];
		  }
      //以下为连线关系数据，每一个{}里面为一个关系，source（起点，对应上面的name），target（终点，对应上面的name）
      //value(起点到终点的距离，值越大，权重越大，距离越短)
      	  if(index != 0){
	      	  graph.links[index] = [
	                {source: 0, target: index, value:5, label:'IS_FRIEND_OF'}
	          ];
          }
          index++;
      </c:forEach>
      //categories为node节点分类，categoriesshort为显示图例，后者比前者短，可以使得图例中没有主干人物
      graph.categories = [{name:'ME'},{name:'friend'},{name:'me'} ];
      graph.categoriesshort = [{name:'me'},{name:'friend'} ];

      // 设置关系图节点标记的大小
      graph.nodes.forEach(function (node) {
        node.symbolSize = node.value*3;
    });
      var option = {
      title: {
        text: '人际关系网络图',//标题
        subtext: '人物关系：'+arr[0][1],//标题副标题
        top: 'top',//相对在y轴上的位置
        left: 'center'//相对在x轴上的位置
      },
      tooltip : {//提示框，鼠标悬浮交互时的信息提示
        trigger: 'item',//数据触发类型
        formatter: function(params){//触发之后返回的参数，这个函数是关键
          console.log(params);
          if (params.data.category != undefined) {//如果触发节点
            return params.data.label + params.data.del;//返回标签
          }else {//如果触发边
            return params.data.label;
          }
        },
      },
      //工具箱，每个图表最多仅有一个工具箱
      toolbox: {
        show : true,
        feature : {//启用功能
          //dataView数据视图，打开数据视图，可设置更多属性,readOnly 默认数据视图为只读(即值为true)，可指定readOnly为false打开编辑功能
          dataView: {show: true, readOnly: true},
          restore : {show: true},//restore，还原，复位原始图表
          saveAsImage : {show: true}//saveAsImage，保存图片
        }
      },
      //全局颜色，图例、节点、边的颜色都是从这里取，按照之前划分的种类依序选取
      color:['rgb(194,53,49)','rgb(97,160,168)'],
      //图例，每个图表最多仅有一个图例
      legend: [{
        x: 'left',//图例位置
        //图例的名称，这里返回短名称，即不包含第一个，当然你也可以包含第一个，这样就可以在图例中选择主干人物
        data: graph.categoriesshort.map(function (a) {
                return a.name;
            })
      }],
      //sereis的数据: 用于设置图表数据之用
      series : [
        {
          name: '人际关系网络图',//系列名称
          type: 'graph',//图表类型
          layout: 'force',//echarts3的变化，force是力向图，circular是和弦图
          draggable: true,//指示节点是否可以拖动
          data: graph.nodes,//节点数据
          links: graph.links,//边、联系数据
          categories: graph.categories,//节点种类
          focusNodeAdjacency:true,//当鼠标移动到节点上，突出显示节点以及节点的边和邻接节点
          roam: true,//是否开启鼠标缩放和平移漫游。默认不开启。如果只想要开启缩放或者平移，可以设置成 'scale' 或者 'move'。设置成 true 为都开启
          label: {//图形上的文本标签，可用于说明图形的一些数据信息
            normal: {
              show : true,//显示
              position: 'right',//相对于节点标签的位置
              //回调函数，你期望节点标签上显示什么
              formatter: function(params){
                return params.data.label;
              },
            }
          },
          //节点的style
          itemStyle:{
            normal:{
              opacity:0.9,//设置透明度为0.8，为0时不绘制
            },
          },
          // 关系边的公用线条样式
          lineStyle: {
            normal: {
              show : true,
              color: 'target',//决定边的颜色是与起点相同还是与终点相同
              curveness: 0//边的曲度，支持从 0 到 1 的值，值越大曲度越大。
            }
          },
          force: {
            edgeLength: [100,200],//线的长度，这个距离也会受 repulsion，支持设置成数组表达边长的范围
            repulsion: 80//节点之间的斥力因子。值越大则斥力越大
          }
        }
      ]
    };

    chart.setOption(option);

	//鼠标点击事件
    chart.on('click', function (params) {
    	//window.open('https://www.baidu.com/s?wd=' + encodeURIComponent(params.name));
        if (params.dataType === 'node') {
            //alert("zhh");
            window.open('showFriend?id=' + arr[params.data.name][0]);
        }
	});
	
    </script>
  </body>
</html>
