<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

  <head>
    <meta charset="UTF-8">
    <title>ESMS</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
    <link rel="shortcut icon" href="/favicon.ico" type="image/x-icon" />
    <link rel="stylesheet" href="/ssm_esms/static/css/font.css">
    <link rel="stylesheet" href="/ssm_esms/static/css/xadmin.css">
    <script type="text/javascript" src="/ssm_esms/static/js/jquery-3.3.1.js"></script>
    <script type="text/javascript" src="/ssm_esms/static/lib/layui/layui.js"></script>
    <script type="text/javascript" src="/ssm_esms/static/js/xadmin.js"></script>
    <!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
    <!--[if lt IE 9]>
      <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
      <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    <!-- Bootstrap -->
    <link href="/ssm_esms/static/css/bootstrap.css" rel="stylesheet">
    <script type="text/javascript" src="/ssm_esms/static/js/bootstrap.js"></script>


  </head>
  
  <body class="layui-anim layui-anim-up">
    <div class="x-nav">
      <span class="layui-breadcrumb">
        <a >首页</a>
        <a >职称奖金管理</a>
        <a>
          <cite>职称列表</cite></a>
      </span>
      <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right" href="javascript:location.replace(location.href);" title="刷新">
        <i class="layui-icon" style="line-height:30px">ဂ</i></a>
    </div>
    <div class="x-body">
      <div class="layui-row">
        <form class="layui-form layui-col-md12 x-so">
      <!--     <input class="layui-input" placeholder="开始日" name="start" id="start">
          <input class="layui-input" placeholder="截止日" name="end" id="end"> -->
          <input type="text" name="username"  placeholder="请输入用户名" autocomplete="off" class="layui-input">
          <button class="layui-btn"  lay-submit="" lay-filter="sreach"><i class="layui-icon">&#xe615;</i></button>
        </form>
      </div>
      <xblock>
        <button class="layui-btn layui-btn-danger" onclick="delAll()"><i class="layui-icon"></i>批量删除</button>
        <button class="layui-btn" onclick="x_admin_show('添加','toPage.do?url=admin/rank-add.html',600,400)"><i class="layui-icon"></i>添加</button>
        <span class="x-right" style="line-height:40px">共有数据：${pageInfo.total} 条</span>
      </xblock>
      <table class="layui-table">
        <thead>
          <tr>
            <th>
              <div class="layui-unselect header layui-form-checkbox" lay-skin="primary"><i class="layui-icon">&#xe605;</i></div>
            </th>
            <th>#</th>
            <th>职称名称</th>
            <th>补贴</th>
            <!--<th>性别</th>
            <th>电话</th>
            <th>岗位</th>
            <th>部门</th>-->

            <th>操作</th>
          </tr>
        </thead>
        <tbody>

        <c:forEach items="${pageInfo.list}" var="rb">
          <tr>
            <td>
              <div class="layui-unselect layui-form-checkbox" lay-skin="primary" data-id='2'><i class="layui-icon">&#xe605;</i></div>
            </td>
            <td>${rb.rbId}</td>
            <td>${rb.rankName}</td>
            <td>${rb.rbBonus}</td>
            <td class="td-manage">
              <!-- <a onclick="member_stop(this,'10001')" href="javascript:;"  title="启用">
                <i class="layui-icon">&#xe601;</i>
              </a> -->
              <a title="编辑"  onclick="rank_edit(this)" href="javascript:;">
                <i class="layui-icon">&#xe642;</i>
              </a>
              <!-- <a onclick="x_admin_show('修改密码','member-password.html',600,400)" title="修改密码" href="javascript:;">
                <i class="layui-icon">&#xe631;</i>
              </a> -->
              <a title="删除"  onclick="member_del(this,'要删除的id')" href="javascript:;">
                <i class="layui-icon">&#xe640;</i>
              </a>
            </td>
          </tr>
       </c:forEach>
        </tbody>
      </table>
      <!--分页信息-->
      <div class="row">
        <%--分页文字信息--%>
        <div class="col-md-6">
          当前为第${pageInfo.pageNum}页，总共有${pageInfo.pages}页.
        </div>
        <%--	分页条--%>
        <div class="col-md-6">
          <nav aria-label="Page navigation">
            <ul class="pagination">
              <li><a href="${pageContext.request.contextPath}/findAll.do?pn=1">首页</a></li>
              <li>
                <c:if test="${pageInfo.hasPreviousPage}">
                  <a href="${pageContext.request.contextPath}/findAll.do?pn=${pageInfo.pageNum-1}" aria-label="Previous">
                    <span aria-hidden="true">&laquo;</span>
                  </a>
                </c:if>
              </li>
              <c:forEach items="${pageInfo.navigatepageNums}" var="page_num">
                <c:if test="${page_num==pageInfo.pageNum}">
                  <li class="active"><a href="${pageContext.request.contextPath}/findAll.do?pn=${page_num}">${page_num}</a></li>
                </c:if>
                <c:if test="${page_num!=pageInfo.pageNum}">
                  <li><a href="${pageContext.request.contextPath}/findAll.do?pn=${page_num}">${page_num}</a></li>
                </c:if>
              </c:forEach>

              <li>
                <c:if test="${pageInfo.hasNextPage}">
                  <a href="${pageContext.request.contextPath}/findAll.do?pn=${pageInfo.pageNum+1}" aria-label="Next">
                    <span aria-hidden="true">&raquo;</span>
                  </a>
                </c:if>
              </li>
              <li><a href="${pageContext.request.contextPath}/findAll.do?pn=${pageInfo.pages}">末页</a></li>
            </ul>
          </nav>
        </div>

      </div>
      <%--<div class="page">
        <div>
          <a class="prev" href="">&lt;&lt;</a>
          <a class="num" href="">1</a>
          <span class="current">2</span>
          <a class="num" href="">3</a>
          <a class="num" href="">489</a>
          <a class="next" href="">&gt;&gt;</a>
        </div>
      </div>--%>

    </div>
    ${test}
    <script>

      layui.use('laydate', function(){
        var laydate = layui.laydate;
        
        //执行一个laydate实例
        laydate.render({
          elem: '#start' //指定元素
        });

        //执行一个laydate实例
        laydate.render({
          elem: '#end' //指定元素
        });
      });

       /*用户-停用*/
      function member_stop(obj,id){
          layer.confirm('确认要停用吗？',function(index){

              if($(obj).attr('title')=='启用'){

                //发异步把用户状态进行更改
                $(obj).attr('title','停用')
                $(obj).find('i').html('&#xe62f;');

                $(obj).parents("tr").find(".td-status").find('span').addClass('layui-btn-disabled').html('已停用');
                layer.msg('已停用!',{icon: 5,time:1000});

              }else{
                $(obj).attr('title','启用')
                $(obj).find('i').html('&#xe601;');

                $(obj).parents("tr").find(".td-status").find('span').removeClass('layui-btn-disabled').html('已启用');
                layer.msg('已启用!',{icon: 5,time:1000});
              }
              
          });
      }

      /*用户-删除*/
      function member_del(obj,id){
          layer.confirm('确认要删除吗？',function(index){
              //发异步删除数据
              $(obj).parents("tr").remove();
              alert(obj.parentNode.parentNode.cells[1].innerText);
              $.ajax({
                  type: "post",
                  url: "delete.do",
                  data: {
                      'id':obj.parentNode.parentNode.cells[1].innerText
                  },
                  /*contentType: "application/json; charset=utf-8",*/
                  //dataType: "json",
                  success: function (data) {
                      alert(data);
                      layer.msg('已删除!',{icon:1,time:1000});
                  },
                  error: function (err) {
                      alert(err);
                  }
              });

          });
      }
      function rank_edit(obj) {
          var id=obj.parentNode.parentNode.cells[1].innerText;
          var rank=obj.parentNode.parentNode.cells[2].innerText;
          var bonus=obj.parentNode.parentNode.cells[3].innerText;
          /*$.ajax({
              type: "post",
              url: "copytxt.do",
              data: {
                  'id':id,
                  'rank':rank,
                  'bonus':bonus
              },

          });*/
          x_admin_show('编辑','toPage.do?url=admin/rank-edit.html',600,400);
      }


      function delAll (argument) {

        var data = tableCheck.getData();
  
        layer.confirm('确认要删除吗？'+data,function(index){
            //捉到所有被选中的，发异步进行删除
            layer.msg('删除成功', {icon: 1});
            $(".layui-form-checked").not('.header').parents('tr').remove();
        });
      }
    </script>

  </body>

</html>