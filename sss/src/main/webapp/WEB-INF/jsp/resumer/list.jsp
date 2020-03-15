<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>layui</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" type="text/css" href="/js/layui/css/layui.css">
    <link rel="stylesheet" type="text/css" href="/js/layui/css/public.css">

</head>
<body>
<div class="layuimini-container">
    <div class="layuimini-main">
        <script type="text/html" id="toolbarDemo">
            <div class="layui-btn-container">
                <button class="layui-btn layui-btn-sm data-add-btn" lay-event="add"> 添加 </button>
            </div>
        </script>

        <table class="layui-hide" id="currentTableId" lay-filter="currentTableFilter"></table>

        <script type="text/html" id="currentTableBar">
            <a class="layui-btn layui-btn-xs data-count-edit" lay-event="edit">编辑</a>
            <a class="layui-btn layui-btn-xs layui-btn-danger data-count-delete" lay-event="delete">删除</a>
        </script>

    </div>
</div>
<script src="/js/layui/layui.js" charset="utf-8"></script>
<script>
    layui.use(['form', 'table'], function () {
        var $ = layui.jquery,
            form = layui.form,
            table = layui.table;

        table.render({
            elem: '#currentTableId',
            url: '/resumer/list',
            toolbar: '#toolbarDemo',
            cols: [[
                {field: 'id', align: 'center', title: 'ID', sort: true},
                {field: 'name', align: 'center', title: '姓名'},
                {field: 'address', align: 'center', title: '地址', sort: true},
                {field: 'phone', align: 'center', title: '电话'},
                {title: '操作', minWidth: 50, templet: '#currentTableBar', fixed: "right", align: "center"}
            ]]
        });

        /**
         * toolbar监听事件
         */
        table.on('toolbar(currentTableFilter)', function (obj) {
            if (obj.event === 'add') {  // 监听添加操作
                var index = layer.open({
                    title: '添加用户',
                    type: 2,
                    shade: 0.2,
                    maxmin:true,
                    shadeClose: true,
                    area: ['80%', '80%'],
                    content: '/resumer/add/page',
                });
                $(window).on("resize", function () {
                    layer.full(index);
                });
            }
        });

        table.on('tool(currentTableFilter)', function (obj) {
            var data = obj.data;
            if (obj.event === 'edit') {
                var index = layer.open({
                    title: '编辑用户',
                    type: 2,
                    shade: 0.2,
                    maxmin:true,
                    shadeClose: true,
                    area: ['80%', '80%'],
                    content: '/resumer/edit/page',
                    success: function (layero, index) {    //成功获得加载changefile.html时，预先加载，将值从父窗口传到 子窗口
                        //// console.log(obj.data.editAble);
                        let body = layer.getChildFrame('body', index);
                        //console.log(rowselect[0].filename);
                        body.find("#id").val(data.id);
                        body.find("#name").val(data.name);
                        body.find("#address").val(data.address);
                        body.find("#phone").val(data.phone);
                        layui.form.render();
                    },
                });
                $(window).on("resize", function () {
                    layer.full(index);
                });
                return false;
            } else if (obj.event === 'delete') {
                layer.confirm('真的删除行么', function (index) {
                    $.ajax({
                        //请求方式
                        type : "POST",
                        //请求地址
                        url:"/resumer/delete?id="+obj.data.id,
                        //contentType: "application/json;charset=UTF-8",
                        //数据，json字符串
                        data : obj.data.id,
                        //请求成功
                        success : function(result) {
                            console.log(result);
                        },
                        //请求失败，包含具体的错误信息
                        error : function(e){
                            console.log(e.status);
                            console.log(e.responseText);
                        }
                    });
                    obj.del();
                    layer.close(index);
                    window.location.reload();//刷新父页面
                });
            }
        });

    });
</script>
</body>
</html>