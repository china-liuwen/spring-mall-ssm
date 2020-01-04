<%--
  Created by IntelliJ IDEA.
  User: LW
  Date: 2019/12/11
  Time: 10:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
    <meta http-equiv="Cache-Control" content="no-siteapp" />

    <title>商品类型</title>

    <link rel="stylesheet" type="text/css" href="/static/h-ui/css/H-ui.min.css" />
    <link rel="stylesheet" type="text/css" href="/static/h-ui.admin/css/H-ui.admin.css" />
    <link rel="stylesheet" type="text/css" href="/static/lib/Hui-iconfont/1.0.8/iconfont.css" />
    <link rel="stylesheet" type="text/css" href="/static/h-ui.admin/skin/default/skin.css" id="skin" />
    <link rel="stylesheet" type="text/css" href="/static/h-ui.admin/css/style.css" />
    <script src="/static/js/jquery-3.3.1.min.js"></script>

<%--    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">--%>


<%--    <script src="/static/js/jquery-3.3.1.min.js"></script>--%>
<%--    <script src="/static/bootstrap/js/bootstrap.js"></script>--%>
<%--    <link href="/static/bootstrap/css/bootstrap.css" type="text/css" rel="stylesheet"/>--%>
<%--    <link href="/static/bootstrap/css/pintuer.css" type="text/css" rel="stylesheet"/>--%>
<%--    <link href="/static/bootstrap/css/admin.css" type="text/css" rel="stylesheet"/>--%>


</head>
<body>
<!--_header 作为公共模版分离出去-->
<header class="navbar-wrapper">
    <div class="navbar navbar-fixed-top">
        <div class="container-fluid cl"> <a class="logo navbar-logo f-l mr-10 hidden-xs" href="/be/index">后台管理页面</a> <a class="logo navbar-logo-m f-l mr-10 visible-xs" href="/aboutHui.shtml">H-ui</a>
            <span class="logo navbar-slogan f-l mr-10 hidden-xs">*</span>
            <a aria-hidden="false" class="nav-toggle Hui-iconfont visible-xs" href="javascript:;">&#xe667;</a>
            <nav class="nav navbar-nav">
                <ul class="cl">
                    <li class="dropDown dropDown_hover"><a href="javascript:;" class="dropDown_A"><i class="Hui-iconfont">&#xe600;</i> 新增 <i class="Hui-iconfont">&#xe6d5;</i></a>
                        <ul class="dropDown-menu menu radius box-shadow">
                            <li><a href="#" onclick="article_add('添加资讯','article-add.html')"><i class="Hui-iconfont">&#xe616;</i>动画</a></li>
                            <li><a href="NewFile1.html" onclick="picture_add('添加资讯','picture-add.html')"><i class="Hui-iconfont">&#xe613;</i> 图片</a></li>
                            <li><a href="" onclick="product_add('添加资讯','product-add.html')"><i class="Hui-iconfont">&#xe620;</i> 产品</a></li>
                            <li><a href="/reg" onclick="member_add('添加用户','member-add.html','','510')"><i class="Hui-iconfont">&#xe60d;</i>新增用户</a></li>
                        </ul>
                    </li>
                </ul>
            </nav>
            <nav id="Hui-userbar" class="nav navbar-nav navbar-userbar hidden-xs">
                <ul class="cl">
                    <li>管理员</li>
                    <li class="dropDown dropDown_hover"> <a href="#" class="dropDown_A">admin <i class="Hui-iconfont">&#xe6d5;</i></a>
                        <ul class="dropDown-menu menu radius box-shadow">
                            <li><a href="/admin/information/list" onClick="myselfinfo()">个人信息</a></li>
                            <li><a href="/be/login">退出</a></li>
                        </ul>
                    </li>
                    <li id="Hui-msg"> <a href="#" title="消息"><span class="badge badge-danger">1</span><i class="Hui-iconfont" style="font-size:18px">&#xe68a;</i></a> </li>
                    <li id="Hui-skin" class="dropDown right dropDown_hover"> <a href="javascript:;" class="dropDown_A" title="换肤"><i class="Hui-iconfont" style="font-size:18px">&#xe62a;</i></a>
                        <ul class="dropDown-menu menu radius box-shadow">
                            <li><a href="javascript:;" data-val="default" title="默认（黑色）">默认（黑色）</a></li>
                            <li><a href="javascript:;" data-val="blue" title="蓝色">蓝色</a></li>
                            <li><a href="javascript:;" data-val="green" title="绿色">绿色</a></li>
                            <li><a href="javascript:;" data-val="red" title="红色">红色</a></li>
                            <li><a href="javascript:;" data-val="yellow" title="黄色">黄色</a></li>
                            <li><a href="javascript:;" data-val="orange" title="橙色">橙色</a></li>
                        </ul>
                    </li>
                </ul>
            </nav>
        </div>
    </div>
</header>
<!--/_header 作为公共模版分离出去-->

<!--_menu 作为公共模版分离出去-->
<aside class="Hui-aside">
    <div class="menu_dropdown bk_2">
        <dl id="menu-article">
            <dt><i class="Hui-iconfont">&#xe616;</i> 资讯管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
            <dd>
                <ul>
                    <li><a href="quiry.html" title="资讯管理">资讯管理</a></li>
                </ul>
            </dd>
        </dl>
        <dl id="menu-picture">
            <dt><i class="Hui-iconfont">&#xe613;</i> 商品管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
            <dd>
                <ul>
                    <li><a href="/admin/administration/list" title=" 商品管理"> 商品管理</a></li>

                </ul>

            </dd>
        </dl>
        <dl id="menu-product">
            <dt><i class="Hui-iconfont">&#xe620;</i> 产品管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
            <dd>
                <ul>

                    <li><a href="/type/list2" title="商品类型">商品类型</a></li>
                </ul>
            </dd>
        </dl>

        <dl id="menu-member">
            <dt><i class="Hui-iconfont">&#xe60d;</i> 会员管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
            <dd>
                <ul>
                    <li><a href="/employee/list2" title="员工列表">员工列表</a></li>
                </ul>
            </dd>
        </dl>
        <dl id="menu-admin">
            <dt><i class="Hui-iconfont">&#xe62d;</i> 管理员管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
            <dd>
                <ul>
                    <li><a href="admin-role.html" title="角色管理">角色管理</a></li>
                    <li><a href="admin.jsp" title="管理员列表">管理员列表</a></li>
                </ul>
            </dd>
        </dl>
        <dl id="menu-tongji">
            <dt><i class="Hui-iconfont">&#xe61a;</i> 系统统计<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
            <dd>
                <ul>
                    <li><a href="charts-4.html" title="柱状图">柱状图</a></li>
                </ul>
            </dd>
        </dl>
        <dl id="menu-system">
            <dt><i class="Hui-iconfont">&#xe62e;</i> 系统管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
            <dd>
                <ul>
                    <li><a href="system-base.html" title="系统设置">系统设置</a></li>
                    <li><a href="system-category.html" title="栏目管理">栏目管理</a></li>

                    <li><a href="system-log.html" title="系统日志">系统日志</a></li>
                </ul>
            </dd>
        </dl>
    </div>
</aside>
<div class="dislpayArrow hidden-xs"><a class="pngfix" href="javascript:void(0);" onClick="displaynavbar(this)"></a></div>
<!--/_menu 作为公共模版分离出去-->

<div class="Hui-article-box">
    <nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 用户中心 <span class="c-gray en">&gt;</span> 商品类型<a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
    <div class="Hui-article">
        <article class="cl pd-20">
            <div class="container">
                <div class="row clearfix">
                    <div class="col-md-4 column" >
                        <h1>商品类型</h1>
                    </div>
                </div>
                <div class="col-md-10 column" id="content">

                    <a href='#' class='insert btn btn-info' onclick="add(this)" >新增</a>
                    <table id="table" class="table table-bordered table-hover">
                        <thead>
                            <tr>
                                <th>编号</th>
                                <th>类型</th>
                                <th>操作</th>
                            </tr>
                        </thead>
                        <c:forEach items="${pagety.list}" var="ty">
                            <tr>
                                <td>${ty.tid}</td>
                                <td>${ty.tname}</td>
<%--                                <td>--%>
<%--                                    <a href='#' class='delete btn btn-danger'>删除</a>--%>
<%--                                    <a href='#' class='edit btn btn-info'>编辑</a>--%>
<%--                                </td>--%>
                                <td>
                                    <a href='#' class='delete btn btn-danger' onclick="confirmDel(${ty.tid})">删除</a>
                                    <a href='#' class='edit btn btn-info' onclick="editRole(this)" >编辑</a>
                                </td>
                            </tr>

                        </c:forEach>

                    </table>
                    <ul class="pagination">
                        <li><a href="/type/list2?pageNum=1"> 首页</a></li>
                        <li><a href="/type/list2?pageNum=${pagety.prePage}"> 上一页</a></li>
                        <c:forEach items="${pagety.navigatepageNums}" var="p">
                            <li><a href="/type/list2?pageNum=${p}"> ${p}</a></li>
                        </c:forEach>
                        <li><a href="/type/list2?pageNum=${pagety.nextPage}"> 下一页</a></li>
                        <li><a href="/type/list2?pageNum=${pagety.pages}"> 尾页</a></li>
                    </ul>
                </div>
            </div>

        </article>
    </div>
</div>

<!-- 模态框(Modal)-->
<div class="modal fade" id="update" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content" id="content2">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;
                    <tton>
                        <h4 class="modal-title" id="myModalLabel">
                            修改信息
                        </h4>
                    </tton>
                </button>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" role="form">

                    <div class="form-group">
                        <label for="tid" class="col-sm-2 control-label">编号</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="tid" name="tid" />
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="tname" class="col-sm-2 control-label">类型</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="tname" name="tname" />
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-10">
                            <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                            <button type="button" id="save" class="btn btn-default">保存</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

<script>
    function confirmDel(param){
        alert("par"+param);
        if(window.confirm("您确定要删除吗？")){
            document.location.href="/type/delete?tid="+param
        }
    }

    /*修改时获取当前的id*/
    function editRole(obj) {
        /*得到当前行*/
        var id = $(obj.parentNode).parent().prevAll().length+1;
        //var lie = $(obj.parentNode).prevAll().length;
        //alert("第"+id+"行"+"	"+"第"+lie+"列");

        //获取表格中的一行数据
        var tid=document.getElementById("table").rows[id].cells[0].innerText;
        var tname = document.getElementById("table").rows[id].cells[1].innerText;
        //向模态框中传值
        $('#tid').val(tid);
        //禁止操作
        $("#tid").prop("disabled", "disabled");
        $('#tname').val(tname);
        //模态框显示
        $('#update').modal('show');
    }
    $("#save").click(function () {
        //得到修改的值
        var tname = $('#tname').val();
        var tid=$("#tid").val();
        //模态框隐藏
        $("#update").modal('hide');
        //ajax做法
        $.ajax({
            type: "post",
            url: "/type/update",
            data:{
                tid:tid,
                tname:tname
            },
            success:function (data) {
                location.href="/type/list2";
            }
        });
    })

    // $("#save").click(function () {
    //
    //     /*post做法*/
    //     /* var obj = {tid:$("#tid").val(),typeName:$("#typeName").val()};
    //      $.post("/ProductTypeLocation/update",obj,function () {
    //          //location.href="/ProductTypeLocation/list";
    //      });*/
    // });

    //添加操作
    function add() {
        //修改保存按钮的id值，因为添加和修改共用一个模态框
        var s=document.getElementById("save").value="insert"
        $("#tid").val("");
        $("#tid").prop("disabled", "disabled");
        $("#tname").val("");;
        $("#update").modal('show');

    }
    //添加操作
    $("#save").click(function () {
        //得到保存按钮修改的值
        var val=document.getElementById("save").value;
        if(val!="insert"){
            return;
        }
        //得到添加的值
        var tname = $('#tname').val();

        //模态框隐藏
        $("#update").modal('hide');
        //ajax做法
        $.ajax({
            type: "post",
            url: "/type/insert",
            data:{
                tname:tname
            },
            success:function (data) {
                location.href="/type/list2";
            }
        });
    });
</script>



<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="/static/lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="/static/lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="/static/h-ui/js/H-ui.js"></script>
<script type="text/javascript" src="/static/h-ui.admin/js/H-ui.admin.page.js"></script>
<!--/_footer /作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="/static/lib/My97DatePicker/4.8/WdatePicker.js"></script>
<script type="text/javascript" src="/static/lib/datatables/1.10.0/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="/static/lib/laypage/1.2/laypage.js"></script>
<script type="text/javascript">

</script>
<!--/请在上方写此页面业务相关的脚本-->


<%--<script type="text/javascript" src="/static/js/list.js"></script>--%>
</body>
</html>
